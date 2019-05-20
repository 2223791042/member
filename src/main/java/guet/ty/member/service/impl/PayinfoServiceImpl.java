package guet.ty.member.service.impl;

import com.github.pagehelper.PageInfo;
import guet.ty.member.dao.CardMapper;
import guet.ty.member.dao.MemberMapper;
import guet.ty.member.dao.PayinfoMapper;
import guet.ty.member.dto.PayinfoDTO;
import guet.ty.member.entity.*;
import guet.ty.member.service.PayinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by 罗惠铎 on 2019/5/19.
 */
@Service
public class PayinfoServiceImpl implements PayinfoService {
    @Autowired
    private CardMapper cardMapper;
    @Autowired
    private PayinfoMapper payinfoMapper;
    @Autowired
    private MemberMapper memberMapper;

    @Transactional
    @Override
    public void savePayInfo(Payinfo payInfo) {
        payinfoMapper.insertSelective(payInfo);
        Card saveCard = cardMapper.selectByPrimaryKey(payInfo.getPayCardId().toString());
        if (payInfo.getPayMethod() == 0){
            saveCard.setCardBalance(saveCard.getCardBalance().subtract(payInfo.getPayMoney()));
        }
        saveCard.setCardPayTimes(saveCard.getCardPayTimes() + 1);
        saveCard.setCardPayMoney(saveCard.getCardPayMoney().add(payInfo.getPayMoney()));
        saveCard.setCardPoints(saveCard.getCardPoints().add(payInfo.getPayMoney()));
        cardMapper.updateByPrimaryKeySelective(saveCard);
    }


    @Override
    public Map<String, Object> getPayinfoList(int payKind, String memberPhone, Date startTime, Date endTime) {
        PayinfoExample payinfoExample = new PayinfoExample();
        PayinfoExample.Criteria payinfoCriteria = payinfoExample.createCriteria();
        payinfoCriteria.andPayKindEqualTo(payKind);
        if (memberPhone != null && !memberPhone.trim().equals("")){
            payinfoCriteria.andPayCardIdEqualTo(Long.parseLong(memberPhone));
        }
        if (startTime != null){
            payinfoCriteria.andPayTimeGreaterThanOrEqualTo(startTime);
        }
        if (endTime != null){
            payinfoCriteria.andPayTimeLessThanOrEqualTo(endTime);
        }
        List<Payinfo> payinfoList = payinfoMapper.selectByExample(payinfoExample);
        PageInfo<Payinfo> pageInfo = new PageInfo<>(payinfoList);
        Map<String, Object> map = new HashMap<>();
        map.put("pageInfo", pageInfo);
        List<PayinfoDTO> payinfoDTOList = new ArrayList<>();
        for (Payinfo payinfo : payinfoList){
            PayinfoDTO payinfoDTO = new PayinfoDTO();
            Card card = cardMapper.selectByPrimaryKey(payinfo.getPayCardId().toString());
            MemberExample memberExample = new MemberExample();
            MemberExample.Criteria criteria = memberExample.createCriteria();
            criteria.andMemberPhoneEqualTo(card.getCardId());
            List<Member> memberList = memberMapper.selectByExample(memberExample);
            Member member = memberList.get(0);
            payinfoDTO.setCardId(payinfo.getPayCardId().toString());
            payinfoDTO.setMemberGrade(card.getCardGrade());
            payinfoDTO.setPayDesc(payinfo.getPayDesc());
            payinfoDTO.setPayHandler(payinfo.getPayHandler());
            payinfoDTO.setMemberName(member.getMemberName());
            payinfoDTO.setPayKind(payinfo.getPayKind());
            payinfoDTO.setPayMoney(payinfo.getPayMoney());
            payinfoDTO.setPayMethod(payinfo.getPayMethod());
            payinfoDTO.setPayTime(payinfo.getPayTime());
            payinfoDTOList.add(payinfoDTO);
        }
        map.put("payinfoDTOList", payinfoDTOList);
        return map;
    }

    @Override
    public List<Payinfo> getMember(String memberPhone) {
        PayinfoExample payinfoExample = new PayinfoExample();
        PayinfoExample.Criteria criteria = payinfoExample.createCriteria();
        criteria.andPayCardIdEqualTo(Long.parseLong(memberPhone));
        return payinfoMapper.selectByExample(payinfoExample);

    }

    @Override
    public List<Member> payinfoSearchByPhone(String memberPhone)
    {
        MemberExample memberExample1 = new MemberExample();
        MemberExample.Criteria memCriteria1 = memberExample1.createCriteria();
        memCriteria1.andMemberPhoneEqualTo(memberPhone);
        return memberMapper.selectByExample(memberExample1);
    }
}
