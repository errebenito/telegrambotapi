package io.github.errebenito.telegrambotapi.objects;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.github.errebenito.telegrambotapi.util.Constants;

/**
 * This class represents a link to a video animation.
 * 
 * @author Raúl Benito
 *
 */
public class InlineQueryResultMpeg4Gif extends InlineQueryResult {
	/**
	 * The MPEG4 URL.
	 */
	@Expose
	@SerializedName(Constants.MPEG4_URL)
	private String mpeg4URL;
	/**
	 * MPEG4 width. Optional.
	 */
	@Expose
	@SerializedName(Constants.MPEG4_WIDTH)
	private Integer mpeg4Width;	
	/**
	 * MPEG4 height. Optional.
	 */
	@Expose
	@SerializedName(Constants.MPEG4_HEIGHT)
	private Integer mpeg4Height;
	/**
	 * Caption of the MPEG4. Optional.
	 */
	@Expose
	@SerializedName(Constants.CAPTION)
	private String caption;
	
	/**
	 * 
	 * Class constructor.
	 */
	public InlineQueryResultMpeg4Gif() {
		super();
		this.setMpeg4Width(null);
		this.setMpeg4Height(null);
		this.setMpeg4URL(null);
		this.setCaption(null);
	}
	
	/**
	 * 
	 * Class constructor.
	 * @param object
	 * 			  The JSON object from which the result will be constructed.
	 */
	public InlineQueryResultMpeg4Gif(final JsonObject object) {
		super(object);
		this.setMpeg4URL(object.get(Constants.MPEG4_URL).getAsString());
		if (object.has(Constants.MPEG4_HEIGHT)) {
			this.setMpeg4Height(object.get(Constants.MPEG4_HEIGHT)
					.getAsInt());		
		} else {
			this.setMpeg4Height(null);
		}
		if (object.has(Constants.MPEG4_WIDTH)) {
			this.setMpeg4Width(object.get(Constants.MPEG4_WIDTH)
					.getAsInt());		
		} else {
			this.setMpeg4Width(null);
		}
		if (object.has(Constants.CAPTION)) {
			this.setCaption(object.get(Constants.CAPTION).getAsString());
		} else {
			this.setCaption(null);
		}
	}
	
	/**
	 * Accessor for the mpeg4 URL. 
	 * @return the mpeg4 URL
	 */
	public final String getMpeg4URL() {
		return this.mpeg4URL;
	}
	/**
	 * Mutator for the  mpeg4 URL.
	 * @param url the mpeg4 URL
	 */
	public final void setMpeg4URL(final String url) {
		mpeg4URL = url;
	}
	/**
	 * Accessor for the mpeg4 width. 
	 * @return the mpeg4 width
	 */
	public final Integer getMpeg4Width() {
		return this.mpeg4Width;
	}
	/**
	 * Mutator for the  mpeg4 width.
	 * @param width the mpeg4 width
	 */
	public final void setMpeg4Width(final Integer width) {
		this.mpeg4Width = width;
	}
	/**
	 * Accessor for the mpeg4 height. 
	 * @return the mpeg4 height
	 */
	public final Integer getMpeg4Height() {
		return this.mpeg4Height;
	}
	/**
	 * Mutator for the  mpeg4 height.
	 * @param height the mpeg4 height
	 */
	public final void setMpeg4Height(final Integer height) {
		this.mpeg4Height = height;
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
