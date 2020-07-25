package com.bw.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.bw.mapper.TbShoppingMapper;
import com.bw.pojo.TbShopping;
import com.bw.pojo.TbShoppingExample;
import com.bw.pojo.TbShoppingExample.Criteria;
import com.bw.service.ShoppingService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class ShoppingServiceImpl implements ShoppingService {

	@Autowired
	private TbShoppingMapper shoppingMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbShopping> findAll() {
		return shoppingMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbShopping> page=   (Page<TbShopping>) shoppingMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbShopping shopping) {
		shoppingMapper.insert(shopping);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbShopping shopping){
		shoppingMapper.updateByPrimaryKey(shopping);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbShopping findOne(int id){
		return shoppingMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(int[] ids) {
		for(int id:ids){
			shoppingMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(TbShopping shopping, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbShoppingExample example=new TbShoppingExample();
		Criteria criteria = example.createCriteria();
		
		if(shopping!=null){			
						if(shopping.getName()!=null && shopping.getName().length()>0){
				criteria.andNameLike("%"+shopping.getName()+"%");
			}
			if(shopping.getAddress()!=null && shopping.getAddress().length()>0){
				criteria.andAddressLike("%"+shopping.getAddress()+"%");
			}
			if(shopping.getNum()!=null && shopping.getNum().length()>0){
				criteria.andNumLike("%"+shopping.getNum()+"%");
			}
			if(shopping.getWeight()!=null && shopping.getWeight().length()>0){
				criteria.andWeightLike("%"+shopping.getWeight()+"%");
			}
			if(shopping.getBzdw()!=null && shopping.getBzdw().length()>0){
				criteria.andBzdwLike("%"+shopping.getBzdw()+"%");
			}
	
		}
		
		Page<TbShopping> page= (Page<TbShopping>)shoppingMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
