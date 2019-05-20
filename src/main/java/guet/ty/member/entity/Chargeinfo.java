package guet.ty.member.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Chargeinfo {
    private Long chargeId;

    private Long chargeCardId;

    private Integer chargeMethod;

    private BigDecimal chargeMoney;

    private Date chargeTime;

    private String chargeHandler;

    public Long getChargeId() {
        return chargeId;
    }

    public void setChargeId(Long chargeId) {
        this.chargeId = chargeId;
    }

    public Long getChargeCardId() {
        return chargeCardId;
    }

    public void setChargeCardId(Long chargeCardId) {
        this.chargeCardId = chargeCardId;
    }

    public Integer getChargeMethod() {
        return chargeMethod;
    }

    public void setChargeMethod(Integer chargeMethod) {
        this.chargeMethod = chargeMethod;
    }

    public BigDecimal getChargeMoney() {
        return chargeMoney;
    }

    public void setChargeMoney(BigDecimal chargeMoney) {
        this.chargeMoney = chargeMoney;
    }

    public Date getChargeTime() {
        return chargeTime;
    }

    public void setChargeTime(Date chargeTime) {
        this.chargeTime = chargeTime;
    }

    public String getChargeHandler() {
        return chargeHandler;
    }

    public void setChargeHandler(String chargeHandler) {
        this.chargeHandler = chargeHandler == null ? null : chargeHandler.trim();
    }
}