import utils.Utils;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Day2 {

    public static void main(String[] args) {
        String fileName = "input-day2.txt";

        int resultTask1 = solveTask1(Utils.getFileFromResourceAsString(fileName));
        int resultTask2 = solveTask2(Utils.getFileFromResourceAsString(fileName));

        System.out.println("Total score task 1: " + resultTask1);
        System.out.println("Total score task 2: " + resultTask2);
    }

    public static int solveTask1 (String[] lines) {
        AtomicInteger score = new AtomicInteger();
        Arrays.stream(lines).forEach(line -> {
            String opponentVote = line.split(" ")[0];
            String myVote = line.split(" ")[1];
            score.addAndGet(evaluate(opponentVote, myVote));
            score.addAndGet(voteScorePoint(myVote));
        });
        return score.get();
    }

    public static int solveTask2 (String[] lines) {
        AtomicInteger score = new AtomicInteger();
        Arrays.stream(lines).forEach(line -> {
            String opponentVote = line.split(" ")[0];
            String myVote = line.split(" ")[1];
            String myNewVote = getCorrectVote(opponentVote, myVote);
            score.addAndGet(evaluate(opponentVote, myNewVote));
            score.addAndGet(voteScorePoint(myNewVote));
        });
        return score.get();
    }

    private static int voteScorePoint(String myVote) {
        switch (myVote) {
            case "X": return 1;
            case "Y": return 2;
            case "Z": return 3;
        }
        return 0;
    }

    private static int evaluate(String oponnentVote, String myVote) {

        switch(myVote) {
            case "X":
                switch (oponnentVote) {
                    case "A": return 3;
                    case "B": return 0;
                    case "C": return 6;
                }
            case "Y":
                switch (oponnentVote) {
                    case "A": return 6;
                    case "B": return 3;
                    case "C": return 0;
                }
            case "Z":
                switch (oponnentVote) {
                    case "A": return 0;
                    case "B": return 6;
                    case "C": return 3;
                }
        }
        return 0;
    }

    private static String getCorrectVote(String oponnentVote, String result) {
        switch (result) {
            case "X":
                switch (oponnentVote) {
                    case "A": return "Z";
                    case "B": return "X";
                    case "C": return "Y";
                }
            case "Y":
                switch (oponnentVote) {
                    case "A": return "X";
                    case "B": return "Y";
                    case "C": return "Z";
                }
            case "Z":
                switch (oponnentVote) {
                    case "A": return "Y";
                    case "B": return "Z";
                    case "C": return "X";
                }
        }
        return "";
    }
}
