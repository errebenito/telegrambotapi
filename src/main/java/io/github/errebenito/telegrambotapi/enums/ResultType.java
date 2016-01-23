package io.github.errebenito.telegrambotapi.enums;

/**
 * @author Raúl Benito
 *
 */
public enum ResultType {
	/**
	 * Result type: article.
	 */
	ARTICLE(0, "article"),
	/**
	 * Result type: photo.
	 */
	PHOTO(1, "photo"),
	/**
	 * Result type: gif. 
	 */
	GIF(2, "gif"),
	/**
	 * Result type: MPEG4GIF.
	 */
	MPEG4GIF(3, "mpeg4_gif"),
	/**
	 * Result type: video.
	 */
	VIDEO(4, "video");
	/**
	 * The ID of the chat type.
	 */
	private Integer typeId;
	/**
	 * The description of the chat type.
	 */
	private String description;
	
	/**
	 * 
	 * Class constructor.
	 * 
	 * @param ident
	 *            The ID of the result type
	 * @param actionDescription
	 *            The description of the result type
	 */
	private ResultType(final Integer ident, final String actionDescription) {
		this.typeId = ident;
		this.description = actionDescription;
	}

	/**
	 * Accessor for the ID of the result type.
	 * 
	 * @return The ID of the result type
	 */
	public final Integer getTypeId() {
		return this.typeId;
	}

	/**
	 * Mutator for the ID of the result type.
	 * 
	 * @param ident
	 *            The ID of the result type
	 */
	public final void setTypeId(final Integer ident) {
		this.typeId = ident;
	}

	/**
	 * Accessor for the description of the result type.
	 * 
	 * @return The description of the result type
	 */
	public final String getDescription() {
		return this.description;
	}

	/**
	 * Mutator for the description of the result type.
	 * 
	 * @param typeDescription
	 *            The description of the result type
	 */
	public final void setDescription(final String typeDescription) {
		this.description = typeDescription;
	}
}
