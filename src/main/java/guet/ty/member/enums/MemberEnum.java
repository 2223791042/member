package guet.ty.member.enums;

import lombok.Getter;

@Getter
public enum MemberEnum {

    ORDINARY("普通", 0),
    VIP("VIP", 1),
    GUEST("贵宾", 2);

    private String desc;
    private Integer grade;
    MemberEnum(String desc, Integer grade){
        this.desc = desc;
        this.grade = grade;
    }
}
