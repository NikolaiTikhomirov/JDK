import PersonTask.*;
import calcArraysPair.Calculator;
import calcArraysPair.CompareArrays;
import calcArraysPair.Pair;
import myCollection.MyCollection;
import myCollection.MyCollectionIterator;

import java.util.Arrays;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        MyCollection<Integer> collection = new MyCollection<>();
        collection.addElement(1);
        collection.addElement(34);
        collection.addElement(66);
        collection.addElement(66);
        collection.addElement(66);
        collection.addElement(66);
        collection.addElement(66);
        collection.addElement(66);
        collection.addElement(66);
        collection.addElement(66);
        collection.addElement(66);
        System.out.println(Arrays.toString(collection.getValue()));
        collection.deleteElement(34);
        collection.deleteElement(66);
        System.out.println(Arrays.toString(collection.getValue()));
        MyCollectionIterator<Object> myCollectionIterator = new MyCollectionIterator<>(collection.value);

        while (myCollectionIterator.hasNext()) {
            System.out.print(myCollectionIterator.next() + ", ");
        }
        System.out.println("");
        System.out.println("===========================================================");
        System.out.println("===========================================================");

        Person[] persons = {new Worker(), new Idle(), new Worker(), new Worker()};
        Workplace<Person> workplace = new Workplace<>(persons);
        Club<Person> club = new Club<>(persons);
        workplace.start();
        System.out.println("============================================================");
        club.start();
        System.out.println("============================================================");

        /*
        Внедрить итератор из задания 2 в коллекцию, написанную в задании 3 таким образом,
        чтобы итератор был внутренним классом и, соответственно, объектом в коллекции.
         */

        MyCollectionIterator<Person> myCollectionIteratorSecond = new MyCollectionIterator<>(persons);
        while (myCollectionIteratorSecond.hasNext()) {
            Person person = myCollectionIteratorSecond.next();
            person.doWork();
            person.haveRest();
        }
        System.out.println("===========================================================");
        System.out.println("===========================================================");


        Calculator calculator = new Calculator();
        System.out.println(calculator.sum(21, -65.524521));
        System.out.println(Calculator.multiply(21, -65.524521));
        System.out.println(calculator.divide(21, -65.524521));
        System.out.println(calculator.subtract(21, -65.524521));
        System.out.println("===========================================================");
        System.out.println("===========================================================");

        CompareArrays compareArrays = new CompareArrays();
        String [] strArr1 = {"Gertruda", "Zhandana", "Petrendra", "Lusindra"};
        String [] strArr2TheSame = {"Gertruda", "Zhandana", "Petrendra", "Lusindra"};
        String [] strArr3DifferentName = {"Gertruda", "Kamila", "Petrendra", "Lusindra"};
        String [] strArr4DifferentSize = {"Gertruda", "Zhandana", "Petrendra", "Lusindra", "Klementina"};
        Integer [] intArr1 = {1, 2, 3, 4, 5};
        Integer [] intArr2 = {1, 2, 3, 4, 5};
        Integer [] intArr3 = {1, 3, 2, 5, 4};
        Integer [] intArr4 = {1, 2, 3, 4, 5, 6};
        System.out.println(compareArrays.compareArr(strArr1, strArr2TheSame));
        System.out.println(compareArrays.compareArr(strArr1, strArr3DifferentName));
        System.out.println(compareArrays.compareArr(strArr1, strArr4DifferentSize));
        System.out.println("===========================================================");
        System.out.println("===========================================================");
        System.out.println(compareArrays.compareArr(intArr1, intArr2));
        System.out.println(compareArrays.compareArr(strArr1, intArr3));
        System.out.println(compareArrays.compareArr(strArr1, intArr4));
        System.out.println("===========================================================");
        System.out.println("===========================================================");

        Pair pair = new Pair<>(12, "twelve");
        Pair pair1 = new Pair<>("water is dry", true);
        Pair pair2 = new Pair<>("the date and time is", new Date());
        System.out.println(pair);
        System.out.println(pair1);
        System.out.println(pair2);
    }
}
