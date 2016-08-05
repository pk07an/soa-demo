package com.meila.soa.product.dal.entity.product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SkuBomExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SkuBomExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSpuIdIsNull() {
            addCriterion("spu_id is null");
            return (Criteria) this;
        }

        public Criteria andSpuIdIsNotNull() {
            addCriterion("spu_id is not null");
            return (Criteria) this;
        }

        public Criteria andSpuIdEqualTo(Long value) {
            addCriterion("spu_id =", value, "spuId");
            return (Criteria) this;
        }

        public Criteria andSpuIdNotEqualTo(Long value) {
            addCriterion("spu_id <>", value, "spuId");
            return (Criteria) this;
        }

        public Criteria andSpuIdGreaterThan(Long value) {
            addCriterion("spu_id >", value, "spuId");
            return (Criteria) this;
        }

        public Criteria andSpuIdGreaterThanOrEqualTo(Long value) {
            addCriterion("spu_id >=", value, "spuId");
            return (Criteria) this;
        }

        public Criteria andSpuIdLessThan(Long value) {
            addCriterion("spu_id <", value, "spuId");
            return (Criteria) this;
        }

        public Criteria andSpuIdLessThanOrEqualTo(Long value) {
            addCriterion("spu_id <=", value, "spuId");
            return (Criteria) this;
        }

        public Criteria andSpuIdIn(List<Long> values) {
            addCriterion("spu_id in", values, "spuId");
            return (Criteria) this;
        }

        public Criteria andSpuIdNotIn(List<Long> values) {
            addCriterion("spu_id not in", values, "spuId");
            return (Criteria) this;
        }

        public Criteria andSpuIdBetween(Long value1, Long value2) {
            addCriterion("spu_id between", value1, value2, "spuId");
            return (Criteria) this;
        }

        public Criteria andSpuIdNotBetween(Long value1, Long value2) {
            addCriterion("spu_id not between", value1, value2, "spuId");
            return (Criteria) this;
        }

        public Criteria andSubSkuIdIsNull() {
            addCriterion("sub_sku_id is null");
            return (Criteria) this;
        }

        public Criteria andSubSkuIdIsNotNull() {
            addCriterion("sub_sku_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubSkuIdEqualTo(Long value) {
            addCriterion("sub_sku_id =", value, "subSkuId");
            return (Criteria) this;
        }

        public Criteria andSubSkuIdNotEqualTo(Long value) {
            addCriterion("sub_sku_id <>", value, "subSkuId");
            return (Criteria) this;
        }

        public Criteria andSubSkuIdGreaterThan(Long value) {
            addCriterion("sub_sku_id >", value, "subSkuId");
            return (Criteria) this;
        }

        public Criteria andSubSkuIdGreaterThanOrEqualTo(Long value) {
            addCriterion("sub_sku_id >=", value, "subSkuId");
            return (Criteria) this;
        }

        public Criteria andSubSkuIdLessThan(Long value) {
            addCriterion("sub_sku_id <", value, "subSkuId");
            return (Criteria) this;
        }

        public Criteria andSubSkuIdLessThanOrEqualTo(Long value) {
            addCriterion("sub_sku_id <=", value, "subSkuId");
            return (Criteria) this;
        }

        public Criteria andSubSkuIdIn(List<Long> values) {
            addCriterion("sub_sku_id in", values, "subSkuId");
            return (Criteria) this;
        }

        public Criteria andSubSkuIdNotIn(List<Long> values) {
            addCriterion("sub_sku_id not in", values, "subSkuId");
            return (Criteria) this;
        }

        public Criteria andSubSkuIdBetween(Long value1, Long value2) {
            addCriterion("sub_sku_id between", value1, value2, "subSkuId");
            return (Criteria) this;
        }

        public Criteria andSubSkuIdNotBetween(Long value1, Long value2) {
            addCriterion("sub_sku_id not between", value1, value2, "subSkuId");
            return (Criteria) this;
        }

        public Criteria andMatchCountIsNull() {
            addCriterion("match_count is null");
            return (Criteria) this;
        }

        public Criteria andMatchCountIsNotNull() {
            addCriterion("match_count is not null");
            return (Criteria) this;
        }

        public Criteria andMatchCountEqualTo(Integer value) {
            addCriterion("match_count =", value, "matchCount");
            return (Criteria) this;
        }

        public Criteria andMatchCountNotEqualTo(Integer value) {
            addCriterion("match_count <>", value, "matchCount");
            return (Criteria) this;
        }

        public Criteria andMatchCountGreaterThan(Integer value) {
            addCriterion("match_count >", value, "matchCount");
            return (Criteria) this;
        }

        public Criteria andMatchCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("match_count >=", value, "matchCount");
            return (Criteria) this;
        }

        public Criteria andMatchCountLessThan(Integer value) {
            addCriterion("match_count <", value, "matchCount");
            return (Criteria) this;
        }

        public Criteria andMatchCountLessThanOrEqualTo(Integer value) {
            addCriterion("match_count <=", value, "matchCount");
            return (Criteria) this;
        }

        public Criteria andMatchCountIn(List<Integer> values) {
            addCriterion("match_count in", values, "matchCount");
            return (Criteria) this;
        }

        public Criteria andMatchCountNotIn(List<Integer> values) {
            addCriterion("match_count not in", values, "matchCount");
            return (Criteria) this;
        }

        public Criteria andMatchCountBetween(Integer value1, Integer value2) {
            addCriterion("match_count between", value1, value2, "matchCount");
            return (Criteria) this;
        }

        public Criteria andMatchCountNotBetween(Integer value1, Integer value2) {
            addCriterion("match_count not between", value1, value2, "matchCount");
            return (Criteria) this;
        }

        public Criteria andClearancePriceIsNull() {
            addCriterion("clearance_price is null");
            return (Criteria) this;
        }

        public Criteria andClearancePriceIsNotNull() {
            addCriterion("clearance_price is not null");
            return (Criteria) this;
        }

        public Criteria andClearancePriceEqualTo(BigDecimal value) {
            addCriterion("clearance_price =", value, "clearancePrice");
            return (Criteria) this;
        }

        public Criteria andClearancePriceNotEqualTo(BigDecimal value) {
            addCriterion("clearance_price <>", value, "clearancePrice");
            return (Criteria) this;
        }

        public Criteria andClearancePriceGreaterThan(BigDecimal value) {
            addCriterion("clearance_price >", value, "clearancePrice");
            return (Criteria) this;
        }

        public Criteria andClearancePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("clearance_price >=", value, "clearancePrice");
            return (Criteria) this;
        }

        public Criteria andClearancePriceLessThan(BigDecimal value) {
            addCriterion("clearance_price <", value, "clearancePrice");
            return (Criteria) this;
        }

        public Criteria andClearancePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("clearance_price <=", value, "clearancePrice");
            return (Criteria) this;
        }

        public Criteria andClearancePriceIn(List<BigDecimal> values) {
            addCriterion("clearance_price in", values, "clearancePrice");
            return (Criteria) this;
        }

        public Criteria andClearancePriceNotIn(List<BigDecimal> values) {
            addCriterion("clearance_price not in", values, "clearancePrice");
            return (Criteria) this;
        }

        public Criteria andClearancePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("clearance_price between", value1, value2, "clearancePrice");
            return (Criteria) this;
        }

        public Criteria andClearancePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("clearance_price not between", value1, value2, "clearancePrice");
            return (Criteria) this;
        }

        public Criteria andArchiveIsNull() {
            addCriterion("archive is null");
            return (Criteria) this;
        }

        public Criteria andArchiveIsNotNull() {
            addCriterion("archive is not null");
            return (Criteria) this;
        }

        public Criteria andArchiveEqualTo(Boolean value) {
            addCriterion("archive =", value, "archive");
            return (Criteria) this;
        }

        public Criteria andArchiveNotEqualTo(Boolean value) {
            addCriterion("archive <>", value, "archive");
            return (Criteria) this;
        }

        public Criteria andArchiveGreaterThan(Boolean value) {
            addCriterion("archive >", value, "archive");
            return (Criteria) this;
        }

        public Criteria andArchiveGreaterThanOrEqualTo(Boolean value) {
            addCriterion("archive >=", value, "archive");
            return (Criteria) this;
        }

        public Criteria andArchiveLessThan(Boolean value) {
            addCriterion("archive <", value, "archive");
            return (Criteria) this;
        }

        public Criteria andArchiveLessThanOrEqualTo(Boolean value) {
            addCriterion("archive <=", value, "archive");
            return (Criteria) this;
        }

        public Criteria andArchiveIn(List<Boolean> values) {
            addCriterion("archive in", values, "archive");
            return (Criteria) this;
        }

        public Criteria andArchiveNotIn(List<Boolean> values) {
            addCriterion("archive not in", values, "archive");
            return (Criteria) this;
        }

        public Criteria andArchiveBetween(Boolean value1, Boolean value2) {
            addCriterion("archive between", value1, value2, "archive");
            return (Criteria) this;
        }

        public Criteria andArchiveNotBetween(Boolean value1, Boolean value2) {
            addCriterion("archive not between", value1, value2, "archive");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNull() {
            addCriterion("created_at is null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNotNull() {
            addCriterion("created_at is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtEqualTo(Date value) {
            addCriterion("created_at =", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotEqualTo(Date value) {
            addCriterion("created_at <>", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThan(Date value) {
            addCriterion("created_at >", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("created_at >=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThan(Date value) {
            addCriterion("created_at <", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThanOrEqualTo(Date value) {
            addCriterion("created_at <=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIn(List<Date> values) {
            addCriterion("created_at in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotIn(List<Date> values) {
            addCriterion("created_at not in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtBetween(Date value1, Date value2) {
            addCriterion("created_at between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotBetween(Date value1, Date value2) {
            addCriterion("created_at not between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNull() {
            addCriterion("updated_at is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNotNull() {
            addCriterion("updated_at is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtEqualTo(Date value) {
            addCriterion("updated_at =", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotEqualTo(Date value) {
            addCriterion("updated_at <>", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThan(Date value) {
            addCriterion("updated_at >", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("updated_at >=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThan(Date value) {
            addCriterion("updated_at <", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThanOrEqualTo(Date value) {
            addCriterion("updated_at <=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIn(List<Date> values) {
            addCriterion("updated_at in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotIn(List<Date> values) {
            addCriterion("updated_at not in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtBetween(Date value1, Date value2) {
            addCriterion("updated_at between", value1, value2, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotBetween(Date value1, Date value2) {
            addCriterion("updated_at not between", value1, value2, "updatedAt");
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
