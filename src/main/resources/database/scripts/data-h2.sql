    insert into USER_ROLES (ROLE_TYPE)
    VALUES ('ADMIN');
    insert into USER_ROLES (ROLE_TYPE)
    VALUES ('TEACHERS');
    insert into USER_ROLES (ROLE_TYPE)
    VALUES ('STUDENTS');


    insert into STUDY_FIELDS (STUDY_TYPE)
    VALUES ('HUMANITIES');
    insert into STUDY_FIELDS (STUDY_TYPE)
    VALUES ('SCIENCE');

    insert into ASSIGNMENTS (STUDY_FIELD, SUBJECT, CREDITS)
    VALUES (1, 'German', 5);
    insert into ASSIGNMENTS (STUDY_FIELD, SUBJECT, CREDITS)
    VALUES (1, 'Philosophy', 8);
    insert into ASSIGNMENTS (STUDY_FIELD, SUBJECT, CREDITS)
    VALUES (1, 'English', 4);
    insert into ASSIGNMENTS (STUDY_FIELD, SUBJECT, CREDITS)
    VALUES (1, 'French', 5);
    insert into ASSIGNMENTS (STUDY_FIELD, SUBJECT, CREDITS)
    VALUES (1, 'Spanish', 6);
    insert into ASSIGNMENTS (STUDY_FIELD, SUBJECT, CREDITS)
    VALUES (1, 'Mythology', 6);


    insert into ASSIGNMENTS (STUDY_FIELD, SUBJECT, CREDITS)
    VALUES (2, 'Mathematics', 5);
    insert into ASSIGNMENTS (STUDY_FIELD, SUBJECT, CREDITS)
    VALUES (2, 'Comp. Science', 8);
    insert into ASSIGNMENTS (STUDY_FIELD, SUBJECT, CREDITS)
    VALUES (2, 'Chemistry', 4);
    insert into ASSIGNMENTS (STUDY_FIELD, SUBJECT, CREDITS)
    VALUES (2, 'Physics', 5);
    insert into ASSIGNMENTS (STUDY_FIELD, SUBJECT, CREDITS)
    VALUES (2, 'Biology', 6);
    insert into ASSIGNMENTS (STUDY_FIELD, SUBJECT, CREDITS)
    VALUES (2, 'Electronics', 7);

    insert into ACCOUNTS (DNIE, USER_ROLE_ID, FIRST_NAME, LAST_NAME)
    values ('MPadp666-C', 1, 'MP', 'MP');
