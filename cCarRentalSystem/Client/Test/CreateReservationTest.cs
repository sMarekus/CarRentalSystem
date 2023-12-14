using BlazorApp.Pages;
using Bunit;
using Bunit.TestDoubles;
using Domain.DTOs;
using Domain.Models;
using HttpClients.ClientInterfaces;
using HttpClients.Implementations;
using Microsoft.Extensions.DependencyInjection;
using Moq;
using Xunit;

namespace Test;

public class CreateReservationTest
{
    private Mock<IReservationService> reservationService;
    private Mock<IUserService> userService;
    private Mock<ICarService> carService;
    private TestContext context;
    private IRenderedComponent<CarDetails> renderedComponent;
    
    public CreateReservationTest()
    {
        Setup();
    }

    private void Setup()
    {
        // Initialize the TestContext
        context = new TestContext();
        
        HttpClient client = new HttpClient();
        reservationService = new Mock<IReservationService>();
        userService = new Mock<IUserService>();
        carService = new Mock<ICarService>();

        // Register the mocks with the TestContext's service collection
        context.Services.AddSingleton<ICarService>(carService.Object);
        context.Services.AddSingleton<IUserService>(userService.Object);
        context.Services.AddSingleton<IReservationService>(reservationService.Object);

        // Add test authorization if necessary
        context.AddTestAuthorization();
    }
    
    [Fact]
    public void TestSuccessfulReservationCreation()
    {
        // Arrange
        var expectedReservation = new ReservationCreationDTO(1, "user", DateTime.Today, DateTime.Today.AddDays(3), 300, false);
        reservationService.Setup(service => service.CreateAsync(It.IsAny<ReservationCreationDTO>()))
            .ReturnsAsync(new Reservation());

        // Act
        var result = reservationService.Object.CreateAsync(expectedReservation).Result;

        // Assert
        Assert.NotNull(result);
        reservationService.Verify(service => service.CreateAsync(It.IsAny<ReservationCreationDTO>()), Times.Once);
    }
    
    [Fact]
    public void TestReservationCreationFailure()
    {
        var expectedReservation = new ReservationCreationDTO(1, "user", DateTime.Today, DateTime.Today.AddDays(3), 300, false);
        reservationService.Setup(service => service.CreateAsync(It.IsAny<ReservationCreationDTO>()))
            .ThrowsAsync(new Exception());
        
        Assert.ThrowsAsync<Exception>(() => reservationService.Object.CreateAsync(expectedReservation));
        reservationService.Verify(service => service.CreateAsync(It.IsAny<ReservationCreationDTO>()), Times.Once);
    }
}