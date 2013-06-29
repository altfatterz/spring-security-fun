package org.spring.security.preauthorize;

import org.springframework.security.access.prepost.PreAuthorize;

public interface SecuredService {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void securedMethod();


}
