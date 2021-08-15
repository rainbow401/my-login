package com.yzh.oauth2.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yzh.oauth2.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
