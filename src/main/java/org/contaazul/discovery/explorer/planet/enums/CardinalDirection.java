package org.contaazul.discovery.explorer.planet.enums;

public enum CardinalDirection {
	
	NORTH("N"), 
	SOUTH("S"), 
	WEST("W"), 
	EAST("E");
	
	private String symbol;
	
	private CardinalDirection(String symbol) {
		this.symbol = symbol;
	}
	
	public String getSymbol() {
		return symbol;
	}

}
