package tasks;

import java.util.ArrayList;
import java.util.List;

/**
 *Реализуйте метод checkArray(Integer[] arr), принимающий в качестве аргумента
 * целочисленный одномерный массив.
 * Метод должен пройтись по каждому элементу и проверить что он не равен null.
 * А теперь реализуйте следующую логику:
 *
 * 1. Если в какой-то ячейке встретился null, то необходимо “оповестить” об этом пользователя
 * 2. Если null’ы встретились в нескольких ячейках, то идеально было бы все их “подсветить”
 *
 *  УСЛОЖНЕНИЕ: можно сделать массив Float и пообрабатывать там Infinity и Nan
 */
public class Task3 {
    public static void checkArray(Integer[] arr) {
        List<Integer> indexesOfNull = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                indexesOfNull.add(i);
            }
        }

        if (indexesOfNull.size() == 0) System.out.println("In this array elements equals null were not found");
        else throw new RuntimeException(
                String.format("In this array were found elements equals null. Indexes: %s", indexesOfNull)
        );
    }
}
