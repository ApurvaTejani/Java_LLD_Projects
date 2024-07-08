package Exception;

public class InvalidGameConstructorParameterException extends Exception{
    public InvalidGameConstructorParameterException(String msg){
        System.out.println(msg);
    }
}
