package adventofcode2021;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Day1 {

  private static final String RESOURCE_FILE = "src/main/resources/puzzleInput.txt";

public static void main(String[] args) throws IOException {

    List<Integer> measurementsArray = getPuzzleInput();
    System.out.println(getTotalNextBiggerThanPreviousMeasurements(measurementsArray));
    System.out.println(getSumNextBiggerThanPreviousMeasurements(measurementsArray));
    System.out.println("Finish");
  }

  private static int getTotalNextBiggerThanPreviousMeasurements(List<Integer> measurementsArray) {
    int previousMeasurement = measurementsArray.get(0);
    int total = 0;

    for (Integer measurement : measurementsArray) {
      if (measurement > previousMeasurement) {
        total++;
      }
      previousMeasurement = measurement;
    }
    return total;
  }

  private static int getSumNextBiggerThanPreviousMeasurements(List<Integer> measurementsArray) {
    int total = 0;

    for (int i = 0; i < measurementsArray.size()-3; i++) {
      int firstMeasurement = measurementsArray.get(i);
      int secondMeasurement = measurementsArray.get(i+1);
      int thirdMeasurement = measurementsArray.get(i+2);

      int nextFirstMeasurement = measurementsArray.get(i+1);
      int nextSecondMeasurement = measurementsArray.get(i+2);
      int nextThirdMeasurement = measurementsArray.get(i+3);

      int sumCurrent = firstMeasurement + secondMeasurement + thirdMeasurement;
      int sumNext = nextFirstMeasurement + nextSecondMeasurement + nextThirdMeasurement;

      if (sumNext > sumCurrent) {
        total++;
      }
    }
    return total;
  }

  private static List<Integer> getPuzzleInput() throws IOException {
    return Files.readAllLines(Paths.get(RESOURCE_FILE)).stream()
        .map(Integer::parseInt)
        .collect(Collectors.toList());
  }
}