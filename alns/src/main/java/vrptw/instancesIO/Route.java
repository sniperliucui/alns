package vrptw.instancesIO;

import vrptw.algrithm.Cost;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiuCui on 2020/12/7
 */
public class Route {
    private int id;
    private List<Node> route = new ArrayList<>();
    private Cost cost;

    public Route(int id){
        this.id=id;
        this.cost=new Cost();
    }

    public Route cloneRoute(){
        Route clone = new Route(this.id);
        clone.cost = new Cost(this.cost);
        clone.route = new ArrayList<>(this.route);
        return clone;
    }

    public Cost getCost() {
        return this.cost;
    }

    public void setCost(Cost cost) {
        this.cost = cost;
    }
}
