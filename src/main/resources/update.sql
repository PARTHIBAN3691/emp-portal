
create user test with password 'admin';


create table employee(employee_id serial primary key, first_name varchar(50), last_name varchar(50), gender varchar(50), date_of_birth date, department varchar(50));


insert into employee(first_name,last_name,gender,date_of_birth,department) values('parthiban', 'ekambaram', 'male', '03/06/1991', 'development');

select * from employee;

alter table employee alter column date_of_birth set not null; 

GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public TO test;
