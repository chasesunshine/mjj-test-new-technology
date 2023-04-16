sql:
    CREATE TABLE `redis_mysql_consistency` (
      `id` bigint(20) NOT NULL COMMENT '主键ID',
      `name` varchar(30) DEFAULT NULL COMMENT '姓名',
      `age` int(11) DEFAULT NULL COMMENT '年龄',
      `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
      PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;