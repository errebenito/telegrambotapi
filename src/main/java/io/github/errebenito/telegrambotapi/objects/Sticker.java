package io.github.errebenito.telegrambotapi.objects;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.github.errebenito.telegrambotapi.util.Constants;

/**
 * This class represents a Sticker.
 * @author Raúl Benito
 *
 */
public class Sticker extends PhotoSize {

	/**
	 * Sticker thumbnail in .webp or .jpg format.
	 */
	@Expose
	@SerializedName(Constants.THUMB)
	private PhotoSize thumb;
	
	/**
	 * 
	 * Class constructor.
	 * @param object The JsonObject from which the Sticket will be constructed.
	 */
	public Sticker(final JsonObject object) {
		super(object);
		this.setThumb(new PhotoSize(object.get(Constants.THUMB)
				.getAsJsonObject()));
	}

	/**
	 * Class constructor.
	 */
	public Sticker() {
		super();
		this.setThumb(new PhotoSize());
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
	 * @param stickerThumb the thumb
	 */
	public final void setThumb(final PhotoSize stickerThumb) {
		this.thumb = stickerThumb;
	}
	
}
