/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/11/23 11:02:36                          */
/*==============================================================*/


drop table if exists allmsg_cfg;

drop table if exists app;

drop table if exists bot_cfg;

drop table if exists business_user_ext;

drop table if exists channel;

drop table if exists company;

drop table if exists dept_app;

drop table if exists dispatch_cfg;

drop table if exists evaluate_cfg;

drop table if exists knowledge_answer;

drop table if exists knowledge_ask;

drop table if exists knowledge_menu;

drop table if exists limit_words_cfg;

drop table if exists msg_quality;

drop table if exists msg_remark;

drop table if exists offlinemsg_cfg;

drop table if exists offlinemsg_skill_cfg;

drop table if exists page_menu;

drop table if exists "quality _cfg";

drop table if exists satisfied;

drop table if exists satisfy_type;

drop table if exists skill_autoquery;

drop table if exists skill_group;

drop table if exists skill_group_user;

drop table if exists skill_mapping;

drop table if exists supplier_user_ext;

drop table if exists sys_config;

drop table if exists sys_dept;

drop table if exists sys_log;

drop table if exists sys_menu;

drop table if exists sys_role;

drop table if exists sys_role_dept;

drop table if exists sys_role_menu;

drop table if exists sys_user;

drop table if exists sys_user_role;

drop table if exists talk_cfg;

drop table if exists user_token;

drop table if exists white_list;

/*==============================================================*/
/* Table: allmsg_cfg                                            */
/*==============================================================*/
create table allmsg_cfg
(
   id                   int not null auto_increment,
   dept_id              int,
   "label"              varchar(50),
   url                  varchar(200),
   channel_id           int,
   create_time          datetime,
   update_time          datetime,
   del_flag             tinyint,
   primary key (id)
)
ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8 COMMENT='系统日志';

/*==============================================================*/
/* Table: app                                                   */
/*==============================================================*/
create table app
(
   app_id               int not null,
   cha_channel_id       int,
   channel_id           varchar(50),
   应用名称                 varchar(50),
   create_time          datetime,
   update_time          datetime,
   del_flag             tinyint,
   primary key (app_id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门管理';

/*==============================================================*/
/* Table: bot_cfg                                               */
/*==============================================================*/
create table bot_cfg
(
   id                   int not null auto_increment,
   start_speech         varchar(50),
   auto_reply           varchar(50),
   offline_reply        varchar(200),
   end_speech           varchar(5000),
   work_day             varchar(200),
   channel_id           int,
   create_time          datetime,
   update_time          datetime,
   primary key (id)
)
ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8 COMMENT='系统日志';

/*==============================================================*/
/* Table: business_user_ext                                     */
/*==============================================================*/
create table business_user_ext
(
   id                   int not null,
   shop_no              varchar(50),
   user_id              int,
   shop_name            varchar(100),
   dialog_name          varchar(100),
   start_status         int,
   cfg_count            int,
   create_time          datetime,
   update_time          datetime,
   primary key (id)
);

/*==============================================================*/
/* Table: channel                                               */
/*==============================================================*/
create table channel
(
   channel_id           int not null,
   companyId            int,
   channel_code         varchar(50),
   name                 varchar(50),
   create_time          datetime,
   update_time          datetime,
   del_flag             tinyint,
   primary key (channel_id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门管理';

/*==============================================================*/
/* Table: company                                               */
/*==============================================================*/
create table company
(
   id                   int not null auto_increment,
   name                 varchar(50),
   contact              varchar(100),
   address              varchar(100),
   create_time          datetime,
   update_time          datetime,
   del_flag             tinyint,
   primary key (id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门管理';

/*==============================================================*/
/* Table: dept_app                                              */
/*==============================================================*/
create table dept_app
(
   id                   int not null,
   app_id               int not null,
   dept_id              int,
   create_time          datetime,
   update_time          datetime,
   primary key (id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门管理';

/*==============================================================*/
/* Table: dispatch_cfg                                          */
/*==============================================================*/
create table dispatch_cfg
(
   id                   int not null auto_increment,
   "label"              varchar(50),
   channel_id           int,
   create_time          datetime,
   update_time          datetime,
   del_flag             tinyint,
   primary key (id)
)
ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8 COMMENT='系统日志';

/*==============================================================*/
/* Table: evaluate_cfg                                          */
/*==============================================================*/
create table evaluate_cfg
(
   id                   int not null auto_increment,
   "label"              varchar(50),
   type                 int comment '1:满意标签 2:不满意标签',
   channel_id           int,
   create_time          datetime,
   update_time          datetime,
   del_flag             tinyint,
   primary key (id)
)
ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8 COMMENT='系统日志';

/*==============================================================*/
/* Table: knowledge_answer                                      */
/*==============================================================*/
create table knowledge_answer
(
   ask_id               int not null,
   km_id                int not null,
   ask                  varchar(200),
   channel_id           int,
   create_time          datetime,
   update_time          datetime,
   del_flag             tinyint,
   primary key (ask_id, km_id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门管理';

/*==============================================================*/
/* Table: knowledge_ask                                         */
/*==============================================================*/
create table knowledge_ask
(
   ask_id               int not null,
   km_id                int not null,
   title                varchar(100),
   ask                  varchar(200),
   asktype              int,
   channel_id           int,
   create_time          datetime,
   update_time          datetime,
   del_flag             tinyint,
   primary key (ask_id, km_id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门管理';

/*==============================================================*/
/* Table: knowledge_menu                                        */
/*==============================================================*/
create table knowledge_menu
(
   km_id                int not null auto_increment,
   parent_id            int,
   name                 varchar(50),
   order_num            int,
   del_flag             tinyint default 0,
   channel_id           int,
   level                int,
   create_time          datetime,
   update_time          datetime,
   primary key (km_id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门管理';

/*==============================================================*/
/* Table: limit_words_cfg                                       */
/*==============================================================*/
create table limit_words_cfg
(
   id                   int,
   is_start             int,
   prompt               varchar(100),
   words                text,
   create_time          datetime,
   update_time          datetime
);

/*==============================================================*/
/* Table: msg_quality                                           */
/*==============================================================*/
create table msg_quality
(
   msg_id               int,
   result               int,
   user_id              int,
   update_time          datetime,
   create_time          datetime
);

/*==============================================================*/
/* Table: msg_remark                                            */
/*==============================================================*/
create table msg_remark
(
   msg_id               int,
   user_id              int,
   访客id                 int,
   remark               varchar(200),
   update_time          datetime,
   create_time          datetime
);

/*==============================================================*/
/* Table: offlinemsg_cfg                                        */
/*==============================================================*/
create table offlinemsg_cfg
(
   id                   int not null auto_increment,
   handle_time          varchar(50),
   type                 varchar(200),
   channel_id           int,
   create_time          datetime,
   update_time          datetime,
   del_flag             tinyint,
   primary key (id)
)
ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8 COMMENT='系统日志';

/*==============================================================*/
/* Table: offlinemsg_skill_cfg                                  */
/*==============================================================*/
create table offlinemsg_skill_cfg
(
   id                   int not null auto_increment,
   offline_id           int,
   skill_id             int,
   channel_id           int,
   create_time          datetime,
   update_time          datetime,
   del_flag             tinyint,
   primary key (id)
)
ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8 COMMENT='系统日志';

/*==============================================================*/
/* Table: page_menu                                             */
/*==============================================================*/
create table page_menu
(
   menu_id              int not null,
   页面菜单名称               varchar(50),
   channel_id           int,
   create_time          datetime,
   update_time          datetime,
   del_flag             tiny,
   primary key (menu_id)
);

/*==============================================================*/
/* Table: "quality _cfg"                                        */
/*==============================================================*/
create table "quality _cfg"
(
   id                   int not null auto_increment,
   "label"              varchar(50),
   channel_id           int,
   create_time          datetime,
   update_time          datetime,
   del_flag             tinyint,
   primary key (id)
)
ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8 COMMENT='系统日志';

/*==============================================================*/
/* Table: satisfied                                             */
/*==============================================================*/
create table satisfied
(
   id                   int,
   type_id              int,
   name                 varchar(100),
   score                int,
   create_time          datetime,
   update_time          datetime
);

/*==============================================================*/
/* Table: satisfy_type                                          */
/*==============================================================*/
create table satisfy_type
(
   id                   int,
   type_name            varchar(50),
   创建时间                 datetime,
   更新时间                 datetime
);

/*==============================================================*/
/* Table: skill_autoquery                                       */
/*==============================================================*/
create table skill_autoquery
(
   id                   int not null,
   name                 varchar(100) not null,
   url                  varchar(100),
   channel_id           int,
   create_time          datetime,
   update_time          datetime,
   del_flag             tinyint,
   primary key (id, name)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门管理';

/*==============================================================*/
/* Table: skill_group                                           */
/*==============================================================*/
create table skill_group
(
   skill_id             int not null,
   name                 varchar(100),
   app_id               int,
   create_time          datetime,
   update_time          datetime,
   del_flag             tinyint,
   primary key (skill_id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门管理';

/*==============================================================*/
/* Table: skill_group_user                                      */
/*==============================================================*/
create table skill_group_user
(
   id                   int not null,
   skill_id             int not null,
   user_id              int not null,
   create_time          datetime,
   update_time          datetime,
   primary key (id, skill_id, user_id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门管理';

/*==============================================================*/
/* Table: skill_mapping                                         */
/*==============================================================*/
create table skill_mapping
(
   id                   int not null,
   skill_id             int,
   menu_id              int,
   create_time          datetime,
   update_time          datetime,
   primary key (id)
);

/*==============================================================*/
/* Table: supplier_user_ext                                     */
/*==============================================================*/
create table supplier_user_ext
(
   id                   int,
   supplier_code        varchar(50),
   user_id              int,
   dialog_name          varchar(100),
   online_status        int,
   first_cat            varchar(50),
   second_cat           varchar(50),
   three_cat            varchar(50),
   brand_id             varchar(50),
   province_code        varchar(50),
   city_code            varchar(50),
   area_code            varchar(50),
   create_time          datetime,
   update_time          datetime
);

/*==============================================================*/
/* Table: sys_config                                            */
/*==============================================================*/
create table sys_config
(
   id                   int not null auto_increment,
   key                  varchar(50),
   value                varchar(2000),
   status               tinyint default 1,
   remark               varchar(500),
   channel_id           int,
   create_time          datetime,
   update_time          datetime,
   del_flag             tinyint,
   primary key (id),
   unique key AK_Key_2 (key)
)
ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8 COMMENT='系统配置信息表';

alter table sys_config comment '默认头像';

/*==============================================================*/
/* Table: sys_dept                                              */
/*==============================================================*/
create table sys_dept
(
   dept_id              int not null auto_increment,
   channel_id           int,
   parent_id            int,
   name                 varchar(50),
   order_num            int,
   del_flag             tinyint default 0,
   level                int,
   path                 varchar(100),
   create_time          datetime,
   update_time          datetime,
   primary key (dept_id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门管理';

/*==============================================================*/
/* Table: sys_log                                               */
/*==============================================================*/
create table sys_log
(
   id                   int not null auto_increment,
   user_id              varchar(50),
   operation            varchar(50),
   method               varchar(200),
   params               varchar(5000),
   time                 bigint not null,
   ip                   varchar(64),
   channel_id           int,
   create_time          datetime,
   update_time          datetime,
   primary key (id)
)
ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8 COMMENT='系统日志';

/*==============================================================*/
/* Table: sys_menu                                              */
/*==============================================================*/
create table sys_menu
(
   menu_id              int not null auto_increment,
   parent_id            int,
   name                 varchar(50),
   url                  varchar(200),
   perms                varchar(500),
   type                 int,
   icon                 varchar(50),
   order_num            int,
   channel_id           int,
   create_time          datetime,
   update_time          datetime,
   del_flag             tinyint,
   primary key (menu_id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单管理';

/*==============================================================*/
/* Table: sys_role                                              */
/*==============================================================*/
create table sys_role
(
   role_id              int not null auto_increment,
   role_name            varchar(100),
   remark               varchar(100),
   dept_id              int,
   channel_id           int,
   create_time          datetime,
   update_time          datetime,
   del_flag             tinyint,
   primary key (role_id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色';

/*==============================================================*/
/* Table: sys_role_dept                                         */
/*==============================================================*/
create table sys_role_dept
(
   id                   int not null auto_increment,
   role_id              int,
   dept_id              int,
   create_time          datetime,
   update_time          datetime,
   primary key (id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色与部门对应关系';

/*==============================================================*/
/* Table: sys_role_menu                                         */
/*==============================================================*/
create table sys_role_menu
(
   id                   int not null auto_increment,
   role_id              int,
   menu_id              int,
   create_time          datetime,
   update_time          datetime,
   primary key (id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';

/*==============================================================*/
/* Table: sys_user                                              */
/*==============================================================*/
create table sys_user
(
   user_id              int not null auto_increment,
   username             varchar(50) not null,
   password             varchar(100),
   salt                 varchar(20),
   email                varchar(100),
   mobile               varchar(100),
   status               tinyint,
   dept_id              int,
   channel_id           int,
   service_limit        int,
   default_state        int,
   nickname             varchar(50),
   usericon             varchar(200),
   employeeId           varchar(50),
   usertype             int comment '1:自营 2:商家 3;供应商',
   create_time          datetime,
   update_time          datetime,
   remark               varchar(100),
   del_flag             tinyint,
   primary key (user_id),
   unique key AK_Key_2 (username)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户';

alter table sys_user comment '使用客服服务端回答访客问题的人';

/*==============================================================*/
/* Table: sys_user_role                                         */
/*==============================================================*/
create table sys_user_role
(
   id                   int not null auto_increment,
   user_id              int,
   role_id              int,
   create_time          datetime,
   update_time          datetime,
   primary key (id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系';

/*==============================================================*/
/* Table: talk_cfg                                              */
/*==============================================================*/
create table talk_cfg
(
   id                   int not null auto_increment,
   "label"              varchar(50),
   channel_id           int,
   create_time          datetime,
   update_time          datetime,
   del_flag             tinyint,
   primary key (id)
)
ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8 COMMENT='系统日志';

/*==============================================================*/
/* Table: user_token                                            */
/*==============================================================*/
create table user_token
(
   user_id              int,
   token                varchar(100),
   channel_id           int,
   expire_time          datetime,
   update_time          datetime,
   create_time          datetime
);

/*==============================================================*/
/* Table: white_list                                            */
/*==============================================================*/
create table white_list
(
   id                   int,
   url                  varchar(200),
   create_time          datetime,
   update_time          datetime
);

