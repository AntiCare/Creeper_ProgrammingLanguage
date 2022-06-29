package nl.saxion.cos;

/**
 * @author YangCheng
 * @date 3/9/2022 6:17 PM
 */


/**
 * Throw when find error.
 */
public class CompilerException extends RuntimeException {
    public CompilerException(String errorMSG) {
        super(errorMSG);
    }
}
