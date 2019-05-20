package guet.ty.member.VO;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 会员id(精确) 会员姓名(模糊) 开卡时间(xxx-xxx) 查询
 *会员id 会员姓名 会员等级 余额 积分 累计充值次数 累计充值金额 累计消费次数 累计消费金额 开卡时间
 */
@Data
public class CardListVO {
    private String cardId;//会员id

    private String memberName;//会员姓名

    private Integer memberGrade;//会员等级

    private BigDecimal cardBalance;//余额

    private BigDecimal cardPoints;//积分

    private Date cardCreateTime;//开卡时间

    private Integer cardPayTimes;//累计消费次数

    private BigDecimal cardPayMoney;//累计消费金额

    private Integer cardChargeTimes;//累计充值次数

    private BigDecimal cardChargeMomey;//累计充值金额
}
