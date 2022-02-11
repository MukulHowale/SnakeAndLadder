import java.util.ArrayList;
import java.util.List;

public class Board{

    private int noOfCells;

    private int noOfPlayers;

    private List<Player> listOfPlayes;

    public Board(int noOfCells, int noOfPlayers) {
        this.noOfCells = noOfCells;
        this.noOfPlayers = noOfPlayers;
        this.listOfPlayes = new ArrayList<>();
    }

    public void beginGame(Dice dice, Snake snake, Ladder ladder){

        int index = 0;

        while(true){

            // making the index 0 if the last player has rolled the dice
            if(index >= noOfPlayers){
                index = 0;
            }

            // getting the players for the list of players
            Player player = listOfPlayes.get(index);

            // rolling the dice
            int diceRoll = dice.rollDice();

            // getting the players new position
            int newPosition = player.getPosition() +diceRoll;

            // checking if the player position after rolling of dice excedes the board cell count
            if(newPosition > noOfCells){
                index++;
                continue;
            }

            // if the new position is at the head of a snake, new position will be set at the tail
            if(snake.validPosition(newPosition)){
                changePosition(player,snake,diceRoll,newPosition);
            }

            // if the new position is at the bottom of a ladder, new position will be set at the top
            if(ladder.validPosition(newPosition)){
                changePosition(player,ladder,diceRoll,newPosition);
            }

            // setting the new position of a player
            else{
                System.out.println(player.getName() + " rolled a " + diceRoll + " and moved from " + player.getPosition()
                        + " to " + newPosition);
                player.setPosition(newPosition);
            }

            // if the player is at the last cell on the board, he wins the game
            if(player.getPosition() == noOfCells){
                System.out.println(player.getName() + " wins the game");
                listOfPlayes.remove(player);
                noOfPlayers--;
//                break;
            }

            if(listOfPlayes.size() == 1){
                System.out.println(listOfPlayes.get(index) + " losses the game");
                break;
            }

            index++;
        }

    }

    public void addPlayersToBoard(Player player){
        listOfPlayes.add(player);
    }


    private void changePosition(Player player, MarkerForSnakeAndLadder marker, int diceRoll, int newPosition){
        System.out.println(player.getName() + " rolled a " + diceRoll + ", found a snake and moved from " + player.getPosition()
                + " to " + marker.returnPosition(newPosition));
        player.setPosition(marker.returnPosition(newPosition));
    }
}
