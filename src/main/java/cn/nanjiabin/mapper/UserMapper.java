package cn.nanjiabin.mapper;

import cn.nanjiabin.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface UserMapper extends BaseMapper<User> {

    Integer selectMaxAge();
}