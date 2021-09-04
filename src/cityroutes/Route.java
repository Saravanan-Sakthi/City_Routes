package cityroutes;

import java.util.LinkedList;

public class Route {
    private int distance;
    char from;
    char to;
    LinkedList <Character> route= new LinkedList<>();

    public Route(char from, char to) {
        this.from = from;
        this.to = to;
    }
}
