package jcloner;

/**
 * Factory class to create cloner instance due to parameter value.
 * 
 * @author Faruk BOZAN
 * @since 15.4.8
 * @version 15.4.26
 *
 */
public class ClonerFactory {

	/**
	 * Byte based cloner type.
	 */
	public static final int BYTE_BASED_CLONER = 1;

	/**
	 * File based cloner type.
	 */
	public static final int FILE_BASED_CLONER = 2;

	/**
	 * Socket based cloner type.
	 */
	public static final int SOCKET_BASED_CLONER = 3;

	/**
	 * Creates a ICloner instance by using cloner type parameter.
	 * 
	 * @param clonerType
	 *            Cloner type. Use fields of this class.
	 * @return ICloner instance due to cloner type. If cloner type is invalid
	 *         returns null.
	 */
	public ICloner createCloner(int clonerType) {
		switch (clonerType) {
		case BYTE_BASED_CLONER:
			return new ByteBasedCloner();
		case FILE_BASED_CLONER:
			return new FileBasedCloner();
		case SOCKET_BASED_CLONER:
			return new SocketBasedCloner();
		}
		return null;
	}
}
