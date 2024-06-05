public class ParametrosInvalidosException extends Exception {
    String message;
    public ParametrosInvalidosException(String message){
        this.message = message;
    }
    @Override
    public String getMessage() {
        return this.message;
    }
}
