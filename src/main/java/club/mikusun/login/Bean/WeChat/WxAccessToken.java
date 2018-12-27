package club.mikusun.login.Bean.WeChat;

import lombok.Data;

/**
 * @Author :yzw.
 * @Date :Created in 20:15 2018/12/24
 * @Description:微信实例化对象
 * @Version: 1.0
 */
@Data
public class WxAccessToken {

    private String access_token;

    private String expires_in;

    private String refresh_token;

    private String openid;

    private String scope;

    private String unionid;

    private String screen_name;
}
