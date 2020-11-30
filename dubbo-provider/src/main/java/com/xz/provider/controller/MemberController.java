package com.xz.provider.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.xz.api.domain.Member;
import com.xz.api.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author xz
 * @ClassName MemberController
 * @Description
 * @date 2020/11/23 0023 21:42
 **/
@RestController
public class MemberController {
    @Autowired
    MemberService memberService;

    @RequestMapping("/reduce")
    @SentinelResource(fallback = "fallBack")
    public String memberReduceBalance(@RequestBody Member member) {
        if (member.getBalance().equals(BigDecimal.ZERO)) {
            throw new RuntimeException();
        }
        memberService.reduceBalance(member);
        return "success";
    }

    public String fallBack(Member member) {
        return "fall back member is " + member.getMemberName();
    }
}
