/* Воспользоваться утилитарным классом Lists:
○ Развернуть список элементов
○ Получить лист Character из строки
○ Разделить лист на группы по 2 элемента
● Воспользоваться утилитарным классом Sets
○ Получить итоговый Set из двух коллекций
○ Получить итоговый Set из общих элементов двух коллекций
○ Получить итоговый Set из непересекающихся элементов двух коллекций
 */

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class GuavaTest {
    public static void main(String[] args) {
        List<Character> data = Arrays.asList('A', 'B', 'C', 'D', 'E');
        System.out.println(data);
        System.out.println(Lists.reverse(data));

        String string = "I love Java";
        System.out.println(string);
        List<Character> list = new ArrayList<>();
        list = Lists.charactersOf(string);
        System.out.println(list);

        System.out.println(Lists.partition(list, 2));

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(list1);
        List<Integer> list2 = Arrays.asList(1, 5, 10, 8, 7);
        System.out.println(list2);
        Set<Integer> set1 = Sets.union(Set.copyOf(list1), Set.copyOf(list2));
        System.out.println(set1);
        Set<Integer> set2 = Sets.intersection(Set.copyOf(list1), Set.copyOf(list2));
        System.out.println(set2);
        Set<Integer> set3 = Sets.difference(set1, set2);
        System.out.println(set3);
    }
}
