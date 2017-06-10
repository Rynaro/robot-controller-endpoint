package org.contaazul.discovery.explorer.planet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.contaazul.discovery.explorer.planet.Mars;

public class MarsTest {

	Planet mars;
	
	@Before
	public void setup() {
		mars = Mars.newInstance();		
	}

	@Test
	public void testMarsIsAPlanetInstance() {
		Assert.assertNotNull(mars);
	}	
	
	@Test
	public void testMarsXBoundLimit() {
		Assert.assertEquals(5, mars.getXBound());
	}
	
	@Test
	public void testMarsYBoundLimit() {
		Assert.assertEquals(5, mars.getYBound());
	}
	
	@Test
	public void testMarsTerrainChanges() {
		mars.setTerrainBounds(7, 4);
		Assert.assertEquals(7, mars.getXBound());
		Assert.assertEquals(4, mars.getYBound());
	}
	
	
}
