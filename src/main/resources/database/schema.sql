DROP TABLE IF EXISTS accounts CASCADE;
DROP TABLE IF EXISTS user_roles CASCADE;
DROP TABLE IF EXISTS assignments CASCADE;
DROP TABLE IF EXISTS study_fields CASCADE;
DROP TABLE IF EXISTS teachers;
DROP TABLE IF EXISTS students;

create table user_roles
(
    id        bigint auto_increment primary key,
    role_type varchar(10) not null
);

create table accounts
(
    id           bigint auto_increment primary key,
    dnie         varchar(10) not null,
    user_role_id integer     not null,
    first_name   varchar(50) not null,
    last_name    varchar(50) not null,
    is_log        boolean default false,
    constraint fk_account_user_role_id foreign key (user_role_id) references user_roles
);

create table study_fields
(
    id         bigint auto_increment primary key,
    study_type varchar(50) not null
);

create table assignments
(
    id          bigint auto_increment primary key,
    study_field integer     not null,
    subject     varchar(50) not null,
    credit      integer     not null,
    constraint fk_assignments_study_field foreign key (study_field) references study_fields
);

create table teachers
(
    id            bigint auto_increment primary key,
    account_id    integer not null,
    assignment_id integer not null,
    constraint fk_teachers_account_id foreign key (account_id) references accounts,
    constraint fk_teachers_assignment_id foreign key (assignment_id) references assignments
);

create table students
(
    id            bigint auto_increment primary key,
    account_id    integer not null,
    assignment_id integer not null,
    constraint fk_students_account_id foreign key (account_id) references accounts,
    constraint fk_students_assignment_id foreign key (assignment_id) references assignments
);