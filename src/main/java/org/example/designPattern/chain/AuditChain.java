package org.example.designPattern.chain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.designPattern.chain.model.ChainUser;

import java.util.HashMap;
import java.util.Map;

import static org.example.designPattern.chain.AuditChain.Chain.CHAIN_USER;

/**
 * @Author jfz
 * @Date 2024/3/4 9:18
 * @PackageName:org.example.designPattern.chain
 * @ClassName: AuditChain
 */
public abstract class AuditChain {

    public AuditChain next;

    public static class Chain {
        public static final Map<String, ChainUser> CHAIN_USER = new HashMap<>();
    }

    public AuditChain(String id, String value, String userType) {
        CHAIN_USER.put(userType, new ChainUser(id, value, userType));
    }

    public AuditChain addNext(AuditChain next) {
        this.next = next;
        return this;
    }

    public AuditChain getNext() {
        return this.next;
    }

    public abstract ChainUser doAudit(String uid);
}
