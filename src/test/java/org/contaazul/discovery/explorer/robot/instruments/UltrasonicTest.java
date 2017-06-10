package org.contaazul.discovery.explorer.robot.instruments;

import org.contaazul.discovery.explorer.planet.Mars;
import org.contaazul.discovery.explorer.planet.Planet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UltrasonicTest {
	
	Ultrasonic ultrasonicInstrument;
	
	@Before
	public void setup() {
		Planet mars = Mars.newInstance();
		ultrasonicInstrument = new Ultrasonic(mars);
	}
	
	@Test
	public void testUltrasonicNotNull() {
		Assert.assertNotNull(ultrasonicInstrument);
	}
	
	@Test
	public void testCheckIfInBounds() {
		Assert.assertTrue(ultrasonicInstrument.checkTerrainBounds(1, 1));
	}
	
	@Test
	public void testCheckIfOutOfBounds() {
		Assert.assertFalse(ultrasonicInstrument.checkTerrainBounds(6, 6));
	}


}
