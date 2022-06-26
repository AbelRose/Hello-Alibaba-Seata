package com.matrix.seata.service;

import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

/**
 * @author yihaosun
 * @date 2022/6/25 17:38
 */
@LocalTCC
public interface RmOneInterface {
    // commitMethod 指定成功时候的调用方法 rollbackMethod 指定失败时候的调用方法
    @TwoPhaseBusinessAction(name = "rm1TccAction" , commitMethod = "rm1Commit" ,rollbackMethod = "rm1Rollback")
    String rm1(BusinessActionContext businessActionContext);

    boolean rm1Commit(BusinessActionContext businessActionContext);

    boolean rm1Rollback(BusinessActionContext businessActionContext);
}
