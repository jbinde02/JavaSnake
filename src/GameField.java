
public class GameField {
    int[] xar = new int[25];
    int[] yar = new int[25];
    Cell[][] cellarry = new Cell[xar.length][yar.length];
    Snake snake;
    GameField(){
        System.out.println("Field running");
        createGrid();
        snake = new Snake(2, 2);
        addSnake();
    }

    private void createGrid(){
        populateXY();
        populateCell();
    }

    private void populateXY(){
        int x = 0;
        int y = 0;
        for(int i = 0; i<xar.length; i++) {
            xar[i] = x;
            x+= 20;
        }
        for(int i = 0; i<yar.length; i++) {
            yar[i] = y;
            y+= 20;
        }

    }

    private void populateCell(){
        for(int i = 0; i<xar.length; i++){
            for(int j = 0; j<yar.length; j++){
                cellarry[i][j] = new Cell(xar[i],yar[j], false);
            }
        }
    }

    public void changeActive(Cell c){
        if(!c.active){
            c.setActive(true);
        }else{
            c.setActive(false);
        }
    }

    public void checkAll(){
        for(int i = 0; i<xar.length; i++){
            for(int j = 0; j<yar.length; j++){
                changeActive(cellarry[i][j]);
            }
        }
    }

    public void addSnake(){
                changeActive(cellarry[snake.bodyarry[0].x][snake.bodyarry[0].y]);
    }

    public void removeSnake(){
                changeActive(cellarry[snake.bodyarry[0].x][snake.bodyarry[0].y]);
    }

    public void addBody(){
        for(int i = 0; i<snake.bodyarry.length; i++){
            if(snake.bodyarry[i] == null){
                snake.bodyarry[i] = new Cell(snake.bodyarry[i - 1].x - 1,snake.bodyarry[i - 1].y, true);
                System.out.println("This ran");
                break;
            }

        }
    }

    public void moveBody(String direction){
        for(int i = 0; i<snake.bodyarry.length; i++){
            if(snake.bodyarry[i] == null){
                break;
            }
            switch (direction){
                case "up":
                    snake.bodyarry[i].setY(--snake.bodyarry[i].y);
                    System.out.println("up");
                    break;
                case "down":
                    snake.bodyarry[i].setY(++snake.bodyarry[i].y);
                    System.out.println("down");
                    break;
                case "left":
                    snake.bodyarry[i].setX(--snake.bodyarry[i].x);
                    System.out.println("left");
                    break;
                case "right":
                    snake.bodyarry[i].setX(++snake.bodyarry[i].x);
                    System.out.println("right");
                    break;
            }
        }
    }

}
