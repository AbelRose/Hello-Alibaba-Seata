package com.matrix.seata.controller;

import com.matrix.seata.service.RmTwoInterface;
import com.matrix.seata.service.RmTwoService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yihaosun
 * @date 2022/6/25 17:52
 */
@RestController
public class TwoController {
    private final RmTwoService rmTwoService;

    private final RmTwoInterface rmTwoInterface;

    @Autowired
    public TwoController(RmTwoService rmTwoService, RmTwoInterface rmTwoInterface) {
        this.rmTwoService = rmTwoService;
        this.rmTwoInterface = rmTwoInterface;
    }

    @GetMapping("/rm2")
    public String two(){
        rmTwoService.rm2();
//        int i = 1/0;
        return "success";
    }

    @GetMapping("/rm2-tcc")
    @GlobalTransactional(rollbackFor = Exception.class)
    public String twoTcc(){
        rmTwoInterface.rm2(null);
//        int i = 1/0;
        return "success";
    }
}
