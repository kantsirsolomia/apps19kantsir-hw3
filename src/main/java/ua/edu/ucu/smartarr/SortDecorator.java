package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Sorts elements using MyComparator to compare them
public class SortDecorator  extends SmartArrayDecorator{
    private MyComparator mycomp;

    public SortDecorator(SmartArray smartArray, MyComparator comparator){
        super(smartArray);
        mycomp = comparator;
    }

    @Override
    public Object[] toArray() {
        Object[] array = smartArray.toArray();
        Arrays.sort(array, mycomp);
        return array;
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
