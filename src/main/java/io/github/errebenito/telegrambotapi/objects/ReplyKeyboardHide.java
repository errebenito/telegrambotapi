package io.github.errebenito.telegrambotapi.objects;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.github.errebenito.telegrambotapi.util.Constants;

/**
 * This class represents a way to force custom keyboards to hide, displaying the
 * standard keyboard instead.
 * 
 * @author Raúl Benito
 *
 */
public class ReplyKeyboardHide extends SelectiveObject {

	/**
	 * Requests clients to hide the keyboard.
	 */
	@Expose
	@SerializedName(Constants.HIDE_KEYBOARD)
	private Boolean hideKeyboard;

	/**
	 * 
	 * Class constructor.
	 * 
	 * @param object
	 *            The JsonObject from which the ReplyKeyboardHide will be
	 *            constructed.
	 */
	public ReplyKeyboardHide(final JsonObject object) {
		super(object);
		this.setHideKeyboard(object.get(Constants.HIDE_KEYBOARD)
				.getAsBoolean());
	}

	/**
	 * Accessor for the hide keyboard field.
	 * 
	 * @return <em>true</em> if the keyboard must be hidden; 
	 * 		   <em>false</em> otherwise
	 */
	public final Boolean getHideKeyboard() {
		return this.hideKeyboard;
	}

	/**
	 * Mutator for the hide keyboard field.
	 * 
	 * @param hide
	 *            <em>true</em> if the keyboard must be hidden; 
	 *            <em>false</em> otherwise
	 */
	public final void setHideKeyboard(final Boolean hide) {
		this.hideKeyboard = hide;
	}
}
