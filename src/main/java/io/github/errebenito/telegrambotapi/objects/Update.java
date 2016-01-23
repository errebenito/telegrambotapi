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
	 * The incoming inline query. Optional.
	 */
	@Expose
	@SerializedName(Constants.INLINE_QUERY)
	private InlineQuery inlineQuery;

	/**
	 * The result of an inline query chosen by a user and sent 
	 * to their partner.
	 */
	@Expose
	@SerializedName(Constants.CHOSEN_RESULT)
	private ChosenInlineResult chosenResult;

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
		if (object.has(Constants.INLINE_QUERY)) {
			this.setInlineQuery(new InlineQuery(object
					.get(Constants.INLINE_QUERY).getAsJsonObject()));
		}
		if (object.has(Constants.CHOSEN_RESULT)) {
			this.setChosenResult(new ChosenInlineResult(object
					.get(Constants.CHOSEN_RESULT).getAsJsonObject()));
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

	/**
	 * Accessor for the inline query. 
	 * @return the query
	 */
	public final InlineQuery getInlineQuery() {
		return this.inlineQuery;
	}

	/**
	 * Mutator for the  inline query.
	 * @param newQuery the query
	 */
	public final void setInlineQuery(final InlineQuery newQuery) {
		this.inlineQuery = newQuery;
	}

	/**
	 * Accessor for the inline query result. 
	 * @return the inline query result
	 */
	public final ChosenInlineResult getChosenResult() {
		return this.chosenResult;
	}

	/**
	 * Mutator for the  inline query result.
	 * @param newResult the result
	 */
	public final void setChosenResult(final ChosenInlineResult newResult) {
		this.chosenResult = newResult;
	}

}
