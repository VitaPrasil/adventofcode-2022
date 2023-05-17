import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class Day5Test {
  private static final String INPUT_FILE = "day5_input.txt";
  private static final String INPUT_FILE_INIT = "day5_input_init.txt";

  @Test
  public void day5_task1() {
    Day5 day5 = new Day5();
    day5.setStacksCount(3);
    String solveTask1 = day5.solveTask1(Utils.getFileFromResourceAsString(INPUT_FILE), Utils.getFileFromResourceAsString(INPUT_FILE_INIT));
    Assert.assertThat(solveTask1, CoreMatchers.is("CMZ"));
  }

  @Test
  public void day5_task2() {
    Day5 day5 = new Day5();
    day5.setStacksCount(3);
    String solveTask2 = day5.solveTask2(Utils.getFileFromResourceAsString(INPUT_FILE), Utils.getFileFromResourceAsString(INPUT_FILE_INIT));
    Assert.assertThat(solveTask2, CoreMatchers.is("MCD"));
  }
}
