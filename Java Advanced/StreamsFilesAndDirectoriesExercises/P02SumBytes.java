package StreamsFilesAndDirectoriesExercises;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class P02SumBytes {
    public static void main(String[] args) throws IOException {

        String inputPath = "C:\\Users\\matar\\Desktop\\01._Sum Lines_Ресурси\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath))){

            int sum = 0;

            String line = reader.readLine();

            while(line!=null){

                for (char currentChar : line.toCharArray()) {
                    sum+=currentChar;
                }


                line = reader.readLine();
            }
            System.out.println(sum);


        }catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
