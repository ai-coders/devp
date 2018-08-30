Ext.define('AM.view.icode4.view.ViewModelPropertyAddWindow', {
    extend: 'Ext.window.Window'
    ,requires:[
    'AM.store.icode4.view.ViewModelStore'
    ,'AM.store.icode4.system.DomainModelStore'
    ,'AM.store.icode4.system.DomainModelPropertyStore'
    ]
    ,autoScroll: true
    ,height: 350
    ,width: 600
    ,layout: {
        type: 'fit'
    }
    ,title: '添加新展现对象属性'
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
                                            itemId: 'nameField',
                                            name: 'name',
                                            fieldLabel: '属性名'
                                        }
                                        ,{
	                                        xtype: 'textfield',
                                            allowBlank:false,
                                            afterLabelTextTpl: [
                                            '<span style="color:red;font-weight:bold" data-qtip="Required">*</span>'
                                            ],
                                            itemId: 'typeField',
                                            name: 'type',
                                            fieldLabel: '属性类型'
                                        }
                                        ,{
                                            xtype: 'combobox',
                                            store: [
                                                [true,'是'],
                                                [false,'否']
                                            ],
                                            value:true,
                                            typeAhead:false,
                                            editable:false,
                                            allowBlank:false,
                                            afterLabelTextTpl: [
                                            '<span style="color:red;font-weight:bold" data-qtip="Required">*</span>'
                                            ],
                                            itemId: 'editableField',
                                            name: 'editable',
                                            fieldLabel: '可修改'
                                        }
                                        ,{
	                                        xtype: 'textfield',
                                            allowBlank:true,
                                            itemId: 'memoField',
                                            name: 'memo',
                                            fieldLabel: '备注'
                                        }
                                        ,{
                                            xtype: 'combobox',
                                            store: Ext.create("AM.store.icode4.system.DomainModelStore"),
                                            typeAhead:false,
                                            editable:false,
                                            displayField:'name',
                                            valueField:'id',
                                            allowBlank:true,
                                            itemId: 'domainModelField',
                                            name: 'domainModelId',
                                            fieldLabel: '关联对象'
                                        }
                                        ,{
	                                        xtype: 'textfield',
                                            allowBlank:true,
                                            itemId: 'propertyGroupField',
                                            name: 'propertyGroup',
                                            fieldLabel: '属性组'
                                        }
                                        ,{
                                            xtype: 'combobox',
                                            store: [
                                                [true,'是'],
                                                [false,'否']
                                            ],
                                            value:true,
                                            typeAhead:false,
                                            editable:false,
                                            allowBlank:false,
                                            afterLabelTextTpl: [
                                            '<span style="color:red;font-weight:bold" data-qtip="Required">*</span>'
                                            ],
                                            itemId: 'gridHiddenField',
                                            name: 'gridHidden',
                                            fieldLabel: '列表隐藏'
                                        }
                                        ,{
                                            xtype: 'combobox',
                                            store: [
                                                [true,'是'],
                                                [false,'否']
                                            ],
                                            value:true,
                                            typeAhead:false,
                                            editable:false,
                                            allowBlank:true,
                                            itemId: 'searchConditionField',
                                            name: 'searchCondition',
                                            fieldLabel: '是否查询条件'
                                        }
                                        ,{
                                            xtype: 'combobox',
                                            store: [
                                                [true,'是'],
                                                [false,'否']
                                            ],
                                            value:true,
                                            typeAhead:false,
                                            editable:false,
                                            allowBlank:false,
                                            afterLabelTextTpl: [
                                            '<span style="color:red;font-weight:bold" data-qtip="Required">*</span>'
                                            ],
                                            itemId: 'formHiddenField',
                                            name: 'formHidden',
                                            fieldLabel: '表单隐藏'
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
                                        itemId: 'codeField',
                                        name: 'code',
                                        fieldLabel: '属性代码'
                                        }
                                        ,{
                                            xtype: 'combobox',
                                            store: Ext.create("AM.store.icode4.view.ViewModelStore"),
                                            typeAhead:false,
                                            editable:false,
                                            displayField:'name',
                                            valueField:'id',
                                            allowBlank:false,
                                            afterLabelTextTpl: [
                                            '<span style="color:red;font-weight:bold" data-qtip="Required">*</span>'
                                            ],
                                        itemId: 'viewModelField',
                                        name: 'viewModelId',
                                        fieldLabel: '所属展现对象'
                                        }
                                        ,{
                                            xtype: 'combobox',
                                            store: [
                                            [true,'是'],
                                            [false,'否']
                                            ],
                                            value:true,
                                            typeAhead:false,
                                            editable:false,
                                            allowBlank:false,
                                            afterLabelTextTpl: [
                                            '<span style="color:red;font-weight:bold" data-qtip="Required">*</span>'
                                            ],
                                        itemId: 'nullableField',
                                        name: 'nullable',
                                        fieldLabel: '可为空'
                                        }
                                        ,{
                                            xtype: 'combobox',
                                            store: [
                                            [true,'是'],
                                            [false,'否']
                                            ],
                                            value:true,
                                            typeAhead:false,
                                            editable:false,
                                            allowBlank:false,
                                            afterLabelTextTpl: [
                                            '<span style="color:red;font-weight:bold" data-qtip="Required">*</span>'
                                            ],
                                        itemId: 'coreRelationField',
                                        name: 'coreRelation',
                                        fieldLabel: '核心关联'
                                        }
                                        ,{
                                            xtype: 'combobox',
                                            store: Ext.create("AM.store.icode4.system.DomainModelPropertyStore"),
                                            typeAhead:false,
                                            editable:false,
                                            displayField:'name',
                                            valueField:'id',
                                            allowBlank:true,
                                        itemId: 'domainModelPropertyField',
                                        name: 'domainModelPropertyId',
                                        fieldLabel: '关联对象属性'
                                        }
                                        ,{
                                            xtype: 'numberfield',
                                            allowDecimals:false,
                                            allowBlank:false,
                                            afterLabelTextTpl: [
                                            '<span style="color:red;font-weight:bold" data-qtip="Required">*</span>'
                                            ],
                                        itemId: 'gridIndexField',
                                        name: 'gridIndex',
                                        fieldLabel: '列表排序'
                                        }
                                        ,{
                                            xtype: 'combobox',
                                            store: [
                                            [true,'是'],
                                            [false,'否']
                                            ],
                                            value:true,
                                            typeAhead:false,
                                            editable:false,
                                            allowBlank:true,
                                        itemId: 'quickSearchConditionField',
                                        name: 'quickSearchCondition',
                                        fieldLabel: '是否快速查询条件'
                                        }
                                        ,{
                                            xtype: 'numberfield',
                                            allowDecimals:false,
                                            allowBlank:false,
                                            afterLabelTextTpl: [
                                            '<span style="color:red;font-weight:bold" data-qtip="Required">*</span>'
                                            ],
                                        itemId: 'formIndexField',
                                        name: 'formIndex',
                                        fieldLabel: '表单排序'
                                        }
                                        ,{
                                            xtype: 'numberfield',
                                            allowDecimals:false,
                                            allowBlank:false,
                                            afterLabelTextTpl: [
                                            '<span style="color:red;font-weight:bold" data-qtip="Required">*</span>'
                                            ],
                                        itemId: 'viewIndexField',
                                        name: 'viewIndex',
                                        fieldLabel: '展现排序'
                                        }
                                    ]
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
                Ext.MsgUtil.show('操作成功', '保存展现对象属性成功!');
                me.down('form').getForm().loadRecord(newRecord);
                me.store.load({
                    callback: function (records, operation, success) {
                        if (success) {
                            Ext.MsgUtil.show('操作成功', '同步展现对象属性列表成功');
                        }

                    }
                });
            }
        });


        this.hide(this.targetComp);
    },

    setModel: function (model) {
        if(!model){
            Ext.Msg.show({title: '操作失败', msg: "未设置模型", buttons: Ext.Msg.OK, icon: Ext.Msg.ERROR});
            return;
        }

        this.setTitle("修改展现对象属性信息");
        if(model.phantom){
            this.setTitle("新增展现对象属性信息");
        }
        this.down('form').getForm().loadRecord(model);
    },
    setStore: function (store) {
        this.store = store;
    }

});