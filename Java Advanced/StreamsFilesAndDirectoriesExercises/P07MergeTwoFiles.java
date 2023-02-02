package StreamsFilesAndDirectoriesExercises;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P07MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        String inputPathOne = "C:\\Users\\matar\\Desktop\\01._Sum Lines_Ресурси\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";
        String inputPathTwo = "C:\\Users\\matar\\Desktop\\01._Sum Lines_Ресурси\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";
        String outputPath = "C:\\Users\\matar\\Desktop\\01._Sum Lines_Ресурси\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output_02.txt";

        List<String> linesOne = Files.readAllLines(Path.of(inputPathOne));
        List<String> linesTwo = Files.readAllLines(Path.of(inputPathTwo));

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputPath));
        for (String wordOne : linesOne) {
            bufferedWriter.write(wordOne);
            bufferedWriter.newLine();
        }
        for (String wordTwo : linesTwo) {
            bufferedWriter.write(wordTwo);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

    }
}
