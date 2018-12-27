package club.mikusun.login.Config;

/**
 * @Author :yzw.
 * @Date :Created in 18:34 2018/12/26
 * @Description:
 * @Version:
 */
public class AttrManager {
    public static final AttrManager attrManager= new AttrManager();;

    static String WX_APPID="wx_ClientId";
    static String WX_SECRET="wx_Secret";

    static String SINA_APPID ="sina_ClientId";
    static String SINA_SECRET ="sina_Secret";
    static String SINA_REDIRECTURI = "sina_RedirectUri";

    static String TENCENT_APPID ="tencent_ClientId";
    static String TENCENT_SECRET ="tencent_Secret";
    static String TENCENT_REDIRECTURI = "tencent_RedirectUri";

    public AttrManager setWxAppid(String wxAppid) {
        WX_APPID = wxAppid;
        return attrManager;
    }

    public AttrManager setWxSecret(String wxSecret) {
        WX_SECRET = wxSecret;
        return attrManager;
    }

    public AttrManager setSinaClientId(String SinaClientId) {
        SINA_APPID = SinaClientId;
        return attrManager;
    }

    public AttrManager setSinaSecret(String sinaSecret) {
        SINA_SECRET = sinaSecret;
        return attrManager;
    }

    public AttrManager setSinaRedirectUri(String sinaRedirectUri) {
        SINA_REDIRECTURI = sinaRedirectUri;
        return attrManager;
    }

    public AttrManager setTencentClientId(String SinaClientId) {
        SINA_APPID = SinaClientId;
        return attrManager;
    }

    public AttrManager setTencentSecret(String sinaSecret) {
        SINA_SECRET = sinaSecret;
        return attrManager;
    }

    public AttrManager setTencentRedirectUri(String sinaRedirectUri) {
        SINA_REDIRECTURI = sinaRedirectUri;
        return attrManager;
    }

    public CountConfig closeReset(){
        return CountConfig.config;
    }
}
