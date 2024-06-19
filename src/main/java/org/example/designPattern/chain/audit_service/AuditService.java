package org.example.designPattern.chain.audit_service;

import org.example.designPattern.chain.model.ChainUser;

/**
 * @Author jfz
 * @Date 2024/3/4 9:26
 * @PackageName:org.example.designPattern.chain.audit
 * @ClassName: AuditService
 */
public interface AuditService {

    void audit(String uid,ChainUser chainUser);

    ChainUser getAuditStatus(String uid);

}
