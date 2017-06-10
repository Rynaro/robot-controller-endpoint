package org.contaazul.discovery.explorer.robot;

import java.util.List;

import org.contaazul.discovery.explorer.exception.BadInstructionException;
import org.contaazul.discovery.explorer.exception.PlanetNotRecognizedException;
import org.contaazul.discovery.explorer.exception.TerrainOutOfBoundsException;
import org.contaazul.discovery.explorer.planet.Planet;
import org.contaazul.discovery.explorer.planet.enums.CardinalDirection;
import org.contaazul.discovery.explorer.robot.instruments.Geolocation;
import org.contaazul.discovery.explorer.robot.instruments.Magnometer;
import org.contaazul.discovery.explorer.robot.instruments.MovementInstructionConverter;
import org.contaazul.discovery.explorer.robot.instruments.Ultrasonic;

public class RobotHover implements Robot {
	
	private Planet planetLanded;
	private Geolocation<Integer, Integer> geolocationInstrument;
	private Magnometer magnometerInstrument;
	private Ultrasonic ultrasonicInstrument;
	
	public static RobotHover land(Planet planet) {
		return new RobotHover(planet);
	}

	public void move(String movementPath) {
		List<String> instructions = MovementInstructionConverter.convert(movementPath);
		sendInstructionToEngine(instructions);			
	}

	public String getActualSpot() {
		return String.format("(%s, %s)", 
				geolocationInstrument.toString(), 
				magnometerInstrument.actualMagnometerSpot().getSymbol());
	}

	
	private RobotHover(Planet planet) {
		planetLanded = planet;
		initializeInstruments();
	}

	private void initializeInstruments() {
		try {
			ultrasonicInstrument = new Ultrasonic(planetLanded);
			magnometerInstrument = new Magnometer();
			geolocationInstrument = new Geolocation<Integer, Integer>(0, 0);
		} catch (NullPointerException e) {
			throw new PlanetNotRecognizedException();
		}
	}
	
	private void sendInstructionToEngine(List<String> instructions) {
		for (String instruction : instructions) {
			if (instruction.equals("L") || instruction.equals("R")) {
				motorAxisRotation(instruction);
			} else if (instruction.equals("M")) {
				motorForward();
			} else {
				throw new BadInstructionException();
			}
		}
	}

	private void motorAxisRotation(String instruction) {
		magnometerInstrument.rotate(instruction);
	}
	
	private void motorForward() {
		int xTemporaryCache = geolocationInstrument.getXCoordinates();
		int yTemporaryCache = geolocationInstrument.getYCoordinates();
		if (magnometerInstrument.actualMagnometerSpot().equals(CardinalDirection.NORTH)) {
			yTemporaryCache++;
		} else if (magnometerInstrument.actualMagnometerSpot().equals(CardinalDirection.SOUTH)) {
			yTemporaryCache--;
		} else if (magnometerInstrument.actualMagnometerSpot().equals(CardinalDirection.EAST)) {
			xTemporaryCache++;
		} else if (magnometerInstrument.actualMagnometerSpot().equals(CardinalDirection.WEST)) {
			xTemporaryCache--;
		}
		terrainAnalysis(xTemporaryCache, yTemporaryCache);
	}
	
	private void terrainAnalysis(int predictX, int predictY) {
		if (ultrasonicInstrument.checkTerrainBounds(predictX, predictY)) {
			geolocationInstrument.relocalize(predictX, predictY);
		} else {
			throw new TerrainOutOfBoundsException();
		}
	}
	
}
