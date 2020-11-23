package com.xz.consumer.impl;

import com.xz.api.domain.Member;
import com.xz.api.domain.MemberOrder;
import com.xz.api.service.MemberOrderService;
import com.xz.consumer.mapper.MemberOrderMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xz
 * @ClassName MemberOrderServiceImpl
 * @Description
 * @date 2020/11/23 0023 21:22
 **/
@DubboService
@Service
public class MemberOrderServiceImpl implements MemberOrderService {
    @Autowired
    MemberOrderMapper orderMapper;
    @Override
    public void generateMemberOrder(Member member) {
        MemberOrder order = new MemberOrder();
        order.setMemberId(member.getId());
        order.setMoney(member.getBalance());
        orderMapper.insertOrderMapper(order);
    }
}
