package org.contaazul.discovery.explorer.robot.instruments;

import java.util.ArrayList;

import org.contaazul.discovery.explorer.planet.enums.CardinalDirection;

public class Magnometer extends ArrayList<CardinalDirection> {
	
	private static final long serialVersionUID = 1L;
	
	private int currentRotationIndex;
	
	public Magnometer() {
		currentRotationIndex = 0;
		initializeCardinalSystem();
	}
	
	public CardinalDirection actualMagnometerSpot() {
		return this.get(currentRotationIndex);
	}
	
	public void rotate(String direction) {
		if (direction.equals("R")) {
			currentRotationIndex++;
		} else if (direction.equals("L")) {
			currentRotationIndex--;			
		}
		adjustmentOnRotationIndex();
	}
	
	private void initializeCardinalSystem() {
		this.add(0, CardinalDirection.NORTH);
		this.add(1, CardinalDirection.EAST);
		this.add(2, CardinalDirection.SOUTH);
		this.add(3, CardinalDirection.WEST);
	}
	
	private void adjustmentOnRotationIndex() {
		if (currentRotationIndex == this.size()) {
			currentRotationIndex = 0;
		} else if (currentRotationIndex == -1) {
			currentRotationIndex = this.size() - 1;
		}
	}

}
