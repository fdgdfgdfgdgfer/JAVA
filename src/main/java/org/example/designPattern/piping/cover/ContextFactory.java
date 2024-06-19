package org.example.designPattern.piping.cover;

import lombok.Data;
import org.example.designPattern.factory.ReqContext;
import org.example.designPattern.piping.order.PipingBuild;

/**
 * @Author jfz
 * @Date 2024/6/7 9:47
 * @PackageName:org.example.designPattern.factory
 * @ClassName: ContextFoctory
 */
@Data
public abstract class ContextFactory implements Build {


    @Override
    public PipingBuild build() {
        ReqContext reqContext = new ReqContext();
        reqContext.setA("a");
        reqContext.setB("b");
        reqContext.setC("b");
        reqContext.setD("b");
        Context context = new Context();
        //参数转换
        CoverHand coverHand = new CoverHand();
        Cover cover = new Cover();
        coverHand.setCoverInput(cover);
        cover.copy(reqContext, context);
        System.out.println(context);
        //剩余步骤
        PipingBuild piping = createPiping();
        doBuild(piping);

        return piping;
    }

    abstract void doBuild(PipingBuild pipingBuild);


   public PipingBuild createPiping() {
        return new PipingBuild();
    } ;
}
