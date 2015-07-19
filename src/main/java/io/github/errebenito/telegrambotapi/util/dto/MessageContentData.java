package io.github.errebenito.telegrambotapi.util.dto;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.github.errebenito.telegrambotapi.objects.Audio;
import io.github.errebenito.telegrambotapi.objects.Contact;
import io.github.errebenito.telegrambotapi.objects.Document;
import io.github.errebenito.telegrambotapi.objects.Location;
import io.github.errebenito.telegrambotapi.objects.PhotoSize;
import io.github.errebenito.telegrambotapi.objects.Sticker;
import io.github.errebenito.telegrambotapi.objects.Video;
import io.github.errebenito.telegrambotapi.util.Constants;

/**
 * This class represents additional message data that may not be present in the
 * message.
 * 
 * @author Raúl Benito
 */
public class MessageContentData {
	/**
	 * For text messages, the actual UTF-8 text of the message. Optional.
	 */
	@SerializedName(Constants.TEXT)
	@Expose
	private String text;
	/**
	 * Message is an audio file, information about the file. Optional.
	 */
	@SerializedName(Constants.AUDIO)
	@Expose
	private Audio audio;
	/**
	 * Message is a general file, information about the file. Optional.
	 */
	@SerializedName(Constants.DOCUMENT)
	@Expose
	private Document document;
	/**
	 * Message is a photo, available sizes of the photo. Optional.
	 */
	@SerializedName(Constants.PHOTO)
	@Expose
	private PhotoSize[] photo;
	/**
	 * Message is a sticker, information about the sticker. Optional
	 */
	@SerializedName(Constants.STICKER)
	@Expose
	private Sticker sticker;
	/**
	 * Message is a video, information about the video. Optional.
	 */
	@SerializedName(Constants.VIDEO)
	@Expose
	private Video video;
	/**
	 * Message is a shared contact, information about the contact. Optional.
	 */
	@SerializedName(Constants.CONTACT)
	@Expose
	private Contact contact;
	/**
	 * Message is a shared location, information about the location. Optional.
	 */
	@SerializedName(Constants.LOCATION)
	@Expose
	private Location location;

	/**
	 * 
	 * Class constructor.
	 */
	public MessageContentData() {
		this.setAudio(null);
		this.setContact(null);
		this.setDocument(null);
		this.setLocation(null);
		this.setPhoto(new PhotoSize[0]);
		this.setSticker(null);
		this.setText(null);
		this.setVideo(null);
	}

	/**
	 * Class constructor.
	 * 
	 * @param object
	 *            the JsonObject from which the optional fields will be
	 *            constructed.
	 */
	public MessageContentData(final JsonObject object) {
		if (object.has(Constants.TEXT)) {
			this.setText(object.get(Constants.TEXT).getAsString());
		} else {
			this.setText(null);
		}
		if (object.has(Constants.AUDIO)) {
			this.setAudio(new Audio(object.get(Constants.AUDIO)
					.getAsJsonObject()));
		} else {
			this.setAudio(null);
		}
		if (object.has(Constants.AUDIO)) {
			this.setDocument(new Document(object.get(Constants.DOCUMENT)
					.getAsJsonObject()));
		} else {
			this.setDocument(null);
		}
		if (object.has(Constants.PHOTO)) {
			this.setPhoto(new PhotoSize(object.get(Constants.PHOTO)
					.getAsJsonObject()));
		} else {
			this.setPhoto(new PhotoSize[0]);
		}
		if (object.has(Constants.STICKER)) {
			this.setSticker(new Sticker(object.get(Constants.STICKER)
					.getAsJsonObject()));
		} else {
			this.setSticker(null);
		}
		if (object.has(Constants.VIDEO)) {
			this.setVideo(new Video(object.get(Constants.VIDEO)
					.getAsJsonObject()));
		} else {
			this.setVideo(null);
		}
	}

	/**
	 * Accessor for the the actual UTF-8 text of the message.
	 * 
	 * @return the the actual UTF-8 text of the message
	 */
	public final String getText() {
		return this.text;
	}

	/**
	 * Mutator for the the actual UTF-8 text of the message.
	 * 
	 * @param content
	 *            the the actual UTF-8 text of the message
	 */
	public final void setText(final String content) {
		this.text = content;
	}

	/**
	 * Accessor for the audio file attached to the message.
	 * 
	 * @return the audio file attached to the message
	 */
	public final Audio getAudio() {
		return this.audio;
	}

	/**
	 * Mutator for the audio file attached to the message.
	 * 
	 * @param audioFile
	 *            the audio file attached to the message
	 */
	public final void setAudio(final Audio audioFile) {
		this.audio = audioFile;
	}

	/**
	 * Accessor for the document file attached to the message.
	 * 
	 * @return the document file attached to the message
	 */
	public final Document getDocument() {
		return this.document;
	}

	/**
	 * Mutator for the document file attached to the message.
	 * 
	 * @param doc
	 *            the document file attached to the message
	 */
	public final void setDocument(final Document doc) {
		this.document = doc;
	}

	/**
	 * Accessor for the photo file attached to the message.
	 * 
	 * @return the photo file attached to the message
	 */
	public final PhotoSize[] getPhoto() {
		final PhotoSize[] result = new PhotoSize[this.photo.length];
		System.arraycopy(this.photo, 0, result, 0, this.photo.length);
		return result;
	}

	/**
	 * Mutator for the photo file attached to the message.
	 * 
	 * @param photoFile
	 *            the photo file attached to the message
	 */
	public final void setPhoto(final PhotoSize... photoFile) {
		System.arraycopy(photoFile, 0, photo, 0, photoFile.length);
	}

	/**
	 * Accessor for the sticker attached to the message.
	 * 
	 * @return the sticker attached to the message
	 */
	public final Sticker getSticker() {
		return this.sticker;
	}

	/**
	 * Mutator for the sticker attached to the message.
	 * 
	 * @param stick
	 *            the sticker attached to the message
	 */
	public final void setSticker(final Sticker stick) {
		this.sticker = stick;
	}

	/**
	 * Accessor for the video attached to the message.
	 * 
	 * @return the video attached to the message
	 */
	public final Video getVideo() {
		return this.video;
	}

	/**
	 * Mutator for the video attached to the message.
	 * 
	 * @param videoFile
	 *            the video attached to the message
	 */
	public final void setVideo(final Video videoFile) {
		this.video = videoFile;
	}

	/**
	 * Accessor for the contact being shared.
	 * 
	 * @return the contact being shared
	 */
	public final Contact getContact() {
		return this.contact;
	}

	/**
	 * Mutator for the contact being shared.
	 * 
	 * @param sharedContact
	 *            the contact being shared
	 */
	public final void setContact(final Contact sharedContact) {
		this.contact = sharedContact;
	}

	/**
	 * Accessor for the location being shared.
	 * 
	 * @return the location being shared
	 */
	public final Location getLocation() {
		return this.location;
	}

	/**
	 * Mutator for the location being shared.
	 * 
	 * @param loc
	 *            the location being shared
	 */
	public final void setLocation(final Location loc) {
		this.location = loc;
	}
}