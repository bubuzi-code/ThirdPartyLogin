OAuth2.0错误响应中的错误码定义如下表所示：
---
|错误码(error)|错误编号(error_code)|错误描述(error_description)|
|:----:|:----:|:----:|
|redirect_uri_mismatch|21322|重定向地址不匹配|
|invalid_request	|21323|	请求不合法|
|invalid_client|	21324	|client_id或client_secret参数无效|
|invalid_grant	|21325	|提供的Access Grant是无效的、过期的或已撤销的|
|unauthorized_client|	21326|	客户端没有权限|
|expired_token	|21327	|token过期|
|unsupported_grant_type|	21328	|不支持的 GrantType|
|unsupported_response_type|	21329|	不支持的 ResponseType|
|access_denied|	21330|	用户或授权服务器拒绝授予数据访问权限|
|temporarily_unavailable|	21331	|服务暂时无法访问|

在CountConfig的build方法中指定配置文件路径
---
```java
public class Star{
    public static void main(String[] args){
        CountConfig.build("classpath:application.properties");   
    }
    
    //也可以修改配置属性的name
    public static void main(String[] args) {
        CountConfig.build("").openReset(true)
                .setWxSecret("WxSecret")
                .setSinaRedirectUri("http://...")
                .setWxAppid("...");
    }
}
```
对于网页登录组件的生成
---
```javascript
//微信登录组件
!function (a, b, c) {
    function d(a) {
        var c = "default";
        a.self_redirect === !0 ? c = "true" : a.self_redirect === !1 && (c = "false");
        var d = b.createElement("iframe"),
            e = "https://open.weixin.qq.com/connect/qrconnect?appid=" + a.appid + "&scope=" + a.scope + "&redirect_uri=" + a.redirect_uri + "&state=" + a.state + "&login_type=jssdk&self_redirect=" + c;
        e += a.style ? "&style=" + a.style : "", e += a.href ? "&href=" + a.href : "", d.src = e, d.frameBorder = "0", d.allowTransparency = "true", d.scrolling = "no", d.width = "300px", d.height = "400px";
        var f = b.getElementById(a.id);
        f.innerHTML = "", f.appendChild(d)
    }
    a.WxLogin = d
}(window, document);
/**
 * QQ登录
 * http://localhost:9090/logback/qq.jsp  QQ互联上设置的回调地址
 */
$("#QQ_hover").click(
    function loginQQ(){
        window.open("https://graph.qq.com/oauth2.0/authorize" +
            "?response_type=code" + //该值不变,为code
            "&client_id=" +         //你的应用id
            "&state=register" +     //不变
            "&redirect_uri=");      //你在QQ互联设置的回调地址
    }
)

/**
 * 微博登录
 * http://localhost:9090/logback/weibo.jsp这个就是在微博上设置的回调地址
 */
$("#weibo_hover").click(
    function loginWeibo(){
        window.location.href ="https://api.weibo.com/oauth2/authorize" +
            "?response_type=code" + //该值不变,为code
            "&client_id=" +         //你的应用id
            "&state=register" +     //不变
            "&redirect_uri=";       //你在微博开放平台设置的回调地址
    }
);


/**
 *  微信登录二维码生成 
 *  扫码有个坑，当用户扫码时会回掉一次地址，当用户点击确认登陆会再次访问，所以，应当在第一次回调时存入openid
 */
var obj = new WxLogin({
    id:"login_container",           //装载二维码容器id
    appid: "",                      //微信开放平台的应用id
    scope: "",                      //请求作用域[snsapi_login,snsapi_userinfo],
    redirect_uri:"",                //微信回调地址
    state: "",                      //带回服务器参数,可预防网络攻击
    style: "black",                 //组件样式
    href: ""
});

```

QQ登录的一些事
---
QQ的openid的机制,导致要让多个应用之间的openid进行关联
解决方法:
给connect@qq.com发送邮件,内容格式:

第三方登录,web端返回的openid和手机端返回的openid不一致, 现申请两个appid合并

移动应用:
appid:aabbbcccccc
appkey:aaaaaa

网站应用:
appid:bbbbbbb
appkey:ddddddddd

![Image text](Tencent.png)



