package ua.edu.ucu.smartarr;
import java.util.ArrayList;


// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator{

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
        ArrayList<Object> newArray = new ArrayList<>();
        Object[] myArray= toArray();
        boolean same = false;
        int size= size();

        for (int i = 0; i< size-1;i++ ){
            for (int j = i+1; j<size;j++){
                if (myArray[i].equals(myArray[j])){
                   same = true;
                }
            }
            if(!same){
                newArray.add(myArray[i]);
            }

        }

        this.smartArray = new BaseArray(newArray.toArray());

//        smartArray= newArray;

    }

    @Override
    public Object[] toArray() {
        return smartArray.toArray();
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
