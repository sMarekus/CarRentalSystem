using Entity.Model;
using Microsoft.EntityFrameworkCore;

namespace EfcDataAccess;

public class CarRentalSystemContext : DbContext
{
    public DbSet<User?> Users { get; set; }
    
    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
    {
        optionsBuilder.UseSqlite("Data Source = ../EfcDataAccess/CarRentalDatabase.db");
        optionsBuilder.UseQueryTrackingBehavior(QueryTrackingBehavior.NoTracking);            
    }
    
    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder.Entity<User>().HasKey(user => user.Username);
    }
}