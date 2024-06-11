public class BancoException extends Exception{
    String message;

    public BancoException(String message){
        this.message = message;
    }
    @Override
    public String getMessage() {
        return message;
    }
}
