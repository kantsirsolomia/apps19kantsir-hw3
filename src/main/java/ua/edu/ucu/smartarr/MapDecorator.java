package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;
import java.util.ArrayList;
import java.util.function.Function;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {
    private MyFunction myfunc;

    public MapDecorator(SmartArray smartArray, MyFunction myFunc){
        super(smartArray);
        this.myfunc = myFunc;
    }

    @Override
    public Object[] toArray() {
        Object[] array = smartArray.toArray().clone();
        int end = array.length;
        for (int i = 0; i < end; i++) {
            array[i] = myfunc.apply(array[i]);
        }
        return array.clone();
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
