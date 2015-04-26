package jcloner;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This class is network socket based cloner. Data is sent to socket and than is
 * read from socket again. Default host is localhost(127.0.0.1) and default port
 * is 14725.
 * 
 * @author Faruk BOZAN
 * @since 15.4.7
 * @version 15.4.26
 *
 */
public class SocketBasedCloner implements ICloner {

	/**
	 * Default host, localhost.
	 */
	private final String HOST = "127.0.0.1";

	/**
	 * Default port for socket.
	 */
	private final int PORT = 14725;

	/**
	 * Server socket.
	 */
	private Socket serverSocket = null;

	/**
	 * Socket.
	 */
	private Socket socket = null;

	/**
	 * Server socket instance.
	 */
	private ServerSocket serverSide;

	/**
	 * Gets server socket.
	 * 
	 * @return Server socket.
	 */
	private Socket getServerSocket() {
		return serverSocket;
	}

	/**
	 * Sets server socket.
	 * 
	 * @param serverSocket
	 *            Server socket.
	 */
	private void setServerSocket(Socket serverSocket) {
		this.serverSocket = serverSocket;
	}

	/**
	 * Gets socket.
	 * 
	 * @return Socket.
	 */
	private Socket getSocket() {
		return socket;
	}

	/**
	 * Sets socket.
	 * 
	 * @param socket
	 *            Socket.
	 */
	private void setSocket(Socket socket) {
		this.socket = socket;
	}

	/**
	 * Gets server side socket.
	 * 
	 * @return Server side socket.
	 */
	private ServerSocket getServerSide() {
		return serverSide;
	}

	/**
	 * Sets server side socket.
	 * 
	 * @param serverSide
	 *            Server side socket.
	 */
	private void setServerSide(ServerSocket serverSide) {
		this.serverSide = serverSide;
	}

	/**
	 * Creates and initializes sockets.
	 * 
	 * @throws IOException
	 *             Throws when an error occurs during initialization of sockets.
	 */
	private void initializeSockets() throws IOException {
		setServerSide(new ServerSocket(PORT));
		setSocket(new Socket(HOST, PORT));
	}

	/**
	 * Writes source object to socket.
	 * 
	 * @param sourceObject
	 *            Source object to clone.
	 * @throws IOException
	 *             Throws when an exception occurs during stream operations.
	 */
	private void writeToSocket(Object sourceObject) throws IOException {
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
		OutputStream os = getSocket().getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		try {
			dos.write(byteArray);
			dos.flush();
		} finally {
			dos.close();
		}
	}

	/**
	 * Reads source object from socket and creates new object.
	 * 
	 * @return New object instance.
	 * @throws IOException
	 *             Throws when an exception occurs during stream operations.
	 * @throws ClassNotFoundException
	 *             Throws when an exception occurs during class stream
	 *             operation.
	 */
	private Object readFromSocket() throws IOException, ClassNotFoundException {
		setServerSocket(getServerSide().accept());
		DataInputStream dis = new DataInputStream(getServerSocket().getInputStream());
		byte[] byteArray = new byte[dis.available()];
		try {
			dis.read(byteArray);
		} finally {
			dis.close();
		}
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

	/**
	 * Closes sockets.
	 * 
	 * @throws IOException
	 *             Throws when an exception occurs during closing sockets.
	 */
	private void closeSockets() throws IOException {
		getSocket().close();
		getServerSocket().close();
		getServerSide().close();
	}

	@Override
	public Object clone(Object sourceObject) throws ClonerException {
		try {
			initializeSockets();
			writeToSocket(sourceObject);
			Object newObject = readFromSocket();
			closeSockets();
			return newObject;
		} catch (IOException e) {
			throw new ClonerException(e);
		} catch (ClassNotFoundException e) {
			throw new ClonerException(e);
		}
	}
}
