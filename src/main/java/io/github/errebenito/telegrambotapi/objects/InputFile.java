package io.github.errebenito.telegrambotapi.objects;

import java.io.File;

/**
 * This class represents the contents of a file to be uploaded.
 * 
 * @author Raúl Benito
 *
 */
public class InputFile {

	/**
	 * The file to be uploaded.
	 */
	private File file;

	/**
	 * 
	 * Class constructor.
	 * 
	 * @param path
	 *            The local path to the file that will be uploaded.
	 */
	public InputFile(final String path) {
		this.file = new File(path);
	}

	/**
	 * Accessor for the file to be uploaded.
	 * 
	 * @return the file to be uploaded
	 */
	public final File getFile() {
		return this.file;
	}

	/**
	 * Mutator for the file to be uploaded.
	 * 
	 * @param newFile
	 *            the file to be uploaded
	 */
	public final void setFile(final File newFile) {
		this.file = newFile;
	}
}
