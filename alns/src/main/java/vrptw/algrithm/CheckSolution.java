package vrptw.algrithm;

import vrptw.instancesIO.Instance;
import vrptw.instancesIO.Node;
import vrptw.instancesIO.Route;

/**
 * Created by LiuCui on 2020/12/7
 */
public class CheckSolution {
    private double[][] distance;

    public CheckSolution(Instance instance){
        this.distance = instance.getDistanceMatrix();
    }

    public String Check(Solution solution){
        String result = "";
        double totalCost = 0.0D;
        int id=0;

        for(int i=0;i<solution.getRoutes().size();++i){
            Route vehicle = (Route)solution.getRoutes().get(i);
            if(vehicle.getRoute().size() >=3){
                ++id;
                double costInVehicle=0.0D;
                double loadInVehicle=0.0D;
                double time =0.0D;
                boolean checkCost=true;
                boolean checkLoad=true;
                boolean checkTime=true;
                boolean checkTimeWindows = true;

                for(int j=1;j<vehicle.getRoute().size();++j){
                    time += this.distance[((Node)vehicle.getRoute().get(j-1)).getId()][((Node)vehicle.getRoute().get(j)).getId()];
                    costInVehicle += this.distance[((Node)vehicle.getRoute().get(j-1)).getId()][((Node)vehicle.getRoute().get(j)).getId()];
                    loadInVehicle += ((Node)vehicle.getRoute().get(j)).getDemand();
                    if(time<((Node)vehicle.getRoute().get(j)).getTimeWindows()[0]){
                        time = ((Node)vehicle.getRoute().get(j)).getTimeWindows()[0];
                    }else if(time>((Node)vehicle.getRoute().get(j)).getTimeWindows()[1]){
                        checkTimeWindows=false;
                    }
                    time += ((Node)vehicle.getRoute().get(j)).getServiceTime();
                }

                totalCost += costInVehicle;
                if(Math.abs(vehicle.getCost().cost-costInVehicle)>0.001D){
                    checkCost=false;
                }
                if(Math.abs(vehicle.getCost().load-loadInVehicle)>0.001D){
                    checkLoad=false;
                }
                if(Math.abs(vehicle.getCost().time-time)>0.001D){
                    checkTime=false;
                }

                result = result + "\n check route "+id+": "+"\n check cost = "+ costInVehicle+" "+checkCost+"\n check demand = "+loadInVehicle+" "+
                        checkLoad+"\n check time = "+time+" "+checkTime+"\n check time windows = "+checkTimeWindows+"\n";
            }
        }
        boolean checkTotalCost = true;
        if(Math.abs(totalCost=solution.getTotalCost())>0.001D){
            checkTotalCost=false;
        }

        result = result + "\ncheck total cost = "+(double)Math.round(totalCost*100.0D)/100.0D + " " + checkTotalCost;
        return result;
    }

}
