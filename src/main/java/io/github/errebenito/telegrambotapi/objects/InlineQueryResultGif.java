package io.github.errebenito.telegrambotapi.objects;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.github.errebenito.telegrambotapi.util.Constants;

/**
 * This class represents a link to an animated GIF file.
 * 
 * @author Raúl Benito
 *
 */
public class InlineQueryResultGif extends InlineQueryResult {
	/**
	 * The GIF URL.
	 */
	@Expose
	@SerializedName(Constants.GIF_URL)
	private String gifURL;
	/**
	 * GIF width. Optional.
	 */
	@Expose
	@SerializedName(Constants.GIF_WIDTH)
	private Integer gifWidth;	
	/**
	 * GIF height. Optional.
	 */
	@Expose
	@SerializedName(Constants.GIF_HEIGHT)
	private Integer gifHeight;
	/**
	 * Caption of the GIF. Optional.
	 */
	@Expose
	@SerializedName(Constants.CAPTION)
	private String caption;
	
	/**
	 * 
	 * Class constructor.
	 */
	public InlineQueryResultGif() {
		super();
		this.setGifURL(null);
		this.setGifHeight(null);
		this.setGifWidth(null);
		this.setCaption(null);
	}
	
	/**
	 * 
	 * Class constructor.
	 * @param object
	 * 			  The object from which the result photo will be constructed.
	 */
	public InlineQueryResultGif(final JsonObject object) {
		super(object);
		this.setGifURL(object.get(Constants.GIF_URL).getAsString());
		if (object.has(Constants.GIF_WIDTH)) {
			this.setGifWidth(object.get(Constants.GIF_WIDTH).getAsInt());
		} else {
			this.setGifWidth(null);
		}
		if (object.has(Constants.GIF_HEIGHT)) {
			this.setGifHeight(object.get(Constants.GIF_HEIGHT).getAsInt());
		} else {
			this.setGifHeight(null);
		}
		if (object.has(Constants.CAPTION)) {
			this.setCaption(object.get(Constants.CAPTION).getAsString());
		} else {
			this.setCaption(null);
		}
	}
	
	/**
	 * Accessor for the gif URL. 
	 * @return the gif URL
	 */
	public final String getGifURL() {
		return this.gifURL;
	}
	/**
	 * Mutator for the  gif URL.
	 * @param url the gif URL
	 */
	public final void setGifURL(final String url) {
		this.gifURL = url;
	}
	/**
	 * Accessor for the gif width. 
	 * @return the gif width
	 */
	public final Integer getGifWidth() {
		return this.gifWidth;
	}
	/**
	 * Mutator for the  gif width.
	 * @param width the gif width
	 */
	public final void setGifWidth(final Integer width) {
		this.gifWidth = width;
	}
	/**
	 * Accessor for the gif height. 
	 * @return the gif height
	 */
	public final Integer getGifHeight() {
		return this.gifHeight;
	}
	/**
	 * Mutator for the  gif height.
	 * @param height the height
	 */
	public final void setGifHeight(final Integer height) {
		this.gifHeight = height;
	}
	/**
	 * Accessor for the caption. 
	 * @return the caption
	 */
	public final String getCaption() {
		return this.caption;
	}
	/**
	 * Mutator for the  caption.
	 * @param newCaption the caption
	 */
	public final void setCaption(final String newCaption) {
		this.caption = newCaption;
	}
}
