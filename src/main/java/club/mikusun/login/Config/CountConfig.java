package club.mikusun.login.Config;

import lombok.extern.java.Log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 * @Author :yzw.
 * @Date :Created in 17:19 2018/12/24
 * @Description: 公共配置类
 * @Version: 1.0
 */
@Log
public class CountConfig {
    private static String configFilePath = "";
    private final static Properties properties = new Properties();
    ;
    public static CountConfig config;
    public static String classPath;
    private static Integer index = new Integer(0);
    private static  Field modifiersField;

    private static boolean editKeyFlag;

    static {
        synchronized (CountConfig.class) {
            classPath = ClassLoader.getSystemResource("").toString().replace("file:", "");
            config = new CountConfig(classPath + "application.properties");
        }
        try {
            modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    private CountConfig(String path) {
        try {
            CountConfig.configFilePath = path;
            FileInputStream fileInputStream = new FileInputStream(path);
            CountConfig.properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public final static Object getProperties(String key_) {
        return CountConfig.properties.get(key_);
    }

    public final static CountConfig build(String path) {

        if (config == null) {
            synchronized (CountConfig.class) {
                if (config == null) {

                    if (path.startsWith("classpath:")) {
                        path = classPath + path.replace("classpath:", "");
                    }
                    config = new CountConfig(path);
                    config.openReset(false);
                }
            }
        }
        return config;
    }

    public final synchronized AttrManager openReset(boolean flag) {
        index++;
        if (index > 2) {
            log.warning("打开重设失败");
            return AttrManager.attrManager;
        }
        editKeyFlag = flag;
        return AttrManager.attrManager;
    }



}
