# sql:
    CREATE TABLE `spring_world` (
      `id` bigint(20) NOT NULL AUTO_INCREMENT,
      `age` int(5) DEFAULT NULL,
      `name` varchar(3) DEFAULT NULL,
      `sex` varchar(255) DEFAULT NULL,
      PRIMARY KEY (`id`) USING BTREE
    ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;
    