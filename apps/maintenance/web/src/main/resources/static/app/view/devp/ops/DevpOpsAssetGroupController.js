Ext.define('AM.view.devp.ops.DevpOpsAssetGroupController', {
	extend: 'Ext.app.ViewController',
	requires: [

	]
	,alias: 'controller.ops_DevpOpsAssetGroupController'

	,onMainPanelRowClick:function(tablepanel, record, item, index, e, options) {
		//点击主数据的某行
		var me = this;


		var detailTabPanel = me.lookup('detailTabPanel');
		detailTabPanel.expand();

		var id = record.get('id');



	}
	,reloadStore:function () {
        var me = this;
        var devpOpsAssetGroupAddWindow = me.lookupReference ('devpOpsAssetGroupAddWindow');
        var devpOpsAssetGroupGrid = devpOpsAssetGroupAddWindow.up('gridpanel');

        devpOpsAssetGroupGrid.getStore().load({
            callback: function (records, operation, success) {
                if (success) {
                    Ext.MsgUtil.show('操作成功', '同步列表成功');
                }
            }
        });
    }
    ,doSearch:function () {
        var me = this;
        var devpOpsAssetGroupSearchWindow = me.lookupReference ('devpOpsAssetGroupSearchWindow');
        var devpOpsAssetGroupGrid = devpOpsAssetGroupSearchWindow.up('gridpanel');
        devpOpsAssetGroupGrid.getStore().proxy.extraParams={searchCondition:devpOpsAssetGroupSearchWindow.getCondition()};
        devpOpsAssetGroupGrid.getStore().load({
            params:{
                start:0,
                page:0
            }
        });
    }
})