Ext.define('AM.model.icode.tplfile.TplCode', {
    extend: 'Ext.data.Model'
    ,proxy: {
        type: "rest"
        ,writer:{writeRecordId:false, partialDataOptions:{changes:false}}
        ,headers:{"Accept":"application/json"}
        ,url: 'icode/tplfile/tplcode'
        ,listeners: {
            exception: {
                fn:  function(server, response, operation, options) {
                    var errorBody = Ext.decode(response.responseText);
                    Ext.MessageBox.alert('操作失败('+errorBody.code+')', errorBody.message);
                }
            }
        }
    },
    fields: [
    	{
            name: 'id'
            ,type:'string'
            ,allowNull:true
        }
    	,{
            name: 'tid'
            ,type:'string'
            ,allowNull:false
            ,critical:true
        }
    	,{
            name: 'code'
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
            name: 'type'
            ,type:'string'
            ,allowNull:true
            ,critical:true
        }
    	,{
            name: 'content'
            ,type:'string'
            ,allowNull:true
            ,critical:true
        }
    	,{
            name: 'fileName'
            ,type:'string'
            ,allowNull:false
            ,critical:true
        }
    	,{
            name: 'filePath'
            ,type:'string'
            ,allowNull:false
            ,critical:true
        }
    	,{
            name: 'tplSet'
            ,type:'string'
            ,allowNull:true
            ,critical:true
        }
    	,{
            name: 'acceptModelType'
            ,type:'string'
            ,allowNull:false
            ,critical:true
        }
    	,{
            name: 'overridable'
            ,type:'bool'
            ,allowNull:false
            ,critical:true
        }
    ]
});