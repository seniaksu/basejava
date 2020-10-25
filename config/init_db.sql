create table if not exists resume
(
    uuid      char(36) not null
        constraint resume_pk
            primary key,
    full_name text     not null
);

create table if not exists contact
(
    id          serial   not null
        constraint contact_pk
            primary key,
    resume_uuid char(36) not null
        constraint contact_resume_uuid_fk
            references resume
            on update restrict on delete cascade,
    type        text     not null,
    value       text     not null
);
create unique index if not exists contact_uuid_type_index
    on contact (resume_uuid, type);

insert into resume (uuid, full_name)
values ('uuid1', 'Name1'),
       ('uuid2', 'Name2'),
       ('uuid3', 'Name3'),
       ('uuid4', 'Name4');