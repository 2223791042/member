package guet.ty.member.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import guet.ty.member.VO.ExchangeRecordVO;
import guet.ty.member.VO.ResultVO;
import guet.ty.member.VO.TableVO;
import guet.ty.member.entity.Card;
import guet.ty.member.entity.ExchangeRecord;
import guet.ty.member.entity.Goods;
import guet.ty.member.entity.Manager;
import guet.ty.member.service.CardService;
import guet.ty.member.service.ExchangeRecordService;
import guet.ty.member.service.GoodsService;
import guet.ty.member.utils.DateUtil;
import guet.ty.member.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class ExchangeRecordController {

    @Autowired
    private ExchangeRecordService exchangeRecordService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private CardService cardService;

    @GetMapping("/recordList")
    public TableVO<ExchangeRecordVO> recordList(int page, int limit, HttpServletRequest request){
        PageHelper.startPage(page, limit);
        Long goodsId=null;
        if(request.getParameter("goodsId")!=null){
            goodsId= Long.valueOf(request.getParameter("goodsId"));
        }

        String goodsName = request.getParameter("goodsName");

        Date startTime = DateUtil.getStart(request);
        Date endTime = DateUtil.getEnd(request);

        Map<String, Object> map = exchangeRecordService.getRecordList(goodsId, goodsName, startTime, endTime);

        PageInfo pageInfo = (PageInfo) map.get("pageInfo");

        List<ExchangeRecordVO> records = (List<ExchangeRecordVO>) map.get("recordList");

        return new TableVO<>(pageInfo,records);
    }


    /**
     * 添加商品兑换记录
     * @param goodsId 商品id
     * @param cardId 会员卡id
     * @param count 兑换数量
     */
    @PostMapping("/record/add")
    public ResultVO recordAdd(Long goodsId, String cardId, int count, HttpSession session) {

        Manager manager = (Manager) session.getAttribute("manager");

        ExchangeRecord record = new ExchangeRecord();
        record.setRecordGoodsId(goodsId);
        record.setRecordCardId(cardId);
        record.setRecordExchangeNum(count);
        record.setRecordExchangeTime(new Date());
        record.setRecordHandler(manager.getManagerUsername());

        Goods goods = goodsService.getGoods(goodsId);
        int left =  goods.getGoodsLeft() - count;
        goods.setGoodsLeft(left);

        Card card = cardService.getCard(cardId);
        BigDecimal counts = new BigDecimal(count);
        //leftPoint = card.getCardPoints() - goods.getGoodsPoints() * count
        BigDecimal leftPoint = card.getCardPoints().subtract(goods.getGoodsPoints().multiply(counts));
        card.setCardPoints(leftPoint);

        try {
            exchangeRecordService.saveExchangeRecord(record); //新增兑换记录
            goodsService.editGoods(goods);  //减少商品库存
            cardService.editCard(card);   //更新卡的积分
            return ResultVOUtil.success();
        }catch (Exception e){
            return ResultVOUtil.fail();
        }

    }

}
