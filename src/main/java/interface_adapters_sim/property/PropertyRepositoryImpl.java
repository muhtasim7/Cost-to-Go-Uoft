package interface_adapters_sim.property;

import data_access_sim.AIRBNB;
import entities.Property;
import usecases_sim.property.PropertyRepository;

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

