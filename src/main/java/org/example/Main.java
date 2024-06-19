package org.example;

import com.github.kevinsawicki.http.HttpRequest;
import com.google.common.collect.Lists;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author jfz
 * @Date ${DATE} ${TIME}
 * @PackageName:org.example
 * @ClassName: ${NAME}
 */
public class Main {
    static AtomicInteger i = new AtomicInteger(0);
    static ThreadPoolExecutor executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), Runtime.getRuntime().availableProcessors() * 2
            , 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(2000)
    );

    private static final ScheduledExecutorService SCHEDULED_FUTURE = new ScheduledThreadPoolExecutor(
            1,
            r -> {
                Thread t = new Thread(r);
                t.setDaemon(true);
                t.setName("Timeout");
                return t;
            },
            (r, e) -> e.execute(r)
    );

    public static void main(String[] args) throws IOException {
        PathMatcher pathMatcher = new AntPathMatcher();
        String appletPath = "/pms/api/**/list/**";
        if(pathMatcher.match(appletPath,"/pms/api/daily/list/aa")){
            System.out.println("yes");
        }
    }
    private static CompletableFuture<String> async(List<String> strings) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() ->
                ko(strings), executor
        ).thenApply(num -> {
            System.out.println(num);
            return "1";
        });
        return future;

    }

    public static ArrayList<String> ko(List<String> d) {
        System.out.println(Thread.currentThread().getName() + "----" + i.incrementAndGet());
        ArrayList<String> strings = new ArrayList<>();
        for (String a : d) {
            strings.add(HttpRequest.get("http://localhost:8011/sentinel/query").body());
        }
        return strings;
    }
}