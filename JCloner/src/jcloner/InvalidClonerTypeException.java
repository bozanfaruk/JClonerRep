package jcloner;

/**
 * Invalid cloner type exception.
 * 
 * @author Faruk BOZAN
 * @since 15.5.7
 * @version 15.5.7
 *
 */
public class InvalidClonerTypeException extends Exception {

	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor with no parameter.
	 */
	public InvalidClonerTypeException() {
		super("Invalid cloner type. Check your cloner type parameter value!");
	}
}
