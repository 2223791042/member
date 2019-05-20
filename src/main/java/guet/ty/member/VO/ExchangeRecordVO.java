package guet.ty.member.VO;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ExchangeRecordVO {
    private Long recordId;

    private Long recordGoodsId;

    private String recordCardId;

    private Integer recordExchangeNum;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date recordExchangeTime;

    private String recordHandler;

    private String memberName;

    private String goodsName;

    private BigDecimal goodsPoints;

}