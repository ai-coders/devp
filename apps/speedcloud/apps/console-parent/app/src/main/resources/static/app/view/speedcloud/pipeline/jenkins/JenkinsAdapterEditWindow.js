Ext.define('AM.view.speedcloud.pipeline.jenkins.JenkinsAdapterEditWindow', {
    extend: 'Ext.window.Window'
    ,xtype: 'speedcloud.pipeline.jenkins.JenkinsAdapterEditWindow'
    ,requires:[
        'AM.store.speedcloud.project.ProjectStore'
        ,'AM.store.speedcloud.env.AppEnvConfigStore'
    ]
    ,autoScroll: true
    ,height: '60%'
    ,width: '60%'
    ,layout: {
        type: 'vbox'
        ,pack: 'start'
        ,align: 'stretch'
    }
    ,title: '修改JenkinsAdapter信息'
    ,maximizable: true
    ,closeAction:'hide'
    ,constructor:function(cfg){
        var me = this;
        cfg = cfg || {}

        me.callParent([Ext.apply({
            viewModel : {
                stores:{
                    projectStore:Ext.create("AM.store.speedcloud.project.ProjectStore")
                    ,appEnvConfigStore:Ext.create("AM.store.speedcloud.env.AppEnvConfigStore").applyCondition({project:-999}).load()
                }
            }
        }, cfg)])
    }
    ,initComponent: function () {
        var me = this;

        Ext.apply(me, {
            items: [
                {
                    xtype: 'form',
                    autoScroll: true,
                    bodyPadding: 10
                    ,layout: {
                      type: 'vbox'
                      ,pack: 'start'
                      ,align: 'stretch'
                    }
                  	,flex:1
                    ,width:'100%'
                    ,fieldDefaults: {
                        labelAlign: 'top'
                        ,msgTarget: 'side'
                        ,padding: '5 0 0 5'
                        ,blankText:'该字段为必填项'
                        ,anchor: '96%'
                    },
                    items: [
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
                                    // ,store: Ext.create("AM.store.speedcloud.project.ProjectStore")
                                    ,bind:{store: '{projectStore}'}
                                    ,typeAhead:false
                                    ,editable:false
                                    ,displayField:'name'
                                    ,valueField:'id'
                                    ,hidden: false
                                    ,readOnly:false
                                    ,allowBlank:true
                                    ,afterLabelTextTpl: []
                                    ,itemId: 'projectField'
                                    ,name: 'project'
                                    ,fieldLabel: '所属产品'
                                    ,listeners:{
                                        change:function(field, newValue, oldValue){
                                            var appEnvConfigStore = me.getViewModel().getStore('appEnvConfigStore');
                                            appEnvConfigStore.applyCondition({project:newValue}).load({callback: function(records, operation, success) {
                                                    if(success) {
                                                        me.down('#envField').clearValue();
                                                        if(records && records.length > 0){
                                                            me.down('#envField').select(records[0])
                                                        }
                                                    }
                                                }})
                                        }
                                    }
                                }
                                ,{
                                    xtype: 'combobox'
                                    // ,store: Ext.create("AM.store.speedcloud.env.AppEnvConfigStore")
                                    ,bind:{store: '{appEnvConfigStore}'}
                                    ,typeAhead:false
                                    ,editable:false
                                    ,displayField:'name'
                                    ,valueField:'id'
                                    ,hidden: false
                                    ,readOnly:false
                                    ,allowBlank:true
                                    ,afterLabelTextTpl: []
                                    ,itemId: 'envField'
                                    ,name: 'env'
                                    ,fieldLabel: '所属环境'
                                }
                                ,{
                                    xtype: 'numberfield'
                                    ,allowDecimals:false
                                    ,hidden: false
                                    ,readOnly:false
                                    ,allowBlank:false
                                    ,afterLabelTextTpl: ['<span style="color:red;font-weight:bold" data-qtip="Required">*</span>']
                                    ,itemId: 'portField'
                                    ,name: 'port'
                                    ,fieldLabel: '端口'
                                }
                                ,{
                                    xtype: 'textfield'
                                    ,hidden: false
                                    ,readOnly:false
                                    ,allowBlank:false
                                    ,afterLabelTextTpl: ['<span style="color:red;font-weight:bold" data-qtip="Required">*</span>']
                                    ,itemId: 'hostField'
                                    ,name: 'host'
                                    ,fieldLabel: 'IP'
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
                            iconCls: 'fas fa-save',
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


        //将form中的数据刷进record
        this.down('form').getForm().updateRecord(record);
        record.save({
            success: function (newRecord) {
                Ext.MsgUtil.notification('操作成功', '保存JenkinsAdapter成功!');
                me.down('form').getForm().loadRecord(newRecord);
                me.fireEvent('saved');
                me.hide(this.targetComp);
            }
            ,failure: function(record, operation) {
                //console.log(operation.responseText)
                var response = operation.getResponse();
                var responseBody = Ext.decode(response.responseText)
                Ext.MessageBox.alert('操作失败', "ERROR:"+response.status+"<br/>"+responseBody.message);
            }
        });



    }

    ,setModel: function (model) {
        if(!model){
            Ext.Msg.show({title: '操作失败', msg: "未设置模型", buttons: Ext.Msg.OK, icon: Ext.Msg.ERROR});
            return;
        }

        this.setTitle("修改JenkinsAdapter信息");

        this.down('form').getForm().loadRecord(model);

    }
    ,onBeforeShow:function() {
        this.down('#projectField').getStore().reload();
      
        this.down('#envField').getStore().reload();
      
        // this.lookupReference('mainGridPanel').getStore().reload({scope: this,callback: function(){}});
    }
});