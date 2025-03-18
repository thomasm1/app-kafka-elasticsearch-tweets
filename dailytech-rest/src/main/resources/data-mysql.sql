
INSERT INTO dailytech.roles (id, name)
VALUES
    (1, 'ROLE_ADMIN'),
    (2, 'ROLE_USER');

-- USERS: 5 entries
INSERT INTO dailytech.users (
    userid, username, password, lastname, firstname,
    usertype, email, organizationcode, cusurl,
    dashboardcode, isactive, contacttype
)
VALUES
    (101, 'tomAdmin', 'pass123', 'Smith', 'TomA', 0, 'tom.admin@example.com', 'ORG-A', 'https://example.com/tomA', 'DASH-A', 1, 111),
    (102, 'janeUser', 'pass234', 'Doe', 'Jane', 1, 'jane.user@example.com', 'ORG-B', 'https://example.com/jane', 'DASH-B', 1, 222),
    (103, 'bobUser', 'pass345', 'Brown', 'Bob', 2, 'bob.user@example.com', 'ORG-C', 'https://example.com/bob', 'DASH-C', 0, 333),
    (104, 'aliceUser', 'pass456', 'Johnson', 'Alice', 3, 'alice.user@example.com', 'ORG-D', 'https://example.com/alice', 'DASH-D', 1, 444),
    (105, 'thomasMaestas', 'pass567', 'Maestas', 'ThomasM', 3, 'thomas.maestas@example.com', 'ORG-E', 'https://example.com/thomasM', 'DASH-E', 0, 555);

-- USERS_ROLES: 5 entries
INSERT INTO dailytech.users_roles (role_id, user_id)
VALUES
    (1, 101),  -- tomAdmin => ROLE_ADMIN
    (2, 102),  -- janeUser => ROLE_USER
    (2, 103),  -- bobUser => ROLE_USER
    (2, 104),  -- aliceUser => ROLE_USER
    (1, 105);  -- thomasMaestas => ROLE_ADMIN
-- USERS_ROLES: 5 entries

-- CATEGORIES: 5 entries
INSERT INTO dailytech.categories (id, name, description)
VALUES
    (10, 'A.I.Now.', 'AI Technology news'),
    (11, 'Web Dev Affairs', 'Web-Dev & Coding updates'),
    (12, 'Sociology Tomorrow!', 'Sociology Apps & updates'),
    (13, 'Quantum Data', 'Quantum news & tips'),
    (14, 'Musing Blockchain', ' Blockchain Cryptocurrency insights');

-- POST_ENTITY: 5 entries
INSERT INTO dailytech.post_entity (
    id, did, post_date, author, month_order, cat3, title,
    post, blogcite, email, state, word_count, duration_goal, category_id
)
VALUES
    (20, 'D1001', '2025-05-01', 'TomA', 'May', 'Blockchain', 'Ethereum Merge',
     'Discussion on Ethereum merge details...', 'https://blogsite1.com', 'tom.admin@example.com',
     'Published', 1500, 10, 14),  -- references categories.id=14 (Crypto)

    (21, 'D1002', '2025-05-02', 'Jane', 'May', 'Wellness', 'Nutrition Tips',
     'Top 10 tips for daily health...', 'https://blogsite2.com', 'jane.user@example.com',
     'Draft', 800, 5, 11),        -- references categories.id=11 (Health)

    (22, 'D1003', '2025-05-03', 'Bob', 'June', 'Sports', 'Championship Recap',
     'Recap of the championship match...', 'https://blogsite3.com', 'bob.user@example.com',
     'Published', 1200, 7, 12),   -- references categories.id=12 (Sports)

    (23, 'D1004', '2025-05-04', 'Alice', 'June', 'Tech', 'AI Breakthrough',
     'New AI breakthrough discovered...', 'https://blogsite4.com', 'alice.user@example.com',
     'Published', 1600, 8, 10),   -- references categories.id=10 (Tech)

    (24, 'D1005', '2025-05-05', 'ThomasM', 'July', 'Finance', 'Stock Market Trends',
     'Analyzing latest stock market trends...', 'https://blogsite5.com', 'thomas.maestas@example.com',
     'Published', 2000, 14, 13);  -- references categories.id=13 (Finance)

-- COMMENTS: 5 entries
INSERT INTO dailytech.comments (
    id, name, email, body, post_id
)
VALUES
    (30, 'Sam Reader', 'sam@example.com', 'Great insights, thanks for sharing!', 20),  -- references post_entity.id=20
    (31, 'HealthGuru', 'guru@example.com', 'Loved the tips!', 21),                     -- references post_entity.id=21
    (32, 'SportFanatic', 'fan@example.com', 'Fantastic recap! Keep it up.', 22),       -- references post_entity.id=22
    (33, 'TechLover', 'techie@example.com', 'Excited about AI updates!', 23),          -- references post_entity.id=23
    (34, 'InvestorJoe', 'joe@example.com', 'Any more stock tips?', 24);                -- references post_entity.id=24

-- NEWS: 5 entries
INSERT INTO dailytech.news (
    id, title, url, category_id
)
VALUES
    (40, 'Crypto Market Surges', 'https://news1.com', 14),  -- references categories.id=14 (Crypto)
    (41, 'Health App Innovations', 'https://news2.com', 11), -- references categories.id=11 (Health)
    (42, 'Tech Giant Merges', 'https://news3.com', 10),      -- references categories.id=10 (Tech)
    (43, 'Local Team Wins', 'https://news4.com', 12),        -- references categories.id=12 (Sports)
    (44, 'Finance Reforms', 'https://news5.com', 13);        -- references categories.id=13 (Finance)

