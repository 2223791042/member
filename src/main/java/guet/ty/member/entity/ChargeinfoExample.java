package guet.ty.member.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChargeinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ChargeinfoExample() {
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

        public Criteria andChargeIdIsNull() {
            addCriterion("charge_id is null");
            return (Criteria) this;
        }

        public Criteria andChargeIdIsNotNull() {
            addCriterion("charge_id is not null");
            return (Criteria) this;
        }

        public Criteria andChargeIdEqualTo(Long value) {
            addCriterion("charge_id =", value, "chargeId");
            return (Criteria) this;
        }

        public Criteria andChargeIdNotEqualTo(Long value) {
            addCriterion("charge_id <>", value, "chargeId");
            return (Criteria) this;
        }

        public Criteria andChargeIdGreaterThan(Long value) {
            addCriterion("charge_id >", value, "chargeId");
            return (Criteria) this;
        }

        public Criteria andChargeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("charge_id >=", value, "chargeId");
            return (Criteria) this;
        }

        public Criteria andChargeIdLessThan(Long value) {
            addCriterion("charge_id <", value, "chargeId");
            return (Criteria) this;
        }

        public Criteria andChargeIdLessThanOrEqualTo(Long value) {
            addCriterion("charge_id <=", value, "chargeId");
            return (Criteria) this;
        }

        public Criteria andChargeIdIn(List<Long> values) {
            addCriterion("charge_id in", values, "chargeId");
            return (Criteria) this;
        }

        public Criteria andChargeIdNotIn(List<Long> values) {
            addCriterion("charge_id not in", values, "chargeId");
            return (Criteria) this;
        }

        public Criteria andChargeIdBetween(Long value1, Long value2) {
            addCriterion("charge_id between", value1, value2, "chargeId");
            return (Criteria) this;
        }

        public Criteria andChargeIdNotBetween(Long value1, Long value2) {
            addCriterion("charge_id not between", value1, value2, "chargeId");
            return (Criteria) this;
        }

        public Criteria andChargeCardIdIsNull() {
            addCriterion("charge_card_id is null");
            return (Criteria) this;
        }

        public Criteria andChargeCardIdIsNotNull() {
            addCriterion("charge_card_id is not null");
            return (Criteria) this;
        }

        public Criteria andChargeCardIdEqualTo(Long value) {
            addCriterion("charge_card_id =", value, "chargeCardId");
            return (Criteria) this;
        }

        public Criteria andChargeCardIdNotEqualTo(Long value) {
            addCriterion("charge_card_id <>", value, "chargeCardId");
            return (Criteria) this;
        }

        public Criteria andChargeCardIdGreaterThan(Long value) {
            addCriterion("charge_card_id >", value, "chargeCardId");
            return (Criteria) this;
        }

        public Criteria andChargeCardIdGreaterThanOrEqualTo(Long value) {
            addCriterion("charge_card_id >=", value, "chargeCardId");
            return (Criteria) this;
        }

        public Criteria andChargeCardIdLessThan(Long value) {
            addCriterion("charge_card_id <", value, "chargeCardId");
            return (Criteria) this;
        }

        public Criteria andChargeCardIdLessThanOrEqualTo(Long value) {
            addCriterion("charge_card_id <=", value, "chargeCardId");
            return (Criteria) this;
        }

        public Criteria andChargeCardIdIn(List<Long> values) {
            addCriterion("charge_card_id in", values, "chargeCardId");
            return (Criteria) this;
        }

        public Criteria andChargeCardIdNotIn(List<Long> values) {
            addCriterion("charge_card_id not in", values, "chargeCardId");
            return (Criteria) this;
        }

        public Criteria andChargeCardIdBetween(Long value1, Long value2) {
            addCriterion("charge_card_id between", value1, value2, "chargeCardId");
            return (Criteria) this;
        }

        public Criteria andChargeCardIdNotBetween(Long value1, Long value2) {
            addCriterion("charge_card_id not between", value1, value2, "chargeCardId");
            return (Criteria) this;
        }

        public Criteria andChargeMethodIsNull() {
            addCriterion("charge_method is null");
            return (Criteria) this;
        }

        public Criteria andChargeMethodIsNotNull() {
            addCriterion("charge_method is not null");
            return (Criteria) this;
        }

        public Criteria andChargeMethodEqualTo(Integer value) {
            addCriterion("charge_method =", value, "chargeMethod");
            return (Criteria) this;
        }

        public Criteria andChargeMethodNotEqualTo(Integer value) {
            addCriterion("charge_method <>", value, "chargeMethod");
            return (Criteria) this;
        }

        public Criteria andChargeMethodGreaterThan(Integer value) {
            addCriterion("charge_method >", value, "chargeMethod");
            return (Criteria) this;
        }

        public Criteria andChargeMethodGreaterThanOrEqualTo(Integer value) {
            addCriterion("charge_method >=", value, "chargeMethod");
            return (Criteria) this;
        }

        public Criteria andChargeMethodLessThan(Integer value) {
            addCriterion("charge_method <", value, "chargeMethod");
            return (Criteria) this;
        }

        public Criteria andChargeMethodLessThanOrEqualTo(Integer value) {
            addCriterion("charge_method <=", value, "chargeMethod");
            return (Criteria) this;
        }

        public Criteria andChargeMethodIn(List<Integer> values) {
            addCriterion("charge_method in", values, "chargeMethod");
            return (Criteria) this;
        }

        public Criteria andChargeMethodNotIn(List<Integer> values) {
            addCriterion("charge_method not in", values, "chargeMethod");
            return (Criteria) this;
        }

        public Criteria andChargeMethodBetween(Integer value1, Integer value2) {
            addCriterion("charge_method between", value1, value2, "chargeMethod");
            return (Criteria) this;
        }

        public Criteria andChargeMethodNotBetween(Integer value1, Integer value2) {
            addCriterion("charge_method not between", value1, value2, "chargeMethod");
            return (Criteria) this;
        }

        public Criteria andChargeMoneyIsNull() {
            addCriterion("charge_money is null");
            return (Criteria) this;
        }

        public Criteria andChargeMoneyIsNotNull() {
            addCriterion("charge_money is not null");
            return (Criteria) this;
        }

        public Criteria andChargeMoneyEqualTo(BigDecimal value) {
            addCriterion("charge_money =", value, "chargeMoney");
            return (Criteria) this;
        }

        public Criteria andChargeMoneyNotEqualTo(BigDecimal value) {
            addCriterion("charge_money <>", value, "chargeMoney");
            return (Criteria) this;
        }

        public Criteria andChargeMoneyGreaterThan(BigDecimal value) {
            addCriterion("charge_money >", value, "chargeMoney");
            return (Criteria) this;
        }

        public Criteria andChargeMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("charge_money >=", value, "chargeMoney");
            return (Criteria) this;
        }

        public Criteria andChargeMoneyLessThan(BigDecimal value) {
            addCriterion("charge_money <", value, "chargeMoney");
            return (Criteria) this;
        }

        public Criteria andChargeMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("charge_money <=", value, "chargeMoney");
            return (Criteria) this;
        }

        public Criteria andChargeMoneyIn(List<BigDecimal> values) {
            addCriterion("charge_money in", values, "chargeMoney");
            return (Criteria) this;
        }

        public Criteria andChargeMoneyNotIn(List<BigDecimal> values) {
            addCriterion("charge_money not in", values, "chargeMoney");
            return (Criteria) this;
        }

        public Criteria andChargeMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("charge_money between", value1, value2, "chargeMoney");
            return (Criteria) this;
        }

        public Criteria andChargeMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("charge_money not between", value1, value2, "chargeMoney");
            return (Criteria) this;
        }

        public Criteria andChargeTimeIsNull() {
            addCriterion("charge_time is null");
            return (Criteria) this;
        }

        public Criteria andChargeTimeIsNotNull() {
            addCriterion("charge_time is not null");
            return (Criteria) this;
        }

        public Criteria andChargeTimeEqualTo(Date value) {
            addCriterion("charge_time =", value, "chargeTime");
            return (Criteria) this;
        }

        public Criteria andChargeTimeNotEqualTo(Date value) {
            addCriterion("charge_time <>", value, "chargeTime");
            return (Criteria) this;
        }

        public Criteria andChargeTimeGreaterThan(Date value) {
            addCriterion("charge_time >", value, "chargeTime");
            return (Criteria) this;
        }

        public Criteria andChargeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("charge_time >=", value, "chargeTime");
            return (Criteria) this;
        }

        public Criteria andChargeTimeLessThan(Date value) {
            addCriterion("charge_time <", value, "chargeTime");
            return (Criteria) this;
        }

        public Criteria andChargeTimeLessThanOrEqualTo(Date value) {
            addCriterion("charge_time <=", value, "chargeTime");
            return (Criteria) this;
        }

        public Criteria andChargeTimeIn(List<Date> values) {
            addCriterion("charge_time in", values, "chargeTime");
            return (Criteria) this;
        }

        public Criteria andChargeTimeNotIn(List<Date> values) {
            addCriterion("charge_time not in", values, "chargeTime");
            return (Criteria) this;
        }

        public Criteria andChargeTimeBetween(Date value1, Date value2) {
            addCriterion("charge_time between", value1, value2, "chargeTime");
            return (Criteria) this;
        }

        public Criteria andChargeTimeNotBetween(Date value1, Date value2) {
            addCriterion("charge_time not between", value1, value2, "chargeTime");
            return (Criteria) this;
        }

        public Criteria andChargeHandlerIsNull() {
            addCriterion("charge_handler is null");
            return (Criteria) this;
        }

        public Criteria andChargeHandlerIsNotNull() {
            addCriterion("charge_handler is not null");
            return (Criteria) this;
        }

        public Criteria andChargeHandlerEqualTo(String value) {
            addCriterion("charge_handler =", value, "chargeHandler");
            return (Criteria) this;
        }

        public Criteria andChargeHandlerNotEqualTo(String value) {
            addCriterion("charge_handler <>", value, "chargeHandler");
            return (Criteria) this;
        }

        public Criteria andChargeHandlerGreaterThan(String value) {
            addCriterion("charge_handler >", value, "chargeHandler");
            return (Criteria) this;
        }

        public Criteria andChargeHandlerGreaterThanOrEqualTo(String value) {
            addCriterion("charge_handler >=", value, "chargeHandler");
            return (Criteria) this;
        }

        public Criteria andChargeHandlerLessThan(String value) {
            addCriterion("charge_handler <", value, "chargeHandler");
            return (Criteria) this;
        }

        public Criteria andChargeHandlerLessThanOrEqualTo(String value) {
            addCriterion("charge_handler <=", value, "chargeHandler");
            return (Criteria) this;
        }

        public Criteria andChargeHandlerLike(String value) {
            addCriterion("charge_handler like", value, "chargeHandler");
            return (Criteria) this;
        }

        public Criteria andChargeHandlerNotLike(String value) {
            addCriterion("charge_handler not like", value, "chargeHandler");
            return (Criteria) this;
        }

        public Criteria andChargeHandlerIn(List<String> values) {
            addCriterion("charge_handler in", values, "chargeHandler");
            return (Criteria) this;
        }

        public Criteria andChargeHandlerNotIn(List<String> values) {
            addCriterion("charge_handler not in", values, "chargeHandler");
            return (Criteria) this;
        }

        public Criteria andChargeHandlerBetween(String value1, String value2) {
            addCriterion("charge_handler between", value1, value2, "chargeHandler");
            return (Criteria) this;
        }

        public Criteria andChargeHandlerNotBetween(String value1, String value2) {
            addCriterion("charge_handler not between", value1, value2, "chargeHandler");
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