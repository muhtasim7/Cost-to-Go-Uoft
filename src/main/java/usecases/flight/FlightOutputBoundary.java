package usecases.flight;

public interface FlightOutputBoundary {
    void present(FlightOutputData data);

    void handleError(String error);
    void switchToDashboardView();
}
