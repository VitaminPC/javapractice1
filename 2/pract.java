import java.lang.module.ResolutionException;
import java.util.Scanner;

public class pract {
    public static void main(String[] args) throws Exception {
        Scanner iScanner = new Scanner(System.in);

        System.out.print("Введите первый символ:");
        String first = iScanner.next();
        System.out.println();

        System.out.print("Введите второй символ:");
        String second = iScanner.next();
        System.out.println();

        System.out.print("Введите количество символов в итоговой строке:");
        int size = iScanner.nextInt();
        System.out.println();

        String result = BuildString(first, second, size);

        System.out.printf("Результат: %s", result);
        iScanner.close();
        
    }

    public static String BuildString(String a, String b, int size) {
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0)
                result.append(a);
            else
                result.append(b);
        }
        return result.toString();
    }
}
