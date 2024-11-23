package interface_adapters.property;

import interface_adapters.ViewModel;

/**
 * The View Model for the Property View.
 */
public class PropertyViewModel extends ViewModel<PropertyState> {

    public PropertyViewModel() {
        super("property view");
        setState(new PropertyState());
    }
}
