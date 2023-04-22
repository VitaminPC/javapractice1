import java.util.Scanner;

public class pract2 {
    public static void main(String[] args) throws Exception {
        Scanner iScanner = new Scanner(System.in);

        System.out.print("Введите строку для упаковки:");
        String unpacked = iScanner.nextLine();
        System.out.println();

        String result = Pack(unpacked);

        System.out.printf("Результат: %s", result);
        iScanner.close();
    }

    public static String Pack(String Stroka) {
        StringBuilder result = new StringBuilder("");
        char current = Stroka.charAt(0);
        Integer counter = 1;
        for (int i = 1; i < Stroka.length(); i++) {
            if (current != Stroka.charAt(i) || i == Stroka.length() - 1) {
                if (i == Stroka.length() - 1)
                    counter++;
                result.append(current + counter.toString());
                current = Stroka.charAt(i);
                counter = 0;
            }
            counter++;
        }
        return result.toString();
    }
}
