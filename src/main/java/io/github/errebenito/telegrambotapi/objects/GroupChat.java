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
public class GroupChat extends ChatType {

	/**
	 * Group name.
	 */
	@Expose
	@SerializedName(Constants.TITLE)
	private String title;

	/**
	 * 
	 * Class constructor.
	 * 
	 * @param object
	 *            The JsonObject from which the GroupChat will be constructed.
	 */
	public GroupChat(final JsonObject object) {
		super(object);
		this.setTitle(object.get(Constants.TITLE).getAsString());
	}
	
	/**
	 * 
	 * Class constructor.
	 */
	public GroupChat() {
		super();
		this.setTitle(null);
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
}
