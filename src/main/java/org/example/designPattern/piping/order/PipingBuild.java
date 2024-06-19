package org.example.designPattern.piping.order;



/**
 * @Author jfz
 * @Date 2024/6/7 15:08
 * @PackageName:org.example.designPattern.piping.order
 * @ClassName: PipingDuilding
 */

public class PipingBuild implements BuildingPiping {
    private PipingNode head;
    private PipingNode tail;

    public PipingBuild() {
        this.head = new PipingNode();
        tail = head;
    }

    @Override
    public void buildingPiping(ProcessAction op) {
        //首节点指针
        try {
            PipingNode next = tail;

            PipingNode pipingNode = new PipingNode();
            pipingNode.setProcessAction(op);

            next.setNext(pipingNode);
            tail = pipingNode;
        } catch (Exception e) {
            System.out.println("获取具体管道内容");
        }


    }

    @Override
    public void start() {
        head.getNext().exec();
    }
}
