package io.github.errebenito.telegrambotapi.objects;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.github.errebenito.telegrambotapi.util.Constants;
import io.github.errebenito.telegrambotapi.util.dto.MessageChatData;
import io.github.errebenito.telegrambotapi.util.dto.MessageContentData;

/**
 * This class represents a message.
 * 
 * @author Raúl Benito
 *
 */
public class Message {
	/**
	 * Unique message identifier.
	 */
	@Expose
	@SerializedName(Constants.MESSAGE_ID)
	private Integer messageId;

	/**
	 * Sender.
	 */
	@Expose
	@SerializedName(Constants.FROM)
	private User from;

	/**
	 * Date the message was sent in Unix time.
	 */
	@Expose
	@SerializedName(Constants.DATE)
	private Integer date;

	/**
	 * Conversation the message belongs to — User in case of a private message,
	 * GroupChat in case of a group.
	 */
	@Expose
	@SerializedName(Constants.CHAT)
	private Chat chat;

	/**
	 * For forwarded messages, sender of the original message. Optional.
	 */
	@Expose
	@SerializedName(Constants.FORWARD_FROM)
	private User forwardFrom;

	/**
	 * For forwarded messages, date the original message was sent in Unix time.
	 * Optional.
	 */
	@Expose
	@SerializedName(Constants.FORWARD_DATE)
	private Integer forwardDate;

	/**
	 * For replies, the original message. Note that the Message object in this
	 * field will not contain further reply_to_message fields even if it itself
	 * is a reply. Optional.
	 */
	@Expose
	@SerializedName(Constants.REPLY_TO)
	private Message replyToMessage;

	/**
	 * A container class to avoid excess of fields in this one.
	 */
	private transient MessageContentData contentData;

	/**
	 * A container class to avoid excess of fields in this one.
	 */
	private transient MessageChatData chatData;

	/**
	 * Sets the optional fields.
	 * 
	 * @param object
	 *            The JsonObject that may store the values of the fields.
	 */
	private void setOptionalFields(final JsonObject object) {
		if (object.has(Constants.FORWARD_FROM)) {
			this.setForwardFrom(new User(object.get(Constants.FORWARD_FROM)
					.getAsJsonObject()));
		} 
		if (object.has(Constants.FORWARD_DATE)) {
			this.setForwardDate(object.get(Constants.FORWARD_DATE).getAsInt());
		}
		if (object.has(Constants.REPLY_TO)) {
			this.setReplyToMessage(new Message(object.get(Constants
					.REPLY_TO).getAsJsonObject()));
		} 
		if (object.has(Constants.CONTACT)) {
			this.setContact(new Contact(object.get(Constants.CONTACT)
					.getAsJsonObject()));
		}
		if (object.has(Constants.LOCATION)) {
			this.setLocation(new Location(object.get(Constants.LOCATION)
					.getAsJsonObject()));
		} 
	}

	/**
	 * 
	 * Class constructor.
	 * 
	 * @param object
	 *            The JsonObject from which the message will be constructed
	 */
	public Message(final JsonObject object) {
		this.setMessageId(object.get(Constants.MESSAGE_ID).getAsInt());
		this.setFrom(new User(object.get(Constants.FROM).getAsJsonObject()));
		this.setDate(object.get(Constants.DATE).getAsInt());
		this.setChat(new Chat(object.get(Constants.CHAT)
				.getAsJsonObject()));
		setOptionalFields(object);
	}

	/**
	 * Class constructor.
	 */
	public Message() {
		this.setMessageId(null);
		this.setFrom(null);
		this.setDate(null);
		this.setChat(null);
		this.setOptionalFields(null);
	}

	/**
	 * Accessor for the message identifier.
	 * 
	 * @return the message identifier
	 */
	public final Integer getMessageId() {
		return this.messageId;
	}

	/**
	 * Mutator for the message identifier.
	 * 
	 * @param ident
	 *            the message identifier
	 */
	public final void setMessageId(final Integer ident) {
		this.messageId = ident;
	}

	/**
	 * Accessor for the user that sent the message.
	 * 
	 * @return the user that sent the message
	 */
	public final User getFrom() {
		return this.from;
	}

	/**
	 * Mutator for the user that sent the message.
	 * 
	 * @param userFrom
	 *            the user that sent the message
	 */
	public final void setFrom(final User userFrom) {
		this.from = userFrom;
	}

	/**
	 * Accessor for the date when the message was sent.
	 * 
	 * @return the date when the message was sent
	 */
	public final Integer getDate() {
		return this.date;
	}

	/**
	 * Mutator for the date when the message was sent.
	 * 
	 * @param sentDate
	 *            the date when the message was sent
	 */
	public final void setDate(final Integer sentDate) {
		this.date = sentDate;
	}

	/**
	 * Accessor for the conversation where the message belongs.
	 * 
	 * @return the conversation where the message belongs — user in case of a
	 *         private message, GroupChat in case of a group
	 */
	public final Chat getChat() {
		return this.chat;
	}

	/**
	 * Mutator for the conversation where the message belongs.
	 * 
	 * @param newChat
	 *            the conversation where the message belongs
	 */
	public final void setChat(final Chat newChat) {
		this.chat = newChat;
	}

	/**
	 * Accessor for the sender of the original message.
	 * 
	 * @return the sender of the original message
	 */
	public final User getForwardFrom() {
		return this.forwardFrom;
	}

	/**
	 * Mutator for the sender of the original message.
	 * 
	 * @param userForwardFrom
	 *            the sender of the original message
	 */
	public final void setForwardFrom(final User userForwardFrom) {
		this.forwardFrom = userForwardFrom;
	}

	/**
	 * Accessor for the date when the original message was sent.
	 * 
	 * @return the date when the original message was sent
	 */
	public final Integer getForwardDate() {
		return this.forwardDate;
	}

	/**
	 * Mutator for the date when the original message was sent.
	 * 
	 * @param newForwardDate
	 *            the date when the original message was sent
	 */
	public final void setForwardDate(final Integer newForwardDate) {
		this.forwardDate = newForwardDate;
	}

	/**
	 * Accessor for the original message if this one is a reply.
	 * 
	 * @return the original message if this one is a reply
	 */
	public final Message getReplyToMessage() {
		return this.replyToMessage;
	}

	/**
	 * Mutator for the original message if this one is a reply.
	 * 
	 * @param message
	 *            the the original message if this one is a reply
	 */
	public final void setReplyToMessage(final Message message) {
		this.replyToMessage = message;
	}

	/**
	 * Accessor for the the actual UTF-8 text of the message.
	 * 
	 * @return the the actual UTF-8 text of the message
	 */
	public final String getText() {
		return this.contentData.getText();
	}

	/**
	 * Mutator for the the actual UTF-8 text of the message.
	 * 
	 * @param content
	 *            the the actual UTF-8 text of the message
	 */
	public final void setText(final String content) {
		this.contentData.setText(content);
	}

	/**
	 * Accessor for the audio file attached to the message.
	 * 
	 * @return the audio file attached to the message
	 */
	public final Audio getAudio() {
		return this.contentData.getAudio();
	}

	/**
	 * Mutator for the audio file attached to the message.
	 * 
	 * @param audioFile
	 *            the audio file attached to the message
	 */
	public final void setAudio(final Audio audioFile) {
		this.contentData.setAudio(audioFile);
	}

	/**
	 * Accessor for the document file attached to the message.
	 * 
	 * @return the document file attached to the message
	 */
	public final Document getDocument() {
		return this.contentData.getDocument();
	}

	/**
	 * Mutator for the document file attached to the message.
	 * 
	 * @param doc
	 *            the document file attached to the message
	 */
	public final void setDocument(final Document doc) {
		this.contentData.setDocument(doc);
	}

	/**
	 * Accessor for the photo file attached to the message.
	 * 
	 * @return the photo file attached to the message
	 */
	public final PhotoSize[] getPhoto() {
		final PhotoSize[] result = new PhotoSize[contentData.getPhoto().length];
		System.arraycopy(this.contentData.getPhoto(), 0, result, 0, 
				contentData.getPhoto().length);
		return result;
	}

	/**
	 * Mutator for the photo file attached to the message.
	 * 
	 * @param photoFile
	 *            the photo file attached to the message
	 */
	public final void setPhoto(final PhotoSize... photoFile) {
		System.arraycopy(photoFile, 0, this.getPhoto(), 0, photoFile.length);
	}

	/**
	 * Accessor for the sticker attached to the message.
	 * 
	 * @return the sticker attached to the message
	 */
	public final Sticker getSticker() {
		return this.contentData.getSticker();
	}

	/**
	 * Mutator for the sticker attached to the message.
	 * 
	 * @param stick
	 *            the sticker attached to the message
	 */
	public final void setSticker(final Sticker stick) {
		this.contentData.setSticker(stick);
	}

	/**
	 * Accessor for the video attached to the message.
	 * 
	 * @return the video attached to the message
	 */
	public final Video getVideo() {
		return this.contentData.getVideo();
	}

	/**
	 * Mutator for the video attached to the message.
	 * 
	 * @param videoFile
	 *            the video attached to the message
	 */
	public final void setVideo(final Video videoFile) {
		this.contentData.setVideo(videoFile);
	}

	/**
	 * Accessor for the contact being shared.
	 * 
	 * @return the contact being shared
	 */
	public final Contact getContact() {
		return this.contentData.getContact();
	}

	/**
	 * Mutator for the contact being shared.
	 * 
	 * @param sharedContact
	 *            the contact being shared
	 */
	public final void setContact(final Contact sharedContact) {
		this.contentData.setContact(sharedContact);
	}

	/**
	 * Accessor for the location being shared.
	 * 
	 * @return the location being shared
	 */
	public final Location getLocation() {
		return this.contentData.getLocation();
	}

	/**
	 * Mutator for the location being shared.
	 * 
	 * @param loc
	 *            the location being shared
	 */
	public final void setLocation(final Location loc) {
		this.contentData.setLocation(loc);
	}

	/**
	 * Accessor for the new chat participant.
	 * 
	 * @return the new chat participant
	 */
	public final User getNewParticipant() {
		return this.chatData.getNewParticipant();
	}

	/**
	 * Mutator for the new chat participant.
	 * 
	 * @param newUser
	 *            the new chat participant
	 */
	public final void setNewParticipant(final User newUser) {
		this.chatData.setNewParticipant(newUser);
	}

	/**
	 * Accessor for the chat participant that left the chat.
	 * 
	 * @return the chat participant that left the chat
	 */
	public final User getLeftParticipant() {
		return this.chatData.getLeftParticipant();
	}

	/**
	 * Mutator for the chat participant that left the chat.
	 * 
	 * @param goneUser
	 *            the chat participant that left the chat
	 */
	public final void setLeftParticipant(final User goneUser) {
		this.chatData.setLeftParticipant(goneUser);
	}

	/**
	 * Accessor for the new chat title.
	 * 
	 * @return the new chat title
	 */
	public final String getNewChatTitle() {
		return this.chatData.getNewChatTitle();
	}

	/**
	 * Mutator for the new chat title.
	 * 
	 * @param title
	 *            the new chat title
	 */
	public final void setNewChatTitle(final String title) {
		this.chatData.setNewChatTitle(title);
	}

	/**
	 * Accessor for the new chat photo.
	 * 
	 * @return the new chat photo
	 */
	public final PhotoSize[] getNewChatPhoto() {
		final PhotoSize[] result = 
				new PhotoSize[this.chatData.getNewChatPhoto().length];
		System.arraycopy(this.chatData.getNewChatPhoto(), 0, result, 0, 
				this.chatData.getNewChatPhoto().length);
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
		return this.chatData.getDeleteChatPhoto();
	}

	/**
	 * Mutator for the delete chat photo.
	 * 
	 * @param deletedPhoto
	 *            <em>true</em> if the chat photo was deleted; <em>false</em>
	 *            otherwise.
	 */
	public final void setDeleteChatPhoto(final Boolean deletedPhoto) {
		this.chatData.setDeleteChatPhoto(deletedPhoto);
	}

	/**
	 * Accessor for the field to check if the group chat created.
	 * 
	 * @return <em>true</em> if the chat group was created; <em>false</em>
	 *         otherwise.
	 */
	public final Boolean getGroupChatCreated() {
		return this.chatData.getGroupChatCreated();
	}

	/**
	 * Mutator for the field to check if the group chat created.
	 * 
	 * @param created
	 *            <em>true</em> if the chat group was created; <em>false</em>
	 *            otherwise.
	 */
	public final void setGroupChatCreated(final Boolean created) {
		this.chatData.setGroupChatCreated(created);
	}
}
