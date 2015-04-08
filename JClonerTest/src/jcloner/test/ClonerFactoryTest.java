package jcloner.test;

import jcloner.ByteBasedCloner;
import jcloner.ClonerFactory;
import jcloner.FileBasedCloner;
import jcloner.ICloner;
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
	public void testCreateByteBasedCloner() {
		ICloner tempCloner = factory.createCloner(ClonerFactory.BYTE_BASED_CLONER);
		Assert.assertTrue(tempCloner.getClass() == bbc.getClass());
	}

	@Test
	public void testCreateFileBasedCloner() {
		ICloner tempCloner = factory.createCloner(ClonerFactory.FILE_BASED_CLONER);
		Assert.assertTrue(tempCloner.getClass() == fbc.getClass());
	}

	@Test
	public void testCreateSocketBasedCloner() {
		ICloner tempCloner = factory.createCloner(ClonerFactory.SOCKET_BASED_CLONER);
		Assert.assertTrue(tempCloner.getClass() == sbc.getClass());
	}

	@Test
	public void testCreateNullCloner() {
		ICloner tempCloner = factory.createCloner(Integer.MAX_VALUE);
		Assert.assertNull(tempCloner);
	}

}
