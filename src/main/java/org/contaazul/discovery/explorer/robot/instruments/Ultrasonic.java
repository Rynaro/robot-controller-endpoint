package org.contaazul.discovery.explorer.robot.instruments;

import org.contaazul.discovery.explorer.planet.Planet;

public class Ultrasonic {
	
	int xAxisBound;
	int yAxisBound;
	
	public Ultrasonic(Planet planet) {
		xAxisBound = planet.getXBound();
		yAxisBound = planet.getYBound();
	}
	
	public boolean checkTerrainBounds(int x, int y) {
		return ((xAxisBound >= x) && (yAxisBound >= y));
	}

}
