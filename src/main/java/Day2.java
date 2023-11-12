import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Day2 {

  private static final Map<String, Integer> voteScorePoints = Map.of("X", 1, "Y", 2, "Z", 3);
  private static final Map<String, Map<String, Integer>> evaluate = Map.of(
          "X", Map.of("A", 3, "B", 0, "C", 6),
          "Y", Map.of("A", 6, "B", 3, "C", 0),
          "Z", Map.of("A", 0, "B", 6, "C", 3));
  private static final Map<String, Map<String, String>> correctVotes = Map.of(
          "X", Map.of("A", "Z", "B", "X", "C", "Y"),
          "Y", Map.of("A", "X", "B", "Y", "C", "Z"),
          "Z", Map.of("A", "Y", "B", "Z", "C", "X"));

  public static void main(String[] args) throws URISyntaxException, IOException {
    List<String> lines = Files.readAllLines(Path.of(Objects.requireNonNull(Day1.class.getClassLoader().getResource("input-day2.txt")).toURI()));

    System.out.println("Total score game 1: " + game1(lines));
    System.out.println("Total score game 2: " + game2(lines));
  }

  public static int game1(List<String> lines) {
    return lines.stream()
            .map(line -> line.split(" "))
            .mapToInt(line -> Integer.parseInt(evaluate.get(line[1]).get(line[0]).toString()) + voteScorePoints.get(line[1]))
            .sum();
  }

  public static int game2(List<String> lines) {
    return lines.stream()
            .map(line -> line.split(" "))
            .mapToInt(line -> {
              String correctVote = correctVotes.get(line[1]).get(line[0]);
              return Integer.parseInt(evaluate.get(correctVote).get(line[0]).toString()) + voteScorePoints.get(correctVote);
            })
            .sum();
  }
}
