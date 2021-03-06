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
    /// PlacedLimitOrder
    /// </summary>
    [DataContract]
        public partial class PlacedLimitOrder :  IEquatable<PlacedLimitOrder>, IValidatableObject
    {
        /// <summary>
        /// Gets or Sets Operation
        /// </summary>
        [DataMember(Name="operation", EmitDefaultValue=false)]
        public OperationType Operation { get; set; }
        /// <summary>
        /// Initializes a new instance of the <see cref="PlacedLimitOrder" /> class.
        /// </summary>
        /// <param name="orderId">orderId (required).</param>
        /// <param name="operation">operation (required).</param>
        /// <param name="status">status (required).</param>
        /// <param name="rejectReason">rejectReason.</param>
        /// <param name="requestedLots">requestedLots (required).</param>
        /// <param name="executedLots">executedLots (required).</param>
        /// <param name="commission">commission.</param>
        public PlacedLimitOrder(string orderId = default(string), OperationType operation = default(OperationType), string status = default(string), string rejectReason = default(string), int? requestedLots = default(int?), int? executedLots = default(int?), MoneyAmount commission = default(MoneyAmount))
        {
            // to ensure "orderId" is required (not null)
            if (orderId == null)
            {
                throw new InvalidDataException("orderId is a required property for PlacedLimitOrder and cannot be null");
            }
            else
            {
                this.OrderId = orderId;
            }
            // to ensure "operation" is required (not null)
            if (operation == null)
            {
                throw new InvalidDataException("operation is a required property for PlacedLimitOrder and cannot be null");
            }
            else
            {
                this.Operation = operation;
            }
            // to ensure "status" is required (not null)
            if (status == null)
            {
                throw new InvalidDataException("status is a required property for PlacedLimitOrder and cannot be null");
            }
            else
            {
                this.Status = status;
            }
            // to ensure "requestedLots" is required (not null)
            if (requestedLots == null)
            {
                throw new InvalidDataException("requestedLots is a required property for PlacedLimitOrder and cannot be null");
            }
            else
            {
                this.RequestedLots = requestedLots;
            }
            // to ensure "executedLots" is required (not null)
            if (executedLots == null)
            {
                throw new InvalidDataException("executedLots is a required property for PlacedLimitOrder and cannot be null");
            }
            else
            {
                this.ExecutedLots = executedLots;
            }
            this.RejectReason = rejectReason;
            this.Commission = commission;
        }
        
        /// <summary>
        /// Gets or Sets OrderId
        /// </summary>
        [DataMember(Name="orderId", EmitDefaultValue=false)]
        public string OrderId { get; set; }


        /// <summary>
        /// Gets or Sets Status
        /// </summary>
        [DataMember(Name="status", EmitDefaultValue=false)]
        public string Status { get; set; }

        /// <summary>
        /// Gets or Sets RejectReason
        /// </summary>
        [DataMember(Name="rejectReason", EmitDefaultValue=false)]
        public string RejectReason { get; set; }

        /// <summary>
        /// Gets or Sets RequestedLots
        /// </summary>
        [DataMember(Name="requestedLots", EmitDefaultValue=false)]
        public int? RequestedLots { get; set; }

        /// <summary>
        /// Gets or Sets ExecutedLots
        /// </summary>
        [DataMember(Name="executedLots", EmitDefaultValue=false)]
        public int? ExecutedLots { get; set; }

        /// <summary>
        /// Gets or Sets Commission
        /// </summary>
        [DataMember(Name="commission", EmitDefaultValue=false)]
        public MoneyAmount Commission { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            var sb = new StringBuilder();
            sb.Append("class PlacedLimitOrder {\n");
            sb.Append("  OrderId: ").Append(OrderId).Append("\n");
            sb.Append("  Operation: ").Append(Operation).Append("\n");
            sb.Append("  Status: ").Append(Status).Append("\n");
            sb.Append("  RejectReason: ").Append(RejectReason).Append("\n");
            sb.Append("  RequestedLots: ").Append(RequestedLots).Append("\n");
            sb.Append("  ExecutedLots: ").Append(ExecutedLots).Append("\n");
            sb.Append("  Commission: ").Append(Commission).Append("\n");
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
            return this.Equals(input as PlacedLimitOrder);
        }

        /// <summary>
        /// Returns true if PlacedLimitOrder instances are equal
        /// </summary>
        /// <param name="input">Instance of PlacedLimitOrder to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(PlacedLimitOrder input)
        {
            if (input == null)
                return false;

            return 
                (
                    this.OrderId == input.OrderId ||
                    (this.OrderId != null &&
                    this.OrderId.Equals(input.OrderId))
                ) && 
                (
                    this.Operation == input.Operation ||
                    (this.Operation != null &&
                    this.Operation.Equals(input.Operation))
                ) && 
                (
                    this.Status == input.Status ||
                    (this.Status != null &&
                    this.Status.Equals(input.Status))
                ) && 
                (
                    this.RejectReason == input.RejectReason ||
                    (this.RejectReason != null &&
                    this.RejectReason.Equals(input.RejectReason))
                ) && 
                (
                    this.RequestedLots == input.RequestedLots ||
                    (this.RequestedLots != null &&
                    this.RequestedLots.Equals(input.RequestedLots))
                ) && 
                (
                    this.ExecutedLots == input.ExecutedLots ||
                    (this.ExecutedLots != null &&
                    this.ExecutedLots.Equals(input.ExecutedLots))
                ) && 
                (
                    this.Commission == input.Commission ||
                    (this.Commission != null &&
                    this.Commission.Equals(input.Commission))
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
                if (this.OrderId != null)
                    hashCode = hashCode * 59 + this.OrderId.GetHashCode();
                if (this.Operation != null)
                    hashCode = hashCode * 59 + this.Operation.GetHashCode();
                if (this.Status != null)
                    hashCode = hashCode * 59 + this.Status.GetHashCode();
                if (this.RejectReason != null)
                    hashCode = hashCode * 59 + this.RejectReason.GetHashCode();
                if (this.RequestedLots != null)
                    hashCode = hashCode * 59 + this.RequestedLots.GetHashCode();
                if (this.ExecutedLots != null)
                    hashCode = hashCode * 59 + this.ExecutedLots.GetHashCode();
                if (this.Commission != null)
                    hashCode = hashCode * 59 + this.Commission.GetHashCode();
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
