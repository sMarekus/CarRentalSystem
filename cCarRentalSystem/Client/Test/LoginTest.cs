using BlazorApp.Pages;
using Bunit;
using Bunit.TestDoubles;
using HttpClients.ClientInterfaces;
using HttpClients.Implementations;
using Microsoft.AspNetCore.Components;
using Microsoft.Extensions.DependencyInjection;
using Moq;
using Xunit;

namespace Test;

public class LoginTest
{
    private Mock<IUserService> userService;
    private TestContext context;
    private IRenderedComponent<Login> renderedComponent;

    public LoginTest()
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

        // Render the Login component
        renderedComponent = context.RenderComponent<Login>();
    }
    
    private void SetInstancesValueForUser()
    {
        renderedComponent.Instance.userName = "testUser";
        renderedComponent.Instance.password = "testPassword";
    }

    [Fact]
    public void LoginButtonDisabledWhenFieldsAreEmpty()
    {
        var loginButton = renderedComponent.Find("button.acceptbtn");
        Assert.True(loginButton.HasAttribute("disabled"));
    }

    [Fact]
    public void SuccessfulLogin()
    {
        userService.Setup(service => service.ValidateUser(It.IsAny<string>(), It.IsAny<string>()));

        SetInstancesValueForUser();

        renderedComponent.Find("button.acceptbtn").Click();

        userService.Verify(service => service.ValidateUser("testUser", "testPassword"), Times.Once);
    }

    [Fact]
    public void invalidLogin()
    {
        userService.Setup(service => service.ValidateUser(It.IsAny<string>(), It.IsAny<string>()))
            .Throws(new Exception("Invalid username or password"));

        SetInstancesValueForUser();

        renderedComponent.Find("button.acceptbtn").Click();

        userService.Verify(service => service.ValidateUser("testUser", "testPassword"), Times.Once);
    }
}