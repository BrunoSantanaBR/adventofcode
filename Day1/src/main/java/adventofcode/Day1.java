package adventofcode;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Day1 {

	public static void main(String[] args) {

		String[] measurementsArray = getPuzzleInput();

		String previousMeasurement = null;
		String nextMeasurement = null;

		int counter = 0;

		for (String measurement : measurementsArray) {

			if (nextMeasurement == null) {
				previousMeasurement = measurement;
				nextMeasurement = measurement;
			} else {
				nextMeasurement = measurement;
			}

			if (Integer.parseInt(nextMeasurement) > Integer.parseInt(previousMeasurement)) {
				counter++;
				previousMeasurement = measurement;
			} else {
				previousMeasurement = measurement;
			}
		}
		
		System.out.println(counter);
	}

	private static String[] getPuzzleInput() {

		List<String> measurements = new ArrayList<String>();

		try {

			InputStream in = Day1.class.getClassLoader().getResourceAsStream("puzzleInput.txt");

			DataInputStream data_input = new DataInputStream(in);
			BufferedReader buffer = new BufferedReader(new InputStreamReader(data_input));

			String measurementLine;

			while ((measurementLine = buffer.readLine()) != null) {
				measurementLine = measurementLine.trim();
				if ((measurementLine.length() != 0)) {
					measurements.add(measurementLine);
				}
			}

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}

		return (String[]) measurements.toArray(new String[measurements.size()]);
	}

}
