package com.ibm.ms.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


//@FeignClient(name="currency-exchnage-service",url="localhost:8000")
//@FeignClient(name="currency-exchnage-service")
@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name="currency-exchnage-service")
public interface CurrencyExchangeServiceProxy {
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	//@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangevalue(@PathVariable("from") String from,@PathVariable("to") String to);
	
	@PostMapping("/convert")
	public ExchangeResponse convert(@RequestBody ExchangeRequest obj);
}
