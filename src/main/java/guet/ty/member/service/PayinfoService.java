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

    Map<String, Object> getPayinfoList(int payKind, String memberPhone, Date startTime, Date endTime);

    List<Member> payinfoSearchByPhone(String memberPhone);

    List<Payinfo> getMember(String memberPhone);
}
