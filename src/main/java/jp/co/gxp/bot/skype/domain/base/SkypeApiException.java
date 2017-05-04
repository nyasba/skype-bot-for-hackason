package jp.co.gxp.bot.skype.domain.base;

/**
 * SkypeのAPIで発生した例外
 */
public class SkypeApiException extends RuntimeException {
    public SkypeApiException(String message) {
        super(message);
    }
}
