package io.github.errebenito.telegrambotapi.impl;

import io.github.errebenito.telegrambotapi.enums.ActionType;
import io.github.errebenito.telegrambotapi.exceptions.CommandFailedException;
import io.github.errebenito.telegrambotapi.objects.File;
import io.github.errebenito.telegrambotapi.objects.InlineQueryResult;
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
	 *            Unique identifier for the message recipient.
	 * @param text
	 *            Text of the message to be sent.
	 * @param parseMode
	 * 			  Enables the use of Markdown in messages.           
	 * @param disablePreview
	 *            Disables link previews for links in this message.
	 * @param disableNotif
	 * 			  Disables notifications when sending a message.           
	 * @param reply
	 *            If the message is a reply, ID of the original message.
	 * @param markup
	 *            Additional interface options.
	 * @return On success, the sent Message is returned.
	 * @throws CommandFailedException If the command execution fails.
	 */
	Message sendMessage(Integer chatId, String text, String parseMode, 
			Boolean disablePreview, Boolean disableNotif, 
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
	 * @param disableNotif
	 * 			  Disables notifications when sending a message.
	 * @param messageId
	 *            Unique message identifier
	 * @return On success, the sent Message is returned.
	 * @throws CommandFailedException If the command execution fails.
	 */
	Message forwardMessage(Integer chatId, Integer fromId, 
			Boolean disableNotif, Integer messageId) 
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
	 * @param disableNotif
	 * 			  Disables notifications when sending a message.            
	 * @param originalId
	 *            If the message is a reply, ID of the original message
	 * @param markup
	 *            Additional interface options.
	 * @return On success, the sent Message is returned.
	 * @throws CommandFailedException If the command execution fails.
	 */
	Message sendPhoto(Integer chatId, Object photo, String caption, 
			Boolean disableNotif, Integer originalId, SelectiveObject markup) 
					throws CommandFailedException;

	/**
	 * Sends an audio file (ogg encoded with OPUS).
	 * 
	 * @param chatId
	 *            Unique identifier for the message recipient.
	 * @param audio
	 *            Audio to send. Either a string id, or InputFile.
	 * @param duration
	 * 			  Duration of the audio.
	 * @param performer 
	 * 			  Performer of the audio
     * @param disableNotif
	 * 			  Disables notifications when sending a message.      
	 * @param originalId
	 *            If the message is a reply, ID of the original message.
	 * @param markup
	 *            Additional interface options.
	 * @return On success, the sent Message is returned.
	 * @throws CommandFailedException If the command execution fails.
	 */
	Message sendAudio(Integer chatId, Object audio, Integer duration, 
			String performer, Boolean disableNotif, 
			Integer originalId, SelectiveObject markup) 
					throws CommandFailedException;

	/**
	 * Sends a file. It's used as a wrapper for the file sending methods.
	 * 
	 * @param chatId
	 *            Unique identifier for the message recipient.
	 * @param document
	 *            BaseFile to send. Either a string id, or InputFile.
	 *  @param disableNotif
	 * 			  Disables notifications when sending a message.              
	 * @param originalId
	 *            If the message is a reply, ID of the original message.
	 * @param markup
	 *            Additional interface options.
	 * @return On success, the sent Message is returned.
	 * @throws CommandFailedException If the command execution fails.
	 */
	Message sendDocument(Integer chatId, Object document, 
			Boolean disableNotif, Integer originalId, 
			SelectiveObject markup) 
					throws CommandFailedException;

	/**
	 * Sends a sticker.
	 * 
	 * @param chatId
	 *            Unique identifier for the message recipient.
	 * @param sticker
	 *            Sticker to send. Either a string id, or InputFile.
	 *  @param disableNotif
	 * 			  Disables notifications when sending a message.             
	 * @param originalId
	 *            If the message is a reply, ID of the original message.
	 * @param markup
	 *            Additional interface options.
	 * @return On success, the sent Message is returned.
	 * @throws CommandFailedException If the command execution fails.
	 */
	Message sendSticker(Integer chatId, Object sticker, Boolean disableNotif, 
			Integer originalId,	SelectiveObject markup) 
					throws CommandFailedException;

	/**
	 * Sends a video file (mp4).
	 * 
	 * @param chatId
	 *            Unique identifier for the message recipient.
	 * @param video
	 *            Video to send. Either a string id, or InputFile.
	 * @param duration
	 * 			  The duration of the video.
	 * @param caption
	 * 			  The caption of the video.  
	 * @param disableNotif
	 * 			  Disables notifications when sending a message.         
	 * @param originalId
	 *            If the message is a reply, ID of the original message.
	 * @param markup
	 *            Additional interface options.
	 * @return On success, the sent Message is returned.
	 * @throws CommandFailedException If the command execution fails.
	 */
	Message sendVideo(Integer chatId, Object video, Integer duration, 
			String caption, Boolean disableNotif, Integer originalId,
			SelectiveObject markup) throws CommandFailedException;

	/**
	 * Sends a voice note.
	 * @param chatId
	 * 			  Unique identifier for the message recipient.
	 * @param voice
	 * 			  Voice note to send. Either a string id or InputFile.
	 * @param duration
	 * 			  The duration of the voice note.
	 * @param disableNotif
	 * 			  Disables notifications when sending a message. 
	 * @param originalId
	 * 			  If the message is a reply, ID of the original message.
	 * @param markup
	 *            Additional interface options.
	 * @return On success, the sent Message is returned.
	 * @throws CommandFailedException If the command execution fails.
	 */
	Message sendVoice(Integer chatId, Object voice, Integer duration, 
			Boolean disableNotif, Integer originalId, SelectiveObject markup) 
					throws CommandFailedException;
	
	/**
	 * Sends a location.
	 * 
	 * @param chatId
	 *            Unique identifier for the message recipient.
	 * @param latitude
	 *            Latitude of location
	 * @param longitude
	 *            Longitude of location
	 * @param disableNotif
	 * 			  Disables notifications when sending a message.             
	 * @param originalId
	 *            If the message is a reply, ID of the original message.
	 * @param markup
	 *            Additional interface options.
	 * @return On success, the sent Message is returned.
	 * @throws CommandFailedException If the command execution fails.
	 */
	Message sendLocation(Integer chatId, Float latitude, Float longitude, 
			Boolean disableNotif, Integer originalId, SelectiveObject markup) 
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
	 * Get basic info about a file and prepare it for downloading.
	 * @param fileId
	 * 			  File identifier to get info about.
	 * @return A File object containing the file.
	 * @throws CommandFailedException If the command execution fails.
	 */
	File getFile(String fileId) throws CommandFailedException;
	
	/**
	 * Send answers to an inline query.
	 * @param queryId
	 * 			   The query Id
	 * @param results
	 * 			   An array of InlineQueryResult with the results.
	 * @param cacheTime
	 * 			   The maximum amount of time in seconds that the 
	 * 			   result may be cached.
	 * @param isPersonal
	 * 			   <em>True</em> if the results may be cached on the 
	 * 			   server only for the user who sent the query.
	 * @param nextOffset
	 * 			   The offset that a client should send in the next 
	 * 			   query with the same text to receive more results.
	 * @return <em>true</em> on success; <em>false</em> otherwise.
	 * @throws CommandFailedException If the command execution fails.
	 */
	Boolean answerInlineQuery(String queryId, InlineQueryResult[] results,
			Integer cacheTime, Boolean isPersonal, String nextOffset) 
					throws CommandFailedException;
	
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
}
