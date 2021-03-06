Ext.define('AM.view.devp.publish.DevpSysOpsTaskPublishMainPanel', {
    extend: 'Ext.panel.Panel'
    ,xtype: 'devp.publish.DevpSysOpsTaskPublishMainPanel'
    ,requires: [
        'AM.view.devp.publish.DevpSysOpsTaskPublishPanel'
		,'AM.view.devp.publish.DevpSysOpsTaskPublishController'
    ]
	,layout: {
		type: 'border'
	}
    ,title: '发布设置'
	,store:null
	,controller: 'publish_DevpSysOpsTaskPublishController'
    ,initComponent: function() {
        var me = this;

		var devpSysOpsTaskPublishStore = Ext.create('AM.store.devp.publish.DevpSysOpsTaskPublishStore');
		devpSysOpsTaskPublishStore.proxy.extraParams={searchCondition:{}};
		devpSysOpsTaskPublishStore.load();

	    Ext.apply(me, {
		    items: [
			    {
				    xtype: 'devp.publish.DevpSysOpsTaskPublishPanel'
				    ,region: 'center'
				    ,itemId: 'devpSysOpsTaskPublishGrid'
					,reference: 'devpSysOpsTaskPublishGrid'
				    ,store: devpSysOpsTaskPublishStore
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
		var panel = this.lookup('devpSysOpsTaskPublishGrid');
		panel.onBeforeShow();
	}
	,onPanelBeforeHide: function(abstractcomponent, options) {
		var panel = this.lookup('devpSysOpsTaskPublishGrid');
		panel.onPanelBeforeHide();
	}
	,onMainItemDblClick: function(tablepanel, record, item, index, e, options) {

		var me = this;

	}
	,initStore: function(){
		var me = this;
		var devpSysOpsTaskPublishStore = Ext.create('AM.store.devp.publish.DevpSysOpsTaskPublishStore');
		devpSysOpsTaskPublishStore.proxy.extraParams={searchCondition:{}};
		me.devpSysOpsTaskPublishStore = devpSysOpsTaskPublishStore;
		devpSysOpsTaskPublishStore.load();
	}

});