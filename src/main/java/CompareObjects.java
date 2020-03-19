public class CompareObjects {

    /**
     * Метод сравнения объектов
     * @param object1 - первый объект для сравнения
     * @param object2 - второй лбъект для сравнения
     * @return boolean - Равны ли объекты
     */
    public static boolean compare(Object object1, Object object2){
        return object1.equals(object2);
    }

    /**
     * Метод переводит объекты в строку и дальше сравнивает
     * @param object1 - первый объект для сравнения
     * @param object2 - второй лбъект для сравнения
     * @return boolean - Равны ли объекты
     */
    public static boolean compareToString(Object object1, Object object2){
        return object1.toString().equals(object2.toString());
    }

    /**
     * Метод сравнивает хэш-коды объектов
     * @param object1 - первый объект для сравнения
     * @param object2 - второй лбъект для сравнения
     * @return boolean - Равны ли объекты
     */
    public static boolean compareHashCode(Object object1, Object object2){
        return object1.hashCode() == object2.hashCode();
    }

    // Какой из методов вернет false? Почему?
    // Напишите свою реализцию сравнения экземпляров класса, который при сравнении вернет true
}
