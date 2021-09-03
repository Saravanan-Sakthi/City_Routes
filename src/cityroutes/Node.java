package cityroutes;

import java.util.ArrayList;

public class Node {
    private char point;
    private ArrayList<Node> links;
    public Node(char point){
        this.point = point;
    }

    public void addLink (Node point){
        links.add(point);
    }

    public void removeLink (Node point){
        links.remove(point);
    }
}
