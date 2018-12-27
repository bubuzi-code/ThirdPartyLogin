package club.mikusun.login.Config;

/**
 * @Author :yzw.
 * @Date :Created in 9:42 2018/12/27
 * @Description:
 * @Version:
 */
public class SinaLoginConfig {

    public static String getSecret() throws Exception {
        try {
            return CountConfig.getProperties(AttrManager.SINA_SECRET).toString();
        } catch (Exception e) {
            throw new Exception("微博密钥获取失败,请检查配置文件");
        }
    }

    public static String getClientId() throws Exception {
        try {
            return CountConfig.getProperties(AttrManager.SINA_APPID).toString();
        } catch (Exception e) {
            throw new Exception("微博Appid获取失败,请检查配置文件");
        }
    }

    public static String getRedirectUri() throws Exception {
        try {
            return CountConfig.getProperties(AttrManager.SINA_REDIRECTURI).toString();
        } catch (Exception e) {
            throw new Exception("微博回调地址获取失败,请检查配置文件");
        }
    }

}
