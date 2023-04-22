import java.util.Scanner;

public class pract3 {
    public static void main(String[] args) throws Exception {
        Scanner iScanner = new Scanner(System.in);

        System.out.print("Введите строку для проверки:");
        String forChecking = iScanner.nextLine();
        System.out.println();

        boolean result = hasSimmetry(forChecking);

        System.out.printf("Результат: %s", result ? "Строка палиндром" : "Строка не палиндром");
        iScanner.close();
    }

    public static boolean hasSimmetry(String Stroka) {
        for (int i = 0; i < Stroka.length() / 2; i++)
            if (Stroka.charAt(i) != Stroka.charAt(Stroka.length() - i - 1))
                return false;
        return true;
    }
}
