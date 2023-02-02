package StreamsFilesAndDirectoriesExercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P01SumLines {
    public static void main(String[] args) throws IOException {
        String inputPath = "C:\\Users\\matar\\Desktop\\01._Sum Lines_Ресурси\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        List<String> allLines = Files.readAllLines(Path.of(inputPath));

        allLines.forEach(line -> {
            int sum = 0;
            for (char currentChar : line.toCharArray()) {
                sum += (int) currentChar;
            }
            System.out.println(sum);
        });
    }
}
