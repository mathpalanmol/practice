package com.adamsresearch.ws.async;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.xml.namespace.QName;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;

import com.adamsresearch.ws.async.generated.ExchangeRate;
import com.adamsresearch.ws.async.generated.ExchangeRateService;
import com.adamsresearch.ws.async.generated.GetExchangeRateResponse;

public class ExchangeRateClient
{
protected ExchangeRateClient theClient = null;
protected String wsdlUrl = null;
protected double rate = 0.0d;
ExchangeRate excRate = null;

public static void main(String args[]) throws MalformedURLException, InterruptedException, ExecutionException
{
  if (args.length != 1)
  {
    System.out.println("Usage java -cp <jarFile> com.adamsresearch.ws.async.ExchangeRateClient serviceWsdlUrl");
    System.exit(-1);
  }
  ExchangeRateClient client = new ExchangeRateClient(args[0]);
  System.out.println("Going to sleep " + Thread.currentThread().getName());
  Thread.sleep(10000L);
  System.out.println("woke up." + Thread.currentThread().getName());
  System.out.println("End");
}

public ExchangeRateClient(String urlStr) throws MalformedURLException, InterruptedException, ExecutionException
{
  theClient = this;
  wsdlUrl = urlStr;
  URL url = new URL(wsdlUrl);
  QName qname = new QName("http://async.ws.adamsresearch.com/", "ExchangeRateService");
  ExchangeRateService exchangeRateService = new ExchangeRateService(url, qname);
  excRate = exchangeRateService.getExchangeRatePort();

//  // synchronous:
//  System.out.println("Airstrip One / Ganymede exchange rate, retrieved synchronously, is: " + excRate.getExchangeRate("AS1", "GMD"));
//
//  // asynchronous with polling:
//  try
//  {
//	  javax.xml.ws.Response response = excRate.getExchangeRateAsync("AS1", "GMD");
//    Thread.sleep (2000L);
//    GetExchangeRateResponse output = (GetExchangeRateResponse) response.get();
//    System.out.println("--> retrieved via polling: " + output.getReturn());
//  }
//  catch (Exception exc)
//  {
//    System.out.println(exc.getClass().getName() + " polling for response: " + exc.getMessage());
//  }

  // asynchronous with callback:
  Future<?> exchangeRateAsync = excRate.getExchangeRateAsync("AS1", "GMD", new AsyncHandler()
  {
    public void handleResponse(Response response)
    {
      System.out.println("In AsyncHandler");
      try
      {
        theClient.setCurrencyExchangeRate(((GetExchangeRateResponse) response.get()).getReturn());
      }
      catch (Exception exc)
      {
          System.out.println(exc.getClass().getName() + " using callback for response:" + exc.getMessage());
      }
    }
  });
  for(int i=0; i<5; i++) {
  System.out.println(i);
  }
}

protected void setCurrencyExchangeRate(double newRate)
{
    rate = newRate;
    System.out.println(Thread.currentThread().isDaemon()+" --> via callback, updated exchange rate to " + rate);
}
}