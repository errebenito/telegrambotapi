package io.github.errebenito.telegrambotapi.objects;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.github.errebenito.telegrambotapi.util.Constants;

/**
 * This class represents a Telegram user or bot.
 * @author Raúl Benito
 *
 */
public class User extends ChatType {

	/**
	 * User‘s or bot’s first name.
	 */
	@Expose
	@SerializedName(Constants.FIRST_NAME)
	private String firstName;
		
	/**
	 * User‘s or bot’s last name. Optional. 
	 */
	@Expose
	@SerializedName(Constants.LAST_NAME)
	private String lastName;
	
	/**
	 * User‘s or bot’s username. Optional. 
	 */
	@Expose
	@SerializedName(Constants.USER_NAME)
	private String userName;
		
	/**
	 * 
	 * Class constructor.
	 * 
	 * @param object
	 *            The JsonObject from which the User will be constructed.
	 */
	public User(final JsonObject object) {
		super(object);
		this.setFirstName(object.get(Constants.FIRST_NAME).getAsString());
		if (object.has(Constants.LAST_NAME)) {
			this.setLastName(object.get(Constants.LAST_NAME).getAsString());
		} 
		if (object.has(Constants.USER_NAME)) {
			this.setUserName(object.get(Constants.USER_NAME).getAsString());
		} 
	}

	/**
	 * Class constructor.
	 */
	public User() {
		super();
		this.setFirstName(null);
		this.setLastName(null);
		this.setUserName(null);
	}

	/**
	 * Accessor for the user's first name. 
	 * @return the user's first name
	 */
	public final String getFirstName() {
		return this.firstName;
	}

	/**
	 * Mutator for the user's first name.
	 * @param userFirstName the user's first name
	 */
	public final void setFirstName(final String userFirstName) {
		this.firstName = userFirstName;
	}

	/**
	 * Accessor for the user's last name. 
	 * @return the user's last name
	 */
	public final String getLastName() {
		return this.lastName;
	}

	/**
	 * Mutator for the user's last name.
	 * @param userLastName the user's last name
	 */
	public final void setLastName(final String userLastName) {
		this.lastName = userLastName;
	}

	/**
	 * Accessor for the user's username. 
	 * @return the user's username
	 */
	public final String getUserName() {
		return this.userName;
	}

	/**
	 * Mutator for the  user's username.
	 * @param newUserName the user's username
	 */
	public final void setUserName(final String newUserName) {
		this.userName = newUserName;
	}
	
	
}
