import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class Day3Test {
  private static final String INPUT_FILE = "day3_input.txt";

  @Test
  public void day3_task1() {
    int solveTask1 = Day3.solveTask1(Utils.getFileFromResourceAsString(INPUT_FILE));
    Assert.assertThat(solveTask1, CoreMatchers.is(157));
  }

  @Test
  public void day3_task2() {
    int solveTask2 = Day3.solveTask2(Utils.getFileFromResourceAsString(INPUT_FILE));
    Assert.assertThat(solveTask2, CoreMatchers.is(70));
  }

}
