package io.github.errebenito.telegrambotapi.objects;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.github.errebenito.telegrambotapi.util.Constants;

/**
 * This class represents a video file.
 * @author Raúl Benito
 *
 */
public class Video  extends File {

	/**
	 * Video width.
	 */
	@Expose
	@SerializedName(Constants.WIDTH)
	private Integer width;

	/**
	 * Video height.
	 */
	@Expose
	@SerializedName(Constants.HEIGHT)
	private Integer height;
	
	/**
	 * Duration of the video in seconds as defined by sender.
	 */
	@Expose
	@SerializedName(Constants.DURATION)
	private Integer duration;
	
	/**
	 * Video thumbnail.
	 */
	@Expose
	@SerializedName(Constants.THUMB)
	private PhotoSize thumb;
	
	/**
	 * Text description of the video (usually empty). Optional.
	 */
	@Expose
	@SerializedName(Constants.CAPTION)
	private String caption;

	/**
	 * 
	 * Class constructor.
	 * @param object The JsonObject from which the Video will be constructed.
	 */
	public Video(final JsonObject object) {
		super(object);
		this.setHeight(object.get(Constants.HEIGHT).getAsInt());
		this.setWidth(object.get(Constants.WIDTH).getAsInt());
		this.setDuration(object.get(Constants.DURATION).getAsInt());
		this.setThumb(new PhotoSize(object.get(Constants.THUMB)
				.getAsJsonObject()));
		if (object.has(Constants.CAPTION)) {
			this.setCaption(object.get(Constants.CAPTION).getAsString());
		} 
	}
	
	/**
	 * Class constructor.
	 */
	public Video() {
		super();
		this.setWidth(null);
		this.setHeight(null);
		this.setCaption(null);
		this.setDuration(null);
		this.setThumb(null);
	}

	/**
	 * Accessor for the width. 
	 * @return the width
	 */
	public final Integer getWidth() {
		return this.width;
	}

	/**
	 * Mutator for the width.
	 * @param videoWidth the width
	 */
	public final void setWidth(final Integer videoWidth) {
		this.width = videoWidth;
	}

	/**
	 * Accessor for the height. 
	 * @return the height
	 */
	public final Integer getHeight() {
		return this.height;
	}

	/**
	 * Mutator for the height.
	 * @param videoHeight the height
	 */
	public final void setHeight(final Integer videoHeight) {
		this.height = videoHeight;
	}

	/**
	 * Accessor for the duration. 
	 * @return the duration
	 */
	public final Integer getDuration() {
		return this.duration;
	}

	/**
	 * Mutator for the duration.
	 * @param seconds the duration
	 */
	public final void setDuration(final Integer seconds) {
		this.duration = seconds;
	}

	/**
	 * Accessor for the thumb. 
	 * @return the thumb
	 */
	public final PhotoSize getThumb() {
		return this.thumb;
	}

	/**
	 * Mutator for the thumb.
	 * @param thumbnail the thumb
	 */
	public final void setThumb(final PhotoSize thumbnail) {
		this.thumb = thumbnail;
	}

	/**
	 * Accessor for the caption. 
	 * @return the caption
	 */
	public final String getCaption() {
		return this.caption;
	}

	/**
	 * Mutator for the caption.
	 * @param text the caption
	 */
	public final void setCaption(final String text) {
		this.caption = text;
	}	
}
