package org.spring.security.fun;

import java.util.List;

import org.spring.security.fun.items.Item;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;

public interface SecuredService {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void securedMethod();

    @PostAuthorize("hasPermission(returnObject, 'READ')")
    Item getItem(Long id);

    @PostAuthorize("hasPermission(returnObject, 'READ')")
    Item getPageItem(Long id);

    @PostAuthorize("hasPermission(returnObject, 'WRITE')")
    Item getPage(Long id);

    @PostFilter("hasPermission(filterObject, 'READ')")
    List<Item> getItems();
}
