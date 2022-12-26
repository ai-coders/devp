Ext.define('AM.store.security.RoleResourceRelationTreeStore', {
    extend: 'Ext.data.TreeStore',

    requires: [
        'AM.model.security.RoleResourceRelationTreeNode'
    ],
	model: 'AM.model.security.RoleResourceRelationTreeNode',
	autoLoad: false,
	nodeParam:'id',
	root: {
		expanded: false,
		//text: "My Root",
		name:'Root',
		id: '-1'
	},
    constructor: function(cfg) {
        var me = this;
        cfg = cfg || {};
        me.callParent([Ext.apply({
            proxy: {
                type: 'ajax',
	            headers:{Accept:'application/json'},
	            paramsAsJson:true,
                url: 'security/roleResourceRelation',

                actionMethods:{read:'GET', update:'PUT'},
                api:{read:"security/roleResourceRelation?method=getChildNodes"},
	            reader: {
		            type: 'json'
		            //,root: 'content'
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

        if('read' !== operation.action){
            store.load();
        }
    }


});