package component;

import java.util.Scanner;
import java.util.regex.Pattern;

import model.Cell;

public class UserInputParser {
    private static final Pattern ACCEPTABLE_PATTERN = Pattern.compile("[0-9]");

    public Cell askForInput() {
        System.out.println();
        printAskForRow();
        int row = parseInput();
        printAskForColumn();
        int column = parseInput();
        return new Cell(row, column);
    }

    private void printAskForRow() {
        System.out.println("Please select a row:");
    }

    private void printAskForColumn() {
        System.out.println("Please select a column:");
    }

    private int parseInput() {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext(ACCEPTABLE_PATTERN)) {
            String input = scanner.next(ACCEPTABLE_PATTERN);
            return Integer.parseInt(input);
        } else {
            System.out.println("Wrong parameter, please use a single number.");
            return parseInput();
        }
    }
}
