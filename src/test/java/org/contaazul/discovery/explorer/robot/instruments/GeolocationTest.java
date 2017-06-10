package org.contaazul.discovery.explorer.robot.instruments;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class GeolocationTest {

	Geolocation<Integer, Integer> geolocationInstrument;
	
	@Before
	public void setup() {
		geolocationInstrument = new Geolocation<Integer, Integer>(0, 0);
	}

	@Test
	public void testGeolocationNotNull() {
		Assert.assertNotNull(geolocationInstrument);
	}

	@Test
	public void testGetXCoordinates() {
		Assert.assertEquals(0, geolocationInstrument.getXCoordinates().intValue());					
	}
	
	@Test
	public void testGetYCoordinates() {
		Assert.assertEquals(0, geolocationInstrument.getYCoordinates().intValue());					
	}
	
	@Test
	public void testRelocatization() {
		geolocationInstrument.relocalize(7, 8);
		Assert.assertEquals(7, geolocationInstrument.getXCoordinates().intValue());
		Assert.assertEquals(8, geolocationInstrument.getYCoordinates().intValue());				
	}
	
	@Test
	public void testStringfyCoordinates() {		
		Assert.assertEquals("0, 0", geolocationInstrument.toString());				
	}
	
	
}
