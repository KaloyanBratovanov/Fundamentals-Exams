import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                Map <String, Integer> personHealth = new LinkedHashMap<>();
                Map <String, Integer> personEnergy = new LinkedHashMap<>();

                String input = scanner.nextLine();

                while (!input.equals("Results")){
                    String [] token = input.split(":");

                    String command = token[0];
                    String name = token [1];
                            switch (command){
                        case "Add":{
                            int health = Integer.parseInt(token [2]);
                            int energy  = Integer.parseInt(token [3]);
                            add(name,health,energy,personHealth,personEnergy);
                        }
                            break;
                        case "Attack":{
                            String defenderName = token [2];
                            int damage = Integer.parseInt(token[3]);
                            attack(name,defenderName,damage,personHealth,personEnergy);
                        }
                            break;
                        case "Delete":
                            delete(name,personEnergy,personHealth);
                            break;

                    }

                    input = scanner.nextLine();
                }
                int peopleCount = personEnergy.size();
        System.out.println(String.format("People count: %d",peopleCount));

        personHealth.entrySet().stream()
                .sorted((a,b) -> {
                    int result = b.getValue().compareTo(a.getValue());
                    if (result == 0){
                        result = a.getKey().compareTo(b.getKey());
                    }
                    return result;
                })
                .forEach(entry ->{
                    String name = entry.getKey();
                    int health = personHealth.get(name);
                    int energy = personEnergy.get(name);
                    System.out.println(String.format("%s - %d - %d",name,health,energy));
                });


    }

    private static void delete(String name, Map<String, Integer> personEnergy, Map<String, Integer> personHealth) {
        if (name.equals("All")){
            personEnergy.clear();
            personHealth.clear();
        }else if (personEnergy.containsKey(name)){
            personEnergy.remove(name);
            personHealth.remove(name);
        }
    }

    private static void attack(String name, String defenderName, int damage, Map<String, Integer> personHealth, Map<String, Integer> personEnergy) {

        if (personEnergy.containsKey(name) && personEnergy.containsKey(defenderName)){
            personHealth.put(defenderName,personHealth.get(defenderName) - damage);
            personEnergy.put(name,personEnergy.get(name)-1);
            if (personHealth.get(defenderName)<= 0){
                System.out.println(String.format("%s was disqualified!",defenderName));
                personHealth.remove(defenderName);
                personEnergy.remove(defenderName);
            }
            if (personEnergy.get(name)<=0){
                System.out.println(String.format("%s was disqualified!",name));
                personEnergy.remove(name);
                personHealth.remove(name);
            }

        }

    }

    private static void add(String name, int health, int energy, Map<String, Integer> personHealth, Map<String, Integer> personEnergy) {

        if (!personHealth.containsKey(name)){
            personHealth.put(name,health);
            personEnergy.put(name,energy);
        }else {
            personHealth.put(name,personHealth.get(name)+ health);
        }

    }
}
