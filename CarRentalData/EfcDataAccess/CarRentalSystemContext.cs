using Entity.Model;
using Microsoft.EntityFrameworkCore;

namespace EfcDataAccess;

public class CarRentalSystemContext : DbContext
{
    public DbSet<UserEntity?> Users { get; set; }
    
    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
    {
        optionsBuilder.UseSqlite("Data Source = ..\\EfcDataAccess\\Todo.db");
        optionsBuilder.UseQueryTrackingBehavior(QueryTrackingBehavior.NoTracking);            
    }
    
    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder.Entity<UserEntity>().HasKey(user => user.Cpr);
    }
}