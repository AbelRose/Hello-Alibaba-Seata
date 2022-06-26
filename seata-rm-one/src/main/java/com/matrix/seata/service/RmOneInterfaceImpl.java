package com.matrix.seata.service;

import io.seata.rm.tcc.api.BusinessActionContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

/**
 * @author yihaosun
 * @date 2022/6/25 17:38
 */
@Component
public class RmOneInterfaceImpl implements RmOneInterface {
    private final RestTemplate restTemplate;

    public RmOneInterfaceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    @Transactional
    public String rm1(BusinessActionContext businessActionContext) {
        // 查询是事务记录表，xxxx
        System.out.println("rm1 try");
        rm2();
        rm3();
//        System.out.println(1/0);
        return null;
    }

    @Override
    @Transactional
    public boolean rm1Commit(BusinessActionContext businessActionContext) {
        // TODO 需要手动去插入数据库 commit/cancel阶段代码实现
        System.out.println("rm1 confirm");
        return true;
    }

    @Override
    @Transactional
    public boolean rm1Rollback(BusinessActionContext businessActionContext) {
        // TODO 需要手动去删除数据库 commit/cancel阶段代码实现
        System.out.println("rm1 rollback");
        return true;
    }

    private void rm2() {
        restTemplate.getForEntity("http://two/rm2-tcc", null);
    }

    private void rm3() {
        restTemplate.getForEntity("http://three/rm3-tcc", null);
    }
}
