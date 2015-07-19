package io.github.errebenito.telegrambotapi.impl;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import io.github.errebenito.telegrambotapi.enums.ActionType;
import io.github.errebenito.telegrambotapi.exceptions.CommandFailedException;
import io.github.errebenito.telegrambotapi.objects.InputFile;
import io.github.errebenito.telegrambotapi.objects.Message;
import io.github.errebenito.telegrambotapi.objects.SelectiveObject;
import io.github.errebenito.telegrambotapi.objects.Update;
import io.github.errebenito.telegrambotapi.objects.User;
import io.github.errebenito.telegrambotapi.objects.UserProfilePhotos;
import io.github.errebenito.telegrambotapi.util.ApiUtils;
import io.github.errebenito.telegrambotapi.util.Constants;
import io.github.errebenito.telegrambotapi.util.FieldUtils;
import io.github.errebenito.telegrambotapi.util.dto.MethodUrl;

/**
 * This class represents a bot.
 * 
 * @author Raúl Benito
 *
 */
public abstract class AbstractBot extends HttpServlet 
implements TelegramBotAPI {

	/**
	 * Generated ID.
	 */
	private static final long serialVersionUID = 9172233920271339366L;
	
	/**
	 * Logger for the AbstractBot class.
	 */
	private static final Logger LOG = LogManager.getLogger(
			AbstractBot.class);

	/**
	 * The bot's token.
	 */
	private final transient String botToken;
	
	/**
	 * The HTTP client.
	 */
	private transient CloseableHttpClient httpClient;

	
	/**
	 * 
	 * Class constructor.
	 * 
	 * @param token
	 *            The bot's token.
	 */
	public AbstractBot(final String token) {
		super();
		this.botToken = token;
		this.httpClient = HttpClientBuilder.create()
				.setSSLHostnameVerifier(new NoopHostnameVerifier())
				.build();
	}

	/**
	 * A simple method for testing your bot's auth token. Requires no
	 * parameters.
	 * 
	 * @return bot information in the form of a User object.
	 * @throws CommandFailedException If the command execution fails.
	 */
	public final User getMe() throws CommandFailedException {
		final HttpPost httpPost = new HttpPost(new MethodUrl(botToken, 
				Constants.GET_ME).toString());
		httpPost.addHeader(Constants.CONTENT_TYPE, Constants.URL_ENCODED);
		httpPost.addHeader(Constants.CHARSET, Constants.ENCODING);
		BufferedHttpEntity entity;
		String responseContent;
		final JsonParser parser = new JsonParser();
		User user = new User();
		try {
			entity = new BufferedHttpEntity(httpClient.execute(httpPost)
					.getEntity());
			responseContent = EntityUtils.toString(entity, 
					Constants.ENCODING);
			final JsonObject object = parser.parse(responseContent)
					.getAsJsonObject();
			if (!object.has(Constants.OK)) {
				throw new CommandFailedException(Constants
						.INVALID_RESPONSE);
			}
			user = new User(object);
		} catch (IOException e) {
			if (LOG.isErrorEnabled()) {
				LOG.error(Constants.POST_ERROR);
				throw new CommandFailedException(e);
			}
		} catch (ParseException e) {
			if (LOG.isErrorEnabled()) {
				LOG.error(Constants.JSON_PARSE_ERROR);
				throw new CommandFailedException(e);
			}
		}
		return user;
	}
	
	/**
	 * Sends text messages.
	 * 
	 * @param chatId
	 *            Unique identifier for the message recipient.
	 * @param text
	 *            Text of the message to be sent.
	 * @param disablePreview
	 *            Disables link previews for links in this message.
	 * @param reply
	 *            If the message is a reply, ID of the original message.
	 * @param markup
	 *            Additional interface options.
	 * @return On success, the sent Message is returned.
	 * @throws CommandFailedException If the command execution fails.
	 */
	public final Message sendMessage(final Integer chatId, 
			final String text, final Boolean disablePreview, 
			final Boolean reply, final SelectiveObject markup) 
					throws CommandFailedException {
		final HttpPost httpPost = new HttpPost(new MethodUrl(botToken,
				Constants.SEND_MESSAGE).toString());
		httpPost.addHeader(Constants.CONTENT_TYPE, Constants.URL_ENCODED);
		httpPost.addHeader(Constants.CHARSET, Constants.ENCODING);
		final List<BasicNameValuePair> values = 
				new ArrayList<BasicNameValuePair>();
		values.add(new BasicNameValuePair(Constants.CHAT_ID, 
				chatId.toString()));
		values.add(new BasicNameValuePair(Constants.TEXT, text));
		values.addAll(FieldUtils.addOptionalFields(disablePreview, reply,
				markup));
		return ApiUtils.executeApiMethod(httpPost, values);
	}

	/**
	 * Forwards a message.
	 * 
	 * @param chatId
	 *            Unique identifier for the message recipient
	 * @param fromId
	 *            Unique identifier for the chat where the original message was
	 *            sent
	 * @param messageId
	 *            Unique message identifier
	 * @return On success, the sent Message is returned.
	 * @throws CommandFailedException If the command execution fails.
	 */
	public final Message forwardMessage(final Integer chatId, 
			final Integer fromId, final Integer messageId) 
					throws CommandFailedException {
		final HttpPost httpPost = new HttpPost(new MethodUrl(botToken,
				Constants.FORWARD_MESSAGE).toString());
		httpPost.addHeader(Constants.CONTENT_TYPE, Constants.URL_ENCODED);
		httpPost.addHeader(Constants.CHARSET, Constants.ENCODING);
		final List<BasicNameValuePair> values = 
				new ArrayList<BasicNameValuePair>();
		values.add(new BasicNameValuePair(Constants.CHAT_ID, 
				chatId.toString()));
		values.add(new BasicNameValuePair(Constants.FROM_CHAT_ID, 
				fromId.toString()));
		values.add(new BasicNameValuePair(Constants.MESSAGE_ID, 
				messageId.toString()));
		return ApiUtils.executeApiMethod(httpPost, values);
	}

	/**
	 * Sends a photo.
	 * 
	 * @param chatId
	 *            Unique identifier for the message recipient
	 * @param photo
	 *            Photo to send. Either a string id, or InputFile.
	 * @param caption
	 *            Photo caption.
	 * @param originalId
	 *            If the message is a reply, ID of the original message
	 * @param markup
	 *            Additional interface options.
	 * @return On success, the sent Message is returned.
	 * @throws CommandFailedException If the command execution fails.
	 */
	public final Message sendPhoto(final Integer chatId, final Object photo, 
			final String caption, final Integer originalId, 
			final SelectiveObject markup) throws CommandFailedException {
		final HttpPost httpPost = new HttpPost(new MethodUrl(botToken, 
				Constants.SEND_PHOTO).toString());
		httpPost.addHeader(Constants.CONTENT_TYPE, Constants.URL_ENCODED);
		httpPost.addHeader(Constants.CHARSET, Constants.ENCODING);
		List<BasicNameValuePair> values = null;
		if (photo instanceof InputFile) {
			final HttpEntity multipart = ApiUtils.prepareEntity(
					Constants.PHOTO, chatId, (InputFile) photo, 
					originalId, markup);
            httpPost.setEntity(multipart);
		} else if (photo instanceof String) {
			values = ApiUtils.prepareValues(chatId, (String) photo, 
					originalId, markup, caption);
		}
		return ApiUtils.executeApiMethod(httpPost, values);
	}

	/**
	 * Sends an audio file (ogg encoded with OPUS).
	 * 
	 * @param chatId
	 *            Unique identifier for the message recipient.
	 * @param audio
	 *            Audio to send. Either a string id, or InputFile.
	 * @param originalId
	 *            If the message is a reply, ID of the original message.
	 * @param markup
	 *            Additional interface options.
	 * @return On success, the sent Message is returned.
	 * @throws CommandFailedException If the command execution fails.
	 */
	public final Message sendAudio(final Integer chatId, final Object audio, 
			final Integer originalId, final SelectiveObject markup) 
					throws CommandFailedException {
		final HttpPost httpPost = new HttpPost(new MethodUrl(botToken, 
				Constants.SEND_AUDIO).toString());
		httpPost.addHeader(Constants.CONTENT_TYPE, Constants.URL_ENCODED);
		httpPost.addHeader(Constants.CHARSET, Constants.ENCODING);
		List<BasicNameValuePair> values = null;
		if (audio instanceof InputFile) {
			final HttpEntity multipart = ApiUtils
					.prepareEntity(Constants.AUDIO, chatId, 
							(InputFile) audio, originalId, markup);
            httpPost.setEntity(multipart);
		} else if (audio instanceof String) {
			values = ApiUtils.prepareValues(chatId, (String) audio, 
					originalId, markup, null);
		}
		return ApiUtils.executeApiMethod(httpPost, values);
	}
	
	/**
	 * Sends a general file.
	 * 
	 * @param chatId
	 *            Unique identifier for the message recipient.
	 * @param document
	 *            File to send. Either a string id, or InputFile.
	 * @param originalId
	 *            If the message is a reply, ID of the original message.
	 * @param markup
	 *            Additional interface options.
	 * @return On success, the sent Message is returned.
	 * @throws CommandFailedException If the command execution fails.
	 */
	public final Message sendDocument(final Integer chatId, 
			final Object document, final Integer originalId, 
			final SelectiveObject markup) throws CommandFailedException {
		final HttpPost httpPost = new HttpPost(new MethodUrl(botToken, 
				Constants.SEND_DOCUMENT).toString());
		httpPost.addHeader(Constants.CONTENT_TYPE, Constants.URL_ENCODED);
		httpPost.addHeader(Constants.CHARSET, Constants.ENCODING);
		List<BasicNameValuePair> values = null;
		if (document instanceof InputFile) {
			final HttpEntity multipart = ApiUtils
					.prepareEntity(Constants.DOCUMENT, chatId, 
							(InputFile) document, originalId, markup);
            httpPost.setEntity(multipart);
		} else if (document instanceof String) {
			values = ApiUtils.prepareValues(chatId, (String) document, 
					originalId, markup, null);
		}
		return ApiUtils.executeApiMethod(httpPost, values);
	}	

	/**
	 * Sends a sticker.
	 * 
	 * @param chatId
	 *            Unique identifier for the message recipient.
	 * @param sticker
	 *            Sticker to send. Either a string id, or InputFile.
	 * @param originalId
	 *            If the message is a reply, ID of the original message.
	 * @param markup
	 *            Additional interface options.
	 * @return On success, the sent Message is returned.
	 * @throws CommandFailedException If the command execution fails.
	 */
	public final Message sendSticker(final Integer chatId, 
			final Object sticker, final Integer originalId, 
			final SelectiveObject markup) 
					throws CommandFailedException {
		final HttpPost httpPost = new HttpPost(new MethodUrl(botToken, 
				Constants.SEND_STICKER).toString());
		httpPost.addHeader(Constants.CONTENT_TYPE, Constants.URL_ENCODED);
		httpPost.addHeader(Constants.CHARSET, Constants.ENCODING);
		List<BasicNameValuePair> values = null;
		if (sticker instanceof InputFile) {
			final HttpEntity multipart = ApiUtils
					.prepareEntity(Constants.STICKER, chatId, 
							(InputFile) sticker, originalId, markup);
            httpPost.setEntity(multipart);
		} else if (sticker instanceof String) {
			values = ApiUtils.prepareValues(chatId, (String) sticker, 
					originalId, markup, null);
		}
		return ApiUtils.executeApiMethod(httpPost, values);
	}

	/**
	 * Sends a video file (mp4).
	 * 
	 * @param chatId
	 *            Unique identifier for the message recipient.
	 * @param video
	 *            Video to send. Either a string id, or InputFile.
	 * @param originalId
	 *            If the message is a reply, ID of the original message.
	 * @param markup
	 *            Additional interface options.
	 * @return On success, the sent Message is returned.
	 * @throws CommandFailedException If the command execution fails.
	 */
	public final Message sendVideo(final Integer chatId, final Object video, 
			final Integer originalId, final SelectiveObject markup) 
					throws CommandFailedException {
		final HttpPost httpPost = new HttpPost(new MethodUrl(botToken, 
				Constants.SEND_VIDEO).toString());
		httpPost.addHeader(Constants.CONTENT_TYPE, Constants.URL_ENCODED);
		httpPost.addHeader(Constants.CHARSET, Constants.ENCODING);
		List<BasicNameValuePair> values = null;
		if (video instanceof InputFile) {
			final HttpEntity multipart = ApiUtils
					.prepareEntity(Constants.VIDEO, chatId, 
							(InputFile) video, originalId, markup);
            httpPost.setEntity(multipart);
		} else if (video instanceof String) {
			values = ApiUtils.prepareValues(chatId, (String) video, 
					originalId, markup, null);
		}
		return ApiUtils.executeApiMethod(httpPost, values);
	}

	/**
	 * Sends a location.
	 * 
	 * @param chatId
	 *            Unique identifier for the message recipient.
	 * @param latitude
	 *            Latitude of location
	 * @param longitude
	 *            Longitude of location
	 * @param originalId
	 *            If the message is a reply, ID of the original message.
	 * @param markup
	 *            Additional interface options.
	 * @return On success, the sent Message is returned.
	 * @throws CommandFailedException If the command execution fails.
	 */
	public final Message sendLocation(final Integer chatId, 
			final Float latitude, final Float longitude, 
			final Integer originalId, final SelectiveObject markup) 
					throws CommandFailedException {
		final HttpPost httpPost = new HttpPost(new MethodUrl(botToken, 
				Constants.SEND_LOCATION).toString());
		httpPost.addHeader(Constants.CONTENT_TYPE, Constants.URL_ENCODED);
		httpPost.addHeader(Constants.CHARSET, Constants.ENCODING);
		final List<BasicNameValuePair> values = 
				new ArrayList<BasicNameValuePair>();
		values.add(new BasicNameValuePair(Constants.CHAT_ID, 
				chatId.toString()));
		values.add(new BasicNameValuePair(Constants.LATITUDE, 
				latitude.toString()));
		values.add(new BasicNameValuePair(Constants.LONGITUDE, 
				longitude.toString()));
		values.addAll(FieldUtils.addOptionalFields(originalId, markup));
		return ApiUtils.executeApiMethod(httpPost, values);
	}

	/**
	 * Tells the user that something is happening on the bot's side.
	 * 
	 * @param chatId
	 *            Unique identifier for the message recipient.
	 * @param action
	 *            Type of action to broadcast.
	 * @return A custom message to display according to the action.
	 * @throws CommandFailedException If the command execution fails.
	 */
	public final Message sendChatAction(final Integer chatId, 
			final ActionType action) throws CommandFailedException {
		final HttpPost httpPost = new HttpPost(new MethodUrl(botToken, 
				Constants.SEND_CHAT_ACTION).toString());
		httpPost.addHeader(Constants.CONTENT_TYPE, Constants.URL_ENCODED);
		httpPost.addHeader(Constants.CHARSET, Constants.ENCODING);
		final List<BasicNameValuePair> values = 
				new ArrayList<BasicNameValuePair>();
		values.add(new BasicNameValuePair(Constants.CHAT_ID, 
				chatId.toString()));
		values.add(new BasicNameValuePair(Constants.ACTION, action
				.getDescription()));
		return ApiUtils.executeApiMethod(httpPost, values);
	}

	/**
	 * Returns a list of profile pictures for a user.
	 * 
	 * @param userId
	 *            Unique identifier of the target user
	 * @param offset
	 *            Sequential number of the first photo to be returned. By
	 *            default, all photos are returned.
	 * @param limit
	 *            Limits the number of photos to be retrieved. Values between
	 *            1—100 are accepted. Defaults to 100.
	 * @return A UserProfilePhotos object containing the profile pictures.
	 * @throws CommandFailedException If the command execution fails.
	 */
	public final UserProfilePhotos getUserProfilePhotos(final Integer userId, 
			final Integer offset, final Integer limit) 
					throws CommandFailedException {
		BufferedHttpEntity entity;
		UserProfilePhotos photos = new UserProfilePhotos();
		final JsonParser parser = new JsonParser();
		httpClient = HttpClientBuilder.create()
				.setSSLHostnameVerifier(new NoopHostnameVerifier()).build();
		final HttpGet httpGet = new HttpGet(new MethodUrl(botToken, 
				Constants.GET_PHOTOS).toString());
		try {
			entity = new BufferedHttpEntity(httpClient.execute(httpGet)
					.getEntity());
			final JsonObject object = parser.parse(EntityUtils
					.toString(entity, Constants.ENCODING)).getAsJsonObject();
			if (!object.has(Constants.OK)) {
				throw new CommandFailedException(Constants
						.INVALID_RESPONSE);
			}
			photos = new UserProfilePhotos(object);
		} catch (ClientProtocolException e) {
			if (LOG.isErrorEnabled()) {
				LOG.error(Constants.PROTOCOL_ERROR);
			}
		} catch (IOException e) {
			if (LOG.isErrorEnabled()) {
				LOG.error(Constants.IO_ERROR);
			}
		}
		return photos;
	}
	
	/**
	 * receive incoming updates using long polling.
	 * 
	 * @param offset
	 *            Identifier of the first update to be returned.
	 * @param limit
	 *            Must be greater by one than the highest among the identifiers
	 *            of previously received updates. By default, updates starting
	 *            with the earliest unconfirmed update are returned. An update
	 *            is considered confirmed as soon as getUpdates is called with
	 *            an offset higher than its update_id.
	 * @param timeout
	 *            Limits the number of updates to be retrieved. Values between
	 *            1—100 are accepted. Defaults to 100
	 * @return An Array of Update objects Timeout in seconds for long polling.
	 *         Defaults to 0, i.e. usual short polling
	 * @throws CommandFailedException If the command execution fails.
	 */
	public final Update[] getUpdates(final Integer offset, 
			final Integer limit, final Integer timeout) 
					throws CommandFailedException {
		Update[] updates = new Update[1];
		BufferedHttpEntity entity;
		final JsonParser parser = new JsonParser();
		httpClient = HttpClientBuilder.create()
				.setSSLHostnameVerifier(new NoopHostnameVerifier()).build();
		String url = new MethodUrl(botToken, Constants.GET_UPDATES)
				.toString();
		final StringBuffer buffer = new StringBuffer(); 
		buffer.append(url);
		if (offset != null) {
			buffer.append("?offset=");
			buffer.append(offset);
		}
		url = buffer.toString();
		final HttpGet httpGet = new HttpGet(url);
		httpGet.addHeader(Constants.CONTENT_TYPE, Constants.URL_ENCODED);
        httpGet.addHeader(Constants.CHARSET, Constants.ENCODING);
        try {
			entity = new BufferedHttpEntity(httpClient.execute(httpGet)
					.getEntity());
			final JsonObject object = parser.parse(EntityUtils.toString(entity))
					.getAsJsonObject();
			if (!object.has(Constants.OK)) {
				throw new CommandFailedException(Constants.INVALID_RESPONSE);
			}
			final JsonArray jsonArray = object.get(Constants.RESULT)
					.getAsJsonArray();
            if (jsonArray.size() != 0) {
            	updates = new Update[jsonArray.size()];
            	for (int i = 0; i < jsonArray.size(); i++) {
                    updates[i] = ApiUtils.retrieveUpdate(jsonArray, i);
            	}    
            }
		} catch (ClientProtocolException e) {
			if (LOG.isErrorEnabled()) {
				LOG.error(Constants.PROTOCOL_ERROR);
			}
		} catch (IOException e) {
			if (LOG.isErrorEnabled()) {
				LOG.error(Constants.IO_ERROR);
			}
		}
		return updates;
	}

	/**
	 * Specify a url and receive incoming updates via an outgoing webhook.
	 * Whenever there is an update for the bot, an HTTPS POST request to the
	 * specified url is sent, containing a JSON-serialized Update. In case of an
	 * unsuccessful request, no more requests are sent after a reasonable amount
	 * of attempts.
	 * 
	 * @param url
	 *            HTTPS url to send updates to. Use an empty string to remove
	 *            webhook integration. Optional.
	 * @throws CommandFailedException If the command execution fails.
	 */
	public final void setWebhook(final String url) 
			throws CommandFailedException {
		final CloseableHttpClient httpclient = HttpClientBuilder.create()
				.setSSLHostnameVerifier(new NoopHostnameVerifier()).build();
        final HttpPost httpPost = new HttpPost(new MethodUrl(botToken, 
        		Constants.SET_WEBHOOK).toString());
        httpPost.addHeader(Constants.CONTENT_TYPE, Constants.URL_ENCODED);
        httpPost.addHeader(Constants.CHARSET, Constants.ENCODING);
        final List<BasicNameValuePair> values = 
        		new ArrayList<BasicNameValuePair>();
        values.add(new BasicNameValuePair(Constants.URL, url));
			try {
				httpPost.setEntity(new UrlEncodedFormEntity(values, 
						Constants.ENCODING));
		        httpclient.execute(httpPost);
			} catch (UnsupportedEncodingException e) {
				if (LOG.isErrorEnabled()) {
					LOG.error(Constants.INVALID_ENCODING 
							+ Constants.ENCODING);
					throw new CommandFailedException(e);
				}
			} catch (ClientProtocolException e) {
				if (LOG.isErrorEnabled()) {
					LOG.error(Constants.PROTOCOL_ERROR);
					throw new CommandFailedException(e);
				}
			} catch (IOException e) {
				if (LOG.isErrorEnabled()) {
					LOG.error(Constants.IO_ERROR);
					throw new CommandFailedException(e);
				}
			}
	}
	
	/**
	 * Method to process GET requests. Must be reimplemented by the bot.
	 * @param req The HTTP GET request
	 * @param resp The HTTP response
	 * @throws  ServletException If the request for the GET could not be handled
	 * @throws IOException If an input or output error is detected when the 
	 * servlet handles the GET request
	 */
	protected final void doGet(final HttpServletRequest req, 
			final HttpServletResponse resp) throws ServletException, 
	IOException {
		final JsonParser parser = new JsonParser();
		final String body = EntityUtils
				.toString(((HttpEntityEnclosingRequest) req)
				.getEntity());
		final JsonObject object = parser.parse(body).getAsJsonObject();
		if (!object.has(Constants.OK)) {
            throw new InvalidObjectException(object.toString());
        }
        final JsonArray array = object.get(Constants.RESULT)
        		.getAsJsonArray();
        if (array.size() != 0) {
            for (int i = 0; i < array.size(); i++) {
            	  final Update update = ApiUtils.parseUpdate(array.get(i)
                  		.getAsJsonObject());
                  try {
					handleCommands(update);
				} catch (CommandFailedException e) {
					throw new ServletException(e);
				}
            }
        }
	}

	/**
	 * Method to process POST requests. Must be reimplemented by the bot.
	 * @param req The HTTP POST request
	 * @param resp The HTTP response
	 * @throws  ServletException If the request for the POST could not be 
	 * handled
	 * @throws IOException If an input or output error is detected when the 
	 * servlet handles the request
	 */
	protected final void doPost(final HttpServletRequest req, 
			final HttpServletResponse resp) throws ServletException, 
	IOException {
		final JsonParser parser = new JsonParser();
		final String body = EntityUtils
				.toString(((HttpEntityEnclosingRequest) req)
				.getEntity());
		final JsonObject object = parser.parse(body).getAsJsonObject();
		if (!object.has(Constants.OK)) {
            throw new InvalidObjectException(object.toString());
        }
        final JsonArray array = object.get(Constants.RESULT)
        		.getAsJsonArray();
        if (array.size() != 0) {
            for (int i = 0; i < array.size(); i++) {
                final Update update = ApiUtils.parseUpdate(array.get(i)
                		.getAsJsonObject());
                try {
					handleCommands(update);
				} catch (CommandFailedException e) {
					throw new ServletException(e);
				}
            }
        }
	}
	/**
	 * Method to handle commands. Must be reimplemented.
	 * @param update The update that contains the command.
	 * @throws CommandFailedException If the command execution fails.
	 */
	public abstract void handleCommands(Update update) 
			throws CommandFailedException;
}
