INSERT INTO acl_sid (id, principal, sid) VALUES
(1, 1, 'admin'),
(2, 1, 'user');

INSERT INTO acl_class (id, class) VALUES
(1, 'org.spring.security.preauthorize.items.Page'),
(2, 'org.spring.security.preauthorize.items.Container'),
(3, 'org.spring.security.preauthorize.items.Widget');

-- one page with one container and two widgets
INSERT INTO acl_object_identity
(id, object_id_class, object_id_identity, parent_object, owner_sid, entries_inheriting) VALUES
(1, 1, 1, NULL, 1, 1),
(2, 2, 2, 1, 1, 1),
(3, 3, 3, 2, 1, 1),
(4, 3, 4, 2, 1, 0);

INSERT INTO acl_entry
(id, acl_object_identity, ace_order, sid, mask, granting, audit_success, audit_failure) VALUES
(1, 1, 1, 1, 1, 1, 1, 1),
(2, 1, 2, 1, 2, 1, 1, 1),
(3, 1, 3, 1, 4, 1, 1, 1),
(4, 1, 4, 1, 8, 1, 1, 1),
(5, 1, 5, 1, 16, 1, 1, 1),
(6, 1, 6, 2, 1, 1, 1, 1),
(7, 1, 7, 2, 2, 0, 1, 1);





