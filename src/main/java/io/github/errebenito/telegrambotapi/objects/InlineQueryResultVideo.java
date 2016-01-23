package io.github.errebenito.telegrambotapi.objects;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.github.errebenito.telegrambotapi.util.Constants;

/**
 * This class represents link to a page containing an embedded video 
 * player or a video file.
 * 
 * @author Raúl Benito
 *
 */
public class InlineQueryResultVideo extends InlineQueryResult {
	/**
	 * The video URL.
	 */
	@Expose
	@SerializedName(Constants.VIDEO_URL)
	private String videoURL;
	/**
	 * Video width. Optional.
	 */
	@Expose
	@SerializedName(Constants.VIDEO_WIDTH)
	private Integer videoWidth;	
	/**
	 * Video height. Optional.
	 */
	@Expose
	@SerializedName(Constants.VIDEO_HEIGHT)
	private Integer videoHeight;
	/**
	 * Video duration. Optional.
	 */
	@Expose
	@SerializedName(Constants.VIDEO_DURATION)
	private Integer videoDuration;
	/**
	 * Description of the video. Optional.
	 */
	@Expose
	@SerializedName(Constants.DESCRIPTION)
	private String description;
	/**
	 * MIME type of the video.
	 */
	@Expose
	@SerializedName(Constants.MIME_TYPE)
	private String mimeType;
	
	/**
	 * 
	 * Class constructor.
	 */
	public InlineQueryResultVideo() {
		super();
		this.setVideoURL(null);
		this.setVideoWidth(null);
		this.setVideoHeight(null);
		this.setVideoDuration(null);
		this.setDescription(null);
		this.setMimeType(null);
	}
	
	/**
	 * 
	 * Class constructor.
	 * @param object
	 * 			  The JSON object from which the result will be constructed.
	 */
	public InlineQueryResultVideo(final JsonObject object) {
		super(object);
		this.setVideoURL(object.get(Constants.VIDEO_URL).getAsString());
		this.setMimeType(object.get(Constants.MIME_TYPE).getAsString());
		if (object.has(Constants.VIDEO_DURATION)) {
			this.setVideoDuration(object.get(Constants.VIDEO_DURATION)
					.getAsInt());
		} else {
			this.setVideoDuration(null);
		}
		if (object.has(Constants.VIDEO_HEIGHT)) {
			this.setVideoHeight(object.get(Constants.VIDEO_HEIGHT).getAsInt());
		} else {
			this.setVideoHeight(null);
		}
		if (object.has(Constants.VIDEO_WIDTH)) {
			this.setVideoWidth(object.get(Constants.VIDEO_WIDTH).getAsInt());
		} else {
			this.setVideoWidth(null);
		}
		if (object.has(Constants.VIDEO_DURATION)) {
			this.setVideoDuration(object.get(Constants.VIDEO_DURATION)
					.getAsInt());
		} else {
			this.setVideoDuration(null);
		}
	}
	
	/**
	 * Accessor for the video URL. 
	 * @return the video URL
	 */
	public final String getVideoURL() {
		return this.videoURL;
	}
	/**
	 * Mutator for the video URL.
	 * @param url the video URL
	 */
	public final void setVideoURL(final String url) {
		this.videoURL = url;
	}
	/**
	 * Accessor for the video width. 
	 * @return the video width
	 */
	public final Integer getVideoWidth() {
		return this.videoWidth;
	}
	/**
	 * Mutator for the video width.
	 * @param width the video width
	 */
	public final void setVideoWidth(final Integer width) {
		this.videoWidth = width;
	}
	/**
	 * Accessor for the video height. 
	 * @return the video height
	 */
	public final Integer getVideoHeight() {
		return this.videoHeight;
	}
	/**
	 * Mutator for the video height.
	 * @param height the video height
	 */
	public final void setVideoHeight(final Integer height) {
		this.videoHeight = height;
	}
	/**
	 * Accessor for the video duration. 
	 * @return the video duration
	 */
	public final Integer getVideoDuration() {
		return this.videoDuration;
	}
	/**
	 * Mutator for the video duration.
	 * @param duration the video duration
	 */
	public final void setVideoDuration(final Integer duration) {
		this.videoDuration = duration;
	}
	/**
	 * Accessor for the description. 
	 * @return the description
	 */
	public final String getDescription() {
		return this.description;
	}
	/**
	 * Mutator for the description.
	 * @param desc the description
	 */
	public final void setDescription(final String desc) {
		this.description = desc;
	}
	/**
	 * Accessor for the MIME type. 
	 * @return the MIME type
	 */
	public final String getMimeType() {
		return this.mimeType;
	}
	/**
	 * Mutator for the MIME type. 
	 * @param newType the MIME type. 
	 */
	public final void setMimeType(final String newType) {
		this.mimeType = newType;
	}
}
