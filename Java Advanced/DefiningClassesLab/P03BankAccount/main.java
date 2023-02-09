package DefiningClassesLab.P03BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class main {

    private static final String END_COMMAND = "End";
    private static final String CREATE = "Create";
    private static final String DEPOSIT = "Deposit";
    private static final String SET_INTEREST = "SetInterest";
    private static final String GET_INTEREST = "GetInterest";
    private static final Map<Integer, BankAccount> accounts = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals(END_COMMAND)) {
            String[] commands = input.split(" ");
            String command = commands[0];
            String result = "";
            switch (command) {
                case CREATE:
                    result = createAccount();
                    break;
                case DEPOSIT:
                    result = deposit(commands);
                    break;
                case SET_INTEREST:
                    setInterest(commands);
                    break;
                case GET_INTEREST:
                    result = getInterest(commands);
                    break;
            }
            if (!result.isEmpty()) {
                System.out.println(result);
            }
            input = scanner.nextLine();
        }
    }

    private static String getInterest(String[] commands) {
        int account = Integer.parseInt(commands[1]);
        int years = Integer.parseInt(commands[2]);
        BankAccount bankAccount = accounts.get(account);
        if (bankAccount != null) {
            double interest = bankAccount.getInterest(years);
            return String.format("%.2f", interest);
        }
        return "Account does not exist";
    }

    private static String setInterest(String[] commands) {

        double interest = Double.parseDouble(commands[1]);
        BankAccount.setInterestRate(interest);

        return "";
    }

    private static String createAccount() {
        BankAccount bankAccount = new BankAccount();
        accounts.put(bankAccount.getId(), bankAccount);
        return String.format("Account ID%d created", bankAccount.getId());
    }

    private static String deposit(String[] commands) {

        int accountToDeposit = Integer.parseInt(commands[1]);
        int amountToDeposit = Integer.parseInt(commands[2]);

        BankAccount bankAccount = accounts.get(accountToDeposit);

        if (accounts.get(accountToDeposit) == null) {
            return "Account does not exist";
        }

        bankAccount.deposit(amountToDeposit);
        return String.format("Deposited %d to ID%d", amountToDeposit, accountToDeposit);

    }
}
