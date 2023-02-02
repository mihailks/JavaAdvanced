package StreamsFilesAndDirectoriesLab;

import java.io.*;
import java.util.Scanner;

public class P05WriteEveryThirdLine {
    public static void main(String[] args) {

        String inputPath = "C:\\Users\\matar\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "C:\\Users\\matar\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\output.txt";


        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             PrintStream writer = new PrintStream(new FileOutputStream(outputPath))) {


            int lineCount = 1;
            String line = reader.readLine();

            while (line!=null) {

                if (lineCount%3==0){
                    writer.println(line);
                }

                line = reader.readLine();
                lineCount++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
