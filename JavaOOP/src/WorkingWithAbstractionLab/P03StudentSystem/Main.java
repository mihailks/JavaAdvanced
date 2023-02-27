package WorkingWithAbstractionLab.P03StudentSystem;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CommandExecutor commandExecutor = new CommandExecutor();

        while (true) {
            String[] input = scanner.nextLine().split(" ");

            if (CommandExecutor.isExitCommand(input[0])) {
                break;
            }
            commandExecutor.ParseCommand(input);
        }
    }
}
