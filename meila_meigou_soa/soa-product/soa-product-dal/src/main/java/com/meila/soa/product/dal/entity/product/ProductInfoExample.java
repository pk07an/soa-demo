package com.meila.soa.product.dal.entity.product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductInfoExample() {
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

        public Criteria andProductIdIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(Long value) {
            addCriterion("product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(Long value) {
            addCriterion("product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(Long value) {
            addCriterion("product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(Long value) {
            addCriterion("product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(Long value) {
            addCriterion("product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(Long value) {
            addCriterion("product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<Long> values) {
            addCriterion("product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<Long> values) {
            addCriterion("product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(Long value1, Long value2) {
            addCriterion("product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(Long value1, Long value2) {
            addCriterion("product_id not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andPropertyIsNull() {
            addCriterion("property is null");
            return (Criteria) this;
        }

        public Criteria andPropertyIsNotNull() {
            addCriterion("property is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyEqualTo(Boolean value) {
            addCriterion("property =", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyNotEqualTo(Boolean value) {
            addCriterion("property <>", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyGreaterThan(Boolean value) {
            addCriterion("property >", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyGreaterThanOrEqualTo(Boolean value) {
            addCriterion("property >=", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyLessThan(Boolean value) {
            addCriterion("property <", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyLessThanOrEqualTo(Boolean value) {
            addCriterion("property <=", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyIn(List<Boolean> values) {
            addCriterion("property in", values, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyNotIn(List<Boolean> values) {
            addCriterion("property not in", values, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyBetween(Boolean value1, Boolean value2) {
            addCriterion("property between", value1, value2, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyNotBetween(Boolean value1, Boolean value2) {
            addCriterion("property not between", value1, value2, "property");
            return (Criteria) this;
        }

        public Criteria andMsPriceIsNull() {
            addCriterion("ms_price is null");
            return (Criteria) this;
        }

        public Criteria andMsPriceIsNotNull() {
            addCriterion("ms_price is not null");
            return (Criteria) this;
        }

        public Criteria andMsPriceEqualTo(BigDecimal value) {
            addCriterion("ms_price =", value, "msPrice");
            return (Criteria) this;
        }

        public Criteria andMsPriceNotEqualTo(BigDecimal value) {
            addCriterion("ms_price <>", value, "msPrice");
            return (Criteria) this;
        }

        public Criteria andMsPriceGreaterThan(BigDecimal value) {
            addCriterion("ms_price >", value, "msPrice");
            return (Criteria) this;
        }

        public Criteria andMsPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ms_price >=", value, "msPrice");
            return (Criteria) this;
        }

        public Criteria andMsPriceLessThan(BigDecimal value) {
            addCriterion("ms_price <", value, "msPrice");
            return (Criteria) this;
        }

        public Criteria andMsPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ms_price <=", value, "msPrice");
            return (Criteria) this;
        }

        public Criteria andMsPriceIn(List<BigDecimal> values) {
            addCriterion("ms_price in", values, "msPrice");
            return (Criteria) this;
        }

        public Criteria andMsPriceNotIn(List<BigDecimal> values) {
            addCriterion("ms_price not in", values, "msPrice");
            return (Criteria) this;
        }

        public Criteria andMsPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ms_price between", value1, value2, "msPrice");
            return (Criteria) this;
        }

        public Criteria andMsPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ms_price not between", value1, value2, "msPrice");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andShortIntroIsNull() {
            addCriterion("short_intro is null");
            return (Criteria) this;
        }

        public Criteria andShortIntroIsNotNull() {
            addCriterion("short_intro is not null");
            return (Criteria) this;
        }

        public Criteria andShortIntroEqualTo(String value) {
            addCriterion("short_intro =", value, "shortIntro");
            return (Criteria) this;
        }

        public Criteria andShortIntroNotEqualTo(String value) {
            addCriterion("short_intro <>", value, "shortIntro");
            return (Criteria) this;
        }

        public Criteria andShortIntroGreaterThan(String value) {
            addCriterion("short_intro >", value, "shortIntro");
            return (Criteria) this;
        }

        public Criteria andShortIntroGreaterThanOrEqualTo(String value) {
            addCriterion("short_intro >=", value, "shortIntro");
            return (Criteria) this;
        }

        public Criteria andShortIntroLessThan(String value) {
            addCriterion("short_intro <", value, "shortIntro");
            return (Criteria) this;
        }

        public Criteria andShortIntroLessThanOrEqualTo(String value) {
            addCriterion("short_intro <=", value, "shortIntro");
            return (Criteria) this;
        }

        public Criteria andShortIntroLike(String value) {
            addCriterion("short_intro like", value, "shortIntro");
            return (Criteria) this;
        }

        public Criteria andShortIntroNotLike(String value) {
            addCriterion("short_intro not like", value, "shortIntro");
            return (Criteria) this;
        }

        public Criteria andShortIntroIn(List<String> values) {
            addCriterion("short_intro in", values, "shortIntro");
            return (Criteria) this;
        }

        public Criteria andShortIntroNotIn(List<String> values) {
            addCriterion("short_intro not in", values, "shortIntro");
            return (Criteria) this;
        }

        public Criteria andShortIntroBetween(String value1, String value2) {
            addCriterion("short_intro between", value1, value2, "shortIntro");
            return (Criteria) this;
        }

        public Criteria andShortIntroNotBetween(String value1, String value2) {
            addCriterion("short_intro not between", value1, value2, "shortIntro");
            return (Criteria) this;
        }

        public Criteria andShortNameIsNull() {
            addCriterion("short_name is null");
            return (Criteria) this;
        }

        public Criteria andShortNameIsNotNull() {
            addCriterion("short_name is not null");
            return (Criteria) this;
        }

        public Criteria andShortNameEqualTo(String value) {
            addCriterion("short_name =", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotEqualTo(String value) {
            addCriterion("short_name <>", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameGreaterThan(String value) {
            addCriterion("short_name >", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameGreaterThanOrEqualTo(String value) {
            addCriterion("short_name >=", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLessThan(String value) {
            addCriterion("short_name <", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLessThanOrEqualTo(String value) {
            addCriterion("short_name <=", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLike(String value) {
            addCriterion("short_name like", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotLike(String value) {
            addCriterion("short_name not like", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameIn(List<String> values) {
            addCriterion("short_name in", values, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotIn(List<String> values) {
            addCriterion("short_name not in", values, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameBetween(String value1, String value2) {
            addCriterion("short_name between", value1, value2, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotBetween(String value1, String value2) {
            addCriterion("short_name not between", value1, value2, "shortName");
            return (Criteria) this;
        }

        public Criteria andTotalCountIsNull() {
            addCriterion("total_count is null");
            return (Criteria) this;
        }

        public Criteria andTotalCountIsNotNull() {
            addCriterion("total_count is not null");
            return (Criteria) this;
        }

        public Criteria andTotalCountEqualTo(Integer value) {
            addCriterion("total_count =", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountNotEqualTo(Integer value) {
            addCriterion("total_count <>", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountGreaterThan(Integer value) {
            addCriterion("total_count >", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_count >=", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountLessThan(Integer value) {
            addCriterion("total_count <", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountLessThanOrEqualTo(Integer value) {
            addCriterion("total_count <=", value, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountIn(List<Integer> values) {
            addCriterion("total_count in", values, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountNotIn(List<Integer> values) {
            addCriterion("total_count not in", values, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountBetween(Integer value1, Integer value2) {
            addCriterion("total_count between", value1, value2, "totalCount");
            return (Criteria) this;
        }

        public Criteria andTotalCountNotBetween(Integer value1, Integer value2) {
            addCriterion("total_count not between", value1, value2, "totalCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountIsNull() {
            addCriterion("comment_count is null");
            return (Criteria) this;
        }

        public Criteria andCommentCountIsNotNull() {
            addCriterion("comment_count is not null");
            return (Criteria) this;
        }

        public Criteria andCommentCountEqualTo(Integer value) {
            addCriterion("comment_count =", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountNotEqualTo(Integer value) {
            addCriterion("comment_count <>", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountGreaterThan(Integer value) {
            addCriterion("comment_count >", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_count >=", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountLessThan(Integer value) {
            addCriterion("comment_count <", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountLessThanOrEqualTo(Integer value) {
            addCriterion("comment_count <=", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountIn(List<Integer> values) {
            addCriterion("comment_count in", values, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountNotIn(List<Integer> values) {
            addCriterion("comment_count not in", values, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountBetween(Integer value1, Integer value2) {
            addCriterion("comment_count between", value1, value2, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_count not between", value1, value2, "commentCount");
            return (Criteria) this;
        }

        public Criteria andBadgesIsNull() {
            addCriterion("badges is null");
            return (Criteria) this;
        }

        public Criteria andBadgesIsNotNull() {
            addCriterion("badges is not null");
            return (Criteria) this;
        }

        public Criteria andBadgesEqualTo(String value) {
            addCriterion("badges =", value, "badges");
            return (Criteria) this;
        }

        public Criteria andBadgesNotEqualTo(String value) {
            addCriterion("badges <>", value, "badges");
            return (Criteria) this;
        }

        public Criteria andBadgesGreaterThan(String value) {
            addCriterion("badges >", value, "badges");
            return (Criteria) this;
        }

        public Criteria andBadgesGreaterThanOrEqualTo(String value) {
            addCriterion("badges >=", value, "badges");
            return (Criteria) this;
        }

        public Criteria andBadgesLessThan(String value) {
            addCriterion("badges <", value, "badges");
            return (Criteria) this;
        }

        public Criteria andBadgesLessThanOrEqualTo(String value) {
            addCriterion("badges <=", value, "badges");
            return (Criteria) this;
        }

        public Criteria andBadgesLike(String value) {
            addCriterion("badges like", value, "badges");
            return (Criteria) this;
        }

        public Criteria andBadgesNotLike(String value) {
            addCriterion("badges not like", value, "badges");
            return (Criteria) this;
        }

        public Criteria andBadgesIn(List<String> values) {
            addCriterion("badges in", values, "badges");
            return (Criteria) this;
        }

        public Criteria andBadgesNotIn(List<String> values) {
            addCriterion("badges not in", values, "badges");
            return (Criteria) this;
        }

        public Criteria andBadgesBetween(String value1, String value2) {
            addCriterion("badges between", value1, value2, "badges");
            return (Criteria) this;
        }

        public Criteria andBadgesNotBetween(String value1, String value2) {
            addCriterion("badges not between", value1, value2, "badges");
            return (Criteria) this;
        }

        public Criteria andPresaleTextIsNull() {
            addCriterion("presale_text is null");
            return (Criteria) this;
        }

        public Criteria andPresaleTextIsNotNull() {
            addCriterion("presale_text is not null");
            return (Criteria) this;
        }

        public Criteria andPresaleTextEqualTo(String value) {
            addCriterion("presale_text =", value, "presaleText");
            return (Criteria) this;
        }

        public Criteria andPresaleTextNotEqualTo(String value) {
            addCriterion("presale_text <>", value, "presaleText");
            return (Criteria) this;
        }

        public Criteria andPresaleTextGreaterThan(String value) {
            addCriterion("presale_text >", value, "presaleText");
            return (Criteria) this;
        }

        public Criteria andPresaleTextGreaterThanOrEqualTo(String value) {
            addCriterion("presale_text >=", value, "presaleText");
            return (Criteria) this;
        }

        public Criteria andPresaleTextLessThan(String value) {
            addCriterion("presale_text <", value, "presaleText");
            return (Criteria) this;
        }

        public Criteria andPresaleTextLessThanOrEqualTo(String value) {
            addCriterion("presale_text <=", value, "presaleText");
            return (Criteria) this;
        }

        public Criteria andPresaleTextLike(String value) {
            addCriterion("presale_text like", value, "presaleText");
            return (Criteria) this;
        }

        public Criteria andPresaleTextNotLike(String value) {
            addCriterion("presale_text not like", value, "presaleText");
            return (Criteria) this;
        }

        public Criteria andPresaleTextIn(List<String> values) {
            addCriterion("presale_text in", values, "presaleText");
            return (Criteria) this;
        }

        public Criteria andPresaleTextNotIn(List<String> values) {
            addCriterion("presale_text not in", values, "presaleText");
            return (Criteria) this;
        }

        public Criteria andPresaleTextBetween(String value1, String value2) {
            addCriterion("presale_text between", value1, value2, "presaleText");
            return (Criteria) this;
        }

        public Criteria andPresaleTextNotBetween(String value1, String value2) {
            addCriterion("presale_text not between", value1, value2, "presaleText");
            return (Criteria) this;
        }

        public Criteria andPresaleJumpLabelIsNull() {
            addCriterion("presale_jump_label is null");
            return (Criteria) this;
        }

        public Criteria andPresaleJumpLabelIsNotNull() {
            addCriterion("presale_jump_label is not null");
            return (Criteria) this;
        }

        public Criteria andPresaleJumpLabelEqualTo(String value) {
            addCriterion("presale_jump_label =", value, "presaleJumpLabel");
            return (Criteria) this;
        }

        public Criteria andPresaleJumpLabelNotEqualTo(String value) {
            addCriterion("presale_jump_label <>", value, "presaleJumpLabel");
            return (Criteria) this;
        }

        public Criteria andPresaleJumpLabelGreaterThan(String value) {
            addCriterion("presale_jump_label >", value, "presaleJumpLabel");
            return (Criteria) this;
        }

        public Criteria andPresaleJumpLabelGreaterThanOrEqualTo(String value) {
            addCriterion("presale_jump_label >=", value, "presaleJumpLabel");
            return (Criteria) this;
        }

        public Criteria andPresaleJumpLabelLessThan(String value) {
            addCriterion("presale_jump_label <", value, "presaleJumpLabel");
            return (Criteria) this;
        }

        public Criteria andPresaleJumpLabelLessThanOrEqualTo(String value) {
            addCriterion("presale_jump_label <=", value, "presaleJumpLabel");
            return (Criteria) this;
        }

        public Criteria andPresaleJumpLabelLike(String value) {
            addCriterion("presale_jump_label like", value, "presaleJumpLabel");
            return (Criteria) this;
        }

        public Criteria andPresaleJumpLabelNotLike(String value) {
            addCriterion("presale_jump_label not like", value, "presaleJumpLabel");
            return (Criteria) this;
        }

        public Criteria andPresaleJumpLabelIn(List<String> values) {
            addCriterion("presale_jump_label in", values, "presaleJumpLabel");
            return (Criteria) this;
        }

        public Criteria andPresaleJumpLabelNotIn(List<String> values) {
            addCriterion("presale_jump_label not in", values, "presaleJumpLabel");
            return (Criteria) this;
        }

        public Criteria andPresaleJumpLabelBetween(String value1, String value2) {
            addCriterion("presale_jump_label between", value1, value2, "presaleJumpLabel");
            return (Criteria) this;
        }

        public Criteria andPresaleJumpLabelNotBetween(String value1, String value2) {
            addCriterion("presale_jump_label not between", value1, value2, "presaleJumpLabel");
            return (Criteria) this;
        }

        public Criteria andPresaleJumpDataIsNull() {
            addCriterion("presale_jump_data is null");
            return (Criteria) this;
        }

        public Criteria andPresaleJumpDataIsNotNull() {
            addCriterion("presale_jump_data is not null");
            return (Criteria) this;
        }

        public Criteria andPresaleJumpDataEqualTo(String value) {
            addCriterion("presale_jump_data =", value, "presaleJumpData");
            return (Criteria) this;
        }

        public Criteria andPresaleJumpDataNotEqualTo(String value) {
            addCriterion("presale_jump_data <>", value, "presaleJumpData");
            return (Criteria) this;
        }

        public Criteria andPresaleJumpDataGreaterThan(String value) {
            addCriterion("presale_jump_data >", value, "presaleJumpData");
            return (Criteria) this;
        }

        public Criteria andPresaleJumpDataGreaterThanOrEqualTo(String value) {
            addCriterion("presale_jump_data >=", value, "presaleJumpData");
            return (Criteria) this;
        }

        public Criteria andPresaleJumpDataLessThan(String value) {
            addCriterion("presale_jump_data <", value, "presaleJumpData");
            return (Criteria) this;
        }

        public Criteria andPresaleJumpDataLessThanOrEqualTo(String value) {
            addCriterion("presale_jump_data <=", value, "presaleJumpData");
            return (Criteria) this;
        }

        public Criteria andPresaleJumpDataLike(String value) {
            addCriterion("presale_jump_data like", value, "presaleJumpData");
            return (Criteria) this;
        }

        public Criteria andPresaleJumpDataNotLike(String value) {
            addCriterion("presale_jump_data not like", value, "presaleJumpData");
            return (Criteria) this;
        }

        public Criteria andPresaleJumpDataIn(List<String> values) {
            addCriterion("presale_jump_data in", values, "presaleJumpData");
            return (Criteria) this;
        }

        public Criteria andPresaleJumpDataNotIn(List<String> values) {
            addCriterion("presale_jump_data not in", values, "presaleJumpData");
            return (Criteria) this;
        }

        public Criteria andPresaleJumpDataBetween(String value1, String value2) {
            addCriterion("presale_jump_data between", value1, value2, "presaleJumpData");
            return (Criteria) this;
        }

        public Criteria andPresaleJumpDataNotBetween(String value1, String value2) {
            addCriterion("presale_jump_data not between", value1, value2, "presaleJumpData");
            return (Criteria) this;
        }

        public Criteria andVerifyIsNull() {
            addCriterion("verify is null");
            return (Criteria) this;
        }

        public Criteria andVerifyIsNotNull() {
            addCriterion("verify is not null");
            return (Criteria) this;
        }

        public Criteria andVerifyEqualTo(Short value) {
            addCriterion("verify =", value, "verify");
            return (Criteria) this;
        }

        public Criteria andVerifyNotEqualTo(Short value) {
            addCriterion("verify <>", value, "verify");
            return (Criteria) this;
        }

        public Criteria andVerifyGreaterThan(Short value) {
            addCriterion("verify >", value, "verify");
            return (Criteria) this;
        }

        public Criteria andVerifyGreaterThanOrEqualTo(Short value) {
            addCriterion("verify >=", value, "verify");
            return (Criteria) this;
        }

        public Criteria andVerifyLessThan(Short value) {
            addCriterion("verify <", value, "verify");
            return (Criteria) this;
        }

        public Criteria andVerifyLessThanOrEqualTo(Short value) {
            addCriterion("verify <=", value, "verify");
            return (Criteria) this;
        }

        public Criteria andVerifyIn(List<Short> values) {
            addCriterion("verify in", values, "verify");
            return (Criteria) this;
        }

        public Criteria andVerifyNotIn(List<Short> values) {
            addCriterion("verify not in", values, "verify");
            return (Criteria) this;
        }

        public Criteria andVerifyBetween(Short value1, Short value2) {
            addCriterion("verify between", value1, value2, "verify");
            return (Criteria) this;
        }

        public Criteria andVerifyNotBetween(Short value1, Short value2) {
            addCriterion("verify not between", value1, value2, "verify");
            return (Criteria) this;
        }

        public Criteria andNeedMcodeIsNull() {
            addCriterion("need_mcode is null");
            return (Criteria) this;
        }

        public Criteria andNeedMcodeIsNotNull() {
            addCriterion("need_mcode is not null");
            return (Criteria) this;
        }

        public Criteria andNeedMcodeEqualTo(Boolean value) {
            addCriterion("need_mcode =", value, "needMcode");
            return (Criteria) this;
        }

        public Criteria andNeedMcodeNotEqualTo(Boolean value) {
            addCriterion("need_mcode <>", value, "needMcode");
            return (Criteria) this;
        }

        public Criteria andNeedMcodeGreaterThan(Boolean value) {
            addCriterion("need_mcode >", value, "needMcode");
            return (Criteria) this;
        }

        public Criteria andNeedMcodeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("need_mcode >=", value, "needMcode");
            return (Criteria) this;
        }

        public Criteria andNeedMcodeLessThan(Boolean value) {
            addCriterion("need_mcode <", value, "needMcode");
            return (Criteria) this;
        }

        public Criteria andNeedMcodeLessThanOrEqualTo(Boolean value) {
            addCriterion("need_mcode <=", value, "needMcode");
            return (Criteria) this;
        }

        public Criteria andNeedMcodeIn(List<Boolean> values) {
            addCriterion("need_mcode in", values, "needMcode");
            return (Criteria) this;
        }

        public Criteria andNeedMcodeNotIn(List<Boolean> values) {
            addCriterion("need_mcode not in", values, "needMcode");
            return (Criteria) this;
        }

        public Criteria andNeedMcodeBetween(Boolean value1, Boolean value2) {
            addCriterion("need_mcode between", value1, value2, "needMcode");
            return (Criteria) this;
        }

        public Criteria andNeedMcodeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("need_mcode not between", value1, value2, "needMcode");
            return (Criteria) this;
        }

        public Criteria andMcodeTipIsNull() {
            addCriterion("mcode_tip is null");
            return (Criteria) this;
        }

        public Criteria andMcodeTipIsNotNull() {
            addCriterion("mcode_tip is not null");
            return (Criteria) this;
        }

        public Criteria andMcodeTipEqualTo(String value) {
            addCriterion("mcode_tip =", value, "mcodeTip");
            return (Criteria) this;
        }

        public Criteria andMcodeTipNotEqualTo(String value) {
            addCriterion("mcode_tip <>", value, "mcodeTip");
            return (Criteria) this;
        }

        public Criteria andMcodeTipGreaterThan(String value) {
            addCriterion("mcode_tip >", value, "mcodeTip");
            return (Criteria) this;
        }

        public Criteria andMcodeTipGreaterThanOrEqualTo(String value) {
            addCriterion("mcode_tip >=", value, "mcodeTip");
            return (Criteria) this;
        }

        public Criteria andMcodeTipLessThan(String value) {
            addCriterion("mcode_tip <", value, "mcodeTip");
            return (Criteria) this;
        }

        public Criteria andMcodeTipLessThanOrEqualTo(String value) {
            addCriterion("mcode_tip <=", value, "mcodeTip");
            return (Criteria) this;
        }

        public Criteria andMcodeTipLike(String value) {
            addCriterion("mcode_tip like", value, "mcodeTip");
            return (Criteria) this;
        }

        public Criteria andMcodeTipNotLike(String value) {
            addCriterion("mcode_tip not like", value, "mcodeTip");
            return (Criteria) this;
        }

        public Criteria andMcodeTipIn(List<String> values) {
            addCriterion("mcode_tip in", values, "mcodeTip");
            return (Criteria) this;
        }

        public Criteria andMcodeTipNotIn(List<String> values) {
            addCriterion("mcode_tip not in", values, "mcodeTip");
            return (Criteria) this;
        }

        public Criteria andMcodeTipBetween(String value1, String value2) {
            addCriterion("mcode_tip between", value1, value2, "mcodeTip");
            return (Criteria) this;
        }

        public Criteria andMcodeTipNotBetween(String value1, String value2) {
            addCriterion("mcode_tip not between", value1, value2, "mcodeTip");
            return (Criteria) this;
        }

        public Criteria andBuyLimitCountIsNull() {
            addCriterion("buy_limit_count is null");
            return (Criteria) this;
        }

        public Criteria andBuyLimitCountIsNotNull() {
            addCriterion("buy_limit_count is not null");
            return (Criteria) this;
        }

        public Criteria andBuyLimitCountEqualTo(Short value) {
            addCriterion("buy_limit_count =", value, "buyLimitCount");
            return (Criteria) this;
        }

        public Criteria andBuyLimitCountNotEqualTo(Short value) {
            addCriterion("buy_limit_count <>", value, "buyLimitCount");
            return (Criteria) this;
        }

        public Criteria andBuyLimitCountGreaterThan(Short value) {
            addCriterion("buy_limit_count >", value, "buyLimitCount");
            return (Criteria) this;
        }

        public Criteria andBuyLimitCountGreaterThanOrEqualTo(Short value) {
            addCriterion("buy_limit_count >=", value, "buyLimitCount");
            return (Criteria) this;
        }

        public Criteria andBuyLimitCountLessThan(Short value) {
            addCriterion("buy_limit_count <", value, "buyLimitCount");
            return (Criteria) this;
        }

        public Criteria andBuyLimitCountLessThanOrEqualTo(Short value) {
            addCriterion("buy_limit_count <=", value, "buyLimitCount");
            return (Criteria) this;
        }

        public Criteria andBuyLimitCountIn(List<Short> values) {
            addCriterion("buy_limit_count in", values, "buyLimitCount");
            return (Criteria) this;
        }

        public Criteria andBuyLimitCountNotIn(List<Short> values) {
            addCriterion("buy_limit_count not in", values, "buyLimitCount");
            return (Criteria) this;
        }

        public Criteria andBuyLimitCountBetween(Short value1, Short value2) {
            addCriterion("buy_limit_count between", value1, value2, "buyLimitCount");
            return (Criteria) this;
        }

        public Criteria andBuyLimitCountNotBetween(Short value1, Short value2) {
            addCriterion("buy_limit_count not between", value1, value2, "buyLimitCount");
            return (Criteria) this;
        }

        public Criteria andVtalkIdIsNull() {
            addCriterion("vtalk_id is null");
            return (Criteria) this;
        }

        public Criteria andVtalkIdIsNotNull() {
            addCriterion("vtalk_id is not null");
            return (Criteria) this;
        }

        public Criteria andVtalkIdEqualTo(Integer value) {
            addCriterion("vtalk_id =", value, "vtalkId");
            return (Criteria) this;
        }

        public Criteria andVtalkIdNotEqualTo(Integer value) {
            addCriterion("vtalk_id <>", value, "vtalkId");
            return (Criteria) this;
        }

        public Criteria andVtalkIdGreaterThan(Integer value) {
            addCriterion("vtalk_id >", value, "vtalkId");
            return (Criteria) this;
        }

        public Criteria andVtalkIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("vtalk_id >=", value, "vtalkId");
            return (Criteria) this;
        }

        public Criteria andVtalkIdLessThan(Integer value) {
            addCriterion("vtalk_id <", value, "vtalkId");
            return (Criteria) this;
        }

        public Criteria andVtalkIdLessThanOrEqualTo(Integer value) {
            addCriterion("vtalk_id <=", value, "vtalkId");
            return (Criteria) this;
        }

        public Criteria andVtalkIdIn(List<Integer> values) {
            addCriterion("vtalk_id in", values, "vtalkId");
            return (Criteria) this;
        }

        public Criteria andVtalkIdNotIn(List<Integer> values) {
            addCriterion("vtalk_id not in", values, "vtalkId");
            return (Criteria) this;
        }

        public Criteria andVtalkIdBetween(Integer value1, Integer value2) {
            addCriterion("vtalk_id between", value1, value2, "vtalkId");
            return (Criteria) this;
        }

        public Criteria andVtalkIdNotBetween(Integer value1, Integer value2) {
            addCriterion("vtalk_id not between", value1, value2, "vtalkId");
            return (Criteria) this;
        }

        public Criteria andAppraisalVtalkIdIsNull() {
            addCriterion("appraisal_vtalk_id is null");
            return (Criteria) this;
        }

        public Criteria andAppraisalVtalkIdIsNotNull() {
            addCriterion("appraisal_vtalk_id is not null");
            return (Criteria) this;
        }

        public Criteria andAppraisalVtalkIdEqualTo(Integer value) {
            addCriterion("appraisal_vtalk_id =", value, "appraisalVtalkId");
            return (Criteria) this;
        }

        public Criteria andAppraisalVtalkIdNotEqualTo(Integer value) {
            addCriterion("appraisal_vtalk_id <>", value, "appraisalVtalkId");
            return (Criteria) this;
        }

        public Criteria andAppraisalVtalkIdGreaterThan(Integer value) {
            addCriterion("appraisal_vtalk_id >", value, "appraisalVtalkId");
            return (Criteria) this;
        }

        public Criteria andAppraisalVtalkIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("appraisal_vtalk_id >=", value, "appraisalVtalkId");
            return (Criteria) this;
        }

        public Criteria andAppraisalVtalkIdLessThan(Integer value) {
            addCriterion("appraisal_vtalk_id <", value, "appraisalVtalkId");
            return (Criteria) this;
        }

        public Criteria andAppraisalVtalkIdLessThanOrEqualTo(Integer value) {
            addCriterion("appraisal_vtalk_id <=", value, "appraisalVtalkId");
            return (Criteria) this;
        }

        public Criteria andAppraisalVtalkIdIn(List<Integer> values) {
            addCriterion("appraisal_vtalk_id in", values, "appraisalVtalkId");
            return (Criteria) this;
        }

        public Criteria andAppraisalVtalkIdNotIn(List<Integer> values) {
            addCriterion("appraisal_vtalk_id not in", values, "appraisalVtalkId");
            return (Criteria) this;
        }

        public Criteria andAppraisalVtalkIdBetween(Integer value1, Integer value2) {
            addCriterion("appraisal_vtalk_id between", value1, value2, "appraisalVtalkId");
            return (Criteria) this;
        }

        public Criteria andAppraisalVtalkIdNotBetween(Integer value1, Integer value2) {
            addCriterion("appraisal_vtalk_id not between", value1, value2, "appraisalVtalkId");
            return (Criteria) this;
        }

        public Criteria andAppraisalTextIsNull() {
            addCriterion("appraisal_text is null");
            return (Criteria) this;
        }

        public Criteria andAppraisalTextIsNotNull() {
            addCriterion("appraisal_text is not null");
            return (Criteria) this;
        }

        public Criteria andAppraisalTextEqualTo(String value) {
            addCriterion("appraisal_text =", value, "appraisalText");
            return (Criteria) this;
        }

        public Criteria andAppraisalTextNotEqualTo(String value) {
            addCriterion("appraisal_text <>", value, "appraisalText");
            return (Criteria) this;
        }

        public Criteria andAppraisalTextGreaterThan(String value) {
            addCriterion("appraisal_text >", value, "appraisalText");
            return (Criteria) this;
        }

        public Criteria andAppraisalTextGreaterThanOrEqualTo(String value) {
            addCriterion("appraisal_text >=", value, "appraisalText");
            return (Criteria) this;
        }

        public Criteria andAppraisalTextLessThan(String value) {
            addCriterion("appraisal_text <", value, "appraisalText");
            return (Criteria) this;
        }

        public Criteria andAppraisalTextLessThanOrEqualTo(String value) {
            addCriterion("appraisal_text <=", value, "appraisalText");
            return (Criteria) this;
        }

        public Criteria andAppraisalTextLike(String value) {
            addCriterion("appraisal_text like", value, "appraisalText");
            return (Criteria) this;
        }

        public Criteria andAppraisalTextNotLike(String value) {
            addCriterion("appraisal_text not like", value, "appraisalText");
            return (Criteria) this;
        }

        public Criteria andAppraisalTextIn(List<String> values) {
            addCriterion("appraisal_text in", values, "appraisalText");
            return (Criteria) this;
        }

        public Criteria andAppraisalTextNotIn(List<String> values) {
            addCriterion("appraisal_text not in", values, "appraisalText");
            return (Criteria) this;
        }

        public Criteria andAppraisalTextBetween(String value1, String value2) {
            addCriterion("appraisal_text between", value1, value2, "appraisalText");
            return (Criteria) this;
        }

        public Criteria andAppraisalTextNotBetween(String value1, String value2) {
            addCriterion("appraisal_text not between", value1, value2, "appraisalText");
            return (Criteria) this;
        }

        public Criteria andCoinLimitIsNull() {
            addCriterion("coin_limit is null");
            return (Criteria) this;
        }

        public Criteria andCoinLimitIsNotNull() {
            addCriterion("coin_limit is not null");
            return (Criteria) this;
        }

        public Criteria andCoinLimitEqualTo(Short value) {
            addCriterion("coin_limit =", value, "coinLimit");
            return (Criteria) this;
        }

        public Criteria andCoinLimitNotEqualTo(Short value) {
            addCriterion("coin_limit <>", value, "coinLimit");
            return (Criteria) this;
        }

        public Criteria andCoinLimitGreaterThan(Short value) {
            addCriterion("coin_limit >", value, "coinLimit");
            return (Criteria) this;
        }

        public Criteria andCoinLimitGreaterThanOrEqualTo(Short value) {
            addCriterion("coin_limit >=", value, "coinLimit");
            return (Criteria) this;
        }

        public Criteria andCoinLimitLessThan(Short value) {
            addCriterion("coin_limit <", value, "coinLimit");
            return (Criteria) this;
        }

        public Criteria andCoinLimitLessThanOrEqualTo(Short value) {
            addCriterion("coin_limit <=", value, "coinLimit");
            return (Criteria) this;
        }

        public Criteria andCoinLimitIn(List<Short> values) {
            addCriterion("coin_limit in", values, "coinLimit");
            return (Criteria) this;
        }

        public Criteria andCoinLimitNotIn(List<Short> values) {
            addCriterion("coin_limit not in", values, "coinLimit");
            return (Criteria) this;
        }

        public Criteria andCoinLimitBetween(Short value1, Short value2) {
            addCriterion("coin_limit between", value1, value2, "coinLimit");
            return (Criteria) this;
        }

        public Criteria andCoinLimitNotBetween(Short value1, Short value2) {
            addCriterion("coin_limit not between", value1, value2, "coinLimit");
            return (Criteria) this;
        }

        public Criteria andDistribStatusIsNull() {
            addCriterion("distrib_status is null");
            return (Criteria) this;
        }

        public Criteria andDistribStatusIsNotNull() {
            addCriterion("distrib_status is not null");
            return (Criteria) this;
        }

        public Criteria andDistribStatusEqualTo(Short value) {
            addCriterion("distrib_status =", value, "distribStatus");
            return (Criteria) this;
        }

        public Criteria andDistribStatusNotEqualTo(Short value) {
            addCriterion("distrib_status <>", value, "distribStatus");
            return (Criteria) this;
        }

        public Criteria andDistribStatusGreaterThan(Short value) {
            addCriterion("distrib_status >", value, "distribStatus");
            return (Criteria) this;
        }

        public Criteria andDistribStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("distrib_status >=", value, "distribStatus");
            return (Criteria) this;
        }

        public Criteria andDistribStatusLessThan(Short value) {
            addCriterion("distrib_status <", value, "distribStatus");
            return (Criteria) this;
        }

        public Criteria andDistribStatusLessThanOrEqualTo(Short value) {
            addCriterion("distrib_status <=", value, "distribStatus");
            return (Criteria) this;
        }

        public Criteria andDistribStatusIn(List<Short> values) {
            addCriterion("distrib_status in", values, "distribStatus");
            return (Criteria) this;
        }

        public Criteria andDistribStatusNotIn(List<Short> values) {
            addCriterion("distrib_status not in", values, "distribStatus");
            return (Criteria) this;
        }

        public Criteria andDistribStatusBetween(Short value1, Short value2) {
            addCriterion("distrib_status between", value1, value2, "distribStatus");
            return (Criteria) this;
        }

        public Criteria andDistribStatusNotBetween(Short value1, Short value2) {
            addCriterion("distrib_status not between", value1, value2, "distribStatus");
            return (Criteria) this;
        }

        public Criteria andPostModeIsNull() {
            addCriterion("post_mode is null");
            return (Criteria) this;
        }

        public Criteria andPostModeIsNotNull() {
            addCriterion("post_mode is not null");
            return (Criteria) this;
        }

        public Criteria andPostModeEqualTo(Boolean value) {
            addCriterion("post_mode =", value, "postMode");
            return (Criteria) this;
        }

        public Criteria andPostModeNotEqualTo(Boolean value) {
            addCriterion("post_mode <>", value, "postMode");
            return (Criteria) this;
        }

        public Criteria andPostModeGreaterThan(Boolean value) {
            addCriterion("post_mode >", value, "postMode");
            return (Criteria) this;
        }

        public Criteria andPostModeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("post_mode >=", value, "postMode");
            return (Criteria) this;
        }

        public Criteria andPostModeLessThan(Boolean value) {
            addCriterion("post_mode <", value, "postMode");
            return (Criteria) this;
        }

        public Criteria andPostModeLessThanOrEqualTo(Boolean value) {
            addCriterion("post_mode <=", value, "postMode");
            return (Criteria) this;
        }

        public Criteria andPostModeIn(List<Boolean> values) {
            addCriterion("post_mode in", values, "postMode");
            return (Criteria) this;
        }

        public Criteria andPostModeNotIn(List<Boolean> values) {
            addCriterion("post_mode not in", values, "postMode");
            return (Criteria) this;
        }

        public Criteria andPostModeBetween(Boolean value1, Boolean value2) {
            addCriterion("post_mode between", value1, value2, "postMode");
            return (Criteria) this;
        }

        public Criteria andPostModeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("post_mode not between", value1, value2, "postMode");
            return (Criteria) this;
        }

        public Criteria andStarIsNull() {
            addCriterion("star is null");
            return (Criteria) this;
        }

        public Criteria andStarIsNotNull() {
            addCriterion("star is not null");
            return (Criteria) this;
        }

        public Criteria andStarEqualTo(BigDecimal value) {
            addCriterion("star =", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarNotEqualTo(BigDecimal value) {
            addCriterion("star <>", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarGreaterThan(BigDecimal value) {
            addCriterion("star >", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("star >=", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarLessThan(BigDecimal value) {
            addCriterion("star <", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarLessThanOrEqualTo(BigDecimal value) {
            addCriterion("star <=", value, "star");
            return (Criteria) this;
        }

        public Criteria andStarIn(List<BigDecimal> values) {
            addCriterion("star in", values, "star");
            return (Criteria) this;
        }

        public Criteria andStarNotIn(List<BigDecimal> values) {
            addCriterion("star not in", values, "star");
            return (Criteria) this;
        }

        public Criteria andStarBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("star between", value1, value2, "star");
            return (Criteria) this;
        }

        public Criteria andStarNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("star not between", value1, value2, "star");
            return (Criteria) this;
        }

        public Criteria andStarSumIsNull() {
            addCriterion("star_sum is null");
            return (Criteria) this;
        }

        public Criteria andStarSumIsNotNull() {
            addCriterion("star_sum is not null");
            return (Criteria) this;
        }

        public Criteria andStarSumEqualTo(Integer value) {
            addCriterion("star_sum =", value, "starSum");
            return (Criteria) this;
        }

        public Criteria andStarSumNotEqualTo(Integer value) {
            addCriterion("star_sum <>", value, "starSum");
            return (Criteria) this;
        }

        public Criteria andStarSumGreaterThan(Integer value) {
            addCriterion("star_sum >", value, "starSum");
            return (Criteria) this;
        }

        public Criteria andStarSumGreaterThanOrEqualTo(Integer value) {
            addCriterion("star_sum >=", value, "starSum");
            return (Criteria) this;
        }

        public Criteria andStarSumLessThan(Integer value) {
            addCriterion("star_sum <", value, "starSum");
            return (Criteria) this;
        }

        public Criteria andStarSumLessThanOrEqualTo(Integer value) {
            addCriterion("star_sum <=", value, "starSum");
            return (Criteria) this;
        }

        public Criteria andStarSumIn(List<Integer> values) {
            addCriterion("star_sum in", values, "starSum");
            return (Criteria) this;
        }

        public Criteria andStarSumNotIn(List<Integer> values) {
            addCriterion("star_sum not in", values, "starSum");
            return (Criteria) this;
        }

        public Criteria andStarSumBetween(Integer value1, Integer value2) {
            addCriterion("star_sum between", value1, value2, "starSum");
            return (Criteria) this;
        }

        public Criteria andStarSumNotBetween(Integer value1, Integer value2) {
            addCriterion("star_sum not between", value1, value2, "starSum");
            return (Criteria) this;
        }

        public Criteria andStarUsersCountIsNull() {
            addCriterion("star_users_count is null");
            return (Criteria) this;
        }

        public Criteria andStarUsersCountIsNotNull() {
            addCriterion("star_users_count is not null");
            return (Criteria) this;
        }

        public Criteria andStarUsersCountEqualTo(Integer value) {
            addCriterion("star_users_count =", value, "starUsersCount");
            return (Criteria) this;
        }

        public Criteria andStarUsersCountNotEqualTo(Integer value) {
            addCriterion("star_users_count <>", value, "starUsersCount");
            return (Criteria) this;
        }

        public Criteria andStarUsersCountGreaterThan(Integer value) {
            addCriterion("star_users_count >", value, "starUsersCount");
            return (Criteria) this;
        }

        public Criteria andStarUsersCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("star_users_count >=", value, "starUsersCount");
            return (Criteria) this;
        }

        public Criteria andStarUsersCountLessThan(Integer value) {
            addCriterion("star_users_count <", value, "starUsersCount");
            return (Criteria) this;
        }

        public Criteria andStarUsersCountLessThanOrEqualTo(Integer value) {
            addCriterion("star_users_count <=", value, "starUsersCount");
            return (Criteria) this;
        }

        public Criteria andStarUsersCountIn(List<Integer> values) {
            addCriterion("star_users_count in", values, "starUsersCount");
            return (Criteria) this;
        }

        public Criteria andStarUsersCountNotIn(List<Integer> values) {
            addCriterion("star_users_count not in", values, "starUsersCount");
            return (Criteria) this;
        }

        public Criteria andStarUsersCountBetween(Integer value1, Integer value2) {
            addCriterion("star_users_count between", value1, value2, "starUsersCount");
            return (Criteria) this;
        }

        public Criteria andStarUsersCountNotBetween(Integer value1, Integer value2) {
            addCriterion("star_users_count not between", value1, value2, "starUsersCount");
            return (Criteria) this;
        }

        public Criteria andCollectedCountIsNull() {
            addCriterion("collected_count is null");
            return (Criteria) this;
        }

        public Criteria andCollectedCountIsNotNull() {
            addCriterion("collected_count is not null");
            return (Criteria) this;
        }

        public Criteria andCollectedCountEqualTo(Integer value) {
            addCriterion("collected_count =", value, "collectedCount");
            return (Criteria) this;
        }

        public Criteria andCollectedCountNotEqualTo(Integer value) {
            addCriterion("collected_count <>", value, "collectedCount");
            return (Criteria) this;
        }

        public Criteria andCollectedCountGreaterThan(Integer value) {
            addCriterion("collected_count >", value, "collectedCount");
            return (Criteria) this;
        }

        public Criteria andCollectedCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("collected_count >=", value, "collectedCount");
            return (Criteria) this;
        }

        public Criteria andCollectedCountLessThan(Integer value) {
            addCriterion("collected_count <", value, "collectedCount");
            return (Criteria) this;
        }

        public Criteria andCollectedCountLessThanOrEqualTo(Integer value) {
            addCriterion("collected_count <=", value, "collectedCount");
            return (Criteria) this;
        }

        public Criteria andCollectedCountIn(List<Integer> values) {
            addCriterion("collected_count in", values, "collectedCount");
            return (Criteria) this;
        }

        public Criteria andCollectedCountNotIn(List<Integer> values) {
            addCriterion("collected_count not in", values, "collectedCount");
            return (Criteria) this;
        }

        public Criteria andCollectedCountBetween(Integer value1, Integer value2) {
            addCriterion("collected_count between", value1, value2, "collectedCount");
            return (Criteria) this;
        }

        public Criteria andCollectedCountNotBetween(Integer value1, Integer value2) {
            addCriterion("collected_count not between", value1, value2, "collectedCount");
            return (Criteria) this;
        }

        public Criteria andCommentedCountIsNull() {
            addCriterion("commented_count is null");
            return (Criteria) this;
        }

        public Criteria andCommentedCountIsNotNull() {
            addCriterion("commented_count is not null");
            return (Criteria) this;
        }

        public Criteria andCommentedCountEqualTo(Integer value) {
            addCriterion("commented_count =", value, "commentedCount");
            return (Criteria) this;
        }

        public Criteria andCommentedCountNotEqualTo(Integer value) {
            addCriterion("commented_count <>", value, "commentedCount");
            return (Criteria) this;
        }

        public Criteria andCommentedCountGreaterThan(Integer value) {
            addCriterion("commented_count >", value, "commentedCount");
            return (Criteria) this;
        }

        public Criteria andCommentedCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("commented_count >=", value, "commentedCount");
            return (Criteria) this;
        }

        public Criteria andCommentedCountLessThan(Integer value) {
            addCriterion("commented_count <", value, "commentedCount");
            return (Criteria) this;
        }

        public Criteria andCommentedCountLessThanOrEqualTo(Integer value) {
            addCriterion("commented_count <=", value, "commentedCount");
            return (Criteria) this;
        }

        public Criteria andCommentedCountIn(List<Integer> values) {
            addCriterion("commented_count in", values, "commentedCount");
            return (Criteria) this;
        }

        public Criteria andCommentedCountNotIn(List<Integer> values) {
            addCriterion("commented_count not in", values, "commentedCount");
            return (Criteria) this;
        }

        public Criteria andCommentedCountBetween(Integer value1, Integer value2) {
            addCriterion("commented_count between", value1, value2, "commentedCount");
            return (Criteria) this;
        }

        public Criteria andCommentedCountNotBetween(Integer value1, Integer value2) {
            addCriterion("commented_count not between", value1, value2, "commentedCount");
            return (Criteria) this;
        }

        public Criteria andTopCommentsIsNull() {
            addCriterion("top_comments is null");
            return (Criteria) this;
        }

        public Criteria andTopCommentsIsNotNull() {
            addCriterion("top_comments is not null");
            return (Criteria) this;
        }

        public Criteria andTopCommentsEqualTo(String value) {
            addCriterion("top_comments =", value, "topComments");
            return (Criteria) this;
        }

        public Criteria andTopCommentsNotEqualTo(String value) {
            addCriterion("top_comments <>", value, "topComments");
            return (Criteria) this;
        }

        public Criteria andTopCommentsGreaterThan(String value) {
            addCriterion("top_comments >", value, "topComments");
            return (Criteria) this;
        }

        public Criteria andTopCommentsGreaterThanOrEqualTo(String value) {
            addCriterion("top_comments >=", value, "topComments");
            return (Criteria) this;
        }

        public Criteria andTopCommentsLessThan(String value) {
            addCriterion("top_comments <", value, "topComments");
            return (Criteria) this;
        }

        public Criteria andTopCommentsLessThanOrEqualTo(String value) {
            addCriterion("top_comments <=", value, "topComments");
            return (Criteria) this;
        }

        public Criteria andTopCommentsLike(String value) {
            addCriterion("top_comments like", value, "topComments");
            return (Criteria) this;
        }

        public Criteria andTopCommentsNotLike(String value) {
            addCriterion("top_comments not like", value, "topComments");
            return (Criteria) this;
        }

        public Criteria andTopCommentsIn(List<String> values) {
            addCriterion("top_comments in", values, "topComments");
            return (Criteria) this;
        }

        public Criteria andTopCommentsNotIn(List<String> values) {
            addCriterion("top_comments not in", values, "topComments");
            return (Criteria) this;
        }

        public Criteria andTopCommentsBetween(String value1, String value2) {
            addCriterion("top_comments between", value1, value2, "topComments");
            return (Criteria) this;
        }

        public Criteria andTopCommentsNotBetween(String value1, String value2) {
            addCriterion("top_comments not between", value1, value2, "topComments");
            return (Criteria) this;
        }

        public Criteria andBrandNameIsNull() {
            addCriterion("brand_name is null");
            return (Criteria) this;
        }

        public Criteria andBrandNameIsNotNull() {
            addCriterion("brand_name is not null");
            return (Criteria) this;
        }

        public Criteria andBrandNameEqualTo(String value) {
            addCriterion("brand_name =", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotEqualTo(String value) {
            addCriterion("brand_name <>", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameGreaterThan(String value) {
            addCriterion("brand_name >", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameGreaterThanOrEqualTo(String value) {
            addCriterion("brand_name >=", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLessThan(String value) {
            addCriterion("brand_name <", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLessThanOrEqualTo(String value) {
            addCriterion("brand_name <=", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLike(String value) {
            addCriterion("brand_name like", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotLike(String value) {
            addCriterion("brand_name not like", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameIn(List<String> values) {
            addCriterion("brand_name in", values, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotIn(List<String> values) {
            addCriterion("brand_name not in", values, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameBetween(String value1, String value2) {
            addCriterion("brand_name between", value1, value2, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotBetween(String value1, String value2) {
            addCriterion("brand_name not between", value1, value2, "brandName");
            return (Criteria) this;
        }

        public Criteria andDiscussCountIsNull() {
            addCriterion("discuss_count is null");
            return (Criteria) this;
        }

        public Criteria andDiscussCountIsNotNull() {
            addCriterion("discuss_count is not null");
            return (Criteria) this;
        }

        public Criteria andDiscussCountEqualTo(Integer value) {
            addCriterion("discuss_count =", value, "discussCount");
            return (Criteria) this;
        }

        public Criteria andDiscussCountNotEqualTo(Integer value) {
            addCriterion("discuss_count <>", value, "discussCount");
            return (Criteria) this;
        }

        public Criteria andDiscussCountGreaterThan(Integer value) {
            addCriterion("discuss_count >", value, "discussCount");
            return (Criteria) this;
        }

        public Criteria andDiscussCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("discuss_count >=", value, "discussCount");
            return (Criteria) this;
        }

        public Criteria andDiscussCountLessThan(Integer value) {
            addCriterion("discuss_count <", value, "discussCount");
            return (Criteria) this;
        }

        public Criteria andDiscussCountLessThanOrEqualTo(Integer value) {
            addCriterion("discuss_count <=", value, "discussCount");
            return (Criteria) this;
        }

        public Criteria andDiscussCountIn(List<Integer> values) {
            addCriterion("discuss_count in", values, "discussCount");
            return (Criteria) this;
        }

        public Criteria andDiscussCountNotIn(List<Integer> values) {
            addCriterion("discuss_count not in", values, "discussCount");
            return (Criteria) this;
        }

        public Criteria andDiscussCountBetween(Integer value1, Integer value2) {
            addCriterion("discuss_count between", value1, value2, "discussCount");
            return (Criteria) this;
        }

        public Criteria andDiscussCountNotBetween(Integer value1, Integer value2) {
            addCriterion("discuss_count not between", value1, value2, "discussCount");
            return (Criteria) this;
        }

        public Criteria andShareImgIsNull() {
            addCriterion("share_img is null");
            return (Criteria) this;
        }

        public Criteria andShareImgIsNotNull() {
            addCriterion("share_img is not null");
            return (Criteria) this;
        }

        public Criteria andShareImgEqualTo(String value) {
            addCriterion("share_img =", value, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgNotEqualTo(String value) {
            addCriterion("share_img <>", value, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgGreaterThan(String value) {
            addCriterion("share_img >", value, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgGreaterThanOrEqualTo(String value) {
            addCriterion("share_img >=", value, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgLessThan(String value) {
            addCriterion("share_img <", value, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgLessThanOrEqualTo(String value) {
            addCriterion("share_img <=", value, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgLike(String value) {
            addCriterion("share_img like", value, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgNotLike(String value) {
            addCriterion("share_img not like", value, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgIn(List<String> values) {
            addCriterion("share_img in", values, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgNotIn(List<String> values) {
            addCriterion("share_img not in", values, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgBetween(String value1, String value2) {
            addCriterion("share_img between", value1, value2, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgNotBetween(String value1, String value2) {
            addCriterion("share_img not between", value1, value2, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgWidthIsNull() {
            addCriterion("share_img_width is null");
            return (Criteria) this;
        }

        public Criteria andShareImgWidthIsNotNull() {
            addCriterion("share_img_width is not null");
            return (Criteria) this;
        }

        public Criteria andShareImgWidthEqualTo(Integer value) {
            addCriterion("share_img_width =", value, "shareImgWidth");
            return (Criteria) this;
        }

        public Criteria andShareImgWidthNotEqualTo(Integer value) {
            addCriterion("share_img_width <>", value, "shareImgWidth");
            return (Criteria) this;
        }

        public Criteria andShareImgWidthGreaterThan(Integer value) {
            addCriterion("share_img_width >", value, "shareImgWidth");
            return (Criteria) this;
        }

        public Criteria andShareImgWidthGreaterThanOrEqualTo(Integer value) {
            addCriterion("share_img_width >=", value, "shareImgWidth");
            return (Criteria) this;
        }

        public Criteria andShareImgWidthLessThan(Integer value) {
            addCriterion("share_img_width <", value, "shareImgWidth");
            return (Criteria) this;
        }

        public Criteria andShareImgWidthLessThanOrEqualTo(Integer value) {
            addCriterion("share_img_width <=", value, "shareImgWidth");
            return (Criteria) this;
        }

        public Criteria andShareImgWidthIn(List<Integer> values) {
            addCriterion("share_img_width in", values, "shareImgWidth");
            return (Criteria) this;
        }

        public Criteria andShareImgWidthNotIn(List<Integer> values) {
            addCriterion("share_img_width not in", values, "shareImgWidth");
            return (Criteria) this;
        }

        public Criteria andShareImgWidthBetween(Integer value1, Integer value2) {
            addCriterion("share_img_width between", value1, value2, "shareImgWidth");
            return (Criteria) this;
        }

        public Criteria andShareImgWidthNotBetween(Integer value1, Integer value2) {
            addCriterion("share_img_width not between", value1, value2, "shareImgWidth");
            return (Criteria) this;
        }

        public Criteria andShareImgHeightIsNull() {
            addCriterion("share_img_height is null");
            return (Criteria) this;
        }

        public Criteria andShareImgHeightIsNotNull() {
            addCriterion("share_img_height is not null");
            return (Criteria) this;
        }

        public Criteria andShareImgHeightEqualTo(Integer value) {
            addCriterion("share_img_height =", value, "shareImgHeight");
            return (Criteria) this;
        }

        public Criteria andShareImgHeightNotEqualTo(Integer value) {
            addCriterion("share_img_height <>", value, "shareImgHeight");
            return (Criteria) this;
        }

        public Criteria andShareImgHeightGreaterThan(Integer value) {
            addCriterion("share_img_height >", value, "shareImgHeight");
            return (Criteria) this;
        }

        public Criteria andShareImgHeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("share_img_height >=", value, "shareImgHeight");
            return (Criteria) this;
        }

        public Criteria andShareImgHeightLessThan(Integer value) {
            addCriterion("share_img_height <", value, "shareImgHeight");
            return (Criteria) this;
        }

        public Criteria andShareImgHeightLessThanOrEqualTo(Integer value) {
            addCriterion("share_img_height <=", value, "shareImgHeight");
            return (Criteria) this;
        }

        public Criteria andShareImgHeightIn(List<Integer> values) {
            addCriterion("share_img_height in", values, "shareImgHeight");
            return (Criteria) this;
        }

        public Criteria andShareImgHeightNotIn(List<Integer> values) {
            addCriterion("share_img_height not in", values, "shareImgHeight");
            return (Criteria) this;
        }

        public Criteria andShareImgHeightBetween(Integer value1, Integer value2) {
            addCriterion("share_img_height between", value1, value2, "shareImgHeight");
            return (Criteria) this;
        }

        public Criteria andShareImgHeightNotBetween(Integer value1, Integer value2) {
            addCriterion("share_img_height not between", value1, value2, "shareImgHeight");
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

        public Criteria andPurchaseSourceIsNull() {
            addCriterion("purchase_source is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseSourceIsNotNull() {
            addCriterion("purchase_source is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseSourceEqualTo(String value) {
            addCriterion("purchase_source =", value, "purchaseSource");
            return (Criteria) this;
        }

        public Criteria andPurchaseSourceNotEqualTo(String value) {
            addCriterion("purchase_source <>", value, "purchaseSource");
            return (Criteria) this;
        }

        public Criteria andPurchaseSourceGreaterThan(String value) {
            addCriterion("purchase_source >", value, "purchaseSource");
            return (Criteria) this;
        }

        public Criteria andPurchaseSourceGreaterThanOrEqualTo(String value) {
            addCriterion("purchase_source >=", value, "purchaseSource");
            return (Criteria) this;
        }

        public Criteria andPurchaseSourceLessThan(String value) {
            addCriterion("purchase_source <", value, "purchaseSource");
            return (Criteria) this;
        }

        public Criteria andPurchaseSourceLessThanOrEqualTo(String value) {
            addCriterion("purchase_source <=", value, "purchaseSource");
            return (Criteria) this;
        }

        public Criteria andPurchaseSourceLike(String value) {
            addCriterion("purchase_source like", value, "purchaseSource");
            return (Criteria) this;
        }

        public Criteria andPurchaseSourceNotLike(String value) {
            addCriterion("purchase_source not like", value, "purchaseSource");
            return (Criteria) this;
        }

        public Criteria andPurchaseSourceIn(List<String> values) {
            addCriterion("purchase_source in", values, "purchaseSource");
            return (Criteria) this;
        }

        public Criteria andPurchaseSourceNotIn(List<String> values) {
            addCriterion("purchase_source not in", values, "purchaseSource");
            return (Criteria) this;
        }

        public Criteria andPurchaseSourceBetween(String value1, String value2) {
            addCriterion("purchase_source between", value1, value2, "purchaseSource");
            return (Criteria) this;
        }

        public Criteria andPurchaseSourceNotBetween(String value1, String value2) {
            addCriterion("purchase_source not between", value1, value2, "purchaseSource");
            return (Criteria) this;
        }

        public Criteria andStorageTypeIsNull() {
            addCriterion("storage_type is null");
            return (Criteria) this;
        }

        public Criteria andStorageTypeIsNotNull() {
            addCriterion("storage_type is not null");
            return (Criteria) this;
        }

        public Criteria andStorageTypeEqualTo(String value) {
            addCriterion("storage_type =", value, "storageType");
            return (Criteria) this;
        }

        public Criteria andStorageTypeNotEqualTo(String value) {
            addCriterion("storage_type <>", value, "storageType");
            return (Criteria) this;
        }

        public Criteria andStorageTypeGreaterThan(String value) {
            addCriterion("storage_type >", value, "storageType");
            return (Criteria) this;
        }

        public Criteria andStorageTypeGreaterThanOrEqualTo(String value) {
            addCriterion("storage_type >=", value, "storageType");
            return (Criteria) this;
        }

        public Criteria andStorageTypeLessThan(String value) {
            addCriterion("storage_type <", value, "storageType");
            return (Criteria) this;
        }

        public Criteria andStorageTypeLessThanOrEqualTo(String value) {
            addCriterion("storage_type <=", value, "storageType");
            return (Criteria) this;
        }

        public Criteria andStorageTypeLike(String value) {
            addCriterion("storage_type like", value, "storageType");
            return (Criteria) this;
        }

        public Criteria andStorageTypeNotLike(String value) {
            addCriterion("storage_type not like", value, "storageType");
            return (Criteria) this;
        }

        public Criteria andStorageTypeIn(List<String> values) {
            addCriterion("storage_type in", values, "storageType");
            return (Criteria) this;
        }

        public Criteria andStorageTypeNotIn(List<String> values) {
            addCriterion("storage_type not in", values, "storageType");
            return (Criteria) this;
        }

        public Criteria andStorageTypeBetween(String value1, String value2) {
            addCriterion("storage_type between", value1, value2, "storageType");
            return (Criteria) this;
        }

        public Criteria andStorageTypeNotBetween(String value1, String value2) {
            addCriterion("storage_type not between", value1, value2, "storageType");
            return (Criteria) this;
        }

        public Criteria andProductPrepareDaysIsNull() {
            addCriterion("product_prepare_days is null");
            return (Criteria) this;
        }

        public Criteria andProductPrepareDaysIsNotNull() {
            addCriterion("product_prepare_days is not null");
            return (Criteria) this;
        }

        public Criteria andProductPrepareDaysEqualTo(Byte value) {
            addCriterion("product_prepare_days =", value, "productPrepareDays");
            return (Criteria) this;
        }

        public Criteria andProductPrepareDaysNotEqualTo(Byte value) {
            addCriterion("product_prepare_days <>", value, "productPrepareDays");
            return (Criteria) this;
        }

        public Criteria andProductPrepareDaysGreaterThan(Byte value) {
            addCriterion("product_prepare_days >", value, "productPrepareDays");
            return (Criteria) this;
        }

        public Criteria andProductPrepareDaysGreaterThanOrEqualTo(Byte value) {
            addCriterion("product_prepare_days >=", value, "productPrepareDays");
            return (Criteria) this;
        }

        public Criteria andProductPrepareDaysLessThan(Byte value) {
            addCriterion("product_prepare_days <", value, "productPrepareDays");
            return (Criteria) this;
        }

        public Criteria andProductPrepareDaysLessThanOrEqualTo(Byte value) {
            addCriterion("product_prepare_days <=", value, "productPrepareDays");
            return (Criteria) this;
        }

        public Criteria andProductPrepareDaysIn(List<Byte> values) {
            addCriterion("product_prepare_days in", values, "productPrepareDays");
            return (Criteria) this;
        }

        public Criteria andProductPrepareDaysNotIn(List<Byte> values) {
            addCriterion("product_prepare_days not in", values, "productPrepareDays");
            return (Criteria) this;
        }

        public Criteria andProductPrepareDaysBetween(Byte value1, Byte value2) {
            addCriterion("product_prepare_days between", value1, value2, "productPrepareDays");
            return (Criteria) this;
        }

        public Criteria andProductPrepareDaysNotBetween(Byte value1, Byte value2) {
            addCriterion("product_prepare_days not between", value1, value2, "productPrepareDays");
            return (Criteria) this;
        }

        public Criteria andLogisticsInternaDaysIsNull() {
            addCriterion("logistics_interna_days is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsInternaDaysIsNotNull() {
            addCriterion("logistics_interna_days is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsInternaDaysEqualTo(Byte value) {
            addCriterion("logistics_interna_days =", value, "logisticsInternaDays");
            return (Criteria) this;
        }

        public Criteria andLogisticsInternaDaysNotEqualTo(Byte value) {
            addCriterion("logistics_interna_days <>", value, "logisticsInternaDays");
            return (Criteria) this;
        }

        public Criteria andLogisticsInternaDaysGreaterThan(Byte value) {
            addCriterion("logistics_interna_days >", value, "logisticsInternaDays");
            return (Criteria) this;
        }

        public Criteria andLogisticsInternaDaysGreaterThanOrEqualTo(Byte value) {
            addCriterion("logistics_interna_days >=", value, "logisticsInternaDays");
            return (Criteria) this;
        }

        public Criteria andLogisticsInternaDaysLessThan(Byte value) {
            addCriterion("logistics_interna_days <", value, "logisticsInternaDays");
            return (Criteria) this;
        }

        public Criteria andLogisticsInternaDaysLessThanOrEqualTo(Byte value) {
            addCriterion("logistics_interna_days <=", value, "logisticsInternaDays");
            return (Criteria) this;
        }

        public Criteria andLogisticsInternaDaysIn(List<Byte> values) {
            addCriterion("logistics_interna_days in", values, "logisticsInternaDays");
            return (Criteria) this;
        }

        public Criteria andLogisticsInternaDaysNotIn(List<Byte> values) {
            addCriterion("logistics_interna_days not in", values, "logisticsInternaDays");
            return (Criteria) this;
        }

        public Criteria andLogisticsInternaDaysBetween(Byte value1, Byte value2) {
            addCriterion("logistics_interna_days between", value1, value2, "logisticsInternaDays");
            return (Criteria) this;
        }

        public Criteria andLogisticsInternaDaysNotBetween(Byte value1, Byte value2) {
            addCriterion("logistics_interna_days not between", value1, value2, "logisticsInternaDays");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeIsNull() {
            addCriterion("delivery_type is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeIsNotNull() {
            addCriterion("delivery_type is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeEqualTo(String value) {
            addCriterion("delivery_type =", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeNotEqualTo(String value) {
            addCriterion("delivery_type <>", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeGreaterThan(String value) {
            addCriterion("delivery_type >", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeGreaterThanOrEqualTo(String value) {
            addCriterion("delivery_type >=", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeLessThan(String value) {
            addCriterion("delivery_type <", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeLessThanOrEqualTo(String value) {
            addCriterion("delivery_type <=", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeLike(String value) {
            addCriterion("delivery_type like", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeNotLike(String value) {
            addCriterion("delivery_type not like", value, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeIn(List<String> values) {
            addCriterion("delivery_type in", values, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeNotIn(List<String> values) {
            addCriterion("delivery_type not in", values, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeBetween(String value1, String value2) {
            addCriterion("delivery_type between", value1, value2, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andDeliveryTypeNotBetween(String value1, String value2) {
            addCriterion("delivery_type not between", value1, value2, "deliveryType");
            return (Criteria) this;
        }

        public Criteria andWarehouseIsNull() {
            addCriterion("warehouse is null");
            return (Criteria) this;
        }

        public Criteria andWarehouseIsNotNull() {
            addCriterion("warehouse is not null");
            return (Criteria) this;
        }

        public Criteria andWarehouseEqualTo(String value) {
            addCriterion("warehouse =", value, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseNotEqualTo(String value) {
            addCriterion("warehouse <>", value, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseGreaterThan(String value) {
            addCriterion("warehouse >", value, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseGreaterThanOrEqualTo(String value) {
            addCriterion("warehouse >=", value, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseLessThan(String value) {
            addCriterion("warehouse <", value, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseLessThanOrEqualTo(String value) {
            addCriterion("warehouse <=", value, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseLike(String value) {
            addCriterion("warehouse like", value, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseNotLike(String value) {
            addCriterion("warehouse not like", value, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseIn(List<String> values) {
            addCriterion("warehouse in", values, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseNotIn(List<String> values) {
            addCriterion("warehouse not in", values, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseBetween(String value1, String value2) {
            addCriterion("warehouse between", value1, value2, "warehouse");
            return (Criteria) this;
        }

        public Criteria andWarehouseNotBetween(String value1, String value2) {
            addCriterion("warehouse not between", value1, value2, "warehouse");
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
