package Cryptoanalizer.Utils;

import Cryptoanalizer.BruteForce;
import Cryptoanalizer.Cipher;

import java.util.LinkedHashMap;

import static Cryptoanalizer.Utils.Alphabet.*;
import static Cryptoanalizer.Utils.Printable.*;

public class Menu {
    private static final int ENCODE = 1;
    private static final int DECODE = 2;
    public static void chooseMode() {
        printText(CHOOSE_MODE);
        int chosenMode = Scanner.scanInt();
        switch (chosenMode) {
            case 1: {
                chooseEncodeMode();
                break;
            }
            case 2: {
                chooseDecodeMode();
                break;
            }
            case 3: {
                BruteForce.bruteForceLine();
                break;
            }
            case 4: {
                printText(COME_BACK_SOON);
                break;
            }
            default: break;
        }

    }



    private static void chooseEncodeMode() {
        String chosenAlphabet = chooseAlphabet();
        int shift = chooseShift(chosenAlphabet);
        LinkedHashMap<Character, Character> createdAlphabet = createAlphabet(chosenAlphabet,shift,ENCODE);
        printText(CHOOSE_ENCODE_MODE);
        int chosenEncodeMode = Scanner.scanInt();
        switch (chosenEncodeMode) {
            case 1: {
                printText(NICE_CHOICE);
                Cipher.encodeDecodeMessage(createdAlphabet);
                break;
            }
            case 2: {
                printText(NICE_CHOICE);
                Cipher.encodeDecodeFile(createdAlphabet);
                printText(ALL_IS_ENCODED);
                break;
            }
            case 3: {
                printText(COME_BACK_SOON);
                break;
            }
            default: break;
        }

    }


    private static void chooseDecodeMode() {
        String chosenAlphabet = chooseAlphabet();
        int shift = chooseShift(chosenAlphabet);
        LinkedHashMap<Character, Character> createdAlphabet = createAlphabet(chosenAlphabet,shift,DECODE);

        printText(CHOOSE_DECODE_MODE);
        int chosenEncodeMode = Scanner.scanInt();
        switch (chosenEncodeMode) {
            case 1: {
                printText(NICE_CHOICE);
                Cipher.encodeDecodeMessage(createdAlphabet);
                break;
            }
            case 2: {
                printText(NICE_CHOICE);
                Cipher.encodeDecodeFile(createdAlphabet);
                printText(ALL_IS_DECODED);
                break;
            }
            case 3: {
                printText(COME_BACK_SOON);
                break;
            }
            default: break;
        }

    }
}
