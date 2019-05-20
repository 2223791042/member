package guet.ty.member.dto;

import java.math.BigDecimal;
import java.util.Date;

public class PayinfoDTO {
    private String memberName;

    private String cardId;

    private Integer memberGrade;

    private Integer payKind;

    private BigDecimal payMoney;

    private Integer payMethod;

    private Date payTime;

    private String payHandler;

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public Integer getMemberGrade() {
        return memberGrade;
    }

    public void setMemberGrade(Integer memberGrade) {
        this.memberGrade = memberGrade;
    }

    public Integer getPayKind() {
        return payKind;
    }

    public void setPayKind(Integer payKind) {
        this.payKind = payKind;
    }

    public BigDecimal getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(BigDecimal payMoney) {
        this.payMoney = payMoney;
    }

    public Integer getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(Integer payMethod) {
        this.payMethod = payMethod;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getPayHandler() {
        return payHandler;
    }

    public void setPayHandler(String payHandler) {
        this.payHandler = payHandler;
    }
}
