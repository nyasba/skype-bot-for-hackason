package jp.co.gxp.bot.skype.util.validator;

import java.util.Enumeration;

/**
 * APIリクエストで使われるEnum
 */
public interface ApiRequestEnum<E extends Enumeration> {
    String getApiValue();
}
