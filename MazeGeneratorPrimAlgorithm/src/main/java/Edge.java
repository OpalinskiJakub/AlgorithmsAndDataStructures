public class Edge {

    private int x;

    private int y;

    public Edge(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int max(){
        if (x>y){
            return x;
        }else{
            return y;
        }
    }

    public int min(){
        if (x<y){
            return x;
        }else{
            return y;
        }
    }
}
