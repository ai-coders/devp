Ext.define('AM.store.security.RoleResourceRelationStore', {
    extend: 'Ext.data.Store',

    requires: [
        'AM.model.security.RoleResourceRelation'
    ],

    constructor: function(cfg) {
        var me = this;
        cfg = cfg || {};
        me.callParent([Ext.apply({
            autoLoad: false,
            model: 'AM.model.security.RoleResourceRelation',
            pageSize: 10,
            proxy: {
                type: 'rest',
                url: 'security/roleResourceRelation',
                reader: {
                    type: 'json',
                    root: 'content'
                },
                actionMethods:{read:'POST'},
                api:{read:"security/roleResourceRelation/list"},
                paramsAsJson:true,
                listeners: {
                    exception: {
                        fn: me.onAjaxproxyException,
                        scope: me
                    }
                }
            }
            ,listeners: {
                beforeload: {
                    fn:me.beforeload,
                    scope: me
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
    ,beforeload :function(store, operation, eOpts ){
        //处理一下分页参数,后台默认是从0开始,ext是从1开始
        operation.setPage(operation.getPage() - 1);

        if(this.rootModel){

            var extraParams = this.proxy.getExtraParams();

            if(!extraParams.searchCondition){
                extraParams.searchCondition = {}
            }

            extraParams.searchCondition.projectTemplateId = this.rootModel.getId()

        }
    }

});