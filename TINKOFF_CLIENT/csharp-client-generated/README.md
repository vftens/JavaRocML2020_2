# IO.Swagger - the C# library for the OpenAPI

tinkoff.ru/invest OpenAPI.

This C# SDK is automatically generated by the [Swagger Codegen](https://github.com/swagger-api/swagger-codegen) project:

- API version: 1.0.0
- SDK version: 1.0.0
- Build package: io.swagger.codegen.v3.generators.dotnet.CSharpClientCodegen

<a name="frameworks-supported"></a>
## Frameworks supported
- .NET 4.0 or later
- Windows Phone 7.1 (Mango)

<a name="dependencies"></a>
## Dependencies
- [RestSharp](https://www.nuget.org/packages/RestSharp) - 105.1.0 or later
- [Json.NET](https://www.nuget.org/packages/Newtonsoft.Json/) - 7.0.0 or later
- [JsonSubTypes](https://www.nuget.org/packages/JsonSubTypes/) - 1.2.0 or later

The DLLs included in the package may not be the latest version. We recommend using [NuGet](https://docs.nuget.org/consume/installing-nuget) to obtain the latest version of the packages:
```
Install-Package RestSharp
Install-Package Newtonsoft.Json
Install-Package JsonSubTypes
```

NOTE: RestSharp versions greater than 105.1.0 have a bug which causes file uploads to fail. See [RestSharp#742](https://github.com/restsharp/RestSharp/issues/742)

<a name="installation"></a>
## Installation
Run the following command to generate the DLL
- [Mac/Linux] `/bin/sh build.sh`
- [Windows] `build.bat`

Then include the DLL (under the `bin` folder) in the C# project, and use the namespaces:
```csharp
using IO.Swagger.Api;
using IO.Swagger.Client;
using IO.Swagger.Model;
```
<a name="packaging"></a>
## Packaging

A `.nuspec` is included with the project. You can follow the Nuget quickstart to [create](https://docs.microsoft.com/en-us/nuget/quickstart/create-and-publish-a-package#create-the-package) and [publish](https://docs.microsoft.com/en-us/nuget/quickstart/create-and-publish-a-package#publish-the-package) packages.

This `.nuspec` uses placeholders from the `.csproj`, so build the `.csproj` directly:

```
nuget pack -Build -OutputDirectory out IO.Swagger.csproj
```

Then, publish to a [local feed](https://docs.microsoft.com/en-us/nuget/hosting-packages/local-feeds) or [other host](https://docs.microsoft.com/en-us/nuget/hosting-packages/overview) and consume the new package via Nuget as usual.

<a name="getting-started"></a>
## Getting Started

```csharp
using System;
using System.Diagnostics;
using IO.Swagger.Api;
using IO.Swagger.Client;
using IO.Swagger.Model;

namespace Example
{
    public class Example
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

<a name="documentation-for-api-endpoints"></a>
## Documentation for API Endpoints

All URIs are relative to *https://api-invest.tinkoff.ru/openapi/*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*MarketApi* | [**MarketBondsGet**](docs/MarketApi.md#marketbondsget) | **GET** /market/bonds | Получение списка облигаций
*MarketApi* | [**MarketCurrenciesGet**](docs/MarketApi.md#marketcurrenciesget) | **GET** /market/currencies | Получение списка валютных пар
*MarketApi* | [**MarketEtfsGet**](docs/MarketApi.md#marketetfsget) | **GET** /market/etfs | Получение списка ETF
*MarketApi* | [**MarketSearchByFigiGet**](docs/MarketApi.md#marketsearchbyfigiget) | **GET** /market/search/by-figi | Получение инструмента по FIGI
*MarketApi* | [**MarketSearchByTickerGet**](docs/MarketApi.md#marketsearchbytickerget) | **GET** /market/search/by-ticker | Получение инструмента по тикеру
*MarketApi* | [**MarketStocksGet**](docs/MarketApi.md#marketstocksget) | **GET** /market/stocks | Получение списка акций
*OperationsApi* | [**OperationsGet**](docs/OperationsApi.md#operationsget) | **GET** /operations | Получение списка операций
*OrdersApi* | [**OrdersCancelPost**](docs/OrdersApi.md#orderscancelpost) | **POST** /orders/cancel | Отмена заявки
*OrdersApi* | [**OrdersGet**](docs/OrdersApi.md#ordersget) | **GET** /orders | Получение списка активных заявок
*OrdersApi* | [**OrdersLimitOrderPost**](docs/OrdersApi.md#orderslimitorderpost) | **POST** /orders/limit-order | Создание лимитной заявки
*PortfolioApi* | [**PortfolioCurrenciesGet**](docs/PortfolioApi.md#portfoliocurrenciesget) | **GET** /portfolio/currencies | Получение валютных активов клиента
*PortfolioApi* | [**PortfolioGet**](docs/PortfolioApi.md#portfolioget) | **GET** /portfolio | Получение портфеля клиента
*SandboxApi* | [**SandboxClearPost**](docs/SandboxApi.md#sandboxclearpost) | **POST** /sandbox/clear | Удаление всех позиций
*SandboxApi* | [**SandboxCurrenciesBalancePost**](docs/SandboxApi.md#sandboxcurrenciesbalancepost) | **POST** /sandbox/currencies/balance | Выставление баланса по валютным позициям
*SandboxApi* | [**SandboxPositionsBalancePost**](docs/SandboxApi.md#sandboxpositionsbalancepost) | **POST** /sandbox/positions/balance | Выставление баланса по инструментным позициям
*SandboxApi* | [**SandboxRegisterPost**](docs/SandboxApi.md#sandboxregisterpost) | **POST** /sandbox/register | Регистрация клиента в sandbox

<a name="documentation-for-models"></a>
## Documentation for Models

 - [Model.Currencies](docs/Currencies.md)
 - [Model.Currency](docs/Currency.md)
 - [Model.CurrencyPosition](docs/CurrencyPosition.md)
 - [Model.Empty](docs/Empty.md)
 - [Model.Error](docs/Error.md)
 - [Model.ErrorPayload](docs/ErrorPayload.md)
 - [Model.InstrumentType](docs/InstrumentType.md)
 - [Model.LimitOrderRequest](docs/LimitOrderRequest.md)
 - [Model.LimitOrderResponse](docs/LimitOrderResponse.md)
 - [Model.MarketInstrument](docs/MarketInstrument.md)
 - [Model.MarketInstrumentList](docs/MarketInstrumentList.md)
 - [Model.MarketInstrumentListResponse](docs/MarketInstrumentListResponse.md)
 - [Model.MarketInstrumentResponse](docs/MarketInstrumentResponse.md)
 - [Model.MoneyAmount](docs/MoneyAmount.md)
 - [Model.Operation](docs/Operation.md)
 - [Model.OperationInterval](docs/OperationInterval.md)
 - [Model.OperationStatus](docs/OperationStatus.md)
 - [Model.OperationTrade](docs/OperationTrade.md)
 - [Model.OperationType](docs/OperationType.md)
 - [Model.OperationTypeWithCommission](docs/OperationTypeWithCommission.md)
 - [Model.OperationsResponse](docs/OperationsResponse.md)
 - [Model.Order](docs/Order.md)
 - [Model.OrderStatus](docs/OrderStatus.md)
 - [Model.OrderType](docs/OrderType.md)
 - [Model.OrdersResponse](docs/OrdersResponse.md)
 - [Model.PlacedLimitOrder](docs/PlacedLimitOrder.md)
 - [Model.Portfolio](docs/Portfolio.md)
 - [Model.PortfolioCurrenciesResponse](docs/PortfolioCurrenciesResponse.md)
 - [Model.PortfolioPosition](docs/PortfolioPosition.md)
 - [Model.PortfolioResponse](docs/PortfolioResponse.md)
 - [Model.SandboxCurrency](docs/SandboxCurrency.md)
 - [Model.SandboxSetCurrencyBalanceRequest](docs/SandboxSetCurrencyBalanceRequest.md)
 - [Model.SandboxSetPositionBalanceRequest](docs/SandboxSetPositionBalanceRequest.md)

<a name="documentation-for-authorization"></a>
## Documentation for Authorization

<a name="sso_auth"></a>
### sso_auth


