package cn.zhx.service.impl;

import java.util.ArrayList;
import java.util.List;












import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zhx.mapper.TbItemCatMapper;
import cn.zhx.pojo.EasyUITreeNode;
import cn.zhx.pojo.TbItemCat;
import cn.zhx.pojo.TbItemCatExample;
import cn.zhx.pojo.TbItemCatExample.Criteria;
import cn.zhx.service.ItemCatSerivce;
@Service
public class ItemCatSerivceImpl implements ItemCatSerivce {

	@Autowired
	private TbItemCatMapper itemCatMapper;
	
	@Override
	public List<EasyUITreeNode> getItemCatList(Long parentId) {
		TbItemCatExample example = new TbItemCatExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andParentIdEqualTo(parentId);
		List<EasyUITreeNode> uiNodeList = new ArrayList<EasyUITreeNode>();
		List<TbItemCat> list = itemCatMapper.selectByExample(example);
		for (TbItemCat tbItemCat : list) {
			EasyUITreeNode treeNodeBean = new  EasyUITreeNode();
			treeNodeBean.setId(tbItemCat.getId());
			treeNodeBean.setText(tbItemCat.getName());
			//当节点下有子节点“closed”，如果没有“open”
			treeNodeBean.setState(tbItemCat.getIsParent()?"closed":"open");
			uiNodeList.add(treeNodeBean);
		}
		return uiNodeList;
	}

}
