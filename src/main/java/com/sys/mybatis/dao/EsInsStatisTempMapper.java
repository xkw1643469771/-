package com.sys.mybatis.dao;

import com.sys.mybatis.po.EsInsStatisTemp;
import com.sys.mybatis.po.EsInsStatisTempExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EsInsStatisTempMapper {
    long countByExample(EsInsStatisTempExample example);

    int deleteByExample(EsInsStatisTempExample example);

    int deleteByPrimaryKey(Long esInsStatisTempId);

    int insert(EsInsStatisTemp record);

    int insertSelective(EsInsStatisTemp record);

    List<EsInsStatisTemp> selectByExample(EsInsStatisTempExample example);

    EsInsStatisTemp selectByPrimaryKey(Long esInsStatisTempId);

    int updateByExampleSelective(@Param("record") EsInsStatisTemp record, @Param("example") EsInsStatisTempExample example);

    int updateByExample(@Param("record") EsInsStatisTemp record, @Param("example") EsInsStatisTempExample example);

    int updateByPrimaryKeySelective(EsInsStatisTemp record);

    int updateByPrimaryKey(EsInsStatisTemp record);
}