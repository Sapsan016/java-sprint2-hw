import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CsvFileReader {
    public static String readFileContentsOrNull (String path){     // Метод для считывания файлов отчетов
        {
            try {
                return Files.readString(Path.of(path));
            } catch (IOException e) {
                System.out.println("Невозможно прочитать файл с месячным отчётом. " +
                        "Возможно, файл не находится в нужной директории.");
                return null;
            }
        }
    }

}