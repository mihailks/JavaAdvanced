package StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.IOException;

public class P01ReadFile {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\matar\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream fileStream = new FileInputStream(path);

        int oneByte = fileStream.read();

        while (oneByte>=0){
            System.out.printf("%s ", Integer.toBinaryString(oneByte));
            oneByte = fileStream.read();
        }
        fileStream.close();
    }
}
