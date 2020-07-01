import java.util.Arrays;

/**
 * Класс для тестирования Класса java.Sort
 */
public class TestSort {

    public static void testSort() {
        testReverseSort();
    }

    /**
     * Тестирование метода Sort.reverseSort
     */
    private static void testReverseSort() {
        int arr[] = {-3, 4, 2, 1, 5, -1, 0};
        int emptyArr[] = {};
        int oneElemArr[] = {6};
        int twoElemArr[] = {6, 4};
        int homogeneousArr[] = {0, 0, 0};

        StringBuilder fails = new StringBuilder();
        int okTestsCnt = 0;
        int totalTestsCnt = 0;

        // Тестирование общего случая.
        // Ожидаемый результат -- остротированный по невозрастанию массив
        totalTestsCnt++;
        Sort.reverseSort(arr);
        System.out.println(Arrays.toString(arr));
        try {
            int[] standardArr = Arrays.copyOf(arr, arr.length);
            Arrays.sort(standardArr);
            reverseArray(standardArr);
            Sort.reverseSort(arr);
            if (Arrays.equals(standardArr, arr)) {
                okTestsCnt++;
            } else {
                fails.append("Test " + totalTestsCnt + " fell down; ");
            }
        } catch (Exception ex) {
            fails.append("Test " + totalTestsCnt + " fell down; ");
        }

        // Тестирование с пустым массивом.
        // Ожидаемый результат -- пустой массив
        totalTestsCnt++;
        try {
            int[] standardEmptyArr = {};
            Sort.reverseSort(emptyArr);
            if (Arrays.equals(standardEmptyArr, emptyArr)) {
                okTestsCnt++;
            } else {
                fails.append("Test " + totalTestsCnt + " fell down; ");
            }
        } catch (Exception ex) {
            fails.append("Test " + totalTestsCnt + " fell down; ");
        }

        // Тестирование с содержажим один элемент массивом.
        // Ожидаемый результат -- массив содержащий один элемент
        totalTestsCnt++;
        try {
            int[] standardOneElemArr = Arrays.copyOf(oneElemArr, oneElemArr.length);
            Sort.reverseSort(oneElemArr);
            if (Arrays.equals(standardOneElemArr, oneElemArr)) {
                okTestsCnt++;
            } else {
                fails.append("Test " + totalTestsCnt + " fell down; ");
            }
        } catch (Exception ex) {
            fails.append("Test " + totalTestsCnt + " fell down; ");
        }

        // Тестирование с содержажим два элемента массивом.
        // Ожидаемый результат -- отсортированный по невозрастанию массив
        totalTestsCnt++;
        try {
            int[] standardTwoElemArr = Arrays.copyOf(twoElemArr, twoElemArr.length);
            Arrays.sort(standardTwoElemArr);
            reverseArray(standardTwoElemArr);
            Sort.reverseSort(twoElemArr);
            if (Arrays.equals(standardTwoElemArr, twoElemArr)) {
                okTestsCnt++;
            } else {
                fails.append("Test " + totalTestsCnt + " fell down; ");
            }
        } catch (Exception ex) {
            fails.append("Test " + totalTestsCnt + " fell down; ");
        }

        // Тестирование с содержажим одинаковые элементы массивом.
        // Ожидаемый результат -- тотже самый массив
        totalTestsCnt++;
        try {
            int[] standardHomogenousElemArr = Arrays.copyOf(homogeneousArr, homogeneousArr.length);
            Sort.reverseSort(homogeneousArr);
            if (Arrays.equals(standardHomogenousElemArr, homogeneousArr)) {
                okTestsCnt++;
            } else {
                fails.append("Test " + totalTestsCnt + " fell down; ");
            }
        } catch (Exception ex) {
            fails.append("Test " + totalTestsCnt + " fell down; ");
        }

        System.out.println("\nTEST Sort.reverseSort\nOk " + okTestsCnt + "; Total "
                + totalTestsCnt + "\n" + fails + "\n");
    }

    private static void reverseArray(int[] array) {
        int n = array.length / 2;
        for (int i = 0; i < n; i++) {
            int tmp = array[i];
            array[i] = array[n + i];
            array[n + i] = tmp;
        }
    }
}
