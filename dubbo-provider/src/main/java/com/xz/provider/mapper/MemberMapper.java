package com.xz.provider.mapper;

import com.xz.api.domain.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

public interface MemberMapper {
    @Insert("insert into member(member_name,balance) values (#{memberName}, #{balance})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    void insert(Member member);
}
