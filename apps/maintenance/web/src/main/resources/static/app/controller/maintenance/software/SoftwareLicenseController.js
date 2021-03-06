Ext.define('AM.controller.maintenance.software.SoftwareLicenseController', {
    extend: 'Ext.app.Controller'
    ,init: function(application) {
        this.initPanel(application);
        //this.initMainPanel(application);
    }
    ,initPanel: function(application) {
        var center = application.getController('application.framework.MainController').getMainContentPanel();

        var softwareLicensePanel = center.child('maintenance\\.software\\.SoftwareLicensePanel');
        if(!softwareLicensePanel){
            softwareLicensePanel = Ext.create('AM.view.maintenance.software.SoftwareLicensePanel', {closable:true});

            center.add(softwareLicensePanel);
            center.setActiveTab(softwareLicensePanel);
        }
        center.setActiveTab(softwareLicensePanel);
    }
    ,initMainPanel: function(application) {
         var center = application.getController('application.framework.MainController').getMainContentPanel();

         var softwareLicensePanel = center.child('maintenance\\.software\\.SoftwareLicenseMainPanel');
         if(!softwareLicensePanel){
             softwareLicensePanel = Ext.create('AM.view.maintenance.software.SoftwareLicenseMainPanel',{closable:true});

             center.add(softwareLicensePanel);
             center.setActiveTab(softwareLicensePanel);
         }
         center.setActiveTab(softwareLicensePanel);
     }

})