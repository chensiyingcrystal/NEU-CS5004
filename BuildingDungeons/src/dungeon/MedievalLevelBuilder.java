package dungeon;

import java.util.ArrayList;
import java.util.List;


public class MedievalLevelBuilder {
    private int levelNumber;
    private int numberOfRooms;
    private int numberOfMonsters;
    private int numberOfTreasures;
    private List<Room> rooms;
    private int totalMonster;
    private int totalTreasures;

    public MedievalLevelBuilder(int l, int r, int m, int t) {
        if (l < 0 || r < 0 || m < 0 || t < 0) {
            throw new IllegalArgumentException("Levels, rooms, monsters or treasures cannot be negative value!");
        }

        this.levelNumber = l;
        this.numberOfRooms = r;
        this.numberOfMonsters = m;
        this.numberOfTreasures = t;
        this.rooms = new ArrayList<>();

    }

    public void addRoom(String description) {
        if (rooms.size() == numberOfRooms) {
            throw new IllegalStateException("No rooms can be added! It reaches the maximum capacity!");
        }

        rooms.add(new Room(description));

    }


    public void addGoblins(int roomNumber, int numberOfGoblins) {
        if (totalMonster + numberOfGoblins > numberOfMonsters) {
            throw new IllegalStateException("Cannot add this number of Goblins!");
        }

        if (rooms == null || roomNumber >= rooms.size()) {
            throw new IllegalArgumentException("The target room has not yet been created!");
        }

        String goblinDescrpition = "mischievous and very unpleasant, vengeful, and greedy creature whose primary purpose is to cause trouble to humankind";
        for (int i = 0; i < numberOfGoblins; i++) {
            Monster m = new Monster(TypeOfMonsters.goblin.toString(), goblinDescrpition, 7);
            rooms.get(roomNumber).addMonster(m);
        }

        totalMonster += numberOfGoblins;

    }

    public void addOrc(int roomNumber) {
        if (totalMonster == numberOfMonsters) {
            throw new IllegalStateException("Cannot add any orc!");
        }

        if (roomNumber >= rooms.size()) {
            throw new IllegalArgumentException("The target room has not yet been created!");
        }

        String orcDescription = "brutish, aggressive, malevolent being serving evil";
        Monster o = new Monster(TypeOfMonsters.orc.toString(), orcDescription, 20);
        rooms.get(roomNumber).addMonster(o);
        totalMonster++;

    }

    public void addOgre(int roomNumber) {
        if (totalMonster == numberOfMonsters) {
            throw new IllegalStateException("Cannot add any ogre!");
        }

        if (roomNumber >= rooms.size()) {
            throw new IllegalArgumentException("The target room has not yet been created!");
        }

        String ogreDescription = "large, hideous man-like being that likes to eat humans for lunch";
        Monster og = new Monster(TypeOfMonsters.ogre.toString(), ogreDescription, 50);
        rooms.get(roomNumber).addMonster(og);
        totalMonster++;

    }

    public void addHuman(int roomNumber, String name, String description, int value) {
        if (totalMonster == numberOfMonsters) {
            throw new IllegalStateException("Cannot add any human!");
        }

        if (roomNumber >= rooms.size()) {
            throw new IllegalArgumentException("The target room has not yet been created!");
        }

        Monster human = new Monster(name, description, value);
        rooms.get(roomNumber).addMonster(human);
        totalMonster++;

    }

    public void addPotion(int roomNumber) {
        if (totalTreasures == numberOfTreasures) {
            throw new IllegalStateException("Cannot add any treasure now!");
        }

        if (roomNumber >= rooms.size()) {
            throw new IllegalArgumentException("The target room has not yet been created!");
        }

        Treasure p = new Treasure("a healing potion", 1);
        rooms.get(roomNumber).addTreasure(p);
        totalTreasures++;
    }


    public void addGold(int roomNumber, int value) {
        if (totalTreasures == numberOfTreasures) {
            throw new IllegalStateException("Cannot add this pieces of gold treasure now!");
        }

        if (roomNumber >= rooms.size()) {
            throw new IllegalArgumentException("The target room has not yet been created!");
        }


        Treasure g = new Treasure("pieces of gold", value);
        rooms.get(roomNumber).addTreasure(g);
        totalTreasures++;

    }

    public void addWeapon(int roomNumber, String weapon) {
        if (totalTreasures == numberOfTreasures) {
            throw new IllegalStateException("Cannot add this pieces of weapon treasure now!");
        }

        if (roomNumber >= rooms.size()) {
            throw new IllegalArgumentException("The target room has not yet been created!");
        }

        Treasure w = new Treasure(weapon, 10);
        rooms.get(roomNumber).addTreasure(w);
        totalTreasures++;

    }

    public void addSpecial(int roomNumber, String specialDescription, int value) {
        if (totalTreasures == numberOfTreasures) {
            throw new IllegalStateException("Cannot add any treasure now!");
        }

        if (roomNumber >= rooms.size()) {
            throw new IllegalArgumentException("The target room has not yet been created!");
        }

        rooms.get(roomNumber).addTreasure(new Treasure(specialDescription, value));
        totalTreasures++;
    }

    public Level build() {
        if (rooms == null || rooms.size() < numberOfRooms || totalTreasures < numberOfTreasures || totalMonster < numberOfMonsters) {
            throw new IllegalStateException("Cannot initialize a level until it is completed!");
        }


        return new Level(levelNumber, rooms);
    }


    public static void main(String[] args) {

    }

}
