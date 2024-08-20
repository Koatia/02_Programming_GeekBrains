//        Напишите метод, который вернет содержимое текущей папки в виде
//        массива строк.
//        Напишите метод, который запишет массив, возвращенный предыдущим
//        методом в файл.
//        Обработайте ошибки с помощью try-catch конструкции. В случае
//        возникновения исключения, оно должно записаться в лог-файл.

import java.io.File;
import java.io.FileWriter;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import static java.util.logging.Logger.*;

public class ContentFloder {

    private static final Logger logger = getLogger(ContentFloder.class.getName());

    public static void main(String[] args) {
        setLogger();

        String[] content = getContentFolder(".");
        writeToFile(content, "file1.txt");
    }

    public static String[] getContentFolder(String dir) {
        File folder = new File(dir);
        return folder.list();
    }

    public static void writeToFile(String[] contens, String fileName) {

        try (FileWriter fw = new FileWriter(fileName)) {
            for (String str : contens) {
                fw.write(str);
                fw.write(System.lineSeparator()); // добавляем перевод строки
                logger.log(Level.SEVERE, str); // вывод в лог
            }

        } catch (Exception e) {
            logger.warning(e.getMessage());
        }
    }

    public static void setLogger() {
        try {
            FileHandler fileHandler = new FileHandler("loging.txt", false); // true - append to file, false -
                                                                            // overwritext file
            logger.addHandler(fileHandler);
            SimpleFormatter sf = new SimpleFormatter();
            fileHandler.setFormatter(sf);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}