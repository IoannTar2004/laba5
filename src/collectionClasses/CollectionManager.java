package src.collectionClasses;

import java.util.ArrayDeque;
import java.util.Deque;

public class CollectionManager {
    private static Deque<Dragon> dragons = new ArrayDeque<>();

    public static void add(Dragon dragon) {
        dragons.add(dragon);
    }
    public static int length() {
        return dragons.size();
    }
    public static void remove(int i) {
        Dragon dragon = (Dragon) dragons.toArray()[i];
        dragons.remove(dragon);
    }
    public static void removeAll() {
        dragons.removeAll(dragons);
    }

    //getters
    public static String getName(int i) {
        Dragon dragon = (Dragon) dragons.toArray()[i];
        return dragon.getName();
    }
    public static Long getId(int i) {
        Dragon dragon = (Dragon) dragons.toArray()[i];
        return dragon.getId();
    }
    public static String getCoordinates(int i) {
        Dragon dragon = (Dragon) dragons.toArray()[i];
        return dragon.getCoordinates();
    }
    public static String getColor(int i) {
        Dragon dragon = (Dragon) dragons.toArray()[i];
        return dragon.getColor();
    }
    public static String getCharacter(int i) {
        Dragon dragon = (Dragon) dragons.toArray()[i];
        return dragon.getCharacter();
    }
    public static double getCave(int i) {
        Dragon dragon = (Dragon) dragons.toArray()[i];
        return dragon.getCave();
    }
    public static String getCreationDate(int i) {
        Dragon dragon = (Dragon) dragons.toArray()[i];
        return dragon.getCreationDate();
    }
    public static Integer getAge(int i) {
        Dragon dragon = (Dragon) dragons.toArray()[i];
        return dragon.getAge();
    }
    public static String getType(int i) {
        Dragon dragon = (Dragon) dragons.toArray()[i];
        return dragon.getType();
    }

    //updates
    public static void updateName(int i, String name) {
        Dragon dragon = (Dragon) dragons.toArray()[i];
        dragon.setName(name);
    }
    public static void updateCoordinates(int i, Coordinates coordinates) {
        Dragon dragon = (Dragon) dragons.toArray()[i];
        dragon.setCoordinates(coordinates);
    }
    public static void updateAge(int i, Integer age) {
        Dragon dragon = (Dragon) dragons.toArray()[i];
        dragon.setAge(age);
    }
    public static void updateColor(int i, Color color) {
        Dragon dragon = (Dragon) dragons.toArray()[i];
        dragon.setColor(color);
    }
    public static void updateType(int i, DragonType type) {
        Dragon dragon = (Dragon) dragons.toArray()[i];
        dragon.setType(type);
    }
    public static void updateCharacter(int i, DragonCharacter character) {
        Dragon dragon = (Dragon) dragons.toArray()[i];
        dragon.setCharacter(character);
    }
    public static void updateCave(int i, DragonCave cave) {
        Dragon dragon = (Dragon) dragons.toArray()[i];
        dragon.setCave(cave);
    }
}
