
import utils.ElfArea;
import utils.Utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Day4 {


    public static void main(String[] args) {
        String fileName = "input-day4.txt";

        int resultTask1 = solveTask1(Utils.getFileFromResourceAsString(fileName));
        int resultTask2 = solveTask2(Utils.getFileFromResourceAsString(fileName));

        System.out.println("Task 1 answer: " + resultTask1);
        System.out.println("Task 2 answer: " + resultTask2);
    }
    public static int solveTask1(String[] lines) {

        AtomicInteger score = new AtomicInteger();
        Arrays.stream(lines).forEach(line -> {
            String[] elfArea = line.split(",");
            if (checkFullOverlappedAreas(new ElfArea(elfArea[0]), new ElfArea(elfArea[1]))){
               score.getAndIncrement();
            }
        });
        return score.get();
    }

    public static int solveTask2(String[] lines) {

        AtomicInteger score = new AtomicInteger();
        Arrays.stream(lines).forEach(line -> {
            String[] elfArea = line.split(",");
            if (checkPartialOverlappedAreas(new ElfArea(elfArea[0]), new ElfArea(elfArea[1]))){
                score.getAndIncrement();
            }
        });
        return score.get();
    }

    private static boolean checkFullOverlappedAreas(ElfArea elfArea1, ElfArea elfArea2) {
        return elfArea1.fullOverlap(elfArea2) || elfArea2.fullOverlap(elfArea1);
    }

    private static boolean checkPartialOverlappedAreas(ElfArea elfArea1, ElfArea elfArea2) {
        return elfArea1.partialOverlap(elfArea2) || elfArea2.partialOverlap(elfArea1);
    }

    private String getFileFromResourceAsString(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);
        StringBuffer sb = new StringBuffer();

        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        }
        String text = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining("\n"));
        return text;
    }
}
