create table (
    id bigserial not null,
    nick varchar(36),
    person varchar(128),
    description varchar(128),
    history text
    primary key (id)
)

alter table avenger add constraint UK_2173n1273n1927n39 unique (nick)