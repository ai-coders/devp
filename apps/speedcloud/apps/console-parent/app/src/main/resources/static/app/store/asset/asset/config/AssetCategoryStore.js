Ext.define('AM.store.asset.asset.config.AssetCategoryStore', {
    extend: 'Ext.data.Store'
    , alias: 'store.asset.asset.config.AssetCategoryStore'
    ,requires: [
        'AM.model.asset.asset.config.AssetCategory'
    ]
    ,constructor: function(cfg) {
        var me = this;
        cfg = cfg || {};
        me.callParent([Ext.apply({
            autoLoad: false
            ,model: 'AM.model.asset.asset.config.AssetCategory'
            ,pageSize: 25
            ,proxy: {
                type: 'rest'
                ,pageParam:'page'
                ,limitParam:'limit'
                ,url: 'asset/asset/config/assetcategory'
                ,writer:{writeRecordId:false, partialDataOptions:{changes:false}}
                ,reader: {
                    type: 'json',
                    rootProperty: 'content'
                }
                ,actionMethods:{read:'POST'}
                ,api:{read:"asset/asset/config/assetcategory/list"}
                ,paramsAsJson:true
                ,listeners: {
                    exception: {
                        fn: me.onAjaxproxyException
                        ,scope: me
                    }
                }
            }
            ,listeners: {
                beforeload: {
                    fn:me.beforeload
                    ,scope: me
                }
            }
        }, cfg)]);
    }

    ,onAjaxproxyException: function(server, response, operation, options) {
        //var store = options.scope;
        var store = this;

        var error = operation.getError();
        if(error.status){
            error = error.status + ' ' + error.statusText;
        }
        //Ext.Msg.show({title: '操作失败', msg: response.responseText, buttons: Ext.Msg.OK, icon: Ext.Msg.ERROR});
        Ext.MessageBox.show({title: '操作失败', msg: "ERROR:"+response.status+"<br/>请重试或联系管理员", buttons: Ext.Msg.OK, icon: Ext.Msg.ERROR});

        if('read' !== operation.action){
            store.load();
        }
    }
    ,beforeload :function(store, operation, eOpts ){
        //处理一下分页参数,后台默认是从0开始,ext是从1开始
        operation.setPage(operation.getPage() - 1);

    }
	,applyCondition:function(condition){
        condition = condition || {}
        this.proxy.setExtraParam("searchCondition", condition);
        return this;
    }
});
