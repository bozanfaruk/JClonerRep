package jcloner.test;

import jcloner.ByteBasedCloner;
import jcloner.ClonerException;
import jcloner.ICloner;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ByteBasedClonerTest {

	private static ICloner byteBasedCloner = null;
	private static SourceObject sourceObject = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		byteBasedCloner = new ByteBasedCloner();
		sourceObject = new SourceObject();
		sourceObject.addObjectToList(new SourceListObject("Object 1"));
		sourceObject.addObjectToList(new SourceListObject("Object 2"));
	}

	@Test
	public void testByteBasedClonerForObject() throws ClonerException {
		SourceObject newObject = (SourceObject) byteBasedCloner.clone(sourceObject);
		Assert.assertTrue(newObject != sourceObject);
	}

	@Test
	public void testByteBasedClonerForObjectList() throws ClonerException {
		SourceObject newObject = (SourceObject) byteBasedCloner.clone(sourceObject);
		Assert.assertTrue(newObject.getList() != sourceObject.getList());
	}

}
