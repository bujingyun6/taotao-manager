package cn.zhx.service;

import cn.zhx.pojo.MybatiesPageHelperRusult;
import cn.zhx.pojo.TbItem;

public interface ItemService {

	/** 根据id查询商品
	 * @param id
	 * @return
	 */
	TbItem getItemById(Long id);
	
	MybatiesPageHelperRusult getItemPageHelperList(int page,int row);
}
