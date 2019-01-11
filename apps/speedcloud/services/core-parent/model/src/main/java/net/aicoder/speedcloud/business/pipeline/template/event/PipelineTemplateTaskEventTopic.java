package net.aicoder.speedcloud.business.pipeline.template.event;

import com.yunkang.saas.common.framework.message.DomainEvent;

public enum PipelineTemplateTaskEventTopic implements DomainEvent {

	CREATE("create")
	,DELETE("delete")
	,UPDATE("update");

	private String topic = "speedcloud.pipeline.template";
	private String value;
  
	PipelineTemplateTaskEventTopic(String event){
		this.value = event;
	}

	@Override
	public String toString() {
		return topic+"."+this.value;
	}

	public String getTopic(){
		return topic;
	}

	@Override
	public String getEventType() {
		return value;
	}

}