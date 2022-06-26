package com.matrix.seata.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yihaosun
 * @date 2022/6/25 17:49
 */
@Data
public class TblTwo implements Serializable {
    private Integer id;
    private String name;
    private static final long serialVersionUID = 1L;
}