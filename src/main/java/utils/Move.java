package utils;

public class Move {
    private int countOfItemToMove;
    private int sourceStack;
    private int destinationStack;

    public Move(int countOfItemToMove, int sourceStack, int destinationStack) {
        this.countOfItemToMove = countOfItemToMove;
        this.sourceStack = sourceStack;
        this.destinationStack = destinationStack;
    }

    public int getCountOfItemToMove() {
        return countOfItemToMove;
    }

    public void setCountOfItemToMove(int countOfItemToMove) {
        this.countOfItemToMove = countOfItemToMove;
    }

    public int getSourceStack() {
        return sourceStack;
    }

    public void setSourceStack(int sourceStack) {
        this.sourceStack = sourceStack;
    }

    public int getDestinationStack() {
        return destinationStack;
    }

    public void setDestinationStack(int destinationStack) {
        this.destinationStack = destinationStack;
    }

    @Override
    public String toString() {
        return "Move{" +
                "countOfItemToMove=" + countOfItemToMove +
                ", sourceStack=" + sourceStack +
                ", destinationStack=" + destinationStack +
                '}';
    }
}
