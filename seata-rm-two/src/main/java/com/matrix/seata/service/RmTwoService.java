package com.matrix.seata.service;

import com.matrix.seata.dao.TblTwoDao;
import com.matrix.seata.entity.TblTwo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author yihaosun
 * @date 2022/6/25 17:53
 */
@Service
public class RmTwoService {
    final TblTwoDao mapper;

    public RmTwoService(TblTwoDao mapper) {
        this.mapper = mapper;
    }

    public String rm2() {
        TblTwo o = new TblTwo();
        o.setId(2);
        o.setName("rm2");
        mapper.insertSelective(o);

        return "";
    }

    public String updateRm2() {
        TblTwo o = mapper.selectByPrimaryKey(2);
        o.setName(o.getName()+new Random().nextInt(2));
        mapper.updateByPrimaryKeySelective(o);
        return "";
    }
}
