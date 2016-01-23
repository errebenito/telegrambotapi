package io.github.errebenito.telegrambotapi.objects;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.github.errebenito.telegrambotapi.util.Constants;

/**
 * This class represents a link to a photo.
 *  
 * @author Raúl Benito
 *
 */
public class InlineQueryResultPhoto extends InlineQueryResult {
	/**
	 * The photo URL.
	 */
	@Expose
	@SerializedName(Constants.PHOTO_URL)
	private String photoURL;
	/**
	 * Photo width. Optional.
	 */
	@Expose
	@SerializedName(Constants.PHOTO_WIDTH)
	private Integer photoWidth;	
	/**
	 * Photo height. Optional.
	 */
	@Expose
	@SerializedName(Constants.PHOTO_HEIGHT)
	private Integer photoHeight;
	/**
	 * Description of the photo. Optional.
	 */
	@Expose
	@SerializedName(Constants.DESCRIPTION)
	private String description;
	/**
	 * Caption of the photo. Optional.
	 */
	@Expose
	@SerializedName(Constants.CAPTION)
	private String caption;
	
	/**
	 * 
	 * Class constructor.
	 */
	public InlineQueryResultPhoto() {
		super();
		this.setPhotoURL(null);
		this.setPhotoHeight(null);
		this.setPhotoWidth(null);
		this.setDescription(null);
		this.setCaption(null);
	}
	
	/**
	 * 
	 * Class constructor.
	 * @param object
	 * 			  The object from which the result photo will be constructed.
	 */
	public InlineQueryResultPhoto(final JsonObject object) {
		super(object);
		this.setPhotoURL(object.get(Constants.PHOTO_URL).getAsString());
		if (object.has(Constants.PHOTO_WIDTH)) {
			this.setPhotoWidth(object.get(Constants.PHOTO_WIDTH).getAsInt());
		} else {
			this.setPhotoWidth(null);
		}
		if (object.has(Constants.PHOTO_HEIGHT)) {
			this.setPhotoHeight(object.get(Constants.PHOTO_HEIGHT).getAsInt());
		} else {
			this.setPhotoHeight(null);
		}
		if (object.has(Constants.DESCRIPTION)) {
			this.setDescription(object.get(Constants.DESCRIPTION)
					.getAsString());
		} else {
			this.setDescription(null);
		}
		if (object.has(Constants.CAPTION)) {
			this.setCaption(object.get(Constants.CAPTION).getAsString());
		} else {
			this.setCaption(null);
		}
	}
	
	/**
	 * Accessor for the photo URL. 
	 * @return the photo URL
	 */
	public final String getPhotoURL() {
		return this.photoURL;
	}
	/**
	 * Mutator for the  photo URL.
	 * @param url the photo URL
	 */
	public final void setPhotoURL(final String url) {
		this.photoURL = url;
	}
	/**
	 * Accessor for the photo width. 
	 * @return the photo width
	 */
	public final Integer getPhotoWidth() {
		return this.photoWidth;
	}
	/**
	 * Mutator for the  photo width.
	 * @param width the photo width
	 */
	public final void setPhotoWidth(final Integer width) {
		this.photoWidth = width;
	}
	/**
	 * Accessor for the photo height. 
	 * @return the photo height
	 */
	public final Integer getPhotoHeight() {
		return this.photoHeight;
	}
	/**
	 * Mutator for the  photoHeight.
	 * @param height the photoHeight
	 */
	public final void setPhotoHeight(final Integer height) {
		this.photoHeight = height;
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
