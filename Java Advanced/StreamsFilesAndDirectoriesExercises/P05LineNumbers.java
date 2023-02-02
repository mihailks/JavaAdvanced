package StreamsFilesAndDirectoriesExercises;

import java.io.*;

public class P05LineNumbers {
    public static void main(String[] args) throws IOException {
        String inputPath = "C:\\Users\\matar\\Desktop\\01._Sum Lines_Ресурси\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        String outputPath = "C:\\Users\\matar\\Desktop\\01._Sum Lines_Ресурси\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output_02.txt";


        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputPath));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputPath))) {


            String line = bufferedReader.readLine();
            int lineCounter = 1;

            while (line != null) {

                bufferedWriter.write(lineCounter + ". " + line);
                bufferedWriter.newLine();

                lineCounter++;

                line = bufferedReader.readLine();
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }

    }
}

