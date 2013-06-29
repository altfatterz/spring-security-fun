package org.spring.security.preauthorize;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SecuredServiceImpl implements SecuredService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecuredService.class);

    @Override
    public void securedMethod() {
        LOGGER.info("This method invocation is secured by role_admin access");
    }

}
