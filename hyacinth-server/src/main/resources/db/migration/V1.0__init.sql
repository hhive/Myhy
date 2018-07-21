-- Table: t_user
CREATE TABLE t_user (
  id            BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  code          VARCHAR(255),
  loginName     VARCHAR(255),
  name          VARCHAR(255),
  salt          VARCHAR(255),
  password      VARCHAR(255),
  email         VARCHAR(255)
);

-- Table: t_role
CREATE TABLE t_role
(
  id          BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  code        VARCHAR(255),
  description VARCHAR(255)
);

-- Table: rt_user_role
CREATE TABLE rt_user_role
(
  user_id BIGINT NOT NULL,
  role_id BIGINT NOT NULL,
  PRIMARY KEY (user_id, role_id)
);


CREATE TABLE t_staff (
  id            BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  code     VARCHAR (255),
  name          VARCHAR(255),
  position     VARCHAR(255),
  department   VARCHAR (255),
  phone         VARCHAR(255),
  email         VARCHAR(255),
  emdate         VARCHAR (255)
);

CREATE TABLE t_salary(
 id            BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  code			 	 	         VARCHAR(255) ,
  name				            VARCHAR(255),
  basic_salary	 	         float,
  overtime_wage 	       float,
  post_allowance	       float,
  performance_allowance  float,
  total_contract_wages   float,
  seniority_allowance    float,
  meal_allowance      float ,
  other_allowance		     float,
  other_pre_tax_buckle   float,
  total_payroll		 	     float,
  real_basic_salary			     float,
  real_overtime_allowance			float,
  real_post_allowance     float ,
  real_performance_allwoance float ,
  sick_pay            float ,
  gross_pay           float ,
  social_security    float ,
  housing_fund       float ,
  income_tax         float ,
  hotel_expense     float ,
  water_electricity  float ,
  mutual_fund        float ,
  telephone_fare    float ,
  networ_fee        float ,
  deductions_after_tax   float ,
  real_salary      float ,
  real_allwoance  float,
  total            float
);
CREATE TABLE t_log(
  id        BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  opera_time   DATE ,
  opera_name    VARCHAR(255),
  description   VARCHAR(255)
);

INSERT INTO t_role (id, code, description) VALUES (1, 'admin', 'Administrator');
INSERT INTO t_role (id, code, description) VALUES (2, 'user', 'User');

INSERT INTO rt_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO rt_user_role (user_id, role_id) VALUES (2, 2);


CREATE TABLE t_permission(
  id INT PRIMARY KEY NOT NULL,
  available BOOL default false,
  name VARCHAR (255),
  parent_id BIGINT,
  parent_ids VARCHAR(255),
  permission VARCHAR(255),
  resource_type VARCHAR(255),
  url VARCHAR(255)
);


CREATE TABLE rt_role_permission(
  role_id BIGINT NOT NULL,
  permission_id BIGINT NOT NULL,
  PRIMARY KEY (role_id,permission_id)
);

INSERT INTO t_permission (id,available,name,parent_id,parent_ids,permission,resource_type,url) VALUES (1,0,'用户权限',0,'0/','userInfo:view','menu','user/list');
INSERT INTO t_permission (id,available,name,parent_id,parent_ids,permission,resource_type,url) VALUES (2,0,'用户添加',1,'0/1','userInfo:add','button','views/privilege');
INSERT INTO t_permission (id,available,name,parent_id,parent_ids,permission,resource_type,url) VALUES (3,0,'用户删除',1,'0/1','userInfo:del','button','user/list');

INSERT INTO rt_role_permission (role_id,permission_id) VALUES (1,1);
INSERT INTO rt_role_permission (role_id,permission_id) VALUES (1,2);
INSERT INTO rt_role_permission (role_id,permission_id) VALUES (1,3);

INSERT INTO t_user (id, loginName, name, salt, password, email) VALUES (1, 'admin', 'Administrator', '', '3980e4044675f6339248ee0c735c7d72', 'admin@admin.com');
INSERT INTO t_user (id, loginName, name, salt, password, email) VALUES (2, 'user', 'User', '', '3980e4044675f6339248ee0c735c7d72', 'user@user.com');
INSERT INTO t_user (id, loginName, name, salt, password, email) VALUES (3, 'user1', 'User', '', '3980e4044675f6339248ee0c735c7d72', 'user1@user.com');
INSERT INTO t_user (id, loginName, name, salt, password, email) VALUES (4, 'user2', 'User', '', '3980e4044675f6339248ee0c735c7d72', 'user2@user.com');
INSERT INTO t_user (id, loginName, name, salt, password, email) VALUES (5, 'user3', 'User', '', '3980e4044675f6339248ee0c735c7d72', 'user3@user.com');