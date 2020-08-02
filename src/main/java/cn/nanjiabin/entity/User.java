package cn.nanjiabin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@KeySequence("SEQ_USER")
@TableName("user")
public class User {

    @TableId(type = IdType.INPUT)
    private Integer id;

    private String name;

    private Integer age;

    private String email;
}
