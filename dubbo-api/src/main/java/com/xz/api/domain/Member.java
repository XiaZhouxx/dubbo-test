package com.xz.api.domain;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author xz
 * @ClassName Member
 * @Description
 * @date 2020/11/23 0023 21:10
 **/
public class Member implements Serializable {
    private Integer id;

    private String memberName;

    private BigDecimal balance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
