
public class GameField {
    int[] xar = new int[25];
    int[] yar = new int[25];
    Cell[][] cellarry = new Cell[xar.length][yar.length];
    Snake snake;
    String direction;
    GameField(){
        System.out.println("Field running");
        createGrid();
        snake = new Snake();
        addBody(cellarry[2][2]);
        direction = "None";
    }
    public void addBody(Cell cell){
        snake.bodyarry.add(cell);
        cell.body = true;
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
                cellarry[i][j] = new Cell(xar[i],yar[j]);
            }
        }
    }

    public void setDirection(String direction){
        this.direction = direction;
    }
    public String getDirection(){
        return this.direction;
    }
    public void moveBody(String direction){
        while(snake.iterator.hasNext()){
            switch (direction) {
                case "up":
                    snake.iterator.next().setY(--snake.iterator.next().y);
                    System.out.println("up");
                    break;
                    case "down":
                        snake.iterator.next().setY(++snake.iterator.next().y);
                        System.out.println("down");
                        break;
                    case "left":
                        snake.iterator.next().setX(--snake.iterator.next().x);
                        System.out.println("left");
                        break;
                    case "right":
                        snake.iterator.next().setX(++snake.iterator.next().x);
                        System.out.println("right");
                        break;
            }
        }
    }

}
