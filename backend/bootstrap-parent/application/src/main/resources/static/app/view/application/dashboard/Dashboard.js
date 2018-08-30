Ext.define('AM.view.application.dashboard.Dashboard', {
	extend: 'Ext.panel.Panel'
	,title:'欢迎使用'
	,bodyCls: 'app-dashboard'
	,reference: 'dashboard'
	,controller: 'application.dashboard.DashboardController'
	,requires:['AM.view.application.dashboard.DashboardController', 'AM.view.application.dashboard.UserDetailPanel']
	,bodyPadding: 10
	,layout: {
		type: 'vbox',
		align: 'stretch'
	}
	,items: [
		{
			xtype: 'container'
			,layout: 'hbox'
			,margin: '0 0 10 0'
			,items: [{
				xtype: 'button',

				text: 'Project Summary'
			}]
		},{
			xtype:'container'
			,defaults: {
				frame: true,
			}
			,layout: {
				type: 'column'
			}
			,items: [
				{
					xtype: 'container',
					columnWidth: 0.33,
					itemId:'column01',
					layout: {
						type: 'anchor'
					}
					,defaults:{
						margin: '0 10 10 0'
					}
					,items:[
						{
							xtype:'form-register'
						}
					]
				}

				,{
					xtype: 'container',
					columnWidth: 0.33,
					itemId:'column03',
					layout: {
						type: 'anchor'
					},defaults:{
						margin: '0 10 10 0'
					}
					,items:[

					]
				}

			]
		}
	]

	,initComponent: function() {
		var me = this;

		Ext.apply(me, {


		});

		me.callParent(arguments);
	}
})