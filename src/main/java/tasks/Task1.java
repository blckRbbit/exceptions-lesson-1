package tasks;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Реализуйте метод, принимающий в качестве аргумента целочисленный массив и некоторое значение.
 * Метод ищет в массиве заданное значение и возвращает его индекс. При этом, например:
 * <p>
 * 1. если длина массива меньше некоторого заданного минимума, метод возвращает -1, в качестве кода ошибки.
 * 2. если искомый элемент не найден, метод вернет -2 в качестве кода ошибки.
 * 3. если вместо массива пришел null, метод вернет -3
 * 4.Напишите метод, в котором реализуйте взаимодействие с пользователем.
 * То есть, этот метод запросит искомое число у пользователя, вызовет первый,
 * обработает возвращенное значение и покажет читаемый результат пользователю.
 * Например, если вернулся -2, пользователю выведется сообщение: “Искомый элемент не найден”.
 * 5. придумайте свои варианты исключительных ситуаций и верните соответствующие коды ошибок.
 */
public class Task1 {
    public static void print(int[] arg, int limit, int target) {
        int call = checkArrayLength(arg, limit, target);
        switch (call) {
            case -1 -> System.err.println("Length of array less to minimum length");
            case -2 -> System.err.println("This element was not found");
            case -3 -> System.err.println("Array cannot be null");
            default -> System.out.printf("Length of array equal %s%n", call);
        }
    }

    private static int checkArrayLength(int[] arg, int limit, int target) {
        if (arg == null) return -3;
        if (arg.length < limit) return -1;
        if (!isArrayContainsNumber(arg, target)) return -2;
        return arg.length;
    }

    private static boolean isArrayContainsNumber(int[] arg, int target) {
//        List<Integer> ints = Arrays.stream(arg).boxed().toList();
        return IntStream.range(0, arg.length).anyMatch(i -> Arrays.stream(arg).boxed().toList().contains(target));
    }
}
