package org.contaazul.discovery.explorer.planet.enums;

import org.junit.Assert;
import org.junit.Test;

public class CardinalDirectionTest {
	
	@Test
	public void getNorthSymbol() {
		Assert.assertEquals("N", CardinalDirection.NORTH.getSymbol());
	}

	
	@Test
	public void getEastSymbol() {
		Assert.assertEquals("E", CardinalDirection.EAST.getSymbol());
	}

	@Test
	public void getSouthSymbol() {
		Assert.assertEquals("S", CardinalDirection.SOUTH.getSymbol());
	}

	@Test
	public void getWestSymbol() {
		Assert.assertEquals("W", CardinalDirection.WEST.getSymbol());
	}

}
