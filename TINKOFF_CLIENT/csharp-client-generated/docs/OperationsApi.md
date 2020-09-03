# IO.Swagger.Api.OperationsApi

All URIs are relative to *https://api-invest.tinkoff.ru/openapi/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**OperationsGet**](OperationsApi.md#operationsget) | **GET** /operations | Получение списка операций

<a name="operationsget"></a>
# **OperationsGet**
> OperationsResponse OperationsGet (DateTime? from, OperationInterval interval, string figi = null)

Получение списка операций

### Example
```csharp
using System;
using System.Diagnostics;
using IO.Swagger.Api;
using IO.Swagger.Client;
using IO.Swagger.Model;

namespace Example
{
    public class OperationsGetExample
    {
        public void main()
        {

            var apiInstance = new OperationsApi();
            var from = 2013-10-20;  // DateTime? | Начало временного промежутка
            var interval = new OperationInterval(); // OperationInterval | Длительность временного промежутка
            var figi = figi_example;  // string | Figi инструмента для фильтрации (optional) 

            try
            {
                // Получение списка операций
                OperationsResponse result = apiInstance.OperationsGet(from, interval, figi);
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling OperationsApi.OperationsGet: " + e.Message );
            }
        }
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **from** | **DateTime?**| Начало временного промежутка | 
 **interval** | [**OperationInterval**](OperationInterval.md)| Длительность временного промежутка | 
 **figi** | **string**| Figi инструмента для фильтрации | [optional] 

### Return type

[**OperationsResponse**](OperationsResponse.md)

### Authorization

[sso_auth](../README.md#sso_auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)
