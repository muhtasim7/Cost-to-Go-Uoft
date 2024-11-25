package usecases.property;

public interface PropertyOutputBoundary {
    void present(PropertyOutputData data);

    void handleError(String error);
    void switchToDashboardView();
}
