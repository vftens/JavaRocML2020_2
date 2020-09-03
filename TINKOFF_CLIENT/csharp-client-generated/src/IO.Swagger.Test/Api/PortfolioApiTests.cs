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
    ///  Class for testing PortfolioApi
    /// </summary>
    /// <remarks>
    /// This file is automatically generated by Swagger Codegen.
    /// Please update the test case below to test the API endpoint.
    /// </remarks>
    [TestFixture]
    public class PortfolioApiTests
    {
        private PortfolioApi instance;

        /// <summary>
        /// Setup before each unit test
        /// </summary>
        [SetUp]
        public void Init()
        {
            instance = new PortfolioApi();
        }

        /// <summary>
        /// Clean up after each unit test
        /// </summary>
        [TearDown]
        public void Cleanup()
        {

        }

        /// <summary>
        /// Test an instance of PortfolioApi
        /// </summary>
        [Test]
        public void InstanceTest()
        {
            // TODO uncomment below to test 'IsInstanceOfType' PortfolioApi
            //Assert.IsInstanceOfType(typeof(PortfolioApi), instance, "instance is a PortfolioApi");
        }

        /// <summary>
        /// Test PortfolioCurrenciesGet
        /// </summary>
        [Test]
        public void PortfolioCurrenciesGetTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //var response = instance.PortfolioCurrenciesGet();
            //Assert.IsInstanceOf<PortfolioCurrenciesResponse> (response, "response is PortfolioCurrenciesResponse");
        }
        /// <summary>
        /// Test PortfolioGet
        /// </summary>
        [Test]
        public void PortfolioGetTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //var response = instance.PortfolioGet();
            //Assert.IsInstanceOf<PortfolioResponse> (response, "response is PortfolioResponse");
        }
    }

}