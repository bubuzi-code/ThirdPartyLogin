package club.mikusun.login.Bean;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author :yzw.
 * @Date :Created in 14:20 2018/12/27
 * @Description:
 * @Version:
 */
@Setter
@Getter
public class Error {
    private String request;
    private String error_description;
    private String error_code;
    private String error_uri;

    @Override
    public String toString() {
        return "获取授权失败\n" +
                "请求:'" + request + '\'' + '\n'+
                "错误原因:'" + error_description + '\'' +'\n'+
                "错误代码:'" + error_code + '\'' +'\n'+
                "请求地址:'" + error_uri + '\'';
    }
}
