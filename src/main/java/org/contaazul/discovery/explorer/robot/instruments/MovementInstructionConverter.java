package org.contaazul.discovery.explorer.robot.instruments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovementInstructionConverter {
		
	
	public static List<String> convert(String movementInstruction) {
		List<String> convertedInstructions = new ArrayList<String>();
		convertedInstructions.addAll(
				Arrays.asList(movementInstruction.split("")));
		return convertedInstructions;
	}

}
