package io.github.errebenito.telegrambotapi.objects;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.github.errebenito.telegrambotapi.util.Constants;

/**
 * This class represents a contact.
 * @author Raúl Benito
 *
 */
public class Contact {

	/**
	 * Contact's phone number.
	 */
	@Expose
	@SerializedName(Constants.PHONE_NUMBER)
	private String phoneNumber;

	/**
	 * Contact's first name.
	 */
	@Expose
	@SerializedName(Constants.FIRST_NAME)
	private String firstName;

	/**
	 * Contact's last name. Optional.
	 */
	@Expose
	@SerializedName(Constants.LAST_NAME)
	private String lastName;

	/**
	 * Contact's user identifier in Telegram. Optional.
	 */
	@Expose
	@SerializedName(Constants.USER_ID)
	private String userId;

	/**
	 * 
	 * Class constructor.
	 * 
	 * @param object
	 *            The JsonObject from which the Contact will be constructed.
	 */
	public Contact(final JsonObject object) {
		this.setPhoneNumber(object.get(Constants.PHONE_NUMBER).getAsString());
		this.setFirstName(object.get(Constants.FIRST_NAME).getAsString());
		if (object.has(Constants.LAST_NAME)) {
			this.setLastName(object.get(Constants.LAST_NAME).getAsString());
		}
		if (object.has(Constants.USER_ID)) {
			this.setUserId(object.get(Constants.USER_ID).getAsString());
		} 
	}

	/**
	 * Class constructor.
	 */
	public Contact() {
		this.setFirstName(null);
		this.setLastName(null);
		this.setPhoneNumber(null);
		this.setUserId(null);
	}

	/**
	 * Accessor for the contact's phone number.
	 * 
	 * @return the contact's phone number
	 */
	public final String getPhoneNumber() {
		return this.phoneNumber;
	}

	/**
	 * Mutator for the contact's phone number.
	 * 
	 * @param phone
	 *            the contact's phone number
	 */
	public final void setPhoneNumber(final String phone) {
		this.phoneNumber = phone;
	}

	/**
	 * Accessor for the contact's first name.
	 * 
	 * @return the contact's first name
	 */
	public final String getFirstName() {
		return this.firstName;
	}

	/**
	 * Mutator for the contact's first name.
	 * 
	 * @param contactFirstName
	 *            the contact's first name
	 */
	public final void setFirstName(final String contactFirstName) {
		this.firstName = contactFirstName;
	}

	/**
	 * Accessor for the contact's last name.
	 * 
	 * @return the contact's last name
	 */
	public final String getLastName() {
		return this.lastName;
	}

	/**
	 * Mutator for the contact's last name.
	 * 
	 * @param contactLastName
	 *            the contact's last name
	 */
	public final void setLastName(final String contactLastName) {
		this.lastName = contactLastName;
	}

	/**
	 * Accessor for the contact's user id.
	 * 
	 * @return the contact's user id
	 */
	public final String getUserId() {
		return this.userId;
	}

	/**
	 * Mutator for the contact's user id.
	 * 
	 * @param ident
	 *            the contact's user id
	 */
	public final void setUserId(final String ident) {
		this.userId = ident;
	}

}
