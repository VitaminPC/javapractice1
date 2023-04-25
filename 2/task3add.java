import java.util.Scanner;
import java.util.logging.*;

public class task3add {
    // К калькулятору из предыдущего дз добавить логирование.

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

        double result = 0.0;
        boolean canceled = false;
        StringBuilder logLine = new StringBuilder("");
        logLine.append(first);
        logLine.append(" ");
        logLine.append(operation);
        logLine.append(" ");
        logLine.append(second);
        switch (operation) {
            case ("+"):
                result = first + second;
                logLine.append(" = ");
                logLine.append(result);
                break;
            case ("-"):
                result = first - second;
                logLine.append(" = ");
                logLine.append(result);
                break;
            case ("*"):
                result = first * second;
                logLine.append(" = ");
                logLine.append(result);
                break;
            case ("/"):
                if (second == 0) {
                    System.out.print("Деление на 0 невозможно.");
                    logLine.append(" \nДеление на 0 невозможно.");
                    canceled = true;
                } else {
                    result = first / second;
                    logLine.append(" = ");
                    logLine.append(result);
                }
                break;
            default:
                System.out.print("Калькулятор не умеет вычислять такое выражение.");
                logLine.append(" \nКалькулятор не умеет вычислять такое выражение.");
                canceled = true;
                break;
        }
        if (!(canceled)) {
            System.out.println();
            System.out.printf("Результат = %f", result);
            System.out.println();
        }

        System.out.println();
        Logger logger = Logger.getLogger(task3add.class.getName());
        logger.setLevel(Level.INFO);
        FileHandler fh = new FileHandler("logTask3add.txt");
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);
        String logString = logLine.toString();
        logger.log(Level.WARNING, logString);
        logger.info(logString);
        iScanner.close();
    }
}
