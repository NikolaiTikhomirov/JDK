package calcArraysPair;

/*
Напишите обобщенный метод compareArrays(), который принимает два массива и
возвращает true, если они одинаковые, и false в противном случае. Массивы могут быть
любого типа данных, но должны иметь одинаковую длину и содержать элементы одного
типа.
 */

public class CompareArrays {

    public <E> Boolean compareArr (E[] arr1, E[] arr2){
        if (arr1.length == arr2.length){
            if (arr1.getClass().equals(arr2.getClass())){
                for (int i = 0; i < arr1.length; i++) {
                    if (arr1[i] != arr2[i]){
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
