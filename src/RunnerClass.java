import java.util.Scanner;

public class RunnerClass {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter number of cells on the board");
        int noOfCells = sc.nextInt();

        System.out.println("Please enter number of snakes on the board");
        int noOfSnakes = sc.nextInt();

        Snake snake = new Snake(noOfSnakes);

        System.out.println("Please enter head and tail of the snakes");
        for(int i=0; i<noOfSnakes; i++){
            int head = sc.nextInt();

            int tail =sc.nextInt();

            snake.addSnakes(head,tail);
        }

        System.out.println("Please enter no of ladders on the board");
        int noOfLadders = sc.nextInt();

        Ladder ladder = new Ladder(noOfLadders);

        System.out.println("Please enter bottom and top of the ladder");
        for(int i=0; i<noOfLadders; i++) {
            int bottom = sc.nextInt();

            int top = sc.nextInt();

            ladder.addLadder(bottom, top);
        }

        System.out.println("Please number of players");
        int noOfPlayers = sc.nextInt();

        Board board = new Board(noOfCells,noOfPlayers);

        String fornoreason = sc.nextLine();

        System.out.println("Please enter names of players");
        for (int i=0; i<noOfPlayers; i++){
            String nameOfPlayer = sc.nextLine();
            Player player = new Player(nameOfPlayer);
            board.addPlayersToBoard(player);
        }

        System.out.println("Please enter number of dices but less that 3");

        int noOfDices = sc.nextInt();

        Dice dice = new Dice(noOfDices);

        board.beginGame(dice,snake,ladder);
    }
    /*

snakes
62 5
33 6
49 9
88 16
41 20
56 53
98 64
93 73
95 75

ladders
2 37
27 46
10 32
51 68
61 79
65 84
71 91
81 100
 */
}
