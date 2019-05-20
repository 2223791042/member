package guet.ty.member.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import guet.ty.member.VO.ResultVO;
import guet.ty.member.VO.TableVO;
import guet.ty.member.entity.Goods;
import guet.ty.member.service.GoodsService;
import guet.ty.member.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    /**
     * 商品添加
     */
    @PostMapping("/goods/add")
    public ResultVO goodsAdd(Goods goods, HttpSession session) {
        try {
            goodsService.saveGoods(goods);
            return ResultVOUtil.success();
        } catch (Exception e) {
            return ResultVOUtil.fail();
        }
    }

    /**
     * 库存修改
     */
    @PostMapping("/goods/edit")
    public ResultVO goodsEdit(HttpServletRequest request) {
        try {
            Long goodsId =Long.parseLong(request.getParameter("goodsId"));
            Integer goodsLeft =Integer.parseInt(request.getParameter("goodsLeft"));

            Goods goods = new Goods();
            goods.setGoodsId(goodsId);
            goods.setGoodsLeft(goodsLeft);
            goodsService.editGoods(goods);

            return ResultVOUtil.success();
        } catch (Exception e) {
            return ResultVOUtil.fail();
        }
    }


    @GetMapping("/goodsList")
    public TableVO<Goods> goodsList(HttpServletRequest request){

        if(request.getParameter("page")!=null && request.getParameter("limit")!=null){
            int page= Integer.parseInt(request.getParameter("page"));
            int limit= Integer.parseInt(request.getParameter("limit"));
            PageHelper.startPage(page, limit);
        }

        Long goodsId=null;
        if(request.getParameter("goodsId")!=null){
            goodsId= Long.valueOf(request.getParameter("goodsId"));
        }

        String goodsName = request.getParameter("goodsName");

        BigDecimal goodsPoints=null;
        if(request.getParameter("goodsPoints")!=null && !request.getParameter("goodsPoints").equals("")){
            goodsPoints = new BigDecimal(request.getParameter("goodsPoints"));
        }

        List<Goods> goods = goodsService.getGoodsList(goodsId, goodsName,goodsPoints);

        PageInfo pageInfo = new PageInfo<>(goods);

        return new TableVO<>(pageInfo,goods);
    }

}




