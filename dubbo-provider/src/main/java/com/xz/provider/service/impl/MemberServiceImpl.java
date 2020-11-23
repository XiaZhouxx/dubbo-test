package com.xz.provider.service.impl;

import com.xz.api.domain.Member;
import com.xz.api.service.MemberOrderService;
import com.xz.api.service.MemberService;
import com.xz.provider.mapper.MemberMapper;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author xz
 * @ClassName MemberOrderServiceImpl
 * @Description
 * @date 2020/11/23 0023 21:22
 **/
@DubboService
@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    MemberMapper memberMapper;
    @DubboReference
    MemberOrderService orderService;

    @Override
    @GlobalTransactional
    public void reduceBalance(Member member) {
        // 本地事务
        memberMapper.insert(member);
        // 远程事务
        orderService.generateMemberOrder(member);
        if (member.getBalance().compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException();
        }
    }

}
