import java.util.*;

public class newturd {
    public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);


        Map<String, List<String>> usernameEmail = new LinkedHashMap<>();
        Map<String,Integer> usernameCount = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Statistics")){
            String [] token = input.split("->");

            String command = token[0];

            switch (command){
                case "Add": {
                    String name = token[1];
                    if (!usernameEmail.containsKey(name)){
                        usernameEmail.put(name,new LinkedList<>());
                        usernameCount.put(name,0);
                    }else {
                        System.out.printf("%s is already registered%n",name);
                    }
                }
                break;
                case "Send":{
                    String name = token[1];
                    String email = token[2];
                    if (usernameEmail.containsKey(name)){
                        usernameEmail.get(name).add(email);
                        usernameCount.put(name,+1);
                    }
                }
                break;
                case "Delete": {
                    String name = token[1];
                    if (!usernameCount.containsKey(name)){
                        System.out.printf("%s not found!%n",name);
                    }else {
                        usernameCount.remove(name);
                        usernameEmail.remove(name);
                    }
                }
                break;
            }

            input = scanner.nextLine();
        }

        System.out.println(String.format("Users count: %d",usernameCount.size()));

        usernameCount.entrySet().stream()
                .sorted((a,b) ->{
                    int result = b.getValue().compareTo(a.getValue());
                    if (result == 0){
                        result = a.getKey().compareTo(b.getKey());
                    }
                    return  result;
                })
                .forEach(entry ->{
                            System.out.println(entry.getKey());
                    for (Map.Entry<String, List<String>> stringListEntry : usernameEmail.entrySet()) {
                        System.out.println(String.format("%s", stringListEntry.getValue()));
                    }
                        }
                );


//        System.out.println(String.format("%s\n" +
//                " - %s\n",entry.getKey(),usernameEmail.get(name)));
//
//        for (Map.Entry<String, List<String>> stringListEntry : usernameEmail.entrySet()) {
//            System.out.println(String.format(" - %s",stringListEntry.getValue()));
//        }


    }
}
