package guet.ty.member.service;

import guet.ty.member.entity.Schedule;

import java.util.List;

public interface ScheduleService {
    List<Schedule> getScheduleList();

    Schedule getSchedule(String scheduleName);

    void saveSchedule(Schedule schedule);

    Schedule getSchedule(Long scheduleId);

    void editSchedule(Schedule schedule);

    void delSchedule(Long scheduleId);
}
