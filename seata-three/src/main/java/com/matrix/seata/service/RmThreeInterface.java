package com.matrix.seata.service;

import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

/**
 * @author yihaosun
 * @date 2022/6/25 17:57
 */
@LocalTCC
public interface RmThreeInterface {
    @TwoPhaseBusinessAction(name = "rm1TccAction" , commitMethod = "rm1Commit" ,rollbackMethod = "rm1Rollback")
    public String rm3(BusinessActionContext businessActionContext);

    public boolean rm1Commit(BusinessActionContext businessActionContext);

    public boolean rm1Rollback(BusinessActionContext businessActionContext);
}
