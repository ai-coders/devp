Ext.define('AM.model.icode4.view.ViewModelProperty', {
    extend: 'Ext.data.Model',
    proxy: {
        type: "rest",
        writer:{writeRecordId:false, partialDataOptions:{changes:false}},
        headers:{"Accept":"application/json"},
        url: 'view/viewModelProperty'
    },
    fields: [
    	{
            name: 'id',
            type:'string',
            allowNull:true
        }
    	,{
            name: 'name'
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
            name: 'type'
            ,type:'string'
            ,allowNull:false
            ,critical:true
        }
        ,{
            name: 'viewModelId'
            ,type:'string'

	        ,allowNull:false
            ,critical:true
        }
        ,{
            name: 'viewModelName'
            ,type:'string'
            ,persist:false
        }
    	,{
            name: 'editable'
            ,type:'string'
            ,allowNull:false
            ,critical:true
        }
    	,{
            name: 'nullable'
            ,type:'string'
            ,allowNull:false
            ,critical:true
        }
    	,{
            name: 'memo'
            ,type:'string'
            ,allowNull:true
            ,critical:true
        }
    	,{
            name: 'coreRelation'
            ,type:'string'
            ,allowNull:false
            ,critical:true
        }
        ,{
            name: 'domainModelId'
            ,type:'string'

	        ,allowNull:true
            ,critical:true
        }
        ,{
            name: 'domainModelName'
            ,type:'string'
            ,persist:false
        }
        ,{
            name: 'domainModelPropertyId'
            ,type:'string'

	        ,allowNull:true
            ,critical:true
        }
        ,{
            name: 'domainModelPropertyName'
            ,type:'string'
            ,persist:false
        }
    	,{
            name: 'propertyGroup'
            ,type:'string'
            ,allowNull:true
            ,critical:true
        }
    	,{
            name: 'gridIndex'
            ,type:'int'
            ,allowNull:false
            ,critical:true
        }
    	,{
            name: 'gridHidden'
            ,type:'string'
            ,allowNull:false
            ,critical:true
        }
    	,{
            name: 'quickSearchCondition'
            ,type:'string'
            ,allowNull:true
            ,critical:true
        }
    	,{
            name: 'searchCondition'
            ,type:'string'
            ,allowNull:true
            ,critical:true
        }
    	,{
            name: 'formIndex'
            ,type:'int'
            ,allowNull:false
            ,critical:true
        }
    	,{
            name: 'formHidden'
            ,type:'string'
            ,allowNull:false
            ,critical:true
        }
    	,{
            name: 'viewIndex'
            ,type:'int'
            ,allowNull:false
            ,critical:true
        }
    ]
});