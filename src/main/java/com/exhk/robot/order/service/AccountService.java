package com.exhk.robot.order.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.exhk.robot.order.bean.pojo.common.JsonResult;
import com.exhk.robot.order.bean.pojo.dto.account.RegistDto;
import com.exhk.robot.order.bean.pojo.vo.RegistVo;
import com.exhk.robot.order.dao.entity.Account;
import com.exhk.robot.order.dao.mapper.AccountMapper;
import com.exhk.robot.order.utils.UuidUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class AccountService {
    @Resource
    AccountMapper accountMapper;

    /**
     * 用户注册
     * @param dto
     * @return
     */
    public JsonResult regist(RegistDto dto) {
        Account account = getAccountByNameAndMobile(dto.getName(), dto.getMobile());
        if (account!=null) {
            return JsonResult.createFalied("此手机号已存在");
        }
        Account newAcc = new Account();
        BeanUtils.copyProperties(dto,newAcc);
        newAcc.setCreateTime(new Date());
        String uuid = UuidUtil.getUUID();
        newAcc.setToken(uuid);
        newAcc.setIsLucky(0);

        newAcc.setUtmGuanjia(dto.getUtm_guanjia());
        newAcc.setUtmWuye(dto.getUtm_wuye());
        newAcc.setUtmQudao(dto.getUtm_qudao());
        newAcc.setCity(dto.getCity());
        accountMapper.insert(newAcc);
        RegistVo vo = new RegistVo();
        vo.setToken(uuid);
        return JsonResult.createSuccess(vo);
    }


    public Account getAccountByNameAndMobile(String name, String mobile) {
        EntityWrapper<Account> entityWrapper = new EntityWrapper<>();
      //  entityWrapper.eq("name", name);
        entityWrapper.eq("mobile", mobile);

        List<Account> accounts = accountMapper.selectList(entityWrapper);
        if (accounts.isEmpty()) {
            return null;
        }
        return accounts.get(0);
    }
    public Account getAccountByToken(String token) {
        EntityWrapper<Account> entityWrapper = new EntityWrapper<>();
        //  entityWrapper.eq("name", name);
        entityWrapper.eq("token", token);

        List<Account> accounts = accountMapper.selectList(entityWrapper);
        if (accounts.isEmpty()) {
            return null;
        }
        return accounts.get(0);
    }
}
