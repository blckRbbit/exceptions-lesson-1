package tasks;


import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный массив.
 * Необходимо посчитать и вернуть сумму элементов этого массива. При этом накладываем
 * на метод 2 ограничения:
 *  - метод может работать только с квадратными массивами (кол-во строк = кол-ву столбцов),
 *  - в каждой ячейке может лежать только значение 0 или 1.
 *
 *  Если нарушается одно из условий,
 * метод должен бросить RuntimeException с сообщением об ошибке.
 *
 */
public class Task2 {
    public static int getArrayElementsSum(int[][] arg) {
        if (isNotSquareArray(arg)) throw new RuntimeException("This isn't squared array");
        if (isDataNotCorrect(arg)) throw new RuntimeException("Array must contains 0 or 1");
        int result = 0;
        for (int [] ints: arg) {
            result += Arrays.stream(ints).sum();
        }
        // Arrays.stream(arg).mapToInt(ints -> Arrays.stream(ints).sum()).sum();
        return Arrays.stream(arg)
                .mapToInt(ints -> Arrays.stream(ints).sum()).sum();
    }

    private static boolean isNotSquareArray(int[][] arg) {
        return Arrays.stream(arg).anyMatch(arr -> arr.length != arg.length);

//        for (int[] arr : arg) {
//            if (arr.length != arg.length) {
//                return true;
//            }
//        }
//        return false;
    }

    private static boolean isDataNotCorrect(int[][] arg) {
        List<Integer> container = List.of(0, 1);
//        for (int i = 0; i < arg.length; i++) {
//            for (int j = 0; j < arg.length; j++) {
//                if (!container.contains(arg[i][j])) return true;
//            }
//        }
//        return false;
        return IntStream.range(0, arg.length)
                .anyMatch(i -> IntStream.range(0, arg.length)
                        .anyMatch(j -> !container.contains(arg[i][j])));
    }

}
