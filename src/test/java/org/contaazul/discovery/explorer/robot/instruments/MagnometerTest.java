package org.contaazul.discovery.explorer.robot.instruments;

import org.contaazul.discovery.explorer.planet.enums.CardinalDirection;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MagnometerTest {

	Magnometer magnometerInstrument;
	
	@Before
	public void setup() {
		magnometerInstrument = new Magnometer();
	}
	
	@Test
	public void testMagnometerNotNull() {
		Assert.assertNotNull(magnometerInstrument);
	}
	
	@Test
	public void testMagnometerInitialSpot() {
		Assert.assertEquals(CardinalDirection.NORTH, magnometerInstrument.actualMagnometerSpot());
	}

	@Test
	public void testRotateMagnometerToWest() {
		magnometerInstrument.rotate("L");
		Assert.assertEquals(CardinalDirection.WEST, magnometerInstrument.actualMagnometerSpot());
	}

	@Test
	public void testRotateMagnometerToEast() {
		magnometerInstrument.rotate("R");
		Assert.assertEquals(CardinalDirection.EAST, magnometerInstrument.actualMagnometerSpot());
	}

	@Test
	public void testRotateMagnometerToSouth() {
		magnometerInstrument.rotate("R");
		magnometerInstrument.rotate("R");
		Assert.assertEquals(CardinalDirection.SOUTH, magnometerInstrument.actualMagnometerSpot());
	}
	

	@Test
	public void testRotateMagnometerToNorth() {
		magnometerInstrument.rotate("R");
		magnometerInstrument.rotate("L");
		Assert.assertEquals(CardinalDirection.NORTH, magnometerInstrument.actualMagnometerSpot());
	}
	
	
}
