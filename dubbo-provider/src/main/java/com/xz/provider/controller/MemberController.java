package com.xz.provider.controller;

import com.xz.api.domain.Member;
import com.xz.api.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String memberReduceBalance(@RequestBody Member member) {
        memberService.reduceBalance(member);
        return "success";
    }
}
