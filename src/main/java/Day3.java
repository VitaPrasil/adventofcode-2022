import utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicInteger;

public class Day3 {
  private static String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
  public static void main(String[] args) {
    String fileName = "input-day3.txt";

    int resultTask1 = solveTask1(Utils.getFileFromResourceAsString(fileName));
    int resultTask2 = solveTask2(Utils.getFileFromResourceAsString(fileName));

    System.out.println("Task 1 answer: " + resultTask1);
    System.out.println("Task 2 answer: " + resultTask2);
  }

  public static int solveTask1(String[] lines) {
    AtomicInteger score = new AtomicInteger();
    List<String> characterPriorityList = splitString(CHARACTERS);

    Arrays.stream(lines).forEach(line -> {
      String[] splitLine = splitLine(line);
      String sameChar = findSameChar(splitString(splitLine[0]), splitString(splitLine[1]));
      score.addAndGet(characterPriorityList.indexOf(sameChar) + 1);
    });
    return score.get();
  }

  public static int solveTask2(String[] lines) {
    int score = 0;
    List<String> characterPriorityList = splitString(CHARACTERS);

    for(int i = 0; i<lines.length; i = i+3) {
      String sameChar = findSameChar(
              splitString(lines[i]),
              splitString(lines[i + 1]),
              splitString(lines[i + 2]));
      score += characterPriorityList.indexOf(sameChar) + 1;
    }
    return score;
  }

  private static List<String> splitString(String partLine) {
    StringTokenizer st = new StringTokenizer(partLine, partLine, true);
    List<String> partList = new ArrayList<>();
    while (st.hasMoreTokens()) {
      partList.add(st.nextToken());
    }
    return partList;
  }

  private static String[] splitLine(String line) {
    String firstPart = line.substring(0, line.length() / 2);
    String secondPart = line.substring(line.length() / 2);
    String[] returnValue = new String[2];
    returnValue[0] = firstPart;
    returnValue[1] = secondPart;
    return returnValue;
  }

  private static String findSameChar(List<String> part1, List<String> part2) {
    for (String character: part1) {
      if(part2.contains(character)) {
        return character;
      }
    }
    return null;
  }

  private static String findSameChar(List<String> part1, List<String> part2, List<String> part3) {
    for (String character: part1) {
      if(part2.contains(character) && part3.contains(character)) {
        return character;
      }
    }
    return null;
  }
}
