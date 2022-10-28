import java.util.Scanner;
import java.util.StringJoiner;
import java.util.StringTokenizer;
import java.lang.String;
import java.lang.Object;
import java.util.ArrayList;

public class StringLaba {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        String razdel = input.nextLine();
        String P = input.nextLine();
        String[] newStr = new String[Count(str, razdel)];
        int count = 0;
        if (razdel.length() == 1) {
            newStr = str.split(razdel);
            System.out.print("Строка через split: ");
            for (String s : newStr) {
                System.out.print(s + " ");
                count++;
            }
        } else {
            System.out.println("Строка через Tokenizer: ");
            StringTokenizer tokenizer = new StringTokenizer(str, razdel);
            boolean flag = false;
            for (int i = 0; tokenizer.hasMoreTokens(); i++) {
                newStr[i] = tokenizer.nextToken();
                System.out.print(newStr[i]);
                count++;
            }
            System.out.println();
            for (int i = 0; i < count; i++) {
                if (newStr[i].equals(P)) {
                    System.out.println("Число " + P + " является лексемой №" + str.indexOf(P));
                    flag = true;
                }
            }
            if (!flag) System.out.println("Числа " + P + " среди лексем нет");
        }
        // str = newStr.toString();
        str = String.join("", newStr);
        String[] mass = new String[str.length()];
        int count_mass = 0;
        System.out.println();
        System.out.println("Числа в 10-ой с/c: ");
        char[] charstr = new char[str.length()];
        str.getChars(0, str.length(), charstr, 0);  //getChars()
        for (int i = 0; i < str.length(); i++) {
            if (charstr[i] >= 'A' && charstr[i] <= 'F' || charstr[i] >= '0' && charstr[i] <= '9') {
                System.out.print(Integer.parseInt(String.valueOf(charstr[i]), 16) + " "); //Integer.parseInt()
                mass[count_mass] = String.valueOf(charstr[i]);
                count_mass++;
            }
        }
        System.out.println();
        System.out.print("Числа в 16-ой с/с: ");
        for (int i = 0; i < count_mass; i++) {
            System.out.print(mass[i] + " ");
        }
        System.out.println();
        System.out.println("Строка без первого латинского символа: " + str.replaceFirst("([A-z])", ""));             //replace
        System.out.println("Строка без первого числа в 16 c/c: " + str.replaceFirst("([A-F1-9])", ""));
        StringBuffer strBuffer = new StringBuffer();
        strBuffer.append(str);
        strBuffer.insert(3, "2022");
        System.out.println("Строка с новым элементом через insert: " + strBuffer);
        strBuffer.delete(3, 7);
        System.out.println("Строка с удаленным элементом через delete: " + strBuffer);
        strBuffer.reverse();
        System.out.println("Перевернутая строка через reverse: " + strBuffer);
        ArrayList<String> strList = new ArrayList<String>();
        for(int i = 0; i < count; i++){
            strList.add(newStr[i]);
        }
    }

    public static int Count(String str, String razdel) {
        String[] newStr = new String[str.length()];
        StringTokenizer tokenizer = new StringTokenizer(str, razdel);
        int count = 0;
        for (int i = 0; tokenizer.hasMoreTokens(); i++) {
            newStr[i] = tokenizer.nextToken();
            System.out.print(newStr[i]);
            count++;
        }
        return count;
    }
}