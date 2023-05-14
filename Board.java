import java.util.concurrent.ThreadLocalRandom;

public class Board {
    Cell[][] cells;

    Board(int boardSize, int numberOfSnakes, int numberOfLadders) {
        initializeCells(boardSize);
        addSnakesLadders(cells, numberOfSnakes, numberOfLadders);
    }

    private void initializeCells(int boardSize) {
        cells = new Cell[boardSize][boardSize];
        for(int i=0;i<boardSize;i++) {
            for(int j=0;j<boardSize;j++) {
                Cell cellsObj = new Cell();
                cells[i][j] = cellsObj;
            }
        }
    }

    private void addSnakesLadders(Cell[][] cells, int numberOfSnakes, int numberOfLadders) {
        while(numberOfSnakes > 0) {
            int snakeHead = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
            int snakeTail = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
            //since for snakeTails should always be less
            if(snakeTail >= snakeHead)
                continue;

            Jump snakeObj = new Jump(snakeHead, snakeTail);
            Cell cell = getCell(snakeHead);
            // Assign the Jump object to the jump variable in the Cell object
            cell.jump = snakeObj;

            numberOfSnakes--;
        }

        while(numberOfLadders > 0) {
            int ladderHead = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
            int ladderTail = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);

            if(ladderHead >= ladderTail)
                continue;

            Jump ladderObj = new Jump(ladderHead, ladderTail);
            Cell cell = getCell(ladderHead);

            // Assign the Jump object to the jump variable in the Cell object
            cell.jump = ladderObj;

            numberOfLadders --;
        }
    }

    Cell getCell(int playerPosition) {
        int boardRow = playerPosition / cells.length;
        int boardColumn = playerPosition % cells.length;
        return cells[boardRow][boardColumn];
    }

}
