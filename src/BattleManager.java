import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class BattleManager {
    public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

        Map<String,Integer> personHealth = new LinkedHashMap<>();
        Map<String,Integer> personEnergy = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Results")){
            String [] token = input.split(":");

            String command = token[0];


            switch (command){
                case "Add": {
                    String name = token[1];
                    int health = Integer.parseInt(token[2]);
                    int energy = Integer.parseInt(token[3]);

                    if (!personHealth.containsKey(name)) {
                        personEnergy.put(name,energy);
                        personHealth.put(name,health);
                    } else {
                        personHealth.put(name,personHealth.get(name)+health);
                    }
                }
                    break;
                case "Attack":{
                    String attackerName = token[1];
                    String defenderName = token[2];
                    int damage = Integer.parseInt(token[3]);
                    if (personEnergy.containsKey(attackerName)&& personEnergy.containsKey(defenderName)){
                        personHealth.put(defenderName, personHealth.get(defenderName)-damage);
                        personEnergy.put(attackerName,personEnergy.get(attackerName)-1);
                        if (personHealth.get(defenderName)<=0){
                            personHealth.remove(defenderName);
                            personEnergy.remove(defenderName);
                            System.out.println(String.format("%s was disqualified!",defenderName));
                        }
                        if (personEnergy.get(attackerName)<=0){
                            personEnergy.remove(attackerName);
                            personHealth.remove(attackerName);
                            System.out.println(String.format("%s was disqualified!",attackerName));
                        }
                    }
                }
                    break;
                case "Delete":{
                    String name = token [1];
                    if (name.equals("All")){
                        personEnergy.clear();
                        personHealth.clear();
                    }else {
                        personEnergy.remove(name);
                        personHealth.remove(name);
                    }
                }
                    break;
            }

            input = scanner.nextLine();
        }

        System.out.println(String.format("People count: %d",personEnergy.size()));

        personHealth.entrySet().stream()
                .sorted((a,b) ->{
                    int result = b.getValue().compareTo(a.getValue());
                    if (result == 0){
                        result = a.getKey().compareTo(b.getKey());
                    }
                    return  result;
                })
                .forEach(entry -> {
                    String name = entry.getKey();
                    System.out.println(String.format("%s - %d - %d",entry.getKey(),entry.getValue(),personEnergy.get(name)));
                });


    }
}
