package guet.ty.member.utils;

import guet.ty.member.VO.ResultVO;
import guet.ty.member.enums.ResultEnum;

public class ResultUtil {

    public static ResultVO success(String msg, Object data){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(ResultEnum.SUCCESS.getCode());
        resultVO.setMsg(msg);
        resultVO.setData(data);
        return resultVO;
    }

    public static ResultVO fail(String msg, Object data){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(ResultEnum.FAIL.getCode());
        resultVO.setMsg(msg);
        resultVO.setData(data);
        return resultVO;
    }

    public static ResultVO success(String msg){
        return success(msg, null);
    }

    public static ResultVO success(){
        return success("成功");
    }

    public static ResultVO fail(String msg){
        return fail(msg, null);
    }

    public static ResultVO fail(){
        return fail("失败");
    }

}
