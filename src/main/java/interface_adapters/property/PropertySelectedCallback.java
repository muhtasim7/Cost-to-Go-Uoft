package interface_adapters.property;

import entities.Property;

/**
 * Callback interface for handling the selection of a property.
 * Implementations of this interface define actions to take when a property is selected.
 */
public interface PropertySelectedCallback {
    /**
     * Called when a property is selected.
     *
     * @param selectedProperty the Property that has been selected
     */
    void onPropertySelected(Property selectedProperty);
}
