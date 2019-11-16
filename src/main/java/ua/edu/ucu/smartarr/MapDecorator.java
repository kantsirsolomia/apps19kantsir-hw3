package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;
import java.util.ArrayList;
import java.util.function.Function;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {

    public MapDecorator(SmartArray smartArray, MyFunction myFunc){
        super(smartArray);
        ArrayList<Object> newArray = new ArrayList<>();
        Object[] myArray= toArray();
        int size= size();
        for(int i = 0; i<size; i++){
            newArray.add(myFunc.apply(myArray[i]));
        }
        super.smartArray = new BaseArray(newArray.toArray());

    }


    @Override
    public Object[] toArray() {
        return smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "Reflects each element into the other object, applying to each function - MyFunction.";
    }

    @Override
    public int size() {
        return smartArray.size();
    }
}
