package component;

import java.util.Scanner;
import java.util.regex.Pattern;

import model.Cell;

public class UserInputParser {
    private static final char MIN_RANGE = '1';
    private static final char MAX_RANGE = '9';
    private static final Pattern ACCEPTABLE_PATTERN = Pattern.compile(String.format("[%s-%s]", MIN_RANGE, MAX_RANGE));

    public Cell askForInput() {
        System.out.println();
        printAskForRow();
        int row = parseInput();
        printAskForColumn();
        int column = parseInput();
        return of(row, column);
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
            System.out.printf("Wrong parameter, please use a single number between %s and %s%n", MIN_RANGE, MAX_RANGE);
            return parseInput();
        }
    }

    private Cell of(int userInputRow, int userInputColumn) {
        int rowInArray = userInputRow - 1;
        int columnInArray = userInputColumn - 1;
        return new Cell(rowInArray, columnInArray);
    }
}
