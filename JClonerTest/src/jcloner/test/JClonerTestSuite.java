package jcloner.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ByteBasedClonerTest.class, FileBasedClonerTest.class, SocketBasedClonerTest.class, ClonerFactoryTest.class })
public class JClonerTestSuite {

}
