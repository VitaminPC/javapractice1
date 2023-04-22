import java.util.Scanner;

public class task3 {
    // Реализовать простой калькулятор
    // Введите первое число: 12
    // Введите операцию: +
    // Введите второе число: 1
    // Ответ: 13

    public static void main(String[] args) throws Exception {

        Scanner iScanner = new Scanner(System.in);

        System.out.print("Введите первое число:");
        double first = iScanner.nextDouble();
        System.out.println();

        System.out.print("Введите операцию:");
        String operation = iScanner.next();
        System.out.println();

        System.out.print("Введите второе число:");
        double second = iScanner.nextDouble();
        System.out.println();

        double result = 0;
        boolean canceled = false;
        switch (operation) {
            case ("+"):
                result = first + second;
                break;
            case ("-"):
                result = first - second;
                break;
            case ("*"):
                result = first * second;
                break;
            case ("/"):
                if (second == 0) {
                    System.out.print("Деление на 0 невозможно.");
                    canceled = true;
                } else
                    result = first / second;
                break;
            default:
                System.out.print("Калькулятор не умеет вычислить такое выражени");
                canceled = true;
                break;
        }
        if (!(canceled)) {
            System.out.println();
            System.out.printf("Результат = %f", result);
        }

        iScanner.close();
    }
}
