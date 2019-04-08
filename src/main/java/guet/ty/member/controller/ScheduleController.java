package guet.ty.member.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import guet.ty.member.VO.TableVO;
import guet.ty.member.entity.Schedule;
import guet.ty.member.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @ResponseBody
    @GetMapping("/schedule/list")
    public TableVO<Schedule> scheduleList(@RequestParam(value = "page", defaultValue = "1") int page,
                                @RequestParam(value = "limit", defaultValue = "5") int limit){
        PageHelper.startPage(page, limit);
        List<Schedule> scheduleList = scheduleService.getScheduleList();
        PageInfo<Schedule> pageInfo = new PageInfo<>(scheduleList);
        return new TableVO<>(pageInfo, pageInfo.getList());
    }

}
