package vrptw.algrithm;

import vrptw.alns.config.ControlParameter;
import vrptw.alns.config.IALNSConfig;
import vrptw.instancesIO.Instance;

/**
 * Created by LiuCui on 2020/12/7
 */
public class Solver {
    public Solver(){
    }

    public Solution getInitialSolution(Instance instance){
        GreedyVRP greedyVRP = new GreedyVRP(instance);
        return greedyVRP.getInitialSolution();
    }

    public Solution improveSolution(Solution s, IALNSConfig ac, ControlParameter cp,Instance is) throws Exception{
        MyALNSProcess ALNS = new MyALNSProcess(s,is,ac,cp);
        return ALNS.improveSolution;
    }
}
