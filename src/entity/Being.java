package entity;

import java.util.Objects;

public class Being extends Entity implements Comparable<Being> {

    public static final int DEFAULT_HEALTH = 20;

    private int MAX_HEALTH;
    private int hp;
    private int level;

    public Being(String name, String description, int hp) {
        super(name, description);

        if (hp < 1)
            hp = DEFAULT_HEALTH;

        this.level = 1;
        this.MAX_HEALTH = hp;
        this.hp = hp;
    }

    public Being(String name, String description) {
        this(name, description, DEFAULT_HEALTH);
    }

    public int getHP() {
        return hp;
    }

    public int getMAX_HP() {
        return MAX_HEALTH;
    }

    public void healMax() {
        hp = MAX_HEALTH;
    }

    public void heal(int amount) {
        if (amount > 0)
            this.hp += amount;
    }

    public void hurt(int amount) {
        if (amount > 0)
            hp -= amount;
        if (hp < 0)
            hp = 0;
    }

    public boolean isDead() {
        return hp < 0;
    }

    public void kill() {
        hp = 0;
    }

    public int getLevel() {
        return level;
    }

    private void updateMAX_HP() {
        // HP levelUP formula
        // (for 20 MAX_HP it goes by increments of 10,
        // but for 10 it will go by increments of 5)
        this.MAX_HEALTH += MAX_HEALTH / level;
    }

    public void levelUP() {
        level++;
        updateMAX_HP();
        healMax();
    }

    public void levelUP(int levels) {
        for (int i = 0; i < levels; i++)
            levelUP();
    }

    @Override
    public String getDisplay() {
        return getSimpleDisplay() + "\n" +
               "    lvl : " + level + "\n" +
               "    hp  : " + hp + "/" + MAX_HEALTH;
    }

    @Override
    public int compareTo(Being being) {
        return this.level - being.level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        if (!super.equals(o))
            return false;

        Being being = (Being) o;
        return hp == being.hp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hp);
    }
}
