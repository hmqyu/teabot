package minigames.cockfighting;

import java.util.concurrent.ThreadLocalRandom;

public class Cock {
    private int height;                          // height of chicken in inches
    private int weight;                          // weight of chicken in pounds
    private String colour;                       // colour of the chicken
    private static final String[] CHICKEN_COLOURS = { "White", "Silver", "Grey", "Orange", "Red", "Brown", "Black" };

    private static final int MAX_HEALTH = 100;   // the maximum health a chicken can have
    private int health = 100;                    // how much health the chicken has
    private boolean isAlive = true;              // if the chicken is alive (>0 health) or not
    private int attack;                          // how hard the chicken hits
    private int defense;                         // how well the chicken puts up against attacks
    private int speed;                           // how quickly the chicken fights
    private Level level;                         // current level of the chicken

    public Cock() {
        this.height = ThreadLocalRandom.current().nextInt(1, 27 + 1);
        this.weight = ThreadLocalRandom.current().nextInt(1, 6 + 1);
        this.colour = CHICKEN_COLOURS[ThreadLocalRandom.current().nextInt(0, 6 + 1)];
        this.attack = ThreadLocalRandom.current().nextInt(1, 5 + 1);
        this.defense = ThreadLocalRandom.current().nextInt(1, 5 + 1);
        this.speed = ThreadLocalRandom.current().nextInt(1, 5 + 1);
        this.level = new Level();
    }

    public Cock(int height, int weight, String colour, int health, int attack, int defense, int speed, Level level) {
        this.height = height;
        this.weight = weight;
        this.colour = colour;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.level = level;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void loseHealth(int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            this.health = 0;
            this.isAlive = false;
        }
    }

    public void restoreHealth() {
        this.health = MAX_HEALTH;
        this.isAlive = true;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void gainExp() {
        if (this.level.gainExp()) {
            attack += ThreadLocalRandom.current().nextInt(0, 2 + 1);
            defense += ThreadLocalRandom.current().nextInt(0, 2 + 1);
            speed += ThreadLocalRandom.current().nextInt(0, 2 + 1);
        }
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
