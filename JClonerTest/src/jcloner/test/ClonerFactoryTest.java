package jcloner.test;

import jcloner.ByteBasedCloner;
import jcloner.ClonerFactory;
import jcloner.FileBasedCloner;
import jcloner.ICloner;
import jcloner.SocketBasedCloner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
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

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateCloner() {
		ICloner tempCloner = factory.createCloner(ClonerFactory.BYTE_BASED_CLONER);
		Assert.assertTrue(tempCloner.getClass() == bbc.getClass());
		tempCloner = factory.createCloner(ClonerFactory.FILE_BASED_CLONER);
		Assert.assertTrue(tempCloner.getClass() == fbc.getClass());
		tempCloner = factory.createCloner(ClonerFactory.SOCKET_BASED_CLONER);
		Assert.assertTrue(tempCloner.getClass() == sbc.getClass());
		tempCloner = factory.createCloner(Integer.MAX_VALUE);
		Assert.assertNull(tempCloner);
	}

}
