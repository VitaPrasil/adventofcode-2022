
import utils.Move;
import utils.Utils;

import java.util.*;

public class Day5 {

    private static Map<Integer, LinkedList<String>> stacks =new HashMap<>();
    private int stacksCount = 9;

    private static final String FILE_NAME = "input-day5.txt";
    private static final String FILE_NAME_INIT = "input-day5-init.txt";

    public static void main(String[] args) {
        Day5 day5 = new Day5();
        day5.setStacksCount(9);

        String[] input = Utils.getFileFromResourceAsString(FILE_NAME);
        String[] initState = Utils.getFileFromResourceAsString(FILE_NAME_INIT);

        String resultTask1 = day5.solveTask1(input, initState);
        String resultTask2 = day5.solveTask2(input, initState);

        System.out.println("Task 1 answer: " + resultTask1);
        System.out.println("Task 2 answer: " + resultTask2);
    }

    public String solveTask1(String[] lines, String[] linesInitState) {
        intiStacks(Arrays.asList(linesInitState));

        Arrays.stream(lines).forEach(line -> {
            String[] plannedMove = line
                    .replaceAll("move ", "")
                    .replaceAll("from ", "")
                    .replaceAll("to " ,"")
                    .trim()
                    .split(" ");

            makeMovesPart1(new Move(Integer.valueOf(plannedMove[0]), Integer.valueOf(plannedMove[1]), Integer.valueOf(plannedMove[2])));

        });

        return getTopsFromStacks();
    }

    public String solveTask2(String[] lines, String[] linesInitState) {
        intiStacks(Arrays.asList(linesInitState));

        Arrays.stream(lines).forEach(line -> {
            String[] plannedMove = line
                    .replaceAll("move ", "")
                    .replaceAll("from ", "")
                    .replaceAll("to " ,"")
                    .trim()
                    .split(" ");

            makeMovesPart2(new Move(Integer.valueOf(plannedMove[0]), Integer.valueOf(plannedMove[1]), Integer.valueOf(plannedMove[2])));
        });
        return getTopsFromStacks();
    }

    private String getTopsFromStacks() {
        StringBuilder topOfStacks = new StringBuilder();
        for(int stackIndex = 1; stackIndex <= stacksCount; stackIndex++){
            String item = stacks.get(stackIndex).get(0);
            topOfStacks.append(item);
        }
       return topOfStacks.toString();
    }

    private void makeMovesPart2(Move move) {
        List<String> itemToMove = new ArrayList<>();
        for(int i = 0; i < move.getCountOfItemToMove(); i++) {
            itemToMove.add(stacks.get(move.getSourceStack()).pop());
        }
        Collections.reverse(itemToMove);
        itemToMove.stream().forEach(item -> stacks.get(move.getDestinationStack()).push(item));
    }

    private void makeMovesPart1(Move move) {
        for(int i = 0; i < move.getCountOfItemToMove(); i++) {
            stacks.get(move.getDestinationStack()).push(stacks.get(move.getSourceStack()).pop());
        }
    }

    private void intiStacks(List<String> linesInitState) {
        createEmptyStacks();

        //change order of lines first is last and last is forst
        Collections.reverse(linesInitState);
        linesInitState.stream().forEach(line -> {
            List<String> characterList = splitString(line);
                fillStacks(characterList);
        });
    }

    private void fillStacks(List<String> line) {
        for(int stackIndex = 1; stackIndex <= stacksCount; stackIndex++){
            int itemPosition = 1 + (stackIndex-1)*4;
            if (itemPosition + 1 > line.size()) {
                continue;
            }
            String item = line.get(itemPosition);
            if (!item.equals(" ")) {
                LinkedList<String> stackContent = stacks.get(stackIndex);
                stackContent.push(item);
                stacks.put(stackIndex, stackContent);
            }
        }
    }

    private void createEmptyStacks() {
        for(int i = 1; i <= stacksCount; i++){
            stacks.put(i, new LinkedList());
        }
    }

    private List<String> splitString(String partLine) {
        StringTokenizer st = new StringTokenizer(partLine, partLine, true);
        List<String> charList = new ArrayList<>();
        while (st.hasMoreTokens()) {
            charList.add(st.nextToken());
        }
        return charList;
    }

    public void setStacksCount(int stacksCount) {
        this.stacksCount = stacksCount;
    }
}
