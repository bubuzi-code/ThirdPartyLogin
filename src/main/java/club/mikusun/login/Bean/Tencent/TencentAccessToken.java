package club.mikusun.login.Bean.Tencent;

import lombok.Data;

/**
 * @Author :yzw.
 * @Date :Created in 16:21 2018/12/27
 * @Description:
 * @Version:
 */
@Data
public class TencentAccessToken {
    private String access_token;
    private String expires_in;
    private String refresh_token;
}
