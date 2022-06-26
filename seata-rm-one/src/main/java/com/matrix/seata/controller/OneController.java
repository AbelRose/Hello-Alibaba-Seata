package com.matrix.seata.controller;

import com.matrix.seata.service.RmOneInterface;
import com.matrix.seata.service.RmOneService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yihaosun
 * @date 2022/6/25 17:37
 */
@RestController
public class OneController {
    private final RmOneService rmOneService;

    private final RmOneInterface rmOneInterface;

    public OneController(RmOneService rmOneService, RmOneInterface rmOneInterface) {
        this.rmOneService = rmOneService;
        this.rmOneInterface = rmOneInterface;
    }

    @GetMapping("/one")
    // TODO 只需要在调用方加上 @GlobalTransactional 这个注解就可以了
    @GlobalTransactional(rollbackFor = Exception.class)
    public String one() throws InterruptedException {
        rmOneService.rm1();
//        TimeUnit.MINUTES.sleep(1);
        System.out.println(1/0);
        return "success";
    }


    @GetMapping("/one-tcc")
    @GlobalTransactional(rollbackFor = Exception.class)
    public String oneTcc() throws InterruptedException {
        rmOneInterface.rm1(null);
        return "success";
    }
}

