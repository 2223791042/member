package guet.ty.member.service;

import guet.ty.member.entity.Member;
import guet.ty.member.entity.Payinfo;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by 罗惠铎 on 2019/5/19.
 */
public interface PayinfoService {
    void savePayInfo(Payinfo payInfo);

    void addPayinfo(Payinfo payinfo);

    Map<String, Object> getPayinfoList(Integer payKind, String memberPhone, String memberName, Date startTime, Date endTime, String memberHandler);

    List<Member> payinfoSearchByPhone(String memberPhone);

    List<Payinfo> getMember(String memberPhone);
}
