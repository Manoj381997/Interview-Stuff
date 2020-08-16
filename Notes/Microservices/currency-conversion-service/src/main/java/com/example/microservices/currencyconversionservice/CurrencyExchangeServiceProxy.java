package com.example.microservices.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
//No need of hardcoding URL since we are gonna invoke multiple instances, configured in appln.ppties
//@FeignClient(name = "currency-exchange-service")
@FeignClient(name = "netflix-zuul-api-gateway-server") //So that the serv calls other serv via gateway
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
	
//	@GetMapping("/currency-exchange/from/{from}/to/{to}")	When not using API Gateway
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from, 
			@PathVariable("to") String to);
}
