Ext.define('AM.view.application.framework.MainContentPanel', {
    extend: 'Ext.tab.Panel',
    alias: 'widget.mainContentPanel',
	requires:[
        'AM.view.application.dashboard.Dashboard'
	    ,'AM.view.maintenance.asset.info.AssetCmdbPanel'

	]
	,defaults: {
		//bodyPadding: 10,
		scrollable: true,
		closable: true,
		//border: false
	}

    ,initComponent: function() {
        var me = this;

        Ext.apply(me, {
            listeners: {
                beforerender: {
                    fn: me.onTabpanelBeforeRender,
                    scope: me
                }
            }
        });

        me.callParent(arguments);
    },

    onTabpanelBeforeRender: function(abstractcomponent, options) {
        function getTools(){
            return [{
                xtype: 'tool',
                type: 'gear',
                handler: function(e, target, panelHeader, tool){
                    var portlet = panelHeader.ownerCt;
                    portlet.setLoading('Loading...');
                    Ext.defer(function() {
                        portlet.setLoading(false);
                    }, 2000);
                }
            }];
        }

	    // var portal = Ext.create('Ext.panel.Panel',{ title:'欢迎使用', html:"欢迎使用", closable:false, bodyCls: 'app-dashboard', iconAlign:'right', iconCls:'bullet_red' });
	    // this.insert(0,portal);
	    // this.setActiveTab(0);


	    var dashboard = Ext.create("AM.view.application.dashboard.Dashboard",{
			closable:false
	    })
	    this.insert(0,dashboard);
	    this.setActiveTab(0);

        var assetCmdbPanel = Ext.create("AM.view.maintenance.asset.info.AssetCmdbPanel",{
            closable:false
        })
        this.insert(1,assetCmdbPanel);
        this.setActiveTab(1);


    }

});