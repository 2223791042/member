package guet.ty.member.service.impl;

import com.github.pagehelper.PageInfo;
import guet.ty.member.VO.ExchangeRecordVO;
import guet.ty.member.dao.ExchangeRecordMapper;
import guet.ty.member.dao.GoodsMapper;
import guet.ty.member.dao.MemberMapper;
import guet.ty.member.entity.*;
import guet.ty.member.service.ExchangeRecordService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

@Service
public class ExchangeRecordServiceImpl implements ExchangeRecordService {
    @Resource
    private ExchangeRecordMapper exchangeRecordMapper;

    @Resource
    private GoodsMapper goodsMapper;

    @Resource
    private MemberMapper memberMapper;

    @Transactional
    @Override
    public Map<String,Object> getRecordList(Long goodsId, String goodsName, Date startTime, Date endTime) {
        ExchangeRecordExample example = new ExchangeRecordExample();
        ExchangeRecordExample.Criteria criteria = example.createCriteria();

        if(goodsId!=null) {
            criteria.andRecordGoodsIdEqualTo(goodsId);
        }

        GoodsExample goodsExample = new GoodsExample();
        GoodsExample.Criteria goodsCriteria = goodsExample.createCriteria();

        if(goodsName != null && !goodsName.trim().equals("")){  //商品名模糊查询-->>
            goodsCriteria.andGoodsNameLike("%"+goodsName+"%");
            List<Goods> goods = goodsMapper.selectByExample(goodsExample); //查出商品对象 -->>

            List<Long> ids= new ArrayList<>();

            for(Goods good:goods){
                ids.add(good.getGoodsId());
            }
            criteria.andRecordGoodsIdIn(ids); //查出来商品对象的ids  作为兑换记录的查询条件-->>
        }


        if (startTime != null){
            criteria.andRecordExchangeTimeGreaterThanOrEqualTo(startTime);
        }
        if (endTime != null){
            criteria.andRecordExchangeTimeLessThanOrEqualTo(endTime);
        }


        List<ExchangeRecord> records = exchangeRecordMapper.selectByExample(example);  //查出来的兑换记录
        List<ExchangeRecordVO> recordVO = new ArrayList<>();

        for(ExchangeRecord record : records){
            ExchangeRecordVO vo = new ExchangeRecordVO();
            BeanUtils.copyProperties(record, vo);
            MemberExample memberExample = new MemberExample();
            MemberExample.Criteria memberCriteria = memberExample.createCriteria();
            memberCriteria.andMemberPhoneEqualTo(record.getRecordCardId());
            Member member = memberMapper.selectByExample(memberExample).get(0);

            Goods goods = goodsMapper.selectByPrimaryKey(record.getRecordGoodsId());

            vo.setMemberName(member.getMemberName()); //用户名 -->> 通过会员卡id去member表查
            vo.setGoodsName(goods.getGoodsName());  //商品名 -->>通过商品id去商品表查
            vo.setGoodsPoints(goods.getGoodsPoints());//商品兑换所需积分 -->>通过商品id去商品表查

            recordVO.add(vo);
        }

        PageInfo pageInfo = new PageInfo<>(records);

        Map<String, Object> map = new HashMap<>();

        map.put("recordList", recordVO);
        map.put("pageInfo", pageInfo);

        return map;
    }

    @Transactional
    @Override
    public void saveExchangeRecord(ExchangeRecord record) {
        exchangeRecordMapper.insertSelective(record);
    }


}
