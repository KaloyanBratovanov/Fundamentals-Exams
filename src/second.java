import java.util.Scanner;

public class second {
    public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

        String string = scanner.nextLine();

        String input = scanner.nextLine();

        while (!input.equals("")){
            String [] token = input.split("\\s+");

            String command = token[0];

            switch (command){
                case "jhgj":{

                }
                break;
                case "Includes": {

                }
                break;
                case "Start":{

                }
                break;
                case "Lowercase":

                    break;
                case "FindIndex":{

                }
                break;
                case "Remove":

                    break;
            }
            input = scanner.nextLine();
        }

    }
}
