package org.example.testModel;


import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.*;
import java.util.stream.Collectors;


/**
 * @Author jfz
 * @Date 2024/5/29 9:45
 * @PackageName:org.example.testModel
 * @ClassName: DdzImpl
 */

public class DdzImpl {
    public static List<String> p1 = new ArrayList<>();
    public static List<String> p2 = new ArrayList<>();
    public static List<String> p3 = new ArrayList<>();
    public static List<String> all;
    public static int dz = 0;
    public static int max = 0;

    public void begin(List<String> p) {
        Scanner scanner = new Scanner(System.in);
        //发牌
        all = new ArrayList(p);
        System.out.println("发牌Y/N?");
        while (true) {
            String fa = scanner.next();
            if (fa.equals("Y")) {
                System.out.println("=====================开始发牌====================");
                break;
            }
        }
        //未看牌
        CardBaseImpl base = new CardBaseImpl();
        base.alls = all;
        base.showDown = false;
        base.show = true;
        System.out.println("看牌Y/N");
        while (true) {
            String fa = scanner.next();
            if (fa.equals("Y")) {
                System.out.println("=====================开始看牌====================");
                break;
            }
        }
        //随机不重复17张
        List<String> allSet = new ArrayList<>();
        for (int i = 0; i < 17; i++) {
            Random random = new Random();
            int index = random.nextInt(all.size());
            while (true) {
                if (allSet.contains(all.get(index))) {
                    index = random.nextInt(all.size());
                } else {
                    break;
                }
            }
            allSet.add(all.get(index));
            p1.add(all.get(index));
        }

        //去除第一组牌
        all.removeAll(p1);

        //随机不重复17张
        for (int i = 0; i < 17; i++) {
            Random random = new Random();
            int index = random.nextInt(all.size());
            while (true) {
                if (allSet.contains(all.get(index))) {
                    index = random.nextInt(all.size());
                } else {
                    break;
                }
            }
            allSet.add(all.get(index));
            p2.add(all.get(index));

        }

        //去除第二组
        all.removeAll(p2);

        //随机不重复17张
        for (int i = 0; i < 17; i++) {
            Random random = new Random();
            int index = random.nextInt(all.size());
            while (true) {
                if (allSet.contains(all.get(index))) {
                    index = random.nextInt(all.size());
                } else {
                    break;
                }
            }
            p3.add(all.get(index));
            allSet.add(all.get(index));
        }
        //去除第三组
        all.removeAll(p3);

        new NotOrder(base).showCard(p1, p2, p3);
        System.out.println("                    玩家");
    }

    public void figDz() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        //抢地主

        System.out.println("================叫分==============");
        Thread.sleep(5000L);
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            if (i != 0) {
                int num = random.nextInt(3);
                if (num == 2) {
                    if (i == 1) {
                        dz = 1;
                        System.out.println("电脑一抢到地主");
                        break;
                    }
                    if (i == 2) {
                        dz = 2;
                        System.out.println("电脑二抢到地主");
                        break;
                    }
                }
            } else {
                while (true) {
                    System.out.println("一分 二分 三分 选择分数");
                    Integer next1 = scanner.nextInt();
                    if (next1.equals(3)) {
                        System.out.println("您抢到地主");
                        break;
                    } else if (next1.equals(1)) {
                        System.out.println("一分");
                        break;
                    } else if (next1.equals(2)) {
                        System.out.println("二分");
                        break;
                    } else {
                        System.out.println("输入有误...");
                    }
                }
                break;
            }
        }
        CardBaseImpl cardBase = new CardBaseImpl();
        cardBase.show = false;
        cardBase.alls = all;
        cardBase.showDown = true;
        new NotOrder(cardBase).showCard(p1, p2, p3);
        System.out.println("================上牌===================");
        Thread.sleep(5000L);

        //上牌
        if (dz == 0) {
            p1.addAll(all);
            cardBase.showDown = false;
            cardBase.show = false;
            cardBase.alls = all;
            new NotOrder(cardBase).showCard(p1, p2, p3);
        } else if (dz == 1) {
            cardBase.showDown = false;
            cardBase.show = false;
            cardBase.alls = all;
            p2.addAll(all);
            new NotOrder(new CardBaseImpl()).showCard(p1, p2, p3);
        } else if (dz == 2) {
            cardBase.showDown = false;
            cardBase.show = false;
            cardBase.alls = all;
            p3.addAll(all);
            new NotOrder(new CardBaseImpl()).showCard(p1, p2, p3);
        }

        //排序
        System.out.println("整理牌...");

        Thread.sleep(5000l);
        //快速排序
        DdzUtils.quck(p1, 0, p1.size() - 1);
        if (dz == 0) {
            p1.addAll(all);
            new OrderShow(new CardBaseImpl()).showCard(p1, p2, p3);

        } else if (dz == 1) {
            p2.addAll(all);
            new OrderShow(new CardBaseImpl()).showCard(p1, p2, p3);

        } else if (dz == 2) {
            p3.addAll(all);
            new OrderShow(new CardBaseImpl()).showCard(p1, p2, p3);
        }
    }

    public static OutModel determine(List<String> out) {
        //1:单张 ， 2:对子 , 3:三不带 , 4:三带一 , 5:4炸 , 6:王炸, 7:顺子，8:连对
        //单张
        OutModel outModel = new OutModel();
        int size = out.size();
        if (size == 1) {
            outModel.setOut(1);
            outModel.setOutCard(out);
        }
        if (size == 2) {
            String one = out.get(0);
            String two = out.get(1);
            if (one.equals(two)) {
                // 2:对子
                outModel.setOut(2);
                outModel.setOutCard(out);
            } else if (out.contains("w") && out.contains("W")) {
                //, 6:王炸
                outModel.setOut(6);
                outModel.setOutCard(out);
            } else {
                outModel.setOut(9);
                outModel.setOutCard(out);
            }
        }
        //1:单张 ， 2:对子 , 3:三不带 , 4:三带一 , 5:4炸 , 6:王炸, 7:顺子，8:连对
        if (size == 3) {
            String one = out.get(0);
            String two = out.get(1);
            String three = out.get(2);
            if (one.equals(two) && two.equals(three)) {
                //3:三不带
                outModel.setOut(3);
                outModel.setOutCard(out);
            } else {
                outModel.setOut(9);
                outModel.setOutCard(out);
            }
        }
        if (size == 4) {
            String one = out.get(0);
            String two = out.get(1);
            String three = out.get(2);
            String four = out.get(3);
            if (one.equals(two) && two.equals(three) && three.equals(four)) {
                // 4炸
                outModel.setOut(5);
                outModel.setOutCard(out);
                return outModel;
            }
            Set<String> set = new HashSet<>();
            int count = 1;
            for (String a : out) {
                if (!set.add(a)) {
                    count++;
                }
            }
            if (count == 3) {
                //三带一
                outModel.setOut(4);
                outModel.setOutCard(out);
                return outModel;
            }

        }
        if (size > 4) {
            List<Integer> result = new ArrayList<>();
            for (String a : out) {
                result.add(DdzUtils.revert(a));
            }
            boolean loop = false;
            for (int i = 0; i < result.size() - 1; i++) {
                if (!(result.get(i + 1) - result.get(i) == 1)) {
                    loop = true;
                }
            }
            if (!loop) {
                //顺子
                outModel.setOut(7);
                outModel.setOutCard(out);
                return outModel;
            }


            Map<Integer, Integer> card = new HashMap();
            Set<Integer> set = new HashSet<>();
            //对相同字符分组
            for (Integer ai : result) {
                if (set.add(ai)) {
                    card.put(ai, 1);
                } else {
                    Integer integer = card.get(ai);
                    card.put(ai, integer + 1);
                }
            }
            Collection<Integer> values = card.values();
            List<Integer> list = new ArrayList<>(values);
            int threeCount = 0;
            int single = 0;
            int twoCount = 0;
            for (int i = 0; i < list.size(); i++) {
                //飞机
                if (list.get(i) == 3) {
                    threeCount++;
                }
                if (list.get(i) == 2) {
                    twoCount++;
                }
                if (list.get(i) == 1) {
                    single++;
                }
            }
            //1:单张 ， 2:对子 , 3:三不带 , 4:三带一 , 5:4炸 , 6:王炸, 7:顺子，8:连对 9:出牌有误 10:飞机
            //飞机
            if (threeCount > 1 && threeCount == single) {
                //飞机
                outModel.setOut(10);
                outModel.setOutCard(out);
                return outModel;
            } else if (twoCount > 2 && single == 0 && threeCount == 0) {
                Set<Integer> strings = card.keySet();
                List<Integer> lists = new ArrayList<>(strings);
                for (int i = 0; i < lists.size() - 1; i++) {
                    if (!(lists.get(i + 1) - lists.get(i) == 1)) {
                        outModel.setOut(9);
                        outModel.setOutCard(out);
                        return outModel;
                    }
                }
                //连对
                outModel.setOut(8);
                outModel.setOutCard(out);
                return outModel;

            } else {
                outModel.setOut(9);
                outModel.setOutCard(out);
                return outModel;
            }
        }
        return outModel;
    }


    public void out() throws InterruptedException {
        CardBaseImpl cardBase = new CardBaseImpl();
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        Thread.sleep(5000l);
        while (true) {

            while (true) {
                if (dz == 0 || max == 0) {
                    dz = -1;
                    //出牌
                    System.out.println("=====================出牌按Y结束N不要=================");
                    List<String> user = new ArrayList<>();
                    while (true) {
                        String next = scanner.next();
                        if (next.equals("Y")) {
                            break;
                        }
                        user.add(next);
                    }
                    //玩家
                    OutModel outModel = user(user);
                    computerOne(outModel,null);

                }
                if (dz == 1 || max == 1) {
                    dz = -1;

                }
                if (dz == 2 || max == 2) {
                    dz = -1;

                }


            }

        }
    }

    public Boolean computerOne(OutModel outModel, List<String> p2) {
        Integer out = outModel.getOut();
        List<String> outCard = outModel.getOutCard();
        //TODO
        return false;
    }

    public Boolean computerTwo(String code) {
        //转化大小


        //根据手牌对比,出牌,可用管return true ， 不可管 return false


        return false;
    }

    public OutModel user(List<String> code) {

        //根据手牌对比,出牌,可用管return true ， 不可管 return false
        return DdzImpl.determine(code);
    }

}

