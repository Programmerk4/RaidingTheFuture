
/*Class:Player
 * Extends - Entity
 * Purpose - This is where the player is instantiated with all the specific methods and attributes.
 */

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Player extends Entity {

    static int x, y;
    static int yVelocity = -40, xVelocity = 25, gravity = 2;

    static boolean bashAttacking;
    static public BufferedImage currentImage;

    public Player(GamePanel gp) {
        super(gp);
        this.gp = gp;

        setDefaultValues();
        getBashImage();
    }

    /*Method = setDefaultValues
     * parameters = nothing’
     * Purpose - it is to set the default values of the players
     */

    public void setDefaultValues() {
        x = 100;
        y = 360;
        speed = 4;
        bashAttacking = false;
        status = "idle";
        fightState = true;

        //Currently i am setting up the player's character's default value
        maxHp = 120; // More Hp = player can endure more damage from enemies
        Hp = maxHp;
        MaxMana = 4; // More mana = higher Potential for using more cards
        mana = MaxMana;
        coins = 0; // To buy items from the game's shop
        Shield = 0; //First to take damage, before the HP bar
    }
    /*Method = getBashImage
     * parameters = nothing’
     * Purpose -to get the bash images
     */
    public void getBashImage() {
        try {
            bash1 = ImageIO.read(getClass().getResourceAsStream("/Bash/Bash1.png"));
            bash2 = ImageIO.read(getClass().getResourceAsStream("/Bash/Bash2.png"));
            bash3 = ImageIO.read(getClass().getResourceAsStream("/Bash/Bash3.png"));
            bash4 = ImageIO.read(getClass().getResourceAsStream("/Bash/Bash4.png"));
            bash5 = ImageIO.read(getClass().getResourceAsStream("/Bash/Bash5.png"));
            bash6 = ImageIO.read(getClass().getResourceAsStream("/Bash/Bash6.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (Hp > 0) {
            if (status.equals("bash")) {
                spriteCounter++;
                if (spriteCounter > 10) {
                    if (spriteNum == 1) {
                        spriteNum = 2;
                    } else if (spriteNum == 2) {
                        spriteNum = 1;
                    }
                    spriteCounter = 0;
                }
            } else if (status.equals("idle")) {
                currentImage = bash6;
            }

        } else {
            dead = true;
        }

    }

    public void draw(Graphics2D g2) {
        currentImage = null;
        switch (status) {
            case "idle":
                currentImage = bash5;
            case "bash":
                if (spriteNum == 1) {
                    currentImage = bash1;
                }
                if (spriteNum == 2) {
                    currentImage = bash2;
                }
                if (spriteNum == 3) {
                    currentImage = bash3;
                }
                if (spriteNum == 4) {
                    currentImage = bash4;
                }
                if (spriteNum == 5) {
                    currentImage = bash5;
                }
                if (spriteNum == 6) {
                    currentImage = bash6;
                }
        }
        g2.drawImage(currentImage, x, y, bash2.getWidth() * 4, bash2.getHeight() * 4, null);

        //Health Bar
        g2.setColor(Color.green);
        g2.fillRect(x, y + 140, Hp * 2, 30);

        //Shield Bar
        Color ShieldColor = new Color(122, 185, 222);
        g2.setColor(ShieldColor);
        g2.fillRect(x + (Hp * 2), y + 140, Shield, 30);

    }

    public static void ScoreCalculator() {
        score = (maxHp - Hp) * 100 - SuperEnemy.EnemyMaxHp;
    }

    public static void windUp() {
        // A timer is made so loops occur periodically and not instantly
        //movement towards the enemy
        System.out.println("windup complete");
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            int counter = 50;

            @Override
            public void run() {
                if (counter > 0) {

                    x = x + 20;
                    counter--;
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 3);
    }

    public static void BackToStart() {
        //movement away from the enemy
        System.out.println("back to start complete");
        status = "idle";
        Damage = 5;
        status = "bash";
        SuperEnemy.EnemyStatus = "idle";
        Timer timer = new Timer();
        TimerTask task3 = new TimerTask() {
            int counter = 50;
            @Override
            public void run() {
                status = "idle";
                status = "bash";
                SuperEnemy.EnemyStatus = "idle";

                if (counter > 0) {
                    x = x - 20;
                    counter--;
                }

            }
        };
        timer.scheduleAtFixedRate(task3, 1000, 3);
    }

    public static void JumpingBackToStart() {
        status = "idle";
        status = "bash";
        SuperEnemy.EnemyStatus = "idle";
        Timer timer = new Timer();
        TimerTask task3 = new TimerTask() {
            int counter = 50;
            @Override
            public void run() {
                status = "idle";
                SuperEnemy.EnemyStatus = "idle";
                yVelocity = 0;
                xVelocity = 0;
                gravity = 0;
                x = 320;

            }
        };

        timer.scheduleAtFixedRate(task3, 1000, 3);
    }

    public static void BashAttack() {
        // status ensures that the right image is drawn for the attack
        status = "bash";
        System.out.println("BashAttack complete"); //Used as a form of validation to make sure that the attack is being completed
        Timer timer2 = new Timer();
        TimerTask task2 = new TimerTask() {

            @Override
            public void run() {
                if (mana > 1) {
                    Damage = 10;
                    status = "bash";
                    SuperEnemy.EnemyStatus = "attacked";
                    mana -= 2;
                    SuperEnemy.EnemyHp = SuperEnemy.EnemyHp - Damage; //Simple calculation for damage, redraws the health bar to demonstrate change in health
                } else {
                    System.out.println("Not enough Mana"); // Will notify the player that the attack is unable to be completed
                }
            }

        };
        timer2.schedule(task2, 100);
    }

    public static void IronWaveAttack() {
        // status ensures that the right image is drawn for the attack
        status = "ironWave";
        System.out.println("IronWave complete"); //Used as a form of validation to make sure that the attack is being completed
        Timer timer2 = new Timer();
        TimerTask task2 = new TimerTask() {

            @Override
            public void run() {
                if (mana > 0) {
                    Damage = 10;
                    Shield = Shield + 10;
                    status = "bash";
                    SuperEnemy.EnemyStatus = "attacked";
                    mana -= 1;
                    SuperEnemy.EnemyHp = SuperEnemy.EnemyHp - Damage; //Simple calculation for damage, redraws the health bar to demonstrate change in health
                } else {
                    System.out.println("Not enough Mana"); // Will notify the player that the attack is unable to be completed
                }
            }

        };
        timer2.schedule(task2, 100);
    }

    public static void BodySlamAttack() {
        // status ensures that the right image is drawn for the attack
        status = "bash";
        System.out.println("BodySlam complete"); //Used as a form of validation to make sure that the attack is being completed
        Timer timer2 = new Timer();
        TimerTask task2 = new TimerTask() {

            @Override
            public void run() {
                if (mana > 0) {
                    Damage = Shield;
                    status = "bash";
                    SuperEnemy.EnemyStatus = "attacked";
                    mana -= 1;
                    SuperEnemy.EnemyHp = SuperEnemy.EnemyHp - Damage; //Simple calculation for damage, redraws the health bar to demonstrate change in health
                } else {
                    System.out.println("Not enough Mana"); // Will notify the player that the attack is unable to be completed
                }
            }

        };
        timer2.schedule(task2, 100);
    }

    public static void block() {
        if (mana > 0) {
            Shield = Shield + 10; //given shield to player
            SuperEnemy.EnemyStatus = "idle";
            mana -= 1;
        } else {
            System.out.println("Not enough Mana");
        }

    }
}