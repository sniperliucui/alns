package vrptw.algrithm;

import vrptw.instancesIO.Route;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by LiuCui on 2020/12/7
 */
public class Solution {
    private double testTime;
    private List<Route> routes = new ArrayList<>();
    private double totalCost = 0.0D;
    private int vehicleNr = 0;

    public Solution(){}

    public List<Route> getRoutes() {
        return this.routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public void addRoute(Route route){
        this.routes.add(route);
    }

    public double getTotalCost() {
        return this.totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public int getVehicleNr() {
        return this.vehicleNr;
    }

    public void setVehicleNr(int vehicleNr) {
        this.vehicleNr = vehicleNr;
    }

    public Solution clone(){
        Solution clone = new Solution();
        clone.totalCost = this.totalCost;
        clone.vehicleNr = this.vehicleNr;
        Iterator var3 = this.routes.iterator();

        while (var3.hasNext()){
            Route route = (Route)var3.next();
            clone.routes.add(route.cloneRoute());
        }

        return clone;
    }

    public String toString(){
        String result = "Solution{totalCost="+(double)Math.round(this.totalCost*100.0D) /100.0D+", routes=[";
        Iterator var3 = this.routes.iterator();

        while (var3.hasNext()){
            Route vehicle=(Route)var3.next();
            if(vehicle.getRoute().size()>2){
                result=result+"\n\t"+vehicle;
            }
        }
        return result + "]}";
    }

}
