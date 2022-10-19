package Cryptoanalizer.Exeption;

public class WrongFilePath extends RuntimeException{
    public WrongFilePath(String message){
        super(message);
    }
}
