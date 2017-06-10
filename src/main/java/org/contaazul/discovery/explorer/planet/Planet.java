package org.contaazul.discovery.explorer.planet;

public abstract class Planet {
	
	private static int xBound;
	private static int yBound;
	
	public void setTerrainBounds(int x, int y) {
		xBound = x;
		yBound = y;
	}
	
	public int getYBound() {
		return yBound;
	}
	
	public int getXBound() {
		return xBound;
	}
	
}
