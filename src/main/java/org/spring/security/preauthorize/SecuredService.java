package org.spring.security.preauthorize;

import org.spring.security.preauthorize.items.Item;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;

public interface SecuredService {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void securedMethod();

    @PostAuthorize("hasPermission(returnObject, 'READ')")
    Item getItem(Long id);

    @PostAuthorize("hasPermission(returnObject, 'READ')")
    Item getPageItem(Long id);

}
