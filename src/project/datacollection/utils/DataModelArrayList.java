package project.datacollection.utils;

import java.util.ArrayList;

import project.datacollection.model.DataModel;

/**
 * ArrayList for stornig DataModel classes
 * @param <T>
 */
public class DataModelArrayList<T extends DataModel> extends ArrayList<T> {

    private static final long serialVersionUID = 1L;

    @Override
    public boolean add(T e) {
        if (e == null || e.isEmpty()) {
            return false;
        }
        return super.add(e);
    }
}
