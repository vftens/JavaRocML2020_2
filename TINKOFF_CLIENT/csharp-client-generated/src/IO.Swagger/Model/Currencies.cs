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
    /// Currencies
    /// </summary>
    [DataContract]
        public partial class Currencies :  IEquatable<Currencies>, IValidatableObject
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="Currencies" /> class.
        /// </summary>
        /// <param name="currencies">currencies (required).</param>
        public Currencies(List<CurrencyPosition> currencies = default(List<CurrencyPosition>))
        {
            // to ensure "currencies" is required (not null)
            if (currencies == null)
            {
                throw new InvalidDataException("currencies is a required property for Currencies and cannot be null");
            }
            else
            {
                this._Currencies = currencies;
            }
        }
        
        /// <summary>
        /// Gets or Sets _Currencies
        /// </summary>
        [DataMember(Name="currencies", EmitDefaultValue=false)]
        public List<CurrencyPosition> _Currencies { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            var sb = new StringBuilder();
            sb.Append("class Currencies {\n");
            sb.Append("  _Currencies: ").Append(_Currencies).Append("\n");
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
            return this.Equals(input as Currencies);
        }

        /// <summary>
        /// Returns true if Currencies instances are equal
        /// </summary>
        /// <param name="input">Instance of Currencies to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(Currencies input)
        {
            if (input == null)
                return false;

            return 
                (
                    this._Currencies == input._Currencies ||
                    this._Currencies != null &&
                    input._Currencies != null &&
                    this._Currencies.SequenceEqual(input._Currencies)
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
                if (this._Currencies != null)
                    hashCode = hashCode * 59 + this._Currencies.GetHashCode();
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