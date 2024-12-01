package usecases.flight;

public interface FlightOutputBoundary {
    void present(FlightOutputData data);
    void switchToDashboardView();
}
