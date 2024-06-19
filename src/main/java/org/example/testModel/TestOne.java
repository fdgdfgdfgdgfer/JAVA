//package org.example.testModel;
//
//import com.google.common.collect.Lists;
//import lombok.Data;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.config.RequestConfig;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.util.EntityUtils;
//import org.example.utils.HttpClientUtils;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.CompletableFuture;
//import java.util.concurrent.LinkedBlockingQueue;
//import java.util.concurrent.ThreadPoolExecutor;
//import java.util.concurrent.TimeUnit;
//import java.util.concurrent.atomic.AtomicInteger;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//
///**
// * @Author jfz
// * @Date 2024/2/19 13:55
// * @PackageName:org.example.testModel
// * @ClassName: TestOne
// */
//@Data
//public class TestOne {
//    static AtomicInteger a = new AtomicInteger(0);
//    static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(20, 30, 50
//            , TimeUnit.SECONDS, new LinkedBlockingQueue<>(2000),(r, e) -> e.execute(r));
//
//    public static void main(String[] args) {
//        ArrayList<Integer> strings = new ArrayList<>();
//        for (int i = 0; i < 2000; i++) {
//            strings.add(i);
//        }
//        int group = strings.size() / 2000+1;
//        List<List<Integer>> partition = Lists.partition(strings, group);
//        List<CompletableFuture<List<String>>> futures = partition.stream()
//                .map(this::cutAsync).collect(Collectors.toList());
//        //等待获取openid异步任务结束
//        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
//    }
//
//
//    private static void tast2() {
//        CloseableHttpClient httpClient = HttpClientUtils.getHttpClient();
//        System.out.println(httpClient);
//        HttpGet httpGet = new HttpGet("http://localhost:8011/sentinel/query");//HTTP Get请求(POST雷同)
//        RequestConfig requestConfig = RequestConfig.custom()
//                .setSocketTimeout(5000)
//                .setConnectTimeout(5000)
//                .build();
//        try {
//            httpGet.setConfig(requestConfig);
//            HttpResponse execute = httpClient.execute(httpGet);
//            String result = EntityUtils.toString(execute.getEntity(), "UTF-8");// 返回json格式：
//            System.out.println("结果：=================================" + result);
//            System.out.println("请求次数========================================" + a.incrementAndGet());
//        } catch (Exception e) {
//            System.out.println("=====异常!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//        }
//
//    }
//
//}
