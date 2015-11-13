package jcloner;

/**
 * This interface is wrapper for cloner classes and operations.
 * 
 * @author Faruk BOZAN
 * @since 15.4.3
 * @version 15.11.13
 *
 */
public interface ICloner {

	/**
	 * Clones source object to return object.
	 * 
	 * @param sourceObject
	 *            Source object to clone.
	 * @return Clone of source object.
	 * @throws ClonerException
	 *             Throws when a clone exception occurs.
	 */
	public Object clone(Object sourceObject) throws ClonerException;

}
