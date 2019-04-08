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

    /**
     * 获取日程列表数据
     * @param page 页号
     * @param limit 页面大小
     * @return 数据
     */
    @ResponseBody
    @GetMapping("/schedule/list")
    public TableVO<Schedule> scheduleList(@RequestParam(value = "page", defaultValue = "1") int page,
                                @RequestParam(value = "limit", defaultValue = "5") int limit){
        PageHelper.startPage(page, limit);
        List<Schedule> scheduleList = scheduleService.getScheduleList();
        PageInfo<Schedule> pageInfo = new PageInfo<>(scheduleList);
        return new TableVO<>(pageInfo, pageInfo.getList());
    }

    /**
     * 查询日程名称是否重复
     * @param scheduleName 日程名称
     * @return found存在 notFound不存在
     */
    @ResponseBody
    @GetMapping("/schedule/checkScheduleName/{scheduleName}")
    public ResultVO checkScheduleName(@PathVariable("scheduleName") String scheduleName){
        Schedule schedule = scheduleService.getSchedule(scheduleName);
        if (schedule != null){
            return ResultUtil.found();
        }
        return ResultUtil.notFound();
    }

    /**
     * 添加日程（添加数据）
     * @param schedule 日程信息
     * @return 添加成功与否
     */
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

    /**
     * 获取指定日程
     * @param scheduleId 日程id
     * @return 指定日程信息
     */
    @ResponseBody
    @GetMapping("/schedule/{scheduleId}")
    public ResultVO scheduleEdit(@PathVariable("scheduleId") Long scheduleId){
        Schedule schedule = scheduleService.getSchedule(scheduleId);
        if (schedule != null){
            return ResultUtil.success("查询成功", schedule);
        }
        return ResultUtil.fail("查询失败");
    }

    /**
     * 修改指定日程
     * @param scheduleId 日程id
     * @param schedule 日程修改信息
     * @return 修改成功与否
     */
    @ResponseBody
    @PutMapping("/schedule/{scheduleId}")
    public ResultVO scheduleEdit(@PathVariable("scheduleId") Long scheduleId, Schedule schedule){
        schedule.setScheduleId(scheduleId);
        try{
            scheduleService.editSchedule(schedule);
            return ResultUtil.success();
        }catch (Exception e){
            return ResultUtil.fail();
        }
    }

    /**
     * 删除指定id日程
     * @param scheduleId 日程id
     * @return 删除与否
     */
    @ResponseBody
    @DeleteMapping("/schedule/{scheduleId}")
    public ResultVO scheduleDel(@PathVariable("scheduleId") Long scheduleId){
        try{
            scheduleService.delSchedule(scheduleId);
            return ResultUtil.success();
        }catch (Exception e){
            return ResultUtil.fail();
        }
    }
}
