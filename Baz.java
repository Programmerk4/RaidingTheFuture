import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Baz extends SuperEnemy {

    public Baz() {
        setDefaultValues();
        getBazImage();
        enemyName = "Baz";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("Images/Baz1.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void setDefaultValues() {
        xLocation = 890;
        yLocation = 300;
        EnemyStatus = "idle";

        //Currently i am setting up the player's character's default value
        EnemyMaxHp = 120; // More Hp = player can endure more damage from enemies
        EnemyHp = EnemyMaxHp;
        EnemyCoins = 60; // To buy items from the game's shop
        EnemyStatus = "idle";
        Level = 1;

    }

    public void getBazImage() {
        try {
            //sets image for enemy,
            baz1 = ImageIO.read(getClass().getResourceAsStream("Images/Baz1.png"));
            baz2 = ImageIO.read(getClass().getResourceAsStream("Images/Baz2.png"));
            baz3 = ImageIO.read(getClass().getResourceAsStream("Images/Baz3.png"));
            bazHit = ImageIO.read(getClass().getResourceAsStream("Images/BazHit.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (EnemyHp > 0) {
            if (EnemyStatus.equals("Attacked")) {
                spriteCounter++;
                if (spriteCounter > 10) {
                    if (spriteNum == 1) {
                        spriteNum = 2;
                    } else if (spriteNum == 2) {
                        spriteNum = 1;
                    }
                    spriteCounter = 0;
                }
            } else if (EnemyStatus.equals("attacking")) {
                image = baz3;
            }
        } else {
            enemyDead = true;
        }
    }
    /* Method : Attacking
     * parameters : Graphics2D g2, GamePanel gp
     * purpose :
     */

    public void draw(Graphics2D g2, GamePanel gp) {
        image = null;
        switch (EnemyStatus) {
            case "idle" -> image = baz1;
            case "attacked" -> image = bazHit;
            case "attacking" -> image = baz3;
        }
        assert image != null;
        g2.drawImage(image, xLocation, yLocation, image.getWidth() * 3, image.getHeight() * 3, null);
        //This is for the health Bar
        g2.setColor(Color.red);
        g2.fillRect(xLocation + 280, yLocation + 200, EnemyHp * 3, 30);
    }

    /* Method : Attacking
     * parameters : none
     * purpose : this is for the attacking phase for the enemy
     */
    public void attacking() {
        SuperEnemy.EnemyStatus = "attacking";
        //this leads to a change in animation
        System.out.println("BashAttack complete");
        Timer timer2 = new Timer();
        TimerTask task2 = new TimerTask() {
            int counter = 55;

            @Override
            public void run() {
                //damage calculations
                SuperEnemy.EnemyStatus = "attacking";
                if (Entity.Shield > 0) {
                    Entity.Shield = Entity.Shield - damage;
                    Entity.Hp = Entity.Hp + Entity.Shield;
                    Entity.mana = 4;
                    Entity.Shield = 0;
                } else Entity.Hp = Entity.Hp - damage;
                Entity.mana = 4;
                //resetting for player's tuirn
            }
        };
        for (int i = 0; i < 1; i++) {
            timer2.schedule(task2, 100);
        }

    }
}