package io.github.errebenito.telegrambotapi.util.dto;

import io.github.errebenito.telegrambotapi.util.Constants;

/**
 * This class represents a method URL.
 * @author Raúl Benito
 *
 */
public class MethodUrl {

	
	/**
	 * The part of the url specific to the method.
	 */
	private final transient String url;
	
	/**
	 * 
	 * Class constructor.
	 * @param token The bot's token.
	 * @param method The part of the url specific to the method.
	 */
	public MethodUrl(final String token, final String method) {
		this.url = Constants.BASE_URL + token + method;
	}

	/**
	 * Produces a string representation of the method URL.
	 * @return the method URL
	 */
	public final String toString() {
		return this.url;
	}

}
