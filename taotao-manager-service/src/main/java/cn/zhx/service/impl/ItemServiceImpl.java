package cn.zhx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.zhx.mapper.TbItemMapper;
import cn.zhx.pojo.MybatiesPageHelperRusult;
import cn.zhx.pojo.TbItem;
import cn.zhx.pojo.TbItemExample;
import cn.zhx.pojo.TbItemExample.Criteria;
import cn.zhx.service.ItemService;
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper tbItemMapper;

	@Override
	public TbItem getItemById(Long id) {
		TbItemExample example = new TbItemExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andIdEqualTo(id);
		List<TbItem> selectByExample = tbItemMapper.selectByExample(example);
		return selectByExample.get(0);
	}

	@Override
	public MybatiesPageHelperRusult getItemPageHelperList(int page, int row) {
		PageHelper.startPage(page, row);
		TbItemExample example = new TbItemExample();
		List<TbItem> list = tbItemMapper.selectByExample(example);
		PageInfo<TbItem> info = new PageInfo<TbItem>(list);
		MybatiesPageHelperRusult result = new MybatiesPageHelperRusult();
		result.setRows(list);
		result.setTotal(info.getTotal());
		return result;
	}
	
	
}
