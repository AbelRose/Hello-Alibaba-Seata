package com.matrix.seata.service;

import com.matrix.seata.dao.TblThreeDao;
import com.matrix.seata.entity.TblThree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yihaosun
 * @date 2022/6/25 17:58
 */
@Service
public class RmThreeService {
    private final TblThreeDao mapper;

    public RmThreeService(TblThreeDao mapper) {
        this.mapper = mapper;
    }

    public String rm3() {
        TblThree o = new TblThree();
        o.setId(3);
        o.setName("rm3");
        mapper.insertSelective(o);
        return "";
    }
}