import java.util.Scanner;

public class task1 {
    public static void main(String[] args) throws Exception {
        // Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение
        // чисел от 1 до n)
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите целое число:");
        int n = iScanner.nextInt();
        long res = 0;
        for (int i = 1; i <= n; i++) {
            res += i;
        }
        System.out.printf("треугольное число на базе %d = %d", n, res);
        iScanner.close();
    }
}
