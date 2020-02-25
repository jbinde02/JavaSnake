
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

class GameController{
    Timer timer;
    TimerTask timerTask;
    private JFrame frame;
    private GameField field;
    private GameView view;
    int frameRate;
    boolean isPlaying;
    GameController(){
        field = new GameField();
        view = new GameView(field);
        createFrame();
        frame.add(view);
        createListener();
        frameRate = 5;
        timer = new Timer();
        isPlaying = true;

        timerTask = new TimerTask() {
            @Override
            public void run() {
                if(isPlaying){
                    update();
                }
            }
        };
        timer.schedule(timerTask, 0, 1000/frameRate);
        System.out.println("Controller running");
    }
    public void update(){
        checkDirection();
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
                        System.out.print("up" + " ");
                        break;
                    case KeyEvent.VK_DOWN:
                        // handle down
                        moveDown();
                        System.out.print("down" + " ");
                        break;
                    case KeyEvent.VK_LEFT:
                        // handle left
                        moveLeft();
                        System.out.print("left" + " ");
                        break;
                    case KeyEvent.VK_RIGHT :
                        // handle right
                        moveRight();
                        System.out.print("right" + " ");
                        break;
                    case KeyEvent.VK_SPACE :
                        // Debug Stop
                        moveStop();
                        System.out.print("stop" + " ");
                        break;
                }
            }
        });
    }

    public void moveRight(){
        if(field.getDirection().equals("right") || field.getDirection().equals("left") ){
            return;
        }
        field.setDirection("right");
    }

    public void moveDown(){
        if(field.getDirection().equals("down") || field.getDirection().equals("up")){
            return;
        }
        field.setDirection("down");
    }

    public void moveLeft(){
        if(field.getDirection().equals("left") || field.getDirection().equals("right")){
            return;
        }
        field.setDirection("left");
    }

    public void moveUp(){
        if(field.getDirection().equals("up") || field.getDirection().equals("down")){
            return;
        }
        field.setDirection("up");
    }

    public void moveStop(){
        if(field.getDirection().equals("none")){
            return;
        }
        field.setDirection("none");
    }

    public void checkDirection(){
        try {
            field.moveBody(field.getDirection());
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage() + " Game Over!");
            isPlaying = false;

        }
    }
}
