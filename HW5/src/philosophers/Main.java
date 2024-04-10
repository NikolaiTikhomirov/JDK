package philosophers;

/*
Условие:
● Есть пять философов (потоки), которые могут либо обедать (выполнение кода) либо размышлять (ожидание).
● Каждый философ должен пообедать три раза. Каждый прием пищи длиться 500 миллисекунд
● После каждого приема пищи философ должен размышлять
● Не должно возникнуть общей блокировки
● Философы не должны есть больше одного раза подряд
● Одновременно может есть только один философ
 */

public class Main {

    public static void main(String[] args) {
        EatingQueue eatingQueue = new EatingQueue();

        Thread philosother1 = new Philosopher("Platon", eatingQueue);
        Thread philosother2 = new Philosopher("Sokrat", eatingQueue);
        Thread philosother3 = new Philosopher("Aristotel", eatingQueue);
        Thread philosother4 = new Philosopher("Konfuciy", eatingQueue);
        Thread philosother5 = new Philosopher("Dekart", eatingQueue);

        philosother1.start();
        philosother2.start();
        philosother3.start();
        philosother4.start();
        philosother5.start();

    }
}