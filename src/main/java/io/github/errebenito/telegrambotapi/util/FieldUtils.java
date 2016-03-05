package io.github.errebenito.telegrambotapi.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.message.BasicNameValuePair;

import io.github.errebenito.telegrambotapi.objects.SelectiveObject;

/**
 * This class contains methods to manage optional fields for API methods.
 * @author Raúl Benito
 *
 */
public final class FieldUtils {

	/**
	 * 
	 * Class constructor.
	 */
	private FieldUtils() {
		
	}
	
	/**
	 * Adds the optional fields of the Message for the sendMessage method.
	 * 
	 * @param parseMode
	 * 			The flag to enable or disable Markdown
	 * @param disablePreview
	 *            Disables link previews for links in this message.
	 * @param disableNotif
	 * 			  Disables notifications when sending a message.           
	 * @param reply
	 *            If the message is a reply, ID of the original message.
	 * @param markup
	 *            Additional interface options.
	 * @return A list with the optional fields' names and values.
	 */
	public static List<BasicNameValuePair> addOptionalFields(
			final String parseMode, final Boolean disablePreview,
			final Boolean disableNotif, final Boolean reply, 
			final SelectiveObject markup) {
		final List<BasicNameValuePair> values = 
				new ArrayList<BasicNameValuePair>();
		if (parseMode != null) {
			values.add(new BasicNameValuePair(Constants.PARSE_MODE, 
					parseMode));
		}
		if (disablePreview != null) {
			values.add(new BasicNameValuePair(Constants.DISABLE_PREVIEW, 
					disablePreview.toString()));
		}
		if (disableNotif != null) {
			values.add(new BasicNameValuePair(Constants.DISABLE_NOTIF,
					disableNotif.toString()));
		}
		if (reply != null) {
			values.add(new BasicNameValuePair(Constants.REPLY_TO_ID, 
					reply.toString()));
		}
		if (markup != null) {
			values.add(new BasicNameValuePair(Constants.REPLY_MARKUP, 
					markup.toString()));
		}
		return values;
	}
		
	/**
	 * Adds the optional fields of the Document for the sendDocument method.
	 * 
	 * @param disableNotif
	 * 			  Disables notifications when sending a message.
	 * @param originalId 
	 * 			  If the message is a reply, ID of the original message.
	 * @param markup
	 * 			  Additional interface options.	
	 * @return A list with the optional fields' names and values.
	 */
	public static List<BasicNameValuePair>  addOptionalFields(
			final Boolean disableNotif, final Integer originalId, 
			final SelectiveObject markup) {
		final List<BasicNameValuePair> values = 
				new ArrayList<BasicNameValuePair>();
		if (disableNotif != null) {
			values.add(new BasicNameValuePair(Constants.DISABLE_NOTIF,
					disableNotif.toString()));
		}
		if (originalId != null) {
			values.add(new BasicNameValuePair(Constants.REPLY_TO_ID, 
					originalId.toString()));
		}
		if (markup != null) {
			values.add(new BasicNameValuePair(Constants.REPLY_MARKUP, 
					markup.toString()));
		}
		return values;
	}
}
