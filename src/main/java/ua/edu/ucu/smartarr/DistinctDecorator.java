package ua.edu.ucu.smartarr;
import java.util.ArrayList;
import java.util.Arrays;


// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
    }


    @Override
    public Object[] toArray() {
        Object[] arr = smartArray.toArray().clone();
        return Arrays.stream(arr).distinct().toArray();
    }

    @Override
    public String operationDescription() {
        return "Decorator returns an array without duplications.";
    }

    @Override
    public int size() {
        return smartArray.size();
    }
}
