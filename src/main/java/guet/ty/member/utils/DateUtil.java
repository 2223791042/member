package guet.ty.member.utils;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private final static String START="startTime";
    private final static String END="endTime";


    public static Date getStart(HttpServletRequest request){
        return getData(request,START);
    }

    public static Date getEnd(HttpServletRequest request){
        Date endTime = getData(request,END);
        if(endTime!=null) endTime = new Date(endTime.getTime() + 86400000 - 1);
        return endTime;
    }

    public static Date getData(HttpServletRequest request,String type){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try{
            if (request.getParameter(type) != null && !request.getParameter(type).equals("")){
                return simpleDateFormat.parse(request.getParameter(type));
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return null;
    }



}
