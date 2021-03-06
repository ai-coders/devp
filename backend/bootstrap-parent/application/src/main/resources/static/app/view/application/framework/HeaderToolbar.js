Ext.define('AM.view.application.framework.HeaderToolbar', {
    extend: 'Ext.toolbar.Toolbar'
    ,alias: 'widget.mainHeaderToolbar'
    ,requires:[
        'AM.view.application.framework.UserSwitcher'
        ,'AM.view.application.framework.HeaderContainerController'
    ]
    ,title: ''
    ,height: 64
    ,controller:'HeaderContainerController'
    ,initComponent: function() {

        var me = this;

        me.items= [

            '->',
            {
                xtype:'button'
                // text:'Menu Button',
                ,iconCls: 'fas fa-bell'
                ,ui:'plain-toolbar-small'
                ,style: 'color: #28384a;'
                ,tooltip: '提醒'
                ,menu:[{
                    text:'Menu Button 1'
                }]
            }
            ,{ xtype: 'tbseparator' }
            ,{
                xtype:'button'
                // text:'Menu Button',
                ,iconCls: 'fas fa-envelope'
                ,ui:'plain-toolbar-small'
                ,style: 'color: #28384a;'
                ,tooltip: '消息'
                ,menu:[{
                    text:'Menu Button 1'
                }]
            }
            ,{ xtype: 'tbseparator' }
            // ,{
            //     xtype: 'userSwitcher'
            //     ,style: 'color: 28384a;font-size: 18px; font-weight:bold; margin: 0 10px;'
            //     ,html:'你好'
            //     ,listeners:{
            //         afterrender: 'loadUserInfo'
            //     }
            // }
            ,{
                xtype:'button'
                ,ui:'plain-toolbar-small'
                ,style: 'color: #28384a;'
                ,tooltip: '当前用户'
                // ,text:'超级管理员'
                ,style: 'color: 28384a;font-size: 18px; font-weight:bold; margin: 0 10px;'
                ,menu:[
                    {text:'修改' }
                    ,'-'
                    ,{text:'登出' ,handler:'userLogout'}
                ]
                ,listeners:{
                    afterrender: 'loadUserInfo'
                }
            }
        ];

        this.callParent();
    }

});