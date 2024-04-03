package PersonTask;

public class Club<T extends Person> {
    T[] arrayT;

    public Club(T[] arrayT) {
        this.arrayT = arrayT;
    }

    public void start() {
        for (int i = 0; i < arrayT.length; i++) {
            arrayT[i].haveRest();
        }
    }
}
