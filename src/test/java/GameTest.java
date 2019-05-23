import org.junit.Assert;
import org.junit.Test;


public class GameTest {

    int[][] TEST_MATRIX = {
            {0,2,0,16},
            {0,2,0,64},
            {0,0,4,0},
            {32,0,0,0}
    };

    @Test
    public void MainClassCreationTest() {
        Game game = new Game();
        Assert.assertNotNull(game);
    }

    @Test
    public void CreateMatrixTest()
    {
        Game game = new Game();
        Assert.assertNotNull(game.CreateMatrix());
    }

    @Test
    public void InitMatrixText()
    {
        Game game = new Game();
        int[][] matrix = game.InitMatrix(game.CreateMatrix());
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[i].length; j++)
                Assert.assertEquals(0,matrix[i][j]);
        }

    }

    @Test
    public void RandomEmptyCellFillTest()
    {
        Game game = new Game();
        int[][] matrix = TEST_MATRIX;
        int[][] matrix2 = CopyMatrix(matrix);
        game.RandomEmptyCellFill(matrix2);
        int nonEqualCells = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] != matrix2[i][j])
                    nonEqualCells++;
            }
        }
        Assert.assertEquals(1,nonEqualCells);
    }

    public int[][] CopyMatrix(int[][] matrix1)
    {
        int[][] matrix2 = new int[matrix1.length][matrix1.length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                matrix2[i][j] = matrix1[i][j];
            }
        }
        return matrix2;
    }

    @Test
    public void MoveLeftTest()
    {
        Game myGame = new Game();
        int[][] matrix = TEST_MATRIX;
        matrix = myGame.MoveLeft(matrix);
        for (int i=0; i<matrix.length; i++)
        {
            boolean nullCounter = false;
            boolean properlyMoved = true;
            for (int j=0; j< matrix.length; j++)
            {
                //if number placed righter than empty cell, then error
                if(matrix[i][j]==0) nullCounter = true;
                else if(nullCounter==true) properlyMoved = false;
            }
            Assert.assertTrue(properlyMoved);
        }
    }

    @Test
    public void MergeLeftTest()
    {
        Game myGame = new Game();
        int[][] matrix = TEST_MATRIX;
        matrix = myGame.MergeLeft(matrix);
        for (int i=0; i<matrix.length; i++)
        {
            boolean properlyMerged = true;
            for (int j=1; j< matrix.length; j++)
            {
                if(matrix[i][j]==matrix[i][j-1]) properlyMerged = false;
            }
            Assert.assertTrue(properlyMerged);
        }
    }

};

