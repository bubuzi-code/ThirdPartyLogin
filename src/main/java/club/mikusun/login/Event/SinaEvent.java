package club.mikusun.login.Event;

import club.mikusun.login.Bean.Sina.SinaAccessToken;
import club.mikusun.login.Bean.Sina.SinaUsersInfo;
import club.mikusun.login.Config.Api;
import club.mikusun.login.Config.SinaLoginConfig;
import club.mikusun.login.Event.Server.EventServer;
import club.mikusun.login.Util.LoginHttpUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.java.Log;

import javax.servlet.ServletRequest;
import java.util.HashMap;

/**
 * @Author :yzw.
 * @Date :Created in 23:51 2018/12/26
 * @Description:
 * @Version:
 */
@Log
public final class SinaEvent implements EventServer {

    private static final SinaEvent sinaEvent=new SinaEvent();
    @Override
    public SinaUsersInfo login(ServletRequest request) throws Exception {
        return login(request, SinaUsersInfo.class);
    }

    @Override
    public <T> T login(ServletRequest request, Class<T> tClass) throws Exception {
        if(!StrUtil.hasEmpty(request.getParameter("error_code"))){
            throw new Exception("微博令牌错误");
        }
        SinaAccessToken accessToken =null;
        try{
            accessToken = getAccessToken(request, SinaAccessToken.class);
        }catch (Exception e){
            e.printStackTrace();
            log.warning("授权失败");
        }

        String access_token = accessToken.getAccess_token();
        String uid = accessToken.getUid();
        return LoginHttpUtil.sendGet(Api.SINA_USER_INFO,new HashMap<String, String>(){{
            put("access_token",access_token);
            put("uid",uid);
        }},tClass,1000);
    }

    @Override
    public SinaAccessToken getAccessToken(ServletRequest request) throws Exception {
        return null;
    }

    @Override
    public <T> T getAccessToken(ServletRequest request, Class<T> tClass) throws Exception {
        final String code = request.getParameter("code");
        return LoginHttpUtil.sendPost(Api.SINA_TOKEN,new HashMap<String, Object>(){{
            put("grant_type","authorization_code");
            put("client_id", SinaLoginConfig.getClientId());
            put("client_secret",SinaLoginConfig.getSecret());
            put("redirect_uri",SinaLoginConfig.getRedirectUri());
            put("code",code);
        }},tClass,2000);
    }

    public static SinaEvent openConnect(){
        return sinaEvent;
    }

}
