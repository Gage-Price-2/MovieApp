package com.gcu.util;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

public class AopConfiguration {
	// Setup Pointcuts to the Controllers, Rest Controllers, Business Services, and Data Services
		@Pointcut("execution(* com.gcu..movie..controller..*(..)) || execution(* com.gcu..movie..business..*(..)) || execution(* com.gcu..movie..data..*(..))")
		public void monitor()
		{
		}
		//comment
		// Get an instance of the Tracer that will be used in the Aspect
		@Bean
		public Tracer tracer()
		{
			return new Tracer(true);
		}

		// Setup the Aspect with the Tracer and reference to the monitor() Pointcut
		@Bean
		public Advisor performanceMonitorAdvisor()
		{
			AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
			pointcut.setExpression("com.gcu.util.AopConfiguration.monitor()");
			return new DefaultPointcutAdvisor(pointcut, tracer());
		}
}
