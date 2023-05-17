import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class Day2Test {

  private static final String INPUT_FILE = "day2_input.txt";

  @Test
  public void day2_task1() {
    int solveTask1 = Day2.solveTask1(Utils.getFileFromResourceAsString(INPUT_FILE));
    Assert.assertThat(solveTask1, CoreMatchers.is(15));
  }

  @Test
  public void day2_task2() {
    int solveTask2 = Day2.solveTask2(Utils.getFileFromResourceAsString(INPUT_FILE));
    Assert.assertThat(solveTask2, CoreMatchers.is(12));
  }
}
