package ua.edu.ucu.smartarr;

// Base array for decorators
//
public class BaseArray implements SmartArray {
    public Object[] list;


    public BaseArray(Object[] myArray){
        list = myArray;
    }

    @Override
    public Object[] toArray() {
        return this.list;
    }

    @Override
    public String operationDescription() {
        return "Base array for decorators.";
    }

    @Override
    public int size() {
        return list.length;
    }

    public void setValue(int i) {
        list[i] = 0;
    }
    }

