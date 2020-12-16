package vrptw.instancesIO;

import java.util.Arrays;

/**
 * Created by LiuCui on 2020/12/7
 */
public class Node {
    private double[] timeWindows;
    private double serviceTime;
    private double x;
    private double y;
    private int id;
    private double demand;

    public Node(Node n) {
        this.x = n.x;
        this.y = n.y;
        this.id = n.id;
        this.demand = n.demand;
        this.serviceTime = n.serviceTime;
        this.timeWindows = new double[]{n.timeWindows[0], n.timeWindows[1]};
    }

    public Node() {
    }

    public double getServiceTime() {
        return this.serviceTime;
    }

    public void setServiceTime(double serviceTime) {
        this.serviceTime = serviceTime;
    }

    public double[] getTimeWindows() {
        return this.timeWindows;
    }

    public void setTimeWindows(double start, double end) {
        this.timeWindows = new double[]{start, end};
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getDemand() {
        return this.demand = demand;
    }

    public void setDemand(double demand) {
        this.demand = demand;
    }

    public String toString() {
        return "Node{x=" + this.x + ", y=" + this.y + ", id" + this.id + ", demand=" + this.demand + "}";
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Node node = (Node) o;
            return this.id == node.id;
        } else {
            return false;
        }
    }

}












