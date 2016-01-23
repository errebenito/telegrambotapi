package io.github.errebenito.telegrambotapi.objects;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.github.errebenito.telegrambotapi.util.Constants;

/**
 * This class represents a result of an inline query that was chosen 
 * by the user and sent to their chat partner.
 * @author Raúl Benito
 *
 */
public class ChosenInlineResult {

	/**
	 * The result ID.
	 */
	@Expose
	@SerializedName(Constants.ID)
	private String resultID;
	/**
	 * The sender.
	 */
	@Expose
	@SerializedName(Constants.FROM)
	private User from;
	/**
	 * The Query.
	 */
	@Expose
	@SerializedName(Constants.QUERY)
	private String query;
	
	/**
	 * 
	 * Class constructor.
	 */
	public ChosenInlineResult() {
		this.setFrom(null);
		this.setQuery(null);
		this.setResultID(null);
	}
	
	/**
	 * 
	 * Class constructor.
	 * 
	 * @param object
	 *            The JsonObject from which the result will be constructed.
	 */
	public ChosenInlineResult(final JsonObject object) {
		this.setFrom(new User(object.get(Constants.FROM).getAsJsonObject()));
		this.setQuery(object.get(Constants.QUERY).getAsString());
		this.setResultID(object.get(Constants.ID).getAsString());
	}

	/**
	 * Accessor for the result ID. 
	 * @return the result ID
	 */
	public final String getResultID() {
		return this.resultID;
	}

	/**
	 * Mutator for the  result ID.
	 * @param ident the result ID
	 */
	public final void setResultID(final String ident) {
		this.resultID = ident;
	}

	/**
	 * Accessor for the sender. 
	 * @return the sender
	 */
	public final User getFrom() {
		return this.from;
	}

	/**
	 * Mutator for the  sender.
	 * @param sender the sender
	 */
	public final void setFrom(final User sender) {
		this.from = sender;
	}

	/**
	 * Accessor for the query. 
	 * @return the query
	 */
	public final String getQuery() {
		return this.query;
	}

	/**
	 * Mutator for the  query.
	 * @param newQuery the query
	 */
	public final void setQuery(final String newQuery) {
		this.query = newQuery;
	}
}
