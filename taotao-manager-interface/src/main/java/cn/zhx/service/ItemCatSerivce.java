package cn.zhx.service;

import java.util.List;

import cn.zhx.pojo.EasyUITreeNode;

public interface ItemCatSerivce {

	List<EasyUITreeNode> getItemCatList(Long parentId);
}
