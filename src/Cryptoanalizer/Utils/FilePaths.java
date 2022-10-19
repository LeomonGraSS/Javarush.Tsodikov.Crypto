package Cryptoanalizer.Utils;

import Cryptoanalizer.Exeption.WrongFilePath;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilePaths {
    public static String createFile() {
        String path;
        try {
            path = String.valueOf(Files.createFile(Path.of(getPathForResult() + Scanner.scanString()+".txt")));
        } catch (IOException e) {
            throw new WrongFilePath("Неправильно введен путь к файлу");
        }
        return path;
    }

    private static Path getPathForResult() {
        Path path;
        do {
            Printable.printText("Введи путь для сохранения файла");
            path = Path.of(Scanner.scanString()+ "/..//");
        }
        while (!checkDirectory(path));
        Printable.printText("Введи название файла для сохранения");
        return path;
    }

    public static String getFilePath() {
        Path path;
        do {
            Printable.printText("Введи путь к файлу:");
            path = Path.of(Scanner.scanString());
        }
        while (!checkPath(path));
        return path.toString();
    }

    private static boolean checkPath(Path path)  {
        File file = path.toFile();
        if (Files.notExists(path) || !Files.isRegularFile(path)) {
            Printable.printText("Введен некорректный путь к файлу");
            return false;
        } else if (file.length() == 0) {
            Printable.printText("Файл пустой,попробуй другой");
            return false;
        }
        return true;
    }
    private static boolean checkDirectory(Path path)  {
        if (!Files.exists(path) || !Files.isDirectory(path)) {
            Printable.printText("Введен некорректный путь для сохранения");
            return false;
        }
        return true;
    }
}
