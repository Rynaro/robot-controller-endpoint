package org.contaazul.discovery.explorer.api.controller;

import org.contaazul.discovery.explorer.planet.Mars;
import org.contaazul.discovery.explorer.planet.Planet;
import org.contaazul.discovery.explorer.robot.Robot;
import org.contaazul.discovery.explorer.robot.RobotHover;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/rest/mars")
public class MarsController {
	
	Planet mars;
	Robot robotHover;

	@RequestMapping(value="/{robotMovement}", method = RequestMethod.POST)
	public ResponseEntity robotMovement(@PathVariable("robotMovement") String robotMovement) {
		initializeRobotInstructions();
		try {
			robotHover.move(robotMovement);
			return new ResponseEntity(robotHover.getActualSpot(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity("400 Bad Request", HttpStatus.BAD_REQUEST);
		}		
	}
	
	private void initializeRobotInstructions() {
		mars = Mars.newInstance();		
		robotHover = RobotHover.land(mars);			
	}
	
}
