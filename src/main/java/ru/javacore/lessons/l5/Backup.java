package main.java.ru.javacore.lessons.l5;

import java.io.IOException;
import java.nio.file.*;

public class Backup {
    public static void main(String[] args) {

        String sourceDirPath = "./src/main/java"; // Укажите свой путь
        String backupDirPath = "./backup";

        backupFilesInDirectory(sourceDirPath, backupDirPath);
    }

    public static void backupFilesInDirectory(String sourceDirPath, String backupDirPath) {
        Path sourceDir = Paths.get(sourceDirPath);
        Path backupDir = Paths.get(backupDirPath);

        try {
            Files.walk(sourceDir)
                    .filter(Files::isRegularFile)
                    .forEach(sourceFile -> {
                        Path relativePath = sourceDir.relativize(sourceFile);
                        Path targetFile = backupDir.resolve(relativePath);

                        try {
                            Files.createDirectories(targetFile.getParent());
                            Files.copy(sourceFile, targetFile, StandardCopyOption.REPLACE_EXISTING);
                            System.out.println("Создана резервная копия файла: " + sourceFile);
                        } catch (IOException e) {
                            System.out.println("Ошибка при создании резервной копии файла: " + sourceFile);
                        }
                    });
            System.out.println("Резервные копии файлов созданы успешно");
        } catch (IOException e) {
            System.out.println("Ошибка при обходе директории: " + e.getMessage());
        }
    }
}


