package minigames.cockfighting;

public class CockFightDuel {
    private Cock cockOne;
    private Cock cockTwo;

    private static final int SPEED_PER_ATTACK = 5;   // speed required for another attack

    public CockFightDuel(Cock cockOne, Cock cockTwo) {
        this.cockOne = cockOne;
        this.cockTwo = cockTwo;
    }

    private int calculateDamage(int attack) {

        return 0;
    }

    private int calculateDamageReduction(int defense) {
        return 0;
    }

    private int calculateNumberOfAttacks(int speed) {
        return speed / SPEED_PER_ATTACK;
    }
}
