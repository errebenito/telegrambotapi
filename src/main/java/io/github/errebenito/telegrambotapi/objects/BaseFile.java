package io.github.errebenito.telegrambotapi.objects;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.github.errebenito.telegrambotapi.util.Constants;

/**
 * This class represents a generic file.
 * 
 * @author Raúl Benito
 *
 */
public class BaseFile {

	/**
	 * Unique identifier for this file.
	 */
	@Expose
	@SerializedName(Constants.FILE_ID)
	private String fileId;

	/**
	 * MIME type of the file as defined by sender. Optional
	 */
	@Expose
	@SerializedName(Constants.MIME_TYPE)
	private String mimeType;

	/**
	 * BaseFile size. Optional.
	 */
	@Expose
	@SerializedName(Constants.FILE_SIZE)
	private Integer fileSize;

	/**
	 * 
	 * Class constructor.
	 */
	public BaseFile() {
		this.setFileId(null);
		this.setFileSize(null);
		this.setMimeType(null);
	}

	/**
	 * 
	 * Class constructor.
	 * 
	 * @param object
	 *            The JsonObject from which the BaseFile will be constructed.
	 */
	public BaseFile(final JsonObject object) {
		this.setFileId(object.get(Constants.FILE_ID).getAsString());
		if (object.has(Constants.FILE_SIZE)) {
			this.setFileSize(object.get(Constants.FILE_SIZE).getAsInt());
		} 
		if (object.has(Constants.MIME_TYPE)) {
			this.setMimeType(object.get(Constants.MIME_TYPE).getAsString());
		} 
	}

	/**
	 * Accessor for the file's mime type.
	 * 
	 * @return the mime file's type
	 */
	public final String getMimeType() {
		return this.mimeType;
	}

	/**
	 * Mutator for the file's mime type.
	 * 
	 * @param type
	 *            the file's mime type
	 */
	public final void setMimeType(final String type) {
		this.mimeType = type;
	}

	/**
	 * Accessor for the file size.
	 * 
	 * @return the file size
	 */
	public final Integer getFileSize() {
		return this.fileSize;
	}

	/**
	 * Mutator for the file's size.
	 * 
	 * @param size
	 *            the file's size
	 */
	public final void setFileSize(final Integer size) {
		this.fileSize = size;
	}

	/**
	 * Accessor for the file's identifier.
	 * 
	 * @return the file's identifier
	 */
	public final String getFileId() {
		return this.fileId;
	}

	/**
	 * Mutator for the file's identifier.
	 * 
	 * @param ident
	 *            the file's identifier
	 */
	public final void setFileId(final String ident) {
		this.fileId = ident;
	}
}
