package com.matrix.seata.dao;

import com.matrix.seata.entity.TblOne;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yihaosun
 * @date 2022/6/25 17:35
 */
@Mapper
public interface TblOneDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TblOne record);

    int insertSelective(TblOne record);

    TblOne selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TblOne record);

    int updateByPrimaryKey(TblOne record);
}
