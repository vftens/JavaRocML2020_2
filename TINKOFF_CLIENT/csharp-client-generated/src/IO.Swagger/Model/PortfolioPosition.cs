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
    /// PortfolioPosition
    /// </summary>
    [DataContract]
        public partial class PortfolioPosition :  IEquatable<PortfolioPosition>, IValidatableObject
    {
        /// <summary>
        /// Gets or Sets InstrumentType
        /// </summary>
        [DataMember(Name="instrumentType", EmitDefaultValue=false)]
        public InstrumentType InstrumentType { get; set; }
        /// <summary>
        /// Initializes a new instance of the <see cref="PortfolioPosition" /> class.
        /// </summary>
        /// <param name="figi">figi (required).</param>
        /// <param name="ticker">ticker.</param>
        /// <param name="isin">isin.</param>
        /// <param name="instrumentType">instrumentType (required).</param>
        /// <param name="balance">balance (required).</param>
        /// <param name="blocked">blocked.</param>
        /// <param name="expectedYield">expectedYield.</param>
        /// <param name="lots">lots (required).</param>
        public PortfolioPosition(string figi = default(string), string ticker = default(string), string isin = default(string), InstrumentType instrumentType = default(InstrumentType), double? balance = default(double?), double? blocked = default(double?), MoneyAmount expectedYield = default(MoneyAmount), int? lots = default(int?))
        {
            // to ensure "figi" is required (not null)
            if (figi == null)
            {
                throw new InvalidDataException("figi is a required property for PortfolioPosition and cannot be null");
            }
            else
            {
                this.Figi = figi;
            }
            // to ensure "instrumentType" is required (not null)
            if (instrumentType == null)
            {
                throw new InvalidDataException("instrumentType is a required property for PortfolioPosition and cannot be null");
            }
            else
            {
                this.InstrumentType = instrumentType;
            }
            // to ensure "balance" is required (not null)
            if (balance == null)
            {
                throw new InvalidDataException("balance is a required property for PortfolioPosition and cannot be null");
            }
            else
            {
                this.Balance = balance;
            }
            // to ensure "lots" is required (not null)
            if (lots == null)
            {
                throw new InvalidDataException("lots is a required property for PortfolioPosition and cannot be null");
            }
            else
            {
                this.Lots = lots;
            }
            this.Ticker = ticker;
            this.Isin = isin;
            this.Blocked = blocked;
            this.ExpectedYield = expectedYield;
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
        /// Gets or Sets Balance
        /// </summary>
        [DataMember(Name="balance", EmitDefaultValue=false)]
        public double? Balance { get; set; }

        /// <summary>
        /// Gets or Sets Blocked
        /// </summary>
        [DataMember(Name="blocked", EmitDefaultValue=false)]
        public double? Blocked { get; set; }

        /// <summary>
        /// Gets or Sets ExpectedYield
        /// </summary>
        [DataMember(Name="expectedYield", EmitDefaultValue=false)]
        public MoneyAmount ExpectedYield { get; set; }

        /// <summary>
        /// Gets or Sets Lots
        /// </summary>
        [DataMember(Name="lots", EmitDefaultValue=false)]
        public int? Lots { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            var sb = new StringBuilder();
            sb.Append("class PortfolioPosition {\n");
            sb.Append("  Figi: ").Append(Figi).Append("\n");
            sb.Append("  Ticker: ").Append(Ticker).Append("\n");
            sb.Append("  Isin: ").Append(Isin).Append("\n");
            sb.Append("  InstrumentType: ").Append(InstrumentType).Append("\n");
            sb.Append("  Balance: ").Append(Balance).Append("\n");
            sb.Append("  Blocked: ").Append(Blocked).Append("\n");
            sb.Append("  ExpectedYield: ").Append(ExpectedYield).Append("\n");
            sb.Append("  Lots: ").Append(Lots).Append("\n");
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
            return this.Equals(input as PortfolioPosition);
        }

        /// <summary>
        /// Returns true if PortfolioPosition instances are equal
        /// </summary>
        /// <param name="input">Instance of PortfolioPosition to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(PortfolioPosition input)
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
                    this.InstrumentType == input.InstrumentType ||
                    (this.InstrumentType != null &&
                    this.InstrumentType.Equals(input.InstrumentType))
                ) && 
                (
                    this.Balance == input.Balance ||
                    (this.Balance != null &&
                    this.Balance.Equals(input.Balance))
                ) && 
                (
                    this.Blocked == input.Blocked ||
                    (this.Blocked != null &&
                    this.Blocked.Equals(input.Blocked))
                ) && 
                (
                    this.ExpectedYield == input.ExpectedYield ||
                    (this.ExpectedYield != null &&
                    this.ExpectedYield.Equals(input.ExpectedYield))
                ) && 
                (
                    this.Lots == input.Lots ||
                    (this.Lots != null &&
                    this.Lots.Equals(input.Lots))
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
                if (this.InstrumentType != null)
                    hashCode = hashCode * 59 + this.InstrumentType.GetHashCode();
                if (this.Balance != null)
                    hashCode = hashCode * 59 + this.Balance.GetHashCode();
                if (this.Blocked != null)
                    hashCode = hashCode * 59 + this.Blocked.GetHashCode();
                if (this.ExpectedYield != null)
                    hashCode = hashCode * 59 + this.ExpectedYield.GetHashCode();
                if (this.Lots != null)
                    hashCode = hashCode * 59 + this.Lots.GetHashCode();
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
