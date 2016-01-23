package io.github.errebenito.telegrambotapi.objects;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.github.errebenito.telegrambotapi.util.Constants;

/**
 * This class represents an audio file.
 * 
 * @author Raúl Benito
 *
 */
public class Audio extends BaseFile {

	/**
	 * Duration of the audio in seconds as defined by sender.
	 */
	@Expose
	@SerializedName(Constants.DURATION)
	private Integer duration;

	/**
	 * Performer of the audio as defined by sender or audio tags.
	 */
	@Expose
	@SerializedName(Constants.PERFORMER)
	private String performer;
	
	/**
	 * Title of the audio as defined by sender or audio tags.
	 */
	@Expose
	@SerializedName(Constants.TITLE)
	private String title;
	
	/**
	 * 
	 * Class constructor.
	 * 
	 * @param object
	 *            The JsonObject from which the Audio will be constructed
	 */
	public Audio(final JsonObject object) {
		super(object);
		this.setDuration(object.get(Constants.DURATION).getAsInt());
		if (object.has(Constants.PERFORMER)) {
			this.setPerformer(object.get(Constants.PERFORMER).getAsString());
		}
		if (object.has(Constants.TITLE)) {
			this.setTitle(object.get(Constants.TITLE).getAsString());
		}
	}

	/**
	 * Class constructor.
	 */
	public Audio() {
		super();
		this.setDuration(null);
		this.setTitle(null);
		this.setPerformer(null);
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

	/**
	 * Accessor for the performer. 
	 * @return the performer
	 */
	public final String getPerformer() {
		return this.performer;
	}

	/**
	 * Mutator for the  performer.
	 * @param newPerf the performer
	 */
	public final void setPerformer(final String newPerf) {
		this.performer = newPerf;
	}

	/**
	 * Accessor for the title. 
	 * @return the title
	 */
	public final String getTitle() {
		return this.title;
	}

	/**
	 * Mutator for the  title.
	 * @param newTitle the title
	 */
	public final void setTitle(final String newTitle) {
		this.title = newTitle;
	}
}
