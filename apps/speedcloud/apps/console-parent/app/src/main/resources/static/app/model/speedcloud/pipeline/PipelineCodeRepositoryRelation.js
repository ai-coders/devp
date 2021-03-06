Ext.define('AM.model.speedcloud.pipeline.PipelineCodeRepositoryRelation', {
    extend: 'Ext.data.Model'
    ,proxy: {
        type: "rest"
        ,writer:{writeRecordId:false, partialDataOptions:{changes:false}}
        ,headers:{"Accept":"application/json"}
        ,url: 'speedcloud/pipeline/pipelinecoderepositoryrelation'
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
            name: 'codeRepository'
            ,type:'string'
            ,allowNull:false
            ,critical:true
        }
    	,{
            name: 'pipeline'
            ,type:'string'
            ,allowNull:false
            ,critical:true
        }
    	,{
            name: 'autoStart'
            ,type:'bool'
            ,allowNull:false
            ,critical:true
        }
    ]
});