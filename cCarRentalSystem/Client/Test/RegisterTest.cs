using System.Security.Claims;
using Bunit;
using HttpClients.ClientInterfaces;
using Moq;
using Xunit;
using BlazorApp.Pages;
using Domain.DTOs;
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
    
    private void Setup() {
        HttpClient client = new HttpClient();
        userService = new Mock<IUserService>();
        context = new TestContext();
        context.Services.AddSingleton<IUserService>(new UserService(client));
        context.Services.AddSingleton(userService.Object);
        context.Services.AddAuthorization();
        renderedComponent = context.RenderComponent<Register>();
        
        var authenticationStateProviderMock = new Mock<AuthenticationStateProvider>();
        authenticationStateProviderMock
            .Setup(provider => provider.GetAuthenticationStateAsync())
            .ReturnsAsync(new AuthenticationState(new ClaimsPrincipal(new ClaimsIdentity())));

        context.Services.AddSingleton<AuthenticationStateProvider>(authenticationStateProviderMock.Object);
    }
    
    [Fact]
    public void RegisterUserTest() {
        Setup();
        renderedComponent.Find("#inputFirstName").Change("Lorem");
        renderedComponent.Find("#inputLastName").Change("Ipsum");
        renderedComponent.Find("#inputEmail").Change("user@user.sk");
        renderedComponent.Find("#inputPassword").Change("heslo");
        renderedComponent.Find("#inputCprNumber").Change(4846545);
        renderedComponent.Find("#inputPhoneNumber").Change(4846545);
        renderedComponent.Find(".acceptbtn").Click();
        userService.VerifyAdd(x => x.CreateAsync(It.IsAny<UserCreationDto>()), Times.Once);
    }
}