package vrptw.alns.operation;

import java.util.Random;

/**
 * Created by LiuCui on 2020/12/7
 */
public abstract class ALNSAbstractOperation implements IALNSOperation {
    private final Random r = new Random();
    private int pi;
    private double p;
    private int draws;
    private double w;

    public ALNSAbstractOperation() {
    }

    public void drawn() {
        ++this.draws;
    }

    public void addToPi(int pi) {
        this.pi += pi;
    }

    public int getPi(){
        return this.pi;
    }
    public void setPi(int pi){
        this.pi=pi;
    }

    public double getP(){
         return this.p;
    }

    public void setP(double p){
        this.p=p;
    }

    public int getDraws(){
        return this.draws;
    }
    public void setDraws(int draws){
        this.draws = draws;
    }

    public double getW(){
        return this.w;
    }

    public void setW(double w) {
        this.w = w;
    }
}
