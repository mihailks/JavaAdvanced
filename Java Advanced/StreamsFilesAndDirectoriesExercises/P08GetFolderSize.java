package StreamsFilesAndDirectoriesExercises;

import java.io.File;

public class P08GetFolderSize {
    public static void main(String[] args) {

        String pathFolder = "C:\\Users\\matar\\Desktop\\01._Sum Lines_Ресурси\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";
        File folder = new File(pathFolder);

        File[] allFilesInFolder = folder.listFiles();
        int folderSize = 0;
        if (allFilesInFolder != null) {
            for (File file : allFilesInFolder) {
                folderSize += file.length();
            }
        }
        System.out.println("Folder size: " + folderSize);
    }
}
