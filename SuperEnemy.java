 /*Class: SuperEnemy
  *Extends - null
  *Purpose - Class for Enemies to be instantiated from.
  */

 import java.util.Random;

 public class SuperEnemy {

     //all enemy stats
     public BufferedImage image;
     public String name;
     public int xLocation, yLocation;
     public static int EnemyMaxHp;
     public static int EnemyHp;
     public static String EnemyStatus;
     public int EnemyCoins;
     public static BufferedImage baz1, baz2, baz3, bazHit;
     public int spriteCounter = 0;
     public int spriteNum = 1;
     public static boolean enemyDead = false;
     public static String enemyName;
     public static int Level;
     public static Random random = new Random();
     public static int damage = 10 + random.nextInt(30);

     //function to draw enemy
     public void draw(Graphics2D g2, GamePanel gp) {

         g2.drawImage(image, xLocation, yLocation, image.getWidth() * 3, image.getHeight() * 3, null);
         g2.setColor(Color.red);
         g2.fillRect(xLocation + 280, yLocation + 200, EnemyHp * 3, 30);
     }

 }