package guet.ty.member.service;

import guet.ty.member.entity.ExchangeRecord;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ExchangeRecordService {

    Map<String,Object> getRecordList(Long goodsId, String goodsName, Date from, Date to);

    void saveExchangeRecord(ExchangeRecord record);

}
