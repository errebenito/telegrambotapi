package io.github.errebenito.telegrambotapi.objects;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.github.errebenito.telegrambotapi.util.Constants;

/**
 * This class represents a way to force showing the reply interface.
 * 
 * @author Raúl Benito
 *
 */
public class ForceReply extends SelectiveObject {
	/**
	 * Shows reply interface to the user, as if they manually selected the bot‘s
	 * message and tapped ’Reply'.
	 */
	@Expose
	@SerializedName(Constants.FORCE_REPLY)
	private Boolean forceReplyField;

	/**
	 * 
	 * Class constructor.
	 * 
	 * @param object
	 *            The JsonObject from which the ForceReply will be constructed.
	 */
	public ForceReply(final JsonObject object) {
		super(object);
		this.setForceReplyField(object.get(Constants.FORCE_REPLY)
				.getAsBoolean());

	}
	
	/**
	 * 
	 * Class constructor.
	 */
	public ForceReply() {
		super();
		this.setForceReplyField(null);
	}

	/**
	 * Accessor for the force reply field.
	 * 
	 * @return <em>true</em> if the message is a reply; <em>false</em> otherwise
	 */
	public final Boolean getForceReplyField() {
		return this.forceReplyField;
	}

	/**
	 * Mutator for the force reply field.
	 * 
	 * @param newForceReply
	 *            <em>true</em> if the message is a reply; <em>false</em>
	 *            otherwise
	 */
	public final void setForceReplyField(final Boolean newForceReply) {
		this.forceReplyField = newForceReply;
	}

}
