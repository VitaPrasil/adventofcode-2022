import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

@RunWith(MockitoJUnitRunner.class)
public class Day2Test {

  private static final String INPUT_FILE = "day2_input.txt";

  @Test
  public void day2_game1() throws URISyntaxException, IOException {
    int solveGame1 = Day2.game1(Files.readAllLines(Path.of(Objects.requireNonNull(Day1.class.getClassLoader().getResource(INPUT_FILE)).toURI())));
    Assert.assertThat(solveGame1, CoreMatchers.is(15));
  }

  @Test
  public void dayy1_task2() throws URISyntaxException, IOException {
    int solveGame2 = Day2.game2(Files.readAllLines(Path.of(Objects.requireNonNull(Day1.class.getClassLoader().getResource(INPUT_FILE)).toURI())));
    Assert.assertThat(solveGame2, CoreMatchers.is(12));
  }
}
