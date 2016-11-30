package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.HelloJUnitTest;
import test.TrackingServiceTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	HelloJUnitTest.class, 
	TrackingServiceTest.class
})
public class ProteinTrackerSuit {

}
