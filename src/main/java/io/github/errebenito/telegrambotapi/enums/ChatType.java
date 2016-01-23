package io.github.errebenito.telegrambotapi.enums;

/**
 * @author Raúl Benito
 *
 */
public enum ChatType {

	/**
	 * Chat type: private.
	 */
	PRIVATE(0, "private"), 
	/**
	 * Chat type: group.
	 */
	GROUP(1, "group"),
	/**
	 * Chat type: supergroup.
	 */
	SUPERGROUP(2, "supergroup"),
	/**
	 * Chat type: channel.
	 */
	CHANNEL(3, "channel");
	
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
	 *            The ID of the chat type
	 * @param actionDescription
	 *            The description of the chat tpye
	 */
	private ChatType(final Integer ident, final String actionDescription) {
		this.typeId = ident;
		this.description = actionDescription;
	}

	/**
	 * Accessor for the ID of the chat type.
	 * 
	 * @return The ID of the chat type
	 */
	public final Integer getTypeId() {
		return this.typeId;
	}

	/**
	 * Mutator for the ID of the chat type.
	 * 
	 * @param ident
	 *            The ID of the chat type
	 */
	public final void setTypeId(final Integer ident) {
		this.typeId = ident;
	}

	/**
	 * Accessor for the description of the chat type.
	 * 
	 * @return The description of the chat type
	 */
	public final String getDescription() {
		return this.description;
	}

	/**
	 * Mutator for the description of the chat type.
	 * 
	 * @param typeDescription
	 *            The description of the chat type
	 */
	public final void setDescription(final String typeDescription) {
		this.description = typeDescription;
	}
}
