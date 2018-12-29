package com.sys.mybatis.po;

import java.io.Serializable;

public class EsInsStatisTemp implements Serializable {
    /** 社保统计临时表主键ID */
    private Long esInsStatisTempId;

    /** 社保账户信息ID */
    private Long custInsId;

    private static final long serialVersionUID = 1L;

    public Long getEsInsStatisTempId() {
        return esInsStatisTempId;
    }

    public void setEsInsStatisTempId(Long esInsStatisTempId) {
        this.esInsStatisTempId = esInsStatisTempId;
    }

    public Long getCustInsId() {
        return custInsId;
    }

    public void setCustInsId(Long custInsId) {
        this.custInsId = custInsId;
    }
}