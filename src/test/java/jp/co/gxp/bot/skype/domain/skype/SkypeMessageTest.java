//
//
package jp.co.gxp.bot.skype.domain.skype;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SkypeMessageTest {


    /**
     * 文字列が判定できていることを期待するテスト
     */
    @Test
    public void test() throws Exception {
        SkypeMessage skypeMessage = new SkypeMessage("test");
        SkypeMessage reverseSkypeMessage = skypeMessage.getReverseMessage();
        assertThat("tset", is(reverseSkypeMessage.getValue()));
    }

}
