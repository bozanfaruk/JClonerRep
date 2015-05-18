package jcloner;

/**
 * Factory class to create cloner instance due to parameter value.
 * 
 * @author Faruk BOZAN
 * @since 15.4.8
 * @version 15.5.18
 *
 */
public class ClonerFactory {

	/**
	 * Creates a ICloner instance by using cloner type parameter.
	 * 
	 * @param clonerType
	 *            Cloner type. Use fields of {@link jcloner.ClonerTypes}.
	 * @return ICloner instance due to cloner type.
	 * @throws InvalidClonerTypeException
	 *             Throws when clonerType parameter value is invalid.
	 */
	public ICloner createCloner(ClonerTypes clonerType) throws InvalidClonerTypeException {
		switch (clonerType) {
		case BYTE_BASED_CLONER:
			return new ByteBasedCloner();
		case FILE_BASED_CLONER:
			return new FileBasedCloner();
		case SOCKET_BASED_CLONER:
			return new SocketBasedCloner();
		case INVALID_CLONER:
			break;
		}
		throw new InvalidClonerTypeException();
	}
}
