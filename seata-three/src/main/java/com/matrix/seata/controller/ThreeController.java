package com.matrix.seata.controller;

import com.matrix.seata.service.RmThreeInterface;
import com.matrix.seata.service.RmThreeService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yihaosun
 * @date 2022/6/25 18:00
 */
@RestController
public class ThreeController {
    private final RmThreeService rmThreeService;

    private final RmThreeInterface rmThreeInterface;

    public ThreeController(RmThreeService rmThreeService, RmThreeInterface rmThreeInterface) {
        this.rmThreeService = rmThreeService;
        this.rmThreeInterface = rmThreeInterface;
    }

    @GetMapping("/rm3")
    @Transactional
    public String three(){
        rmThreeService.rm3();
//        int i = 1/0;
        return "成功";
    }

    @GetMapping("/rm3-tcc")
    @GlobalTransactional(rollbackFor = Exception.class)
    public String threeTcc(){
        rmThreeInterface.rm3(null);
        return "成功";
    }
}

