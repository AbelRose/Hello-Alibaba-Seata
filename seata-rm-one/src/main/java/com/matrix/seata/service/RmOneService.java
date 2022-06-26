package com.matrix.seata.service;

import com.matrix.seata.dao.TblOneDao;
import com.matrix.seata.entity.TblOne;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author yihaosun
 * @date 2022/6/25 17:39
 */

@Service
public class RmOneService {
    private final TblOneDao mapper;

    private final RestTemplate restTemplate;

    public RmOneService(TblOneDao mapper, RestTemplate restTemplate) {
        this.mapper = mapper;
        this.restTemplate = restTemplate;
    }

    public String rm1() {
        TblOne o = new TblOne();
        o.setId(1);
        o.setName("rm1");
        mapper.insertSelective(o);

        rm2();
        rm3();
        return "";
    }

    public String rm2Update() {
        rm2UpdateRemote();
        TblOne o = new TblOne();
        o.setId(2);
        o.setName("rm2");
        mapper.insertSelective(o);
//		int i = 1/0;
        return "";
    }

    private void rm2() {
        restTemplate.getForEntity("http://seata-rm-two/rm2", null);
    }

    private void rm2UpdateRemote() {
        restTemplate.getForEntity("http://seata-rm-two/rm2-update", null);
    }

    private void rm3() {
        restTemplate.getForEntity("http://seata-rm-three/rm3", null);
    }
}