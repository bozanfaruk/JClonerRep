package jcloner;

/**
 * Cloner exception.
 * 
 * @author Faruk BOZAN
 * @since 15.4.5
 * @version 15.4.26
 *
 */
public class ClonerException extends Exception {

	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Single parameter constructor.
	 * 
	 * @param e
	 *            Exception instance.
	 */
	public ClonerException(Exception e) {
		super("An exception occurs during clone operation", e);
	}

}
