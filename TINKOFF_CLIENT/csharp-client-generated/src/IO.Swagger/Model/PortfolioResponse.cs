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
    /// PortfolioResponse
    /// </summary>
    [DataContract]
        public partial class PortfolioResponse :  IEquatable<PortfolioResponse>, IValidatableObject
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="PortfolioResponse" /> class.
        /// </summary>
        /// <param name="trackingId">trackingId (required).</param>
        /// <param name="status">status (required) (default to &quot;Ok&quot;).</param>
        /// <param name="payload">payload (required).</param>
        public PortfolioResponse(string trackingId = default(string), string status = "Ok", Portfolio payload = default(Portfolio))
        {
            // to ensure "trackingId" is required (not null)
            if (trackingId == null)
            {
                throw new InvalidDataException("trackingId is a required property for PortfolioResponse and cannot be null");
            }
            else
            {
                this.TrackingId = trackingId;
            }
            // to ensure "status" is required (not null)
            if (status == null)
            {
                throw new InvalidDataException("status is a required property for PortfolioResponse and cannot be null");
            }
            else
            {
                this.Status = status;
            }
            // to ensure "payload" is required (not null)
            if (payload == null)
            {
                throw new InvalidDataException("payload is a required property for PortfolioResponse and cannot be null");
            }
            else
            {
                this.Payload = payload;
            }
        }
        
        /// <summary>
        /// Gets or Sets TrackingId
        /// </summary>
        [DataMember(Name="trackingId", EmitDefaultValue=false)]
        public string TrackingId { get; set; }

        /// <summary>
        /// Gets or Sets Status
        /// </summary>
        [DataMember(Name="status", EmitDefaultValue=false)]
        public string Status { get; set; }

        /// <summary>
        /// Gets or Sets Payload
        /// </summary>
        [DataMember(Name="payload", EmitDefaultValue=false)]
        public Portfolio Payload { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            var sb = new StringBuilder();
            sb.Append("class PortfolioResponse {\n");
            sb.Append("  TrackingId: ").Append(TrackingId).Append("\n");
            sb.Append("  Status: ").Append(Status).Append("\n");
            sb.Append("  Payload: ").Append(Payload).Append("\n");
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
            return this.Equals(input as PortfolioResponse);
        }

        /// <summary>
        /// Returns true if PortfolioResponse instances are equal
        /// </summary>
        /// <param name="input">Instance of PortfolioResponse to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(PortfolioResponse input)
        {
            if (input == null)
                return false;

            return 
                (
                    this.TrackingId == input.TrackingId ||
                    (this.TrackingId != null &&
                    this.TrackingId.Equals(input.TrackingId))
                ) && 
                (
                    this.Status == input.Status ||
                    (this.Status != null &&
                    this.Status.Equals(input.Status))
                ) && 
                (
                    this.Payload == input.Payload ||
                    (this.Payload != null &&
                    this.Payload.Equals(input.Payload))
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
                if (this.TrackingId != null)
                    hashCode = hashCode * 59 + this.TrackingId.GetHashCode();
                if (this.Status != null)
                    hashCode = hashCode * 59 + this.Status.GetHashCode();
                if (this.Payload != null)
                    hashCode = hashCode * 59 + this.Payload.GetHashCode();
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