package vrptw.instancesIO;

import vrptw.algrithm.Cost;

import java.util.ArrayList;
import java.util.Iterator;
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

    public int getId() {
        return this.id;
    }

    public List<Node> getRoute() {
        return this.route;
    }

    public Node getLastNodeOfTheRoute() { return (Node)this.route.get(this.route.size()-1);}

    public void addNodeToRoute(Node node) { this.route.add(node);}

    public void addNodeToRouteWithIndex(Node node, int index){ this.route.add(index, node);}

    public Node removeNode(int index) { return (Node)this.route.remove(index); }

    public String toString() {
        String result = "Route{cost= " + this.cost + ", route = [";

        Node customer;
        /**
         *   Iterator<String> it = sites.iterator();  // 获取迭代器
         *   while(it.hasNext()) {                    // 用于检测集合中是否还有元素
         *       System.out.println(it.next());       // 返回迭代器的下一个元素，并且更新迭代器的状态
         *   }
         */
        for(Iterator var3 = this.route.iterator(); var3.hasNext();result=result+"\n\t\t" + customer){
            customer = (Node)var3.next();
        }
        return result+"]";

    }

    public Cost getCost() {
        return this.cost;
    }

    public void setCost(Cost cost) {
        this.cost = cost;
    }
}
