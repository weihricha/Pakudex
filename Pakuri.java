public class Pakuri {
    private String species;
    private int attack, defense, speed;

    public Pakuri(String species) {
        this.species = species;
        this.attack = (species.length() * 7) + 9;
        this.defense = (species.length() * 5) + 17;
        this.speed = (species.length() * 6) + 13;

        //This method should be the only constructor for this class. There should not be a default constructor!
    }

    public String getSpecies() {
        return species;
        //Returns the species of this critter
    }

    public int getAttack() {
        return attack;
        //Returns the attack value for this critter
    }

    public int getDefense() {
        // Returns the defense value for this critter
        return defense;
    }

    public int getSpeed() {
        return speed;
        //Returns the speed of this critter
    }

    public void setAttack(int newAttack) {
        this.attack = newAttack;
        //Changes the attack value for this critter to newAttack
    }

    public void evolve() {
        attack = attack*2;
        defense = defense*4;
        speed = speed*3;

        //Will evolve the critter as follows: a) double the attack; b) quadruple the defense; and c) triple the speed}
    }
}

