Ext.define('AM.view.speedcloud.deployscheme.ResourceCategoryDetailWindow', {
    extend: 'Ext.window.Window'
    ,xtype: 'speedcloud.deployscheme.ResourceCategoryDetailWindow'
    ,autoScroll: true
    ,height: 350
    ,width: 700
    ,layout: {
        type: 'fit'
    }
    ,title: '部署资源类别详细信息'
    ,maximizable: true
    ,closeAction:'hide'
    ,initComponent: function () {
        var me = this;

        Ext.apply(me, {
            items: [
                {
                    xtype: 'form'
                    ,autoScroll: true
                    ,bodyPadding: 10
                    ,layout: {
                        type: 'anchor'
                    }
                    ,defaults: {
                        labelAlign: 'right'
                        ,xtype: 'displayfield'
                        ,padding: '5 0 0 5'
                        ,anchor: '100%'
                        ,labelWidth:150
                    }
                    ,items: [
                        ,{
                            itemId: 'nameField'
                            ,padding: '5 0 0 5'
                            ,name: 'name'
                            ,fieldLabel: '名称'
                        }
                        ,{
                            itemId: 'codeField'
                            ,padding: '5 0 0 5'
                            ,name: 'code'
                            ,fieldLabel: '代码'
                        }
                        ,{
                            itemId: 'iconField'
                            ,padding: '5 0 0 5'
                            ,name: 'icon'
                            ,fieldLabel: '图标'
                        }
                        ,{
                            itemId: 'idxField'
                            ,padding: '5 0 0 5'
                            ,name: 'idx'
                            ,fieldLabel: '排序'
                        }
                    ]
                }
            ]
        });

        me.callParent(arguments);
    }

    ,setModel: function (model) {
        if (model && model.get('id')) {
            this.down('form').getForm().loadRecord(model);
        } else {
            this.down('form').getForm().reset();
        }
    }

});