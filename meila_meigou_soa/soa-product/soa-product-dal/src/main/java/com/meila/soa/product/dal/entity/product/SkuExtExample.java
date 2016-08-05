package com.meila.soa.product.dal.entity.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SkuExtExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SkuExtExample() {
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

        public Criteria andSkuIdIsNull() {
            addCriterion("sku_id is null");
            return (Criteria) this;
        }

        public Criteria andSkuIdIsNotNull() {
            addCriterion("sku_id is not null");
            return (Criteria) this;
        }

        public Criteria andSkuIdEqualTo(Long value) {
            addCriterion("sku_id =", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotEqualTo(Long value) {
            addCriterion("sku_id <>", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdGreaterThan(Long value) {
            addCriterion("sku_id >", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdGreaterThanOrEqualTo(Long value) {
            addCriterion("sku_id >=", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdLessThan(Long value) {
            addCriterion("sku_id <", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdLessThanOrEqualTo(Long value) {
            addCriterion("sku_id <=", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdIn(List<Long> values) {
            addCriterion("sku_id in", values, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotIn(List<Long> values) {
            addCriterion("sku_id not in", values, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdBetween(Long value1, Long value2) {
            addCriterion("sku_id between", value1, value2, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotBetween(Long value1, Long value2) {
            addCriterion("sku_id not between", value1, value2, "skuId");
            return (Criteria) this;
        }

        public Criteria andHsCodeIsNull() {
            addCriterion("hs_code is null");
            return (Criteria) this;
        }

        public Criteria andHsCodeIsNotNull() {
            addCriterion("hs_code is not null");
            return (Criteria) this;
        }

        public Criteria andHsCodeEqualTo(String value) {
            addCriterion("hs_code =", value, "hsCode");
            return (Criteria) this;
        }

        public Criteria andHsCodeNotEqualTo(String value) {
            addCriterion("hs_code <>", value, "hsCode");
            return (Criteria) this;
        }

        public Criteria andHsCodeGreaterThan(String value) {
            addCriterion("hs_code >", value, "hsCode");
            return (Criteria) this;
        }

        public Criteria andHsCodeGreaterThanOrEqualTo(String value) {
            addCriterion("hs_code >=", value, "hsCode");
            return (Criteria) this;
        }

        public Criteria andHsCodeLessThan(String value) {
            addCriterion("hs_code <", value, "hsCode");
            return (Criteria) this;
        }

        public Criteria andHsCodeLessThanOrEqualTo(String value) {
            addCriterion("hs_code <=", value, "hsCode");
            return (Criteria) this;
        }

        public Criteria andHsCodeLike(String value) {
            addCriterion("hs_code like", value, "hsCode");
            return (Criteria) this;
        }

        public Criteria andHsCodeNotLike(String value) {
            addCriterion("hs_code not like", value, "hsCode");
            return (Criteria) this;
        }

        public Criteria andHsCodeIn(List<String> values) {
            addCriterion("hs_code in", values, "hsCode");
            return (Criteria) this;
        }

        public Criteria andHsCodeNotIn(List<String> values) {
            addCriterion("hs_code not in", values, "hsCode");
            return (Criteria) this;
        }

        public Criteria andHsCodeBetween(String value1, String value2) {
            addCriterion("hs_code between", value1, value2, "hsCode");
            return (Criteria) this;
        }

        public Criteria andHsCodeNotBetween(String value1, String value2) {
            addCriterion("hs_code not between", value1, value2, "hsCode");
            return (Criteria) this;
        }

        public Criteria andQtyUnitIsNull() {
            addCriterion("qty_unit is null");
            return (Criteria) this;
        }

        public Criteria andQtyUnitIsNotNull() {
            addCriterion("qty_unit is not null");
            return (Criteria) this;
        }

        public Criteria andQtyUnitEqualTo(String value) {
            addCriterion("qty_unit =", value, "qtyUnit");
            return (Criteria) this;
        }

        public Criteria andQtyUnitNotEqualTo(String value) {
            addCriterion("qty_unit <>", value, "qtyUnit");
            return (Criteria) this;
        }

        public Criteria andQtyUnitGreaterThan(String value) {
            addCriterion("qty_unit >", value, "qtyUnit");
            return (Criteria) this;
        }

        public Criteria andQtyUnitGreaterThanOrEqualTo(String value) {
            addCriterion("qty_unit >=", value, "qtyUnit");
            return (Criteria) this;
        }

        public Criteria andQtyUnitLessThan(String value) {
            addCriterion("qty_unit <", value, "qtyUnit");
            return (Criteria) this;
        }

        public Criteria andQtyUnitLessThanOrEqualTo(String value) {
            addCriterion("qty_unit <=", value, "qtyUnit");
            return (Criteria) this;
        }

        public Criteria andQtyUnitLike(String value) {
            addCriterion("qty_unit like", value, "qtyUnit");
            return (Criteria) this;
        }

        public Criteria andQtyUnitNotLike(String value) {
            addCriterion("qty_unit not like", value, "qtyUnit");
            return (Criteria) this;
        }

        public Criteria andQtyUnitIn(List<String> values) {
            addCriterion("qty_unit in", values, "qtyUnit");
            return (Criteria) this;
        }

        public Criteria andQtyUnitNotIn(List<String> values) {
            addCriterion("qty_unit not in", values, "qtyUnit");
            return (Criteria) this;
        }

        public Criteria andQtyUnitBetween(String value1, String value2) {
            addCriterion("qty_unit between", value1, value2, "qtyUnit");
            return (Criteria) this;
        }

        public Criteria andQtyUnitNotBetween(String value1, String value2) {
            addCriterion("qty_unit not between", value1, value2, "qtyUnit");
            return (Criteria) this;
        }

        public Criteria andHgRecordNoIsNull() {
            addCriterion("hg_record_no is null");
            return (Criteria) this;
        }

        public Criteria andHgRecordNoIsNotNull() {
            addCriterion("hg_record_no is not null");
            return (Criteria) this;
        }

        public Criteria andHgRecordNoEqualTo(String value) {
            addCriterion("hg_record_no =", value, "hgRecordNo");
            return (Criteria) this;
        }

        public Criteria andHgRecordNoNotEqualTo(String value) {
            addCriterion("hg_record_no <>", value, "hgRecordNo");
            return (Criteria) this;
        }

        public Criteria andHgRecordNoGreaterThan(String value) {
            addCriterion("hg_record_no >", value, "hgRecordNo");
            return (Criteria) this;
        }

        public Criteria andHgRecordNoGreaterThanOrEqualTo(String value) {
            addCriterion("hg_record_no >=", value, "hgRecordNo");
            return (Criteria) this;
        }

        public Criteria andHgRecordNoLessThan(String value) {
            addCriterion("hg_record_no <", value, "hgRecordNo");
            return (Criteria) this;
        }

        public Criteria andHgRecordNoLessThanOrEqualTo(String value) {
            addCriterion("hg_record_no <=", value, "hgRecordNo");
            return (Criteria) this;
        }

        public Criteria andHgRecordNoLike(String value) {
            addCriterion("hg_record_no like", value, "hgRecordNo");
            return (Criteria) this;
        }

        public Criteria andHgRecordNoNotLike(String value) {
            addCriterion("hg_record_no not like", value, "hgRecordNo");
            return (Criteria) this;
        }

        public Criteria andHgRecordNoIn(List<String> values) {
            addCriterion("hg_record_no in", values, "hgRecordNo");
            return (Criteria) this;
        }

        public Criteria andHgRecordNoNotIn(List<String> values) {
            addCriterion("hg_record_no not in", values, "hgRecordNo");
            return (Criteria) this;
        }

        public Criteria andHgRecordNoBetween(String value1, String value2) {
            addCriterion("hg_record_no between", value1, value2, "hgRecordNo");
            return (Criteria) this;
        }

        public Criteria andHgRecordNoNotBetween(String value1, String value2) {
            addCriterion("hg_record_no not between", value1, value2, "hgRecordNo");
            return (Criteria) this;
        }

        public Criteria andCiqRecordNoIsNull() {
            addCriterion("ciq_record_no is null");
            return (Criteria) this;
        }

        public Criteria andCiqRecordNoIsNotNull() {
            addCriterion("ciq_record_no is not null");
            return (Criteria) this;
        }

        public Criteria andCiqRecordNoEqualTo(String value) {
            addCriterion("ciq_record_no =", value, "ciqRecordNo");
            return (Criteria) this;
        }

        public Criteria andCiqRecordNoNotEqualTo(String value) {
            addCriterion("ciq_record_no <>", value, "ciqRecordNo");
            return (Criteria) this;
        }

        public Criteria andCiqRecordNoGreaterThan(String value) {
            addCriterion("ciq_record_no >", value, "ciqRecordNo");
            return (Criteria) this;
        }

        public Criteria andCiqRecordNoGreaterThanOrEqualTo(String value) {
            addCriterion("ciq_record_no >=", value, "ciqRecordNo");
            return (Criteria) this;
        }

        public Criteria andCiqRecordNoLessThan(String value) {
            addCriterion("ciq_record_no <", value, "ciqRecordNo");
            return (Criteria) this;
        }

        public Criteria andCiqRecordNoLessThanOrEqualTo(String value) {
            addCriterion("ciq_record_no <=", value, "ciqRecordNo");
            return (Criteria) this;
        }

        public Criteria andCiqRecordNoLike(String value) {
            addCriterion("ciq_record_no like", value, "ciqRecordNo");
            return (Criteria) this;
        }

        public Criteria andCiqRecordNoNotLike(String value) {
            addCriterion("ciq_record_no not like", value, "ciqRecordNo");
            return (Criteria) this;
        }

        public Criteria andCiqRecordNoIn(List<String> values) {
            addCriterion("ciq_record_no in", values, "ciqRecordNo");
            return (Criteria) this;
        }

        public Criteria andCiqRecordNoNotIn(List<String> values) {
            addCriterion("ciq_record_no not in", values, "ciqRecordNo");
            return (Criteria) this;
        }

        public Criteria andCiqRecordNoBetween(String value1, String value2) {
            addCriterion("ciq_record_no between", value1, value2, "ciqRecordNo");
            return (Criteria) this;
        }

        public Criteria andCiqRecordNoNotBetween(String value1, String value2) {
            addCriterion("ciq_record_no not between", value1, value2, "ciqRecordNo");
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

        public Criteria andCreatedIdIsNull() {
            addCriterion("created_id is null");
            return (Criteria) this;
        }

        public Criteria andCreatedIdIsNotNull() {
            addCriterion("created_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedIdEqualTo(Long value) {
            addCriterion("created_id =", value, "createdId");
            return (Criteria) this;
        }

        public Criteria andCreatedIdNotEqualTo(Long value) {
            addCriterion("created_id <>", value, "createdId");
            return (Criteria) this;
        }

        public Criteria andCreatedIdGreaterThan(Long value) {
            addCriterion("created_id >", value, "createdId");
            return (Criteria) this;
        }

        public Criteria andCreatedIdGreaterThanOrEqualTo(Long value) {
            addCriterion("created_id >=", value, "createdId");
            return (Criteria) this;
        }

        public Criteria andCreatedIdLessThan(Long value) {
            addCriterion("created_id <", value, "createdId");
            return (Criteria) this;
        }

        public Criteria andCreatedIdLessThanOrEqualTo(Long value) {
            addCriterion("created_id <=", value, "createdId");
            return (Criteria) this;
        }

        public Criteria andCreatedIdIn(List<Long> values) {
            addCriterion("created_id in", values, "createdId");
            return (Criteria) this;
        }

        public Criteria andCreatedIdNotIn(List<Long> values) {
            addCriterion("created_id not in", values, "createdId");
            return (Criteria) this;
        }

        public Criteria andCreatedIdBetween(Long value1, Long value2) {
            addCriterion("created_id between", value1, value2, "createdId");
            return (Criteria) this;
        }

        public Criteria andCreatedIdNotBetween(Long value1, Long value2) {
            addCriterion("created_id not between", value1, value2, "createdId");
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

        public Criteria andUpdatedIdIsNull() {
            addCriterion("updated_id is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedIdIsNotNull() {
            addCriterion("updated_id is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedIdEqualTo(Long value) {
            addCriterion("updated_id =", value, "updatedId");
            return (Criteria) this;
        }

        public Criteria andUpdatedIdNotEqualTo(Long value) {
            addCriterion("updated_id <>", value, "updatedId");
            return (Criteria) this;
        }

        public Criteria andUpdatedIdGreaterThan(Long value) {
            addCriterion("updated_id >", value, "updatedId");
            return (Criteria) this;
        }

        public Criteria andUpdatedIdGreaterThanOrEqualTo(Long value) {
            addCriterion("updated_id >=", value, "updatedId");
            return (Criteria) this;
        }

        public Criteria andUpdatedIdLessThan(Long value) {
            addCriterion("updated_id <", value, "updatedId");
            return (Criteria) this;
        }

        public Criteria andUpdatedIdLessThanOrEqualTo(Long value) {
            addCriterion("updated_id <=", value, "updatedId");
            return (Criteria) this;
        }

        public Criteria andUpdatedIdIn(List<Long> values) {
            addCriterion("updated_id in", values, "updatedId");
            return (Criteria) this;
        }

        public Criteria andUpdatedIdNotIn(List<Long> values) {
            addCriterion("updated_id not in", values, "updatedId");
            return (Criteria) this;
        }

        public Criteria andUpdatedIdBetween(Long value1, Long value2) {
            addCriterion("updated_id between", value1, value2, "updatedId");
            return (Criteria) this;
        }

        public Criteria andUpdatedIdNotBetween(Long value1, Long value2) {
            addCriterion("updated_id not between", value1, value2, "updatedId");
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
