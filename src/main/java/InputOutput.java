import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * 1. Задан файл с текстом, найти и вывести в консоль все слова, начинающиеся с гласной буквы.
 * 2. Задан файл с текстом, найти и вывести в консоль все слова,  для которых последняя буква одного слова совпадает с первой буквой следующего слова
 * 3. Задан файл с текстом. В каждой строке найти и вывести наибольшее число цифр, идущих подряд.
 * 4. Задан файл с java-кодом. Прочитать текст программы из файла и все слова public в объявлении атрибутов и методов класса заменить на слово private. Результат сохранить в другой заранее созданный файл.
 * 5. Задан файл с java-кодом. Прочитать текст программы из файла и записать в другой файл в обратном порядке символы каждой строки.
 */


public class InputOutput {

    public static void main(String[] args) {


        /**
         * 1. Задан файл с текстом, найти и вывести в консоль все слова, начинающиеся с гласной буквы.
         * Гласные: а, е, ё, и, о, у, ы, э, ю, я
         */
        try (Stream<String> lines = Files.lines(Paths.get("src/main/taskFiles/", "fileTaskOne.txt"))) {
            List<String> firstTask = lines
                    .flatMap(line -> Stream.of(line.split("[\\s\n]+")))
                    .filter(word -> word.matches("(?i)^[АаЕеЁёИиОоУуЫыЭэЮюЯя].*"))
                    .map(word -> word.replaceAll("[^а-яА-ЯёЁйЙ]", ""))
                    .toList();
            System.out.println("1. First task:");
            firstTask.forEach(System.out::println);
            System.out.println("\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }


        /**
         * 2. Задан файл с текстом, найти и вывести в консоль все слова, для которых последняя буква одного слова совпадает с первой буквой следующего слова
         */
        try (Stream<String> lines = Files.lines(Paths.get("src/main/taskFiles/", "fileTaskOne.txt"))) {
            List<String> secondTask = lines
                    .flatMap(line -> Stream.of(line.split("[\\s\n]+")))
                    .map(word -> word.replaceAll("[^а-яА-ЯёЁйЙ]", ""))
                    .toList();

            List<String> matchedWords = new ArrayList<>();

            for (int i = 0; i < secondTask.size() - 1; i++) {
                String currentWord = secondTask.get(i).toLowerCase();
                String nextWord = secondTask.get(i + 1).toLowerCase();

                if (!currentWord.isEmpty() && !nextWord.isEmpty() &&
                        currentWord.charAt(currentWord.length() - 1) == nextWord.charAt(0)) {
                    matchedWords.add(currentWord + " " + nextWord);
                }
            }
            System.out.println("2. Second task:");
            matchedWords.forEach(System.out::println);
            System.out.println("\n");

        } catch (IOException ex) {
            ex.printStackTrace();
        }


        /**
         * 3. Задан файл с текстом. В каждой строке найти и вывести наибольшее число цифр, идущих подряд.
         */
        try (Stream<String> lines = Files.lines(Paths.get("src/main/taskFiles/", "fileTaskThree.txt"))) {
            List<String> thirdTask = lines
                    .toList();

            System.out.println("3. Third task:");
            for (String line : thirdTask) {
                int maxCount = 0;
                int currentCount = 0;

                for (char ch : line.toCharArray()) {
                    if (Character.isDigit(ch)) {
                        currentCount++;
                        if (currentCount > maxCount) {
                            maxCount = currentCount;
                        }
                    } else {
                        currentCount = 0;
                    }
                }
                System.out.println("Строка: " + "[" + line + "]");
                System.out.println("Наибольшее число цифр, идущих подряд: " + maxCount);
            }
            System.out.println("\n");

        } catch (IOException ex) {
            ex.printStackTrace();
        }


        /**
         * 4. Задан файл с java-кодом. Прочитать текст программы из файла и все слова public в объявлении атрибутов и методов класса заменить на слово private. Результат сохранить в другой заранее созданный файл.
         */
        try (Stream<String> lines = Files.lines(Paths.get("src/main/taskFiles/", "PublicPerson.java"))) {
            Path targetPath = Paths.get("src/main/taskFiles/", "PrivatePerson.java");
            List<String> fourthTask = lines
                    .map(word -> word.replace("public", "private"))
                    .toList();
            System.out.println("4. Fourth task:");
            if (Files.exists(targetPath)) {
                Files.write(targetPath, fourthTask);
                System.out.println("Изменения успешно сохранены в файл PrivatePerson.java");
            } else {
                System.out.println("Файла PrivatePerson.java не существует!");
            }
            System.out.println("\n");

        } catch (IOException ex) {
            ex.printStackTrace();
        }


        /**
         * 5. Задан файл с java-кодом. Прочитать текст программы из файла и записать в другой файл в обратном порядке символы каждой строки.
         */
        try (Stream<String> lines = Files.lines(Paths.get("src/main/taskFiles/", "InputPerson.java"))) {
            Path outputPath = Paths.get("src/main/taskFiles/", "OutputPerson.java");
            List<String> fifthTask = lines
                    .map(line -> new StringBuilder(line).reverse().toString())
                    .toList();

            System.out.println("5. Fifth task:");
            if (Files.exists(outputPath)) {
                Files.write(outputPath, fifthTask);
                System.out.println("Изменения успешно сохранены в файл OutputPerson.java");
            } else {
                System.out.println("Файла OutputPerson.java не существует!");
            }
            System.out.println("\n");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
