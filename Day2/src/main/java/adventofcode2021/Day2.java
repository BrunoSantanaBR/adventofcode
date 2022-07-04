package adventofcode2021;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Day2 {
  private static final String RESOURCE_FILE = "src/main/resources/puzzleInput.txt";

  public static void main(String[] args) throws IOException {
    List<Instruction> movementsArray = getPuzzleInput();
    System.out.println(getFinalHorizontalDepthPosition(movementsArray));
    System.out.println(getFinalHorizontalDepthPositionWithAim(movementsArray));
    System.out.println("Finish");
  }

  private static int getFinalHorizontalDepthPositionWithAim(List<Instruction> movementsArray) {
    int horizontal = 0;
    int depth = 0;
    int aim = 0;

    for (var instruction : movementsArray) {
      if (instruction.isForward()) {
        horizontal = horizontal + instruction.getAmount();
        depth = depth + (instruction.getAmount() * aim);
      }
      if (instruction.isDown()) {
        aim = aim + instruction.getAmount();
      }
      if (instruction.isUp()) {
        aim = aim - instruction.getAmount();
      }
    }
    return horizontal * depth;
  }

  private static int getFinalHorizontalDepthPosition(List<Instruction> movementsArray) {
    int horizontal = 0;
    int depth = 0;

    for (var instruction : movementsArray) {
      if (instruction.isForward()) {
        horizontal = horizontal + instruction.getAmount();
      }
      if (instruction.isDown()) {
        depth = depth + instruction.getAmount();
      }
      if (instruction.isUp()) {
        depth = depth - instruction.getAmount();
      }
    }
    return horizontal * depth;
  }

  private static List<Instruction> getPuzzleInput() throws IOException {
    return Files.readAllLines(Paths.get(RESOURCE_FILE)).stream()
        .map(String::trim)
        .map(s -> s.split(" "))
        .map(Instruction::new)
        .collect(toList());
  }
}

class Instruction {
  private static final String FORWARD = "forward";
  private static final String DOWN = "down";
  private static final String UP = "up";
  private final String direction;
  private final int amount;

  public Instruction(String[] line) {
    this.direction = line[0];
    this.amount = Integer.parseInt(line[1]);
  }

  public boolean isForward() {
    return direction.contains(FORWARD);
  }

  public boolean isDown() {
    return direction.contains(DOWN);
  }

  public boolean isUp() {
    return direction.contains(UP);
  }

  public int getAmount() {
    return amount;
  }
}
