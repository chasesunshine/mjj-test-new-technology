# sql:
    CREATE TABLE `redis_mysql_consistency` (
      `id` bigint(20) NOT NULL COMMENT '主键ID',
      `name` varchar(30) DEFAULT NULL COMMENT '姓名',
      `age` int(11) DEFAULT NULL COMMENT '年龄',
      `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
      PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;
    
# 通过Java监听MySQL数据的变化
    https://devpress.csdn.net/devcloud/63be5c3080b9983378cda6b8.html?spm=1001.2101.3001.6650.16&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7Eactivity-16-127490460-blog-119148470.235%5Ev29%5Epc_relevant_default_base&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7Eactivity-16-127490460-blog-119148470.235%5Ev29%5Epc_relevant_default_base&utm_relevant_index=17
    