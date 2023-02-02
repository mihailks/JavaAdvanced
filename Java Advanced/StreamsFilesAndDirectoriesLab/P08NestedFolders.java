package StreamsFilesAndDirectoriesLab;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class P08NestedFolders {
    public static void main(String[] args) {

        String path = "C:\\Users\\matar\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";
        File root = new File(path);

        Deque<File> dirs = new ArrayDeque<>();
        dirs.offer(root);
        int counter = 0;
        while (!dirs.isEmpty()) {
            File current = dirs.poll();
            File[] nestedFiles = current.listFiles();
            for (File nestedFile : nestedFiles) {
                if(nestedFile.isDirectory()) {
                    dirs.offer(nestedFile);
                }
            }
            counter++;
            System.out.println(current.getName());
        }
        System.out.println(counter + " folders");
    }
}