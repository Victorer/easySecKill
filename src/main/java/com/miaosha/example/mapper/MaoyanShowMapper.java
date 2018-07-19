package com.miaosha.example.mapper;

import com.miaosha.example.pojo.MaoyanShow;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ProjectName: demo
 * @Package: com.miaosha.example.mapper
 * @ClassName: MaoyanShowMapper
 * @Description: java类作用描述
 * @Author: liyanda
 * @CreateDate: 2018/7/19 12:32
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/7/19 12:32
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Mapper
public interface MaoyanShowMapper {
    List<MaoyanShow> selectMaoyanShow();
}
