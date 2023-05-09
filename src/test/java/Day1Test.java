import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class Day1Test {

  @Test
  public void day1_task1() {
    int solveTask1 = Day1.solveTask1(Utils.getFileFromResourceAsString("day1_input.txt"));
    Assert.assertThat(solveTask1, CoreMatchers.is(24000));
  }

  @Test
  public void day1_task2() {
    int solveTask2 = Day1.solveTask2(Utils.getFileFromResourceAsString("day1_input.txt"));
    Assert.assertThat(solveTask2, CoreMatchers.is(45000));
  }
}
