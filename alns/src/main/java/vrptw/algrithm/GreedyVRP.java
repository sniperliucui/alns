package vrptw.algrithm;

import vrptw.instancesIO.Instance;
import vrptw.instancesIO.Node;
import vrptw.instancesIO.Route;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by LiuCui on 2020/12/7
 */
public class GreedyVRP {
    private List<Node> customers;
    private List<Route> vehicles;
    private double[][] distanceMatrix;
    private int vehicleCapacity;
    private int initialCustomerNr;

    public GreedyVRP(Instance instance) {
        this.customers = instance.getCustomers();
        this.initialCustomerNr = instance.getCustomerNr();
        this.distanceMatrix = instance.getDistanceMatrix();
        this.vehicleCapacity = instance.getVehicleCapacity();
        int vehicleNr = instance.getVehicleNr();
        this.vehicles = new ArrayList<>();

        for (int i = 0; i < vehicleNr; ++i) {
            Route route = new Route(i);
            this.vehicles.add(route);
        }
    }

    public int getCustomerNr() {
        return this.initialCustomerNr;
    }

    public double[][] getDistanceMatrix() {
        return this.distanceMatrix;
    }

    public Solution getInitialSolution() {
        Solution solution = new Solution();
        Node depot = (Node) this.customers.remove(0);
        Route currentVehicle = (Route) this.vehicles.remove(0);
        currentVehicle.addNodeToRoute(depot);

        Cost var10000;
        while (this.customers.size() != 0) {
            Node lastInTheCurrentRoute = currentVehicle.getLastNodeOfTheRoute();
            double smallestDistance = 1.7976931348623157E308D;
            Node closestNode = null;
            Iterator var9 = this.customers.iterator();

            while (var9.hasNext()) {
                Node n = (Node) var9.next();
                double distance = this.distanceMatrix[lastInTheCurrentRoute.getId()][n.getId()];
                if (distance < smallestDistance &&
                        currentVehicle.getCost().load + n.getDemand() <= (double) this.vehicleCapacity &&
                        currentVehicle.getCost().time + this.distanceMatrix[currentVehicle.getId()][n.getId()] < n.getTimeWindows()[1] &&
                        currentVehicle.getCost().time + this.distanceMatrix[currentVehicle.getId()][n.getId()] < n.getTimeWindows()[1] &&
                        currentVehicle.getCost().time + this.distanceMatrix[currentVehicle.getId()][n.getId()] + n.getServiceTime() +
                                this.distanceMatrix[n.getId()][depot.getId()] < depot.getTimeWindows()[1]) {
                    smallestDistance = distance;
                    closestNode = n;
                }
            }

            if (closestNode != null) {
                var10000 = currentVehicle.getCost();
                var10000.cost += smallestDistance;
                var10000 = currentVehicle.getCost();
                var10000.time += smallestDistance;
                if (currentVehicle.getCost().time < closestNode.getTimeWindows()[0]) {
                    currentVehicle.getCost().time = closestNode.getTimeWindows()[0];
                }

                var10000 = currentVehicle.getCost();
                var10000.time += closestNode.getServiceTime();
                var10000 = currentVehicle.getCost();
                var10000.load += closestNode.getDemand();
                currentVehicle.addNodeToRoute(closestNode);
                this.customers.remove(closestNode);
            }else{
                var10000=currentVehicle.getCost();
                var10000.cost += this.distanceMatrix[lastInTheCurrentRoute.getId()][depot.getId()];
                var10000 = currentVehicle.getCost();
                var10000.time += this.distanceMatrix[lastInTheCurrentRoute.getId()][depot.getId()];
                currentVehicle.addNodeToRoute(depot);
                currentVehicle.getCost().calculateTotalCost();
                solution.addRoute(currentVehicle);
                solution.setTotalCost(solution.getTotalCost()+currentVehicle.getCost().cost);
                if(this.vehicles.size()==0){
                    break;
                }

                currentVehicle=(Route)this.vehicles.remove(0);
                currentVehicle.addNodeToRoute(depot);
            }
        }

        var10000 = currentVehicle.getCost();
        var10000.cost += this.distanceMatrix[currentVehicle.getLastNodeOfTheRoute().getId()][depot.getId()];
        var10000 = currentVehicle.getCost();
        var10000.time += this.distanceMatrix[currentVehicle.getLastNodeOfTheRoute().getId()][depot.getId()];
        currentVehicle.addNodeToRoute(depot);
        currentVehicle.getCost().calculateTotalCost();
        solution.addRoute(currentVehicle);
        solution.setTotalCost(solution.getTotalCost()+currentVehicle.getCost().cost);
        solution.setTotalCost((double)Math.round(solution.getTotalCost()*1000.0D)/1000.0D);

        return solution;
    }
}

