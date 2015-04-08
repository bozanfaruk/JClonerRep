package jcloner.test;

import jcloner.ClonerException;
import jcloner.ICloner;
import jcloner.SocketBasedCloner;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class SocketBasedClonerTest {

	private static ICloner socketBasedCloner = null;
	private static SourceObject sourceObject = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		socketBasedCloner = new SocketBasedCloner();
		sourceObject = new SourceObject();
		sourceObject.addObjectToList(new SourceListObject("Object 1"));
		sourceObject.addObjectToList(new SourceListObject("Object 2"));
	}

	@Test
	public void testSocketBasedClonerForObject() throws ClonerException {
		SourceObject newObject = (SourceObject) socketBasedCloner.clone(sourceObject);
		Assert.assertTrue(newObject != sourceObject);
	}

	@Test
	public void testSocketBasedClonerForObjectList() throws ClonerException {
		SourceObject newObject = (SourceObject) socketBasedCloner.clone(sourceObject);
		Assert.assertTrue(newObject.getList() != sourceObject.getList());
	}

}
