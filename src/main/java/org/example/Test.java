//package org.example;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
///**
// * @Author jfz
// * @Date 2024/3/15 9:29
// * @PackageName:org.example
// * @ClassName: Test
// */
//public class Test implements Runnable {
//    //1首先创建个线程池 ,默认核心为10
//    static ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(10);
//
//
//    //2 在写一个启动项目自动启动的注解
//    @PostConstruct
//    public void initHttpApiDetectSuffix() {
//
//
//        logger.info("创建线程池");
//        BaseEncryptionAndDecryption instance = GetEncryptionAndDecryptionBean.getInstance();
//        List<HttpApiDetectManageDO> list = httpApiDetectManageMapper.selectAllByParam(null, null, null, null, 1);
//        list.stream().forEach(bean -> map.put(bean.getApiName(), bean.getStatus()));
//        for (HttpApiDetectManageDO bean : list) {
//            //调用线程的方法
//            httpApiDetectStart(threadPool, count, bean, map, instance);
//            count++;
//        }
//        logger.info("现有探测线程数为:{}", map.size());
//
//
//    }
//
//
////3然后再创建一个方法
//
//    public void httpApiDetectStart1(ScheduledExecutorService threadPool, int i, HttpApiDetectManageDO bean, Map<String, Integer> map, BaseEncryptionAndDecryption instance) {
//        ScheduledFuture<?> scheduledFuture = threadPool.scheduleAtFixedRate(new Runnable() {
//                                                                                @Override
//                                                                                public void run() {
//                                                                                    if (map.get(bean.getApiName()) == 0) {
//
//                                                                                        logger.info("http探测线程停止,apiName={}", bean.getApiName());
//                                                                                        Thread.currentThread().stop();
//                                                                                    }
//                                                                                    String url;
//                                                                                    logger.info("执行第" + i + "个接口探测scheduleAtFixedRate 方法：" + LocalDateTime.now());
//                                                                                    url = bean.getProtocol() + bean.getApiIp() + ":" + bean.getApiPort() + bean.getDetectAddr();
//                                                                                    String detectParams = bean.getDetectParams();
//                                                                                    Map params = null;
//                                                                                    if (StringUtils.isNotBlank(detectParams)) {
//                                                                                        params = JSON.parseObject(detectParams);
//                                                                                        logger.info("平台探测参数-->{}", params);
//                                                                                    }
//                                                                                    ApiCheckResult r = null;
//                                                                                    try {
//                                                                                        r = HttpJdk.doCall(url, params, "get", -1);
//                                                                                        logger.info("平台探测结果-->{}", r);
//                                                                                        insertDB(r, bean);
//                                                                                    } catch (Exception e) {
//                                                                                        e.printStackTrace();
//                                                                                        logger.info(e.getMessage());
//                                                                                    }
//
//
//                                                                                }
//                                                                            },
//                0, // 0s 后开始执行定时任务
//                bean.getDetectCycle(), // 定时任务的执行间隔为
//                TimeUnit.MINUTES);// 描述上面两个参数的时间单位
//
//    }
//
//}
