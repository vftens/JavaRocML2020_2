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
    /// Статус заявки
    /// </summary>
    /// <value>Статус заявки</value>
    [JsonConverter(typeof(StringEnumConverter))]
        public enum OrderStatus
    {
        /// <summary>
        /// Enum New for value: New
        /// </summary>
        [EnumMember(Value = "New")]
        New = 0,
        /// <summary>
        /// Enum PartiallyFill for value: PartiallyFill
        /// </summary>
        [EnumMember(Value = "PartiallyFill")]
        PartiallyFill = 1,
        /// <summary>
        /// Enum Fill for value: Fill
        /// </summary>
        [EnumMember(Value = "Fill")]
        Fill = 2,
        /// <summary>
        /// Enum Cancelled for value: Cancelled
        /// </summary>
        [EnumMember(Value = "Cancelled")]
        Cancelled = 3,
        /// <summary>
        /// Enum Replaced for value: Replaced
        /// </summary>
        [EnumMember(Value = "Replaced")]
        Replaced = 4,
        /// <summary>
        /// Enum PendingCancel for value: PendingCancel
        /// </summary>
        [EnumMember(Value = "PendingCancel")]
        PendingCancel = 5,
        /// <summary>
        /// Enum Rejected for value: Rejected
        /// </summary>
        [EnumMember(Value = "Rejected")]
        Rejected = 6,
        /// <summary>
        /// Enum PendingReplace for value: PendingReplace
        /// </summary>
        [EnumMember(Value = "PendingReplace")]
        PendingReplace = 7,
        /// <summary>
        /// Enum PendingNew for value: PendingNew
        /// </summary>
        [EnumMember(Value = "PendingNew")]
        PendingNew = 8    }
}