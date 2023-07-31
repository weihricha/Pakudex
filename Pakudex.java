public class Pakudex {
    private Pakuri[] deck;
    private int capacity = 0;

    public Pakudex() {
        deck = new Pakuri[20];
        // Default constructor if called, the default size for the Pakudex should be 20
    }

    public Pakudex(int capacity) {
        deck = new Pakuri[capacity];
        // Initializes this object to contain exactly capacity objects when completely full
    }

    // Initializes this object to contain exactly capacity objects when completely full
    public int getSize() {
        int size = 0;
        for (int i = 0; i < deck.length; i++) {
            if (deck[i] != null) {
                size += 1;
            }
        }
        return size;
        // Returns the number of critters currently being stored in the Pakudex
    }

    // Returns the number of critters currently being stored in the Pakudex
    public int getCapacity() {
        return deck.length;
        //Returns the number of critters that the Pakudex has the capacity to hold at most
    }

    public String[] getSpeciesArray() {
        //Returns a String array containing the species of the critters as ordered in the Pakudex; if there are no species added yet, this method should return null
        int count;
        for (count = 0; count < deck.length; count++) {
            if (deck[count] == (null)) {
                break;
            }
        }
        String[] PakudexDeck = new String[count];
        for (int i = 0; i < PakudexDeck.length; i++) {
            PakudexDeck[i] = deck[i].getSpecies();
        }
        int size = 0;
        for (int i = 0; i < deck.length; i++) {
            if (deck[i] != null) {
                size += 1;
            }
        }
        if (size == 0) {
            return null;
        }
        return PakudexDeck;
    }

    public int[] getStats(String species) {
        // Returns an int array containing the attack, defense, and speed statistics of species at indices 0, 1, and 2 respectively; if species is not in the Pakudex, returns null
        int[] curStats = new int[3];
        boolean returnStats = false;
        for (int i = 0; i < deck.length; i++) {
            if ((deck[i] != null) && species.equals(deck[i].getSpecies())) {
                returnStats = true;
                break;
            }
        }
        if (returnStats) {
            for (int i = 0; i < deck.length; i++) {
                if (deck[i].getSpecies().equals(species)) {
                    curStats[0] = deck[i].getAttack();
                    curStats[1] = deck[i].getDefense();
                    curStats[2] = deck[i].getSpeed();
                    return curStats;
                } else if (i == deck.length - 1) {
                    return curStats;
                }
            }
        }
        return null;
    }

    public void sortPakuri() {
        //Sorts the Pakuri objects in this Pakudex according to Java standard lexicographical ordering of species name
        boolean sortPakuri = true;
        for (int i = 0; i < deck.length && sortPakuri; i++) {
            sortPakuri = false;
            for (int j = 1; j < deck.length; j++) {
                if (deck[j]!=null && (deck[j].getSpecies()).compareTo(deck[j - 1].getSpecies()) < 0) {
                    Pakuri temp = deck[j];
                    deck[j] = deck[j - 1];
                    deck[j - 1] = temp;
                    sortPakuri = true;
                }
            }
        }
        System.out.println("Pakuri have been sorted!");
    }

    public boolean addPakuri(String species) {
        boolean added = true;
        int size = 0;
        for (int i = 0; i < deck.length; i++) {
            if (deck[i] != null) {
                size += 1;
            }
        }
        if (size == deck.length) {
            added = false;
            System.out.print("Error: Pakudex is full!");
            return added;
        }
        if (added) {
            for (int i = 0; i < deck.length; i++) {
                if ((deck[i] != null) &&
                        species.equalsIgnoreCase(deck[i].getSpecies())) {
                    added = false;
                    System.out.println("Error: Pakudex already contains this species!");
                    return added;
                }
            }
        }
        if (added) {
            Pakuri newPakuri = new Pakuri(species);
            deck[size] = newPakuri;
        }
//Adds species to the Pakudex; if successful, return true, and false otherwise
        System.out.print("Pakuri species " + species + " successfully added!");
        return added;
    }

    public boolean evolveSpecies(String species) {
        //Attempts to evolve species within the Pakudex; if successful, return true, and false otherwise
        boolean evolve = false;
        for (int i = 0; i < deck.length; i++) {
            if ((deck[i] != null) && species.equals(deck[i].getSpecies())) {
                deck[i].evolve();
                evolve = true;
            }
        }
        return evolve;
    }
}

