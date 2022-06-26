package com.matrix.seata.dao;

import com.matrix.seata.entity.TblThree;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yihaosun
 * @date 2022/6/25 17:59
 */
@Mapper
public interface TblThreeDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TblThree record);

    int insertSelective(TblThree record);

    TblThree selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TblThree record);

    int updateByPrimaryKey(TblThree record);
}
