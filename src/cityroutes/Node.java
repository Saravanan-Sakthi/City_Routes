package cityroutes;

import java.util.HashMap;

public class Node {

    private char point;
    private HashMap<Node , Integer> links;

    public Node(char point){
        this.point = point;
    }

    public char getPoint() {
        return point;
    }

    public void setPoint(char point) {
        this.point = point;
    }

    public HashMap<Node, Integer> getLinks() {
        return links;
    }

    public void setLinks(HashMap<Node, Integer> links) {
        this.links = links;
    }

    public void addLink (Node point , int dist){
        links.put(point , dist);
    }

    public void removeLink (Node point){
        links.remove(point);
    }

    public int getNumberOfLinks(){
        return links.size();
    }

}
