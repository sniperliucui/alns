package vrptw.alns.operation;

/**
 * Created by LiuCui on 2020/12/7
 */
public interface  IALNSOperation {
    int getPi();

    void setPi(int var1);

    void addToPi(int var1);

    double getP();

    void setP(double var1);

    double getW();

    void setW(double var1);

    void drawn();


    int getDraws();

    void setDraws(int var1);


}
