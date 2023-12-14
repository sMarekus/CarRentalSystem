using BlazorApp.Pages;
using Bunit;
using Bunit.TestDoubles;
using HttpClients.ClientInterfaces;
using Microsoft.Extensions.DependencyInjection;
using Moq;
using Xunit;

namespace Test;

public class CancelReservationTest
{
    private Mock<IReservationService> reservationService;
    private TestContext context;
    private IRenderedComponent<Reservations> renderedComponent;
    
    public CancelReservationTest()
    {
        Setup();
    }
    
    private void Setup()
    {
        // Initialize the TestContext
        context = new TestContext();
        
        HttpClient client = new HttpClient();
        reservationService = new Mock<IReservationService>();
        
        context.Services.AddSingleton<IReservationService>(reservationService.Object);
        
        context.AddTestAuthorization();
        
        renderedComponent = context.RenderComponent<Reservations>();
    }
    
    [Fact]
    public void TestCancelReservation()
    {
        var reservationId = 1;
        reservationService.Setup(service => service.CancelReservationAsync(reservationId)).Returns(Task.CompletedTask);
        
        renderedComponent.Instance.CancelReservation(reservationId);
        
        reservationService.Verify(service => service.CancelReservationAsync(reservationId), Times.Once);
    }
}