package io.github.errebenito.telegrambotapi.objects;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.github.errebenito.telegrambotapi.util.Constants;

/**
 * This class represents one size of a photo or a file / sticker thumbnail.
 * 
 * @author Raúl Benito
 *
 */
public class PhotoSize {
	/**
	 * Unique identifier for this file.
	 */
	@Expose
	@SerializedName(Constants.FILE_ID)
	private String fileId;

	/**
	 * Photo width.
	 */
	@Expose
	@SerializedName(Constants.WIDTH)
	private Integer width;

	/**
	 * Photo height.
	 */
	@Expose
	@SerializedName(Constants.HEIGHT)
	private Integer height;

	/**
	 * File size. Optional.
	 */
	@Expose
	@SerializedName(Constants.FILE_SIZE)
	private Integer fileSize;

	/**
	 * 
	 * Class constructor.
	 */
	public PhotoSize() {
		this.setFileId(null);
		this.setFileSize(null);
		this.setHeight(null);
		this.setWidth(null);
	}

	/**
	 * 
	 * Class constructor.
	 * 
	 * @param object
	 *            The JsonObject from which the PhotoSize will be constructed.
	 */
	public PhotoSize(final JsonObject object) {
		this.setFileId(object.get(Constants.FILE_ID).getAsString());
		this.setWidth(object.get(Constants.WIDTH).getAsInt());
		this.setHeight(object.get(Constants.HEIGHT).getAsInt());
		if (object.has(Constants.FILE_SIZE)) {
			this.setFileSize(object.get(Constants.FILE_SIZE).getAsInt());
		} 
	}

	/**
	 * Accessor for the file identifier.
	 * 
	 * @return the file identifier
	 */
	public final String getFileId() {
		return this.fileId;
	}

	/**
	 * Mutator for the file identifier.
	 * 
	 * @param ident
	 *            the file identifier
	 */
	public final void setFileId(final String ident) {
		this.fileId = ident;
	}

	/**
	 * Accessor for the width of the photo.
	 * 
	 * @return the width of the photo
	 */
	public final Integer getWidth() {
		return this.width;
	}

	/**
	 * Mutator for the width of the photo.
	 * 
	 * @param photoWidth
	 *            the width of the photo
	 */
	public final void setWidth(final Integer photoWidth) {
		this.width = photoWidth;
	}

	/**
	 * Accessor for the height of the photo.
	 * 
	 * @return the height of the photo
	 */
	public final Integer getHeight() {
		return this.height;
	}

	/**
	 * Mutator for the height of the photo.
	 * 
	 * @param photoHeight
	 *            the height of the photo
	 */
	public final void setHeight(final Integer photoHeight) {
		this.height = photoHeight;
	}

	/**
	 * Accessor for the file size of the photo.
	 * 
	 * @return the file size of the photo
	 */
	public final Integer getFileSize() {
		return this.fileSize;
	}

	/**
	 * Mutator for the file size of the photo.
	 * 
	 * @param size
	 *            the file size of the photo
	 */
	public final void setFileSize(final Integer size) {
		this.fileSize = size;
	}
}
