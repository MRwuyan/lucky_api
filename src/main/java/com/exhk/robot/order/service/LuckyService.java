package com.exhk.robot.order.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.exhk.robot.order.bean.pojo.common.JsonResult;
import com.exhk.robot.order.bean.pojo.dto.DoLuckyDto;
import com.exhk.robot.order.bean.pojo.dto.GetLuckyListDto;
import com.exhk.robot.order.bean.pojo.vo.LuckyVo;
import com.exhk.robot.order.bean.pojo.vo.WinnerTotalVo;
import com.exhk.robot.order.bean.pojo.vo.WinneringVo;
import com.exhk.robot.order.dao.entity.Account;
import com.exhk.robot.order.dao.entity.PointsLuckDrawPrize;
import com.exhk.robot.order.dao.entity.WinningLog;
import com.exhk.robot.order.dao.mapper.AccountMapper;
import com.exhk.robot.order.dao.mapper.PointsLuckDrawPrizeMapper;
import com.exhk.robot.order.dao.mapper.WinningLogMapper;
import com.exhk.robot.order.mapper.ext.WinnerLogMapperExt;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.*;

@Slf4j
@Service
public class LuckyService {
    @Autowired
    AccountService accountService;
    @Resource
    AccountMapper accountMapper;
    @Resource
    PointsLuckDrawPrizeMapper pointsLuckDrawPrizeMapper;
    @Resource
    WinningLogMapper winningLogMapper;
    @Resource
    WinnerLogMapperExt winnerLogMapperExt;
    List<PointsLuckDrawPrize> pointsLuckDrawPrizes = new ArrayList<>();

    @Transactional(rollbackFor = Exception.class)
    public JsonResult doLucky(DoLuckyDto dto) {
        String token = dto.getToken();
        Account account = accountService.getAccountByToken(token);
        if (account == null) {
             return JsonResult.createFalied("该用户不存在,请先提交信息");
        }
        if (account.getIsLucky() == 1) {
            return JsonResult.createFalied("抽奖失败,每个用户只能抽一次奖");
        }
        Integer prizeId = cj(account.getId());
        account.setIsLucky(1);
        //更新抽奖状态
        accountMapper.updateById(account);
        LuckyVo vo = new LuckyVo();
        vo.setPrizeId(prizeId);
        return JsonResult.createSuccess(vo);
    }

    public Integer cj(Integer accountId) {
        synchronized (accountId.toString().intern()) {
            List<PointsLuckDrawPrize> allPrizes = getAllPrizes();
            BigDecimal random = getRandom();
            Integer prizeId;
            for (PointsLuckDrawPrize prize : allPrizes) {
                BigDecimal probability = prize.getProbability();
                if (probability.compareTo(random) >= 0) {
                    //没有奖品
                    if (prize.getPhase() <= 0) {
                        continue;
                    }
                    prizeId = prize.getId();
                    prize.setPhase(prize.getPhase() - 1);
                    pointsLuckDrawPrizeMapper.updateById(prize);
                    insertWinLog(accountId, prizeId);
                    return prizeId;
                }
            }
            log.error("没有奖品默认到4");
            insertWinLog(accountId, 4);
            return 4;
        }
    }

    public void insertWinLog(Integer accountId, Integer prizeId) {
        WinningLog log = new WinningLog();
        log.setAccountId(accountId);
        log.setPrizeId(prizeId);
        winningLogMapper.insert(log);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            Random random = new Random();
            double v = random.nextDouble();
            BigDecimal loo = new BigDecimal("100");
            BigDecimal bigDecimal = BigDecimal.valueOf(v).multiply(loo);
            if (bigDecimal.compareTo(BigDecimal.ONE)<0) {
                System.out.println(bigDecimal);
            }
        }
    }

    public BigDecimal getRandom() {
        Random random = new Random();
        double v = random.nextDouble();
        BigDecimal loo = new BigDecimal("100");
        BigDecimal bigDecimal = BigDecimal.valueOf(v).multiply(loo);
        return bigDecimal;
    }

    /**
     * @return
     */
    public List<PointsLuckDrawPrize> getAllPrizes() {
        if (pointsLuckDrawPrizes.isEmpty()) {
            refush();
        }
        return pointsLuckDrawPrizes;
    }

    public void refush() {
        EntityWrapper<PointsLuckDrawPrize> ew = new EntityWrapper<>();
        List<PointsLuckDrawPrize> ps = pointsLuckDrawPrizeMapper.selectList(ew);
        ps.sort(Comparator.comparing(PointsLuckDrawPrize::getProbability));
        pointsLuckDrawPrizes = ps;
    }
    /**
     * 查询中奖纪录
     * @param dto
     * @return
     */
    public JsonResult getLuckyList(GetLuckyListDto dto) {
        if (dto.getPageIndex() != null && dto.getPageSize() != null) {
            PageHelper.startPage(dto.getPageIndex(), dto.getPageSize());
        }
        PageInfo<WinneringVo> page;
        try {
            page = new PageInfo<>(winnerLogMapperExt.getLuckyList());
        } finally {
            PageHelper.clearPage();
        }
        WinnerTotalVo vos = new WinnerTotalVo();
        vos.setList(page.getList());
        vos.setTotal(page.getTotal());
        return JsonResult.createSuccess(vos);
    }
}
