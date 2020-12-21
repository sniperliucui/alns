package vrptw.algrithm;

/**
 * Created by LiuCui on 2020/12/7
 */
public class Cost {
    public double total;
    public double cost;
    public double time;
    public double load;
    public double loadViolation;
    public double timeViolation;

    public Cost(){
        this.total = 0.0D;
        this.cost = 0.0D;
        this.time=0.0D;
        this.load = 0.0D;
        this.loadViolation = 0.0D;
        this.timeViolation = 0.0D;
    }
    public Cost(Cost cost){
        this.total=cost.total;
        this.cost= cost.cost;
        this.time=cost.time;
        this.load= cost.load;
        this.loadViolation= cost.loadViolation;
        this.timeViolation= cost.timeViolation;
    }

    public String toString() {
        String result = "[ total =" +this.total+", cost ="+this.cost+", load=" + this.load+", time ="+this.time+", time" +
                "time windows violation =" + this.timeViolation+", load violation ="+this.loadViolation;
        return result+" ]";
    }

    public void calculateTotalCost(double alpha, double beta){
        this.total = this.cost + alpha*this.loadViolation+beta*this.timeViolation;
    }

    public void calculateTotalCost(){ this.total = this.cost + this.loadViolation+ this.timeViolation; }

    public void setLoadViol(double capacityviol){ this.loadViolation = capacityviol; }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setLoad(double load) {
        this.load = load;
    }

    public void setCost(double cost) {this.cost=cost;}

/*
    public void setLoadViolation(double loadViolation) {
        this.loadViolation = loadViolation;
    }
*/

    public void setTimeViolation(double timeViolation) {
        this.timeViolation = timeViolation;
    }

    public double getCost(){
        return this.cost;
    }

    public double getTotal() { return this.total; }

    public double getLoad() {return this.load;}

    public double getLoadViolation() {
        return this.loadViolation;
    }

    public double getTimeViolation() {
        return this.timeViolation;
    }


}
