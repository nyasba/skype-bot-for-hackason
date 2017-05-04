package jp.co.gxp.bot.skype.domain.skype;

/**
 * SkypeのチャットルームのEnum
 * idはルームで{@code /get name}を行うことで取得可能
 */
public enum SkypeRoom {
    TEST("19:97dfc589f33342b3baece09dd3acba0a@thread.skype"); // FIXME 使うルームIDに修正すること
    
    private String id;
    
    SkypeRoom(String id) {
        this.id = id;
    }
    
    public String getId() {
        return this.id;
    }
}
