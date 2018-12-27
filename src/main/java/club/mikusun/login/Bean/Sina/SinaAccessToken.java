package club.mikusun.login.Bean.Sina;

import lombok.Data;

/**
 * @Author :yzw.
 * @Date :Created in 23:56 2018/12/26
 * @Description:
 * @Version:
 */
@Data
public class SinaAccessToken {
    private String access_token;
    private String remind_in;
    private String expires_in;
    private String uid;
}
