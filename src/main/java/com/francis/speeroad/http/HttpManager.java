package com.francis.speeroad.http;

import java.security.NoSuchAlgorithmException;

import javax.annotation.PostConstruct;
import javax.net.ssl.SSLContext;

import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.francis.speeroad.conf.HttpConfig;

/**
 * 连接池管理
 *
 * @author hzzhugequn
 * @date 2018/8/4
 * @since JDK 1.8
 */
@Component
public class HttpManager {
    private static Logger logger = LoggerFactory.getLogger(HttpManager.class);

    @Autowired
    private HttpConfig httpConfig;

    PoolingHttpClientConnectionManager connectionManager = null;

    @PostConstruct
    public void init() {
        LayeredConnectionSocketFactory socketFactory = null;

        try {
            socketFactory = new SSLConnectionSocketFactory(SSLContext.getDefault());
        } catch (NoSuchAlgorithmException e) {
            logger.error("[init] init SSLConnectionSocketFactory fail.");
        }
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                                                                          .register("https", socketFactory)
                                                                          .register("http", new PlainConnectionSocketFactory())
                                                                          .build();
        connectionManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        connectionManager.setMaxTotal(httpConfig.getMaxConnection());
        connectionManager.setDefaultMaxPerRoute(httpConfig.getDefaultMaxConnection());
        logger.info("[init] http connection inti suc. maxTotal:{}, defaultMaxTotal:{}",
                httpConfig.getMaxConnection(), httpConfig.getDefaultMaxConnection());
    }

    public CloseableHttpClient getHttpClient() {
        return HttpClients.custom().setConnectionManager(connectionManager).build();
    }
}
