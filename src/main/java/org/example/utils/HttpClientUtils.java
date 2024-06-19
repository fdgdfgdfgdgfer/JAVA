package org.example.utils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.DnsResolver;
import org.apache.http.conn.HttpConnectionFactory;
import org.apache.http.conn.ManagedHttpClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultHttpResponseParserFactory;
import org.apache.http.impl.conn.ManagedHttpClientConnectionFactory;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.impl.conn.SystemDefaultDnsResolver;
import org.apache.http.impl.io.DefaultHttpRequestWriterFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * HttpClient工具类
 * @author ZH_FTP
 *
 */
public class HttpClientUtils {
	private static Logger log = LoggerFactory.getLogger(HttpClientUtils.class); // 日志记录
	
	private static PoolingHttpClientConnectionManager manager = null;
	private static CloseableHttpClient httpClient = null;
	    
	public static synchronized CloseableHttpClient getHttpClient() {
        if (httpClient == null) {
        	log.info("---------------------------------------------------------创建连接");
        	 /*设置连接池*/
        	configHttpClientConnectionManager();

            /*创建HttpClient*/
            httpClient = InitCloseableHttpClient();

            /*JVM 停止或重启时，关闭连接池释放掉连接(跟数据库连接池类似)*/
            Runtime.getRuntime().addShutdownHook(new Thread() {
                @Override
                public void run() {
                    try {
                        if (httpClient != null) {
                            httpClient.close();
                        }
                    } catch (IOException e) {
                        log.error("error when close httpClient:{}", e);
                    }
                }
            });
        }
        return httpClient;
    }
	
	/**
	 * 配置连接池
	 */
	private static void configHttpClientConnectionManager() {
		 //注册访问协议相关的Socket工厂
        Registry<ConnectionSocketFactory> socketFactoryRegistry = getRegistry();
        //DNS 解析器
        DnsResolver dnsResolver = SystemDefaultDnsResolver.INSTANCE;
        //创建池化连接管理器
        manager = new PoolingHttpClientConnectionManager(socketFactoryRegistry, getHttpConnectionFactory(), dnsResolver);
        //默认为Socket配置
        SocketConfig defaultSocketConfig = SocketConfig.custom().setTcpNoDelay(true).build();
        manager.setDefaultSocketConfig(defaultSocketConfig);
        //设置整个连接池的最大连接数
        manager.setMaxTotal(300);
        //每个路由的默认最大连接，每个路由实际最大连接数由DefaultMaxPerRoute控制，而MaxTotal是整个池子的最大数
        //设置过小无法支持大并发(ConnectionPoolTimeoutException) Timeout waiting for connection from pool
        //每个路由的最大连接数
        manager.setDefaultMaxPerRoute(200);
        //在从连接池获取连接时，连接不活跃多长时间后需要进行一次验证，默认为2s
        manager.setValidateAfterInactivity(5 * 1000);
	}
	
	/**
	 * HttpConnection 工厂:配置写请求/解析响应处理器
	 * @return
	 */
	private static HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> getHttpConnectionFactory(){
		return new ManagedHttpClientConnectionFactory(DefaultHttpRequestWriterFactory.INSTANCE,
				DefaultHttpResponseParserFactory.INSTANCE);
	}
	
	/**
	 * 创建HttpClient
	 * @return
	 */
	private static CloseableHttpClient InitCloseableHttpClient() {
		return HttpClients.custom()
        .setConnectionManager(manager)
        //连接池不是共享模式
        .setConnectionManagerShared(false)
        //定期回收空闲连接
        .evictIdleConnections(60, TimeUnit.SECONDS)
        // 定期回收过期连接
        .evictExpiredConnections()
        //连接存活时间，如果不设置，则根据长连接信息决定
        .setConnectionTimeToLive(60, TimeUnit.SECONDS)
        //设置默认请求配置
        .setDefaultRequestConfig(getRequestConfig())
        //连接重用策略，即是否能keepAlive
        .setConnectionReuseStrategy(DefaultConnectionReuseStrategy.INSTANCE)
        //长连接配置，即获取长连接生产多长时间
        .setKeepAliveStrategy(DefaultConnectionKeepAliveStrategy.INSTANCE)
        //设置重试次数，默认是3次
        .setRetryHandler(new DefaultHttpRequestRetryHandler(3, false))
        .build();
	}
	
	/**
	 * 默认请求配置
	 * @return
	 */
	private static RequestConfig getRequestConfig() {
		return RequestConfig.custom()
                //设置连接超时时间，2s
                .setConnectTimeout(2 * 1000)
                //设置等待数据超时时间，5s
                .setSocketTimeout(5 * 1000)
                //设置从连接池获取连接的等待超时时间
                .setConnectionRequestTimeout(2000)
                .build();
	}
	/**
	 * 注册访问协议相关的Socket工厂
	 * @return
	 */
	private static Registry<ConnectionSocketFactory> getRegistry(){
		return RegistryBuilder.<ConnectionSocketFactory>create().register("http", PlainConnectionSocketFactory.INSTANCE).register("https", SSLConnectionSocketFactory.getSystemSocketFactory()).build();
	}
}
