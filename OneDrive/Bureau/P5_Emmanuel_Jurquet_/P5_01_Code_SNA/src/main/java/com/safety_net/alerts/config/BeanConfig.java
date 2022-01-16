package com.safety_net.alerts.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.safety_net.alerts.repository.ProxyBDD;
import org.json.simple.*;

@Configuration
public class BeanConfig {

	@Bean
	public ProxyBDD initData() {
		ProxyBDD data = new ProxyBDD();
		data.loadData("c:/Users/emman/OneDrive/Bureau/sna.json");
		return data;
	}
}

