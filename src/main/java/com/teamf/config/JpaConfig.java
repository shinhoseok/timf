package com.teamf.config;

import java.util.Collections;
import java.util.HashMap;
import java.util.Optional;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.teamf.dto.UserDto;

@EnableJpaAuditing
@Configuration
@EntityScan(basePackages = { "com.teamf.entity" })
@PropertySource(value = {"classpath:/application.yml"})
public class JpaConfig {
	
	@Value("${spring.jpa.database-platform}")   
	private String dialect;
	@Value("${spring.jpa.show_sql:true}")
	private String showSql;
	@Value("${spring.jpa.properties.hibernate.format_sql:true}")
	private String formaSql;
	@Value("${spring.jpa.hibernate.ddl-auto:validate}")
	private String ddlAuto;
	
	@Primary
	@Bean(name = "dataSource")
	@ConfigurationProperties(prefix = "spring.datasource.hikari")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setDatabasePlatform(dialect);
		
		entityManagerFactoryBean.setJpaVendorAdapter(hibernateJpaVendorAdapter);
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPackagesToScan("com.teamf.entity");
		
		Properties jpaProperties = new Properties();
		jpaProperties.setProperty("hibernate.show_sql", showSql);
		jpaProperties.setProperty("hibernate.format_sql", formaSql);
		jpaProperties.setProperty("hibernate.hbm2ddl.auto", ddlAuto);
		entityManagerFactoryBean.setJpaProperties(jpaProperties);
		
		return entityManagerFactoryBean;
	}

	@Bean(name = "transactionManager")
	public PlatformTransactionManager jpaTransactionManager() {
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setDataSource(dataSource());
		return jpaTransactionManager;
	}

	@Bean(name = "transactionAdvice")
	public TransactionInterceptor transactionAdvice() {
		TransactionInterceptor txAdvice = new TransactionInterceptor();
		NameMatchTransactionAttributeSource txAttributeSource = new NameMatchTransactionAttributeSource();
		
		RuleBasedTransactionAttribute required = new RuleBasedTransactionAttribute();
		required.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
		required.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		
		RuleBasedTransactionAttribute readOnly = new RuleBasedTransactionAttribute();
		readOnly.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		readOnly.setReadOnly(true);

		HashMap<String, TransactionAttribute> txMethods = new HashMap<String, TransactionAttribute>();
		txMethods.put("insert*", required);
		txMethods.put("update*", required);
		txMethods.put("delete*", required);
		
		txMethods.put("select*", readOnly);
		
		txAttributeSource.setNameMap(txMethods);

		txAdvice.setTransactionAttributeSource(txAttributeSource);
		txAdvice.setTransactionManager(jpaTransactionManager());

		return txAdvice;
	}

	@Bean(name = "transactionAdviceAdvisor")
	public Advisor transactionAdviceAdvisor() {
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression("execution(* com.teamf.service.impl.*Impl.*(..))");
		return new DefaultPointcutAdvisor(pointcut, transactionAdvice());
	}

	@Bean(name = "auditorProvider")
	public AuditorAware<Long> auditorProvider() {
		return () -> {
			ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
			UserDto currentUser = (UserDto) attr.getRequest().getSession().getAttribute("loginDTO");
			if (currentUser != null)
				return Optional.of(currentUser.getUserId());
			else
				return Optional.of(1L);
		};
	}
}
