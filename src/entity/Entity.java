package entity;

import util.TextUtil;

public abstract class Entity {
    protected String name;
    protected int maxHp;
    protected int currentHp;
    protected int defense;

    public Entity(String name, int maxHp, int defense) {
        this.name = name;
        this.maxHp = maxHp;
        this.currentHp = maxHp;
        this.defense = defense;
    }

    // --- Encapsulated methods ---
    public void takeDamage(int damage) {
        int reduced = Math.max(0, damage - defense);
        currentHp = Math.max(0, currentHp - reduced);
        TextUtil.typewriterPrint(name + " takes " + reduced + " damage! (" + currentHp + "/" + maxHp + ")");
    }

    public void heal(int amount) {
        currentHp = Math.min(maxHp, currentHp + amount);
        TextUtil.typewriterPrint(name + " heals " + amount + " HP! (" + currentHp + "/" + maxHp + ")");
    }

    // --- Abstract / Polymorphic Methods ---
    public abstract void displayStats();

    public boolean isAlive() {
        return currentHp > 0;
    }

    public String getName() { return name; }
    public int getCurrentHp() { return currentHp; }
    public int getMaxHp() { return maxHp; }
}
