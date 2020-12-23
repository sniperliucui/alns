package vrptw.alns.config;

/**
 * Created by LiuCui on 2020/12/7
 */
public interface IALNSConfig {
    int getOmega();

    int getTau();

    double getR_p();

    int getSigma_1();

    int getSigma_2();

    int getSigma_3();

    double getC();

    double getDelta();

    double getBig_omega();
}
