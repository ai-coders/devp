
Ext.define('AM.view.security.ResourcePanel', {
	extend: 'Ext.panel.Panel',
	alias: 'widget.securityResourcePanel',

	height: 250,
	layout: {
		type: 'border'
	},
	title: '系统资源',

	initComponent: function() {
		var me = this;

		Ext.apply(me, {
			items: [
				{
					xtype: 'treepanel',
					region: 'west',
					split: true,
					width: 150,
					title: '资源树',
					store: 'security.AllResourceTreeStore',
					displayField: 'name',
					viewConfig: {

					},
					listeners: {
						itemclick: {
							fn: me.onTreepanelItemClick,
							scope: me
						}
					}
				},
				{
					xtype: 'gridpanel',
					region: 'center',
					title: '子节点',
					dockedItems: [
						{
							xtype: 'toolbar',
							dock: 'top',
							items: [
								{
									xtype: 'button',
									handler: function(button, event) {

										var grid = this.up('grid');

										var rowEditing = grid.getPlugin('rowediting');
										rowEditing.cancelEdit();

										var tree = grid.previousSibling('treepanel');
										var parentResource = tree.getSelectionModel( ).getLastSelected();
										var parentId = parentResource ? parentResource.get('id'):-1;
										var parentName = parentResource ? parentResource.get('name'):'ROOT';


										// Create a model instance
										var r = Ext.create('AM.model.security.Resource', {
											name: '<resource_name>'
											,parentId: parentId
											,orderIndex: 1
											,type:'function'
											,parentName: parentName

										});

										grid.getStore().insert(grid.getStore().getCount(), r);
										rowEditing.startEdit(r, 0);
									},
									iconCls: 'add',
									text: '新增'
								},
								{
									xtype: 'button',
									handler: function(button, event) {
										var grid = this.up('grid');

										var selected = grid.getSelectionModel( ).getSelection( );
										grid.getStore().remove(selected);
										grid.getStore().sync({
											success:function(){
												Ext.MsgUtil.show('操作成功','删除资源成功!');

												var tree = grid.previousSibling('treepanel');

												var path = tree.getSelectionModel( ).getLastSelected().getPath();
												tree.getStore().load({
													callback:function(records, operation, success){
														if(success){
															Ext.MsgUtil.show('操作成功','同步资源树成功');
															tree.selectPath(path);
														}

													}
												});
											}
										});

									},
									iconCls: 'remove',
									text: '删除'
								}
							]
						}
					],
					columns: [
						{
							xtype: 'gridcolumn',
							dataIndex: 'name',
							text: '资源名',
							editor: {
								xtype: 'textfield'
							}
						},
						{
							xtype: 'gridcolumn',
							dataIndex: 'url',
							flex: 1,
							text: '资源链接',
							editor: {
								xtype: 'textfield'
							}
						},
						{
							xtype: 'numbercolumn',
							dataIndex: 'orderIndex',
							header: '排序',
							format: '0',
							editor: {
								xtype: 'numberfield'
							}
						},
						{
							header: '资源类型',
							dataIndex: 'type',
							editor: new Ext.form.field.ComboBox({
								typeAhead: false,
								editable: false,
								triggerAction: 'all',
								store: [
									['function','功能']
									,['module','模块']
								]
								,value : '1'
							})
							,renderer: function(value){
							if (value == 'function') {
								return '功能';
							}else if (value == 'module') {
								return '模块';
							}else{
								return '';
							}
						}
						}
					],
					viewConfig: {

					},
					selModel: Ext.create('Ext.selection.CheckboxModel', {

					}),
					plugins: [
						//要用rowEditing的时候注意,gridpanel必须在某个panel里，不能再tabpanel里
						Ext.create('Ext.grid.plugin.RowEditing', {
							ptype: 'rowediting',
							pluginId: 'rowediting'
						})
					],
					listeners: {
						edit: {
							fn: me.onGridpanelEdit,
							scope: me
						},
						canceledit: {
							fn: me.onGridpanelCanceledit,
							scope: me
						}
					}
				}
			]
		});

		me.callParent(arguments);
	},

	onTreepanelItemClick: function(tablepanel, record, item, index, e, options) {
		if('function'==record.get('type')){
			Ext.MessageBox.alert('','该资源没有子节点');
			return;
		}

		var parentId = record.get('id');
		var condition = Ext.JSON.encode({parentId:record.get('id')});
		this.resourceStore.proxy.extraParams={"parentId":parentId, "pageSize":1000};
		this.resourceStore.load();
		this.down('grid').setTitle(record.get('name')+'的直接子节点');
	},

	onGridpanelEdit: function(editor, e, options) {

		var me = this;
		this.resourceStore.sync({
			success:function(){
				Ext.MsgUtil.show('操作成功','保存资源信息成功');

				var tree = me.down('treepanel');

				var path = tree.getSelectionModel( ).getLastSelected().getPath();

				me.resourceStore.load();
				tree.getStore().load({
					callback:function(records, operation, success){
						if(success){
							Ext.MsgUtil.show('操作成功','同步资源树成功');

							tree.selectPath(path);
						}
					}
				});
			}
		});

	}
	,onGridpanelCanceledit: function(editor, e, options) {

		if(e.record.phantom){
			this.resourceStore.remove(e.record);
		}
	}
	,setResourceStore: function(store) {
		this.resourceStore = store;
		this.down('grid').reconfigure(store);
	}
	,setResourceTreeStore: function(store) {
		this.resourceTreeStore = store;
		this.down('treepanel').reconfigure(store);
	}

});