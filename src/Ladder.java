import java.util.HashMap;

public class Ladder{

    private int noOfLadders;

    private HashMap<Integer, Integer> topBottomMap;

    public Ladder(int noOfLadders) {
        this.noOfLadders = noOfLadders;
        this.topBottomMap = new HashMap<>();
    }

    public boolean validPosition(int position){

        if(topBottomMap.containsKey(position)){
            return true;
        }

        return false;
    }

    public int returnPosition(int position){
        return topBottomMap.get(position);
    }

    public void addLadder(int bottom, int top){
        topBottomMap.put(bottom,top);
    }

    public int getNoOfLadders() {
        return noOfLadders;
    }

    public HashMap<Integer, Integer> getTopBottomMap() {
        return topBottomMap;
    }

}
