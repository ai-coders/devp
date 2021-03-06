Ext.define('AM.view.platform.security.RoleMainPanel', {
    extend: 'Ext.panel.Panel',
    alias: 'widget.platformSecurityRoleMainPanel',
    requires: [
        'AM.view.platform.security.RolePanel'
    ],
	layout: {
		type: 'border'
	},
    title: '平台角色',
	store:null,
    initComponent: function() {
        var me = this;

	    if(!me.store){
		    Ext.Msg.show({title: '初始化失败', msg: '未设置Store, 请联系技术', buttons: Ext.Msg.OK, icon: Ext.Msg.WARNING});
	    }
	    Ext.apply(me, {
		    items: [
			    {
				    xtype: 'platformSecurityRolePanel',
				    region: 'center',
				    itemId: 'roleGrid',
				    store: me.store
					,listeners: {

						itemdblclick: {
							fn: me.onMainItemDblClick,
							scope: me
						}
					}
			    } 		    ]
		    ,listeners: {
			    beforeshow: {
				    fn: me.onBeforeShow,
				    scope: me
			    },
			    beforehide: {
				    fn: me.onPanelBeforeHide,
				    scope: me
			    }
		    }
	    });
        me.callParent(arguments);
    }
	,onBeforeShow:function(abstractcomponent, options) {

	}
	,onPanelBeforeHide: function(abstractcomponent, options) {

	}
	,onMainItemDblClick: function(tablepanel, record, item, index, e, options) {

		var me = this;

	}

});