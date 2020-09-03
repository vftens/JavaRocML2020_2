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
using System.IO;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Reflection;
using RestSharp;
using NUnit.Framework;

using IO.Swagger.Client;
using IO.Swagger.Api;
using IO.Swagger.Model;

namespace IO.Swagger.Test
{
    /// <summary>
    ///  Class for testing OperationsApi
    /// </summary>
    /// <remarks>
    /// This file is automatically generated by Swagger Codegen.
    /// Please update the test case below to test the API endpoint.
    /// </remarks>
    [TestFixture]
    public class OperationsApiTests
    {
        private OperationsApi instance;

        /// <summary>
        /// Setup before each unit test
        /// </summary>
        [SetUp]
        public void Init()
        {
            instance = new OperationsApi();
        }

        /// <summary>
        /// Clean up after each unit test
        /// </summary>
        [TearDown]
        public void Cleanup()
        {

        }

        /// <summary>
        /// Test an instance of OperationsApi
        /// </summary>
        [Test]
        public void InstanceTest()
        {
            // TODO uncomment below to test 'IsInstanceOfType' OperationsApi
            //Assert.IsInstanceOfType(typeof(OperationsApi), instance, "instance is a OperationsApi");
        }

        /// <summary>
        /// Test OperationsGet
        /// </summary>
        [Test]
        public void OperationsGetTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //DateTime? from = null;
            //OperationInterval interval = null;
            //string figi = null;
            //var response = instance.OperationsGet(from, interval, figi);
            //Assert.IsInstanceOf<OperationsResponse> (response, "response is OperationsResponse");
        }
    }

}
