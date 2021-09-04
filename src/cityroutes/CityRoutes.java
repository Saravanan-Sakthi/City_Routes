package cityroutes;

import java.util.HashMap;
import java.util.LinkedList;

public class CityRoutes {

    Node [] array = new Node[10];

    public CityRoutes() {
        Node node = new Node('A');
        array[0] = node;
    }

    private int getIndex (char point)   {
        return (int) point - (int) 'A';
    }

    public boolean addRoute(char first , char second , int dist) {
        int index1 = getIndex(first);
        int index2 = getIndex(second);
        if(array[index1] == null){
            return false;
        }
        Node node1 = array[index1];
        if(array[index2] == null) {
            Node node2 = new Node(second);
            node1.addLink(node2 , dist);
            array[index2] = node2;
        } else {
            node1.addLink(array[index2] , dist);
            array[index2].addLink(node1 , dist);
        }
        return true;
    }

    public boolean deleteRoute (char first , char second) {
        int index1 = getIndex(first);
        int index2 = getIndex(second);
        if(array[index1] == null || array[index2] == null){
            return false;
        }
        Node node1 = array[index1];
        Node node2 = array[index2];
        node1.removeLink(node2);
        node2.removeLink(node1);
        return true;
    }

    public Node getBusyCity() {
        Node big = array[0];
        for (Node node : array){
            if (node.getNumberOfLinks() > big.getNumberOfLinks()){
                big = node;
            }
        }
        return big;
    }

    public boolean findCity(char point) {
        int index = getIndex(point);
        if (array[index] == null) {
            return false;
        }
        return true;
    }

    public String listCities() {
        StringBuilder out= new StringBuilder();
        for(Node node : array){
            if (node != null){
                out.append(node.getPoint());
            }
        }
        return out.toString();
    }

    public Route getRoute(char first , char second){
        int index1 = getIndex(first);
        int index2 = getIndex(second);
        if(array[index1] == null || array[index2] == null){
            return null;
        }
        Route route = new Route(first , second);
        LinkedList<Character> path = route.route;
        Node point1 = array[index1];
        Node point2 = array[index2];
        HashMap<Node , Integer> links = point1.getLinks();
        if(links.containsKey(point2)){
            path.add(second);
        } else {
            System.out.println();
        }
        return route;
    }

}
