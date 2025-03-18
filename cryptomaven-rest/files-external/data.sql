INSERT INTO ROLES (id, name) VALUES
                               (1, 'ADMIN'),
                               (2, 'USER');

INSERT INTO USERS (userid, contacttype, cusurl, dashboardcode, email, firstname, isactive, lastname, organizationcode, password, usertype, username) VALUES
                                                                                                                                                       (11, 1, 'https://localhost:8080/api/users/admin@example.com', 'DASH001', 'admin@example.com', 'Admin', 1, 'User', 'ORG001', 'securepassword', 1, 'admin'),
                                                                                                                                                       (12, 2, 'https://example.com/user2', 'DASH002', 'user@example.com', 'Regular', 1, 'User', 'ORG002', 'password123', 2, 'user');

INSERT INTO USERS_ROLES (role_id, user_id) VALUES
                                             (1, 11), -- Admin is assigned ADMIN role
                                             (2, 12); -- User is assigned USER role
