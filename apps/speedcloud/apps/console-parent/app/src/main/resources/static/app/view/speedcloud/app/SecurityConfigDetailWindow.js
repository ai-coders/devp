Ext.define('AM.view.speedcloud.app.SecurityConfigDetailWindow', {
    extend: 'Ext.window.Window'
    ,xtype: 'speedcloud.app.SecurityConfigDetailWindow'
    ,autoScroll: true
    ,height: 350
    ,width: 700
    ,layout: {
        type: 'fit'
    }
    ,title: '应用私密配置详细信息'
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
                            itemId: 'appField'
                            ,padding: '5 0 0 5'
                            ,name: 'app'
                            ,fieldLabel: '应用'
                            ,renderer: function (value, field) {
                                var record = me.down('form').getForm().getRecord();
                                return record.get('appVO')?record.get('appVO').name:'';
                            }
                        }
                        ,{
                            itemId: 'itemNameField'
                            ,padding: '5 0 0 5'
                            ,name: 'itemName'
                            ,fieldLabel: '配置名'
                        }
                        ,{
                            itemId: 'itemValueField'
                            ,padding: '5 0 0 5'
                            ,name: 'itemValue'
                            ,fieldLabel: '配置值'
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