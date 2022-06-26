package com.matrix.seata.service;

import io.seata.rm.tcc.api.BusinessActionContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

/**
 * @author yihaosun
 * @date 2022/6/25 17:58
 */
@Component
public class RmThreeInterfaceImpl implements RmThreeInterface {
    private final RestTemplate restTemplate;

    public RmThreeInterfaceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    @Transactional
    public String rm3(BusinessActionContext businessActionContext) {
        System.out.println("rm3 try");
//        System.out.println(1/0);
        return null;
    }

    @Override
    @Transactional
    public boolean rm1Commit(BusinessActionContext businessActionContext) {
        System.out.println("rm3 confirm");
        return true;
    }

    @Override
    @Transactional
    public boolean rm1Rollback(BusinessActionContext businessActionContext) {
        System.out.println("rm3 rollback");
        return true;
    }


    private void rm2() {
        restTemplate.getForEntity("http://two/rm2-tcc", null);
    }

    private void rm3() {
        restTemplate.getForEntity("http://three/rm3-tcc", null);
    }
}
