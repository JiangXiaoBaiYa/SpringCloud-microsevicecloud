package com.qqtwo.user.mapper;

import com.qqtwo.pojo.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Author: 姜光明
 * @Date: 2019/4/24 21:17
 */
@Repository("userMapper")
public interface UserMapper extends Mapper<User> {
}
