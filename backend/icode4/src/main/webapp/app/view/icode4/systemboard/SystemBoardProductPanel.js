Ext.define('AM.view.icode4.systemboard.SystemBoardProductPanel', {
    extend: 'Ext.panel.Panel',
    requires:[
    ],
    autoScroll: true,
    layout: {
        type: 'fit'
    },
    title: '产品信息',
    maximizable: true,
    closeAction:'hide',
    initComponent: function () {
        var me = this;

        Ext.apply(me, {
            items: [
                {
                    xtype: 'form'
                    ,autoScroll: true
                    ,bodyPadding: 10
                    ,fieldDefaults: {
                        labelAlign: 'top'
                        ,msgTarget: 'side'
                        ,padding: '5 0 0 5'
                        ,blankText:'该字段为必填项'
                        ,anchor: '96%'
                    }
                    ,items: [
                        {
                            xtype: 'container',
                            layout: {
                                type: 'column'
                            },
                            items: [
                                {
                                    xtype: 'container',
                                    columnWidth: 0.5,
                                    layout: {
                                        type: 'anchor'
                                    },
                                    items: [
                                        {
                                            xtype: 'hiddenfield',
                                            anchor: '100%',
                                            itemId: 'idField',
                                            name: 'id',
                                            fieldLabel: 'Label'
                                        }
                                        ,{
                                            xtype: 'textfield',
                                            allowBlank:false,
                                            afterLabelTextTpl: [
                                                '<span style="color:red;font-weight:bold" data-qtip="Required">*</span>'
                                            ],
                                            itemId: 'productNameField',
                                            name: 'productName',
                                            fieldLabel: '产品名称'
                                        }

                                    ]
                                },
                                {
                                    xtype: 'container',
                                    columnWidth: 0.5,
                                    layout: {
                                        type: 'anchor'
                                    },
                                    items: [
                                        {
                                            xtype: 'hiddenfield',
                                            anchor: '100%',
                                            itemId: 'versionField',
                                            name: 'version',
                                            fieldLabel: 'Label'
                                        }
                                        ,{
                                            xtype: 'textfield',
                                            allowBlank:false,
                                            afterLabelTextTpl: [
                                                '<span style="color:red;font-weight:bold" data-qtip="Required">*</span>'
                                            ],
                                            itemId: 'productCodeField',
                                            name: 'productCode',
                                            fieldLabel: '产品代码'
                                        }
                                    ]
                                }
                            ]
                        }
                        ,{

                            xtype: 'textarea',
                            anchor: '98% 70%',
                            itemId: 'descriptionField',
                            padding: '5 0 0 5',
                            name: 'description',
                            fieldLabel: '产品说明',
                            labelAlign: 'top'
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
        });

        me.callParent(arguments);
    },

    onSaveButtonClick: function (button, e, options) {
        var me = this;
        if (!this.down('form').getForm().isValid()) {
            Ext.MessageBox.alert('提交失败', '请检查数据项');
            return;
        }

        var id = this.down("#idField").getValue();

        var record = this.down('form').getForm().getRecord();


        //将form中得数据刷进record
        this.down('form').getForm().updateRecord(record);
        record.save({
            success: function (newRecord) {
                Ext.MsgUtil.show('操作成功', '保存系统信息成功!');
                me.down('form').getForm().loadRecord(newRecord);
                me.fireEvent('saved');
            }
        });

    },

    setModel: function (model) {
        if(!model){
            Ext.Msg.show({title: '操作失败', msg: "未设置模型", buttons: Ext.Msg.OK, icon: Ext.Msg.ERROR});
            return;
        }

        this.setTitle("修改产品信息");
        if(model.phantom){
            this.setTitle("新增产品信息");
        }
        this.down('form').getForm().loadRecord(model);
    },
    setStore: function (store) {
        this.store = store;
    }

});