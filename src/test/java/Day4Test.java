import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class Day4Test {
  private static final String INPUT_FILE = "day4_input.txt";

  @Test
  public void day4_task1() {
    int solveTask1 = Day4.solveTask1(Utils.getFileFromResourceAsString(INPUT_FILE));
    Assert.assertThat(solveTask1, CoreMatchers.is(2));
  }

  @Test
  public void day4_task2() {
    int solveTask2 = Day4.solveTask2(Utils.getFileFromResourceAsString(INPUT_FILE));
    Assert.assertThat(solveTask2, CoreMatchers.is(4));
  }

}
