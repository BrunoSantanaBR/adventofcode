package adventofcode2021;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Day2 {

	private static final String RESOURCE_FILE = "src/main/resources/puzzleInput.txt";

	public static void main(String[] args) throws IOException {

		List<String> movementsArray = getPuzzleInput();
		System.out.println(getFinalHorizontalDepthPosition(movementsArray));
		System.out.println(getFinalHorizontalDepthPositionWithAim(movementsArray));
		System.out.println("Finish");
	}

	private static int getFinalHorizontalDepthPositionWithAim(List<String> movementsArray) {

		int horizontal = 0;
		int depth = 0;
		int aim = 0;

		for (String movement : movementsArray) {

			if (movement.indexOf("forward") > -1) {
				int unit = Integer.parseInt(movement.substring(movement.indexOf(" ") + 1));
				horizontal = horizontal + unit;
				depth = depth + (unit * aim);
			} else if (movement.indexOf("down") > -1) {
				aim = aim  + Integer.parseInt(movement.substring(movement.indexOf(" ") + 1));
			}else if (movement.indexOf("up") > -1) {
				aim = aim - Integer.parseInt(movement.substring(movement.indexOf(" ") + 1));
			}

		}
		
		
		return horizontal * depth;
	}

	private static int getFinalHorizontalDepthPosition(List<String> movementsArray) {

		int horizontal = 0;
		int depth = 0;

		for (String movement : movementsArray) {

			if (movement.indexOf("forward") > -1) {
				horizontal = horizontal + Integer.parseInt(movement.substring(movement.indexOf(" ") + 1));
			} else if (movement.indexOf("down") > -1) {
				depth = depth + Integer.parseInt(movement.substring(movement.indexOf(" ") + 1));
			}else if (movement.indexOf("up") > -1) {
				depth = depth - Integer.parseInt(movement.substring(movement.indexOf(" ") + 1));
			}

		}
		
		
		return horizontal * depth;
	}

	private static List<String> getPuzzleInput() throws IOException {
		return Files.readAllLines(Paths.get(RESOURCE_FILE)).stream().map(String::trim).collect(Collectors.toList());
	}
}