package guet.ty.member.service.impl;

import guet.ty.member.dao.MemberMapper;
import guet.ty.member.entity.Member;
import guet.ty.member.entity.MemberExample;
import guet.ty.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Transactional
    @Override
    public void saveMember(Member member) {
        memberMapper.insertSelective(member);
    }

    @Override
    public List<Member> getMemberList(Integer memberGrade, String memberName, String memberPhone, Date startTime, Date endTime, String memberHandler) {
        MemberExample example = new MemberExample();
        MemberExample.Criteria criteria = example.createCriteria();
        criteria.andMemberGradeEqualTo(memberGrade);
        if (memberName != null && !memberName.trim().equals("")){
            criteria.andMemberNameLike("%"+memberName+"%");
        }
        if (memberPhone != null && !memberPhone.trim().equals("")){
            criteria.andMemberPhoneEqualTo(memberPhone);
        }
        if (startTime != null){
            criteria.andMemberJoinTimeGreaterThanOrEqualTo(startTime);
        }
        if (endTime != null){
            criteria.andMemberJoinTimeLessThanOrEqualTo(endTime);
        }
        if (memberHandler != null && !memberHandler.trim().equals("")){
            criteria.andMemberHandlerEqualTo(memberHandler);
        }
        return memberMapper.selectByExample(example);
    }

    @Override
    public Member getMember(Long memberId) {
        return memberMapper.selectByPrimaryKey(memberId);
    }

    @Transactional
    @Override
    public void editMemeber(Member member) {
        memberMapper.updateByPrimaryKeySelective(member);
    }

    @Override
    public Member getMember(String memberPhone) {
        MemberExample example = new MemberExample();
        MemberExample.Criteria criteria = example.createCriteria();
        criteria.andMemberPhoneEqualTo(memberPhone);
        List<Member> memberList = memberMapper.selectByExample(example);
        if (memberList.size() != 0){
            return memberList.get(0);
        }
        return null;
    }
}
