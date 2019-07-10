
package com.adamsresearch.ws.async.generated;

import java.util.concurrent.Future;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.Response;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ExchangeRate", targetNamespace = "http://async.ws.adamsresearch.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ExchangeRate {


    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns javax.xml.ws.Response<com.adamsresearch.ws.async.generated.GetExchangeRateResponse>
     */
    @WebMethod(operationName = "getExchangeRate")
    @RequestWrapper(localName = "getExchangeRate", targetNamespace = "http://async.ws.adamsresearch.com/", className = "com.adamsresearch.ws.async.generated.GetExchangeRate")
    @ResponseWrapper(localName = "getExchangeRateResponse", targetNamespace = "http://async.ws.adamsresearch.com/", className = "com.adamsresearch.ws.async.generated.GetExchangeRateResponse")
    public Response<GetExchangeRateResponse> getExchangeRateAsync(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

    /**
     * 
     * @param arg1
     * @param arg0
     * @param asyncHandler
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "getExchangeRate")
    @RequestWrapper(localName = "getExchangeRate", targetNamespace = "http://async.ws.adamsresearch.com/", className = "com.adamsresearch.ws.async.generated.GetExchangeRate")
    @ResponseWrapper(localName = "getExchangeRateResponse", targetNamespace = "http://async.ws.adamsresearch.com/", className = "com.adamsresearch.ws.async.generated.GetExchangeRateResponse")
    public Future<?> getExchangeRateAsync(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "asyncHandler", targetNamespace = "")
        AsyncHandler<GetExchangeRateResponse> asyncHandler);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getExchangeRate", targetNamespace = "http://async.ws.adamsresearch.com/", className = "com.adamsresearch.ws.async.generated.GetExchangeRate")
    @ResponseWrapper(localName = "getExchangeRateResponse", targetNamespace = "http://async.ws.adamsresearch.com/", className = "com.adamsresearch.ws.async.generated.GetExchangeRateResponse")
    @Action(input = "http://async.ws.adamsresearch.com/ExchangeRate/getExchangeRateRequest", output = "http://async.ws.adamsresearch.com/ExchangeRate/getExchangeRateResponse")
    public double getExchangeRate(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

}