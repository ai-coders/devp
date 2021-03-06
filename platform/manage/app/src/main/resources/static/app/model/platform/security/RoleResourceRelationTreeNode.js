
Ext.define('AM.model.platform.security.RoleResourceRelationTreeNode', {
    extend: 'Ext.data.TreeModel',

    fields: [
	    {
		    name: 'id',
		    type:'string'
	    }
	    ,{
		    name: 'name',
		    type: 'string'
	    }
	    ,{
		    name: 'resourceId'
		    ,type:'string'
		    ,allowNull:false
		    ,critical:true
	    }
	    ,{
		    name: 'roleId'
		    ,type:'string'
		    ,allowNull:false
		    ,critical:true
	    }

        ,{
            name: 'checked',
            defaultValue: false,
            type: 'boolean'
        }
    ]
});