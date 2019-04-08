package guet.ty.member.enums;

import lombok.Getter;

@Getter
public enum ScheduleEnum {

    FINISHED("完成", 0),
    UNFINISHED("未完成", 1);

    private String desc;
    private Integer scheduleStatus;

    ScheduleEnum(String desc, Integer scheduleStatus){
        this.desc = desc;
        this.scheduleStatus = scheduleStatus;
    }
}
