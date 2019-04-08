package guet.ty.member.service.impl;

import guet.ty.member.dao.ScheduleMapper;
import guet.ty.member.entity.Schedule;
import guet.ty.member.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private ScheduleMapper scheduleMapper;

    @Override
    public List<Schedule> getScheduleList() {
        return scheduleMapper.selectByExample(null);
    }
}
