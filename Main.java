import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
//        В папке Games создайте несколько директорий: src, res, savegames, temp.
//                В каталоге src создайте две директории: main, test.
//                В подкаталоге main создайте два файла: Main.java, Utils.java.
//                В каталог res создайте три директории: drawables, vectors, icons.
//                В директории temp создайте файл temp.txt.


        StringBuilder result = new StringBuilder();

        String[] dirsGames = new String[]{"src", "res", "savegames", "temp"};
        String[] dirsSrc = new String[]{"main", "test"};
        String[] dirsRes = new String[]{"drawables", "vectors", "icons"};
        String[] filesMain = new String[]{"Main.java", "Utils.java"};
        String[] filesTemp = new String[]{"temp.txt"};

        result.append(createDirArr(dirsGames, "/Users/realwonder/Games"));
        result.append(createDirArr(dirsSrc, "/Users/realwonder/Games/src"));
        result.append(createFileArr(filesMain, "/Users/realwonder/Games/src/main"));
        result.append(createDirArr(dirsRes, "/Users/realwonder/Games/res"));
        result.append((createFileArr(filesTemp, "/Users/realwonder/Games/temp")));

        try (FileWriter writer = new FileWriter("/Users/realwonder/Games/temp/temp.txt")) {
            writer.write(result.toString());
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }


    }

    public static String createDirArr(String[] arr, String location) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            File dir = new File(location, arr[i]);
            if (dir.mkdir()) {
                result.append(dir.getName()).append(" создан в ").append(location);
            } else {
                result.append(dir.getName()).append("не создан в ").append(location);
            }
            result.append("\n");
        }
        return result.toString();
    }

    public static String createFileArr(String[] arr, String location) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            File dir = new File(location, arr[i]);
            try {
                if (dir.createNewFile()) {
                    result.append(dir.getName()).append(" создан в ").append(location);
                } else {
                    result.append(dir.getName()).append("не создан в ").append(location);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            result.append("\n");
        }
        return result.toString();
    }
}