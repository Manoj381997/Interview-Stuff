package com.example.microservices.netflixzuulapigatewayserver;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public boolean shouldFilter() {
		// If we want to execute the filter or not
		// here we want to execute the filter for all requests so we return true
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		// Here the real logic of interception goes
		HttpServletRequest httpServletRequest = RequestContext.getCurrentContext().getRequest();
		logger.info("request -> {} request uri -> {}", httpServletRequest, 
				httpServletRequest.getRequestURI());
		return null;
	}

	@Override
	public String filterType() {
		// To indicate when filter shud be happening. i mean before(pre), after(post)
		// or if we want to filter only error requests(error) (Reqs which has caused 
		// an exception to happen)
		return "pre";
	}

	@Override
	public int filterOrder() {
		// If we have multiple filters, say like ZuulFilter, ZuulSecurityFilter
		// we can set a priority order like 1, 2
//		return 0;
		return 1;
	}

}
