import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

class GameController{
    private JFrame frame;
    private GameField field;
    private GameView view;
    private boolean isPlaying;
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

    private void checkDirection(){
        if(field.moveBody(field.getDirection())){
            System.out.println("Hit Wall!");
            gameOver();
        }

    }

    private void checkCollision(){
        if(field.isHeadCollision()){
            System.out.println("Body Collision!");
            gameOver();
        }
    }

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
