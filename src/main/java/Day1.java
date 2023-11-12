import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Day1 {

  public static void main(String[] args) throws URISyntaxException, IOException {
    List<String> lines = Files.readAllLines(Path.of(Objects.requireNonNull(Day1.class.getClassLoader().getResource("input-day1.txt")).toURI()));
    System.out.println("Elf with most calories: " + task1(lines));
    System.out.println("Top 3 elves with most calories: " + task2(lines));
  }

  public static int task1(List<String> lines) {
    return computeCalories(lines).getFirst();
  }

  public static int task2(List<String> lines) {
    return computeCalories(lines).stream()
            .limit(3)
            .mapToInt(c -> c)
            .sum();
  }

  private static LinkedList<Integer> computeCalories(List<String> lines) {
    LinkedList<Integer> calories = new LinkedList<>(List.of(0));
    lines.forEach(line -> {
      if (line.isEmpty()) {
        calories.add(0);
      } else {
        calories.add(calories.removeLast() + Integer.parseInt(line));
      }
    });
    calories.sort(Comparator.reverseOrder());

    return calories;
  }
}
