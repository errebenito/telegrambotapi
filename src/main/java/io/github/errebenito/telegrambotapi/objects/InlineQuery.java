package io.github.errebenito.telegrambotapi.objects;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.github.errebenito.telegrambotapi.util.Constants;

/**
 * This class represents an incoming inline query. 
 * 
 * @author Raúl Benito
 *
 */
public class InlineQuery {

	/**
	 * Unique identifier for this query.
	 */
	@Expose
	@SerializedName(Constants.ID)
	private String queryId;

	/**
	 * Sender.
	 */
	@Expose
	@SerializedName(Constants.FROM)
	private User from;
	
	/**
	 * Text of the query.
	 */
	@Expose
	@SerializedName(Constants.QUERY)
	private String query;
	
	/**
	 * Offset of the results to be returned.
	 */
	@Expose
	@SerializedName(Constants.OFFSET)
	private String offset;
	
	/**
	 * 
	 * Class constructor.
	 */
	public InlineQuery() {
		this.setQueryId(null);
		this.setFrom(null);
		this.setQuery(null);
		this.setOffset(null);
	}

	/**
	 * 
	 * Class constructor.
	 * 
	 * @param object
	 *            The JsonObject from which the query will be constructed.
	 */
	public InlineQuery(final JsonObject object) {
		this.setQueryId(object.get(Constants.ID).getAsString());
		this.setFrom(new User(object.get(Constants.FROM).getAsJsonObject()));
		if (object.has(Constants.QUERY)) {
			this.setQuery(object.get(Constants.QUERY).getAsString());
		} 
		if (object.has(Constants.OFFSET)) {
			this.setOffset(object.get(Constants.OFFSET).getAsString());
		} 
	}

	/**
	 * Accessor for the query Id. 
	 * @return the query Id
	 */
	public final String getQueryId() {
		return this.queryId;
	}

	/**
	 * Mutator for the  query Id.
	 * @param ident the query Id
	 */
	public final void setQueryId(final String ident) {
		this.queryId = ident;
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

	/**
	 * Accessor for the offset. 
	 * @return the offset
	 */
	public final String getOffset() {
		return this.offset;
	}

	/**
	 * Mutator for the  offset.
	 * @param newOffset the offset
	 */
	public final void setOffset(final String newOffset) {
		this.offset = newOffset;
	}
	
}
