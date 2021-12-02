package com.haufe.test.config;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class BeansConfig {


	
	@Bean(name = "mapperService")
	public DozerBeanMapper  getMapper() {
		final DozerBeanMapper ref = new DozerBeanMapper();
		List<String> mappingFileUrls = new ArrayList<String>();
		mappingFileUrls.add("dozer-bean-mappings.xml");
		ref.setMappingFiles(mappingFileUrls);
		return ref;
	}
	
	

}
