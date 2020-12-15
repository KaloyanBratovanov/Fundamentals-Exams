import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class first {
    public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        int count = 0;
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String regex = "[U$]+([A-Z][a-z][a-z]+)[U$]+[P@$\"]+([\\w]{5}[A-z]*[0-9]+)[P@$\"]+";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()){
                System.out.println("Registration was successful");
                String userName = matcher.group(1);
                String password = matcher.group(2);
                System.out.println(String.format("Username: %s, Password: %s",userName,password));
                count++;
            }else {
                System.out.println("Invalid username or password");
            }

        }

        System.out.println(String.format("Successful registrations: %d",count));


    }
}
