public class Dice {

    private int noOfDice;

    public Dice(int noOfDice) {
        this.noOfDice = noOfDice;
    }

    public int rollDice(){
        return noOfDice * (int)Math.ceil((Math.random() * 6));
    }
}
