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
    /// Operation
    /// </summary>
    [DataContract]
        public partial class Operation :  IEquatable<Operation>, IValidatableObject
    {
        /// <summary>
        /// Gets or Sets Status
        /// </summary>
        [DataMember(Name="status", EmitDefaultValue=false)]
        public OperationStatus Status { get; set; }
        /// <summary>
        /// Gets or Sets Currency
        /// </summary>
        [DataMember(Name="currency", EmitDefaultValue=false)]
        public Currency Currency { get; set; }
        /// <summary>
        /// Gets or Sets InstrumentType
        /// </summary>
        [DataMember(Name="instrumentType", EmitDefaultValue=false)]
        public InstrumentType? InstrumentType { get; set; }
        /// <summary>
        /// Gets or Sets OperationType
        /// </summary>
        [DataMember(Name="operationType", EmitDefaultValue=false)]
        public OperationTypeWithCommission? OperationType { get; set; }
        /// <summary>
        /// Initializes a new instance of the <see cref="Operation" /> class.
        /// </summary>
        /// <param name="id">id (required).</param>
        /// <param name="status">status (required).</param>
        /// <param name="trades">trades.</param>
        /// <param name="commission">commission.</param>
        /// <param name="currency">currency (required).</param>
        /// <param name="payment">payment (required).</param>
        /// <param name="price">price.</param>
        /// <param name="quantity">quantity.</param>
        /// <param name="figi">figi.</param>
        /// <param name="instrumentType">instrumentType.</param>
        /// <param name="isMarginCall">isMarginCall (required).</param>
        /// <param name="date">ISO8601 (required).</param>
        /// <param name="operationType">operationType.</param>
        public Operation(string id = default(string), OperationStatus status = default(OperationStatus), List<OperationTrade> trades = default(List<OperationTrade>), MoneyAmount commission = default(MoneyAmount), Currency currency = default(Currency), double? payment = default(double?), double? price = default(double?), int? quantity = default(int?), string figi = default(string), InstrumentType? instrumentType = default(InstrumentType?), bool? isMarginCall = default(bool?), DateTime? date = default(DateTime?), OperationTypeWithCommission? operationType = default(OperationTypeWithCommission?))
        {
            // to ensure "id" is required (not null)
            if (id == null)
            {
                throw new InvalidDataException("id is a required property for Operation and cannot be null");
            }
            else
            {
                this.Id = id;
            }
            // to ensure "status" is required (not null)
            if (status == null)
            {
                throw new InvalidDataException("status is a required property for Operation and cannot be null");
            }
            else
            {
                this.Status = status;
            }
            // to ensure "currency" is required (not null)
            if (currency == null)
            {
                throw new InvalidDataException("currency is a required property for Operation and cannot be null");
            }
            else
            {
                this.Currency = currency;
            }
            // to ensure "payment" is required (not null)
            if (payment == null)
            {
                throw new InvalidDataException("payment is a required property for Operation and cannot be null");
            }
            else
            {
                this.Payment = payment;
            }
            // to ensure "isMarginCall" is required (not null)
            if (isMarginCall == null)
            {
                throw new InvalidDataException("isMarginCall is a required property for Operation and cannot be null");
            }
            else
            {
                this.IsMarginCall = isMarginCall;
            }
            // to ensure "date" is required (not null)
            if (date == null)
            {
                throw new InvalidDataException("date is a required property for Operation and cannot be null");
            }
            else
            {
                this.Date = date;
            }
            this.Trades = trades;
            this.Commission = commission;
            this.Price = price;
            this.Quantity = quantity;
            this.Figi = figi;
            this.InstrumentType = instrumentType;
            this.OperationType = operationType;
        }
        
        /// <summary>
        /// Gets or Sets Id
        /// </summary>
        [DataMember(Name="id", EmitDefaultValue=false)]
        public string Id { get; set; }


        /// <summary>
        /// Gets or Sets Trades
        /// </summary>
        [DataMember(Name="trades", EmitDefaultValue=false)]
        public List<OperationTrade> Trades { get; set; }

        /// <summary>
        /// Gets or Sets Commission
        /// </summary>
        [DataMember(Name="commission", EmitDefaultValue=false)]
        public MoneyAmount Commission { get; set; }


        /// <summary>
        /// Gets or Sets Payment
        /// </summary>
        [DataMember(Name="payment", EmitDefaultValue=false)]
        public double? Payment { get; set; }

        /// <summary>
        /// Gets or Sets Price
        /// </summary>
        [DataMember(Name="price", EmitDefaultValue=false)]
        public double? Price { get; set; }

        /// <summary>
        /// Gets or Sets Quantity
        /// </summary>
        [DataMember(Name="quantity", EmitDefaultValue=false)]
        public int? Quantity { get; set; }

        /// <summary>
        /// Gets or Sets Figi
        /// </summary>
        [DataMember(Name="figi", EmitDefaultValue=false)]
        public string Figi { get; set; }


        /// <summary>
        /// Gets or Sets IsMarginCall
        /// </summary>
        [DataMember(Name="isMarginCall", EmitDefaultValue=false)]
        public bool? IsMarginCall { get; set; }

        /// <summary>
        /// ISO8601
        /// </summary>
        /// <value>ISO8601</value>
        [DataMember(Name="date", EmitDefaultValue=false)]
        public DateTime? Date { get; set; }


        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            var sb = new StringBuilder();
            sb.Append("class Operation {\n");
            sb.Append("  Id: ").Append(Id).Append("\n");
            sb.Append("  Status: ").Append(Status).Append("\n");
            sb.Append("  Trades: ").Append(Trades).Append("\n");
            sb.Append("  Commission: ").Append(Commission).Append("\n");
            sb.Append("  Currency: ").Append(Currency).Append("\n");
            sb.Append("  Payment: ").Append(Payment).Append("\n");
            sb.Append("  Price: ").Append(Price).Append("\n");
            sb.Append("  Quantity: ").Append(Quantity).Append("\n");
            sb.Append("  Figi: ").Append(Figi).Append("\n");
            sb.Append("  InstrumentType: ").Append(InstrumentType).Append("\n");
            sb.Append("  IsMarginCall: ").Append(IsMarginCall).Append("\n");
            sb.Append("  Date: ").Append(Date).Append("\n");
            sb.Append("  OperationType: ").Append(OperationType).Append("\n");
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
            return this.Equals(input as Operation);
        }

        /// <summary>
        /// Returns true if Operation instances are equal
        /// </summary>
        /// <param name="input">Instance of Operation to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(Operation input)
        {
            if (input == null)
                return false;

            return 
                (
                    this.Id == input.Id ||
                    (this.Id != null &&
                    this.Id.Equals(input.Id))
                ) && 
                (
                    this.Status == input.Status ||
                    (this.Status != null &&
                    this.Status.Equals(input.Status))
                ) && 
                (
                    this.Trades == input.Trades ||
                    this.Trades != null &&
                    input.Trades != null &&
                    this.Trades.SequenceEqual(input.Trades)
                ) && 
                (
                    this.Commission == input.Commission ||
                    (this.Commission != null &&
                    this.Commission.Equals(input.Commission))
                ) && 
                (
                    this.Currency == input.Currency ||
                    (this.Currency != null &&
                    this.Currency.Equals(input.Currency))
                ) && 
                (
                    this.Payment == input.Payment ||
                    (this.Payment != null &&
                    this.Payment.Equals(input.Payment))
                ) && 
                (
                    this.Price == input.Price ||
                    (this.Price != null &&
                    this.Price.Equals(input.Price))
                ) && 
                (
                    this.Quantity == input.Quantity ||
                    (this.Quantity != null &&
                    this.Quantity.Equals(input.Quantity))
                ) && 
                (
                    this.Figi == input.Figi ||
                    (this.Figi != null &&
                    this.Figi.Equals(input.Figi))
                ) && 
                (
                    this.InstrumentType == input.InstrumentType ||
                    (this.InstrumentType != null &&
                    this.InstrumentType.Equals(input.InstrumentType))
                ) && 
                (
                    this.IsMarginCall == input.IsMarginCall ||
                    (this.IsMarginCall != null &&
                    this.IsMarginCall.Equals(input.IsMarginCall))
                ) && 
                (
                    this.Date == input.Date ||
                    (this.Date != null &&
                    this.Date.Equals(input.Date))
                ) && 
                (
                    this.OperationType == input.OperationType ||
                    (this.OperationType != null &&
                    this.OperationType.Equals(input.OperationType))
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
                if (this.Id != null)
                    hashCode = hashCode * 59 + this.Id.GetHashCode();
                if (this.Status != null)
                    hashCode = hashCode * 59 + this.Status.GetHashCode();
                if (this.Trades != null)
                    hashCode = hashCode * 59 + this.Trades.GetHashCode();
                if (this.Commission != null)
                    hashCode = hashCode * 59 + this.Commission.GetHashCode();
                if (this.Currency != null)
                    hashCode = hashCode * 59 + this.Currency.GetHashCode();
                if (this.Payment != null)
                    hashCode = hashCode * 59 + this.Payment.GetHashCode();
                if (this.Price != null)
                    hashCode = hashCode * 59 + this.Price.GetHashCode();
                if (this.Quantity != null)
                    hashCode = hashCode * 59 + this.Quantity.GetHashCode();
                if (this.Figi != null)
                    hashCode = hashCode * 59 + this.Figi.GetHashCode();
                if (this.InstrumentType != null)
                    hashCode = hashCode * 59 + this.InstrumentType.GetHashCode();
                if (this.IsMarginCall != null)
                    hashCode = hashCode * 59 + this.IsMarginCall.GetHashCode();
                if (this.Date != null)
                    hashCode = hashCode * 59 + this.Date.GetHashCode();
                if (this.OperationType != null)
                    hashCode = hashCode * 59 + this.OperationType.GetHashCode();
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
