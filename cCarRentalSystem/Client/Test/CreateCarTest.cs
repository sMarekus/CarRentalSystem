using BlazorApp.Pages;
using Bunit;
using Bunit.TestDoubles;
using Domain.DTOs;
using HttpClients.ClientInterfaces;
using HttpClients.Implementations;
using Microsoft.AspNetCore.Components;
using Microsoft.Extensions.DependencyInjection;
using Moq;
using Xunit;

namespace Test;

public class CreateCarTest
{
    private Mock<ICarService> carService;
    private TestContext context;
    private IRenderedComponent<CreateCar> renderedComponent;
    
    public CreateCarTest()
    {
        Setup();
    }

    private void Setup()
    {
        HttpClient client = new HttpClient();
        carService = new Mock<ICarService>();
        context = new TestContext();
        context.Services.AddSingleton<ICarService>(new CarService(client));
        context.Services.AddSingleton(carService.Object);
        
        context.AddTestAuthorization();
        
        renderedComponent = context.RenderComponent<CreateCar>();
    }
    
    private void SetInstancesValueForCar()
    {
        renderedComponent.Instance.brand = "testBrand";
        renderedComponent.Instance.color = "testColor";
        renderedComponent.Instance.model = "testModel";
        renderedComponent.Instance.pricePerDay = 100;
        renderedComponent.Instance.gearbox = "testGearbox";
        renderedComponent.Instance.fuelType = "testFuel";
        renderedComponent.Instance.horsePower = 100;
        renderedComponent.Instance.description = "testDescription";
        renderedComponent.Instance.bodyType = "testBodyType";
    }
    
    [Fact]
    public void CreateButtonDisabledWhenFieldsAreEmpty()
    {
        var addButton = renderedComponent.Find("button.acceptbtn");
        Assert.True(addButton.HasAttribute("disabled"));
    }
    
    [Fact]
    public void CarCreationSuccess()
    {
        SetInstancesValueForCar();
        carService.Setup(service => service.CreateAsync(It.IsAny<CarCreationDto>()));

        renderedComponent.Find("button.acceptbtn").Click();

        Assert.True(renderedComponent.Instance.showModal);
    }
}