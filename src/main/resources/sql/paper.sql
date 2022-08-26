create table paper
(
    id          bigint auto_increment,
    title       varchar(100) not null,
    sub_title    varchar(100) not null,
    image_url   varchar(500) null,
    publish_date datetime     not null,
    create_by   varchar(10)  null,
    create_date datetime     not null,
    update_by   varchar(10)  not null,
    update_date datetime     not null,
    constraint paper_pk
        primary key (id)
);
