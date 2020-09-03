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
    /// MarketInstrument
    /// </summary>
    [DataContract]
        public partial class MarketInstrument :  IEquatable<MarketInstrument>, IValidatableObject
    {
        /// <summary>
        /// Gets or Sets Currency
        /// </summary>
        [DataMember(Name="currency", EmitDefaultValue=false)]
        public Currency? Currency { get; set; }
        /// <summary>
        /// Initializes a new instance of the <see cref="MarketInstrument" /> class.
        /// </summary>
        /// <param name="figi">figi (required).</param>
        /// <param name="ticker">ticker (required).</param>
        /// <param name="isin">isin.</param>
        /// <param name="minPriceIncrement">minPriceIncrement.</param>
        /// <param name="lot">lot (required).</param>
        /// <param name="currency">currency.</param>
        public MarketInstrument(string figi = default(string), string ticker = default(string), string isin = default(string), double? minPriceIncrement = default(double?), int? lot = default(int?), Currency? currency = default(Currency?))
        {
            // to ensure "figi" is required (not null)
            if (figi == null)
            {
                throw new InvalidDataException("figi is a required property for MarketInstrument and cannot be null");
            }
            else
            {
                this.Figi = figi;
            }
            // to ensure "ticker" is required (not null)
            if (ticker == null)
            {
                throw new InvalidDataException("ticker is a required property for MarketInstrument and cannot be null");
            }
            else
            {
                this.Ticker = ticker;
            }
            // to ensure "lot" is required (not null)
            if (lot == null)
            {
                throw new InvalidDataException("lot is a required property for MarketInstrument and cannot be null");
            }
            else
            {
                this.Lot = lot;
            }
            this.Isin = isin;
            this.MinPriceIncrement = minPriceIncrement;
            this.Currency = currency;
        }
        
        /// <summary>
        /// Gets or Sets Figi
        /// </summary>
        [DataMember(Name="figi", EmitDefaultValue=false)]
        public string Figi { get; set; }

        /// <summary>
        /// Gets or Sets Ticker
        /// </summary>
        [DataMember(Name="ticker", EmitDefaultValue=false)]
        public string Ticker { get; set; }

        /// <summary>
        /// Gets or Sets Isin
        /// </summary>
        [DataMember(Name="isin", EmitDefaultValue=false)]
        public string Isin { get; set; }

        /// <summary>
        /// Gets or Sets MinPriceIncrement
        /// </summary>
        [DataMember(Name="minPriceIncrement", EmitDefaultValue=false)]
        public double? MinPriceIncrement { get; set; }

        /// <summary>
        /// Gets or Sets Lot
        /// </summary>
        [DataMember(Name="lot", EmitDefaultValue=false)]
        public int? Lot { get; set; }


        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            var sb = new StringBuilder();
            sb.Append("class MarketInstrument {\n");
            sb.Append("  Figi: ").Append(Figi).Append("\n");
            sb.Append("  Ticker: ").Append(Ticker).Append("\n");
            sb.Append("  Isin: ").Append(Isin).Append("\n");
            sb.Append("  MinPriceIncrement: ").Append(MinPriceIncrement).Append("\n");
            sb.Append("  Lot: ").Append(Lot).Append("\n");
            sb.Append("  Currency: ").Append(Currency).Append("\n");
            sb.Append("}\n");
            return sb.ToString();
        }
  
        /// <summary>
        /// Returns the JSON string presentation of the object
        /// </summary>
        /// <returns>JSON string presentation of the object</returns>
        public virtual string ToJson()
        {
            return JsonConvert.SerializeObject(this, Formatting.Indented);
        }

        /// <summary>
        /// Returns true if objects are equal
        /// </summary>
        /// <param name="input">Object to be compared</param>
        /// <returns>Boolean</returns>
        public override bool Equals(object input)
        {
            return this.Equals(input as MarketInstrument);
        }

        /// <summary>
        /// Returns true if MarketInstrument instances are equal
        /// </summary>
        /// <param name="input">Instance of MarketInstrument to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(MarketInstrument input)
        {
            if (input == null)
                return false;

            return 
                (
                    this.Figi == input.Figi ||
                    (this.Figi != null &&
                    this.Figi.Equals(input.Figi))
                ) && 
                (
                    this.Ticker == input.Ticker ||
                    (this.Ticker != null &&
                    this.Ticker.Equals(input.Ticker))
                ) && 
                (
                    this.Isin == input.Isin ||
                    (this.Isin != null &&
                    this.Isin.Equals(input.Isin))
                ) && 
                (
                    this.MinPriceIncrement == input.MinPriceIncrement ||
                    (this.MinPriceIncrement != null &&
                    this.MinPriceIncrement.Equals(input.MinPriceIncrement))
                ) && 
                (
                    this.Lot == input.Lot ||
                    (this.Lot != null &&
                    this.Lot.Equals(input.Lot))
                ) && 
                (
                    this.Currency == input.Currency ||
                    (this.Currency != null &&
                    this.Currency.Equals(input.Currency))
                );
        }

        /// <summary>
        /// Gets the hash code
        /// </summary>
        /// <returns>Hash code</returns>
        public override int GetHashCode()
        {
            unchecked // Overflow is fine, just wrap
            {
                int hashCode = 41;
                if (this.Figi != null)
                    hashCode = hashCode * 59 + this.Figi.GetHashCode();
                if (this.Ticker != null)
                    hashCode = hashCode * 59 + this.Ticker.GetHashCode();
                if (this.Isin != null)
                    hashCode = hashCode * 59 + this.Isin.GetHashCode();
                if (this.MinPriceIncrement != null)
                    hashCode = hashCode * 59 + this.MinPriceIncrement.GetHashCode();
                if (this.Lot != null)
                    hashCode = hashCode * 59 + this.Lot.GetHashCode();
                if (this.Currency != null)
                    hashCode = hashCode * 59 + this.Currency.GetHashCode();
                return hashCode;
            }
        }

        /// <summary>
        /// To validate all properties of the instance
        /// </summary>
        /// <param name="validationContext">Validation context</param>
        /// <returns>Validation Result</returns>
        IEnumerable<System.ComponentModel.DataAnnotations.ValidationResult> IValidatableObject.Validate(ValidationContext validationContext)
        {
            yield break;
        }
    }
}