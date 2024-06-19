package org.example.designPattern.chain.audit_opt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.designPattern.chain.AuditChain;
import org.example.designPattern.chain.audit_service.AuditServiceImpl;
import org.example.designPattern.chain.model.ChainUser;

import java.util.Map;

/**
 * @Author jfz
 * @Date 2024/3/4 9:46
 * @PackageName:org.example.designPattern.chain.audit_opt
 * @ClassName: IntermediateAudit
 */

public class IntermediateAudit extends AuditChain {
    public IntermediateAudit(String id, String value, String userType) {
        super(id, value, userType);
    }

    @Override
    public ChainUser doAudit(String uid) {
        ChainUser chainUser = Chain.CHAIN_USER.get("3");
        ChainUser auditStatus = new AuditServiceImpl().getAuditStatus(chainUser.getUid());
        ChainUser user = AuditServiceImpl.req.get("001");
        if (null == auditStatus) {
            System.out.println("中审：审批人" + chainUser.getName() + "-待审批,申请人:" + user.getName());
            return null;
        }
        if ("3".equals(auditStatus.getUserType())) {
            if (uid != chainUser.getUid()) {
                return super.next.doAudit(uid);
            }
            System.out.println("中审：审批人" + chainUser.getName() + "-审批通过");
        }
        return super.next.doAudit(uid);
    }
}
