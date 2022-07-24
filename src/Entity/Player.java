package Entity;

import Main.GamePanel;
import Main.KeyHandler;

import java.awt.*;

public class Player extends Entity{

    KeyHandler keyHandler;

    public int screenX;
    public int screenY;
    boolean flash = false;
    int flashCounter = 0;

    public Player(GamePanel gp, KeyHandler keyHandler) {
        super(gp);

        this.keyHandler = keyHandler;
        setDefaultValues();
        getPlayerImage();


    }

    public void setDefaultValues(){
        worldX = 23;
        worldY = 21;


        screenX = gp.SCREEN_WIDTH / 2 - gp.TILE_SIZE / 2;
        screenY = gp.SCREEN_HEIGHT / 2 - gp.TILE_SIZE / 2;

        solidArea = new Rectangle();

        //Changing y to centralize it requires tweaking with height
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = gp.TILE_SIZE - (2 * solidArea.x);
        solidArea.height = gp.TILE_SIZE - solidArea.y;

        //Player Status
        level = 1;
        maxLife = 6;
        life = maxLife;
        maxMana = 4;
        mana = maxMana;
        strength = 1;
        dexterity = 1;
        exp = 0;
        nextLevelExp = 5;
        coin = 0;
    }

    public void getPlayerImage(){

        up1 = setUp("/player/tyrone_up_1", gp.TILE_SIZE, gp.TILE_SIZE);
        up2 = setUp("/player/tyrone_up_2", gp.TILE_SIZE, gp.TILE_SIZE);
        down1 = setUp("/player/tyrone_down_1", gp.TILE_SIZE, gp.TILE_SIZE);
        down2 = setUp("/player/tyrone_down_2", gp.TILE_SIZE, gp.TILE_SIZE);
        right1 = setUp("/player/tyrone_right_1", gp.TILE_SIZE, gp.TILE_SIZE);
        right2 = setUp("/player/tyrone_right_2", gp.TILE_SIZE, gp.TILE_SIZE);
        left1 = setUp("/player/tyrone_left_1", gp.TILE_SIZE, gp.TILE_SIZE);
        left2 = setUp("/player/tyrone_left_2", gp.TILE_SIZE, gp.TILE_SIZE);

    }

    public void update(){

        if(keyHandler.up || keyHandler.down || keyHandler.left || keyHandler.right){

            if(keyHandler.up){
                direction = 'U';
            }

            if(keyHandler.down){
                direction = 'D';
            }

            if(keyHandler.right){
                direction = 'R';
            }

            if(keyHandler.left){
                direction = 'L';
            }

        }


    }

}
