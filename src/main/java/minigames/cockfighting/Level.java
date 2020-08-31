package minigames.cockfighting;

public class Level {
    private static final int EXP_PER_LEVEL = 100;   // exp needed to level up
    private static int EXP_PER_WIN = 25;            // exp gained per won fight
    private static final int EXP_REDUCTION = 1;     // exp per win reduction per level-up
    private static final int MIN_EXP_PER_WIN = 1;   // minimum exp gained from a fight
    private int level;                              // level of the chicken
    private int exp;                                // current exp
}
