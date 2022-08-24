CREATE TABLE `test_user1` (
                              `id` bigint(20) NOT NULL AUTO_INCREMENT,
                              `age` int(11) DEFAULT NULL,
                              `name` varchar(255) DEFAULT NULL,
                              `sex` varchar(255) DEFAULT NULL,
                              PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;

CREATE TABLE `test_user2` (
                              `id` bigint(20) NOT NULL AUTO_INCREMENT,
                              `age` int(11) DEFAULT NULL,
                              `name` varchar(255) DEFAULT NULL,
                              `sex` varchar(255) DEFAULT NULL,
                              PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;