package Main;

import Entity.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    //original image size + scaling factor
    final int ORIGINAL_TILE_SIZE = 16;
    final int SCALE = 3;

    //tile/image size
    public final int TILE_SIZE = ORIGINAL_TILE_SIZE * SCALE;

    //Screen Settings
    public final int MAX_SCREEN_COLUMN = 18;
    public final int MAX_SCREEN_ROW = 14;
    public final int SCREEN_WIDTH = MAX_SCREEN_COLUMN * TILE_SIZE;
    public final int SCREEN_HEIGHT = MAX_SCREEN_ROW * TILE_SIZE;

    //Prologue World Size
    public final int MAX_WORLD_COLUMN = 42;
    public final int MAX_WORLD_ROW = 75;
    public final int WORLD_WIDTH = MAX_WORLD_COLUMN * TILE_SIZE;
    public final int WORLD_HEIGHT = MAX_WORLD_ROW * TILE_SIZE;

    //Game Thread
    Thread gameThread;
    final int FPS = 60;


    //External classes
    public KeyHandler keyHandler = new KeyHandler(this);
    public Player player = new Player(this,keyHandler);

    //Game states
    public int gameState = 0;
    public final int titleState = -1;
    public final int playState = 0;
    public final int pauseState = 1;
    public final int dialogueState = 2;
    public final int characterState = 3;



    public GamePanel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.addKeyListener(keyHandler);


    }


    public void setUpGame(){

    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }


    @Override
    public void run() {
        double drawInterval = 1000000000.0 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while(gameThread != null){

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;

            lastTime = currentTime;

            if(delta >= 1) {
                //1 Update information
                update();

                //2 draw the objects in the panels
                repaint();

                delta--;
            }





        }


    }

    public void update() {

    }


    public void paintComponent(Graphics g){

        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;



        g2d.dispose();


    }

}
