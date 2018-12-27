package club.mikusun.login.Bean.Sina;

import lombok.Data;

/**
 * @Author :yzw.
 * @Date :Created in 23:55 2018/12/26
 * @Description:
 * @Version:
 */
@Data
public class SinaUsersInfo {
    private String idstr;               //字符串型的用户UID
    private String screen_name;         //用户昵称
    private Integer province;           //用户所在省级ID
    private Integer city;               //用户所在城市ID
    private String profile_image_url;   //用户头像地址（中图），50×50像素
    private String gender;              //性别，m：男、f：女、n：未知
    private String avatar_large;        //用户头像地址（大图），180×180像素
    private String location;            //用户所在地
}
