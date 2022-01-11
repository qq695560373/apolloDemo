# apolloDemo
apollo项目demo

//此为apollo工具类，demo暂未用到
import com.ctrip.framework.apollo.Config;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 获取apollo配置工具类
 */
@Component
@Slf4j
public class ApolloConfigUtils {

    private final Config apolloConfig;

    public ApolloConfigUtils(Config apolloConfig) {
        this.apolloConfig = apolloConfig;
    }

    /**
     * 静态方法初始化
     */
    @PostConstruct
    public void init() {
        apolloStaticConfig = apolloConfig;
    }


    private static Config apolloStaticConfig = null;

    /**
     * 获取一般key value 配置
     * @param key 键
     * @return 对应值
     */
    public static String getConfig(String key) {
        return apolloStaticConfig.getProperty(key, "");
    }

    /**
     * 获取一般key value 配置
     * @param key 键
     * @param d 默认值
     * @return 对应值 或 默认值
     */
    public static String getConfigDefault(String key, String d) {
        return apolloStaticConfig.getProperty(key, d);
    }


    /**
     * 获取完整的url
     *
     * @param preFixKey url前缀 key：baidu ——>  value: http://baidu.com
     * @param suffix url后缀 : getUserInfo
     * @return
     */
    public static String getCompleteUrl(String preFixKey, String suffix) {
        if (StringUtil.isEmpty(preFixKey) || StringUtil.isEmpty(suffix))
            return null;
        String preFix = getConfig(preFixKey);
        if (StringUtil.isEmpty(preFix)) {
            log.info("getCompleteUrl-------preKey：{} 为空", preFix);
            return null;
        }
        return preFix + suffix;
    }
}
