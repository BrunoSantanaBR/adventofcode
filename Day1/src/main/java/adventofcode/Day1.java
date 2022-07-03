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

		System.out.println(getTotalNextBiggerThanPreviousMeasurements(measurementsArray));

		System.out.println(getSumNextBiggerThanPreviousMeasurements(measurementsArray));

		System.out.println("Finish");
		
	}

	private static int getTotalNextBiggerThanPreviousMeasurements(String[] measurementsArray) {
		String previousMeasurement = null;
		String nextMeasurement = null;

		int total = 0;

		for (String measurement : measurementsArray) {

			if (nextMeasurement == null) {
				previousMeasurement = measurement;
				nextMeasurement = measurement;
			} else {
				nextMeasurement = measurement;
			}

			if (Integer.parseInt(nextMeasurement) > Integer.parseInt(previousMeasurement)) {
				total++;
				previousMeasurement = measurement;
			} else {
				previousMeasurement = measurement;
			}
		}
		return total;
	}

	private static int getSumNextBiggerThanPreviousMeasurements(String[] measurementsArray) {

		boolean firstRun = true;

		int sumA = 0;
		int sumB = 0;
		int sumC = 0;

		int total = 0;

		int counterA = 0;
		int counterB = 0;
		int counterC = 0;

		for (String measurement : measurementsArray) {


			if (firstRun) {
				counterA++;

				sumA = sumA + Integer.parseInt(measurement);

				firstRun = false;

			} else if (counterC == 2) {
				counterC++;
				sumC = sumC + Integer.parseInt(measurement);
				
				counterA++;
				sumA = sumA + Integer.parseInt(measurement);

			} else if (counterC == 1) {
			
				counterC++;
				sumC = sumC + Integer.parseInt(measurement);
				
				if (counterB < 3) {
					counterB++;
					sumB = sumB + Integer.parseInt(measurement);

				}
			
			} else if (counterB == 2) {
				
				counterB++;
				sumB = sumB + Integer.parseInt(measurement);
				
				counterC++;
				sumC = sumC + Integer.parseInt(measurement);

			} else if (counterB == 1) {
				counterA++;
				sumA = sumA + Integer.parseInt(measurement);
				
				counterB++;
				sumB = sumB + Integer.parseInt(measurement);
				
				if (counterC < 3) {
					counterC++;
					sumC = sumC + Integer.parseInt(measurement);
				}
				
			} else if (counterA == 1) {
				counterA++;
				sumA = sumA + Integer.parseInt(measurement);				
				
				counterB++;
				sumB = sumB + Integer.parseInt(measurement);
			} 

			if (counterA == 3 && counterB == 3) {

				if (sumB > sumA) {
					total++;
				}

				counterA = 1;
				sumA = Integer.parseInt(measurement);

			} else if (counterB == 3 && counterC == 3) {

				if (sumC > sumB) {
					total++;
				}

				counterB = 1;
				sumB = Integer.parseInt(measurement);

			} else if (counterC == 3 && counterA == 3) {

				if (sumA > sumC) {
					total++;
				}

				counterC = 1;
				sumC = Integer.parseInt(measurement);
			}
			
			
		}

		return total;

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
