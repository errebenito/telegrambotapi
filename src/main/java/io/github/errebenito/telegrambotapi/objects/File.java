package io.github.errebenito.telegrambotapi.objects;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.github.errebenito.telegrambotapi.util.Constants;

/**
 * This object represents a file ready to be downloaded. 
 * 
 * @author Raúl Benito
 *
 */
public class File {
	
	/**
	 * Unique identifier for this file.
	 */
	@Expose
	@SerializedName(Constants.FILE_ID)
	private String fileId;

	/**
	 * File size. Optional.
	 */
	@Expose
	@SerializedName(Constants.FILE_SIZE)
	private Integer fileSize;
	
	/**
	 * File path. Optional.
	 */
	@Expose
	@SerializedName(Constants.FILE_PATH)
	private String filePath;
	
	/**
	 * 
	 * Class constructor.
	 */
	public File() {
		this.setFileId(null);
		this.setFileSize(null);
		this.setFilePath(null);
	}

	/**
	 * 
	 * Class constructor.
	 * @param path The file path
	 */
	public File(final String path) {
		this.setFileId(null);
		this.setFileSize(null);
		this.setFilePath(path);
	}
	/**
	 * 
	 * Class constructor.
	 * 
	 * @param object
	 *            The JsonObject from which the BaseFile will be constructed.
	 */
	public File(final JsonObject object) {
		this.setFileId(object.get(Constants.FILE_ID).getAsString());
		if (object.has(Constants.FILE_SIZE)) {
			this.setFileSize(object.get(Constants.FILE_SIZE).getAsInt());
		} 
		if (object.has(Constants.FILE_PATH)) {
			this.setFilePath(object.get(Constants.FILE_PATH).getAsString());
		} 
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
	
	/**
	 * Accessor for the file path.
	 * 
	 * @return the file path
	 */
	public final String getFilePath() {
		return this.filePath;
	}

	/**
	 * Mutator for the file's path.
	 * 
	 * @param path
	 *            the file's path
	 */
	public final void setFilePath(final String path) {
		this.filePath = path;
	}
}
