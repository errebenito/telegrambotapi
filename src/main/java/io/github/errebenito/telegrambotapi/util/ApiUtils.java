package io.github.errebenito.telegrambotapi.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import io.github.errebenito.telegrambotapi.exceptions.CommandFailedException;
import io.github.errebenito.telegrambotapi.objects.InputFile;
import io.github.errebenito.telegrambotapi.objects.Message;
import io.github.errebenito.telegrambotapi.objects.SelectiveObject;
import io.github.errebenito.telegrambotapi.objects.Update;

/**
 * This class contains static utility methods that interact with requests 
 * and responses to and from the API.
 * @author Raúl Benito
 *
 */
public final class ApiUtils {
		
	/**
	 * Logger for the ApiUtils class.
	 */
	private static final Logger LOG = LogManager.getLogger(ApiUtils.class);
	
	/**
	 * 
	 * Class constructor.
	 */
	private ApiUtils() {
		
	}
	
	/**
	 * Method to parse an update from its corresponding JSON.
	 * @param object The JsonObject
	 * @return an Update
	 */
	public static Update parseUpdate(final JsonObject object) {
		return new Update(object);
	}
	
		
	
	/**
	 * Retrieves the entity that results from executing the HTTP POST request.
	 * @param httpPost The HTTP POST request.
	 * @param values The contents of the request.
	 * @return An HTTPBufferedEntity.
	 * @throws CommandFailedException If the retrieval fails for any reason.
	 */
	public static BufferedHttpEntity retrieveEntityFromHttpPost(
			final HttpPost httpPost, final List<BasicNameValuePair> values) 
					throws CommandFailedException {
		BufferedHttpEntity entity = null;
		final HttpClient httpClient = HttpClientBuilder.create()
			.setSSLHostnameVerifier(new NoopHostnameVerifier()).build();
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(values, 
			Constants.ENCODING));
			entity = new BufferedHttpEntity(httpClient.execute(httpPost)
				.getEntity());
		} catch (UnsupportedEncodingException e) {
			if (LOG.isErrorEnabled()) {
				LOG.error(Constants.INVALID_ENCODING + Constants.ENCODING);
				throw new CommandFailedException(e);
			}
		} catch (JsonSyntaxException e) {
			if (LOG.isErrorEnabled()) {
				LOG.error(Constants.BAD_JSON_ERROR);
				throw new CommandFailedException(e);
			}
		} catch (ParseException e) {
			if (LOG.isErrorEnabled()) {
				LOG.error(Constants.JSON_PARSE_ERROR);
				throw new CommandFailedException(e);
			}
		} catch (IOException e) {
			if (LOG.isErrorEnabled()) {
				LOG.error(Constants.IO_ERROR);
				throw new CommandFailedException(e);
			}
		}

		return entity;
	}
	
	/**
	 * Retrieves the entity that results from executing the HTTP POST request.
	 * @param httpPost The HTTP POST request.
	 * @return An HTTPBufferedEntity.
	 * @throws CommandFailedException If the retrieval fails for any reason.
	 */
	public static BufferedHttpEntity retrieveEntityFromHttpPost(
			final HttpPost httpPost) 
					throws CommandFailedException {
		BufferedHttpEntity entity = null;
		final HttpClient httpClient = HttpClientBuilder.create()
			.setSSLHostnameVerifier(new NoopHostnameVerifier()).build();
		try {
			entity = new BufferedHttpEntity(httpClient.execute(httpPost)
				.getEntity());
		} catch (UnsupportedEncodingException e) {
			if (LOG.isErrorEnabled()) {
				LOG.error(Constants.INVALID_ENCODING + Constants.ENCODING);
				throw new CommandFailedException(e);
			}
		} catch (JsonSyntaxException e) {
			if (LOG.isErrorEnabled()) {
				LOG.error(Constants.BAD_JSON_ERROR);
				throw new CommandFailedException(e);
			}
		} catch (ParseException e) {
			if (LOG.isErrorEnabled()) {
				LOG.error(Constants.JSON_PARSE_ERROR);
				throw new CommandFailedException(e);
			}
		} catch (IOException e) {
			if (LOG.isErrorEnabled()) {
				LOG.error(Constants.POST_ERROR);
				throw new CommandFailedException(e);
			}
		}

		return entity;
	}
	
	/**
	 *	Executes an API method.
	 * @param httpPost the HTTP POST request.
	 * @param values The contents of the request.
	 * @return The sent message if the operation was successful.
	 * @throws CommandFailedException If the execution fails for any reason.
	 */
	public static Message executeApiMethod(final HttpPost httpPost, 
			final List<BasicNameValuePair> values) 
					throws CommandFailedException {
			BufferedHttpEntity entity;
			final JsonParser parser = new JsonParser();
			if (values == null) {
				entity = retrieveEntityFromHttpPost(httpPost);
			} else {
				entity = retrieveEntityFromHttpPost(httpPost, values);
			}
			final JsonObject object = parser.parse(entity.toString())
					.getAsJsonObject();
			if (!object.has(Constants.OK)) {
				throw new CommandFailedException(Constants.INVALID_RESPONSE);
			}
			return new Message(object);
	}
	
	/**
	 * Retrieves an update from a JSON array.
	 * @param jsonArray the Array
	 * @param index the position of the array
	 * @return An Update
	 */
	public static Update retrieveUpdate(final JsonArray jsonArray, 
			final int index) {
		return new Update(jsonArray.get(index).getAsJsonObject());
	}
	
	/**
	 * Returns an HttpEntity containing the file to be sent.
	 * @param fileType 
	 * 			  The file type.
	 * @param chatId
	 *            Unique identifier for the message recipient.
	 * @param file
	 *            File to send.
	 * @param originalId
	 *            If the message is a reply, ID of the original message.
	 * @param markup
	 *            Additional interface options.
	 * @return An HttpEntity
	 */
	public static HttpEntity prepareEntity(final String fileType, 
			final Integer chatId, final InputFile file, 
			final Integer originalId, final SelectiveObject markup) {
		final MultipartEntityBuilder builder = 
				MultipartEntityBuilder.create();
		builder.addTextBody(Constants.CHAT_ID, chatId.toString());
		builder.addBinaryBody(fileType, file.getFile(),
				ContentType.APPLICATION_OCTET_STREAM, 
				file.getFile().getName()); 
		if (originalId != null) {
			builder.addTextBody(Constants.REPLY_TO_ID, 
					originalId.toString());
		}
		if (markup != null) {
			builder.addTextBody(Constants.REPLY_MARKUP, 
					markup.toString());
		}
		return builder.build();
	}
	
	/**
	 * Returns a list containing the values that will constitute the Entity
	 * of an HttpPost object.
	 * @param chatId
	 *            Unique identifier for the message recipient.
	 * @param file
	 *            File to send.
	 * @param originalId
	 *            If the message is a reply, ID of the original message.
	 * @param markup
	 *            Additional interface options.
	 * @param caption
	 * 			  The caption, if the file is a photo.
	 * @return A list of key-value pairs.
	 */
	public static List<BasicNameValuePair> prepareValues(
			final Integer chatId, final String file, 
			final Integer originalId, final SelectiveObject markup,
			final String caption) {
		final List<BasicNameValuePair> values = 
				new ArrayList<BasicNameValuePair>();
		values.add(new BasicNameValuePair(Constants.CHAT_ID, 
				chatId.toString()));
		values.add(new BasicNameValuePair(Constants.DOCUMENT, file));
		if (originalId != null) {
			values.add(new BasicNameValuePair(Constants.REPLY_TO_ID, 
					originalId.toString()));
		}
		if (markup != null) {
			values.add(new BasicNameValuePair(Constants.REPLY_MARKUP, 
					markup.toString()));
		}
		if (caption != null) {
			values.add(new BasicNameValuePair(Constants.CAPTION, caption));
		}
		return values;
	}
}
