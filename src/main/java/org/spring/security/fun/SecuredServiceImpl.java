package org.spring.security.fun;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.security.fun.items.Page;
import org.spring.security.fun.items.Widget;
import org.spring.security.fun.items.Item;
import org.springframework.stereotype.Service;

@Service
public class SecuredServiceImpl implements SecuredService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecuredService.class);

    @Override
    public void securedMethod() {
        LOGGER.info("This method invocation is secured by role_admin access");
    }

    @Override
    public Item getItem(Long id) {
        Page page = new Page();
        page.setId(id);
        page.setName("myPage");
        return page;
    }

    @Override
    public Item getPageItem(Long id) {
        Widget widget = new Widget();
        widget.setId(id);
        widget.setName("myWidget");
        return widget;
    }

    @Override
    public Item getPage(Long id) {
        Page page = new Page();
        page.setId(id);
        page.setName("myPage");
        return page;
    }

}
