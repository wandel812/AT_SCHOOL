import java.util.HashMap;

/**
 * Класс для тестирования класса java.Map
 */
public class TestMap {
    public static void testMap() {
        testCountElementsInMap();
        testDeleteValueFromMap();
    }

    /**
     * Тест метода Map.countElementsInMap
     */
    private static void testCountElementsInMap() {
        StringBuilder fails = new StringBuilder();
        int okTestsCnt = 0;
        int totalTestsCnt = 0;

        // Тест сравнения строк на поэлементно. Ожиданиемое значение 1
        totalTestsCnt++;
        try {
            String firstName = new String("Алексей");
            String lastName = "Дмитров";
            if (Map.countElementsInMap(lastName, firstName) == 1) {
                okTestsCnt++;
            } else {
                fails.append("Test " + totalTestsCnt + " fell down; ");
            }
        } catch (Exception ex) {
            fails.append("Test " + totalTestsCnt + " fell down; ");
        }

        // Тест на лидирующие и завершающие пробелы. Ожидаемое значение 3
        try {
            totalTestsCnt++;
            String firstName = "Сергей";
            String lastName = "Ерохин";
            if (Map.countElementsInMap(lastName, firstName) == 3) {
                okTestsCnt++;
            } else {
                fails.append("Test " + totalTestsCnt + " fell down; ");
            }
        } catch (Exception ex) {
            fails.append("Test " + totalTestsCnt + " fell down; ");
        }

        // Тест на отсутствующую запись. Ожидаемое значение 0
        totalTestsCnt++;
        try {
            String firstName = "Владимир";
            String lastName = "Красное солнышко";
            if (Map.countElementsInMap(lastName, firstName) == 0) {
                okTestsCnt++;
            } else {
                fails.append("Test " + totalTestsCnt + " fell down; ");
            }
        } catch (Exception ex) {
            fails.append("Test " + totalTestsCnt + " fell down; ");
        }

        // Тест на учет имени в сравнении. Ожидаемое значение 0
        totalTestsCnt++;
        try {
            String firstName = "Владимир";
            String lastName = "Ярмолов";
            if (Map.countElementsInMap(lastName, firstName) == 0) {
                okTestsCnt++;
            } else {
                fails.append("Test " + totalTestsCnt + " fell down; ");
            }
        } catch (Exception ex) {
            fails.append("Test " + totalTestsCnt + " fell down; ");
        }

        // Тест на учет фамилии в сравнении. Ожидаемое значение 0
        try {
            totalTestsCnt++;
            String firstName = "Алексей";
            String lastName = "Петренко";
            if (Map.countElementsInMap(lastName, firstName) == 0) {
                okTestsCnt++;
            } else {
                fails.append("Test " + totalTestsCnt + " fell down; ");
            }
        } catch (Exception ex) {
            fails.append("Test " + totalTestsCnt + " fell down; ");
        }

        System.out.println("\nTEST Map.countElementsInMap\nOk " + okTestsCnt + "; Total "
                + totalTestsCnt + "\n" + fails + "\n");
    }

    /**
     * Тестирование метода Map.deleteValueFromMap
     * <p>
     * Из кода не понятно подразумевается ли изменение map подающейся в качестве
     * аргумента. Поэтому данная проверка пропускается.
     */
    private static void testDeleteValueFromMap() {
        StringBuilder fails = new StringBuilder();
        int okTestsCnt = 0;
        int totalTestsCnt = 0;

        // Тест на удаление нескольких значений map. Ожидаемое значение 3
        totalTestsCnt++;

        try {
            String firstName = "Алексей";
            if (Map.deleteValueFromMap(makeGivenMap(), firstName).size() == 3) {
                okTestsCnt++;
            } else {
                fails.append("Test " + totalTestsCnt + " fell down; ");
            }
        } catch (Exception ex) {
            fails.append("Test " + totalTestsCnt + " fell down; ");
        }

        // Тест на удаление несуществующего значения map. Ожидаемое значение 6
        totalTestsCnt++;
        try {
            String firstName = "Рудольф";
            if (Map.deleteValueFromMap(makeGivenMap(), firstName).size() == 6) {
                okTestsCnt++;
            } else {
                fails.append("Test " + totalTestsCnt + " fell down; ");
            }
        } catch (Exception ex) {
            fails.append("Test " + totalTestsCnt + " fell down; ");
        }


        // Тест на удаление одного значения map. Ожидаемое значение 5
        totalTestsCnt++;
        try {
            String firstName = "Сергей";
            if (Map.deleteValueFromMap(makeGivenMap(), firstName).size() == 5) {
                okTestsCnt++;
            } else {
                fails.append("Test " + totalTestsCnt + " fell down; ");
            }
        } catch (Exception ex) {
            fails.append("Test " + totalTestsCnt + " fell down; ");
        }

        System.out.println("\nTEST Map.deleteValueFromMap\nOk " + okTestsCnt + "; Total "
                + totalTestsCnt + "\n" + fails + "\n");
    }

    private static HashMap<String, String> makeGivenMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Дмитров", "Алексей");
        map.put("Ерохин", "Сергей");
        map.put("Ярмолов", "Алексей");
        map.put("Андреев", "Андрей");
        map.put("Смирнов", "Владимир");
        map.put("Алексеев", "Алексей");

        return map;
    }
}
