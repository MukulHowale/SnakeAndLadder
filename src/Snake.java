import java.util.HashMap;

public class Snake implements MarkerForSnakeAndLadder{

    private int noOfSnakes;

    private HashMap<Integer, Integer> headTailMap;

    public Snake(int noOfSnakes) {
        this.noOfSnakes = noOfSnakes;
        this.headTailMap = new HashMap<>();
    }

    public boolean validPosition(int position){
        if(headTailMap.containsKey(position)){
            return true;
        }
        return false;
    }

    public int returnPosition(int position){
        return headTailMap.get(position);
    }

    public void addSnakes(int head, int tail){
        headTailMap.put(head,tail);
    }

    public int getNoOfSnakes() {
        return noOfSnakes;
    }

    public HashMap<Integer, Integer> getHeadTail() {
        return headTailMap;
    }

}
