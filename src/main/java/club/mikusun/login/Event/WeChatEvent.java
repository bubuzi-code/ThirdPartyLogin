package club.mikusun.login.Event;

import club.mikusun.login.Bean.WeChat.WxAccessToken;
import club.mikusun.login.Config.Api;
import club.mikusun.login.Config.WxLoginConfig;
import club.mikusun.login.Event.Server.EventServer;
import club.mikusun.login.Util.LoginHttpUtil;

import javax.servlet.ServletRequest;
import java.util.HashMap;

/**
 * @Author :yzw.
 * @Date :Created in 14:22 2018/12/26
 * @Description:
 * @Version:
 */
public final class WeChatEvent<T> implements EventServer {
    @Override
    public WxAccessToken login(ServletRequest request) throws Exception {
        return getAccessToken(request, WxAccessToken.class);
    }

    @Override
    public <A> A login(ServletRequest request, Class<A> aClass) throws Exception {
        return getAccessToken(request, aClass);
    }

    @Override
    public <T> T getAccessToken(ServletRequest request) throws Exception {
        return null;
    }

    @Override
    public <T> T getAccessToken(ServletRequest request, Class<T> tClass) throws Exception {
        final String code = request.getParameter("code");
        return LoginHttpUtil.sendGet(Api.WECHAT_TOKEN, new HashMap<String, String>() {{
            put("appid", WxLoginConfig.getClientId());
            put("secret", WxLoginConfig.getSecret());
            put("code", code);
            put("grant_type", "authorization_code");
        }}, tClass,1000);
    }
}
