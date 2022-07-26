
create table users(
	username varchar(50) not null primary key,
	password varchar(100) not null,
	enabled boolean not null
	);
insert into users values('dan', 'pickles', true); 


create table authorities (
		username varchar(50) not null,
		authority varchar(50) not null,
		constraint fk_authorities_users foreign key(username) references users(username)
	);
create unique index ix_auth_username on authorities (username,authority);
insert into authorities values('Jack', 'ROLE_USER');
insert into authorities values('Jill', 'ROLE_ADMIN');username on authorities (username,authority);