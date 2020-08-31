package minigames.cockfighting;

public class Level {
    private static final int EXP_PER_LEVEL = 100;   // exp needed to level up
    private static final int EXP_REDUCTION = 1;     // exp per win reduction per level-up
    private static final int MIN_EXP_PER_WIN = 1;   // minimum exp gained from a fight
    private int level;                              // level of the chicken
    private int exp;                                // current exp
    private int expPerWin;                          // exp gained per won fight

    public Level() {
        this.level = 1;
        this.exp = 0;
        this.expPerWin = 25;
    }

    public Level(int level, int exp, int expPerWin) {
        this.level = level;
        this.exp = exp;
        this.expPerWin = expPerWin;
    }

    // level increases by 1
    // exp per win gets decreased by 1 per level up
    // but exp per win cannot be less than 1
    public void levelUp() {
        level++;
        if (expPerWin > MIN_EXP_PER_WIN) {
            expPerWin -= EXP_REDUCTION;
        }
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    // gains exp
    // if the exp reaches 100 or more, the level increases and returns true, exp then gets reduced by 100
    // else returns false
    public boolean gainExp() {
        exp += expPerWin;
        if (exp >= EXP_PER_LEVEL) {
            exp -= EXP_PER_LEVEL;
            levelUp();
            return true;
        }
        return false;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getExpPerWin() {
        return expPerWin;
    }

    public void setExpPerWin(int expPerWin) {
        this.expPerWin = expPerWin;
    }
}
