import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("512 game tdd");
        Game game = new Game();
        int[][] gameMatrix = game.InitMatrix(game.CreateMatrix());
        int inputbutton=-1;
        gameMatrix = game.RandomEmptyCellFill(gameMatrix);
        do {
            for (int i = 0; i < gameMatrix.length; i++) {
                for (int j = 0; j < gameMatrix[i].length; j++) {
                    System.out.printf("%4d", gameMatrix[i][j]);
                }
                System.out.println();
            }
            System.out.println("q-quit, w-up, a-left, s-down, d-right");
            do{
                inputbutton = System.in.read();
            }while (inputbutton==10);
            boolean keyPressed = false;
            switch (inputbutton)
            {
                case 'w': gameMatrix = game.MoveUp(gameMatrix); System.out.println("You press Up");keyPressed = true;break;
                case 'a': gameMatrix = game.MoveLeft(gameMatrix); System.out.println("You press Left");keyPressed = true;break;
                case 's': gameMatrix = game.MoveDown(gameMatrix); System.out.println("You press Down");keyPressed = true;break;
                case 'd': gameMatrix = game.MoveRight(gameMatrix); System.out.println("You press Right");keyPressed = true;break;
                default:break;
            }
            if(keyPressed) gameMatrix = game.RandomEmptyCellFill(gameMatrix);
        }while (inputbutton !='q');
    }


}
