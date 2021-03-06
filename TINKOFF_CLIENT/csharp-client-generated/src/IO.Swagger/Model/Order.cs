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
    /// Order
    /// </summary>
    [DataContract]
        public partial class Order :  IEquatable<Order>, IValidatableObject
    {
        /// <summary>
        /// Gets or Sets Operation
        /// </summary>
        [DataMember(Name="operation", EmitDefaultValue=false)]
        public OperationType Operation { get; set; }
        /// <summary>
        /// Gets or Sets Status
        /// </summary>
        [DataMember(Name="status", EmitDefaultValue=false)]
        public OrderStatus Status { get; set; }
        /// <summary>
        /// Gets or Sets Type
        /// </summary>
        [DataMember(Name="type", EmitDefaultValue=false)]
        public OrderType Type { get; set; }
        /// <summary>
        /// Initializes a new instance of the <see cref="Order" /> class.
        /// </summary>
        /// <param name="orderId">orderId (required).</param>
        /// <param name="figi">figi (required).</param>
        /// <param name="operation">operation (required).</param>
        /// <param name="status">status (required).</param>
        /// <param name="requestedLots">requestedLots (required).</param>
        /// <param name="executedLots">executedLots (required).</param>
        /// <param name="type">type (required).</param>
        /// <param name="price">price (required).</param>
        public Order(string orderId = default(string), string figi = default(string), OperationType operation = default(OperationType), OrderStatus status = default(OrderStatus), int? requestedLots = default(int?), int? executedLots = default(int?), OrderType type = default(OrderType), double? price = default(double?))
        {
            // to ensure "orderId" is required (not null)
            if (orderId == null)
            {
                throw new InvalidDataException("orderId is a required property for Order and cannot be null");
            }
            else
            {
                this.OrderId = orderId;
            }
            // to ensure "figi" is required (not null)
            if (figi == null)
            {
                throw new InvalidDataException("figi is a required property for Order and cannot be null");
            }
            else
            {
                this.Figi = figi;
            }
            // to ensure "operation" is required (not null)
            if (operation == null)
            {
                throw new InvalidDataException("operation is a required property for Order and cannot be null");
            }
            else
            {
                this.Operation = operation;
            }
            // to ensure "status" is required (not null)
            if (status == null)
            {
                throw new InvalidDataException("status is a required property for Order and cannot be null");
            }
            else
            {
                this.Status = status;
            }
            // to ensure "requestedLots" is required (not null)
            if (requestedLots == null)
            {
                throw new InvalidDataException("requestedLots is a required property for Order and cannot be null");
            }
            else
            {
                this.RequestedLots = requestedLots;
            }
            // to ensure "executedLots" is required (not null)
            if (executedLots == null)
            {
                throw new InvalidDataException("executedLots is a required property for Order and cannot be null");
            }
            else
            {
                this.ExecutedLots = executedLots;
            }
            // to ensure "type" is required (not null)
            if (type == null)
            {
                throw new InvalidDataException("type is a required property for Order and cannot be null");
            }
            else
            {
                this.Type = type;
            }
            // to ensure "price" is required (not null)
            if (price == null)
            {
                throw new InvalidDataException("price is a required property for Order and cannot be null");
            }
            else
            {
                this.Price = price;
            }
        }
        
        /// <summary>
        /// Gets or Sets OrderId
        /// </summary>
        [DataMember(Name="orderId", EmitDefaultValue=false)]
        public string OrderId { get; set; }

        /// <summary>
        /// Gets or Sets Figi
        /// </summary>
        [DataMember(Name="figi", EmitDefaultValue=false)]
        public string Figi { get; set; }



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
            sb.Append("class Order {\n");
            sb.Append("  OrderId: ").Append(OrderId).Append("\n");
            sb.Append("  Figi: ").Append(Figi).Append("\n");
            sb.Append("  Operation: ").Append(Operation).Append("\n");
            sb.Append("  Status: ").Append(Status).Append("\n");
            sb.Append("  RequestedLots: ").Append(RequestedLots).Append("\n");
            sb.Append("  ExecutedLots: ").Append(ExecutedLots).Append("\n");
            sb.Append("  Type: ").Append(Type).Append("\n");
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
            return this.Equals(input as Order);
        }

        /// <summary>
        /// Returns true if Order instances are equal
        /// </summary>
        /// <param name="input">Instance of Order to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(Order input)
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
                    this.Figi == input.Figi ||
                    (this.Figi != null &&
                    this.Figi.Equals(input.Figi))
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
                    this.Type == input.Type ||
                    (this.Type != null &&
                    this.Type.Equals(input.Type))
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
                if (this.OrderId != null)
                    hashCode = hashCode * 59 + this.OrderId.GetHashCode();
                if (this.Figi != null)
                    hashCode = hashCode * 59 + this.Figi.GetHashCode();
                if (this.Operation != null)
                    hashCode = hashCode * 59 + this.Operation.GetHashCode();
                if (this.Status != null)
                    hashCode = hashCode * 59 + this.Status.GetHashCode();
                if (this.RequestedLots != null)
                    hashCode = hashCode * 59 + this.RequestedLots.GetHashCode();
                if (this.ExecutedLots != null)
                    hashCode = hashCode * 59 + this.ExecutedLots.GetHashCode();
                if (this.Type != null)
                    hashCode = hashCode * 59 + this.Type.GetHashCode();
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
