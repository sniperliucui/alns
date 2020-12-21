package vrptw.algrithm;

import vrptw.instancesIO.Instance;

/**
 * Created by LiuCui on 2020/12/7
 */
public class CheckSolution {
    private double[][] distance;

    public CheckSolution(Instance instance){
        this.distance = instance.getDistanceMatrix();
    }

}
