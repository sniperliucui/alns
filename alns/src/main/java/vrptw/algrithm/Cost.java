package vrptw.algrithm;

/**
 * Created by LiuCui on 2020/12/7
 */
public class Cost {
    public double tatal;
    public double cost;
    public double time;
    public double load;
    public double loadViolation;
    public double timeViolation;

    public Cost(){
        this.tatal = 0.0D;
        this.cost = 0.0D;
        this.time=0.0D;
        this.load = 0.0D;
        this.loadViolation = 0.0D;
        this.timeViolation = 0.0D;
    }
    public Cost(Cost cost){
        this.tatal=cost.tatal;
        this.cost= cost.cost;
        this.time=cost.time;
        this.load= cost.load;
        this.loadViolation= cost.loadViolation;
        this.timeViolation= cost.timeViolation;
    }

    public String toString() {
        String result = "[ total =" +this.tatal+", cost ="+this.cost+", load=" + this.load+", time ="+this.time+", time" +
                "time windows violation =" + this.timeViolation+", load violation ="+this.loadViolation;
        return result+" ]";
    }


}
