# IO.Swagger.Api.MarketApi

All URIs are relative to *https://api-invest.tinkoff.ru/openapi/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**MarketBondsGet**](MarketApi.md#marketbondsget) | **GET** /market/bonds | Получение списка облигаций
[**MarketCurrenciesGet**](MarketApi.md#marketcurrenciesget) | **GET** /market/currencies | Получение списка валютных пар
[**MarketEtfsGet**](MarketApi.md#marketetfsget) | **GET** /market/etfs | Получение списка ETF
[**MarketSearchByFigiGet**](MarketApi.md#marketsearchbyfigiget) | **GET** /market/search/by-figi | Получение инструмента по FIGI
[**MarketSearchByTickerGet**](MarketApi.md#marketsearchbytickerget) | **GET** /market/search/by-ticker | Получение инструмента по тикеру
[**MarketStocksGet**](MarketApi.md#marketstocksget) | **GET** /market/stocks | Получение списка акций

<a name="marketbondsget"></a>
# **MarketBondsGet**
> MarketInstrumentListResponse MarketBondsGet ()

Получение списка облигаций

### Example
```csharp
using System;
using System.Diagnostics;
using IO.Swagger.Api;
using IO.Swagger.Client;
using IO.Swagger.Model;

namespace Example
{
    public class MarketBondsGetExample
    {
        public void main()
        {

            var apiInstance = new MarketApi();

            try
            {
                // Получение списка облигаций
                MarketInstrumentListResponse result = apiInstance.MarketBondsGet();
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling MarketApi.MarketBondsGet: " + e.Message );
            }
        }
    }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**MarketInstrumentListResponse**](MarketInstrumentListResponse.md)

### Authorization

[sso_auth](../README.md#sso_auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)
<a name="marketcurrenciesget"></a>
# **MarketCurrenciesGet**
> MarketInstrumentListResponse MarketCurrenciesGet ()

Получение списка валютных пар

### Example
```csharp
using System;
using System.Diagnostics;
using IO.Swagger.Api;
using IO.Swagger.Client;
using IO.Swagger.Model;

namespace Example
{
    public class MarketCurrenciesGetExample
    {
        public void main()
        {

            var apiInstance = new MarketApi();

            try
            {
                // Получение списка валютных пар
                MarketInstrumentListResponse result = apiInstance.MarketCurrenciesGet();
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling MarketApi.MarketCurrenciesGet: " + e.Message );
            }
        }
    }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**MarketInstrumentListResponse**](MarketInstrumentListResponse.md)

### Authorization

[sso_auth](../README.md#sso_auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)
<a name="marketetfsget"></a>
# **MarketEtfsGet**
> MarketInstrumentListResponse MarketEtfsGet ()

Получение списка ETF

### Example
```csharp
using System;
using System.Diagnostics;
using IO.Swagger.Api;
using IO.Swagger.Client;
using IO.Swagger.Model;

namespace Example
{
    public class MarketEtfsGetExample
    {
        public void main()
        {

            var apiInstance = new MarketApi();

            try
            {
                // Получение списка ETF
                MarketInstrumentListResponse result = apiInstance.MarketEtfsGet();
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling MarketApi.MarketEtfsGet: " + e.Message );
            }
        }
    }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**MarketInstrumentListResponse**](MarketInstrumentListResponse.md)

### Authorization

[sso_auth](../README.md#sso_auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)
<a name="marketsearchbyfigiget"></a>
# **MarketSearchByFigiGet**
> MarketInstrumentResponse MarketSearchByFigiGet (string figi)

Получение инструмента по FIGI

### Example
```csharp
using System;
using System.Diagnostics;
using IO.Swagger.Api;
using IO.Swagger.Client;
using IO.Swagger.Model;

namespace Example
{
    public class MarketSearchByFigiGetExample
    {
        public void main()
        {

            var apiInstance = new MarketApi();
            var figi = figi_example;  // string | FIGI

            try
            {
                // Получение инструмента по FIGI
                MarketInstrumentResponse result = apiInstance.MarketSearchByFigiGet(figi);
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling MarketApi.MarketSearchByFigiGet: " + e.Message );
            }
        }
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **figi** | **string**| FIGI | 

### Return type

[**MarketInstrumentResponse**](MarketInstrumentResponse.md)

### Authorization

[sso_auth](../README.md#sso_auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)
<a name="marketsearchbytickerget"></a>
# **MarketSearchByTickerGet**
> MarketInstrumentListResponse MarketSearchByTickerGet (string ticker)

Получение инструмента по тикеру

### Example
```csharp
using System;
using System.Diagnostics;
using IO.Swagger.Api;
using IO.Swagger.Client;
using IO.Swagger.Model;

namespace Example
{
    public class MarketSearchByTickerGetExample
    {
        public void main()
        {

            var apiInstance = new MarketApi();
            var ticker = ticker_example;  // string | Тикер инструмента

            try
            {
                // Получение инструмента по тикеру
                MarketInstrumentListResponse result = apiInstance.MarketSearchByTickerGet(ticker);
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling MarketApi.MarketSearchByTickerGet: " + e.Message );
            }
        }
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ticker** | **string**| Тикер инструмента | 

### Return type

[**MarketInstrumentListResponse**](MarketInstrumentListResponse.md)

### Authorization

[sso_auth](../README.md#sso_auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)
<a name="marketstocksget"></a>
# **MarketStocksGet**
> MarketInstrumentListResponse MarketStocksGet ()

Получение списка акций

### Example
```csharp
using System;
using System.Diagnostics;
using IO.Swagger.Api;
using IO.Swagger.Client;
using IO.Swagger.Model;

namespace Example
{
    public class MarketStocksGetExample
    {
        public void main()
        {

            var apiInstance = new MarketApi();

            try
            {
                // Получение списка акций
                MarketInstrumentListResponse result = apiInstance.MarketStocksGet();
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling MarketApi.MarketStocksGet: " + e.Message );
            }
        }
    }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**MarketInstrumentListResponse**](MarketInstrumentListResponse.md)

### Authorization

[sso_auth](../README.md#sso_auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)
