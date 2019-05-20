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
        payInfo.setPayTime(new Date());
        payinfoMapper.insert(payInfo);
        Card card=cardMapper.selectByPrimaryKey(payInfo.getPayCardId()+"");
        card.setCardPayTimes(card.getCardPayTimes()+1);
        card.setCardPayMoney(card.getCardPayMoney().add(payInfo.getPayMoney()));
        card.setCardPoints(card.getCardPoints().add(payInfo.getPayMoney()));
        cardMapper.updateByPrimaryKey(card);
    }

    @Transactional
    @Override
    public void addPayinfo(Payinfo payinfo) {
        payinfoMapper.insertSelective(payinfo);
    }

    @Override
    public Map<String, Object> getPayinfoList(Integer payKind, String memberPhone, String memberName, Date startTime, Date endTime, String memberHandler) {
        List<PayinfoDTO> PayinfoList = new ArrayList();
        PayinfoExample payinfoExample = new PayinfoExample();
        PayinfoExample.Criteria criteria = payinfoExample.createCriteria();
        criteria.andPayKindEqualTo(payKind);

        //根据会员手机查询
        if (memberPhone != null && !memberPhone.trim().equals("")) {
            MemberExample memberExample1 = new MemberExample();
            MemberExample.Criteria memCriteria1 = memberExample1.createCriteria();
            memCriteria1.andMemberPhoneEqualTo(memberPhone);
            List<Member> members = memberMapper.selectByExample(memberExample1);
            for (Member member : members) {
                criteria.andPayCardIdEqualTo(Long.parseLong(member.getMemberPhone()));

            }
        }

        //根据会员姓名模糊查询
        if (memberName != null && !memberName.trim().equals("")) {
            MemberExample memberExample1 = new MemberExample();
            MemberExample.Criteria memCriteria1 = memberExample1.createCriteria();
            memCriteria1.andMemberNameEqualTo(memberName);
            List<Member> members = memberMapper.selectByExample(memberExample1);
            for (Member member : members) {
                criteria.andPayCardIdEqualTo(Long.parseLong(member.getMemberPhone()));
            }
        }

        //根据消费时间查询
        /*if (payinfoTime != null) {
            criteria.andPayTimeEqualTo(payinfoTime);

        }*/

        if (startTime != null){  //>=
            criteria.andPayTimeGreaterThanOrEqualTo(startTime);
        }
        if (endTime != null){ //<=
            criteria.andPayTimeLessThanOrEqualTo(endTime);
        }

        List<Payinfo> payinfos= payinfoMapper.selectByExample(payinfoExample);

        for (Payinfo payinfo : payinfos) {
            MemberExample example = new MemberExample();
            MemberExample.Criteria memberCriteria = example.createCriteria();
            memberCriteria.andMemberPhoneEqualTo(payinfo.getPayCardId().toString());
            List<Member> memberList = memberMapper.selectByExample(example);
            PayinfoDTO payinfoDTO = new PayinfoDTO();
            payinfoDTO.setCardId(String.valueOf(payinfo.getPayCardId()));
            if (memberList.size() != 0){
                payinfoDTO.setMemberName(memberList.get(0).getMemberName());
                payinfoDTO.setMemberGrade(memberList.get(0).getMemberGrade());
            }
            payinfoDTO.setPayKind(payinfo.getPayKind());
            payinfoDTO.setPayMoney(payinfo.getPayMoney());
            payinfoDTO.setPayMethod(payinfo.getPayMethod());
            payinfoDTO.setPayTime(payinfo.getPayTime());
            payinfoDTO.setPayHandler(payinfo.getPayHandler());
            PayinfoList.add(payinfoDTO);
        }
        PageInfo pageInfo=new PageInfo<>(payinfos);
        Map<String,Object> map=new HashMap<>();
        map.put("PayinfoList",PayinfoList);
        map.put("pageInfo",pageInfo);
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
        /*List<PayinfoDTO> PayinfoList = new ArrayList();
        List<Payinfo> payinfoList = getMember(memberPhone);
        for(Payinfo payinfo:payinfoList) {
            MemberExample memberExample1 = new MemberExample();
            MemberExample.Criteria memCriteria1 = memberExample1.createCriteria();
            memCriteria1.andMemberPhoneEqualTo(memberPhone);

            PayinfoDTO payinfoDTO = new PayinfoDTO();
            payinfoDTO.setCardId(String.valueOf(payinfo.getPayCardId()));
            payinfoDTO.setMemberName(memberMapper.selectByExample(memberExample1).get(0).getMemberName());
            payinfoDTO.setMemberGrade(memberMapper.selectByExample(memberExample1).get(0).getMemberGrade());
            payinfoDTO.setPayKind(payinfo.getPayKind());
            payinfoDTO.setPayMoney(payinfo.getPayMoney());
            payinfoDTO.setPayMethod(payinfo.getPayMethod());
            payinfoDTO.setPayTime(payinfo.getPayTime());
            payinfoDTO.setPayHandler(payinfo.getPayHandler());

            PayinfoList.add(payinfoDTO);
        }
        return PayinfoList;*/
    }
}
