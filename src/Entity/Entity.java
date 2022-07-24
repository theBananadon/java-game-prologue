package Entity;

import Main.GamePanel;
import Main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

    //Game Panel
    GamePanel gp;

    //World location
    public int worldX, worldY;


    //images
    public BufferedImage up1, up2, down1, down2, right1, right2, left1, left2;

    //direction
    public char direction = 'd';

    //Sprite animation
    public int spriteCounter = 0;
    public int spriteNumber = 1;

    //Collision
    public Rectangle solidArea = new Rectangle(0,0,48,48);
    public boolean collisionOn = false;
    public int solidAreaDefaultX, solidAreaDefaultY;

    //Movement
    public int actionLockCounter = 0;

    //Dialogue
    String[] dialogue = new String[50];
    int dialogueIndex = 0;

    //Character Stats
    public int maxLife;
    public int life;

    public String name;
    public int speed;
    public int level;
    public int strength;
    public int dexterity;
    public int attack;
    public int defence;
    public int exp;
    public int nextLevelExp;
    public int coin;
    public int maxMana;
    public int mana;
    public Entity currentWeapon;
    public Entity currentShield;



    public Entity(GamePanel gp){
        this.gp = gp;
    }


    public BufferedImage setUp(String imagePath, int width, int height){
        UtilityTool utilityTool = new UtilityTool();
        BufferedImage scaledImage = null;

        try{
            scaledImage = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
            scaledImage = utilityTool.scaleImage(scaledImage, width, height);
        } catch (Exception e){
            e.printStackTrace();
        }
        return scaledImage;
    }

}
