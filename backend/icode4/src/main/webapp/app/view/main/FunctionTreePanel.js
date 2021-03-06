

Ext.define('AM.view.main.FunctionTreePanel', {
    extend: 'Ext.tree.Panel',
	requires: [
		'AM.store.security.AllResourceTreeStore'
	],
    alias: 'widget.mainFunctionTreePanel',
    width: 150,
    collapsible: true,
    title: '功能菜单',
    //store: Ext.create('AM.store.security.AllResourceTreeStore'),
	store: 'security.AllResourceTreeStore',
    displayField: 'name',
    // lines: false,
    rootVisible: false,
    singleExpand: false,
    useArrows: true,
	animate:true,

    initComponent: function() {
        var me = this;

        Ext.apply(me, {
            viewConfig: {

            }
        });
	    // Ext.create('AM.store.security.AllResourceTreeStore',{storeId:2})
	    // Ext.create('AM.store.security.AllResourceTreeStore',{storeId:1})
	    Ext.data.StoreManager.each(function(obj){
		    console.log(obj.getId());
	    })
        me.callParent(arguments);
    }

});