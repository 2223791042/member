package guet.ty.member.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import guet.ty.member.VO.ResultVO;
import guet.ty.member.VO.TableVO;
import guet.ty.member.entity.Schedule;
import guet.ty.member.service.ScheduleService;
import guet.ty.member.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @ResponseBody
    @GetMapping("/schedule/checkScheduleName/{scheduleName}")
    public ResultVO checkScheduleName(@PathVariable("scheduleName") String scheduleName){
        Schedule schedule = scheduleService.getSchedule(scheduleName);
        if (schedule != null){
            return ResultUtil.found();
        }
        return ResultUtil.notFound();
    }

    @ResponseBody
    @PostMapping("/schedule")
    public ResultVO scheduleAdd(Schedule schedule){
        try{
            scheduleService.saveSchedule(schedule);
            return ResultUtil.success();
        }catch (Exception e){
            return ResultUtil.fail();
        }
    }

}
