package com.exhk.robot.order.mapper.ext;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.exhk.robot.order.bean.pojo.vo.WinneringVo;
import com.exhk.robot.order.dao.entity.WinningLog;
import com.github.pagehelper.Page;

public interface WinnerLogMapperExt extends BaseMapper<WinningLog> {

    Page<WinneringVo> getLuckyList();
}
