package guet.ty.member.service.impl;

import guet.ty.member.dao.ScheduleMapper;
import guet.ty.member.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private ScheduleMapper scheduleMapper;

}
