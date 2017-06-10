package org.contaazul.discovery.explorer.robot;

import org.contaazul.discovery.explorer.robot.instruments.GeolocationTest;
import org.contaazul.discovery.explorer.robot.instruments.MagnometerTest;
import org.contaazul.discovery.explorer.robot.instruments.UltrasonicTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	RobotHoverTest.class,
	GeolocationTest.class,
	MagnometerTest.class,
	UltrasonicTest.class
})
public class RobotTestSuite { }
