package Cryptoanalizer;

import Cryptoanalizer.Exeption.WrongFilePath;
import Cryptoanalizer.Utils.Printable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;

import static Cryptoanalizer.Utils.Alphabet.*;
import static Cryptoanalizer.Cipher.decodeFile;
import static Cryptoanalizer.Utils.FilePaths.getFilePath;

public class BruteForce {
    public static void bruteForceLine() {
        String chosenAlphabet = chooseAlphabet();
        String filePath = getFilePath();
        try (BufferedReader bufferedReader = new BufferedReader( new FileReader(filePath))) {
            for (int shift = 0; shift < chosenAlphabet.length(); shift++) {
                LinkedHashMap<Character, Character> createdAlphabet = createAlphabet(chosenAlphabet,shift,2);
                bufferedReader.mark(chosenAlphabet.length());
                String line = bufferedReader.readLine();
                bufferedReader.reset();
                char[] chars = line.toCharArray();
                char[] decodedLine = new char[chars.length];
                for (int i = 0; i < chars.length; i++) {
                    if (createdAlphabet.containsValue(chars[i])) {
                        decodedLine[i] = createdAlphabet.get(chars[i]);
                    } else {
                        decodedLine[i] = chars[i];
                    }
                }
                if (checkDecodeLine(String.valueOf(decodedLine))) {
                    Printable.printText("Величина сдвига:" + shift);
                    decodeFile(filePath,shift, chosenAlphabet);
                    break;
                }
            }
        } catch (IOException e) {
            throw new WrongFilePath("Неверно введен путь");
        }
    }

    private static boolean checkDecodeLine(String decodedLine) {
        if (decodedLine.contains(", ") || decodedLine.contains(". "))
        {
            if (!decodedLine.contains(" ъ") && !decodedLine.contains(" Ъ")&& !decodedLine.contains(".Ъ")&& !decodedLine.contains(".ъ")
                    && !decodedLine.contains("\"Ъ")&& !decodedLine.contains("\"ъ")&& !decodedLine.contains(":Ъ")&& !decodedLine.contains(":ъ")
                    && !decodedLine.contains("-:")&& !decodedLine.contains(":.")&& !decodedLine.contains("--")&& !decodedLine.contains("(,")
                    && !decodedLine.contains(",.")){
                return true;
            }

        }
        return false;
    }
}
