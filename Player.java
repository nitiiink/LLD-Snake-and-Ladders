public class Player {
    private String id;
    private int currentPosition;

   public Player(String id, Integer currentPosition) {
       this.id = id;
       this.currentPosition = currentPosition;
   }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public String getId() {
        return id;
    }
}
