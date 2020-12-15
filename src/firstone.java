import java.util.Scanner;

public class firstone {
    public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                String email = scanner.nextLine();

                String input = scanner.nextLine();

                while (!input.equals("Complete")){
                    String [] token = input.split("\\s+");

                    String command = token[0];

                    switch (command){
                        case "Make":{
                            String secondCommand = token[1];
                            if (secondCommand.equals("Upper")){
                                email = email.toUpperCase();
                                System.out.println(email);
                            }else if (secondCommand.equals("Lower")){
                                email = email.toLowerCase();
                                System.out.println(email);
                            }
                        }
                            break;
                        case "GetDomain":{
                            int count = Integer.parseInt(token[1]);
                            String last = email.substring(email.length()-count);
                            System.out.println(last);
                        }
                            break;
                        case "GetUsername":{
                         if (!email.contains("@")){
                             System.out.println(String.format("The email %s doesn't contain the @ symbol.",email));
                         }else {
                             String output = email.substring(0, email.indexOf('@'));
                             System.out.println(output);
                         }
                        }
                            break;
                        case "Replace":{
                            String ch = token[1];
                            email = email.replace(ch,"-");
                            System.out.println(email);
                        }
                            break;
                        case "Encrypt":
                            for (int i = 0; i < email.length(); i++) {
                                char character = email.charAt(i);
                                int ascii = (int) character;
                                System.out.print(ascii + " ");
                            }
                            break;
                    }

                    input = scanner.nextLine();
                }




    }
}
