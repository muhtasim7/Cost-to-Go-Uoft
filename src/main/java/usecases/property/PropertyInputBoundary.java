package usecases.property;

public interface PropertyInputBoundary {
    void handle(PropertyInputData inputData) throws Exception;

    default void switchToDashboardView() {

    }
}
