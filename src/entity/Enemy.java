package entity;

import core.Main;
import util.TextUtil;

public class Enemy {
    private String name;
    private int level;
    private int maxHp;
    private int currentHp;
    private int defense;
    private int[] attacks;
    private int turnCount;
    private boolean canDefend;
    private String idleAscii;

    public Enemy(String name, int level, int maxHp, int defense, int[] attacks, String idleAscii) {
    this.name = name;
    this.level = level;
    this.maxHp = maxHp;
    this.currentHp = maxHp;
    this.defense = defense;
    this.attacks = attacks;
<<<<<<< HEAD
    this.idleAscii = idleAscii;
=======
    this.idleAscii = idleAscii;        
    this.color = color;
>>>>>>> 1ce1d36a89a16d7b6b441f2b57dc63019383fe47
    this.turnCount = 0;
    this.canDefend = level >= 2;
}


    public void takeDamage(int damage) {
        int actualDamage = Math.max(0, damage - defense);
        currentHp -= actualDamage;
        if (currentHp < 0) currentHp = 0;

        TextUtil.typewriterPrint(name + " takes " + actualDamage + " damage! HP: " + currentHp + "/" + maxHp);
    }

    public int performAction() {
        turnCount++;

        if (level == 3 && turnCount % 3 == 0) {
            System.out.println(idleAscii);
            TextUtil.typewriterPrint(name + " unleashes a devastating special attack!");
            return 250;
        }

<<<<<<< HEAD
=======
    // Defensive
>>>>>>> 1ce1d36a89a16d7b6b441f2b57dc63019383fe47
        if (canDefend && Main.random.nextInt(100) < 30) {
            TextUtil.typewriterPrint(name + " takes a defensive stance!");
            return 0;
        }

        int attackIndex = Main.random.nextInt(attacks.length);
        int damage = attacks[attackIndex];

        System.out.println(idleAscii);
        TextUtil.typewriterPrint(name + " attacks with force!");

    return damage;
}


    public void displayStats() {
        System.out.println("\n--- " + name + " Stats ---");
        System.out.println(idleAscii);
        System.out.println("Level: " + level);
        System.out.println("HP: " + currentHp + "/" + maxHp);
        System.out.println("DEF: " + defense);
}


    // Getters
    public String getName() { return name; }
    public int getCurrentHp() { return currentHp; }
    public int getMaxHp() { return maxHp; }
    public int getLevel() { return level; }
    public int getDefense() { return defense; }
    public int[] getAttacks() { return attacks; }
    public boolean isAlive() { return currentHp > 0; }
    public String getIdleAscii() { return idleAscii; }
}
