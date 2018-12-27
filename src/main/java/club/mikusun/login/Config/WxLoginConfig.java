package club.mikusun.login.Config;

import lombok.extern.java.Log;

/**
 * @Author :yzw.
 * @Date :Created in 17:56 2018/12/24
 * @Description:
 * @Version:
 */
@Log
public final class WxLoginConfig{

    public static String getSecret() throws Exception {
        try {
            return CountConfig.getProperties(AttrManager.WX_SECRET).toString();
        } catch (Exception e) {
            throw new Exception("微信密钥获取失败,请检查配置文件");
        }
    }

    public static String getClientId() throws Exception {
        try {
            return CountConfig.getProperties(AttrManager.WX_APPID).toString();
        } catch (Exception e) {
            throw new Exception("微信Appid获取失败,请检查配置文件");
        }
    }

}
