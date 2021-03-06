Ext.define('AM.model.platform.security.Account', {
    extend: 'Ext.data.Model',
    proxy: {
        type: "rest",
        headers:{"Accept":"application/json"},
        url: 'platform/security/account'
    },
    fields: [
    	{
            name: 'id',
            type:'string',
            allowNull:true
        }
    	,{
            name: 'nickName'
			,type:'string'
            ,allowNull:false
            ,critical:true
        }
    	,{
            name: 'name'
			,type:'string'
            ,allowNull:false
            ,critical:true
        }
    	,{
            name: 'accountName'
			,type:'string'
            ,allowNull:false
            ,critical:true
        }
    	,{
            name: 'mobile'
			,type:'int'
            ,allowNull:true
            ,critical:true
        }
    	,{
            name: 'email'
			,type:'string'
            ,allowNull:true
            ,critical:true
        }
    	,{
            name: 'enable'
			,type:'boolean'
            ,allowNull:false
            ,critical:true
        }
    	,{
            name: 'initPwd'
			,type:'string'
            ,allowNull:false
            ,critical:true
        }
        ,{
            name: 'tenantId'
            ,type:'string'
            ,allowNull:false
            ,critical:true
        }

    ]
});