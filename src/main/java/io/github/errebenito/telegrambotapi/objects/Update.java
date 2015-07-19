package io.github.errebenito.telegrambotapi.objects;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.github.errebenito.telegrambotapi.util.Constants;

/**
 * This class represents an incoming update.
 * 
 * @author Raúl Benito
 *
 */
public class Update {

	/**
	 * The update‘s unique identifier. Update identifiers start from a certain
	 * positive number and increase sequentially.
	 */
	@Expose
	@SerializedName(Constants.UPDATE_ID)
	private Integer updateId;

	/**
	 * New incoming message. Optional.
	 */
	@Expose
	@SerializedName(Constants.MESSAGE)
	private Message message;

	/**
	 * 
	 * Class constructor.
	 * @param object The JsonObject from which the Update will be constructed.
	 */
	public Update(final JsonObject object) {
		this.setUpdateId(object.get(Constants.UPDATE_ID).getAsInt());
		if (object.has(Constants.MESSAGE)) {
			this.setMessage(new Message(object.get(Constants.MESSAGE)
					.getAsJsonObject()));
		} 
	}

	/**
	 * 
	 * Class constructor.
	 */
	public Update() {
		this.setUpdateId(null);
		this.setMessage(null);
	}

	/**
	 * Accessor for the update identifier.
	 * 
	 * @return the update identifier
	 */
	public final Integer getUpdateId() {
		return this.updateId;
	}

	/**
	 * Mutator for the update identifier.
	 * 
	 * @param ident
	 *            the update identifier
	 */
	public final void setUpdateId(final Integer ident) {
		this.updateId = ident;
	}

	/**
	 * Accessor for the message.
	 * 
	 * @return the message
	 */
	public final Message getMessage() {
		return this.message;
	}

	/**
	 * Mutator for the message.
	 * 
	 * @param newMessage
	 *            the message
	 */
	public final void setMessage(final Message newMessage) {
		this.message = newMessage;
	}

}
