package io.github.errebenito.telegrambotapi.objects;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.github.errebenito.telegrambotapi.util.Constants;

/**
 * This class represents a group chat.
 * 
 * @author Raúl Benito
 *
 */
public class Chat extends User {
	
	/**
	 * Chat name.
	 */
	@Expose
	@SerializedName(Constants.TITLE)
	private String title;

	/**
	 * Chat type.
	 */
	@Expose
	@SerializedName(Constants.TYPE)
	private String type;
	
	/**
	 * 
	 * Class constructor.
	 * 
	 * @param object
	 *            The JsonObject from which the Chat will be constructed.
	 */
	public Chat(final JsonObject object) {
		super(object);
		if (object.has(Constants.TITLE)) {
			this.setTitle(object.get(Constants.TITLE).getAsString());
		}
		this.setType(object.get(Constants.TYPE).getAsString());
	}
	
	/**
	 * 
	 * Class constructor.
	 */
	public Chat() {
		super();
		this.setTitle(null);
		this.setType(null);
	}

	/**
	 * Accessor for the group chat title.
	 * 
	 * @return the group chat title
	 */
	public final String getTitle() {
		return this.title;
	}

	/**
	 * Mutator for the group chat title.
	 * 
	 * @param groupChatTitle
	 *            the group chat title
	 */
	public final void setTitle(final String groupChatTitle) {
		this.title = groupChatTitle;
	}
	
	/**
	 * Accessor for the type of the chat.
	 * 
	 * @return the type of the chat
	 */
	public final String getType() {
		return this.type;
	}

	/**
	 * Mutator for the type of the chat.
	 * 
	 * @param newType
	 *            the type of the chat
	 */
	public final void setType(final String newType) {		
		this.type = newType;
	}
}
