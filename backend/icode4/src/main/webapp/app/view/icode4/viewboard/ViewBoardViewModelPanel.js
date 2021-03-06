Ext.define('AM.view.icode4.viewboard.ViewBoardViewModelPanel', {
    extend: 'Ext.panel.Panel',
    requires:[
	    'AM.store.icode4.system.ModelTypeStore'
	    ,'AM.store.icode4.system.ModuleStore'
	    ,'AM.store.icode4.system.SystemStore'
	    ,'AM.view.icode4.viewboard.ViewBoardViewModelPropertyPanel'
	    ,'AM.store.icode4.view.ViewModelPropertyStore'
    ],
    autoScroll: true,
    height: 350,
    width: 600,
    layout: {
	    type: 'vbox',
	    pack: 'start',
	    align: 'stretch'
    },
    title: '展现对象详细信息',
    maximizable: true,
    closeAction:'hide',
    initComponent: function () {
        var me = this;

        Ext.apply(me, {
            items: [
                {
                    xtype: 'form',
                    autoScroll: true,
                    bodyPadding: 10,
                    fieldDefaults: {
                        labelAlign: 'top'
                        ,msgTarget: 'side'
                        ,padding: '5 0 0 5'
                        ,blankText:'该字段为必填项'
                        ,anchor: '96%'
                    },
                    items: [
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
                                            fieldLabel: '对象名称'
                                        }
                                        ,{
		                                    xtype: 'numberfield',
		                                    allowDecimals:false,
		                                    allowBlank:true,
		                                    itemId: 'viewIndexField',
		                                    name: 'viewIndex',
		                                    fieldLabel: '排序'
	                                    }
	                                    ,{
		                                    xtype: 'combobox',
		                                    store: Ext.create("AM.store.icode4.system.DomainModelStore", {asynchronousLoad:false, autoLoad:false, pageSize:10000}),
		                                    typeAhead:false,
		                                    editable:false,
		                                    disabled:true,
		                                    displayField:'name',
		                                    valueField:'id',
		                                    allowBlank:true,
		                                    itemId: 'domainModelField',
		                                    name: 'domainModelId',
		                                    fieldLabel: '所属领域对象'
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
		                                    xtype: 'textfield',
		                                    allowBlank:false,
		                                    afterLabelTextTpl: [
			                                    '<span style="color:red;font-weight:bold" data-qtip="Required">*</span>'
		                                    ],
		                                    itemId: 'codeField',
		                                    name: 'code',
		                                    fieldLabel: '对象代码'
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
                                            itemId: 'persistField',
                                            name: 'persist',
                                            fieldLabel: '是否持久化'
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
		                    fieldLabel: '描述',
		                    labelAlign: 'top'
	                    }
                    ]
                }
                ,{
            	    xtype:'icode4.viewboard.ViewBoardViewModelPropertyPanel'
		            ,flex:1
		            ,store:Ext.create('AM.store.icode4.view.ViewModelPropertyStore', {pageSize:10000, autoLoad:true})
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
    }
    ,onSaveButtonClick: function (button, e, options) {
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
				me.down('form').getForm().loadRecord(newRecord);
	            me.down('icode4\\.viewboard\\.ViewBoardViewModelPropertyPanel').store.each(function(model){
	                model.set('viewModelId', newRecord.get('id'));
	            });
	            me.down('icode4\\.viewboard\\.ViewBoardViewModelPropertyPanel').store.sync({
		            success:function () {
			            me.fireEvent('saved');
			            me.down('icode4\\.viewboard\\.ViewBoardViewModelPropertyPanel').setViewModel(newRecord);
			            Ext.MsgUtil.show('操作成功', '保存展现对象成功!');
		            }
		            ,failure:function () {

		            }
	            });
            }
        });
    }
    ,setModel: function (model) {
        if(!model){
            Ext.Msg.show({title: '操作失败', msg: "未设置模型", buttons: Ext.Msg.OK, icon: Ext.Msg.ERROR});
            return;
        }

        //this.down('#moduleField').store.load({asynchronousLoad:false});
        this.setTitle("修改展现对象信息");
        if(model.phantom){
            this.setTitle("新增展现对象信息");
        }


		this.down('#domainModelField').getStore().proxy.extraParams = {searchCondition: {moduleId:model.get('moduleId')}};
		this.down('#domainModelField').getStore().load();

		this.down('form').getForm().loadRecord(model);

        this.down('icode4\\.viewboard\\.ViewBoardViewModelPropertyPanel').setViewModel(model);
    }

});