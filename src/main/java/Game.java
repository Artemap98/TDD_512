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
        boolean moveExecuted = false;
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
                    moveExecuted = true;
                }
            }
        }
        if(moveExecuted) matrix = MergeLeft(matrix);
        return matrix;
    }

    public int[][] MergeLeft(int[][] matrix)
    {
        boolean mergeExecuted = false;
        for (int i=0; i<matrix.length; i++)
        {
            for (int j=1; j< matrix.length; j++)
            {
                if(matrix[i][j]==matrix[i][j-1] && matrix[i][j]!=0){
                    matrix[i][j-1] += matrix[i][j];
                    matrix[i][j] = 0;
                    j=0;
                    mergeExecuted = true;
                }
            }
        }
        if(mergeExecuted) matrix = MoveLeft(matrix);
        return matrix;
    }

    public int[][] MoveRight(int[][] matrix)
    {
        boolean moveExecuted = false;
        int mlen = matrix.length-1;
        for (int i=0; i<matrix.length; i++)
        {
            boolean nullCounter = false;
            for (int j=0; j< matrix.length; j++)
            {
                if(matrix[i][mlen-j]==0) nullCounter = true;
                else if(nullCounter==true && matrix[i][mlen-j]!=0) {
                    matrix[i][mlen-(j-1)] = matrix[i][mlen-j];
                    matrix[i][mlen-j] = 0;
                    j=-1;
                    nullCounter = false;
                    moveExecuted = true;
                }
            }
        }
        if(moveExecuted) matrix = MergeRight(matrix);
        return matrix;
    }

    public int[][] MergeRight(int[][] matrix)
    {
        boolean mergeExecuted = false;
        int mlen = matrix.length-1;
        for (int i=0; i<matrix.length; i++)
        {
            for (int j=1; j< matrix.length; j++)
            {
                if(matrix[i][mlen-j]==matrix[i][mlen-(j-1)] && matrix[i][mlen-j]!=0){
                    matrix[i][mlen-(j-1)] += matrix[i][mlen-j];
                    matrix[i][mlen-j] = 0;
                    j=0;
                    mergeExecuted = true;
                }
            }
        }
        if(mergeExecuted) matrix = MoveRight(matrix);
        return matrix;
    }
    //////////////////////////////////////////////////////////////////////////////////////

    public int[][] MoveUp(int[][] matrix)
    {
        boolean moveExecuted = false;
        for (int i=0; i<matrix.length; i++)
        {
            boolean nullCounter = false;
            for (int j=0; j< matrix.length; j++)
            {
                //if number placed righter than empty cell, then move it to left
                if(matrix[j][i]==0) nullCounter = true;
                else if(nullCounter==true && matrix[j][i]!=0) {
                    matrix[j-1][i] = matrix[j][i];
                    matrix[j][i] = 0;
                    j=-1;
                    nullCounter = false;
                    moveExecuted = true;
                }
            }
        }
        if(moveExecuted) matrix = MergeUp(matrix);
        return matrix;
    }

    public int[][] MergeUp(int[][] matrix)
    {
        boolean mergeExecuted = false;
        for (int i=0; i<matrix.length; i++)
        {
            for (int j=1; j< matrix.length; j++)
            {
                if(matrix[j][i]==matrix[j-1][i] && matrix[j][i]!=0){
                    matrix[j-1][i] += matrix[j][i];
                    matrix[j][i] = 0;
                    j=0;
                    mergeExecuted = true;
                }
            }
        }
        if(mergeExecuted) matrix = MoveUp(matrix);
        return matrix;
    }


    public int[][] MoveDown(int[][] matrix)
    {
        boolean moveExecuted = false;
        int mlen = matrix.length-1;
        for (int i=0; i<matrix.length; i++)
        {
            boolean nullCounter = false;
            for (int j=0; j< matrix.length; j++)
            {
                if(matrix[mlen-j][i]==0) nullCounter = true;
                else if(nullCounter==true && matrix[mlen-j][i]!=0) {
                    matrix[mlen-(j-1)][i] = matrix[mlen-j][i];
                    matrix[mlen-j][i] = 0;
                    j=-1;
                    nullCounter = false;
                    moveExecuted = true;
                }
            }
        }
        if(moveExecuted) matrix = MergeDown(matrix);
        return matrix;
    }

    public int[][] MergeDown(int[][] matrix)
    {
        boolean mergeExecuted = false;
        int mlen = matrix.length-1;
        for (int i=0; i<matrix.length; i++)
        {
            for (int j=1; j< matrix.length; j++)
            {
                if(matrix[mlen-j][i]==matrix[mlen-(j-1)][i] && matrix[mlen-j][i]!=0){
                    matrix[mlen-(j-1)][i] += matrix[mlen-j][i];
                    matrix[mlen-j][i] = 0;
                    j=0;
                    mergeExecuted = true;
                }
            }
        }
        if(mergeExecuted) matrix = MoveDown(matrix);
        return matrix;
    }



}
