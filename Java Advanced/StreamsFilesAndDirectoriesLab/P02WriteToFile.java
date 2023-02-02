package StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class P02WriteToFile {
    public static void main(String[] args) throws IOException {

        String inputPath = "C:\\Users\\matar\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "C:\\Users\\matar\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\output.txt";

        List<Character> punctuation = Arrays.asList(',', '.', '!', '?');

        try (FileInputStream inputStream = new FileInputStream(inputPath);
             FileOutputStream outputStream = new FileOutputStream(outputPath)) {
            int oneByte = inputStream.read();
            while (oneByte >= 0) {
                if (!punctuation.contains((char)oneByte)) {
                    outputStream.write(oneByte);
                }
                oneByte = inputStream.read();
            }
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
