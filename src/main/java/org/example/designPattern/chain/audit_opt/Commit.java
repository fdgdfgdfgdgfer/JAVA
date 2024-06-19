package org.example.designPattern.chain.audit_opt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.designPattern.chain.AuditChain;
import org.example.designPattern.chain.audit_service.AuditServiceImpl;
import org.example.designPattern.chain.model.ChainUser;

/**
 * @Author jfz
 * @Date 2024/3/5 14:52
 * @PackageName:org.example.designPattern.chain.audit_opt
 * @ClassName: Commit
 */

public class Commit extends AuditChain {
    public Commit(String id, String value, String userType) {
        super(id, value, userType);
    }

    @Override
    public ChainUser doAudit(String uid) {
        ChainUser chainUser = Chain.CHAIN_USER.get("1");
        ChainUser auditStatus = new AuditServiceImpl().getAuditStatus(chainUser.getUid());
        if ("1".equals(auditStatus.getUserType())) {
            if (uid != chainUser.getUid()) {
                return super.next.doAudit(uid);
            }
            System.out.println("用户" + auditStatus.getName() + "提交审批");
        }

        return super.next.doAudit(uid);
    }
}
