package club.mikusun.login.Config;

/**
 * @Author :yzw.
 * @Date :Created in 16:14 2018/12/27
 * @Description:
 * @Version:
 */
public class TencentLoginConfig {
    public static String getSecret() throws Exception {
        try {
            return CountConfig.getProperties(AttrManager.TENCENT_SECRET).toString();
        } catch (Exception e) {
            throw new Exception("腾讯密钥获取失败,请检查配置文件");
        }
    }

    public static String getClientId() throws Exception {
        try {
            return CountConfig.getProperties(AttrManager.TENCENT_APPID).toString();
        } catch (Exception e) {
            throw new Exception("腾讯Appid获取失败,请检查配置文件");
        }
    }

    public static String getRedirectUri() throws Exception {
        try {
            return CountConfig.getProperties(AttrManager.TENCENT_REDIRECTURI).toString();
        } catch (Exception e) {
            throw new Exception("腾讯回调地址获取失败,请检查配置文件");
        }
    }
}
