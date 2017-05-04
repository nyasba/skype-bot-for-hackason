package jp.co.gxp.bot.skype.domain.skype;

import jp.co.gxp.bot.skype.util.validator.ApiRequestEnum;

/**
 * SkypeのチャットルームのEnum
 * idはルームで{@code /get name}を行うことで取得可能
 */
public enum SkypeRoom implements ApiRequestEnum {
    TEST("test", "19:97dfc589f33342b3baece09dd3acba0a@thread.skype"); // FIXME 使うルームIDに修正すること
    
    private String apiValue;
    private String id;
    
    SkypeRoom(String apiValue, String id) {
        this.apiValue = apiValue;
        this.id = id;
    }
    
    public String getId() {
        return this.id;
    }
    
    public String getApiValue() {
        return apiValue;
    }
    
    public static SkypeRoom convertFromApiValue(String apiValue) {
        for (SkypeRoom e : SkypeRoom.values()) {
            if (e.getApiValue().equals(apiValue)) {
                return e;
            }
        }
        return null;
    }

}
