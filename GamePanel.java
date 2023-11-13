/*Class:GamePanel
 * Extends - JPanel implements Runnable
 * Purpose - The panel is added to the fight screen alongside the card panel, where the player and enemy sprite is placed.
 */

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    final int screenWidth = 1600;
    final int screenHeight = 600;
    int FPS = 60;
    Thread gameThread;
    public Player player = new Player(this);
    public SuperEnemy[] enemy = new SuperEnemy[1];
    public AssetSetter assetSetter = new AssetSetter(this);
    public Baz baz = new Baz();
    public EndScreen endScreen = new EndScreen(this);
    public HUD_Graphics HUD_graphics = new HUD_Graphics(this);

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
    }

    public void setupGame() {
        assetSetter.setObject();
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000 / FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while (gameThread != null) {
            // 1 Update : update information  such as character positions
            update();
            //2 Draw: draw the screen with the updated information
            repaint();
            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime / 1000000;
                if (remainingTime < 0) {
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    public void update() {
        //updates the player's sprites
        player.update();
        baz.update();

    }

    /*Method :paint Component
     * Parameters : Graphics g
     * Purpose - Craws components onto the gamepanel
     */

    public void paintComponent(Graphics g) {
        //draws components onto the gamepanel
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        HUD_graphics.draw(g2);
        player.draw(g2);

        enemy[0].draw(g2, this);
        if (Entity.dead) {
            player.ScoreCalculator();
            endScreen.drawLoss(g2);
        }
        if (SuperEnemy.EnemyHp == 0) {
            player.ScoreCalculator();
            endScreen.drawWin(g2);
        }

        g2.dispose();
    }

}
