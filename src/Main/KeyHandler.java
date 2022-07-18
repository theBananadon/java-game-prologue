package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    GamePanel gp;
    public boolean right, left, up, down, shift, enter, space;

    public KeyHandler(GamePanel gp){
        this.gp = gp;
    }



    public void titleState(int code) {

    }

    public void playState(int code) {
        if (code == KeyEvent.VK_W) {
            up = true;
        }
        if (code == KeyEvent.VK_S) {
            down = true;
        }
        if (code == KeyEvent.VK_D) {
            right = true;
        }
        if (code == KeyEvent.VK_A) {
            left = true;
        }
        if (code == KeyEvent.VK_ESCAPE) {
            gp.gameState = gp.pauseState;
        }
        if (code == KeyEvent.VK_SHIFT) {
            shift = true;
        }
        if(code == KeyEvent.VK_SPACE){
            space = true;
        }
        if(code == KeyEvent.VK_Q){
            gp.gameState = gp.characterState;
        }
    }

    public void pauseState(int code) {

    }

    public void dialogueState(int code) {

    }

    public void characterState(int code) {

    }






    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        //Title State
        if(gp.gameState == gp.titleState){
            titleState(code);
        }
        //Play State
        else if(gp.gameState == gp.playState) {
            playState(code);
        }

        //Pause State
        else if(gp.gameState == gp.pauseState){
            pauseState(code);
        }

        //Dialogue
        else if(gp.gameState == gp.dialogueState){
            dialogueState(code);
        }

        //Character State
        else if(gp.gameState == gp.characterState){
            characterState(code);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W){
            up = false;
        }
        if(code == KeyEvent.VK_S){
            down = false;
        }
        if(code == KeyEvent.VK_D){
            right = false;
        }
        if(code == KeyEvent.VK_A){
            left = false;
        }
        if(code == KeyEvent.VK_SPACE){
            space = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {



    }
}
