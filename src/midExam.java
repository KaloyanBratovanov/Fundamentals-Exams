import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class midExam {
    public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                String [] input = scanner.nextLine().split(", ");
        List<String> nameList = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            nameList.add(input[i]);
        }

        String income = scanner.nextLine();

        while (!income.equals("Report")){
            String token [] = income.split("\\s+");

            String command = token [0];





            command = scanner.nextLine();
        }


    }
}
