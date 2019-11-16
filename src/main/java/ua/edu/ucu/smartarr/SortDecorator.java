package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Sorts elements using MyComparator to compare them
public class SortDecorator  extends SmartArrayDecorator{

    public SortDecorator(SmartArray smartArray, MyComparator comparator){
        super(smartArray);
        Object[] myArray= toArray();
        List<Object> newList = Arrays.asList(myArray);
        newList.sort(comparator);
        this.smartArray = new BaseArray(newList.toArray());


    }
    @Override
    public Object[] toArray() {
        return smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "Sorts elements using MyComparator to compare them.";
    }

    @Override
    public int size() {
        return smartArray.size();
    }
}
