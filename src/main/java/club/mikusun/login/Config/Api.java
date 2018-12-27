package club.mikusun.login.Config;

/**
 * @Author :yzw.
 * @Date :Created in 17:30 2018/12/24
 * @Description: 集成第三方Api接口
 * @Version:
 */
public class Api {
    /**
     * 获取微信openId和唯一Id
     * 微信登陆
     */
    public static final String WECHAT_TOKEN= "https://api.weixin.qq.com/sns/oauth2/access_token";

    /**
     * 微博获取用户详细数据
     */
    public static final String SINA_USER_INFO = "https://api.weibo.com/2/users/show.json";
    /**
     * 微博验证令牌API
     */
    public static final String SINA_TOKEN = "https://api.weibo.com/oauth2/access_token";

    /**
     * QQ验证令牌API
     */
    public static final String TENCENT_TOKEN= "https://graph.qq.com/oauth2.0/token";

    /**
     * QQ获取openId
     */
    public static final String TENCENT_OPENID = "https://graph.qq.com/oauth2.0/me";

    /**
     * QQ获取用户详细数据
     */
    public static final String TENCENT_USER_INFO="https://graph.qq.com/user/get_user_info";
}
