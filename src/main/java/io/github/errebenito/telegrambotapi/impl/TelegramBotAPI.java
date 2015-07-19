package io.github.errebenito.telegrambotapi.impl;

import io.github.errebenito.telegrambotapi.enums.ActionType;
import io.github.errebenito.telegrambotapi.exceptions.CommandFailedException;
import io.github.errebenito.telegrambotapi.objects.Message;
import io.github.errebenito.telegrambotapi.objects.SelectiveObject;
import io.github.errebenito.telegrambotapi.objects.Update;
import io.github.errebenito.telegrambotapi.objects.User;
import io.github.errebenito.telegrambotapi.objects.UserProfilePhotos;

/**
 * This interface defines the API methods.
 * @author Raúl Benito
 *
 */
public interface TelegramBotAPI {
	/**
	 * A simple method for testing your bot's auth token. Requires no
	 * parameters.
	 * 
	 * @return bot information in the form of a User object
	 * @throws CommandFailedException If the command execution fails.
	 */
	User getMe() throws CommandFailedException;

	/**
	 * Sends text messages.
	 * 
	 * @param chatId
	 *            Unique identifier for the message recipient
	 * @param text
	 *            Text of the message to be sent
	 * @param disablePreview
	 *            Disables link previews for links in this message.
	 * @param reply
	 *            If the message is a reply, ID of the original message.
	 * @param markup
	 *            Additional interface options.
	 * @return On success, the sent Message is returned.
	 * @throws CommandFailedException If the command execution fails.
	 */
	Message sendMessage(Integer chatId, String text, Boolean disablePreview, 
			Boolean reply, SelectiveObject markup) 
					throws CommandFailedException;

	/**
	 * Forwards a message.
	 * 
	 * @param chatId
	 *            Unique identifier for the message recipient
	 * @param fromId
	 *            Unique identifier for the chat where the original message was
	 *            sent
	 * @param messageId
	 *            Unique message identifier
	 * @return On success, the sent Message is returned.
	 * @throws CommandFailedException If the command execution fails.
	 */
	Message forwardMessage(Integer chatId, Integer fromId, Integer messageId) 
			throws CommandFailedException;

	/**
	 * Sends a photo.
	 * 
	 * @param chatId
	 *            Unique identifier for the message recipient
	 * @param photo
	 *            Photo to send. Either a string id, or InputFile.
	 * @param caption
	 *            Photo caption.
	 * @param originalId
	 *            If the message is a reply, ID of the original message
	 * @param markup
	 *            Additional interface options.
	 * @return On success, the sent Message is returned.
	 * @throws CommandFailedException If the command execution fails.
	 */
	Message sendPhoto(Integer chatId, Object photo, String caption, 
			Integer originalId, SelectiveObject markup) 
					throws CommandFailedException;

	/**
	 * Sends an audio file (ogg encoded with OPUS).
	 * 
	 * @param chatId
	 *            Unique identifier for the message recipient.
	 * @param audio
	 *            Audio to send. Either a string id, or InputFile.
	 * @param originalId
	 *            If the message is a reply, ID of the original message.
	 * @param markup
	 *            Additional interface options.
	 * @return On success, the sent Message is returned.
	 * @throws CommandFailedException If the command execution fails.
	 */
	Message sendAudio(Integer chatId, Object audio, Integer originalId, 
			SelectiveObject markup) throws CommandFailedException;

	/**
	 * Sends a file. It's used as a wrapper for the file sending methods.
	 * 
	 * @param chatId
	 *            Unique identifier for the message recipient.
	 * @param document
	 *            File to send. Either a string id, or InputFile.
	 * @param originalId
	 *            If the message is a reply, ID of the original message.
	 * @param markup
	 *            Additional interface options.
	 * @return On success, the sent Message is returned.
	 * @throws CommandFailedException If the command execution fails.
	 */
	Message sendDocument(Integer chatId, Object document, 
			Integer originalId, SelectiveObject markup) 
					throws CommandFailedException;

	/**
	 * Sends a sticker.
	 * 
	 * @param chatId
	 *            Unique identifier for the message recipient.
	 * @param sticker
	 *            Sticker to send. Either a string id, or InputFile.
	 * @param originalId
	 *            If the message is a reply, ID of the original message.
	 * @param markup
	 *            Additional interface options.
	 * @return On success, the sent Message is returned.
	 * @throws CommandFailedException If the command execution fails.
	 */
	Message sendSticker(Integer chatId, Object sticker, Integer originalId, 
			SelectiveObject markup) throws CommandFailedException;

	/**
	 * Sends a video file (mp4).
	 * 
	 * @param chatId
	 *            Unique identifier for the message recipient.
	 * @param video
	 *            Video to send. Either a string id, or InputFile.
	 * @param originalId
	 *            If the message is a reply, ID of the original message.
	 * @param markup
	 *            Additional interface options.
	 * @return On success, the sent Message is returned.
	 * @throws CommandFailedException If the command execution fails.
	 */
	Message sendVideo(Integer chatId, Object video, Integer originalId, 
			SelectiveObject markup) throws CommandFailedException;

	/**
	 * Sends a location.
	 * 
	 * @param chatId
	 *            Unique identifier for the message recipient.
	 * @param latitude
	 *            Latitude of location
	 * @param longitude
	 *            Longitude of location
	 * @param originalId
	 *            If the message is a reply, ID of the original message.
	 * @param markup
	 *            Additional interface options.
	 * @return On success, the sent Message is returned.
	 * @throws CommandFailedException If the command execution fails.
	 */
	Message sendLocation(Integer chatId, Float latitude, Float longitude, 
			Integer originalId, SelectiveObject markup) 
					throws CommandFailedException;

	/**
	 * Tells the user that something is happening on the bot's side.
	 * 
	 * @param chatId
	 *            Unique identifier for the message recipient.
	 * @param action
	 *            Type of action to broadcast.
	 * @return A custom message to display according to the action.
	 * @throws CommandFailedException If the command execution fails.
	 */
	Message sendChatAction(Integer chatId, ActionType action) 
			throws CommandFailedException;

	/**
	 * Returns a list of profile pictures for a user.
	 * 
	 * @param userId
	 *            Unique identifier of the target user
	 * @param offset
	 *            Sequential number of the first photo to be returned. By
	 *            default, all photos are returned.
	 * @param limit
	 *            Limits the number of photos to be retrieved. Values between
	 *            1—100 are accepted. Defaults to 100.
	 * @return A UserProfilePhotos object containing the profile pictures.
	 * @throws CommandFailedException If the command execution fails.
	 */
	UserProfilePhotos getUserProfilePhotos(Integer userId, Integer offset, 
			Integer limit) throws CommandFailedException;

	/**
	 * receive incoming updates using long polling.
	 * 
	 * @param offset
	 *            Identifier of the first update to be returned.
	 * @param limit
	 *            Must be greater by one than the highest among the identifiers
	 *            of previously received updates. By default, updates starting
	 *            with the earliest unconfirmed update are returned. An update
	 *            is considered confirmed as soon as getUpdates is called with
	 *            an offset higher than its update_id.
	 * @param timeout
	 *            Limits the number of updates to be retrieved. Values between
	 *            1—100 are accepted. Defaults to 100
	 * @return An Array of Update objects Timeout in seconds for long polling.
	 *         Defaults to 0, i.e. usual short polling
	 * @throws CommandFailedException If the command execution fails.
	 */
	Update[] getUpdates(Integer offset, Integer limit, Integer timeout) 
			throws CommandFailedException;

	/**
	 * Specify a url and receive incoming updates via an outgoing webhook.
	 * Whenever there is an update for the bot, an HTTPS POST request to the
	 * specified url is sent, containing a JSON-serialized Update. In case of an
	 * unsuccessful request, no more requests are sent after a reasonable amount
	 * of attempts.
	 * 
	 * @param url
	 *            HTTPS url to send updates to. Use an empty string to remove
	 *            webhook integration. Optional.
	 * @throws CommandFailedException If the command execution fails.
	 */
	void setWebhook(String url) throws CommandFailedException;
	
	/**
	 * Abstract method for handling commands. Must be reimplemented.
	 * @param update The update that contains the command.
	 * @throws CommandFailedException If the command execution fails.
	 */
	void handleCommand(Update update) throws CommandFailedException;
}
