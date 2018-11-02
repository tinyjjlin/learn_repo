create table user(
    u_id int unsigned not null auto_increment,
    u_name varchar(100) not null,
    u_pwd  varchar(50) not null,
    u_login_time  bigint,
    u_loginout_time bigint,
    primary key(u_id)
)engine=innodb default charset=utf8;


create table news(
n_id int unsigned not null auto_increment,
n_tile varchar(100) not null,
n_source varchar(50) null,
n_star tinyint,
n_detail_id int ,
constraint pk_news primary key(n_id)

)engine=innodb default charset=utf8;

enum('boy','girl','secret')

create table news_detail(
nd_id int unsigned not null auto_increment,
nd_content text not null,
constraint pk_news_detail primary key(nd_id)
)engine=innodb default  charset=utf8;

//add primary key
alter  table news add constraint fk_detail_id foreign key (n_detail_id) references news_detail(nd_id);

show columns from news;//显示表结构
//修改表列名称
alter table news change column n_t n_title varchar(100)
//修改列字段默认值
alter table news alter n_id set default 1;

alter table news modify column
insert into  news(n_title,n_source,n_star)
values("国足未进球","中国时报",1);

insert into news_detail(nd_content)values("国足真的没进球");

alter table news_detail add constraint FK_ID foreign key(nd_id) REFERENCES news(n_id);

alter table news_detail add constraint fk_id foregin key(nd_id)
    -> references news(n_id);

alter table news drop n_detail_id;