package io.github.errebenito.telegrambotapi.enums;

/**
 * Enum for the different chat actions.
 * @author Raúl Benito
 *
 */
public enum ActionType {

	/**
	 * Action pending: typing a message.
	 */
	TYPING(0, "typing"), 
	/**
	 * Action pending: uploading a photo.
	 */
	UPLOAD_PHOTO(1, "upload_photo"), 
	/**
	 * Action pending: recording a video.
	 */
	RECORD_VIDEO(2, "record_video"), 
	/**
	 * Action pending: uploading a video.
	 */
	UPLOAD_VIDEO(3, "upload_video"), 
	/**
	 * Action pending: recording an audio.
	 */
	RECORD_AUDIO(4, "record_audio"), 
	/**
	 * Action pending: uploading an audio.
	 */
	UPLOAD_AUDIO(5, "upload_audio"), 
	/**
	 * Action pending: uploading a document.
	 */
	UPLOAD_DOCUMENT(6,
			"upload_document"),
	/**
	 * Action pending: finding a location.
	 */
	FIND_LOCATION(7, "find_location");

	/**
	 * The ID of the action.
	 */
	private Integer typeId;
	/**
	 * The description of the action.
	 */
	private String description;

	/**
	 * 
	 * Class constructor.
	 * 
	 * @param ident
	 *            The ID of the action
	 * @param actionDescription
	 *            The description of the action
	 */
	private ActionType(final Integer ident, final String actionDescription) {
		this.typeId = ident;
		this.description = actionDescription;
	}

	/**
	 * Accessor for the ID of the action.
	 * 
	 * @return The ID of the action
	 */
	public final Integer getTypeId() {
		return this.typeId;
	}

	/**
	 * Mutator for the ID of the action type.
	 * 
	 * @param ident
	 *            The ID of the action type
	 */
	public final void setTypeId(final Integer ident) {
		this.typeId = ident;
	}

	/**
	 * Accessor for the description of the action type.
	 * 
	 * @return The description of the action type
	 */
	public final String getDescription() {
		return this.description;
	}

	/**
	 * Mutator for the description of the action type.
	 * 
	 * @param typeDescription
	 *            The description of the action type
	 */
	public final void setDescription(final String typeDescription) {
		this.description = typeDescription;
	}

}
