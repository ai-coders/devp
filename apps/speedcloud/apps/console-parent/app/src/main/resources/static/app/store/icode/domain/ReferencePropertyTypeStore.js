Ext.define('AM.store.icode.domain.ReferencePropertyTypeStore', {
    extend: 'Ext.data.Store',
    xtype: 'icode.domain.ReferencePropertyTypeStore'
    ,requires: [
        'AM.model.icode.domain.PropertyType'
    ],

    constructor: function(cfg) {
        var me = this;
        cfg = cfg || {};
        me.callParent([Ext.apply({
            autoLoad: false,
	        model: 'AM.model.icode.domain.PropertyType',
            pageSize: 100,
            proxy: {
                type: 'rest',
                url: '/icode/domain/referencePropertyType',
                reader: {
                    type: 'json',
	                rootProperty: 'content'
                },
                listeners: {
                    exception: {
                        fn: me.onAjaxproxyException,
                        scope: me
                    }
                }
            }
        }, cfg)]);
    },

    onAjaxproxyException: function(server, response, operation, options) {
        //var store = options.scope;
        var store = this;

        var error = operation.getError();
        if(error.status){
            error = error.status + ' ' + error.statusText;
        }
        //Ext.Msg.show({title: '操作失败', msg: response.responseText, buttons: Ext.Msg.OK, icon: Ext.Msg.ERROR});
        Ext.Msg.show({title: '操作失败', msg: "ERROR:"+response.status+"<br/>请重试或联系管理员", buttons: Ext.Msg.OK, icon: Ext.Msg.ERROR});

        if('read'!==operation.action){
            store.load();
        }
    }

});