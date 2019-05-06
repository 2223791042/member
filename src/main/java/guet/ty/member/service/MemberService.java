package guet.ty.member.service;

import guet.ty.member.entity.Member;

import java.util.Date;
import java.util.List;

public interface MemberService {
    void saveMember(Member member);

    List<Member> getMemberList(Integer memberGrade, String memberName, String memberPhone, Date startTime, Date endTime, String memberHandler);

    Member getMember(Long memberId);

    void editMemeber(Member member);

    Member getMember(String memberPhone);
}
