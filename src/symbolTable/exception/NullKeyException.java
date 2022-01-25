package symbolTable.exception;

public class NullKeyException extends Error{
    @Override
    public void printStackTrace() {
        System.out.println("NullKeyException:空Key异常");
    }
}
