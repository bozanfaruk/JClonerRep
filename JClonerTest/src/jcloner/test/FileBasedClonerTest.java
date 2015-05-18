package jcloner.test;

import jcloner.ClonerException;
import jcloner.ClonerFactory;
import jcloner.ClonerTypes;
import jcloner.ICloner;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class FileBasedClonerTest {

	private static ICloner fileBasedCloner = null;
	private static SourceObject sourceObject = null;
	private static ClonerFactory factory = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		factory = new ClonerFactory();
		fileBasedCloner = factory.createCloner(ClonerTypes.FILE_BASED_CLONER);
		sourceObject = new SourceObject();
		sourceObject.addObjectToList(new SourceListObject("Object 1"));
		sourceObject.addObjectToList(new SourceListObject("Object 2"));
	}

	@Test
	public void testFileBasedClonerForObject() throws ClonerException {
		SourceObject newObject = (SourceObject) fileBasedCloner.clone(sourceObject);
		Assert.assertTrue(newObject != sourceObject);
	}

	@Test
	public void testFileBasedClonerForObjectList() throws ClonerException {
		SourceObject newObject = (SourceObject) fileBasedCloner.clone(sourceObject);
		Assert.assertTrue(newObject.getList() != sourceObject.getList());
	}

}
