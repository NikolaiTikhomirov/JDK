package PersonTask;

public class Workplace<T extends Person> {
    T[] arrayT;

    public Workplace(T[] arrayT) {
        this.arrayT = arrayT;
    }

    public void start() {
        for (int i = 0; i < arrayT.length; i++) {
            arrayT[i].doWork();
        }
    }
}
