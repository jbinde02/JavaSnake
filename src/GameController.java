import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

/**
 * This class works the game loop, creates the frame, and manages the controls.
 *
 * @author Jacob Binder
 */

class GameController{
    private JFrame frame;
    private GameField field;
    private GameView view;
    private boolean isPlaying;

    /**
     * The constructor is creating the frame and the game loop which runs Update using a timer. The speed can be changed
     * by altering the frameRate integer. x frameRate = x frames per second.
     */
    GameController(){
        field = new GameField();
        view = new GameView(field);
        createFrame();
        frame.add(view);
        createListener();
        int frameRate = 10;
        Timer timer = new Timer();
        isPlaying = true;

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if (isPlaying) {
                    update();
                }
            }
        };
        timer.schedule(timerTask, 0, 1000/ frameRate);
        System.out.println("Controller running");
    }

    /**
     * These will run every frame.
     */
    private void update(){
        checkDirection();
        checkCollision();
        checkFood();
        view.repaint();
    }

    private void createFrame(){
        frame = new JFrame("SnakeFrame");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    /**
     * This handles keyboard inputs.
     */
    private void createListener(){
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                int keyCode = e.getKeyCode();
                switch( keyCode ) {
                    case KeyEvent.VK_UP:
                        // handle up
                        moveUp();
                        break;
                    case KeyEvent.VK_DOWN:
                        // handle down
                        moveDown();
                        break;
                    case KeyEvent.VK_LEFT:
                        // handle left
                        moveLeft();
                        break;
                    case KeyEvent.VK_RIGHT :
                        // handle right
                        moveRight();
                        break;
                    case KeyEvent.VK_SPACE :
                        // Debug Stop
                        moveStop();
                        break;
                }
            }
        });
    }

    private void moveRight(){
        if(field.getDirection().equals("right") || field.getDirection().equals("left") ){
            return;
        }
        field.setDirection("right");
    }

    private void moveDown(){
        if(field.getDirection().equals("down") || field.getDirection().equals("up")){
            return;
        }
        field.setDirection("down");
    }

    private void moveLeft(){
        if(field.getDirection().equals("left") || field.getDirection().equals("right")){
            return;
        }
        field.setDirection("left");
    }

    private void moveUp(){
        if(field.getDirection().equals("up") || field.getDirection().equals("down")){
            return;
        }
        field.setDirection("up");
    }

    private void moveStop(){
        if(field.getDirection().equals("none")){
            return;
        }
        field.setDirection("none");
    }

    /**
     * Tells snake in the field class to move. If snake hits the wall, trigger a game over.
     */
    private void checkDirection(){
        if(field.moveBody(field.getDirection())){
            System.out.println("Hit Wall!");
            gameOver();
        }

    }

    /**
     * Checks if the head has run into itself. If true then trigger a game over.
     */
    private void checkCollision(){
        if(field.isHeadCollision()){
            System.out.println("Body Collision!");
            gameOver();
        }
    }

    /**
     * Checks if there is food on the field. If not, add food to random spot on field.
     */
    private void checkFood(){
        if(!field.foodExist()){
            field.addRandomFood();
        }
    }

    private void gameOver(){
        System.out.println("Game Over!");
        isPlaying = false;
    }
}
