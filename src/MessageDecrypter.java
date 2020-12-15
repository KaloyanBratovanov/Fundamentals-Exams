import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageDecrypter {
    public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                int n = Integer.parseInt(scanner.nextLine());




        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String regex = "^([$%])([A-Z][a-z][a-z]+)\\1: \\[([0-9]+)\\]\\|\\[([0-9]+)\\]\\|\\[([0-9]+)\\]\\|$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()){
                String name = matcher.group(2);
                int gr1 = Integer.parseInt(matcher.group(3));
                char ch1 = (char)gr1;
                int gr2 = Integer.parseInt(matcher.group(4));
                char ch2 = (char)gr2;
                int gr3 = Integer.parseInt(matcher.group(5));
                char ch3 = (char)gr3;

                System.out.println(String.format("%s: %s%s%s",name,ch1,ch2,ch3));
            }else {
                System.out.println("Valid message not found!");
            }

        }


    }
}
