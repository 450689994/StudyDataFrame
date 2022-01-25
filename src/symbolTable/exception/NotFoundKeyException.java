package symbolTable.exception;

public class NotFoundKeyException extends Error{
    @Override
    public void printStackTrace() {
        System.out.println("NotFoundKeyException:找不到键异常");
    }
}
