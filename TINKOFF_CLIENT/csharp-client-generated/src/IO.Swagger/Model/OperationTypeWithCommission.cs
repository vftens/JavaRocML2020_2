/* 
 * OpenAPI
 *
 * tinkoff.ru/invest OpenAPI.
 *
 * OpenAPI spec version: 1.0.0
 * Contact: n.v.melnikov@tinkoff.ru
 * Generated by: https://github.com/swagger-api/swagger-codegen.git
 */
using System;
using System.Linq;
using System.IO;
using System.Text;
using System.Text.RegularExpressions;
using System.Collections;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Runtime.Serialization;
using Newtonsoft.Json;
using Newtonsoft.Json.Converters;
using System.ComponentModel.DataAnnotations;
using SwaggerDateConverter = IO.Swagger.Client.SwaggerDateConverter;

namespace IO.Swagger.Model
{
    /// <summary>
    /// Defines OperationTypeWithCommission
    /// </summary>
    [JsonConverter(typeof(StringEnumConverter))]
        public enum OperationTypeWithCommission
    {
        /// <summary>
        /// Enum Buy for value: Buy
        /// </summary>
        [EnumMember(Value = "Buy")]
        Buy = 0,
        /// <summary>
        /// Enum Sell for value: Sell
        /// </summary>
        [EnumMember(Value = "Sell")]
        Sell = 1,
        /// <summary>
        /// Enum BrokerCommission for value: BrokerCommission
        /// </summary>
        [EnumMember(Value = "BrokerCommission")]
        BrokerCommission = 2,
        /// <summary>
        /// Enum ExchangeCommission for value: ExchangeCommission
        /// </summary>
        [EnumMember(Value = "ExchangeCommission")]
        ExchangeCommission = 3,
        /// <summary>
        /// Enum ServiceCommission for value: ServiceCommission
        /// </summary>
        [EnumMember(Value = "ServiceCommission")]
        ServiceCommission = 4,
        /// <summary>
        /// Enum MarginCommission for value: MarginCommission
        /// </summary>
        [EnumMember(Value = "MarginCommission")]
        MarginCommission = 5    }
}
