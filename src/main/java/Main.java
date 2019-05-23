public class Main {

    public static void main(String[] args) {
        System.out.println("512 game tdd");
        Game game = new Game();
        int[][] gameMatrix = game.InitMatrix(game.CreateMatrix());
        for (int i = 0; i < gameMatrix.length; i++) {
            for (int j = 0; j < gameMatrix[i].length; j++) {
                gameMatrix[i][j] = 0;
                System.out.printf("%4d", gameMatrix[i][j]);
            }
            System.out.println();
        }
    }


}
