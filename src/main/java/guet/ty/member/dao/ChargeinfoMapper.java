package guet.ty.member.dao;

import guet.ty.member.entity.Chargeinfo;
import guet.ty.member.entity.ChargeinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChargeinfoMapper {
    int countByExample(ChargeinfoExample example);

    int deleteByExample(ChargeinfoExample example);

    int deleteByPrimaryKey(Long chargeId);

    int insert(Chargeinfo record);

    int insertSelective(Chargeinfo record);

    List<Chargeinfo> selectByExample(ChargeinfoExample example);

    Chargeinfo selectByPrimaryKey(Long chargeId);

    int updateByExampleSelective(@Param("record") Chargeinfo record, @Param("example") ChargeinfoExample example);

    int updateByExample(@Param("record") Chargeinfo record, @Param("example") ChargeinfoExample example);

    int updateByPrimaryKeySelective(Chargeinfo record);

    int updateByPrimaryKey(Chargeinfo record);
}