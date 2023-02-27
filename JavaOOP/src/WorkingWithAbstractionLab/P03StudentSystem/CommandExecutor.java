package WorkingWithAbstractionLab.P03StudentSystem;

public class CommandExecutor {

    private static final String EXIT_COMMAND = "Exit";
    private static final String CREATE_STUDENT_COMMAND = "Create";
    private static final String SHOW_STUDENT_COMMAND = "Show";

    private final StudentSystem studentSystem;

    public CommandExecutor() {
        this.studentSystem = new StudentSystem();
    }

    public void ParseCommand(String[] data) {
        String name = data[1];
        switch (data[0]) {
            case CREATE_STUDENT_COMMAND:
                int age = Integer.parseInt(data[2]);
                double grade = Double.parseDouble(data[3]);
                studentSystem.createStudent(name, age, grade);
                break;

            case SHOW_STUDENT_COMMAND:
                String result = studentSystem.showStudent(name);
                if (result != null) {
                    System.out.println(result);
                }
                break;
        }
    }

    public static boolean isExitCommand(String command) {
        return command.equals(EXIT_COMMAND);
    }
}
