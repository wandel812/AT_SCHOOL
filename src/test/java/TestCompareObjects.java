import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Класс производящий тест класа java.CompareObjects
 *
 * метод compareObjects должен отвечать определенным правилам сравнения, которые определяются
 * для конкрентного проекта. Существуют правила (контракт) которым должен соответствовать
 * метод equals (и Compare), но в зависимосте от реализации (instance of vs. getClass) происходит
 * нарушение одного или иного из принципов при сравнении объектов заданной ветки иерархии классов.
 * Реализация метода сравнения выбирается исходя из логики программы. Поскольку в задаче нет
 * специальных указаний сравнения потомков и предков в тестах опущено.
 */

public class TestCompareObjects {
    private static List<String> stringData;
    private static TestObject testObject1;
    private static TestObject testObject2;

    static {
        stringData = new ArrayList<>();
        stringData.add("Alex Alex");
        stringData.add("Boris Boris");
        stringData.add("Trump Trump");
        stringData.add("Rump Rump");
        stringData.add("Boris Boris");
    }

    public static void testCompareObjects() {
        testCompare();
        testCompareToString();
        testCompareHashCode();
    }

    /**
     * Тестирование метода CompareObjects.Compare
     */
    private static void testCompare() {
        StringBuilder fails = new StringBuilder();
        int okTestsCnt = 0;
        int totalTestsCnt = 0;

        // сравение объектов одного класса, но разного значения между собой и с самим собой.
        // Ожидаемое значение true при равных строках, иначе false
        for (int i = 0; i < stringData.size(); i++) {
            for (int j = 0; j < stringData.size(); j++) {
                totalTestsCnt++;
                boolean res = CompareObjects.compare(stringData.get(i), stringData.get(j));
                boolean standardRes = stringData.get(i).equals(stringData.get(j));
                if (res == standardRes) {
                    okTestsCnt++;
                } else {
                    fails.append("Test " + totalTestsCnt + " fell down; ");
                }
            }
        }

        // сравнение объектов одного класса с одинаковыми полями. Ожидается true
        testObject1 = new TestObject();
        testObject2 = new TestObject();
        totalTestsCnt++;
        if (CompareObjects.compare(testObject1, testObject2)) {
            okTestsCnt++;
        } else {
            fails.append("Test " + totalTestsCnt + " fell down; ");
        }

        // сравнение одинаковых объектов с различающимся полем field1. Ожидается false
        testObject1.setField1(777);
        totalTestsCnt++;
        if (!CompareObjects.compare(testObject1, testObject2)) {
            okTestsCnt++;
        } else {
            fails.append("Test " + totalTestsCnt + " fell down; ");
        }

        // сравнение объекта с null. Ожидается false
        totalTestsCnt++;
        try {
            if (!CompareObjects.compare(testObject1, null)) {
                okTestsCnt++;
            }
        } catch (NullPointerException ex) {
            fails.append("Test " + totalTestsCnt + " fell down; ");
        }

        // null с объектом. Ожидается false
        totalTestsCnt++;
        try {
            if (!CompareObjects.compare(null, testObject1)) {
                okTestsCnt++;
            }
        } catch (NullPointerException ex) {
            fails.append("Test " + totalTestsCnt + " fell down; ");
        }

        // сравнение объектов разного класса. Ожидается false
        totalTestsCnt++;
        if (!CompareObjects.compare(stringData.get(0), testObject1)) {
            okTestsCnt++;
        } else {
            fails.append("Test " + totalTestsCnt + " fell down; ");
        }

        System.out.println("\nTEST CompareObjects.compare\nOk " + okTestsCnt + "; Total "
                + totalTestsCnt + "\n" + fails + "\n");
    }

    /**
     * Тестирование метода CompareObjects.CompareToString
     */
    private static void testCompareToString() {
        StringBuilder fails = new StringBuilder();
        int okTestsCnt = 0;
        int totalTestsCnt = 0;

        // сравнение объектов одного класса, но разного значения между собой и с самим собой.
        // Ожидаемое значение true при равных строках, иначе false
        for (int i = 0; i < stringData.size(); i++) {
            for (int j = 0; j < stringData.size(); j++) {
                totalTestsCnt++;
                boolean res = CompareObjects.compareToString(stringData.get(i), stringData.get(j));
                boolean standardRes = stringData.get(i).toString().equals(stringData.get(j).toString());
                if (res == standardRes) {
                    okTestsCnt++;
                } else {
                    fails.append("Test " + totalTestsCnt + " fell down; ");
                }
            }
        }

        // сравнение объектов одного класса с одинаковыми полями. Ожидается true
        testObject1 = new TestObject();
        testObject2 = new TestObject();
        totalTestsCnt++;
        if (CompareObjects.compareToString(testObject1, testObject2)) {
            okTestsCnt++;
        } else {
            fails.append("Test " + totalTestsCnt + " fell down; ");
        }

        // сравнение одинаковых объектов с различающимся полем field1. Ожидается false
        testObject1.setField1(777);
        totalTestsCnt++;
        if (!CompareObjects.compareToString(testObject1, testObject2)) {
            okTestsCnt++;
        } else {
            fails.append("Test " + totalTestsCnt + " fell down; ");
        }

        // сравнение объекта с null. Ожидается false
        totalTestsCnt++;
        try {
            if (!CompareObjects.compareToString(testObject1, null)) {
                okTestsCnt++;
            }
        } catch (NullPointerException ex) {
            fails.append("Test " + totalTestsCnt + " fell down; ");
        }

        // null с объектом. Ожидается false
        totalTestsCnt++;
        try {
            if (!CompareObjects.compareToString(null, testObject1)) {
                okTestsCnt++;
            }
        } catch (NullPointerException ex) {
            fails.append("Test " + totalTestsCnt + " fell down; ");
        }


        // сравнение объектов разного класса. Ожидается false
        totalTestsCnt++;
        if (!CompareObjects.compareToString(stringData.get(0), testObject1)) {
            okTestsCnt++;
        } else {
            fails.append("Test " + totalTestsCnt + " fell down; ");
        }

        System.out.println("\nTEST CompareObjects.compareToString\nOk " + okTestsCnt + "; Total "
                + totalTestsCnt + "\n" + fails + "\n");
    }

    /**
     * Тестирование метода CompareObjects.CompareHashCode
     */
    private static void testCompareHashCode() {
        StringBuilder fails = new StringBuilder();
        int okTestsCnt = 0;
        int totalTestsCnt = 0;

        // сравнение объектов одного класса. Если объекты равны, то его хэш коды должны быть равны.
        // ожидаемые значения true
        for (String datum : stringData) {
            for (String stringDatum : stringData) {
                boolean res = CompareObjects.compareHashCode(datum, stringDatum);
                if (datum.equals(stringDatum)) {
                    totalTestsCnt++;
                    if (res) {
                        okTestsCnt++;
                    } else {
                        fails.append("Test " + totalTestsCnt + " fell down; ");
                    }
                }
            }
        }

        // функция не должна упасть с null в качестве аргумента
        totalTestsCnt++;
        try {
            CompareObjects.compareToString(testObject1, null);
            okTestsCnt++;
        } catch (NullPointerException ex) {
            fails.append("Test " + totalTestsCnt + " fell down; ");
        }

        // функция не должна упасть с null в качестве аргумента
        totalTestsCnt++;
        try {
            CompareObjects.compareToString(null, testObject1);
            okTestsCnt++;
        } catch (NullPointerException ex) {
            fails.append("Test " + totalTestsCnt + " fell down; ");
        }

        System.out.println("\nTEST CompareObjects.compareHashCode\nOk " + okTestsCnt + "; Total "
                + totalTestsCnt + "\n" + fails + "\n");

    }

    private static class TestObject {
        private Integer field1;
        private Double field2;
        private String field3;

        public TestObject() {
            field1 = 1234;
            field2 = 1.234;
            field3 = "test";
        }

        public void setField1(Integer field1) {
            this.field1 = field1;
        }

        public void setField2(Double field2) {
            this.field2 = field2;
        }

        public void setField3(String field3) {
            this.field3 = field3;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TestObject that = (TestObject) o;
            return field1.equals(that.field1) &&
                    field2.equals(that.field2) &&
                    field3.equals(that.field3);
        }

        @Override
        public int hashCode() {
            return Objects.hash(field1, field2, field3);
        }

        @Override
        public String toString() {
            return "TestObject{" +
                    "field1=" + field1 +
                    ", field2=" + field2 +
                    ", field3='" + field3 + '\'' +
                    '}';
        }
    }
}
