import java.util.Random;
/**
 * This class represents the field. The field is made up of a 2D array of cells. This class will create the field and
 * deal with the change in the status of a cell.
 *
 * @author Jacob Binder
 */
class GameField {
    int[] xar;
    int[] yar;
    Cell[][] cellArray;
    private Snake snake;
    private String direction;
    private Random random;

    /**
     * The constructor creates the field and starts a snake. The size of the field can be changed with the columns and
     * rows variables.
     */
    GameField(){
        random = new Random();
        int columns = 25;
        int rows = 25;
        xar = new int[columns];
        yar = new int[rows];
        cellArray = new Cell[xar.length][yar.length];
        createGrid();
        snake = new Snake();
        snake.addBody(cellArray[2][0]);
        direction = "none";
        System.out.println("Field running");
    }

    private void createGrid(){
        populateXY();
        populateCell();
    }

    /**
     * Creates the coordinates for each cell.
     */
    private void populateXY(){
        int x = 0;
        int y = 0;
        Cell cell = new Cell();
        for(int i = 0; i<xar.length; i++) {
            xar[i] = x;
            x+= cell.WIDTH;
        }
        for(int i = 0; i<yar.length; i++) {
            yar[i] = y;
            y+= cell.HEIGHT;
        }

    }

    /**
     * Creates a new cell using the coordinates from the created from the PopulateXY method. Then puts the cell in a
     * 2D array which represents the grid.
     */
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

    /**
     * This controls where each cell will shift according to the argument. If the next cell is either food or a wall,
     * it will do something special. Has to turn the snakes arrayList into a array because of a issue with threads and
     * the awt graphics.
     *
     * @param direction Which direction the snake is going. Will determine where the cells are shifted.
     * @return Returns true if the next cell is a wall. Returns false if not.
     */
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

    /**
     * Will check if the head has run into another part of the body.
     * @return Returns true if the head has run into the body. Returns false if not.
     */
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

    /**
     * Checks if there is food on the field.
     */
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

    /**
     * Adds a food to the field in a random location.
     */
    void addRandomFood(){
        int randomInt1 = random.nextInt(xar.length - 1);
        int randomInt2 = random.nextInt(yar.length - 1);
        cellArray[randomInt1][randomInt2].setFood(true);
    }

    /**
     * Eats the food and destroys the food.
     */
    private void eatFood(Cell cell){
        cell.setFood(false);
        snake.addBody(cell);
        System.out.println("Yummy!");
    }
}
