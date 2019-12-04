package ua.edu.ucu.smartarr;
import ua.edu.ucu.functions.MyPredicate;

import java.util.ArrayList;
import java.util.Arrays;


// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator{
    private MyPredicate mypredi;

    public FilterDecorator(SmartArray smartArray, MyPredicate predicate){
        super(smartArray);
        this.mypredi = predicate;
        }


    @Override
    public Object[] toArray() {
        return  Arrays.stream(smartArray.toArray()).filter(mypredi).toArray();
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
