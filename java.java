import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        // Создаем объект Scanner для считывания данных с консоли
        Scanner scanner = new Scanner(System.in);

        // Открываем файл для записи
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("students.txt"))) {
            // Запрашиваем у пользователя количество студентов
            System.out.print("Введите количество студентов: ");
            int numberOfStudents = scanner.nextInt();
            scanner.nextLine(); // Очищаем буфер после считывания числа

            // Запрашиваем информацию о каждом студенте и записываем в файл
            for (int i = 0; i < numberOfStudents; i++) {
                System.out.println("Введите информацию о студенте #" + (i + 1));

                System.out.print("Имя: ");
                String name = scanner.nextLine();

                System.out.print("Возраст: ");
                int age = scanner.nextInt();
                scanner.nextLine(); // Очищаем буфер после считывания числа

                System.out.print("Средний балл: ");
                double averageScore = scanner.nextDouble();
                scanner.nextLine(); // Очищаем буфер после считывания числа

                // Записываем информацию о студенте в файл
                String studentInfo = name + "," + age + "," + averageScore;
                writer.write(studentInfo);
                writer.newLine(); // Переходим на новую строку для следующего студента
            }

            System.out.println("Данные успешно записаны в файл students.txt.");
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        } finally {
            // Закрываем Scanner
            scanner.close();
        }
    }
}
