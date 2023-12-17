using System.Security.Claims;
using Bunit;
using Bunit.TestDoubles;
using HttpClients.ClientInterfaces;
using Moq;
using Xunit;
using BlazorApp.Pages;
using Domain.DTOs;
using Domain.Models;
using HttpClients.Implementations;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Components;
using Microsoft.AspNetCore.Components.Authorization;
using Microsoft.Extensions.DependencyInjection;

namespace Test;

public class RegisterUserTests : IClassFixture<TestContext>
{
    private TestContext context;
    private IRenderedComponent<Register> renderedComponent;
    private Mock<IUserService> userService;

    public RegisterUserTests()
    {
        Setup();
    }

    private void Setup()
    {
        HttpClient client = new HttpClient();
        userService = new Mock<IUserService>();
        context = new TestContext();
        context.Services.AddSingleton<IUserService>(new UserService(client));
        context.Services.AddSingleton(userService.Object);
        context.AddTestAuthorization();
        renderedComponent = context.RenderComponent<Register>();
    }
    
    private void SetInstancesValueForUser()
    {
        renderedComponent.Instance.firstName = "Janko";
        renderedComponent.Instance.lastName = "Hraško";
        renderedComponent.Instance.email = "janko@hrasko.sk";
        renderedComponent.Instance.password = "123456";
        renderedComponent.Instance.userName = "jankohrasko";
        renderedComponent.Instance.phoneNumber = 0900123456;
    }
    
    [Fact]
    public void ErrorWhenFirstNameIsNull()
    {
        SetInstancesValueForUser();
        
        renderedComponent.Instance.phoneNumber = 0;
        renderedComponent.Find("#createUser").Click();
        Assert.Equal("Phone number cannot be 0", renderedComponent.Instance.resultMsg);
    }
    
    [Fact]
    public void SuccessfulUserRegistration()
    {
        SetInstancesValueForUser();
        
        renderedComponent.Find("#createUser").Click();
        Assert.Equal("User successfully created", renderedComponent.Instance.resultMsg);
    }
    
    [Fact]
    public void ErrorWhenMandatoryFieldsAreEmpty()
    {
        SetInstancesValueForUser();
        
        renderedComponent.Instance.firstName = "";
        renderedComponent.Instance.lastName = "";
        renderedComponent.Instance.email = "";
        renderedComponent.Instance.password = "";
        renderedComponent.Instance.userName = "";
    
        renderedComponent.Find("#createUser").Click();
        Assert.True(renderedComponent.Instance.IsRegisterButtonDisabled);
    }
}