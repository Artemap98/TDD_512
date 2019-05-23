import org.junit.Assert;
import org.junit.Test;


public class GameTest {

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



};

