import java.util.Scanner;

public class StringManipulator {
    public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                String string = scanner.nextLine();

                String input = scanner.nextLine();

                while (!input.equals("End")){
                    String [] token = input.split("\\s+");

                    String command = token[0];

                    switch (command){
                        case "Translate":{
                         String ch = token[1];
                         String replacement = token[2];
                         string = string.replace(ch,replacement);
                            System.out.println(string);
                        }
                            break;
                        case "Includes": {
                            String incl = token[1];
                            if (string.contains(incl)){
                                System.out.println("True");
                            }else {
                                System.out.println("False");
                            }
                        }
                            break;
                        case "Start":{
                            String start = token[1];
                            if (string.startsWith(start)){
                                System.out.println("True");
                            }else {
                                System.out.println("False");
                            }
                        }
                            break;
                        case "Lowercase":
                            string = string.toLowerCase();
                            System.out.println(string);
                            break;
                        case "FindIndex":{
                            String ch = token[1];
                            int cha = string.lastIndexOf(ch);
                            System.out.println(cha);
                        }
                            break;
                        case "Remove":
                            int start = Integer.parseInt(token[1]);
                            int end = Integer.parseInt(token[2]);
                            string = string.substring(0,start) + string.substring(end);
                            System.out.println(string);
                            break;
                    }
                    input = scanner.nextLine();
                }
    }
}
