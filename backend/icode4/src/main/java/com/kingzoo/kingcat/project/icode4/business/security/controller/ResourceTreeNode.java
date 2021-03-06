package com.kingzoo.kingcat.project.icode4.business.security.controller;


import com.kingzoo.kingcat.project.icode4.business.security.entity.Resource;

/**
 */
public class ResourceTreeNode extends Resource {
	
	/**
	 * Constructor for ResourceTreeNode.
	 * @param resource Resource
	 */
	public ResourceTreeNode(Resource resource){
		this.setId(resource.getId());
		this.setName(resource.getName());
		this.setUrl(resource.getUrl());
		this.setType(resource.getType());
		this.setOrderIndex(getOrderIndex());
		this.setParentId(resource.getParentId());
		this.leaf = "function".equals(resource.getType());
		this.setIconCls(resource.getType());
	}

	protected boolean leaf;
	protected String iconCls;
	public boolean isLeaf() {
		return leaf;
	}
	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = "function".equals(iconCls)?"x-fa fa-file":"x-fa fa-folder";
	}
	
	
	
}
