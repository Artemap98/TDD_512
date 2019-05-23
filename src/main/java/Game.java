import java.util.Random;

public class Game {

    public int[][] CreateMatrix()
    {
        int[][] matrix= new int[4][4];
        return matrix;
    }
    public int[][] InitMatrix(int[][] matrix)
    {
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                matrix[i][j] = 0;

        return matrix;
    }
    public int[][] RandomEmptyCellFill(int[][] matrix)
    {
        int emptyCellsCount = 0;
        for (int[] matrix2 : matrix)
            for (int i : matrix2) if (i == 0) emptyCellsCount++;
        Random r = new Random();
        if(emptyCellsCount != 0) {
            int fillPositionNumber = r.nextInt(emptyCellsCount)+1;
            emptyCellsCount = 0;
            for (int i = 0; i < matrix.length; i++)
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == 0) emptyCellsCount++;
                    if((emptyCellsCount) == fillPositionNumber) {
                        matrix[i][j] = 2;
                        fillPositionNumber=-1;
                    }
                }
        }

        return matrix;
    }

    public int[][] MoveLeft(int[][] matrix)
    {
        for (int i=0; i<matrix.length; i++)
        {
            boolean nullCounter = false;
            for (int j=0; j< matrix.length; j++)
            {
                //if number placed righter than empty cell, then move it to left
                if(matrix[i][j]==0) nullCounter = true;
                else if(nullCounter==true && matrix[i][j]!=0) {
                    matrix[i][j-1] = matrix[i][j];
                    matrix[i][j] = 0;
                    j=-1;
                    nullCounter = false;
                }
            }
        }
        return matrix;
    }
}
