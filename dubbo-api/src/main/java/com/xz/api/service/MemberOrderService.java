package com.xz.api.service;

import com.xz.api.domain.Member;

/**
 * @author xz
 * @ClassName UserService
 * @Description
 * @date 2020/11/22 0022 15:40
 **/
public interface MemberOrderService {
    /**
     * 生成会员订单
     * @param member
     */
    void generateMemberOrder(Member member);
}
