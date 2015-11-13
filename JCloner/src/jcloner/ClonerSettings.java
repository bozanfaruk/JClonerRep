package jcloner;

/**
 * Cloner settings class for clone operations.
 * 
 * @author Faruk BOZAN
 * @since 15.5.9
 * @version 15.11.13
 *
 */
public class ClonerSettings {

	/**
	 * Setting for deleting temporary file on FileBasedCloner class.
	 */
	private static boolean deleteCloneFile = true;

	/**
	 * File name for FileBasedCloner class.
	 */
	private static String fileName = "cloner.jcloner";

	/**
	 * Socket host for SocketBasedCloner.
	 */
	private static String socketHost = "127.0.0.1";

	/**
	 * Socket port for SocketBasedCloner.
	 */
	private static int socketPort = 14725;

	/**
	 * Gets setting for deleting temporary file on FileBasedCloner class.
	 * 
	 * @return Setting for deleting temporary file on FileBasedCloner class.
	 */
	public static boolean isDeleteCloneFile() {
		return deleteCloneFile;
	}

	/**
	 * Sets setting for deleting temporary file on FileBasedCloner class.
	 * 
	 * @param deleteCloneFile
	 *            Setting for deleting temporary file on FileBasedCloner class.
	 */
	public static void setDeleteCloneFile(boolean deleteCloneFile) {
		ClonerSettings.deleteCloneFile = deleteCloneFile;
	}

	/**
	 * Gets file name for FileBasedCloner class.
	 * 
	 * @return File name for FileBasedCloner class.
	 */
	public static String getFileName() {
		return fileName;
	}

	/**
	 * Sets file name for FileBasedCloner class.
	 * 
	 * @param fileName
	 *            File name for FileBasedCloner class.
	 */
	public static void setFileName(String fileName) {
		ClonerSettings.fileName = fileName;
	}

	/**
	 * Gets socket host for SocketBasedCloner.
	 * 
	 * @return Socket host for SocketBasedCloner.
	 */
	public static String getSocketHost() {
		return socketHost;
	}

	/**
	 * Sets socket host for SocketBasedCloner.
	 * 
	 * @param socketHost
	 *            Socket host for SocketBasedCloner.
	 */
	public static void setSocketHost(String socketHost) {
		ClonerSettings.socketHost = socketHost;
	}

	/**
	 * Gets socket port for SocketBasedCloner.
	 * 
	 * @return Socket port for SocketBasedCloner.
	 */
	public static int getSocketPort() {
		return socketPort;
	}

	/**
	 * Sets socket port for SocketBasedCloner.
	 * 
	 * @param socketPort
	 *            Socket port for SocketBasedCloner.
	 */
	public static void setSocketPort(int socketPort) {
		ClonerSettings.socketPort = socketPort;
	}

}
