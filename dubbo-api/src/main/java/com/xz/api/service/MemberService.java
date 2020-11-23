package com.xz.api.service;

import com.xz.api.domain.Member;

public interface MemberService {

    /**
     * 扣减余额
     * @param member
     */
    void reduceBalance(Member member);
}
