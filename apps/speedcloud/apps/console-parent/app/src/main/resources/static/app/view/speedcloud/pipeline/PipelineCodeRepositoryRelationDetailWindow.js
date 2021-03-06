Ext.define('AM.view.speedcloud.pipeline.PipelineCodeRepositoryRelationDetailWindow', {
    extend: 'Ext.window.Window'
    ,xtype: 'speedcloud.pipeline.PipelineCodeRepositoryRelationDetailWindow'
    ,autoScroll: true
    ,height: 350
    ,width: 700
    ,layout: {
        type: 'fit'
    }
    ,title: '流水线代码库关联详细信息'
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
                            itemId: 'codeRepositoryField'
                            ,padding: '5 0 0 5'
                            ,name: 'codeRepository'
                            ,fieldLabel: '代码库'
                            ,renderer: function (value, field) {

                                var record = me.down('form').getForm().getRecord();

                                return record.get('codeRepositoryVO').url;
                            }
                        }
                        ,{
                            itemId: 'pipelineField'
                            ,padding: '5 0 0 5'
                            ,name: 'pipeline'
                            ,fieldLabel: '流水线'
                            ,renderer: function (value, field) {

                                var record = me.down('form').getForm().getRecord();

                                return record.get('pipelineVO').name;
                            }
                        }
                        ,{
                            itemId: 'autoStartField'
                            ,padding: '5 0 0 5'
                            ,name: 'autoStart'
                            ,fieldLabel: '提交代码触发流水线'
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