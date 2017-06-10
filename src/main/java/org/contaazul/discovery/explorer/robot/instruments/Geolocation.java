package org.contaazul.discovery.explorer.robot.instruments;

public class Geolocation<X, Y> {

	private X x;
	private Y y;
	
	public Geolocation(X x, Y y) {
		this.x = x;
		this.y = y;
	}
	
	public void relocalize(X x, Y y) {
		this.x = x;
		this.y = y;		
	}
	
	public X getXCoordinates() {
		return x;
	}

	public Y getYCoordinates() {
		return y;
	}
	
	public String toString() {
		return String.format("%s, %s", x, y);
	}
}
