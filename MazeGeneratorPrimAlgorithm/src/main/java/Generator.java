import java.util.*;

public class Generator {

    private static final Random random = new Random();
    private List<Edge> edgeList = new ArrayList<>();
    private HashMap<Integer,Boolean> vertices = new HashMap<>();
    private List<Edge> actualVerticesToVisit = new ArrayList<>();

    private int width;

    private int height;

    private int cellSize;

    public Generator(int width, int height, int cellSize) {
        this.width = width;
        this.height = height;
        this.cellSize = cellSize;
    }

    public List<Edge> generate(){

        vertices.put(0,true);
        for(int i=1;i<width*height;i++){
            vertices.put(i,false);
        }
        while(actualVerticesToVisit.size()>0){
                Edge edge = actualVerticesToVisit.get(random.nextInt(actualVerticesToVisit.size()));
            if(!vertices.get(edge.getY())){
                vertices.put(edge.getY(),true);
                this.add(edge);
            }
        }


        return edgeList;
    }
    private int compareTwoIntegers(int x, int y){
        if (x>y){
            return x;
        }else{
            return y;
        }
    }
    private void add(Edge edge){
        int left = edge.getY()-1;
        int right = edge.getY()+1;
        int up = edge.getY()-width;
        int down = edge.getY()+width;
        if((!vertices.get(left))&&(left%right!=width-1)){
            actualVerticesToVisit.add(new Edge(min(left,edge.getY()),max(left,edge.getY())));
        }
        if((!vertices.get(right))&&(right%width!=0)){
            actualVerticesToVisit.add(new Edge(min(right,edge.getY()),max(right,edge.getY())));
        }
        if((!vertices.get(up))&&(up>0)){
            actualVerticesToVisit.add(new Edge(min(right,edge.getY()),max(right,edge.getY())));
        }
        if((!vertices.get(down))&&(down<width*height)){
            actualVerticesToVisit.add(new Edge(min(right,edge.getY()),max(right,edge.getY())));
        }
    }

    public int max(int x,int y){
        if (x>y){
            return x;
        }else{
            return y;
        }
    }

    public int min(int x, int y){
        if (x<y){
            return x;
        }else{
            return y;
        }
    }


}
