package io.github.errebenito.telegrambotapi.objects;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.github.errebenito.telegrambotapi.util.Constants;

/**
 * This class represents a voice note.
 * 
 * @author Raúl Benito
 *
 */
public class Voice extends BaseFile {
	
	/**
	 * Duration of the audio in seconds as defined by sender.
	 */
	@Expose
	@SerializedName(Constants.DURATION)
	private Integer duration;
	
	/**
	 * 
	 * Class constructor.
	 * 
	 * @param object
	 *            The JsonObject from which the Audio will be constructed
	 */
	public Voice(final JsonObject object) {
		super(object);
		this.setDuration(object.get(Constants.DURATION).getAsInt());
	}

	/**
	 * Class constructor.
	 */
	public Voice() {
		super();
		this.setDuration(null);
	}

	
	/**
	 * Accessor for the duration of the file.
	 * 
	 * @return the duration of the file
	 */
	public final Integer getDuration() {
		return this.duration;
	}

	/**
	 * Mutator for the duration of the file.
	 * 
	 * @param audioDuration
	 *            the duration of the file
	 */
	public final void setDuration(final Integer audioDuration) {
		this.duration = audioDuration;
	}

}
