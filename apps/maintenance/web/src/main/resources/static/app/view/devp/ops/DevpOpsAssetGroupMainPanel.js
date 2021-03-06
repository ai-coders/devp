Ext.define('AM.view.devp.ops.DevpOpsAssetGroupMainPanel', {
    extend: 'Ext.panel.Panel'
    ,xtype: 'devp.ops.DevpOpsAssetGroupMainPanel'
    ,requires: [
        'AM.view.devp.ops.DevpOpsAssetGroupPanel'
		,'AM.view.devp.ops.DevpOpsAssetGroupController'
    ]
	,layout: {
		type: 'border'
	}
    ,title: '资产分组'
	,store:null
	,controller: 'ops_DevpOpsAssetGroupController'
    ,initComponent: function() {
        var me = this;

		var devpOpsAssetGroupStore = Ext.create('AM.store.devp.ops.DevpOpsAssetGroupStore');
		devpOpsAssetGroupStore.proxy.extraParams={searchCondition:{}};
		devpOpsAssetGroupStore.load();

	    Ext.apply(me, {
		    items: [
			    {
				    xtype: 'devp.ops.DevpOpsAssetGroupPanel'
				    ,region: 'center'
				    ,itemId: 'devpOpsAssetGroupGrid'
					,reference: 'devpOpsAssetGroupGrid'
				    ,store: devpOpsAssetGroupStore
					,listeners: {

						itemdblclick: 'onMainPanelRowClick'
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
		var panel = this.lookup('devpOpsAssetGroupGrid');
		panel.onBeforeShow();
	}
	,onPanelBeforeHide: function(abstractcomponent, options) {
		var panel = this.lookup('devpOpsAssetGroupGrid');
		panel.onPanelBeforeHide();
	}
	,onMainItemDblClick: function(tablepanel, record, item, index, e, options) {

		var me = this;

	}
	,initStore: function(){
		var me = this;
		var devpOpsAssetGroupStore = Ext.create('AM.store.devp.ops.DevpOpsAssetGroupStore');
		devpOpsAssetGroupS.proxy.extraParams={searchCondition:{}};
		me.devpOpsAssetGroupStore = devpOpsAssetGroupStore;
		devpOpsAssetGroupStore.load();
	}

});