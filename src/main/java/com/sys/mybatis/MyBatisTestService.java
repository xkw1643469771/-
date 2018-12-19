package com.sys.mybatis;

import com.sys.mybatis.dao.EsInsStatisTempMapper;
import com.sys.mybatis.po.EsInsStatisTempExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class MyBatisTestService {

    @Autowired
    private EsInsStatisTempMapper esInsStatisTempMapper;

    public void test1(){
        EsInsStatisTempExample example = new EsInsStatisTempExample();
        example.setOrderByClause("ES_INS_STATIS_TEMP_ID,CUST_INS_ID");
        esInsStatisTempMapper.selectByExample(example);
    }

}