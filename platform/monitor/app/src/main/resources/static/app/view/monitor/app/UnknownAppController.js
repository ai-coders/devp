Ext.define('AM.view.monitor.app.UnknownAppController', {
	extend: 'Ext.app.ViewController'
	,requires: [
        'AM.view.monitor.app.ApplicationAddWindow'
	]
	,alias: 'controller.monitor.app.UnknownAppController'

	,addToMonitor:function(grid, rowIndex, colIndex, item, event, record) {

	    //点击将未知应用加入监控列表
		var me = this;

        var modelConfig = {code:record.get('code'), totalCount:1, alarm:true, enable:true, thresholdValue:0}
        var record = Ext.create('AM.model.monitor.app.Application', modelConfig);

        this.showAddApplicationWindow(record);


	}

    ,onSimpleSearchButtonClick: function(button, e, options) {
        var me = this;

        var store = me.getViewModel().getStore('store');
        var codeField = me.lookupReference("codeField");
        var ignoredField = me.lookupReference("ignoredField");
        store.applyCondition({code:codeField.getValue(),ignored:ignoredField.getValue()})

    }

    ,showAddApplicationWindow: function(model, targetComponent) {
        var me = this;
        var addWindow = me.lookupReference('applicationAddWindow');
        addWindow.setModel(model);
        addWindow.show(targetComponent);
        return addWindow;
    }

})