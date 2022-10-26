DROP TABLE IF EXISTS accounts CASCADE;
DROP TABLE IF EXISTS user_roles CASCADE;
DROP TABLE IF EXISTS assignments CASCADE;
DROP TABLE IF EXISTS study_fields CASCADE;
DROP TABLE IF EXISTS profiles CASCADE;
DROP TABLE IF EXISTS profiles_assignments CASCADE;

create table user_roles
(
    id        bigint auto_increment primary key,
    role_type varchar(10) not null
);

create table accounts
(
    id           bigint auto_increment primary key,
    dnie         varchar(10) not null unique,
    user_role_id integer     not null,
    first_name   varchar(50) not null,
    last_name    varchar(50) not null,
    is_log       boolean default false,
    constraint fk_account_user_role_id foreign key (user_role_id) references user_roles
);

create table study_fields
(
    id         bigint auto_increment primary key,
    study_type varchar(50) not null unique
);

create table assignments
(
    id          bigint auto_increment primary key,
    study_field integer     not null,
    subject     varchar(50) not null unique,
    credits     integer     not null,
    constraint fk_assignments_study_field foreign key (study_field) references study_fields
);

create table profiles
(
    id      bigint auto_increment primary key,
    account integer     not null,
    process varchar(50) not null,
    constraint fk_users_account_id foreign key (account) references accounts
);

create table profiles_assignments
(
    id             bigint auto_increment primary key,
    assignments_id integer not null,
    profile_id     integer not null,
    constraint fk_profiles_assignments_assignment_ids foreign key (assignments_id) references assignments,
    constraint fk_profiles_assignments_profile_id foreign key (profile_id) references profiles
);