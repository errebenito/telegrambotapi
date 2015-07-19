package io.github.errebenito.telegrambotapi.objects;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.github.errebenito.telegrambotapi.util.Constants;

/**
 * This class represents a custom keyboard with reply options.
 * 
 * @author Raúl Benito
 *
 */
public class ReplyKeyboardMarkup extends SelectiveObject {



	/**
	 * Array of button rows, each represented by an Array of Strings.
	 */
	@Expose
	@SerializedName(Constants.KEYBOARD)
	private String[][] keyboard;

	/**
	 * Requests clients to resize the keyboard vertically for optimal fit.
	 * Optional.
	 */
	@Expose
	@SerializedName(Constants.RESIZE_KEYBOARD)
	private Boolean resizeKeyboard;

	/**
	 * Requests clients to hide the keyboard as soon as it's been used.
	 */
	@Expose
	@SerializedName(Constants.ONE_TIME_KEYBOARD)
	private Boolean oneTimeKeyboard;

	/**
	 * 
	 * Class constructor.
	 * 
	 * @param object
	 *            The JsonObject from which the ReplyKeyboardMarkup will be
	 *            constructed
	 */
	public ReplyKeyboardMarkup(final JsonObject object) {
		super(object);
		final int firstSize = object.get(Constants.KEYBOARD)
				.getAsJsonArray().size();
		final String[][] tempKeyboard = new String[firstSize][];
		for (int i = 0; i < firstSize; i++) {
			final int secondSize = object.get(Constants.KEYBOARD)
					.getAsJsonArray().get(i).getAsJsonArray().size();
			for (int j = 0; j < secondSize; j++) {
				tempKeyboard[i][j] = object.get(Constants.KEYBOARD)
						.getAsJsonArray().get(i).getAsJsonArray().get(j)
						.getAsString();
			}
		}
		this.setKeyboard(tempKeyboard);
		if (object.has(Constants.RESIZE_KEYBOARD)) {
			this.setResizeKeyboard(object.get(Constants.RESIZE_KEYBOARD)
					.getAsBoolean());
		} 		
		if (object.has(Constants.ONE_TIME_KEYBOARD)) {
			this.setOneTimeKeyboard(object.get(Constants.ONE_TIME_KEYBOARD)
					.getAsBoolean());
		} 
	}

	/**
	 * Accessor for the keyboard.
	 * 
	 * @return the keyboard
	 */
	public final String[][] getKeyboard() {
		final String[][] result = new String[keyboard.length][];
		for (int i = 0; i < keyboard.length; i++) {
			System.arraycopy(keyboard[i], 0, result[i], 0, 
					keyboard[0].length);
		}
		return result;

	}

	/**
	 * Mutator for the keyboard.
	 * 
	 * @param newKeyboard
	 *            the keyboard
	 */
	public final void setKeyboard(final String[]... newKeyboard) {
		for (int i = 0; i < keyboard.length; i++) {
			System.arraycopy(newKeyboard[i], 0, keyboard[i], 0, 
					newKeyboard[0].length);
		}
	}

	/**
	 * Accessor for the resize keyboard field.
	 * 
	 * @return <em>true</em> if the keyobard must be resized; 
	 *         <em>false</em> otherwise
	 */
	public final Boolean getResizeKeyboard() {
		return this.resizeKeyboard;
	}

	/**
	 * Mutator for the resize keyboard field.
	 * 
	 * @param resize
	 *            <em>true</em> if the keyobard must be resized; 
	 *            <em>false</em> otherwise
	 */
	public final void setResizeKeyboard(final Boolean resize) {
		this.resizeKeyboard = resize;
	}

	/**
	 * Accessor for the one time keyboard field.
	 * 
	 * @return <em>true</em> if the keyboard must be hidden after it's used; 
	 *         <em>false</em> otherwise
	 */
	public final Boolean getOneTimeKeyboard() {
		return this.oneTimeKeyboard;
	}

	/**
	 * Mutator for the one time keyboard field.
	 * 
	 * @param oneTime
	 *            <em>true</em> if the keyboard must be hidden after it's 
	 *            used; <em>false</em> otherwise
	 */
	public final void setOneTimeKeyboard(final Boolean oneTime) {
		this.oneTimeKeyboard = oneTime;
	}
}
