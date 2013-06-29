package org.spring.security.preauthorize;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:app-context.xml")
public class DummyServiceImplTest {

    @Autowired
    private SecuredService securedService;

    @Test
    public void adminAccess() {
        Authentication admin =
                new UsernamePasswordAuthenticationToken("admin", "admin", AuthorityUtils.createAuthorityList(
                        "ROLE_ADMIN"));
        SecurityContextHolder.getContext().setAuthentication(admin);
        securedService.securedMethod();
    }

    @Test(expected = AccessDeniedException.class)
    public void userAccess() {
        Authentication admin =
                new UsernamePasswordAuthenticationToken("user", "user", AuthorityUtils.createAuthorityList(
                        "ROLE_USER"));
        SecurityContextHolder.getContext().setAuthentication(admin);
        securedService.securedMethod();
    }

    @Test(expected = AuthenticationCredentialsNotFoundException.class)
    public void testSecuredClassNotAuthenticated() throws Exception {
        securedService.securedMethod();
    }

    @After
    public void tearDown() {
        SecurityContextHolder.clearContext();
    }

}
