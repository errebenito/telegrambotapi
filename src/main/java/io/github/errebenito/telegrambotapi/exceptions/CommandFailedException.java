package io.github.errebenito.telegrambotapi.exceptions;

/**
 * Exception thrown when the execution of a command fails.
 * 
 * @author Raúl Benito
 *
 */
public class CommandFailedException extends Exception {

	/**
	 * Generated ID.
	 */
	private static final long serialVersionUID = 5322843102611087203L;

	/**
	 * 
	 * Class constructor.
	 * 
	 * @param message
	 *            The error message to display.
	 */
	public CommandFailedException(final String message) {
		super(message);
	}

	/**
	 * 
	 * Class constructor.
	 * 
	 * @param e
	 *            The exception that fired the CommandFailedException.
	 */
	public CommandFailedException(final Exception e) {
		super(e);
	}
}
