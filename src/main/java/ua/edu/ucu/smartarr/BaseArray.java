package ua.edu.ucu.smartarr;

// Base array for decorators
public class BaseArray implements SmartArray {
    public Object[] List;


    public BaseArray(Object[] myArray){
        List = myArray;
    }

    @Override
    public Object[] toArray() {
        return List.clone();
    }

    @Override
    public String operationDescription() {
        return "Base array for decorators.";
    }

    @Override
    public int size() {
        return List.length;
    }
}
