package com.xz.consumer.mapper;

import com.xz.api.domain.MemberOrder;
import org.apache.ibatis.annotations.Insert;

public interface MemberOrderMapper {
    @Insert("insert into member_order(member_id, money) values (#{memberId}, #{money})")
    void insertOrderMapper(MemberOrder memberOrder);
}
