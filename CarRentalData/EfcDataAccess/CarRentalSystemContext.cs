using Entity.Model;
using Microsoft.EntityFrameworkCore;

namespace EfcDataAccess;

public class CarRentalSystemContext : DbContext
{
    public DbSet<User?> Users { get; set; }
    public DbSet<Car?> Cars { get; set; }
    public DbSet<Reservation?> Reservations { get; set; }
    
    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
    {
        optionsBuilder.UseSqlite("Data Source = ../EfcDataAccess/CarRentalDatabase.db");
        optionsBuilder.UseQueryTrackingBehavior(QueryTrackingBehavior.NoTracking);            
    }
    
    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder.Entity<User>().HasKey(user => user.Username);
        modelBuilder.Entity<Car>().HasKey(car => car.Id);
        modelBuilder.Entity<Reservation>().HasKey(reservation => reservation.Id);
    }
}