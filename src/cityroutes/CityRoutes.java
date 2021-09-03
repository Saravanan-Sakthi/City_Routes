package cityroutes;

public class CityRoutes {

    Node [] array = new Node[10];

    public CityRoutes(){
        Node node = new Node('A');
        array[0] = node;
    }

    private int getIndex (char point){
        int index = (int) point - (int) 'A';
        return index;
    }

    public boolean addRoute (char first , char second){
        int index1 = getIndex(first);
        int index2 = getIndex(second);
        if(array[index1] == null){
            return false;
        }
        Node node1 = array[index1];
        if(array[index2] == null) {
            Node node2 = new Node(second);
            node1.addLink(node2);
            array[index2] = node2;
        } else {
            node1.addLink(array[index2]);
            array[index2].addLink(node1);
        }
        return true;
    }

    public boolean deleteRoute (char first , char second){
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
}
