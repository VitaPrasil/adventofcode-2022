import utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Day1 {

    public static void main(String[] args) {
        String fileName = "input-day1.txt";
        int resultTask1 = solveTask1(Utils.getFileFromResourceAsString(fileName));
        int resultTask2 = solveTask2(Utils.getFileFromResourceAsString(fileName));

        System.out.println("Elf with most calories: " + resultTask1);
        System.out.println("Top 3 elves with most calories: " + resultTask2);
    }

    public static int solveTask1(String[] lines) {
        List<Integer> caloriesPerElf = createSorterElfCaloriesList(lines);
        return caloriesPerElf.get(0);
    }

    public static int solveTask2(String[] lines) {
        List<Integer> caloriesPerElf = createSorterElfCaloriesList(lines);
        return caloriesPerElf.get(0) + caloriesPerElf.get(1) + caloriesPerElf.get(2);
    }

    private static List<Integer> createSorterElfCaloriesList(String[] lines) {
        List<Integer> caloriesPerElf = new ArrayList<>();
        caloriesPerElf.add(0);

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
