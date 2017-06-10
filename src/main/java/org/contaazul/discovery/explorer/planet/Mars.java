package org.contaazul.discovery.explorer.planet;

public class Mars extends Planet {
	
	private Mars() {
		setTerrainBounds(5, 5);
	}
	
	public static Mars newInstance() {
		return new Mars();
	}

}
