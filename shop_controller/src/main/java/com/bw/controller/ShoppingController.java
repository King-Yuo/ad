package com.bw.controller;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.bw.pojo.TbShopping;
import com.bw.service.ShoppingService;

import entity.PageResult;
import entity.Result;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/shopping")
public class ShoppingController {

	@Reference
	private ShoppingService shoppingService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbShopping> findAll(){			
		return shoppingService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return shoppingService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param shopping
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody TbShopping shopping){
		try {
			shoppingService.add(shopping);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param shopping
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TbShopping shopping){
		try {
			shoppingService.update(shopping);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}	
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public TbShopping findOne(int id){
		return shoppingService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(int [] ids){
		try {
			shoppingService.delete(ids);
			return new Result(true, "删除成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
		/**
	 * 查询+分页
	 * @param brand
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody TbShopping shopping, int page, int rows  ){
		return shoppingService.findPage(shopping, page, rows);		
	}
	
}
