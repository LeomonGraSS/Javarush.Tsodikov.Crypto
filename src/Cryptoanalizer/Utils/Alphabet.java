package Cryptoanalizer.Utils;

import java.util.LinkedHashMap;

public class Alphabet {
    private static final String RUSSIAN_ALPHABET = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя.,\":-!?() ";
    private static final String ENGLISH_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz.,\":-!? ()";


    public static LinkedHashMap<Character, Character> createAlphabet(String chosenAlphabet, int shift, int mode) {
        char[] keys = chosenAlphabet.toCharArray();
        char[] value = chosenAlphabet.toCharArray();
        if (shift>0 & shift<chosenAlphabet.length()){
            int counter1 = shift;
            int counter2 = 0;
            for (int i = 0; i < keys.length - shift; i++) {
                value[i] = keys[counter1];
                counter1++;
            }
            for (int i = keys.length - shift; i < keys.length; i++) {
                value[i] = keys[counter2];
                counter2++;
            }
        }
        else if (shift<0 & shift>-chosenAlphabet.length()){
            int counter1 = keys.length+shift;
            int counter2 = 0;
            for (int i = 0; i < -shift; i++) {
                keys[counter1] = value[i];
                counter1++;
            }
            for (int i = -shift; i < keys.length; i++) {
                keys[counter2] = value[i];
                counter2++;

            }
        }

        LinkedHashMap<Character, Character> createdAlphabet = new LinkedHashMap<>();
        for (int i = 0; i < keys.length; i++) {
            if (mode == 1){
                createdAlphabet.put(keys[i], value[i]);
            } else if (mode==2) {
                createdAlphabet.put(value[i], keys[i]);

            }

        }
        return createdAlphabet;

    }



    public static String chooseAlphabet() {
        Printable.printText(Printable.CHOOSE_ALPHABET);
        int chosenAlphabet = Scanner.scanInt();
        switch (chosenAlphabet) {
            case 1: {
                return RUSSIAN_ALPHABET;
            }
            case 2: {
                return ENGLISH_ALPHABET;
            }
            case 3: {
                Printable.printText("Неожиданный выбор :) Введи собственный алфавит: не менее 3 символов, символы не должны повторяться \n" +
                        " например : абвгдеёжзийклмн ():.,)");
                return Scanner.scanString();
            }
            default: {
                Printable.printText("По умолчанию будет использован английский алфавит");
                return ENGLISH_ALPHABET;
            }
        }
    }

    public static int chooseShift(String chosenAlphabet) {
        Printable.printText(Printable.CHOOSE_SHIFT);
        int shift = Scanner.scanInt();
        if (shift>chosenAlphabet.length()){
            return shift%(chosenAlphabet.length());
        } else if (shift<-chosenAlphabet.length()) {
            return shift%(chosenAlphabet.length());

        }
        else if (shift == 0){
            Printable.printText("Ты ввел 0, текст останется прежним");
        }
        return shift;
    }


}

