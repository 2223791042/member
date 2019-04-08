package guet.ty.member.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    SUCCESS("成功", 200),
    NOT_FOUND("未找到", 404),
    FAIL("服务器出错", 500);

    private String desc;
    private Integer code;
    ResultEnum(String desc, Integer code){
        this.desc = desc;
        this.code = code;
    }
}
