package interface_adapters.property;

import data_access.AIRBNB;
import entities.Property;
import usecases.property.PropertyRepository;

import java.util.List;

public class PropertyRepositoryImpl implements PropertyRepository {
    private final AIRBNB airbnb;

    public PropertyRepositoryImpl(AIRBNB airbnb) {
        this.airbnb = airbnb;
    }

    @Override
    public List<Property> searchProperties(String city) throws Exception {
        return airbnb.searchProperties(city);
    }
}

