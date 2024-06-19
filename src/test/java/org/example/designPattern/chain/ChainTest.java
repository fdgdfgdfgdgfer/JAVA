package org.example.designPattern.chain;

import static org.junit.Assert.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.designPattern.chain.audit_opt.Commit;
import org.example.designPattern.chain.audit_opt.IntermediateAudit;
import org.example.designPattern.chain.audit_opt.PrimaryAudit;
import org.example.designPattern.chain.audit_opt.UltimateAudit;
import org.example.designPattern.chain.audit_service.AuditServiceImpl;
import org.example.designPattern.chain.model.ChainUser;
import org.junit.Test;

/**
 * @Author jfz
 * @Date 2024/3/5 15:28
 * @PackageName:org.example.designPattern.chain
 * @ClassName: TestTest
 */
public class ChainTest {

    @Test
    public void chainTest() {
        AuditChain auditChain = new Commit("001", "张三", "1")
                .addNext(new PrimaryAudit("002", "李四", "2")
                        .addNext(new IntermediateAudit("003", "王五", "3")
                                .addNext(new UltimateAudit("004", "赵六", "4")))
                );


        //提交审批
        new AuditServiceImpl().audit("001", new ChainUser("001", "张三", "1"));
        auditChain.doAudit("001");
        System.out.println("=================================");
        //初级审批
        new AuditServiceImpl().audit("002", new ChainUser("002", "李四", "2"));
        auditChain.doAudit("002");
        System.out.println("=================================");
        //中级审批
        new AuditServiceImpl().audit("003", new ChainUser("003", "王五", "3"));
        auditChain.doAudit("003");
        //终极审批
        System.out.println("=================================");
        new AuditServiceImpl().audit("004", new ChainUser("004", "赵六", "4"));
        auditChain.doAudit("004");
    }
}