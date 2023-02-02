package StreamsFilesAndDirectoriesExercises;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P03ALLCAPITALS {
    public static void main(String[] args) {
        String inputPath = "C:\\Users\\matar\\Desktop\\01._Sum Lines_Ресурси\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outputPath = "C:\\Users\\matar\\Desktop\\01._Sum Lines_Ресурси\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output_02.txt";

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(inputPath));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputPath))){

            String line = bufferedReader.readLine();

            while (line!=null){
                for (char currentChar : line.toCharArray()){
                    bufferedWriter.write(Character.toUpperCase(currentChar));
                }
                bufferedWriter.newLine();
                line = bufferedReader.readLine();
            }
        }catch (IOException e ){
            throw new RuntimeException(e);
        }

    }
}
