package io.github.errebenito.telegrambotapi.objects;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.github.errebenito.telegrambotapi.util.Constants;

/**
 * This class represents one result of an inline query.
 * 
 * @author Raúl Benito
 *
 */
public class InlineQueryResult {

	/**
	 * The result type.
	 */
	@Expose
	@SerializedName(Constants.TYPE)
	private String type;
	/**
	 * The result ID.
	 */
	@Expose
	@SerializedName(Constants.ID)
	private String resultID;
	/**
	 * The result title.
	 */
	@Expose
	@SerializedName(Constants.TITLE)
	private String title;
	/**
	 * The message text.
	 */
	@Expose
	@SerializedName(Constants.MESSAGE_TEXT)
	private String messageText;
	/**
	 * The parse mode. Optional.
	 */
	@Expose
	@SerializedName(Constants.PARSE_MODE)
	private String parseMode;
	/**
	 * The thumb url. Optional.
	 */
	@Expose
	@SerializedName(Constants.THUMB_URL)
	private String thumbURL;
	
	/**
	 * Disable link previews. Optional.
	 */
	@Expose
	@SerializedName(Constants.DISABLE_PREVIEW)
	private Boolean disablePreview;
	
	/**
	 * 
	 * Class constructor.
	 */
	public InlineQueryResult() {
		this.setDisablePreview(null);
		this.setMessageText(null);
		this.setParseMode(null);
		this.setResultID(null);
		this.setThumbURL(null);
		this.setTitle(null);
		this.setType(null);
	}

	/**
	 * 
	 * Class constructor.
	 * 
	 * @param object
	 *            The JsonObject from which the result will be constructed.
	 */
	public InlineQueryResult(final JsonObject object) {
		this.setResultID(object.get(Constants.ID).getAsString());
		this.setType(object.get(Constants.TYPE).getAsString());
		this.setTitle(object.get(Constants.TITLE).getAsString());
		this.setMessageText(object.get(Constants.MESSAGE_TEXT).getAsString());
		if (object.has(Constants.PARSE_MODE)) {
			this.setParseMode(object.get(Constants.PARSE_MODE).getAsString());
		} else {
			this.setParseMode(null);
		}
		if (object.has(Constants.THUMB_URL)) {
			this.setThumbURL(object.get(Constants.THUMB_URL).getAsString());
		} else {
			this.setThumbURL(null);
		}
		if (object.has(Constants.DISABLE_PREVIEW)) {
			this.setDisablePreview(object.get(Constants.DISABLE_PREVIEW)
					.getAsBoolean());
		} else {
			this.setDisablePreview(null);
		}
	}
	
	/**
	 * Accessor for the result type. 
	 * @return the result type
	 */
	public final String getType() {
		return this.type;
	}

	/**
	 * Mutator for the result type.
	 * @param newType the result type
	 */
	public final void setType(final String newType) {
		this.type = newType;
	}

	/**
	 * Accessor for the result ID. 
	 * @return the result ID
	 */
	public final String getResultID() {
		return this.resultID;
	}

	/**
	 * Mutator for the result ID.
	 * @param ident the resultID
	 */
	public final void setResultID(final String ident) {
		this.resultID = ident;
	}

	/**
	 * Accessor for the title. 
	 * @return the title
	 */
	public final String getTitle() {
		return this.title;
	}

	/**
	 * Mutator for the title.
	 * @param newTitle the title
	 */
	public final void setTitle(final String newTitle) {
		this.title = newTitle;
	}

	/**
	 * Accessor for the message text. 
	 * @return the message text
	 */
	public final String getMessageText() {
		return this.messageText;
	}

	/**
	 * Mutator for the  message text.
	 * @param text the message text
	 */
	public final void setMessageText(final String text) {
		this.messageText = text;
	}

	/**
	 * Accessor for the parse mode. 
	 * @return the parse mode
	 */
	public final String getParseMode() {
		return this.parseMode;
	}

	/**
	 * Mutator for the  parse mode.
	 * @param mode the parse mode
	 */
	public final void setParseMode(final String mode) {
		this.parseMode = mode;
	}

	/**
	 * Accessor for the thumb URL. 
	 * @return the thumb URL
	 */
	public final String getThumbURL() {
		return this.thumbURL;
	}

	/**
	 * Mutator for the  thumbURL.
	 * @param url the thumbURL
	 */
	public final void setThumbURL(final String url) {
		this.thumbURL = url;
	}

	/**
	 * Accessor for the disable preview flag. 
	 * @return the disable preview flag
	 */
	public final Boolean getDisablePreview() {
		return this.disablePreview;
	}

	/**
	 * Mutator for the  disable preview flag.
	 * @param disable the disable preview flag
	 */
	public final void setDisablePreview(final Boolean disable) {
		this.disablePreview = disable;
	}	
}
