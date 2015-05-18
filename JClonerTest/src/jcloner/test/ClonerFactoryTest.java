package jcloner.test;

import jcloner.ByteBasedCloner;
import jcloner.ClonerFactory;
import jcloner.ClonerTypes;
import jcloner.FileBasedCloner;
import jcloner.ICloner;
import jcloner.InvalidClonerTypeException;
import jcloner.SocketBasedCloner;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ClonerFactoryTest {

	private static ClonerFactory factory = null;
	private static ByteBasedCloner bbc = null;
	private static FileBasedCloner fbc = null;
	private static SocketBasedCloner sbc = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		factory = new ClonerFactory();
		bbc = new ByteBasedCloner();
		fbc = new FileBasedCloner();
		sbc = new SocketBasedCloner();
	}

	@Test
	public void testCreateByteBasedCloner() throws InvalidClonerTypeException {
		ICloner tempCloner = factory.createCloner(ClonerTypes.BYTE_BASED_CLONER);
		Assert.assertTrue(tempCloner.getClass() == bbc.getClass());
	}

	@Test
	public void testCreateFileBasedCloner() throws InvalidClonerTypeException {
		ICloner tempCloner = factory.createCloner(ClonerTypes.FILE_BASED_CLONER);
		Assert.assertTrue(tempCloner.getClass() == fbc.getClass());
	}

	@Test
	public void testCreateSocketBasedCloner() throws InvalidClonerTypeException {
		ICloner tempCloner = factory.createCloner(ClonerTypes.SOCKET_BASED_CLONER);
		Assert.assertTrue(tempCloner.getClass() == sbc.getClass());
	}

	@Test(expected = InvalidClonerTypeException.class)
	public void testCreateNullCloner() throws InvalidClonerTypeException {
		ICloner tempCloner = factory.createCloner(ClonerTypes.INVALID_CLONER);
		Assert.assertNull(tempCloner);
	}

}
