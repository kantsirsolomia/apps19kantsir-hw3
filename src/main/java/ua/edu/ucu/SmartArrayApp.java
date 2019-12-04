package ua.edu.ucu;

import java.util.Arrays;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

public class SmartArrayApp {

    public static final double POINT = 4.0;
    public static void main(String[] args) {
        BaseArray a = new BaseArray(new Integer[]{1,2,3,4,5});
        MapDecorator b = new MapDecorator(a,x->(Integer)x*(Integer)x);
        System.out.println(Arrays.toString(a.toArray()));
        System.out.println(Arrays.toString(b.toArray()));
        a.setValue(0); // що це працювало додайте метод setValue(int index){array[index] = 0};
        System.out.println(Arrays.toString(a.toArray()));
        System.out.println(Arrays.toString(b.toArray()));
    }

//    public static void main(String [ ] args){
//        Student[] students = {
//                new Student("Ivar", "Grimstad", 3.9, 2),
//                new Student("Ittai", "Zeidman", 4.5, 1),
//                new Student("Antons", "Kranga", 4.0, 2),
//                new Student("Burr", "Sutter", 4.2, 2),
//                new Student("Philipp", "Krenn", 4.3, 3),
//                new Student("Tomasz", "Borek", 4.1, 2),
//                new Student("Ittai", "Zeidman", 4.5, 1),
//                new Student("Burr", "Sutter", 4.2, 2)};
//
//        String[] a = findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(students);
//        System.out.println(a);
//
//    }

    public static Integer[]
            filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {
                
        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
        sa = new SortDecorator(sa, cmp); // Result: [1, 2, 3]
        sa = new MapDecorator(sa, func); // Result: [2, 4, 6]

        // Alternative
//        sa = new MapDecorator(
//                    new SortDecorator(
//                        new FilterDecorator(sa, pr),
//                    cmp),
//                func);
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
            findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(Student[] students) {
        MyPredicate predicate = t -> {
            Student student = (Student) t;
            return (student.getYear() == 2) && (student.getGPA() >= POINT);
        };

               MyFunction myFunc = t -> {
            Student student = (Student) t;
            return student.getSurname() + " " + student.getName();
        };

        MyComparator myComp = (o1, o2) -> {
            Student surname = (Student) o1;
            Student surname2 = (Student) o2;
            return (surname.getSurname().compareTo(surname2.getSurname()));
        };


        SmartArray smartArrayStudents = new BaseArray(students);

        smartArrayStudents = new DistinctDecorator(smartArrayStudents);
        smartArrayStudents = new FilterDecorator(smartArrayStudents,predicate);
        smartArrayStudents = new SortDecorator(smartArrayStudents, myComp);

        smartArrayStudents = new MapDecorator(smartArrayStudents, myFunc);


        Object[] result = smartArrayStudents.toArray();
        return Arrays.copyOf(result, result.length, String[].class);

        // Hint: to convert Object[] to String[] - use the following code
        //Object[] result = studentSmartArray.toArray();
        //return Arrays.copyOf(result, result.length, String[].class);

    }
}
