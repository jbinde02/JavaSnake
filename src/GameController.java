package src;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class GameController{
    private JFrame frame;
    private GameField field;
    private GameView view;
    private KeyListener keyListener;
    GameController(){
         view = new GameView(field);
         createFrame();
         frame.add(view);
         createListener();
         System.out.println("Controller running");
    }

    private void createFrame(){
        frame = new JFrame("SnakeFrame");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void createListener(){
        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e){
                //System.out.println("Key Typed");
            }

            @Override
            public void keyPressed(KeyEvent e){
                //System.out.println("Key Pressed");
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
                    case KeyEvent.VK_SPACE :
                        // handle space
                        view.addBody();
                        break;
                }
                //view.moveActive();
            }

            @Override
            public void keyReleased(KeyEvent e){
                //System.out.println("Key Released");
            }
        });
    }


}
