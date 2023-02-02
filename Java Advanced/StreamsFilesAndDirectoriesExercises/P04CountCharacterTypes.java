package StreamsFilesAndDirectoriesExercises;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class P04CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        String inputPath = "C:\\Users\\matar\\Desktop\\01._Sum Lines_Ресурси\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outputPath = "C:\\Users\\matar\\Desktop\\01._Sum Lines_Ресурси\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output_02.txt";
        Set<Character> vowels = getVowels();
        Set<Character> punctuationalMarks = getPuntMarks();

        int vowelsCount = 0;
        int OtherSymbolsCount = 0;
        int PunctuationCount = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputPath))) {

            String line = bufferedReader.readLine();

            while ((line != null)) {
                for (char currentChar : line.toCharArray()) {
                    if (currentChar == ' ') {
                        continue;
                    }
                    if (vowels.contains(currentChar)) {
                        vowelsCount++;
                    } else if (punctuationalMarks.contains(currentChar)) {
                        PunctuationCount++;
                    } else {
                        OtherSymbolsCount++;
                    }
                }
                line = bufferedReader.readLine();

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputPath));
        bufferedWriter.write("Vowels: " + vowelsCount);
        bufferedWriter.newLine();
        bufferedWriter.write("Other symbols: " + OtherSymbolsCount);
        bufferedWriter.newLine();
        bufferedWriter.write("Punctuation: " + PunctuationCount);
        bufferedWriter.close();

    }

    private static Set<Character> getPuntMarks() {
        Set<Character> marks = new HashSet<>();
        marks.add('!');
        marks.add('?');
        marks.add('.');
        marks.add(',');
        return marks;
    }

    private static Set<Character> getVowels() {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        return vowels;
    }
}
