package usecases.flight;

public interface FlightInputBoundary {
    void handle(FlightInputData inputData) throws Exception;
    void switchToDashboardView();
}
