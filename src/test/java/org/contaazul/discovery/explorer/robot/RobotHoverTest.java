package org.contaazul.discovery.explorer.robot;

import org.contaazul.discovery.explorer.exception.BadInstructionException;
import org.contaazul.discovery.explorer.exception.PlanetNotRecognizedException;
import org.contaazul.discovery.explorer.exception.TerrainOutOfBoundsException;
import org.contaazul.discovery.explorer.planet.Mars;
import org.contaazul.discovery.explorer.planet.Planet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RobotHoverTest {

	RobotHover robotHover;
	
	@Before
	public void setup() {
		Planet mars = Mars.newInstance();
		robotHover = RobotHover.land(mars);
	}
	
	@Test
	public void testRobotHoverMovementTurningToRight() {
		robotHover.move("MMRMMRMM");
		Assert.assertEquals("(2, 0, S)", robotHover.getActualSpot());
	}

	@Test
	public void testRobotHoverMovementTurningToLeft() {
		robotHover.move("MMRMMLMM");
		Assert.assertEquals("(2, 4, N)", robotHover.getActualSpot());
	}
	
	@Test
	public void testRobotHoverMovementWithFullInstructions() {
		robotHover.move("MMRMMLMMLM");
		Assert.assertEquals("(1, 4, W)", robotHover.getActualSpot());
	}	
	
	@Test(expected=BadInstructionException.class)
	public void testRobotHoverBadRequestMovementCommand() {
		robotHover.move("AAA");
	}

	@Test(expected=TerrainOutOfBoundsException.class)
	public void testRobotHoverOutOfBoundsMovementCommand() {
		robotHover.move("MMMMMMMMMMMMMMMMMMMMMMMM");
	}

	@Test(expected=PlanetNotRecognizedException.class)
	public void testRobotHoverNotLandedOnPlanet() {
		robotHover = RobotHover.land(null);	
	}

	
}
