package symbolTable.exception;

public class NullSymbolTableException extends Error{
    @Override
    public void printStackTrace() {
        System.out.println("NullSymbolTableException:空符号表异常");
    }
}
