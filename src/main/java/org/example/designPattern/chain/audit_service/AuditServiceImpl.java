package org.example.designPattern.chain.audit_service;


import org.example.designPattern.chain.model.ChainUser;

import java.util.HashMap;

/**
 * @Author jfz
 * @Date 2024/3/4 9:31
 * @PackageName:org.example.designPattern.chain.audit
 * @ClassName: AuditServiceImpl
 */
public class AuditServiceImpl implements AuditService {
    public static final HashMap<String, ChainUser> req = new HashMap<>();

    @Override
    public void audit(String uid, ChainUser chainUser) {
        req.put(uid, chainUser);
    }

    @Override
    public ChainUser getAuditStatus(String uid) {
        return req.get(uid);
    }

  public   static Boolean getMap(String uid) {
        if (req.keySet().contains(uid)) {
            return false;
        } else {
            return true;
        }
    }
}
