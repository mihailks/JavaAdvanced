package StreamsFilesAndDirectoriesExercises;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P06WordCount {
    public static void main(String[] args) throws IOException {
        String inputPath = "C:\\Users\\matar\\Desktop\\01._Sum Lines_Ресурси\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        String outputPath = "C:\\Users\\matar\\Desktop\\01._Sum Lines_Ресурси\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output_02.txt";

        List<String> allLinesWithWords = Files.readAllLines(Path.of(inputPath));
        Map<String, Integer> countMap = new HashMap<>();

        for (String line : allLinesWithWords) {
            String[] wordsOnRow = line.split("\\s+");

            Arrays.stream(wordsOnRow).forEach(word -> {
                countMap.put(word, 0);
            });

        }

        String pathText = "C:\\Users\\matar\\Desktop\\01._Sum Lines_Ресурси\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
        List<String> allLinesWithText = Files.readAllLines(Path.of(pathText));

        for (String line : allLinesWithText) {
            line = line.replaceAll("[\\.\\,\\?\\!\\:]", "");
            String[] words = line.split("\\s+"); //думите на съответния ред
            for (String word : words) {
                if (countMap.containsKey(word)) {
                    countMap.put(word, countMap.get(word) + 1);
                }
            }
        }


        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputPath));
        countMap.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> {
                    try {
                        bufferedWriter.write(entry.getKey() + " - " + entry.getValue());
                        bufferedWriter.newLine();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });

            bufferedWriter.close();
    }
}
