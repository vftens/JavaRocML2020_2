# IO.Swagger.Api.PortfolioApi

All URIs are relative to *https://api-invest.tinkoff.ru/openapi/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**PortfolioCurrenciesGet**](PortfolioApi.md#portfoliocurrenciesget) | **GET** /portfolio/currencies | Получение валютных активов клиента
[**PortfolioGet**](PortfolioApi.md#portfolioget) | **GET** /portfolio | Получение портфеля клиента

<a name="portfoliocurrenciesget"></a>
# **PortfolioCurrenciesGet**
> PortfolioCurrenciesResponse PortfolioCurrenciesGet ()

Получение валютных активов клиента

### Example
```csharp
using System;
using System.Diagnostics;
using IO.Swagger.Api;
using IO.Swagger.Client;
using IO.Swagger.Model;

namespace Example
{
    public class PortfolioCurrenciesGetExample
    {
        public void main()
        {

            var apiInstance = new PortfolioApi();

            try
            {
                // Получение валютных активов клиента
                PortfolioCurrenciesResponse result = apiInstance.PortfolioCurrenciesGet();
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling PortfolioApi.PortfolioCurrenciesGet: " + e.Message );
            }
        }
    }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**PortfolioCurrenciesResponse**](PortfolioCurrenciesResponse.md)

### Authorization

[sso_auth](../README.md#sso_auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)
<a name="portfolioget"></a>
# **PortfolioGet**
> PortfolioResponse PortfolioGet ()

Получение портфеля клиента

### Example
```csharp
using System;
using System.Diagnostics;
using IO.Swagger.Api;
using IO.Swagger.Client;
using IO.Swagger.Model;

namespace Example
{
    public class PortfolioGetExample
    {
        public void main()
        {

            var apiInstance = new PortfolioApi();

            try
            {
                // Получение портфеля клиента
                PortfolioResponse result = apiInstance.PortfolioGet();
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling PortfolioApi.PortfolioGet: " + e.Message );
            }
        }
    }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**PortfolioResponse**](PortfolioResponse.md)

### Authorization

[sso_auth](../README.md#sso_auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)
