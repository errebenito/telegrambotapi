package io.github.errebenito.telegrambotapi.objects;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.github.errebenito.telegrambotapi.util.Constants;

/**
 * This class represents a chat type, either with a user or a group.
 * 
 * @author Raúl Benito
 *
 */
public class ChatType {
	/**
	 * Unique identifier for this ChatType.
	 */
	@Expose
	@SerializedName(Constants.ID)
	private Integer id;

	/**
	 * 
	 * Class constructor.
	 */
	public ChatType() {
		this.setId(null);
	}

	/**
	 * 
	 * Class constructor.
	 * 
	 * @param object
	 *            The JsonObject from which the ChatType will be constructed.
	 */
	public ChatType(final JsonObject object) {
		this.setId(object.get(Constants.ID).getAsInt());
	}

	/**
	 * Accessor for the identifier of the chat.
	 * 
	 * @return the identifier of the chat
	 */
	public final Integer getId() {
		return this.id;
	}

	/**
	 * Mutator for the identifier of the chat.
	 * 
	 * @param ident
	 *            the identifier of the chat
	 */
	public final void setId(final Integer ident) {
		this.id = ident;
	}

}
