package club.mikusun.login.Util;


import club.mikusun.login.Bean.Error;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.NonNull;
import lombok.extern.java.Log;

import java.util.Map;

/**
 * @Author :yzw.
 * @Date :Created in 22:10 2018/12/24
 * @Description:
 * @Version:
 */
@Log
public class LoginHttpUtil{

    private static <T> T parseJsonToBeanByT(@NonNull String jsonStr , @NonNull Class<T> t){

        try {
            if (t == String.class) {
                return (T) jsonStr;
            }
            JSONObject jsonObj = JSONUtil.parseObj(jsonStr);
            T bean = JSONUtil.toBean(jsonObj, t);
            return (T) bean;
        }catch (Exception e){
            log.warning("json解析出现问题");
            e.printStackTrace();
            return null;
        }
    }

    public static <T> T sendGet(@NonNull String url, Map<String, String> map, @NonNull Class<T> tClass,int timeout){
        try {

            final StringBuffer urlBuf = new StringBuffer(url).append('?');
            if (map != null) {
                map.forEach((k, v) -> {
                    urlBuf.append(k).append('=').append(HttpUtil.encode(v, "utf-8")).append('&');
                });
            }
            String result = HttpUtil.get(urlBuf.toString(), timeout);
            if (result.indexOf("error")!=-1) throw new Exception(parseJsonToBeanByT(result, Error.class).toString());
            if (tClass == String.class) return (T) result;
            log.info("A request is being sent to {" + urlBuf + "}");
            return parseJsonToBeanByT(result,tClass);
        } catch (Exception e) {
//            Base.printErr(e);
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T sendPost(@NonNull String url, Map<String, Object> map, @NonNull Class<T> tClass,int timeout) {
        try {
            String result = HttpUtil.post(url, map,timeout);
            log.info("A request is being sent to {" + url + "}");
            System.err.println(result);
            if (result.indexOf("error")!=-1) throw new Exception(parseJsonToBeanByT(result, Error.class).toString());
            if (tClass == String.class) return (T) result;
            return parseJsonToBeanByT(result,tClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
