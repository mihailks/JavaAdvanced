package StreamsFilesAndDirectoriesLab;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class P06SortLines {
    public static void main(String[] args) throws IOException {

        String inputPath = "C:\\Users\\matar\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "C:\\Users\\matar\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\output.txt";

        Path path = Paths.get(inputPath);

        List<String> sortedLines = Files.readAllLines(path)
                .stream()
                .sorted()
                .collect(Collectors.toList());

        Path output = Paths.get(outputPath);
        Files.write(output, sortedLines);

    }
}
