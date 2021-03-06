Ext.define('AM.view.platform.security.AccountPanel', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.platformSecurityAccountPanel',
    requires: [

    ],

    title: '平台账号',

    initComponent: function() {
        var me = this;

        Ext.apply(me, {

            columnLines: true
            ,columns: [
                {
                    xtype: 'gridcolumn'
                    ,dataIndex: 'tenantId'
                    ,renderer: function(value, metaData, record, rowIndex, colIndex, store, view) {
                        return record.get("tenantVO")?record.get("tenantVO").name:'';
                    }
                    ,text: '所属租户'

                }
                ,{
                    xtype: 'gridcolumn',
                    dataIndex: 'accountName',

                    text: '账号'
                }
                ,{
                    xtype: 'gridcolumn',
                    dataIndex: 'nickName',
                    
                    text: '昵称'
                }
                ,{
                    xtype: 'gridcolumn',
                    dataIndex: 'name',
                    
                    text: '姓名'
                }
                ,{
                    xtype: 'gridcolumn',
                    dataIndex: 'mobile',
                    
                    text: '手机号'
                }

                ,{
                    xtype: 'gridcolumn',
                    dataIndex: 'email',
                    
                    text: '邮箱'
                }

                ,{
                    xtype: 'gridcolumn',
                    renderer: function(value, metaData, record, rowIndex, colIndex, store, view) {
                        if(value===null)
                            return '不确定';
                        return value?'是':'否';
                    },
                    dataIndex: 'enable',
                    
                    text: '已启用'
                }
                ,{
		            xtype: 'actioncolumn',
		            items: [
			            {
				            handler: function(view, rowIndex, colIndex, item, e, record, row) {
					            var me = view.up('platformSecurityAccountPanel');
					            //high light the select line
					            view.getSelectionModel( ).select(record);

					            if(!me.roleWindow){

						            this.roleWindow = Ext.create('AM.view.platform.security.AccountRoleRelationWindow');

					            }

					            this.roleWindow.setAccount(record);
					            var window = this.window;



				            },
				            iconCls: 'link',
				            tooltip: '修改用户角色'
			            }
		            ]
	            }

            ]
            ,viewConfig: {

            }
            ,dockedItems: [
                {
                    xtype: 'toolbar',
                    dock: 'top',
                    items: [
                        {
                            xtype: 'button',
                            iconCls: 'add',
                            text: '新增',
                            listeners: {
                                click: {
                                    fn: me.onAddButtonClick,
                                    scope: me
                                }
                            }
                        },
                        {
                            xtype: 'button',
                            iconCls: 'edit',
                            text: '修改',
                            listeners: {
                                click: {
                                    fn: me.onEditButtonClick,
                                    scope: me
                                }
                            }
                        },
                        {
                            xtype: 'button',
                            iconCls: 'delete',
                            text: '删除',
                            listeners: {
                                click: {
                                    fn: me.onDeleteButtonClick,
                                    scope: me
                                }
                            }
                        }
                        ,'-'
                        ,{
                            xtype:'combobox'
                            ,emptyText:'点击选择租户'
                            ,store: Ext.create("AM.store.platform.platform.tenant.TenantStore")
                            ,displayField:'name'
                            ,valueField:'id'
                            ,itemId:'simpleSearchTenantField'

                        }
                        ,{
                            xtype:'textfield'
                            ,emptyText:'请输入姓名查询'
                            ,itemId:'simpleSearchNameField'

                        }
                        ,{
                            xtype: 'button',
                            iconCls: 'search',
                            text: '查询',
                            listeners: {
                                click: {
                                    fn: me.onSimpleSearchButtonClick,
                                    scope: me
                                }
                            }
                        }
                        ,{
                            xtype: 'button',
                            iconCls: 'search',
                            text: '高级查询',
                            listeners: {
                                click: {
                                    fn: me.showSearchWindow,
                                    scope: me
                                }
                            }
                        }
                    ]
                },
                {
                    xtype: 'pagingtoolbar',
                    dock: 'bottom',
                    displayInfo: true
                }
            ],
            selModel: 'checkboxmodel',
            listeners: {
                beforeshow: {
                    fn: me.onBeforeShow,
                    scope: me
                },
                beforehide: {
                    fn: me.onPanelBeforeHide,
                    scope: me
                }
                ,itemdblclick: {
                    fn: me.onItemDblClick,
                    scope: me
                }
            }
        });

        me.callParent(arguments);
    }
    ,onSimpleSearchButtonClick: function(button, e, options) {
        var panel = options.scope;

        var simpleSearchTenantField = panel.down("#simpleSearchTenantField");
        var simpleSearchNameField = panel.down("#simpleSearchNameField");

        var searchCondition = {name:simpleSearchNameField.getValue()
            ,tenantId:simpleSearchTenantField.getValue()}

        this.store.proxy.extraParams={searchCondition:searchCondition};
        this.store.load({
            params:{
                start:0
                ,page:0
            }
        });
    }
	,onAddButtonClick: function(button, e, options) {


        var modelConfig = {}

        var record = Ext.create('AM.model.platform.security.Account', modelConfig);

        options.src = button;
        var detailWindow = this.showDetailWindow(record, options);
        detailWindow.setTitle('添加新账号');
    }
    ,onEditButtonClick: function(button, e, options) {

        options.src=button;
        var selections = this.getSelectionModel( ).getSelection( );

        if(selections.length <= 0){
            Ext.Msg.show({title: '操作失败', msg: '未选择数据', buttons: Ext.Msg.OK, icon: Ext.Msg.WARNING});
            return;
        }

        var record = selections[0];
        var editWindow = this.showEditWindow(record,options);
		editWindow.setTitle('修改账号信息');
    }
    ,onDeleteButtonClick: function(button, e, options) {
        var me = this;
        var selections = me.getSelectionModel( ).getSelection( );
        me.getStore().remove(selections);
        me.getStore().sync({
            success:function(batch,options){

                var store = options.scope;
		        var count = store.getCount();

		        var targetPage = count<=0 ? store.currentPage-1 : store.currentPage;
		        targetPage = targetPage <=0 ? 1 :targetPage;

                store.loadPage(targetPage,{
                    scope: this,
                    callback: function(records, operation, success) {
                        if(!success)
                        	Ext.Msg.show({title: '操作失败', msg: '重新加载数据失败', buttons: Ext.Msg.OK, icon: Ext.Msg.WARNING});
                        else
                        	Ext.MsgUtil.show('操作成功','删除账号成功!');
                    }
                });
            }
            ,scope:me.getStore()
        });
    }
    ,onItemDblClick: function(tablepanel, record, item, index, e, options) {
        var me = options.scope;
        options.src=item;
        var editWindow = me.showEditWindow(record, options);
		editWindow.setTitle('修改账号信息');
    }
    ,showDetailWindow: function(model,options) {
        var me = options.scope;

        var detailWindow = me.detailWindow;

        if(!detailWindow||detailWindow.isHidden()){

            detailWindow = Ext.create('AM.view.platform.security.AccountWindow',{store:me.getStore()});
            me.detailWindow = detailWindow;
        }


        detailWindow.setModel(model);

        detailWindow.show(options.src);
        detailWindow.setStore(this.store);
        return detailWindow;
    }
	,showEditWindow: function(model,options) {
		var me = options.scope;

		var editWindow = me.editWindow;

		if(!editWindow||editWindow.isHidden()){

			editWindow = Ext.create('AM.view.platform.security.AccountEditWindow',{store:me.getStore()});
			me.editWindow = editWindow;
		}


		editWindow.setModel(model);

		editWindow.show(options.src);
		editWindow.setStore(this.store);
		return editWindow;
	}
    ,showSearchWindow: function(button, e, options) {
        var me = options.scope;

        var searchWindow = me.searchWindow;

        if(!searchWindow){

            searchWindow = Ext.create('AM.view.platform.security.AccountSearchWindow');
            me.searchWindow = searchWindow;
            searchWindow.setStore(this.store);
        }

        searchWindow.show(button);
    }
    ,setStore: function(store) {
        this.reconfigure(store);
        this.down('pagingtoolbar').bindStore(store);

        this.store=store;
    }
    ,onBeforeShow:function(abstractcomponent, options) {
	    this.store.reload({scope: this,callback: function(){}});
    }
    ,onPanelBeforeHide: function(abstractcomponent, options) {
    	var me = this;
    	if(me.searchWindow){
    		me.searchWindow.hide();
    	}
    	if(me.detailWindow){
    		me.detailWindow.hide();
    	}
        if(me.roleWindow){
            me.roleWindow.hide();
        }
    }

});