import java.util.Scanner;

public class PakuriProgram {
    public static void main(String[] args) {
        int capacity = 0;
        Scanner MyObj = new Scanner(System.in);
        System.out.println("Welcome to Pakudex: Tracker Extraordinaire!");
        System.out.print("Enter max capacity of the Pakudex: ");

        String tentative;
        boolean capacityTrue = false;
        while (!capacityTrue) {
            tentative = MyObj.next();
            boolean numberTrue = false;
            for (int i = 0; i<tentative.length(); i++){
                if (Character.isDigit(tentative.charAt(i))){
                    numberTrue = true;
                }
                else {
                    numberTrue = false;
                }
            }
            if (tentative.charAt(0)!='-' && numberTrue){
                capacity = Integer.parseInt(tentative);
                capacityTrue = true;
            }
            else {
                capacityTrue = false;
                System.out.println("Please enter a valid size.");
                System.out.print("Enter max capacity of the Pakudex: ");
            }
        }
        boolean runMenu = true;
        Pakudex pakudex = new Pakudex(capacity);
        System.out.println("The Pakudex can hold " + pakudex.getCapacity() + " species of Pakuri.");
        while (runMenu) {
            System.out.println(" ");
            System.out.println("Pakudex Main Menu");
            System.out.println("-----------------");
            System.out.println("1. List Pakuri");
            System.out.println("2. Show Pakuri");
            System.out.println("3. Add Pakuri");
            System.out.println("4. Evolve Pakuri");
            System.out.println("5. Sort Pakuri");
            System.out.println("6. Exit");
            System.out.println(" ");
            System.out.print("What would you like to do? ");
            String menuInput = MyObj.next();

            if (menuInput.equals("1")){
                String[] list = pakudex.getSpeciesArray();
                if (list!=null) {
                    System.out.println("Pakuri In Pakudex: ");
                    for (int i = 0; i < list.length; i++) {
                        System.out.println((i + 1) + ". " + list[i]);
                    }
                } else {
                    System.out.println("No Pakuri in Pakudex yet!");
                }
            } else if (menuInput.equals("2")) {
                System.out.print("Enter the name of the species to display: ");
                String input = MyObj.next();
                int[] curStats;
                curStats = pakudex.getStats(input);
                if (curStats == null || curStats[0] == 0 && curStats[1] == 0 && curStats[2] == 0) {
                    System.out.println("Error: No such Pakuri!");
                } else {
                    System.out.println("Species: " + input);
                    System.out.println("Attack: " + curStats[0]);
                    System.out.println("Defense: " + curStats[1]);
                    System.out.println("Speed: " + curStats[2]);
                }
            } else if (menuInput.equals("3")) {
                if (pakudex.getSize() == pakudex.getCapacity()) {
                    System.out.print("Error: Pakudex is full!");
                } else {
                    System.out.print("Enter the name of the species to add: ");
                    String addSpecies = MyObj.next();
                    pakudex.addPakuri(addSpecies);
                }

            } else if (menuInput.equals("4")) {
                System.out.print("Enter the name of the species to evolve: ");
                String evolve = MyObj.next();
                if (pakudex.evolveSpecies(evolve)) {
                    System.out.println(evolve + " has evolved!");
                } else {
                    System.out.println("Error: No such Pakuri!");
                }
            } else if (menuInput.equals("5")) {
                pakudex.sortPakuri();

            } else if (menuInput.equals("6")){
                System.out.println("Thanks for using Pakudex! Bye!");
                System.exit(130);
            }else{
                System.out.println("Unrecognized menu selection!");
            }

        }
    }
}

