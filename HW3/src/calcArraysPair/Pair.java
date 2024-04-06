package calcArraysPair;

/*
Напишите обобщенный класс Pair, который представляет собой пару значений разного типа.
Класс должен иметь методы getFirst(), getSecond() для получения значений
пары, а также переопределение метода toString(), возвращающее строковое представление пары.
 */

public class Pair <E>{
    E first;
    E second;

    public Pair(E first, E second){
        this.first = first;
        this.second = second;
    }

    public E getFirst() {
        return first;
    }

    public E getSecond() {
        return second;
    }

    @Override
    public String toString (){
        return "[" + first.toString() + ", " + second.toString() + "]";
    }
}
