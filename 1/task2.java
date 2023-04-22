
public class task2 {
    public static void main(String[] args) throws Exception {
        // Вывести все простые числа от 1 до 1000
        System.out.print(" Простые числа от 1 до 1000: ");
        System.out.println();
        for (int i = 1; i <= 1000; i++) {
            if (isSimple(i))
                System.out.printf("%d ", i);
        }
    }

    public static boolean isSimple(int digit) {
        if (digit < 1)
            return false;
        if (digit >= 1 && digit <= 3)
            return true;
        if (digit % 2 == 0)
            return false;
        int d = 5;
        while (d * d <= digit && digit % d != 0)
            d += 2;
        return d * d > digit;
    }

}
