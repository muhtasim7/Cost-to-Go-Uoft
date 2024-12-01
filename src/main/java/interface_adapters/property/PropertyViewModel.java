package interface_adapters.property;

import interface_adapters.ViewModel;

/**
 * The ViewModel for the Property View in the application.
 * This class holds the state and data required for the Property View.
 * It extends the ViewModel to support reactive updates for changes in the state.
 */
public class PropertyViewModel extends ViewModel<PropertyState> {

    /**
     * Constructs a new PropertyViewModel instance.
     * Initializes the state with a new PropertyState object and sets the name to "property view".
     */
    public PropertyViewModel() {
        super("property view");
        setState(new PropertyState());
    }
}
