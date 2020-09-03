# IO.Swagger.Api.SandboxApi

All URIs are relative to *https://api-invest.tinkoff.ru/openapi/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**SandboxClearPost**](SandboxApi.md#sandboxclearpost) | **POST** /sandbox/clear | Удаление всех позиций
[**SandboxCurrenciesBalancePost**](SandboxApi.md#sandboxcurrenciesbalancepost) | **POST** /sandbox/currencies/balance | Выставление баланса по валютным позициям
[**SandboxPositionsBalancePost**](SandboxApi.md#sandboxpositionsbalancepost) | **POST** /sandbox/positions/balance | Выставление баланса по инструментным позициям
[**SandboxRegisterPost**](SandboxApi.md#sandboxregisterpost) | **POST** /sandbox/register | Регистрация клиента в sandbox

<a name="sandboxclearpost"></a>
# **SandboxClearPost**
> Empty SandboxClearPost ()

Удаление всех позиций

Удаление всех позиций клиента

### Example
```csharp
using System;
using System.Diagnostics;
using IO.Swagger.Api;
using IO.Swagger.Client;
using IO.Swagger.Model;

namespace Example
{
    public class SandboxClearPostExample
    {
        public void main()
        {

            var apiInstance = new SandboxApi();

            try
            {
                // Удаление всех позиций
                Empty result = apiInstance.SandboxClearPost();
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling SandboxApi.SandboxClearPost: " + e.Message );
            }
        }
    }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Empty**](Empty.md)

### Authorization

[sso_auth](../README.md#sso_auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)
<a name="sandboxcurrenciesbalancepost"></a>
# **SandboxCurrenciesBalancePost**
> Empty SandboxCurrenciesBalancePost (SandboxSetCurrencyBalanceRequest body)

Выставление баланса по валютным позициям

### Example
```csharp
using System;
using System.Diagnostics;
using IO.Swagger.Api;
using IO.Swagger.Client;
using IO.Swagger.Model;

namespace Example
{
    public class SandboxCurrenciesBalancePostExample
    {
        public void main()
        {

            var apiInstance = new SandboxApi();
            var body = new SandboxSetCurrencyBalanceRequest(); // SandboxSetCurrencyBalanceRequest | Запрос на выставление баланса по валютным позициям

            try
            {
                // Выставление баланса по валютным позициям
                Empty result = apiInstance.SandboxCurrenciesBalancePost(body);
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling SandboxApi.SandboxCurrenciesBalancePost: " + e.Message );
            }
        }
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**SandboxSetCurrencyBalanceRequest**](SandboxSetCurrencyBalanceRequest.md)| Запрос на выставление баланса по валютным позициям | 

### Return type

[**Empty**](Empty.md)

### Authorization

[sso_auth](../README.md#sso_auth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)
<a name="sandboxpositionsbalancepost"></a>
# **SandboxPositionsBalancePost**
> Empty SandboxPositionsBalancePost (SandboxSetPositionBalanceRequest body)

Выставление баланса по инструментным позициям

### Example
```csharp
using System;
using System.Diagnostics;
using IO.Swagger.Api;
using IO.Swagger.Client;
using IO.Swagger.Model;

namespace Example
{
    public class SandboxPositionsBalancePostExample
    {
        public void main()
        {

            var apiInstance = new SandboxApi();
            var body = new SandboxSetPositionBalanceRequest(); // SandboxSetPositionBalanceRequest | Запрос на выставление баланса по инструментным позициям

            try
            {
                // Выставление баланса по инструментным позициям
                Empty result = apiInstance.SandboxPositionsBalancePost(body);
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling SandboxApi.SandboxPositionsBalancePost: " + e.Message );
            }
        }
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**SandboxSetPositionBalanceRequest**](SandboxSetPositionBalanceRequest.md)| Запрос на выставление баланса по инструментным позициям | 

### Return type

[**Empty**](Empty.md)

### Authorization

[sso_auth](../README.md#sso_auth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)
<a name="sandboxregisterpost"></a>
# **SandboxRegisterPost**
> Empty SandboxRegisterPost ()

Регистрация клиента в sandbox

Создание валютные позиций для клиента

### Example
```csharp
using System;
using System.Diagnostics;
using IO.Swagger.Api;
using IO.Swagger.Client;
using IO.Swagger.Model;

namespace Example
{
    public class SandboxRegisterPostExample
    {
        public void main()
        {

            var apiInstance = new SandboxApi();

            try
            {
                // Регистрация клиента в sandbox
                Empty result = apiInstance.SandboxRegisterPost();
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling SandboxApi.SandboxRegisterPost: " + e.Message );
            }
        }
    }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Empty**](Empty.md)

### Authorization

[sso_auth](../README.md#sso_auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)
