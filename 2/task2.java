import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//Дана строка (получение через обычный текстовый файл!!!)

// "фамилия":"Иванов","оценка":"5","предмет":"Математика"
// "фамилия":"Петрова","оценка":"4","предмет":"Информатика"

// Написать метод(ы), который распарсит строку и, используя StringBuilder, создаст строки вида:
// Студент [фамилия] получил [оценка] по предмету [предмет].

// Пример вывода в консоль:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.
public class task2 {
    public static void main(String[] args) throws Exception {
        String[] dataTable = readStringsFromFile("students.txt");
        for (int i = 0; i < dataTable.length; i++) {
            StringBuilder currentString = new StringBuilder("");
            String[] words = dataTable[i].split(",");
            currentString.append("Студент ");
            currentString.append(getField(words[0], "фамилия"));
            currentString.append(" получил ");
            currentString.append(getField(words[1], "оценка"));
            currentString.append(" по предмету ");
            currentString.append(getField(words[2], "предмет"));
            currentString.append(".");
            System.out.println(currentString.toString());
        }
    }

    public static String getField(String field, String FiledName) throws Exception {
        StringBuilder record = new StringBuilder("\"");
        record.append(FiledName);
        record.append("\":");
        return field.replaceAll(record.toString(), "").replaceAll("\"", "");
    }

    public static String[] readStringsFromFile(String Filename) {
        try {
            long size = getFileSize(Filename);
            File file = new File(Filename);
            FileReader f = new FileReader(file);
            BufferedReader br = new BufferedReader(f);
            String[] text = new String[(int) size];
            for (int counter = 0; counter < size; counter++) {
                text[counter] = br.readLine();
            }
            br.close();
            return text;
        } catch (IOException exc) {
            System.out.println("IO error: " + exc);
        }
        return new String[0];

    }

    public static long getFileSize(String fileName) throws IOException {
        var lines = 0L;
        try (var reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.readLine() != null) {
                lines++;
            }
            return lines;
        }
    }
}
