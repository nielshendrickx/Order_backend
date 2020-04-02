package com.switchfully.order.api.security;

import com.switchfully.order.domain.user.system.security.Feature;
import com.switchfully.order.service.authentication.AuthDto;
import com.switchfully.order.service.authentication.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;

@Component
public class UserAuthenticationProvider implements AuthenticationProvider {

    private final AuthenticationService authenticationService;

    @Autowired
    public UserAuthenticationProvider(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        AuthDto authDto = authenticationService.authenticate(authentication.getPrincipal().toString(), authentication.getCredentials().toString());
        if (authDto != null) {
            return new UsernamePasswordAuthenticationToken(
                    authDto.getEmail(),
                    authDto.getPassword(),
                    rolesToGrantedAuthorities(Feature.getFeaturesForRoles(newArrayList(authDto.getRole().toString()))));
        }
        throw new BadCredentialsException("The provided credentials were invalid.");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }

    private Collection<? extends GrantedAuthority> rolesToGrantedAuthorities(List<Feature> features) {
        return features.stream()
                .map(Enum::name)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}