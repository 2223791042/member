package guet.ty.member.service.impl;

import guet.ty.member.dao.ScheduleMapper;
import guet.ty.member.entity.Schedule;
import guet.ty.member.entity.ScheduleExample;
import guet.ty.member.enums.ScheduleEnum;
import guet.ty.member.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private ScheduleMapper scheduleMapper;

    @Override
    public List<Schedule> getScheduleList() {
        return scheduleMapper.selectByExample(null);
    }

    @Override
    public Schedule getSchedule(String scheduleName) {
        ScheduleExample example = new ScheduleExample();
        ScheduleExample.Criteria criteria = example.createCriteria();
        criteria.andScheduleNameEqualTo(scheduleName);
        List<Schedule> scheduleList = scheduleMapper.selectByExample(example);
        if (scheduleList.size() != 0){
            return scheduleList.get(0);
        }
        return null;
    }

    @Transactional
    @Override
    public void saveSchedule(Schedule schedule) {
        schedule.setScheduleStatus(ScheduleEnum.UNFINISHED.getScheduleStatus());
        scheduleMapper.insertSelective(schedule);
    }

    @Override
    public Schedule getSchedule(Long scheduleId) {
        return scheduleMapper.selectByPrimaryKey(scheduleId);
    }

    @Transactional
    @Override
    public void editSchedule(Schedule schedule) {
        scheduleMapper.updateByPrimaryKeySelective(schedule);
    }

    @Transactional
    @Override
    public void delSchedule(Long scheduleId) {
        scheduleMapper.deleteByPrimaryKey(scheduleId);
    }
}
