package ge.TechMarket.Tech_Market;
import ge.TechMarket.Tech_Market.entity.user;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Slf4j
public class CustomUserDetails implements UserDetails {
    private final user usr;

    public CustomUserDetails(user user) {
        this.usr = user;
    }

    @Override
    public String getUsername() {
        return usr.getEmail();
    }

    @Override
    public String getPassword() {
        return usr.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override public boolean isAccountNonExpired() { return true; }
    @Override public boolean isAccountNonLocked() { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled() { return true; }

    public Long getId() {
        return usr.getId();
    }

    public user getUser() {
        return usr;
    }
}
