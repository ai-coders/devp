Ext.define('AM.view.speedcloud.pipeline.PipelineStageAddWindow', {
    extend: 'Ext.window.Window'
    ,xtype: 'speedcloud.pipeline.PipelineStageAddWindow'
    ,requires:[
        'AM.store.common.SimpleConfigStore'
        ,'AM.store.speedcloud.pipeline.PipelineStore'

    ]
    ,autoScroll: true
    ,height: '60%'
    ,width: '60%'
    ,layout: {
        type: 'vbox'
    }
    ,title: '添加新阶段'
    ,maximizable: true
    ,closeAction: 'hide'
    ,initComponent: function () {
        var me = this;

        var pipelineStageFlowTypeStore = Ext.create("AM.store.common.SimpleConfigStore")
        pipelineStageFlowTypeStore.proxy.isSynchronous = true;
        pipelineStageFlowTypeStore.proxy.extraParams={searchCondition:{configType:'PIPELINESTAGE-FLOWTYPE'}};
        pipelineStageFlowTypeStore.load();
        var pipelineStageExecModeStore = Ext.create("AM.store.common.SimpleConfigStore")
        pipelineStageExecModeStore.proxy.isSynchronous = true;
        pipelineStageExecModeStore.proxy.extraParams={searchCondition:{configType:'PIPELINESTAGE-EXECMODE'}};
        pipelineStageExecModeStore.load();
        Ext.apply(me, {
            items: [
                {
                    xtype: 'form'
                    ,autoScroll: true
                    ,bodyPadding: 10
                    ,width:'100%'
                    ,fieldDefaults: {
                        labelAlign: 'right'
                        ,msgTarget: 'side'
                        ,padding: '5 0 0 5'
                        ,blankText:'该字段为必填项'
                        ,anchor: '96%'
                    }
                    ,items: [
                        {
                            xtype:'container'
                            ,anchor: '96% 70%'
                            ,layout: {
                                type: 'table',
                                columns: 3,
                                tableAttrs: {
                                    style: {
                                        width: '100%'
                                    }
                                }
                            }
                            ,defaults:{width:'100%'}
                            ,items:[

                                ,{
                                    xtype: 'combobox'
                                    ,store: Ext.create("AM.store.speedcloud.pipeline.PipelineStore")
                                    ,typeAhead:false
                                    ,editable:false
                                    ,displayField:'name'
                                    ,valueField:'id'
                                    ,hidden: false
                                    ,readOnly:false
                                    ,allowBlank:true
                                    ,afterLabelTextTpl: []
                                    ,itemId: 'pipelineField'
                                    ,name: 'pipeline'
                                    ,fieldLabel: '所属流水线'
                                }


                                ,{
                                    xtype: 'textfield'
                                    ,hidden: false
                                    ,readOnly:false
                                    ,allowBlank:true
                                    ,afterLabelTextTpl: []
                                    ,itemId: 'nameField'
                                    ,name: 'name'
                                    ,fieldLabel: '阶段名称'
                                }


                                ,{
                                    xtype: 'combobox'
                                    ,store: pipelineStageFlowTypeStore
                                    ,typeAhead:false
                                    ,editable:false
                                    ,displayField:'displayName'
                                    ,valueField:'code'
                                    ,hidden: false
                                    ,readOnly:false
                                    ,allowBlank:true
                                    ,afterLabelTextTpl: []
                                    ,itemId: 'flowTypeField'
                                    ,name: 'flowType'
                                    ,fieldLabel: '流转方式'
                                }


                                ,{
                                    xtype: 'combobox'
                                    ,store: pipelineStageExecModeStore
                                    ,typeAhead:false
                                    ,editable:false
                                    ,displayField:'displayName'
                                    ,valueField:'code'
                                    ,hidden: false
                                    ,readOnly:false
                                    ,allowBlank:true
                                    ,afterLabelTextTpl: []
                                    ,itemId: 'execModeField'
                                    ,name: 'execMode'
                                    ,fieldLabel: '执行方式'
                                }

                            ]
                        }
                    ]
                }
            ],
            dockedItems: [
                {
                    xtype: 'toolbar',
                    dock: 'bottom',
                    ui: 'footer',
                    items: [
                        {
                            xtype: 'tbfill'
                        },
                        {
                            xtype: 'button',
                            iconCls: 'accept',
                            text: '确定',
                            listeners: {
                                click: {
                                    fn: me.onSaveButtonClick,
                                    scope: me
                                }
                            }
                        }
                    ]
                }
            ]
            ,listeners: {
                beforeshow: me.onBeforeShow
            }
        });

        me.callParent(arguments);
    },

    onSaveButtonClick: function (button, e, options) {
        var me = this;
        if (!this.down('form').getForm().isValid()) {
            Ext.MessageBox.alert('提交失败', '请检查数据项');
            return;
        }

        //var id = this.down("#idField").getValue();

        var record = this.down('form').getForm().getRecord();


        //将form中得数据刷进record
        this.down('form').getForm().updateRecord(record);
        record.save({
            success: function (newRecord) {
                Ext.MsgUtil.show('操作成功', '保存阶段成功!');
                me.down('form').getForm().loadRecord(newRecord);
                me.fireEvent('saved');
                me.hide(this.targetComp);

            }
        });
    },

    setModel: function (model) {
        if(!model){
            Ext.Msg.show({title: '操作失败', msg: "未设置模型", buttons: Ext.Msg.OK, icon: Ext.Msg.ERROR});
            return;
        }
        this.down('form').getForm().loadRecord(model);

    }
    ,onBeforeShow:function() {
        this.down('#pipelineField').getStore().reload();
        this.down('#flowTypeField').getStore().reload();
        this.down('#execModeField').getStore().reload();
        // this.lookupReference('mainGridPanel').getStore().reload({scope: this,callback: function(){}});
    }
});