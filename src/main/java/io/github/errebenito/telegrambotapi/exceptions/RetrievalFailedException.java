package io.github.errebenito.telegrambotapi.exceptions;

/**
 * Exception thrown when the retrieval of an entity fails.
 * 
 * @author Raúl Benito
 *
 */
public class RetrievalFailedException extends Exception {

	/**
	 * Generated ID.
	 */
	private static final long serialVersionUID = 4693006789282082552L;

	/**
	 * 
	 * Class constructor.
	 * 
	 * @param message
	 *            The error message to display.
	 */
	public RetrievalFailedException(final String message) {
		super(message);
	}

	/**
	 * 
	 * Class constructor.
	 * 
	 * @param e
	 *            The exception that fired the CommandFailedException.
	 */
	public RetrievalFailedException(final Exception e) {
		super(e);
	}

}
