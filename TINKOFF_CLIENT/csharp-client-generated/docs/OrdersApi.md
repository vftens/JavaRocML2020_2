# IO.Swagger.Api.OrdersApi

All URIs are relative to *https://api-invest.tinkoff.ru/openapi/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**OrdersCancelPost**](OrdersApi.md#orderscancelpost) | **POST** /orders/cancel | Отмена заявки
[**OrdersGet**](OrdersApi.md#ordersget) | **GET** /orders | Получение списка активных заявок
[**OrdersLimitOrderPost**](OrdersApi.md#orderslimitorderpost) | **POST** /orders/limit-order | Создание лимитной заявки

<a name="orderscancelpost"></a>
# **OrdersCancelPost**
> Empty OrdersCancelPost (string orderId, Empty body = null)

Отмена заявки

### Example
```csharp
using System;
using System.Diagnostics;
using IO.Swagger.Api;
using IO.Swagger.Client;
using IO.Swagger.Model;

namespace Example
{
    public class OrdersCancelPostExample
    {
        public void main()
        {

            var apiInstance = new OrdersApi();
            var orderId = orderId_example;  // string | ID заявки
            var body = new Empty(); // Empty |  (optional) 

            try
            {
                // Отмена заявки
                Empty result = apiInstance.OrdersCancelPost(orderId, body);
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling OrdersApi.OrdersCancelPost: " + e.Message );
            }
        }
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **orderId** | **string**| ID заявки | 
 **body** | [**Empty**](Empty.md)|  | [optional] 

### Return type

[**Empty**](Empty.md)

### Authorization

[sso_auth](../README.md#sso_auth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)
<a name="ordersget"></a>
# **OrdersGet**
> OrdersResponse OrdersGet ()

Получение списка активных заявок

### Example
```csharp
using System;
using System.Diagnostics;
using IO.Swagger.Api;
using IO.Swagger.Client;
using IO.Swagger.Model;

namespace Example
{
    public class OrdersGetExample
    {
        public void main()
        {

            var apiInstance = new OrdersApi();

            try
            {
                // Получение списка активных заявок
                OrdersResponse result = apiInstance.OrdersGet();
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling OrdersApi.OrdersGet: " + e.Message );
            }
        }
    }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**OrdersResponse**](OrdersResponse.md)

### Authorization

[sso_auth](../README.md#sso_auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)
<a name="orderslimitorderpost"></a>
# **OrdersLimitOrderPost**
> LimitOrderResponse OrdersLimitOrderPost (LimitOrderRequest body, string figi)

Создание лимитной заявки

### Example
```csharp
using System;
using System.Diagnostics;
using IO.Swagger.Api;
using IO.Swagger.Client;
using IO.Swagger.Model;

namespace Example
{
    public class OrdersLimitOrderPostExample
    {
        public void main()
        {

            var apiInstance = new OrdersApi();
            var body = new LimitOrderRequest(); // LimitOrderRequest | 
            var figi = figi_example;  // string | FIGI инструмента

            try
            {
                // Создание лимитной заявки
                LimitOrderResponse result = apiInstance.OrdersLimitOrderPost(body, figi);
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling OrdersApi.OrdersLimitOrderPost: " + e.Message );
            }
        }
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**LimitOrderRequest**](LimitOrderRequest.md)|  | 
 **figi** | **string**| FIGI инструмента | 

### Return type

[**LimitOrderResponse**](LimitOrderResponse.md)

### Authorization

[sso_auth](../README.md#sso_auth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)
