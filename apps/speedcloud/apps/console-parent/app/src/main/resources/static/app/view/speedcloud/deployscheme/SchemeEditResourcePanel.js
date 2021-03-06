Ext.define('AM.view.speedcloud.deployscheme.SchemeEditResourcePanel', {
    extend: 'Ext.tab.Panel'
    ,xtype: 'speedcloud.deployscheme.SchemeEditResourcePanel'
    ,requires:[
        'AM.store.speedcloud.deployscheme.ResourceCategoryStore'
        ,'AM.store.speedcloud.deployscheme.ResourceTypeStore'
        ,'AM.store.speedcloud.env.AppEnvConfigStore'
        ,'AM.store.speedcloud.project.ProjectStore'
        ,'AM.view.speedcloud.deployscheme.SchemeEditResourcePropertyPanel'
    ]
    ,autoScroll: true
    // ,height: '60%'
    // ,width: '60%'
    ,layout: {type: 'vbox'}
    ,title: '资源信息'
    ,viewModel:{
        data:{
            phantom:true
        }
    }
    ,referenceHolder:true
    ,initComponent: function () {
        var me = this;

        Ext.apply(me, {

            items: [
                {
                    xtype: 'form'
                    ,autoScroll: true
                    ,bodyPadding: 10
                    ,title: '基础信息'
                    ,width:'100%'
                    ,fieldDefaults: {
                        labelAlign: 'left'
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
                                columns: 1,
                                tableAttrs: {
                                    style: {
                                        width: '100%'
                                    }
                                }
                            }
                            ,defaults:{width:'100%'}
                            ,items:[


                                ,{
                                    xtype: 'textfield'
                                    ,hidden: false
                                    ,readOnly:false
                                    ,allowBlank:true
                                    ,afterLabelTextTpl: []
                                    ,itemId: 'nameField'
                                    ,name: 'name'
                                    ,fieldLabel: '资源名称'
                                }
                                ,{
                                    xtype: 'textfield'
                                    ,hidden: false
                                    ,readOnly:false
                                    ,allowBlank:true
                                    ,afterLabelTextTpl: []
                                    ,itemId: 'codeField'
                                    ,name: 'code'
                                    ,fieldLabel: '资源代码'
                                }


                                ,{
                                    xtype: 'combobox'
                                    ,store: Ext.create("AM.store.speedcloud.deployscheme.ResourceCategoryStore").load()
                                    ,typeAhead:false
                                    ,editable:false
                                    ,displayField:'name'
                                    ,valueField:'id'
                                    ,hidden: false
                                    ,readOnly:false
                                    ,allowBlank:true
                                    ,afterLabelTextTpl: []
                                    ,itemId: 'categoryField'
                                    ,name: 'category'
                                    ,fieldLabel: '资源类别'
                                }
                                ,{
                                    xtype: 'combobox'
                                    ,store: Ext.create("AM.store.speedcloud.deployscheme.ResourceTypeStore").load()
                                    ,typeAhead:false
                                    ,editable:false
                                    ,displayField:'name'
                                    ,valueField:'id'
                                    ,hidden: false
                                    ,readOnly:false
                                    ,allowBlank:true
                                    ,afterLabelTextTpl: []
                                    ,itemId: 'typeField'
                                    ,name: 'type'
                                    ,fieldLabel: '资源类型'
                                }
                                ,{
                                    xtype: 'textfield'
                                    ,hidden: false
                                    ,readOnly:false
                                    ,allowBlank:true
                                    ,afterLabelTextTpl: []
                                    ,itemId: 'notesField'
                                    ,name: 'notes'
                                    ,fieldLabel: '备注'
                                }
                                , {
                                    xtype: 'fieldset'
                                    ,title: '其他信息'
                                    ,collapsible: true
                                    ,collapsed:true
                                    ,items:[
                                        ,{
                                            xtype: 'textfield'
                                            ,hidden: false
                                            ,readOnly:false
                                            ,allowBlank:true
                                            ,afterLabelTextTpl: []
                                            ,itemId: 'aliasField'
                                            ,name: 'alias'
                                            ,fieldLabel: '资源别名'
                                        }
                                        ,{
                                            xtype: 'combobox'
                                            ,store: [
                                                [true,'是']
                                                ,[false,'否']
                                            ]
                                            ,value:true
                                            ,typeAhead:false
                                            ,editable:false
                                            ,hidden: false
                                            ,readOnly:false
                                            ,allowBlank:true
                                            ,afterLabelTextTpl: []
                                            ,itemId: 'outerResourceField'
                                            ,name: 'outerResource'
                                            ,fieldLabel: '外部资源'
                                        }
                                        ,{
                                            xtype: 'numberfield'
                                            ,allowDecimals:false
                                            ,hidden: false
                                            ,readOnly:false
                                            ,allowBlank:true
                                            ,afterLabelTextTpl: []
                                            ,itemId: 'seqField'
                                            ,name: 'seq'
                                            ,fieldLabel: '顺序号'
                                        }

                                        ,{
                                            xtype: 'textfield'
                                            ,hidden: false
                                            ,readOnly:false
                                            ,allowBlank:true
                                            ,afterLabelTextTpl: []
                                            ,itemId: 'statusField'
                                            ,name: 'status'
                                            ,fieldLabel: '状态'
                                        }
                                        ,{
                                            xtype: 'textfield'
                                            ,hidden: false
                                            ,readOnly:false
                                            ,allowBlank:true
                                            ,afterLabelTextTpl: []
                                            ,itemId: 'versionField'
                                            ,name: 'version'
                                            ,fieldLabel: '版本'
                                        }
                                        ,{

                                            xtype: 'textarea',
                                            anchor: '96% 70%',
                                            itemId: 'descriptionField',
                                            padding: '5 0 0 5',
                                            name: 'description',
                                            fieldLabel: '资源描述',
                                            labelAlign: 'top'
                                        }
                                    ]
                                }



                            ]

                        }

                    ]
                    ,dockedItems: [
                        {
                            xtype: 'toolbar',
                            // dock: 'bottom',
                            dock:'top',
                            ui: 'footer',
                            items: [
                                {
                                    xtype: 'button'
                                    ,iconCls: 'fas fa-save'
                                    ,text: '保存'
                                    ,reference:'saveBtn'
                                    ,disabled:true
                                    ,listeners: {
                                        click: {
                                            fn: me.onSaveButtonClick,
                                            scope: me
                                        }
                                    }
                                }
                            ]
                        }
                    ]
                }
                ,{
                    xtype:'speedcloud.deployscheme.SchemeEditResourcePropertyPanel'
                    ,title:'属性'
                    ,reference:'resourcePropertyPanel'
                    ,disabled:true
                    // ,bind:{disabled:'{phantom}'}
                    ,listeners:{
                        disable:function () {
                            me.setActiveTab(0);
                        }
                    }
                }
            ]

            ,listeners: {
                beforeshow: me.onBeforeShow
            }
        });

        me.callParent(arguments);
    }

    ,onSaveButtonClick: function (button, e, options) {
        var me = this;
        if (!this.down('form').getForm().isValid()) {
            Ext.MessageBox.alert('提交失败', '请检查数据项');
            return;
        }

        var record = this.down('form').getForm().getRecord();

        //将form中的数据刷进record
        this.down('form').getForm().updateRecord(record);
        record.save({
            success: function (newRecord) {
                Ext.MsgUtil.show('操作成功', '保存方案资源成功!');
                me.down('form').getForm().loadRecord(newRecord);
                me.setModel(newRecord);

                me.fireEvent('saved');

            }
        });
    }

    ,setModel: function (model) {

        if(!model){
            Ext.Msg.show({title: '操作失败', msg: "未设置模型", buttons: Ext.Msg.OK, icon: Ext.Msg.ERROR});
            return;
        }
        this.lookup('saveBtn').setDisabled(false)

        this.getViewModel().set('phantom', model.phantom);

        this.getViewModel().set('record', model);

        this.down('form').getForm().loadRecord(model);

        this.lookup('resourcePropertyPanel').getViewModel().set('resource', model);
        this.lookup('resourcePropertyPanel').getViewModel().set('phantom', model.phantom);
        this.lookup('resourcePropertyPanel').setDisabled(model.phantom)
        this.lookup('resourcePropertyPanel').getViewModel().getStore('propertyStore').applyCondition({resource:model.phantom?-999:model.get('id')}).reload();

    }
    ,onBeforeShow:function() {
        console.log(this.getViewModel().get('phantom'))
        this.down('#categoryField').getStore().reload();
       
        this.down('#typeField').getStore().reload();

    }
});