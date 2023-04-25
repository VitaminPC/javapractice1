import java.io.IOException;
import java.util.Scanner;
import java.util.logging.*;

// Реализуйте алгоритм сортировки пузырьком числового массива (введён вами),
// результат после каждой итерации запишите в лог-файл.

public class task1 {
    public static void main(String[] args) throws Exception {
        int array[] = readArray();
        System.out.println();
        printArray(array);
        System.out.println();
        bubbleSortArray(array, true);
        System.out.println();
        printArray(array);
    }

    public static void bubbleSortArray(int array[], boolean makeLogs) throws IOException {

        Logger logger = Logger.getLogger(task1.class.getName());
        logger.setLevel(Level.INFO);
        FileHandler fh = new FileHandler("logTask1.txt");
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);
        boolean wasMoved = true;
        int cash;
        while (wasMoved) {
            wasMoved = false;
            if (makeLogs) {
                String logLine = imageArray(array, "Текущая версия массива:");
                logger.log(Level.WARNING, logLine);
                logger.info(logLine);
            }

            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    wasMoved = true;
                    cash = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = cash;
                }
            }
        }
    }

    public static int[] readArray() {
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите размер массива: ");
        int size = iScanner.nextInt();
        int array[] = new int[size];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < size; i++) {
            array[i] = iScanner.nextInt();
        }
        iScanner.close();
        return array;
    }

    public static void printArray(int array[]) {
        System.out.print(imageArray(array, "Массив:"));
        System.out.println();
    }

    public static String imageArray(int array[], String Title) {
        StringBuilder result = new StringBuilder(Title);
        for (int i = 0; i < array.length; i++) {
            result.append(" " + array[i]);
        }
        return result.toString();
    }
}
