package com.xz.api.domain;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author xz
 * @ClassName MemberOrder
 * @Description
 * @date 2020/11/23 0023 21:40
 **/
public class MemberOrder implements Serializable {
    private Integer id;

    private Integer memberId;

    private BigDecimal money;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
