package io.github.errebenito.telegrambotapi.objects;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.github.errebenito.telegrambotapi.util.Constants;

/**
 * This class represents a document (any file that is not covered by the other
 * specific types like Audio, Photo or Video).
 * 
 * @author Raúl Benito
 *
 */
public class Document extends File {

	/**
	 * Document thumbnail as defined by the sender.
	 */
	@Expose
	@SerializedName(Constants.THUMB)
	private PhotoSize thumb;

	/**
	 * Original filename as defined by sender. Optional.
	 */
	@Expose
	@SerializedName(Constants.FILE_NAME)
	private String fileName;

	/**
	 * 
	 * Class constructor.
	 * 
	 * @param object
	 *            The JsonObject from which the Document will be constructed.
	 */
	public Document(final JsonObject object) {
		super(object);
		this.setThumb(new PhotoSize(object.get(Constants.THUMB)
				.getAsJsonObject()));
		if (object.has(Constants.FILE_NAME)) {
			this.setFileName(object.get(Constants.FILE_NAME).getAsString());
		} 
	}

	/**
	 * Class constructor.
	 */
	public Document() {
		super();
		this.setThumb(null);
		this.setFileName(null);

	}

	/**
	 * Accessor for the document thumbnail.
	 * 
	 * @return the document thumbnail
	 */
	public final PhotoSize getThumb() {
		return this.thumb;
	}

	/**
	 * Mutator for the document thumbnail.
	 * 
	 * @param photoSize
	 *            the document thumbnail
	 */
	public final void setThumb(final PhotoSize photoSize) {
		this.thumb = photoSize;
	}

	/**
	 * Accessor for the document's file name.
	 * 
	 * @return the document's file name
	 */
	public final String getFileName() {
		return this.fileName;
	}

	/**
	 * Mutator for the document's file name.
	 * 
	 * @param name
	 *            the document's file name
	 */
	public final void setFileName(final String name) {
		this.fileName = name;
	}

}
