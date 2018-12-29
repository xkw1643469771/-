package com.sys.mybatis.po;

import java.util.ArrayList;
import java.util.List;

public class EsInsStatisTempExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EsInsStatisTempExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andEsInsStatisTempIdIsNull() {
            addCriterion("ES_INS_STATIS_TEMP_ID is null");
            return (Criteria) this;
        }

        public Criteria andEsInsStatisTempIdIsNotNull() {
            addCriterion("ES_INS_STATIS_TEMP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andEsInsStatisTempIdEqualTo(Long value) {
            addCriterion("ES_INS_STATIS_TEMP_ID =", value, "esInsStatisTempId");
            return (Criteria) this;
        }

        public Criteria andEsInsStatisTempIdNotEqualTo(Long value) {
            addCriterion("ES_INS_STATIS_TEMP_ID <>", value, "esInsStatisTempId");
            return (Criteria) this;
        }

        public Criteria andEsInsStatisTempIdGreaterThan(Long value) {
            addCriterion("ES_INS_STATIS_TEMP_ID >", value, "esInsStatisTempId");
            return (Criteria) this;
        }

        public Criteria andEsInsStatisTempIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ES_INS_STATIS_TEMP_ID >=", value, "esInsStatisTempId");
            return (Criteria) this;
        }

        public Criteria andEsInsStatisTempIdLessThan(Long value) {
            addCriterion("ES_INS_STATIS_TEMP_ID <", value, "esInsStatisTempId");
            return (Criteria) this;
        }

        public Criteria andEsInsStatisTempIdLessThanOrEqualTo(Long value) {
            addCriterion("ES_INS_STATIS_TEMP_ID <=", value, "esInsStatisTempId");
            return (Criteria) this;
        }

        public Criteria andEsInsStatisTempIdIn(List<Long> values) {
            addCriterion("ES_INS_STATIS_TEMP_ID in", values, "esInsStatisTempId");
            return (Criteria) this;
        }

        public Criteria andEsInsStatisTempIdNotIn(List<Long> values) {
            addCriterion("ES_INS_STATIS_TEMP_ID not in", values, "esInsStatisTempId");
            return (Criteria) this;
        }

        public Criteria andEsInsStatisTempIdBetween(Long value1, Long value2) {
            addCriterion("ES_INS_STATIS_TEMP_ID between", value1, value2, "esInsStatisTempId");
            return (Criteria) this;
        }

        public Criteria andEsInsStatisTempIdNotBetween(Long value1, Long value2) {
            addCriterion("ES_INS_STATIS_TEMP_ID not between", value1, value2, "esInsStatisTempId");
            return (Criteria) this;
        }

        public Criteria andCustInsIdIsNull() {
            addCriterion("CUST_INS_ID is null");
            return (Criteria) this;
        }

        public Criteria andCustInsIdIsNotNull() {
            addCriterion("CUST_INS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCustInsIdEqualTo(Long value) {
            addCriterion("CUST_INS_ID =", value, "custInsId");
            return (Criteria) this;
        }

        public Criteria andCustInsIdNotEqualTo(Long value) {
            addCriterion("CUST_INS_ID <>", value, "custInsId");
            return (Criteria) this;
        }

        public Criteria andCustInsIdGreaterThan(Long value) {
            addCriterion("CUST_INS_ID >", value, "custInsId");
            return (Criteria) this;
        }

        public Criteria andCustInsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("CUST_INS_ID >=", value, "custInsId");
            return (Criteria) this;
        }

        public Criteria andCustInsIdLessThan(Long value) {
            addCriterion("CUST_INS_ID <", value, "custInsId");
            return (Criteria) this;
        }

        public Criteria andCustInsIdLessThanOrEqualTo(Long value) {
            addCriterion("CUST_INS_ID <=", value, "custInsId");
            return (Criteria) this;
        }

        public Criteria andCustInsIdIn(List<Long> values) {
            addCriterion("CUST_INS_ID in", values, "custInsId");
            return (Criteria) this;
        }

        public Criteria andCustInsIdNotIn(List<Long> values) {
            addCriterion("CUST_INS_ID not in", values, "custInsId");
            return (Criteria) this;
        }

        public Criteria andCustInsIdBetween(Long value1, Long value2) {
            addCriterion("CUST_INS_ID between", value1, value2, "custInsId");
            return (Criteria) this;
        }

        public Criteria andCustInsIdNotBetween(Long value1, Long value2) {
            addCriterion("CUST_INS_ID not between", value1, value2, "custInsId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}