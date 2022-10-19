package Cryptoanalizer.Utils;

public enum Printable {
    CHOOSE_MODE("Выбери режим работы: \n 1 - Шифрование \n 2 - Расшифровка \n 3 - Взлом шифра \n 4 - Выход"),
    COME_BACK_SOON("Возвращайся скорее!"),
    CHOOSE_ENCODE_MODE("Выбери режим шифрования: \n 1 - Шифрование текста из консоли \n 2 - Шифрование файла \n 3 - Выход"),
    CHOOSE_DECODE_MODE("Выбери режим расшифровки: \n 1 - Расшифровка текста из консоли \n 2 - Расшифровка файла \n 3 - Выход"),
    NICE_CHOICE("Отличный выбор!"),
    CHOOSE_ALPHABET("Выбери алфавит для использования: " +
            "\n 1 - русский (АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя.,\":-!?() ) " +
            "\n 2 - английский (ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz.,\":-!? ())" +
            "\n 3 - собственный (необходимо будет ввести свой алфавит, не менее 3 символов например : абвгдеёжзийклмн ():.,)"),
    CHOOSE_SHIFT("Введи величину сдвига:"),
    ALL_IS_ENCODED("Я все зашифровал, посмотри :)"),
    ALL_IS_DECODED("Я все расшифровал, посмотри :)"),
    ALL_IS_READY("Все готово, посмотри :)");

    private final String title;

    Printable(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
    public static void printText(Printable message){
        System.out.println(message);
    }
    public static void printText(String message){
        System.out.println(message);
    }
    public static void printText(Character message) {
        System.out.println(message);
    }
    public static void printMessage(Character message){
        System.out.print(message);
    }
}

