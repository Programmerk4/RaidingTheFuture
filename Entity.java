/*Class:Entity
 * Extends - null
 * Purpose - This is the parent class for the playable characters to be instantiated from.
 */

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

    public int speed;
    GamePanel gp;
    public SuperEnemy enemy[] = new SuperEnemy[1];

    public static BufferedImage bash1, bash2, bash3, bash4, bash5, bash6, bodySlam1;
    public static String status;

    public int spriteCounter = 0;
    public int spriteNum = 1;

    public String attack;

    //Player Attributes
    public int type;
    public String name;
    static public int maxHp;
    static public int Hp;
    static public int MaxMana;
    static public int mana;
    static public int Shield;
    static public int coins;
    public static int Damage;
    static public boolean dead = false;
    static public int score;
    static public boolean fightState;

    public Entity(GamePanel gp) {
        this.gp = gp;
    }

}
