using BlazorApp.Pages;
using Bunit;
using Bunit.TestDoubles;
using Domain.Models;
using HttpClients.ClientInterfaces;
using Microsoft.Extensions.DependencyInjection;
using Moq;
using Xunit;

namespace Test;

public class ReturnCarTest
{
    private Mock<IReservationService> reservationService;
    private Mock<ICarService> carService;
    private TestContext context;
    private IRenderedComponent<UserReservations> renderedComponent;
    
    public ReturnCarTest()
    {
        Setup();
    }

    private void Setup()
    {
        // Initialize the TestContext
        context = new TestContext();
        
        HttpClient client = new HttpClient();
        reservationService = new Mock<IReservationService>();
        carService = new Mock<ICarService>();

        // Register the mocks with the TestContext's service collection
        context.Services.AddSingleton<ICarService>(carService.Object);
        context.Services.AddSingleton<IReservationService>(reservationService.Object);

        // Add test authorization if necessary
        context.AddTestAuthorization();
    }
    
    [Fact]
    public void TestSuccessfulReturn()
    {
        // Arrange
        var reservationId = 1;
        reservationService.Setup(service => service.ReturnReservationAsync(reservationId))
            .Returns(Task.CompletedTask);
        
        // Act
        var result = reservationService.Object.ReturnReservationAsync(reservationId);
        
        // Assert
        Assert.NotNull(result);
        reservationService.Verify(service => service.ReturnReservationAsync(It.IsAny<int>()), Times.Once);
    }
}