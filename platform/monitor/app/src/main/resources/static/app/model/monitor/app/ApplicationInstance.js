Ext.define('AM.model.monitor.app.ApplicationInstance', {
    extend: 'Ext.data.Model'
    ,proxy: {
        type: "rest"
        ,writer:{writeRecordId:false, partialDataOptions:{changes:false}}
        ,headers:{"Accept":"application/json"}
        ,url: 'monitor/app/applicationinstance'
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
            name: 'app'
            ,type:'string'
            ,allowNull:false
            ,critical:true
        }
    	,{
            name: 'host'
            ,type:'string'
            ,allowNull:false
            ,critical:true
        }
    	,{
            name: 'port'
            ,type:'int'
            ,allowNull:false
            ,critical:true
        }
    	,{
            name: 'alive'
            ,type:'bool'
            ,allowNull:true
            ,critical:true
        }
    	,{
            name: 'alarm'
            ,type:'bool'
            ,allowNull:true
            ,critical:true
        }
    	,{
            name: 'aliveTime'
            ,type:'date'
            ,dateFormat: 'time'
            ,allowNull:true
            ,critical:true
        }
    	,{
            name: 'detectionTime'
            ,type:'date'
            ,dateFormat: 'time'
            ,allowNull:true
            ,critical:true
        }
    ]
});