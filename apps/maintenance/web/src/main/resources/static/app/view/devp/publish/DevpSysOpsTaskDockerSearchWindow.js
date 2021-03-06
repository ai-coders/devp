Ext.define('AM.view.devp.publish.DevpSysOpsTaskDockerSearchWindow', {
    extend: 'Ext.window.Window'
    ,xtype: 'devp.publish.DevpSysOpsTaskDockerSearchWindow'
    ,alias: 'widget.devppublishDevpSysOpsTaskDockerSearchWindow'
    ,autoScroll: true
    ,height: '60%'
    ,width: '60%'
    ,layout: {
        type: 'fit'
    }
    ,title: '部署容器高级查询'
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
                    ,width:'100%'
                    ,fieldDefaults: {
                        labelAlign: 'top'
                        ,msgTarget: 'side'
                        ,padding: '5 0 0 5'
                        ,blankText:'该字段为必填项'
                        ,anchor: '96%'
                    }
                    ,layout: {
                        type: 'table'
                        ,columns: 2
                        ,tableAttrs: {style: {width: '100%'}}
                    }
                    ,defaults:{width:'100%'}
                    ,items:[
                        ,{
                            xtype: 'numberfield'
                            ,allowDecimals:false
                            ,itemId: 'tidField'
                            ,fieldLabel: '租户编号'
                        }
                        ,{
                            xtype: 'numberfield'
                            ,allowDecimals:false
                            ,itemId: 'tidMaxField'
                            ,fieldLabel: '租户编号'
                        }
                        ,{
                            xtype: 'numberfield'
                            ,allowDecimals:false
                            ,itemId: 'tidMinField'
                            ,fieldLabel: '租户编号'
                        }

                        ,{
                            xtype: 'textfield'
                            ,itemId: 'etypeField'
                            ,fieldLabel: '元素类型'
                        }

                        ,{
                            xtype: 'textfield'
                            ,itemId: 'nameField'
                            ,fieldLabel: '系统元素名称'
                        }

                        ,{
                            xtype: 'textfield'
                            ,itemId: 'codeField'
                            ,fieldLabel: '系统元素代码'
                        }

                        ,{
                            xtype: 'textfield'
                            ,itemId: 'aliasField'
                            ,fieldLabel: '系统元素别名'
                        }

                        ,{
                            xtype: 'textfield'
                            ,itemId: 'descriptionField'
                            ,fieldLabel: '系统元素描述'
                        }

                        ,{
                            xtype: 'numberfield'
                            ,allowDecimals:false
                            ,itemId: 'recordStateField'
                            ,fieldLabel: '记录状态'
                        }
                        ,{
                            xtype: 'numberfield'
                            ,allowDecimals:false
                            ,itemId: 'recordStateMaxField'
                            ,fieldLabel: '记录状态'
                        }
                        ,{
                            xtype: 'numberfield'
                            ,allowDecimals:false
                            ,itemId: 'recordStateMinField'
                            ,fieldLabel: '记录状态'
                        }

                        ,{
                            xtype: 'textfield'
                            ,itemId: 'typeField'
                            ,fieldLabel: '类型'
                        }

                        ,{
                            xtype: 'textfield'
                            ,itemId: 'subTypeField'
                            ,fieldLabel: '子类型'
                        }

                        ,{
                            xtype: 'textfield'
                            ,itemId: 'groupField'
                            ,fieldLabel: '所在集群'
                        }

                        ,{
                            xtype: 'textfield'
                            ,itemId: 'namespaceField'
                            ,fieldLabel: '命名空间'
                        }

                        ,{
                            xtype: 'textfield'
                            ,itemId: 'publishGroupField'
                            ,fieldLabel: '发布物分组'
                        }

                        ,{
                            xtype: 'textfield'
                            ,itemId: 'publishArtifactField'
                            ,fieldLabel: '发布物'
                        }

                        ,{
                            xtype: 'textfield'
                            ,itemId: 'publishVersionField'
                            ,fieldLabel: '版本标识'
                        }

                        ,{
                            xtype: 'textfield'
                            ,itemId: 'publishFileField'
                            ,fieldLabel: '发布文件名'
                        }

                        ,{
                            xtype: 'numberfield'
                            ,allowDecimals:false
                            ,itemId: 'instancesNumField'
                            ,fieldLabel: '实例个数'
                        }
                        ,{
                            xtype: 'numberfield'
                            ,allowDecimals:false
                            ,itemId: 'instancesNumMaxField'
                            ,fieldLabel: '实例个数'
                        }
                        ,{
                            xtype: 'numberfield'
                            ,allowDecimals:false
                            ,itemId: 'instancesNumMinField'
                            ,fieldLabel: '实例个数'
                        }

                        ,{
                            xtype: 'numberfield'
                            ,allowDecimals:false
                            ,itemId: 'cpuField'
                            ,fieldLabel: 'CPU'
                        }
                        ,{
                            xtype: 'numberfield'
                            ,allowDecimals:false
                            ,itemId: 'cpuMaxField'
                            ,fieldLabel: 'CPU'
                        }
                        ,{
                            xtype: 'numberfield'
                            ,allowDecimals:false
                            ,itemId: 'cpuMinField'
                            ,fieldLabel: 'CPU'
                        }

                        ,{
                            xtype: 'numberfield'
                            ,allowDecimals:true
                            ,itemId: 'memoryField'
                            ,fieldLabel: '内存(G)'
                        }
                        ,{
                            xtype: 'numberfield'
                            ,allowDecimals:true
                            ,itemId: 'memoryMaxField'
                            ,fieldLabel: '内存(G)'
                        }
                        ,{
                            xtype: 'numberfield'
                            ,allowDecimals:true
                            ,itemId: 'memoryMinField'
                            ,fieldLabel: '内存(G)'
                        }

                        ,{
                            xtype: 'numberfield'
                            ,allowDecimals:false
                            ,itemId: 'serviceableField'
                            ,fieldLabel: '发布为服务'
                        }
                        ,{
                            xtype: 'numberfield'
                            ,allowDecimals:false
                            ,itemId: 'serviceableMaxField'
                            ,fieldLabel: '发布为服务'
                        }
                        ,{
                            xtype: 'numberfield'
                            ,allowDecimals:false
                            ,itemId: 'serviceableMinField'
                            ,fieldLabel: '发布为服务'
                        }

                        ,{
                            xtype: 'textfield'
                            ,itemId: 'lbStrategyField'
                            ,fieldLabel: '负载策略'
                        }

                        ,{
                            xtype: 'textfield'
                            ,itemId: 'accessTypeField'
                            ,fieldLabel: '访问类型'
                        }

                        ,{
                            xtype: 'textfield'
                            ,itemId: 'statusField'
                            ,fieldLabel: '状态'
                        }

                        ,{
                            xtype: 'textfield'
                            ,itemId: 'notesField'
                            ,fieldLabel: '备注'
                        }

                        ,{
                            xtype: 'numberfield'
                            ,allowDecimals:false
                            ,itemId: 'prdRidField'
                            ,fieldLabel: '产品编号'
                        }
                        ,{
                            xtype: 'numberfield'
                            ,allowDecimals:false
                            ,itemId: 'prdRidMaxField'
                            ,fieldLabel: '产品编号'
                        }
                        ,{
                            xtype: 'numberfield'
                            ,allowDecimals:false
                            ,itemId: 'prdRidMinField'
                            ,fieldLabel: '产品编号'
                        }

                        ,{
                            xtype: 'numberfield'
                            ,allowDecimals:false
                            ,itemId: 'schemeRidField'
                            ,fieldLabel: '部署方案编号'
                        }
                        ,{
                            xtype: 'numberfield'
                            ,allowDecimals:false
                            ,itemId: 'schemeRidMaxField'
                            ,fieldLabel: '部署方案编号'
                        }
                        ,{
                            xtype: 'numberfield'
                            ,allowDecimals:false
                            ,itemId: 'schemeRidMinField'
                            ,fieldLabel: '部署方案编号'
                        }

                        ,{
                            xtype: 'numberfield'
                            ,allowDecimals:false
                            ,itemId: 'cmpRidField'
                            ,fieldLabel: '组件编号'
                        }
                        ,{
                            xtype: 'numberfield'
                            ,allowDecimals:false
                            ,itemId: 'cmpRidMaxField'
                            ,fieldLabel: '组件编号'
                        }
                        ,{
                            xtype: 'numberfield'
                            ,allowDecimals:false
                            ,itemId: 'cmpRidMinField'
                            ,fieldLabel: '组件编号'
                        }

                        ,{
                            xtype: 'numberfield'
                            ,allowDecimals:false
                            ,itemId: 'taskRidField'
                            ,fieldLabel: '任务编号'
                        }
                        ,{
                            xtype: 'numberfield'
                            ,allowDecimals:false
                            ,itemId: 'taskRidMaxField'
                            ,fieldLabel: '任务编号'
                        }
                        ,{
                            xtype: 'numberfield'
                            ,allowDecimals:false
                            ,itemId: 'taskRidMinField'
                            ,fieldLabel: '任务编号'
                        }

                        ,{
                            xtype: 'numberfield'
                            ,allowDecimals:false
                            ,itemId: 'seqField'
                            ,fieldLabel: '顺序号'
                        }
                        ,{
                            xtype: 'numberfield'
                            ,allowDecimals:false
                            ,itemId: 'seqMaxField'
                            ,fieldLabel: '顺序号'
                        }
                        ,{
                            xtype: 'numberfield'
                            ,allowDecimals:false
                            ,itemId: 'seqMinField'
                            ,fieldLabel: '顺序号'
                        }

                        ,{
                            xtype: 'textfield'
                            ,itemId: 'createUcodeField'
                            ,fieldLabel: '创建用户代码'
                        }

                        ,{
                            xtype: 'textfield'
                            ,itemId: 'createUnameField'
                            ,fieldLabel: '创建用户姓名'
                        }

                        ,{
                            xtype: 'textfield'
                            ,itemId: 'modifyUcodeField'
                            ,fieldLabel: '修改用户代码'
                        }

                        ,{
                            xtype: 'textfield'
                            ,itemId: 'modifyUnameField'
                            ,fieldLabel: '修改用户姓名'
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
                        }

                        ,{
                            xtype: 'button',
                            iconCls: 'page_white',
                            text: '重置',
                            listeners: {
                                click: {
                                    fn: me.onRestButtonClick,
                                    scope: me
                                }
                            }
                        }
                        ,{
                            xtype: 'button',
                            iconCls: 'search',
                            text: '查询',
                            listeners: {
                                click: {
                                    fn: me.onSearchButtonClick,
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

    ,onSearchButtonClick: function (button, e, options) {

        var me = this;
        if (!this.down('form').getForm().isValid()) {
            Ext.MessageBox.alert('提交失败', '请检查数据项');
            return;
        }

        me.fireEvent('saved');
        me.hide();
    }
    ,onRestButtonClick: function (button, e, options) {
        var me = this;
        me.down('form').getForm().reset();

        me.fireEvent('saved');


    }
    ,getCondition: function(){

        var me = this;
        var tidField = me.down("#tidField");
        var tidMaxField = me.down("#tidMaxField");
        var tidMinField = me.down("#tidMinField");
        var etypeField = me.down("#etypeField");
        var nameField = me.down("#nameField");
        var codeField = me.down("#codeField");
        var aliasField = me.down("#aliasField");
        var descriptionField = me.down("#descriptionField");
        var recordStateField = me.down("#recordStateField");
        var recordStateMaxField = me.down("#recordStateMaxField");
        var recordStateMinField = me.down("#recordStateMinField");
        var typeField = me.down("#typeField");
        var subTypeField = me.down("#subTypeField");
        var groupField = me.down("#groupField");
        var namespaceField = me.down("#namespaceField");
        var publishGroupField = me.down("#publishGroupField");
        var publishArtifactField = me.down("#publishArtifactField");
        var publishVersionField = me.down("#publishVersionField");
        var publishFileField = me.down("#publishFileField");
        var instancesNumField = me.down("#instancesNumField");
        var instancesNumMaxField = me.down("#instancesNumMaxField");
        var instancesNumMinField = me.down("#instancesNumMinField");
        var cpuField = me.down("#cpuField");
        var cpuMaxField = me.down("#cpuMaxField");
        var cpuMinField = me.down("#cpuMinField");
        var memoryField = me.down("#memoryField");
        var serviceableField = me.down("#serviceableField");
        var serviceableMaxField = me.down("#serviceableMaxField");
        var serviceableMinField = me.down("#serviceableMinField");
        var lbStrategyField = me.down("#lbStrategyField");
        var accessTypeField = me.down("#accessTypeField");
        var statusField = me.down("#statusField");
        var notesField = me.down("#notesField");
        var prdRidField = me.down("#prdRidField");
        var prdRidMaxField = me.down("#prdRidMaxField");
        var prdRidMinField = me.down("#prdRidMinField");
        var schemeRidField = me.down("#schemeRidField");
        var schemeRidMaxField = me.down("#schemeRidMaxField");
        var schemeRidMinField = me.down("#schemeRidMinField");
        var cmpRidField = me.down("#cmpRidField");
        var cmpRidMaxField = me.down("#cmpRidMaxField");
        var cmpRidMinField = me.down("#cmpRidMinField");
        var taskRidField = me.down("#taskRidField");
        var taskRidMaxField = me.down("#taskRidMaxField");
        var taskRidMinField = me.down("#taskRidMinField");
        var seqField = me.down("#seqField");
        var seqMaxField = me.down("#seqMaxField");
        var seqMinField = me.down("#seqMinField");
        var createUcodeField = me.down("#createUcodeField");
        var createUnameField = me.down("#createUnameField");
        var modifyUcodeField = me.down("#modifyUcodeField");
        var modifyUnameField = me.down("#modifyUnameField");

        var condition = {
            tid:Ext.isNumber(tidField.getValue())?tidField.getValue():null
            ,tidMax:Ext.isNumber(tidMaxField.getValue())?tidMaxField.getValue():null
            ,tidMin:Ext.isNumber(tidMinField.getValue())?tidMinField.getValue():null
            ,etype:Ext.isEmpty(etypeField.getValue())?null:etypeField.getValue()
            ,name:Ext.isEmpty(nameField.getValue())?null:nameField.getValue()
            ,code:Ext.isEmpty(codeField.getValue())?null:codeField.getValue()
            ,alias:Ext.isEmpty(aliasField.getValue())?null:aliasField.getValue()
            ,description:Ext.isEmpty(descriptionField.getValue())?null:descriptionField.getValue()
            ,recordState:Ext.isNumber(recordStateField.getValue())?recordStateField.getValue():null
            ,recordStateMax:Ext.isNumber(recordStateMaxField.getValue())?recordStateMaxField.getValue():null
            ,recordStateMin:Ext.isNumber(recordStateMinField.getValue())?recordStateMinField.getValue():null
            ,type:Ext.isEmpty(typeField.getValue())?null:typeField.getValue()
            ,subType:Ext.isEmpty(subTypeField.getValue())?null:subTypeField.getValue()
            ,group:Ext.isEmpty(groupField.getValue())?null:groupField.getValue()
            ,namespace:Ext.isEmpty(namespaceField.getValue())?null:namespaceField.getValue()
            ,publishGroup:Ext.isEmpty(publishGroupField.getValue())?null:publishGroupField.getValue()
            ,publishArtifact:Ext.isEmpty(publishArtifactField.getValue())?null:publishArtifactField.getValue()
            ,publishVersion:Ext.isEmpty(publishVersionField.getValue())?null:publishVersionField.getValue()
            ,publishFile:Ext.isEmpty(publishFileField.getValue())?null:publishFileField.getValue()
            ,instancesNum:Ext.isNumber(instancesNumField.getValue())?instancesNumField.getValue():null
            ,instancesNumMax:Ext.isNumber(instancesNumMaxField.getValue())?instancesNumMaxField.getValue():null
            ,instancesNumMin:Ext.isNumber(instancesNumMinField.getValue())?instancesNumMinField.getValue():null
            ,cpu:Ext.isNumber(cpuField.getValue())?cpuField.getValue():null
            ,cpuMax:Ext.isNumber(cpuMaxField.getValue())?cpuMaxField.getValue():null
            ,cpuMin:Ext.isNumber(cpuMinField.getValue())?cpuMinField.getValue():null
            ,memory:Ext.isEmpty(memoryField.getValue())?null:memoryField.getValue()
            ,serviceable:Ext.isNumber(serviceableField.getValue())?serviceableField.getValue():null
            ,serviceableMax:Ext.isNumber(serviceableMaxField.getValue())?serviceableMaxField.getValue():null
            ,serviceableMin:Ext.isNumber(serviceableMinField.getValue())?serviceableMinField.getValue():null
            ,lbStrategy:Ext.isEmpty(lbStrategyField.getValue())?null:lbStrategyField.getValue()
            ,accessType:Ext.isEmpty(accessTypeField.getValue())?null:accessTypeField.getValue()
            ,status:Ext.isEmpty(statusField.getValue())?null:statusField.getValue()
            ,notes:Ext.isEmpty(notesField.getValue())?null:notesField.getValue()
            ,prdRid:Ext.isNumber(prdRidField.getValue())?prdRidField.getValue():null
            ,prdRidMax:Ext.isNumber(prdRidMaxField.getValue())?prdRidMaxField.getValue():null
            ,prdRidMin:Ext.isNumber(prdRidMinField.getValue())?prdRidMinField.getValue():null
            ,schemeRid:Ext.isNumber(schemeRidField.getValue())?schemeRidField.getValue():null
            ,schemeRidMax:Ext.isNumber(schemeRidMaxField.getValue())?schemeRidMaxField.getValue():null
            ,schemeRidMin:Ext.isNumber(schemeRidMinField.getValue())?schemeRidMinField.getValue():null
            ,cmpRid:Ext.isNumber(cmpRidField.getValue())?cmpRidField.getValue():null
            ,cmpRidMax:Ext.isNumber(cmpRidMaxField.getValue())?cmpRidMaxField.getValue():null
            ,cmpRidMin:Ext.isNumber(cmpRidMinField.getValue())?cmpRidMinField.getValue():null
            ,taskRid:Ext.isNumber(taskRidField.getValue())?taskRidField.getValue():null
            ,taskRidMax:Ext.isNumber(taskRidMaxField.getValue())?taskRidMaxField.getValue():null
            ,taskRidMin:Ext.isNumber(taskRidMinField.getValue())?taskRidMinField.getValue():null
            ,seq:Ext.isNumber(seqField.getValue())?seqField.getValue():null
            ,seqMax:Ext.isNumber(seqMaxField.getValue())?seqMaxField.getValue():null
            ,seqMin:Ext.isNumber(seqMinField.getValue())?seqMinField.getValue():null
            ,createUcode:Ext.isEmpty(createUcodeField.getValue())?null:createUcodeField.getValue()
            ,createUname:Ext.isEmpty(createUnameField.getValue())?null:createUnameField.getValue()
            ,modifyUcode:Ext.isEmpty(modifyUcodeField.getValue())?null:modifyUcodeField.getValue()
            ,modifyUname:Ext.isEmpty(modifyUnameField.getValue())?null:modifyUnameField.getValue()
        };

        return condition;
    }

});