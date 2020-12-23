package vrptw.alns.config;

/**
 * Created by LiuCui on 2020/12/7
 */
public class ControlParameter {
    private final boolean solutionsLinechart;
    private final boolean operationsLinechart;
    private final boolean solutionImages;

    public ControlParameter(boolean showSolutionsLinechart, boolean showOperationsLinechart, boolean createSolutionImages) {
        this.solutionsLinechart = showSolutionsLinechart;
        this.operationsLinechart = showOperationsLinechart;
        this.solutionImages = createSolutionImages;
    }

    public boolean isSolutionsLinechart() {
        return this.solutionsLinechart;
    }

    public boolean isOperationsLinechart() {
        return this.operationsLinechart;
    }

    public boolean isSolutionImages() {
        return this.solutionImages;
    }
}
