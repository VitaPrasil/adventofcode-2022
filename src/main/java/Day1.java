import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Day1 {

    public static void main(String[] args) {
        String fileName = "day1/input.txt";
        int resultTask1 = solveTask1(Utils.getFileFromResourceAsString(fileName));
        int resultTask2 = solveTask2(Utils.getFileFromResourceAsString(fileName));

        System.out.println("Elf with most calories: " + resultTask1);
        System.out.println("Top 3 elves with most calories: " + resultTask2);
    }

    public static int solveTask1(String inputString) {
        List<Integer> caloriesPerElf = createSorterElfCaloriesList(inputString);
        return caloriesPerElf.get(0);
    }

    public static int solveTask2(String inputString) {
        List<Integer> caloriesPerElf = createSorterElfCaloriesList(inputString);
        return caloriesPerElf.get(0) + caloriesPerElf.get(1) + caloriesPerElf.get(2);
    }

    private static List<Integer> createSorterElfCaloriesList(String inputString) {
        List<Integer> caloriesPerElf = new ArrayList<>();
        caloriesPerElf.add(0);
        String[] lines = inputString.split("\n");

        Arrays.stream(lines).forEach(line -> {
            if(line.compareTo("") == 0) {
                caloriesPerElf.add(0);
            } else {
                int lastElfCalories = caloriesPerElf.get(caloriesPerElf.size() - 1);
                caloriesPerElf.set(caloriesPerElf.size() - 1, lastElfCalories + Integer.valueOf(line));
            }
        });
        caloriesPerElf.sort(Comparator.reverseOrder());

        return caloriesPerElf;
    }
}
