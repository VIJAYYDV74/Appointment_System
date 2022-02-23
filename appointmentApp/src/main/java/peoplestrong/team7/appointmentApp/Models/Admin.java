package peoplestrong.team7.appointmentApp.Models;

import java.util.List;

public class Admin {

    public List<User> users;
    public List<Business> businesses;
    public List<Appointment> appointments;
    public List<Payments> payments;
    public int totalUsers;
    public int newUsersThisWeek;
    public int totalBusinesses;
    public int newBusinessesToday;
    public int totalRevenue;
    public int revenueThisWeek;

    public Admin() {
        this.users = users;
        this.businesses = businesses;
        this.appointments = appointments;
        this.payments = payments;
        this.totalUsers = totalUsers;
        this.newUsersThisWeek = newUsersThisWeek;
        this.totalBusinesses = totalBusinesses;
        this.newBusinessesToday = newBusinessesToday;
        this.totalRevenue = totalRevenue;
        this.revenueThisWeek = revenueThisWeek;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Business> getBusinesses() {
        return businesses;
    }

    public void setBusinesses(List<Business> businesses) {
        this.businesses = businesses;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public List<Payments> getPayments() {
        return payments;
    }

    public void setPayments(List<Payments> payments) {
        this.payments = payments;
    }

    public int getTotalUsers() {
        return totalUsers;
    }

    public void setTotalUsers(int totalUsers) {
        this.totalUsers = totalUsers;
    }

    public int getNewUsersThisWeek() {
        return newUsersThisWeek;
    }

    public void setNewUsersThisWeek(int newUsersThisWeek) {
        this.newUsersThisWeek = newUsersThisWeek;
    }

    public int getTotalBusinesses() {
        return totalBusinesses;
    }

    public void setTotalBusinesses(int totalBusinesses) {
        this.totalBusinesses = totalBusinesses;
    }

    public int getNewBusinessesToday() {
        return newBusinessesToday;
    }

    public void setNewBusinessesToday(int newBusinessesToday) {
        this.newBusinessesToday = newBusinessesToday;
    }

    public int getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(int totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public int getRevenueThisWeek() {
        return revenueThisWeek;
    }

    public void setRevenueThisWeek(int revenueThisWeek) {
        this.revenueThisWeek = revenueThisWeek;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "users=" + users +
                ", businesses=" + businesses +
                ", appointments=" + appointments +
                ", payments=" + payments +
                ", totalUsers=" + totalUsers +
                ", newUsersThisWeek=" + newUsersThisWeek +
                ", totalBusinesses=" + totalBusinesses +
                ", newBusinessesToday=" + newBusinessesToday +
                ", totalRevenue=" + totalRevenue +
                ", revenueThisWeek=" + revenueThisWeek +
                '}';
    }
}
