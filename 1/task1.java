import java.util.Scanner;

public class task1 {
    public static void main(String[] args) throws Exception {
        // Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение
        // чисел от 1 до n)
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите целое число:");
        int n = iScanner.nextInt();
        long res = 0;
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            res += i;
            fact *= i;
        }
        System.out.printf("Треугольное число на базе %d = %d", n, res);
        System.out.println();
        System.out.printf("Факториал %d = %d", n, fact);
        iScanner.close();
    }
}
