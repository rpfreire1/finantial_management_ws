package com.dentalsoft.finantialManagement.config;

import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class AuditorAwareImpl implements AuditorAware<String> {
    @Value("spring.profiles.active")
    private String profile;
    public Optional<String> getCurrentAuditor() {
        return Optional.of(
//                SecurityUtils.getLoggedUser(profile)
                "devUser" // Placeholder for the logged user, replace with actual implementation
        );
    }
}
