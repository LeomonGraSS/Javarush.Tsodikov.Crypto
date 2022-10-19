package Cryptoanalizer;

import Cryptoanalizer.Utils.Menu;
import Cryptoanalizer.Utils.Printable;

public class Runner {
    public static void main(String[] args) {

        Printable.printText("Привет:) \nЗдорово, что ты здесь, давай что-нибудь зашифруем или расшифруем!");
        Menu.chooseMode();
    }
}

