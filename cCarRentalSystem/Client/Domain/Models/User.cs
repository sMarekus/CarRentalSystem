﻿namespace Domain.Models;

public class User
{
    public string Name { get; set; }
    public string Surname { get; set; }
    public string Email { get; set; }
    public long Cpr { get; set; }
    public string Password { get; set; }
    public string PhoneNumber { get; set; }
    public bool IsAdmin { get; set; }
    
}