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
    /// LimitOrderRequest
    /// </summary>
    [DataContract]
        public partial class LimitOrderRequest :  IEquatable<LimitOrderRequest>, IValidatableObject
    {
        /// <summary>
        /// Gets or Sets Operation
        /// </summary>
        [DataMember(Name="operation", EmitDefaultValue=false)]
        public OperationType Operation { get; set; }
        /// <summary>
        /// Initializes a new instance of the <see cref="LimitOrderRequest" /> class.
        /// </summary>
        /// <param name="lots">lots (required).</param>
        /// <param name="operation">operation (required).</param>
        /// <param name="price">price (required).</param>
        public LimitOrderRequest(int? lots = default(int?), OperationType operation = default(OperationType), double? price = default(double?))
        {
            // to ensure "lots" is required (not null)
            if (lots == null)
            {
                throw new InvalidDataException("lots is a required property for LimitOrderRequest and cannot be null");
            }
            else
            {
                this.Lots = lots;
            }
            // to ensure "operation" is required (not null)
            if (operation == null)
            {
                throw new InvalidDataException("operation is a required property for LimitOrderRequest and cannot be null");
            }
            else
            {
                this.Operation = operation;
            }
            // to ensure "price" is required (not null)
            if (price == null)
            {
                throw new InvalidDataException("price is a required property for LimitOrderRequest and cannot be null");
            }
            else
            {
                this.Price = price;
            }
        }
        
        /// <summary>
        /// Gets or Sets Lots
        /// </summary>
        [DataMember(Name="lots", EmitDefaultValue=false)]
        public int? Lots { get; set; }


        /// <summary>
        /// Gets or Sets Price
        /// </summary>
        [DataMember(Name="price", EmitDefaultValue=false)]
        public double? Price { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            var sb = new StringBuilder();
            sb.Append("class LimitOrderRequest {\n");
            sb.Append("  Lots: ").Append(Lots).Append("\n");
            sb.Append("  Operation: ").Append(Operation).Append("\n");
            sb.Append("  Price: ").Append(Price).Append("\n");
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
            return this.Equals(input as LimitOrderRequest);
        }

        /// <summary>
        /// Returns true if LimitOrderRequest instances are equal
        /// </summary>
        /// <param name="input">Instance of LimitOrderRequest to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(LimitOrderRequest input)
        {
            if (input == null)
                return false;

            return 
                (
                    this.Lots == input.Lots ||
                    (this.Lots != null &&
                    this.Lots.Equals(input.Lots))
                ) && 
                (
                    this.Operation == input.Operation ||
                    (this.Operation != null &&
                    this.Operation.Equals(input.Operation))
                ) && 
                (
                    this.Price == input.Price ||
                    (this.Price != null &&
                    this.Price.Equals(input.Price))
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
                if (this.Lots != null)
                    hashCode = hashCode * 59 + this.Lots.GetHashCode();
                if (this.Operation != null)
                    hashCode = hashCode * 59 + this.Operation.GetHashCode();
                if (this.Price != null)
                    hashCode = hashCode * 59 + this.Price.GetHashCode();
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
