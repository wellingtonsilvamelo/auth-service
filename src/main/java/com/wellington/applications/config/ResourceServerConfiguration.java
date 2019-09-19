package com.wellington.applications.config;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.wellington.applications.domain.AuthorityEnum;
import com.wellington.applications.exception.RestExceptionHandler;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter{
	
	@Value("${security.oauth2.client.resource-ids}")
    private String RESOURCE_ID;
	
	@Bean
	public AccessDeniedHandler accessDeniedHandler(){
	    return new RestExceptionHandler();
	}

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
    	String roles = StringUtils.join(getPreparedRoles(), ",");
    	
    	http.
        anonymous().disable()
        .authorizeRequests()
        .antMatchers("/api/admin").access("hasRole('"+AuthorityEnum.ROLE_SYSTEMADMIN.name()+"')")
        .antMatchers("/api/**").access("hasAnyRole("+ roles +")")
        .and().exceptionHandling().accessDeniedHandler(accessDeniedHandler());
    }
    
    private List<String> getPreparedRoles() {
		List<String> preparedRoles = new ArrayList<>();
		
		Stream.of(AuthorityEnum.values()).map(AuthorityEnum::name).forEach(e -> {
			preparedRoles.add("'"+ e +"'");
		});
		
		return preparedRoles;
	}

}
