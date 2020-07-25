package com.bw.mapper;

import com.bw.pojo.TbShopping;
import com.bw.pojo.TbShoppingExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbShoppingMapper {
    int countByExample(TbShoppingExample example);

    int deleteByExample(TbShoppingExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbShopping record);

    int insertSelective(TbShopping record);

    List<TbShopping> selectByExample(TbShoppingExample example);

    TbShopping selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbShopping record, @Param("example") TbShoppingExample example);

    int updateByExample(@Param("record") TbShopping record, @Param("example") TbShoppingExample example);

    int updateByPrimaryKeySelective(TbShopping record);

    int updateByPrimaryKey(TbShopping record);
}