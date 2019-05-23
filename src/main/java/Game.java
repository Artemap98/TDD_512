public class Game {

    public static void main(String[] args) {
        System.out.println("512 game tdd");
    }

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
}
