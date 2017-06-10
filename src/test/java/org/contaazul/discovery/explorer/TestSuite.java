package org.contaazul.discovery.explorer;

import org.contaazul.discovery.explorer.api.controller.ApiControllerTestSuite;
import org.contaazul.discovery.explorer.planet.PlanetTestSuite;
import org.contaazul.discovery.explorer.robot.RobotTestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	ApiControllerTestSuite.class,
	PlanetTestSuite.class,
	RobotTestSuite.class
})

public class TestSuite { }
