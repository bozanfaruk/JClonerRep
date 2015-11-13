package jcloner;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * This class is byte based object cloner. Source object converts to byte array
 * and then new object is created from this new byte array.
 * 
 * @author Faruk BOZAN
 * @since 15.4.3
 * @version 15.11.13
 *
 */
public class ByteBasedCloner implements ICloner {

	/**
	 * Creates a byte array by using output stream.
	 * 
	 * @param sourceObject
	 *            Source object to clone.
	 * @return Byte array of source object.
	 * @throws IOException
	 *             Throws when an exception occurs during stream operation.
	 */
	private byte[] createByteArray(Object sourceObject) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		byte[] byteArray = null;
		try {
			oos.writeObject(sourceObject);
			oos.flush();
			byteArray = baos.toByteArray();
		} finally {
			oos.close();
		}

		return byteArray;
	}

	/**
	 * Creates a new object due to byte array.
	 * 
	 * @param byteArray
	 *            New object data.
	 * @return New object based on byte array.
	 * @throws IOException
	 *             Throws when an exception occurs during stream operation.
	 * @throws ClassNotFoundException
	 *             Throws when an exception occurs during class stream
	 *             operation.
	 */
	private Object createNewObject(byte[] byteArray) throws IOException, ClassNotFoundException {
		ByteArrayInputStream bais = new ByteArrayInputStream(byteArray);
		ObjectInputStream ois = new ObjectInputStream(bais);
		Object newObject = null;
		try {
			newObject = ois.readObject();
		} finally {
			ois.close();
		}
		return newObject;
	}

	@Override
	public Object clone(Object sourceObject) throws ClonerException {
		try {
			byte[] byteArray = createByteArray(sourceObject);
			Object newObject = createNewObject(byteArray);
			return newObject;
		} catch (IOException e) {
			throw new ClonerException(e);
		} catch (ClassNotFoundException e) {
			throw new ClonerException(e);
		}
	}

}
