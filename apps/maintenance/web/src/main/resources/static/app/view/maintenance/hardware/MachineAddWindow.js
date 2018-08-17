Ext.define('AM.view.maintenance.hardware.MachineAddWindow', {
    extend: 'Ext.window.Window'
    ,xtype: 'maintenance.hardware.MachineAddWindow'
    ,requires:[
    ]
    ,autoScroll: true
    ,height: '80%'
    ,width: '80%'
    ,layout: {
        type: 'vbox'
    }
    ,title: '添加新服务器'
    ,maximizable: true
    ,closeAction: 'hide'
    ,initComponent: function () {
        var me = this;

        var machineStatusStore = Ext.create("AM.store.application.common.SimpleConfigStore")
        machineStatusStore.proxy.isSynchronous = true;
        machineStatusStore.proxy.extraParams={searchCondition:{configType:'MACHINE-STATUS'}};
        machineStatusStore.load();
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
                    ,

                    items: [
                        {
                            xtype:'fieldset'
                            ,title:'基础信息'
                            ,collapsible: true
                            ,layout:'column'
                            ,anchor: '96%'
                            ,defaults:{columnWidth:0.33,layout:'anchor'}
                            ,items:[
                                {
                                    defaults:{anchor: '100%'}
                                    ,items:[
                                        ,{
                                            xtype: 'textfield',
                                            allowBlank:false,
                                            afterLabelTextTpl: [
                                                '<span style="color:red;font-weight:bold" data-qtip="Required">*</span>'
                                            ],
                                            itemId: 'nameField',
                                            name: 'name',
                                            fieldLabel: '名称'

                                        }
                                        ,{
                                            xtype: 'textfield',
                                            allowBlank:true,
                                            itemId: 'codeField',
                                            name: 'code',
                                            fieldLabel: '代码'

                                        }
                                        ,{
                                            xtype: 'textfield',
                                            allowBlank:true,
                                            itemId: 'aliasField',
                                            name: 'alias',
                                            fieldLabel: '别名'

                                        }
                                        ,{
                                            xtype: 'textfield',
                                            allowBlank:true,
                                            itemId: 'typeCodeField',
                                            name: 'typeCode',
                                            fieldLabel: '类型代码'

                                        }
                                    ]
                                }
                                ,{
                                    defaults:{anchor: '100%'}
                                    ,items:[
                                        ,{
                                            xtype: 'textfield',
                                            allowBlank:true,
                                            itemId: 'typeNameField',
                                            name: 'typeName',
                                            fieldLabel: '类型名称'

                                        }
                                        ,{
                                            xtype: 'textfield',
                                            allowBlank:true,
                                            itemId: 'hardwareModelField',
                                            name: 'hardwareModel',
                                            fieldLabel: '硬件型号'

                                        }
                                        ,{
                                            xtype: 'textfield',
                                            allowBlank:true,
                                            itemId: 'softwareModelField',
                                            name: 'softwareModel',
                                            fieldLabel: '软件型号'

                                        }
                                        ,{
                                            xtype: 'combobox',
                                            store: machineStatusStore,
                                            typeAhead:false,
                                            editable:false,
                                            displayField:'displayName',
                                            valueField:'value',
                                            allowBlank:true,
                                            itemId: 'statusField',
                                            name: 'status',
                                            fieldLabel: '状态'

                                        }
                                    ]
                                }
                                ,{
                                    defaults:{anchor: '100%'}
                                    ,items:[
                                        ,{
                                            xtype: 'datefield',
                                            format: 'Y-m-d',
                                            allowBlank:true,
                                            itemId: 'createDateField',
                                            name: 'createDate',
                                            fieldLabel: '创建时间'

                                        }
                                        ,{
                                            xtype: 'datefield',
                                            format: 'Y-m-d',
                                            allowBlank:true,
                                            itemId: 'expireDateField',
                                            name: 'expireDate',
                                            fieldLabel: '到期时间'

                                        }
                                        ,{
                                            xtype: 'datefield',
                                            format: 'Y-m-d',
                                            allowBlank:true,
                                            itemId: 'goliveDateField',
                                            name: 'goliveDate',
                                            fieldLabel: '启用时间'

                                        }
                                    ]
                                }
                            ]
                        }
                        ,{
                            xtype: 'fieldset'
                            , title: '其他信息'
                            , collapsible: true
                            , layout: 'column'
                            , anchor: '96%'
                            , defaults: {columnWidth: 0.33, layout: 'anchor'}
                            , items: [
                                {
                                    defaults: {anchor: '100%'}
                                    , items: [
                                        ,{
                                            xtype: 'textfield',
                                            allowBlank:true,
                                            itemId: 'assetProjectField',
                                            name: 'assetProject',
                                            fieldLabel: '所属项目'

                                        }
                                        ,{
                                            xtype: 'textfield',
                                            allowBlank:true,
                                            itemId: 'assetAreaField',
                                            name: 'assetArea',
                                            fieldLabel: '所属区域'

                                        }
                                        ,{
                                            xtype: 'textfield',
                                            allowBlank:true,
                                            itemId: 'assetLocationField',
                                            name: 'assetLocation',
                                            fieldLabel: '资产位置'

                                        }
                                    ]
                                }
                                ,{
                                    defaults: {anchor: '100%'}
                                    , items: [
                                        ,{
                                            xtype: 'textfield',
                                            allowBlank:true,
                                            itemId: 'intAccessAddrField',
                                            name: 'intAccessAddr',
                                            fieldLabel: '内部访问地址'

                                        }
                                        ,{
                                            xtype: 'textfield',
                                            allowBlank:true,
                                            itemId: 'extAccessAddrField',
                                            name: 'extAccessAddr',
                                            fieldLabel: '外部访问地址'

                                        }
                                    ]
                                },{
                                    defaults: {anchor: '100%'}
                                    , items: [
                                        ,{
                                            xtype: 'textfield',
                                            allowBlank:true,
                                            itemId: 'acquisitionModeField',
                                            name: 'acquisitionMode',
                                            fieldLabel: '获取方式'

                                        }
                                        ,{
                                            xtype: 'textfield',
                                            allowBlank:true,
                                            itemId: 'acquisitionDescField',
                                            name: 'acquisitionDesc',
                                            fieldLabel: '获取方式说明'

                                        }
                                        ,{
                                            xtype: 'textfield',
                                            allowBlank:true,
                                            itemId: 'assetDeptField',
                                            name: 'assetDept',
                                            fieldLabel: '归属部门'

                                        }
                                        ,{
                                            xtype: 'textfield',
                                            allowBlank:true,
                                            itemId: 'assetManagerField',
                                            name: 'assetManager',
                                            fieldLabel: '资产负责人'

                                        }
                                        ,{
                                            xtype: 'textfield',
                                            allowBlank:true,
                                            itemId: 'useDeptField',
                                            name: 'useDept',
                                            fieldLabel: '使用部门'

                                        }
                                        ,{
                                            xtype: 'textfield',
                                            allowBlank:true,
                                            itemId: 'useManagerField',
                                            name: 'useManager',
                                            fieldLabel: '使用负责人'

                                        }
                                        ,{
                                            xtype: 'textfield',
                                            allowBlank:true,
                                            itemId: 'opsDeptField',
                                            name: 'opsDept',
                                            fieldLabel: '维护部门'

                                        }
                                        ,{
                                            xtype: 'textfield',
                                            allowBlank:true,
                                            itemId: 'opsManagerField',
                                            name: 'opsManager',
                                            fieldLabel: '维护负责人'

                                        }
                                        ,{
                                            xtype: 'textfield',
                                            allowBlank:true,
                                            itemId: 'bizLineField',
                                            name: 'bizLine',
                                            fieldLabel: '业务线'

                                        }
                                        ,{
                                            xtype: 'textfield',
                                            allowBlank:true,
                                            itemId: 'bizManagerField',
                                            name: 'bizManager',
                                            fieldLabel: '业务代表'

                                        }

                                        ,{
                                            xtype: 'textfield',
                                            allowBlank:true,
                                            itemId: 'majorCustField',
                                            name: 'majorCust',
                                            fieldLabel: '主要客户'

                                        }
                                        ,{
                                            xtype: 'textfield',
                                            allowBlank:true,
                                            itemId: 'custManagerField',
                                            name: 'custManager',
                                            fieldLabel: '客户代表'

                                        }
                                        ,{
                                            xtype: 'textfield',
                                            allowBlank:true,
                                            itemId: 'custUsageField',
                                            name: 'custUsage',
                                            fieldLabel: '使用情况'

                                        }
                                        ,{
                                            xtype: 'textfield',
                                            allowBlank:true,
                                            itemId: 'notesField',
                                            name: 'notes',
                                            fieldLabel: '备注'

                                        }
                                        ,{
                                            xtype: 'textfield',
                                            allowBlank:true,
                                            itemId: 'parasCodeField',
                                            name: 'parasCode',
                                            fieldLabel: '参数定义标识'

                                        }
                                        ,{
                                            xtype: 'textfield',
                                            allowBlank:true,
                                            itemId: 'acquisitionProviderField',
                                            name: 'acquisitionProvider',
                                            fieldLabel: '供应商'

                                        }
                                    ]
                                }
                            ]
                        }



                        ,{

                            xtype: 'textarea',
                            anchor: '96% 70%',
                            itemId: 'descriptionField',
                            padding: '5 0 0 5',
                            name: 'description',
                            fieldLabel: '描述',
                            labelAlign: 'top'
                        }


                    ]
                }
                ,{xtype:'fileuploadpanel', itemId:'fileuploadpanel-attachment'}
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

        //var id = this.down("#idField").getValue();

        var record = this.down('form').getForm().getRecord();


        //将form中得数据刷进record
        this.down('form').getForm().updateRecord(record);
        record.save({
            success: function (newRecord) {
                Ext.MsgUtil.show('操作成功', '保存服务器成功!');
                me.down('form').getForm().loadRecord(newRecord);
                me.fireEvent('saved');
                me.hide(this.targetComp);

                me.down('#fileuploadpanel-attachment').save(newRecord, 'Machine-attachment')
            }
        });



    },

    setModel: function (model) {
        if(!model){
            Ext.Msg.show({title: '操作失败', msg: "未设置模型", buttons: Ext.Msg.OK, icon: Ext.Msg.ERROR});
            return;
        }

        this.setTitle("修改服务器信息");
        if(model.phantom){
            this.setTitle("新增服务器信息");
        }
        this.down('form').getForm().loadRecord(model);
    }

});