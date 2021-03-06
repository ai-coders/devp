package net.aicoder.speedcloud.asset;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.spring4all.swagger.EnableSwagger2Doc;
import com.yunkang.saas.common.framework.web.controller.ApiResponseBodyHandler;
import com.yunkang.saas.common.framework.web.controller.RestApiExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

//import com.yunkang.saas.common.framework.web.controller.ApiResponseBodyHandler;

@Import({ApiResponseBodyHandler.class, RestApiExceptionHandler.class})
@EnableSwagger2Doc
@SpringBootApplication()
@EnableDiscoveryClient
public class SpeedCloudAssetMicroService implements ExitCodeGenerator {

	public static void main(String[] args) {
		SpringApplication.run(SpeedCloudAssetMicroService.class, args);

	}

	@Override
	public int getExitCode() {
		return 0;
	}

	@ConditionalOnClass(ObjectMapper.class)
	@Autowired
	public void convertLongToString(ObjectMapper objectMapper){
		SimpleModule simpleModule = new SimpleModule();
		simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
		simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
		objectMapper.registerModule(simpleModule);
	}
}