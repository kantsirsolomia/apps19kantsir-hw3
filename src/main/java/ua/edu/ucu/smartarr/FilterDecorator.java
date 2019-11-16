package ua.edu.ucu.smartarr;
import ua.edu.ucu.functions.MyPredicate;

import java.util.ArrayList;
import java.util.Arrays;


// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator{

    public FilterDecorator(SmartArray smartArray, MyPredicate predicate){
        super(smartArray);
        Object[] myArray= toArray();
        ArrayList<Object> newArray = new ArrayList<>();
        int size= size();
        for(int i = 0; i<size; i++){
            if (predicate.test(myArray[i])){
                newArray.add(myArray[i]);
            }

        }
        this.smartArray = new BaseArray(newArray.toArray());

    }

    @Override
    public Object[] toArray() {
        return smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "Deletes elements that don't fit the contitions of predicate. ";
    }

    @Override
    public int size() {
        return smartArray.size();
    }
}
