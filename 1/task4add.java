import java.util.Scanner;

public class task4add {
    // Задано уравнение вида q + w = e, q, w, e >= 0.
    // Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69.
    // Требуется восстановить выражение до верного равенства. Предложить хотя бы
    // одно решение или сообщить, что его нет.
    // Под знаками вопросов - одна и та же цифра Ввод: 2? + ?5 = 69 Вывод: 24 + 45 =
    // 69
    public static void main(String[] args) throws Exception {

        Scanner iScanner = new Scanner(System.in);

        System.out.print("Введите выражение q + w = e (образец: 2? + ?5 = 69):");
        System.out.println();
        String equation = iScanner.nextLine();
        System.out.println();
        String[] members = equation.split(" ");
        if (members.length != 5 || !members[1].equals("+") || !members[3].equals("=")
                || !(isValid(members[0], true))
                || !(isValid(members[2], true))
                || !(isValid(members[4], false)))
            System.out.print("Введите правильное выражение.");
        else {

            boolean validDigitPresent = false;
            for (Integer i = 0; i < 10; i++) {
                String realEquation = equation.replaceAll("\\?", i.toString());
                String[] realMembers = realEquation.split(" ");
                int result = Integer.parseInt(realMembers[0]) + Integer.parseInt(realMembers[2]);
                if (result == Integer.parseInt(realMembers[4])) {
                    validDigitPresent = true;
                    System.out.printf("Подходящая цифра %s. Выражение = %s.", i.toString(), realEquation);
                }
            }
            if (!(validDigitPresent))
                System.out.print("Подходящие цифры отсутствуют.");
            iScanner.close();
        }
    }

    public static boolean isValid(String Value, boolean additional) {
        String checkString = "0123456789";
        if (additional)
            checkString += "\\?";

        char[] chars = Value.toCharArray();

        for (char ch : chars) {
            if (checkString.indexOf(ch) == -1)
                return false;
        }
        return true;
    }
}
