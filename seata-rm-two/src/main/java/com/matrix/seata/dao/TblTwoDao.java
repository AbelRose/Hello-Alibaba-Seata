package com.matrix.seata.dao;

import com.matrix.seata.entity.TblTwo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yihaosun
 * @date 2022/6/25 17:50
 */
@Mapper
public interface TblTwoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TblTwo record);

    int insertSelective(TblTwo record);

    TblTwo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TblTwo record);

    int updateByPrimaryKey(TblTwo record);
}
