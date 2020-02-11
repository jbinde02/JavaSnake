
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

class GameController{
    Timer timer;
    TimerTask timerTask;
    private JFrame frame;
    private GameField field;
    private GameView view;
    GameController(){
         view = new GameView();
         createFrame();
         frame.add(view);
         createListener();

        timer = new Timer();

        timerTask = new TimerTask() {
            @Override
            public void run() {
                update();
            }
        };

        timer.schedule(timerTask, 0, 500);
         System.out.println("Controller running");
    }
    public void update(){
        view.checkDirection();
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
                        view.moveUp();
                        break;
                    case KeyEvent.VK_DOWN:
                        // handle down
                        view.moveDown();
                        break;
                    case KeyEvent.VK_LEFT:
                        // handle left
                        view.moveLeft();
                        break;
                    case KeyEvent.VK_RIGHT :
                        // handle right
                        view.moveRight();
                        break;
                }
            }
        });
    }
}
