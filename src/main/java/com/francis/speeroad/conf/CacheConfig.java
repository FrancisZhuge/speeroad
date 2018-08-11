package com.francis.speeroad.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author hzzhugequn
 * @date 2018/8/4
 * @since JDK 1.8
 */
@Configuration
@PropertySource("classpath:properties/cache.properties")
public class CacheConfig {

    @Value("${cache.host}")
    private String host;
    @Value("${cache.port}")
    private int port;
    @Value("${cache.timeout}")
    private int timeout;
    @Value("${cache.max.total}")
    private int total;
    @Value("${cache.max.idle}")
    private int idle;
    @Value("${cache.max.wait.millis}")
    private long waitTime;
    @Value("${cache.test.on.borrow}")
    private boolean testOnBorrow;
    @Value("${cache.test.on.return}")
    private boolean testOnReturn;
    @Value("${cache.password}")
    private String password;

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public int getTimeout() {
        return timeout;
    }

    public int getTotal() {
        return total;
    }

    public int getIdle() {
        return idle;
    }

    public long getWaitTime() {
        return waitTime;
    }

    public boolean isTestOnBorrow() {
        return testOnBorrow;
    }

    public boolean isTestOnReturn() {
        return testOnReturn;
    }

    public String getPassword() {
        return password;
    }
}
