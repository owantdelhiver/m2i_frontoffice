package com.groupe4.frontoffice.model.user;

import com.groupe4.frontoffice.dto.UserDto;
import com.groupe4.frontoffice.model.cart.Cart;
import com.groupe4.frontoffice.model.order.Order;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Collection;
import java.util.List;

@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String lastname;
    private String firstname;
    private String email;
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_adress")
    private Adress adress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cart")
    private Cart cart;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name="id_user"),
            inverseJoinColumns = @JoinColumn(name="id_role")
    )
    public List<Role> rolelist;

    public User() {
    }

    public User(String lastname, String firstname, String email, String password, Adress adress, Cart cart , List<Order> orders) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.password = password;
        this.adress = adress;
        this.cart = cart;
        this.orders = orders;
    }

    public User(String lastname, String firstname, String email, String password, Cart cart) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.password = password;
        this.cart = cart;
    }

    public UserDto toDto(){
        UserDto dto = new UserDto();
        dto.setId(this.getId());
        dto.setFirstname(this.getFirstname());
        dto.setLastname(this.getLastname());
        dto.setEmail(this.getEmail());
        dto.setPassword(this.getPassword());
        return dto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.rolelist
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .toList();
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public Cart getCart() {
        return cart;
    }
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Adress setAdress() { return adress;
    }

    public List<Role> getRolelist() {
        return rolelist;
    }

    public void setRolelist(List<Role> rolelist) {
        this.rolelist = rolelist;
    }
}
