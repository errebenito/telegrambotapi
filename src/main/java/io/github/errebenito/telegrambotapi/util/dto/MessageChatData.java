package io.github.errebenito.telegrambotapi.util.dto;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.github.errebenito.telegrambotapi.objects.PhotoSize;
import io.github.errebenito.telegrambotapi.objects.User;
import io.github.errebenito.telegrambotapi.util.Constants;

/**
 * This class represents additional chat data that may not be present in the
 * message.
 * @author Raúl Benito
 *
 */
public class MessageChatData {

	/**
	 * A new member was added to the group, information about them (this member
	 * may be bot itself). Optional.
	 */
	@Expose
	@SerializedName(Constants.NEW_PARTICIPANT)
	private User newParticipant;

	/**
	 * A member was removed from the group, information about them (this member
	 * may be bot itself). Optional.
	 */
	@Expose
	@SerializedName(Constants.LEFT_PARTICIPANT)
	private User leftParticipant;

	/**
	 * A group title was changed to this value. Optional.
	 */
	@Expose
	@SerializedName(Constants.NEW_TITLE)
	private String newChatTitle;

	/**
	 * A group photo was change to this value. Optional.
	 */
	@Expose
	@SerializedName(Constants.NEW_PHOTO)
	private PhotoSize[] newChatPhoto;

	/**
	 * Informs that the group photo was deleted. Optional
	 */
	@Expose
	@SerializedName(Constants.DELETE_PHOTO)
	private Boolean deleteChatPhoto;

	/**
	 * Informs that the group has been created. Optional.
	 */
	@Expose
	@SerializedName(Constants.GROUP_CREATED)
	private Boolean groupChatCreated;
	
	/**
	 * Informs that the supergroup has been created. Optional.
	 */
	@Expose
	@SerializedName(Constants.SGROUP_CREATED)
	private Boolean sgroupCreated;
	
	/**
	 * Informs that the channel has been created. Optional.
	 */
	@Expose
	@SerializedName(Constants.CHANNEL_CREATED)
	private Boolean channelCreated;
	
	/**
	 * Informs the identifier of the supergroup to which the group 
	 * was migrated. Optional.
	 */
	@Expose
	@SerializedName(Constants.MIG_TO_CHAT_ID)
	private Integer migrateToChatId;
	
	/**
	 * Informs the identifier of the supergroup from which the group 
	 * was migrated. Optional.
	 */
	@Expose
	@SerializedName(Constants.MIG_FROM_CHAT_ID)
	private Integer migrateFromChatId;
	
	/**
	 * 
	 * Class constructor.
	 * @param object The JsonObject from which the chat data will be 
	 * constructed.
	 */
	public MessageChatData(final JsonObject object) {
		if (object.has(Constants.NEW_PARTICIPANT)) {
			this.setNewParticipant(new User(object
					.get(Constants.NEW_PARTICIPANT).getAsJsonObject()));
		} else {
			this.setNewParticipant(null);
		}
		if (object.has(Constants.LEFT_PARTICIPANT)) {
			this.setLeftParticipant(new User(object
					.get(Constants.LEFT_PARTICIPANT).getAsJsonObject()));
		} else {
			this.setLeftParticipant(null);
		}
		if (object.has(Constants.NEW_TITLE)) {
			this.setNewChatTitle(object.get(Constants.NEW_TITLE).getAsString());
		} else {
			this.setNewChatTitle(null);
		}
		if (object.has(Constants.NEW_PHOTO)) {
			this.setNewChatPhoto(new PhotoSize(object.get(Constants.NEW_PHOTO)
					.getAsJsonObject()));
		} else {
			this.setNewChatPhoto(new PhotoSize[0]);
		}
		if (object.has(Constants.DELETE_PHOTO)) {
			this.setDeleteChatPhoto(object.get(Constants.DELETE_PHOTO)
					.getAsBoolean());
		} else {
			this.setDeleteChatPhoto(null);
		}
		setCreationFlag(object);
		setMigrationId(object);
	}

	/**
	 * @param object the JSON object from which the creation flag will be set.
	 */
	private void setCreationFlag(final JsonObject object) {
		if (object.has(Constants.GROUP_CREATED)) {
			this.setGroupChatCreated(object.get(Constants.GROUP_CREATED)
					.getAsBoolean());
		} else {
			this.setGroupChatCreated(null);
		}
		if (object.has(Constants.SGROUP_CREATED)) {
			this.setSgroupCreated(object.get(Constants.SGROUP_CREATED)
					.getAsBoolean());
		} else {
			this.setSgroupCreated(null);
		}
		if (object.has(Constants.CHANNEL_CREATED)) {
			this.setChannelCreated(object.get(Constants.CHANNEL_CREATED)
					.getAsBoolean());
		} else {
			this.setChannelCreated(null);
		}
	}

	/**
	 * @param object The JSON object from which the migration IDs will be set.
	 */
	private void setMigrationId(final JsonObject object) {
		if (object.has(Constants.MIG_FROM_CHAT_ID)) {
			this.setMigrateFromChatId(object.get(Constants.MIG_FROM_CHAT_ID)
					.getAsInt());
		} else {
			this.setMigrateFromChatId(null);
		}
		if (object.has(Constants.MIG_TO_CHAT_ID)) {
			this.setMigrateToChatId(object.get(Constants.MIG_TO_CHAT_ID)
					.getAsInt());
		} else {
			this.setMigrateToChatId(null);
		}
	}
	
	/**
	 * 
	 * Class constructor.
	 */
	public MessageChatData() {
		this.setDeleteChatPhoto(null);
		this.setGroupChatCreated(null);
		this.setLeftParticipant(null);
		this.setNewChatPhoto(new PhotoSize[0]);
		this.setNewChatTitle(null);
		this.setNewParticipant(null);
	}
	
	/**
	 * Accessor for the new chat participant.
	 * 
	 * @return the new chat participant
	 */
	public final User getNewParticipant() {
		return this.newParticipant;
	}

	/**
	 * Mutator for the new chat participant.
	 * 
	 * @param newUser
	 *            the new chat participant
	 */
	public final void setNewParticipant(final User newUser) {
		this.newParticipant = newUser;
	}

	/**
	 * Accessor for the chat participant that left the chat.
	 * 
	 * @return the chat participant that left the chat
	 */
	public final User getLeftParticipant() {
		return this.leftParticipant;
	}

	/**
	 * Mutator for the chat participant that left the chat.
	 * 
	 * @param goneUser
	 *            the chat participant that left the chat
	 */
	public final void setLeftParticipant(final User goneUser) {
		this.leftParticipant = goneUser;
	}

	/**
	 * Accessor for the new chat title.
	 * 
	 * @return the new chat title
	 */
	public final String getNewChatTitle() {
		return this.newChatTitle;
	}

	/**
	 * Mutator for the new chat title.
	 * 
	 * @param title
	 *            the new chat title
	 */
	public final void setNewChatTitle(final String title) {
		this.newChatTitle = title;
	}

	/**
	 * Accessor for the new chat photo.
	 * 
	 * @return the new chat photo
	 */
	public final PhotoSize[] getNewChatPhoto() {
		final PhotoSize[] result = new PhotoSize[newChatPhoto.length];
		System.arraycopy(this.newChatPhoto, 0, result, 0, newChatPhoto.length);
		return result;
	}

	/**
	 * Mutator for the new chat photo.
	 * 
	 * @param photos
	 *            the new chat photo
	 */
	public final void setNewChatPhoto(final PhotoSize... photos) {
		System.arraycopy(photos, 0, this.getNewChatPhoto(), 0, photos.length);
	}

	/**
	 * Accessor for the field to check if the chat photo was deleted.
	 * 
	 * @return <em>true</em> if the chat photo was deleted; <em>false</em>
	 *         otherwise.
	 */
	public final Boolean getDeleteChatPhoto() {
		return this.deleteChatPhoto;
	}

	/**
	 * Mutator for the delete chat photo.
	 * 
	 * @param deletedPhoto
	 *            <em>true</em> if the chat photo was deleted; <em>false</em>
	 *            otherwise.
	 */
	public final void setDeleteChatPhoto(final Boolean deletedPhoto) {
		this.deleteChatPhoto = deletedPhoto;
	}

	/**
	 * Accessor for the field to check if the group chat created.
	 * 
	 * @return <em>true</em> if the chat group was created; <em>false</em>
	 *         otherwise.
	 */
	public final Boolean getGroupChatCreated() {
		return this.groupChatCreated;
	}

	/**
	 * Mutator for the field to check if the group chat created.
	 * 
	 * @param created
	 *            <em>true</em> if the chat group was created; <em>false</em>
	 *            otherwise.
	 */
	public final void setGroupChatCreated(final Boolean created) {
		this.groupChatCreated = created;
	}

	/**
	 * Accessor for the channel creation flag. 
	 * @return the channel created flag
	 */
	public final Boolean getChannelCreated() {
		return this.channelCreated;
	}

	/**
	 * Mutator for the  channel creation flag.
	 * 
	 * @param created
	 *            <em>true</em> if the channel was created; <em>false</em>
	 *            otherwise.
	 */
	public final void setChannelCreated(final Boolean created) {
		this.channelCreated = created;
	}

	/**
	 * Accessor for the supergroup creation flag. 
	 * @return the supergroup created flag.
	 */
	public final Boolean getSgroupCreated() {
		return this.sgroupCreated;
	}

	/**
	 * Mutator for the  superGroupChatCreated.
	 * 
	 * @param created
	 *            <em>true</em> if the supergroup was created; <em>false</em>
	 *            otherwise.
	 */
	public final void setSgroupCreated(final Boolean created) {
		this.sgroupCreated = created;
	}

	/**
	 * Accessor for the id of the supergroup the chat was migrated to. 
	 * @return the id of the supergroup the chat was migrated to
	 */
	public final Integer getMigrateToChatId() {
		return this.migrateToChatId;
	}

	/**
	 * Mutator for the id of the supergroup the chat was migrated to. 
	 * @param newMigTo the id of the supergroup the chat was migrated to
	 */
	public final void setMigrateToChatId(final Integer newMigTo) {
		this.migrateToChatId = newMigTo;
	}

	/**
	 * Accessor for the id of the supergroup the chat was migrated from. 
	 * @return the id of the supergroup the chat was migrated from
	 */
	public final Integer getMigrateFromChatId() {
		return this.migrateFromChatId;
	}

	/**
	 * Mutator for the id of the supergroup the chat was migrated from. 
	 * @param newMigFrom the id of the supergroup the chat was migrated from
	 */
	public final void setMigrateFromChatId(final Integer newMigFrom) {
		this.migrateFromChatId = newMigFrom;
	}

}
