package club.mikusun.login.Event;

import club.mikusun.login.Bean.Tencent.TencentAccessToken;
import club.mikusun.login.Bean.Tencent.TencentUsersInfo;
import club.mikusun.login.Config.Api;
import club.mikusun.login.Config.TencentLoginConfig;
import club.mikusun.login.Event.Server.EventServer;
import club.mikusun.login.Util.LoginHttpUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.extern.java.Log;

import javax.servlet.ServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author :yzw.
 * @Date :Created in 23:50 2018/12/26
 * @Description:
 * @Version:
 */
@Log
public final class TencentEvent implements EventServer {


    public static final TencentEvent tencentEvent=new TencentEvent();
    @Override
    public TencentUsersInfo login(ServletRequest request) throws Exception {
        return login(request, TencentUsersInfo.class);
    }

    @Override
    public <T> T login(ServletRequest request, Class<T> tClass) throws Exception {
        if(!StrUtil.hasEmpty(request.getParameter("error_code"))){
            throw new Exception("腾讯令牌错误");
        }
        TencentAccessToken accessToken = new TencentAccessToken();
        try{
            String result = getAccessToken(request, String.class);
            String[] arrays = result.split("&");
            Map<String , Object> map = new HashMap<>();
            for (int i = 0; i < arrays.length; i++) {
                String[] strs = arrays[i].split("=");
                map.put(strs[0] , strs[1]);
            }
            accessToken.setAccess_token((String) map.get("access_token"));
            accessToken.setExpires_in((String)map.get("expires_in"));
            accessToken.setRefresh_token((String)map.get("refresh_token"));
        }catch (Exception e){
            e.printStackTrace();
            log.warning("授权失败");
        }
        String open = LoginHttpUtil.sendGet(Api.TENCENT_OPENID, new HashMap<String, String>() {{
            put("access_token", accessToken.getAccess_token());
        }}, String.class, 1000).replace("callback(","").replace(")","");
        JSONObject jsonObj = JSONUtil.parseObj(open);
        Map map = jsonObj.toBean(Map.class);
        return LoginHttpUtil.sendGet(Api.TENCENT_USER_INFO,new HashMap<String, String>(){{
            put("access_token",accessToken.getAccess_token());
            put("oauth_consumer_key",TencentLoginConfig.getClientId());
            put("openid", (String) map.get("openid"));
        }},tClass,1000);
    }

    @Override
    public <T> T getAccessToken(ServletRequest request) throws Exception {
        return null;
    }

    @Override
    public <T> T getAccessToken(ServletRequest request, Class<T> tClass) throws Exception {
        final String code = request.getParameter("code");
        return LoginHttpUtil.sendPost(Api.TENCENT_TOKEN,new HashMap<String, Object>(){{
            put("grant_type","authorization_code");
            put("client_id", TencentLoginConfig.getClientId());
            put("client_secret",TencentLoginConfig.getSecret());
            put("redirect_uri",TencentLoginConfig.getRedirectUri());
            put("code",code);
        }},tClass,2000);
    }

    public static TencentEvent openConnect(){
        return tencentEvent;
    }
}
