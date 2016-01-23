package io.github.errebenito.telegrambotapi.objects;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.github.errebenito.telegrambotapi.util.Constants;

/**
 * This class represents a link to an article or web page.
 * 
 * @author Raúl Benito
 *
 */
public class InlineQueryResultArticle extends InlineQueryResult {

	/**
	 * The article URL. Optional.
	 */
	@Expose
	@SerializedName(Constants.URL)
	private String url;
	/**
	 * Hide URL flag. Optional.
	 */
	@Expose
	@SerializedName(Constants.HIDE_URL)
	private Boolean hideURL;
	/**
	 * Description of the article. Optional.
	 */
	@Expose
	@SerializedName(Constants.DESCRIPTION)
	private String description;
	/**
	 * Thumb width. Optional.
	 */
	@Expose
	@SerializedName(Constants.THUMB_WIDTH)
	private Integer thumbWidth;	
	/**
	 * Thumb height. Optional.
	 */
	@Expose
	@SerializedName(Constants.THUMB_HEIGHT)
	private Integer thumbHeight;	
	
	/**
	 * 
	 * Class constructor.
	 */
	public InlineQueryResultArticle() {
		super();
		this.setDescription(null);
		this.setHideURL(null);
		this.setUrl(null);
		this.setThumbHeight(null);
		this.setThumbWidth(null);
	}

	/**
	 * 
	 * Class constructor.
	 * @param object
	 * 			  The JsonObject from which the result will be constructed.
	 */
	public InlineQueryResultArticle(final JsonObject object) {
		super(object);
		if (object.has(Constants.URL)) {
			this.setUrl(object.get(Constants.URL).getAsString());
		} else {
			this.setUrl(null);
		}
		if (object.has(Constants.HIDE_URL)) {
			this.setHideURL(object.get(Constants.HIDE_URL).getAsBoolean());
		} else {
			this.setHideURL(null);
		}
		if (object.has(Constants.DESCRIPTION)) {
			this.setDescription(object.get(Constants.DESCRIPTION)
					.getAsString());
		} else {
			this.setDescription(null);
		}
		if (object.has(Constants.THUMB_WIDTH)) {
			this.setThumbWidth(object.get(Constants.THUMB_WIDTH)
					.getAsInt());
		} else {
			this.setThumbWidth(null);
		}	
		if (object.has(Constants.THUMB_HEIGHT)) {
			this.setThumbHeight(object.get(Constants.THUMB_HEIGHT)
					.getAsInt());
		} else {
			this.setThumbHeight(null);
		}	
	}

	/**
	 * Accessor for the url. 
	 * @return the url
	 */
	public final String getUrl() {
		return this.url;
	}

	/**
	 * Mutator for the  url.
	 * @param newUrl the url
	 */
	public final void setUrl(final String newUrl) {
		this.url = newUrl;
	}

	/**
	 * Accessor for the hide URL flag. 
	 * @return the hide URL flag
	 */
	public final Boolean getHideURL() {
		return this.hideURL;
	}

	/**
	 * Mutator for the  hide URL flag.
	 * @param hide the hide URL flag
	 */
	public final void setHideURL(final Boolean hide) {
		this.hideURL = hide;
	}

	/**
	 * Accessor for the description. 
	 * @return the description
	 */
	public final String getDescription() {
		return this.description;
	}

	/**
	 * Mutator for the  description.
	 * @param desc the description
	 */
	public final void setDescription(final String desc) {
		this.description = desc;
	}

	/**
	 * Accessor for the thumb width. 
	 * @return the thumb width
	 */
	public final Integer getThumbWidth() {
		return this.thumbWidth;
	}

	/**
	 * Mutator for the  thumb width.
	 * @param width the thumb width
	 */
	public final void setThumbWidth(final Integer width) {
		this.thumbWidth = width;
	}

	/**
	 * Accessor for the thumb height. 
	 * @return the thumb height
	 */
	public final Integer getThumbHeight() {
		return this.thumbHeight;
	}

	/**
	 * Mutator for the thumb height.
	 * @param height the thumb height
	 */
	public final void setThumbHeight(final Integer height) {
		this.thumbHeight = height;
	}
}
