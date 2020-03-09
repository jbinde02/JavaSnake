import java.util.Random;

class GameField {
    int[] xar;
    int[] yar;
    Cell[][] cellArray;
    private Snake snake;
    private String direction;
    private Random random;

    GameField(){
        random = new Random();
        xar = new int[25];
        yar = new int[25];
        cellArray = new Cell[xar.length][yar.length];
        createGrid();
        snake = new Snake();
        snake.addBody(cellArray[2][5]);
        snake.addBody(cellArray[2][4]);
        snake.addBody(cellArray[2][3]);
        snake.addBody(cellArray[2][2]);
        snake.addBody(cellArray[2][1]);
        snake.addBody(cellArray[2][0]);
        addFood(cellArray[10][10]);
        direction = "none";
        System.out.println("Field running");
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
                cellArray[i][j] = new Cell(xar[i],yar[j]);
            }
        }
    }

    void setDirection(String direction){
        this.direction = direction;
    }

    String getDirection(){
        return this.direction;
    }

    boolean moveBody(String direction){
        Cell[] snakeArray = snake.toArray();
        Cell newCell = new Cell();
        int index = 0;
        boolean foodAte = false;
        for(Cell cell : snakeArray){
            switch (direction) {
                case "up":
                    if(cell.getCol(cell.y) - 1 < 0){
                        return true;
                    }
                    if(index == 0) {
                        newCell = cellArray[cell.getRow(cell.x)][cell.getCol(cell.y) - 1];
                        if(newCell.food){
                            eatFood(newCell);
                            foodAte = true;
                            break;
                        }
                    }
                    snake.replaceBody(newCell, index);
                    break;

                case "down":
                    if(cell.getCol(cell.y) + 1 == yar.length){
                        return true;
                    }
                    if(index == 0) {
                        newCell = cellArray[cell.getRow(cell.x)][cell.getCol(cell.y) + 1];
                        if(newCell.food){
                            eatFood(newCell);
                            foodAte = true;
                            break;
                        }
                    }
                    snake.replaceBody(newCell, index);
                    break;

                case "left":
                    if(cell.getRow(cell.x) - 1 < 0){
                        return true;
                    }
                    if(index == 0) {
                        newCell = cellArray[cell.getRow(cell.x) - 1][cell.getCol(cell.y)];
                        if(newCell.food){
                            eatFood(newCell);
                            foodAte = true;
                            break;
                        }
                    }
                    snake.replaceBody(newCell, index);
                    break;

                case "right":
                    if(cell.getRow(cell.x) + 1 == xar.length){
                        return true;
                    }
                    if(index == 0) {
                        newCell = cellArray[cell.getRow(cell.x) + 1][cell.getCol(cell.y)];
                        if(newCell.food){
                            eatFood(newCell);
                            foodAte = true;
                            break;
                        }
                    }
                    snake.replaceBody(newCell, index);
                    break;
            }
            if(foodAte){
                break;
            }
            index++;
            newCell = cell;
        }
        return false;
    }

    boolean isHeadCollision() {
        Cell[] snakeArray = snake.toArray();
        Cell head = snake.bodyList.get(0);
        int index = 0;
        for (Cell cell : snakeArray) {
            if(cell == head && index != 0){
                return true;
            }
            index++;
        }
        return false;
    }

    boolean foodExist(){
        for(int i = 0; i<xar.length; i++){
            for(int j = 0; j<yar.length; j++){
                if(cellArray[i][j].food){
                    return true;
                }
            }
        }
        return false;
    }

    private void addFood(Cell cell){
        cell.setFood(true);
    }

    void addRandomFood(){
        int randomInt1 = random.nextInt(xar.length - 1);
        int randomInt2 = random.nextInt(yar.length - 1);
        cellArray[randomInt1][randomInt2].setFood(true);
    }

    private void eatFood(Cell cell){
        cell.setFood(false);
        snake.addBody(cell);
        System.out.println("Yummy!");
    }
}
