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
public class Day1Test {

  private static final String INPUT_FILE = "day1_input.txt";

  @Test
  public void day1_game1() throws URISyntaxException, IOException {
    int solveTask1 = Day1.task1(Files.readAllLines(Path.of(Objects.requireNonNull(Day1.class.getClassLoader().getResource(INPUT_FILE)).toURI())));
    Assert.assertThat(solveTask1, CoreMatchers.is(24000));
  }

  @Test
  public void day1_game2() throws URISyntaxException, IOException {
    int solveTask2 = Day1.task2(Files.readAllLines(Path.of(Objects.requireNonNull(Day1.class.getClassLoader().getResource(INPUT_FILE)).toURI())));
    Assert.assertThat(solveTask2, CoreMatchers.is(45000));
  }
}
