package club.mikusun.login.Event.Server;

import javax.servlet.ServletRequest;

/**
 * @Author :yzw.
 * @Date :Created in 14:39 2018/12/26
 * @Description:
 * @Version:
 */
public interface EventServer {
    <T>T login(ServletRequest request)throws Exception;
    <T>T login(ServletRequest request,Class<T> tClass)throws Exception;
    <T>T getAccessToken(ServletRequest request)throws Exception;
    <T>T getAccessToken(ServletRequest request,Class<T> tClass) throws Exception;

}
