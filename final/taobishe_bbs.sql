/*
 Navicat MySQL Data Transfer

 Source Server         : test
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : taobishe_bbs

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 05/07/2020 19:56:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bbs_like
-- ----------------------------
DROP TABLE IF EXISTS `bbs_like`;
CREATE TABLE `bbs_like`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `member_id` int(11) NULL DEFAULT NULL COMMENT '会员id',
  `topic_id` int(11) NULL DEFAULT NULL COMMENT '帖子id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '点赞' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bbs_like
-- ----------------------------
INSERT INTO `bbs_like` VALUES (26, 7, 38, '2020-07-05 19:34:47');

-- ----------------------------
-- Table structure for bbs_reply
-- ----------------------------
DROP TABLE IF EXISTS `bbs_reply`;
CREATE TABLE `bbs_reply`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '内容',
  `member_id` int(11) NULL DEFAULT NULL COMMENT '会员id',
  `topic_id` int(11) NULL DEFAULT NULL COMMENT '主贴id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '跟帖' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bbs_reply
-- ----------------------------
INSERT INTO `bbs_reply` VALUES (2, '很棒', 7, 32, '2020-06-29 10:25:36');
INSERT INTO `bbs_reply` VALUES (4, '不错', 7, 34, '2020-07-02 20:06:58');
INSERT INTO `bbs_reply` VALUES (5, '+1', 7, 32, '2020-07-05 14:59:01');
INSERT INTO `bbs_reply` VALUES (6, '+1', 7, 37, '2020-07-05 18:35:58');
INSERT INTO `bbs_reply` VALUES (7, '+1', 7, 38, '2020-07-05 19:34:45');

-- ----------------------------
-- Table structure for bbs_topic
-- ----------------------------
DROP TABLE IF EXISTS `bbs_topic`;
CREATE TABLE `bbs_topic`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '话题',
  `member_id` int(11) NULL DEFAULT NULL COMMENT '会员id',
  `status` tinyint(2) NULL DEFAULT NULL COMMENT '状态',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '主贴' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bbs_topic
-- ----------------------------
INSERT INTO `bbs_topic` VALUES (32, '材料：\n\n肉丝 1 把，白菜 1 片，较小洋葱 1 个，水发木耳 2 大朵，红尖椒半个，姜丝 1 小撮，葱段适量。\n\n调料：\n\n淀粉 1 汤勺，盐、料酒、味精、生抽适量，香油 1 小勺。\n\n1、肉丝、淀粉、一点点料酒混合抓匀。白菜洗净、擦干，裁去叶留帮，切成5厘米长的段，顺菜筋改', 7, NULL, '2020-06-29 10:24:06');
INSERT INTO `bbs_topic` VALUES (37, '上次做了豆腐汤，里面加了干贝和虾仁，所以味道很鲜美，随时都可以做，低脂高蛋白又营养!  这道菜我和儿子都很喜欢，减肥的我晚上也喝了几碗。用料：鸡蛋1个，嫩豆腐半块，海鲜菇半盒，盐2克，蚝油1勺，生抽1勺，蒜2瓣，葱花2克', 7, NULL, '2020-07-05 16:09:39');
INSERT INTO `bbs_topic` VALUES (38, '上次做了豆腐汤，里面加了干贝和虾仁，所以味道很鲜美，随时都可以做，低脂高蛋白又营养!  这道菜我和儿子都很喜欢，减肥的我晚上也喝了几碗。用料：鸡蛋1个，嫩豆腐半块，海鲜菇半盒，盐2克，蚝油1勺，生抽1勺，蒜2瓣，葱花2克', 7, NULL, '2020-07-05 19:34:30');

-- ----------------------------
-- Table structure for bbs_topic_pic
-- ----------------------------
DROP TABLE IF EXISTS `bbs_topic_pic`;
CREATE TABLE `bbs_topic_pic`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `topic_id` int(11) NULL DEFAULT NULL,
  `pic_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 50 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '主贴图片' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bbs_topic_pic
-- ----------------------------
INSERT INTO `bbs_topic_pic` VALUES (43, 32, 'http://localhost:10003/fileupload/20200629/b0ad79b7-3ad4-43b6-bdfa-a06edaac3c99.jpg');
INSERT INTO `bbs_topic_pic` VALUES (45, 34, 'http://localhost:10003/fileupload/20200702/2eabf48f-8f33-4361-ac8f-f89a788f3c0d.JPG');
INSERT INTO `bbs_topic_pic` VALUES (46, 35, 'http://localhost:10003/fileupload/20200705/05118469-c7e7-4c2b-93da-f03137173c35.jpg');
INSERT INTO `bbs_topic_pic` VALUES (47, 36, 'http://localhost:10003/fileupload/20200705/05118469-c7e7-4c2b-93da-f03137173c35.jpg');
INSERT INTO `bbs_topic_pic` VALUES (48, 37, 'http://localhost:10003/fileupload/20200705/1d2b2249-fc62-45e1-8e86-c38c21bdaf54.jpg');
INSERT INTO `bbs_topic_pic` VALUES (49, 38, 'http://localhost:10003/fileupload/20200705/7d8b4feb-7700-492f-ac52-38daa8b01651.jpg');

-- ----------------------------
-- Table structure for o2o_user
-- ----------------------------
DROP TABLE IF EXISTS `o2o_user`;
CREATE TABLE `o2o_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `openid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信openid',
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `avatar_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `gender` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `real_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `mobile` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `user_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `school_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '会员' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of o2o_user
-- ----------------------------
INSERT INTO `o2o_user` VALUES (7, 'orTCY5NwMFtXpXozAU4YkZYgTtbg', '夏宇宁 Jason', 'https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJial9nA7jAav34nApDuY6oSKibPayYkAchslicOV7u4C1xkuW5iazePnEV70jszRfh7kaDvPwKGFWcFQ/132', '1', 'Jason', '13919127469', '同济大学', '上海市杨浦区', '2020-06-29 10:21:13');

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户操作',
  `method` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求参数',
  `ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'IP地址',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 84 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES (73, 'admin', '修改菜单', 'com.wfuhui.modules.sys.controller.SysMenuController.update()', '{\"menuId\":82,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"统计分析\",\"url\":\"\",\"type\":0,\"icon\":\"fa fa-home\",\"orderNum\":0}', '0:0:0:0:0:0:0:1', '2019-12-28 16:28:56');
INSERT INTO `sys_log` VALUES (74, 'admin', '保存菜单', 'com.wfuhui.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"概况统计\",\"url\":\"index.html\",\"type\":1,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '2019-12-28 16:29:19');
INSERT INTO `sys_log` VALUES (75, 'admin', '修改菜单', 'com.wfuhui.modules.sys.controller.SysMenuController.update()', '{\"menuId\":96,\"parentId\":82,\"parentName\":\"统计分析\",\"name\":\"概况统计\",\"url\":\"index.html\",\"type\":1,\"orderNum\":0}', '0:0:0:0:0:0:0:1', '2019-12-28 16:29:27');
INSERT INTO `sys_log` VALUES (76, 'admin', '修改密码', 'com.wfuhui.modules.sys.controller.SysUserController.password()', '\"\"', '127.0.0.1', '2020-01-01 23:28:53');
INSERT INTO `sys_log` VALUES (77, 'admin', '修改密码', 'com.wfuhui.modules.sys.controller.SysUserController.password()', '\"\"', '127.0.0.1', '2020-01-31 22:40:26');
INSERT INTO `sys_log` VALUES (78, 'admin', '修改密码', 'com.wfuhui.modules.sys.controller.SysUserController.password()', '\"\"', '127.0.0.1', '2020-01-31 22:40:29');
INSERT INTO `sys_log` VALUES (79, 'admin', '保存菜单', 'com.wfuhui.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"圈子管理\",\"type\":0,\"icon\":\"fa fa-star\",\"orderNum\":30}', '0:0:0:0:0:0:0:1', '2020-03-12 08:04:38');
INSERT INTO `sys_log` VALUES (80, 'admin', '修改菜单', 'com.wfuhui.modules.sys.controller.SysMenuController.update()', '{\"menuId\":107,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"圈子管理\",\"type\":0,\"icon\":\"fa fa-star\",\"orderNum\":4}', '0:0:0:0:0:0:0:1', '2020-03-12 08:04:53');
INSERT INTO `sys_log` VALUES (81, 'admin', '修改菜单', 'com.wfuhui.modules.sys.controller.SysMenuController.update()', '{\"menuId\":97,\"parentId\":107,\"parentName\":\"圈子管理\",\"name\":\"贴子管理\",\"url\":\"modules/topic/topic.html\",\"type\":1,\"icon\":\"fa fa-file-code-o\",\"orderNum\":6}', '0:0:0:0:0:0:0:1', '2020-03-12 08:05:08');
INSERT INTO `sys_log` VALUES (82, 'admin', '修改菜单', 'com.wfuhui.modules.sys.controller.SysMenuController.update()', '{\"menuId\":102,\"parentId\":107,\"parentName\":\"圈子管理\",\"name\":\"回复管理\",\"url\":\"modules/topic/reply.html\",\"type\":1,\"icon\":\"fa fa-file-code-o\",\"orderNum\":6}', '0:0:0:0:0:0:0:1', '2020-03-12 08:05:19');
INSERT INTO `sys_log` VALUES (83, 'admin', '修改密码', 'com.wfuhui.modules.sys.controller.SysUserController.password()', '\"\"', '127.0.0.1', '2020-04-10 13:01:17');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int(11) NULL DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) NULL DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 108 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, 0, '系统管理', NULL, NULL, 0, 'fa fa-cog', 7);
INSERT INTO `sys_menu` VALUES (2, 1, '管理员列表', '/modules/sys/user.html', NULL, 1, 'fa fa-user', 1);
INSERT INTO `sys_menu` VALUES (3, 1, '角色管理', '/modules/sys/role.html', NULL, 1, 'fa fa-user-secret', 2);
INSERT INTO `sys_menu` VALUES (4, 1, '菜单管理', '/modules/sys/menu.html', NULL, 1, 'fa fa-th-list', 3);
INSERT INTO `sys_menu` VALUES (15, 2, '查看', NULL, 'sys:user:list,sys:user:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (16, 2, '新增', NULL, 'sys:user:save,sys:role:select', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (17, 2, '修改', NULL, 'sys:user:update,sys:role:select', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (18, 2, '删除', NULL, 'sys:user:delete', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (19, 3, '查看', NULL, 'sys:role:list,sys:role:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (20, 3, '新增', NULL, 'sys:role:save,sys:menu:perms', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (21, 3, '修改', NULL, 'sys:role:update,sys:menu:perms', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (22, 3, '删除', NULL, 'sys:role:delete', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (23, 4, '查看', NULL, 'sys:menu:list,sys:menu:info', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (24, 4, '新增', NULL, 'sys:menu:save,sys:menu:select', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (25, 4, '修改', NULL, 'sys:menu:update,sys:menu:select', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (26, 4, '删除', NULL, 'sys:menu:delete', 2, NULL, 0);
INSERT INTO `sys_menu` VALUES (64, 0, '用户管理', NULL, NULL, 0, 'fa fa-user-o', 1);
INSERT INTO `sys_menu` VALUES (66, 64, '用户管理', '/modules/o2o/user.html', NULL, 1, NULL, 1);
INSERT INTO `sys_menu` VALUES (67, 66, '查看', NULL, 'user:list,user:info', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (68, 66, '新增', NULL, 'user:save', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (69, 66, '修改', NULL, 'user:update', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (70, 66, '删除', NULL, 'user:delete', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (82, 0, '统计分析', '', NULL, 0, 'fa fa-home', 0);
INSERT INTO `sys_menu` VALUES (88, 1, '字典管理', '/modules/sys/sysdict.html', NULL, 1, NULL, 6);
INSERT INTO `sys_menu` VALUES (89, 88, '查看', NULL, 'sys:dict:list,sys:dict:info', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (90, 88, '新增', NULL, 'sys:dict:save', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (91, 88, '修改', NULL, 'sys:dict:update', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (92, 88, '删除', NULL, 'sys:dict:delete', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (96, 82, '概况统计', '/index.html', NULL, 1, NULL, 0);
INSERT INTO `sys_menu` VALUES (97, 107, '贴子管理', '/modules/bbs/topic.html', NULL, 1, NULL, 6);
INSERT INTO `sys_menu` VALUES (98, 97, '查看', NULL, 'topic:list,topic:info', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (99, 97, '新增', NULL, 'topic:save', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (100, 97, '修改', NULL, 'topic:update', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (101, 97, '删除', NULL, 'topic:delete', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (102, 107, '回复管理', '/modules/bbs/reply.html', NULL, 1, NULL, 6);
INSERT INTO `sys_menu` VALUES (103, 102, '查看', NULL, 'reply:list,reply:info', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (104, 102, '新增', NULL, 'reply:save', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (105, 102, '修改', NULL, 'reply:update', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (106, 102, '删除', NULL, 'reply:delete', 2, NULL, 6);
INSERT INTO `sys_menu` VALUES (107, 0, '圈子管理', NULL, NULL, 0, 'fa fa-star', 4);

-- ----------------------------
-- Table structure for sys_oss
-- ----------------------------
DROP TABLE IF EXISTS `sys_oss`;
CREATE TABLE `sys_oss`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'URL地址',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '文件上传' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_oss
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '测试', '测试', 1, '2017-10-17 17:44:44');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NULL DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色与菜单对应关系' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (1, 1, 1);
INSERT INTO `sys_role_menu` VALUES (2, 1, 2);
INSERT INTO `sys_role_menu` VALUES (3, 1, 15);
INSERT INTO `sys_role_menu` VALUES (4, 1, 16);
INSERT INTO `sys_role_menu` VALUES (5, 1, 17);
INSERT INTO `sys_role_menu` VALUES (6, 1, 18);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `salt` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '盐',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `status` tinyint(4) NULL DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '9ec9750e709431dad22365cabc5c625482e574c74adaebba7dd02f1129e4ce1d', 'YzcmCZNvbXocrsz9dm8e', '2803180149@qq.com', '18021418906', 1, 1, '2016-11-11 11:11:11');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户与角色对应关系' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user_token
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_token`;
CREATE TABLE `sys_user_token`  (
  `user_id` bigint(20) NOT NULL,
  `token` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'token',
  `expire_time` datetime(0) NULL DEFAULT NULL COMMENT '过期时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `token`(`token`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统用户Token' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_token
-- ----------------------------
INSERT INTO `sys_user_token` VALUES (1, '6432f3391a382f51db6310e7eaa0067f', '2020-06-29 09:35:06', '2020-06-28 21:35:06');
INSERT INTO `sys_user_token` VALUES (2, '3cccdbe47631b6ef34495205408ab5b3', '2018-01-26 01:24:50', '2018-01-25 13:24:50');
INSERT INTO `sys_user_token` VALUES (3, 'edf6852056ad072c8b62aea1c2b106f0', '2018-01-26 04:50:46', '2018-01-25 16:50:46');

-- ----------------------------
-- Table structure for tb_token
-- ----------------------------
DROP TABLE IF EXISTS `tb_token`;
CREATE TABLE `tb_token`  (
  `user_id` bigint(20) NOT NULL,
  `token` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'token',
  `expire_time` datetime(0) NULL DEFAULT NULL COMMENT '过期时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `token`(`token`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户Token' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_token
-- ----------------------------
INSERT INTO `tb_token` VALUES (3, 'e77af301-7f1d-43c8-a8d5-3958d51aad8b', '2018-01-08 03:31:24', '2018-01-07 15:31:24');
INSERT INTO `tb_token` VALUES (4, '83c60a6e-feb0-48fb-865a-fcb2aee149e2', '2018-03-25 04:22:48', '2018-03-24 16:22:48');
INSERT INTO `tb_token` VALUES (5, 'c6ac14a7-8520-46c7-b5ac-427ee9374645', '2018-01-14 09:12:39', '2018-01-13 21:12:39');
INSERT INTO `tb_token` VALUES (6, '8296663a-c0da-48a9-a976-2f4a57410ed3', '2020-06-29 09:34:22', '2020-06-28 21:34:22');
INSERT INTO `tb_token` VALUES (7, '58ac42ec-d6c6-4525-ae22-714306da4309', '2020-07-06 07:50:01', '2020-07-05 19:50:01');
INSERT INTO `tb_token` VALUES (8, '9d277ff5-1d96-4c52-95e9-2c1a453b9cf1', '2018-01-19 03:37:14', '2018-01-18 15:37:14');
INSERT INTO `tb_token` VALUES (9, '27211f9c-d9b6-40c6-afa0-b54410860121', '2018-03-12 21:53:37', '2018-03-12 09:53:37');
INSERT INTO `tb_token` VALUES (10, 'b48d5f73-c06b-4618-ba41-ecc895633f96', '2018-01-19 05:20:07', '2018-01-18 17:20:07');
INSERT INTO `tb_token` VALUES (11, 'c91de7ff-c0e3-4c6e-9c95-6876619d54ae', '2018-01-19 12:02:59', '2018-01-19 00:02:59');
INSERT INTO `tb_token` VALUES (12, '9d9e22b0-a8db-44d2-82af-0bb651ed63d8', '2018-01-20 03:21:08', '2018-01-19 15:21:08');
INSERT INTO `tb_token` VALUES (13, 'e16ebe61-2b42-4bbb-a9b4-6ffc482bdb4a', '2018-03-08 03:09:22', '2018-03-07 15:09:22');
INSERT INTO `tb_token` VALUES (14, '83382553-9186-401f-8ffa-4887287b6750', '2018-01-21 09:23:24', '2018-01-20 21:23:24');
INSERT INTO `tb_token` VALUES (15, '2168d4e7-b9e6-4dba-9e3a-13080b33aeb2', '2018-01-24 11:29:33', '2018-01-23 23:29:33');
INSERT INTO `tb_token` VALUES (16, 'd79fa4dc-f268-4417-bd07-7dcf008b93f1', '2018-03-07 23:40:07', '2018-03-07 11:40:07');
INSERT INTO `tb_token` VALUES (17, 'a4c4a926-0e4c-4c1c-9568-95d772feed53', '2018-01-26 12:48:32', '2018-01-26 00:48:32');
INSERT INTO `tb_token` VALUES (18, 'fea668b3-f7b1-4034-8099-e549e15988bc', '2018-01-24 11:26:00', '2018-01-23 23:26:00');
INSERT INTO `tb_token` VALUES (19, 'ea3a28a5-768e-4083-8e7e-6bd0495bb33c', '2018-01-27 21:23:58', '2018-01-27 09:23:58');
INSERT INTO `tb_token` VALUES (20, 'db3bf66a-fe5b-4c37-8d80-a3d988f224d8', '2018-03-09 01:01:46', '2018-03-08 13:01:46');
INSERT INTO `tb_token` VALUES (21, '13695e93-4eb8-458b-874d-dfd62c0ac7a2', '2018-01-27 23:25:07', '2018-01-27 11:25:07');
INSERT INTO `tb_token` VALUES (22, '0f83c450-a66f-42c1-b644-bf32b2e5bea9', '2018-01-29 09:27:16', '2018-01-28 21:27:16');
INSERT INTO `tb_token` VALUES (23, 'ac38377f-649a-441c-bb3a-edf43c273303', '2018-01-30 05:26:30', '2018-01-29 17:26:30');
INSERT INTO `tb_token` VALUES (24, '1bb09bcb-704f-4dbe-864f-59fd08b6f44d', '2018-02-02 21:56:59', '2018-02-02 09:56:59');
INSERT INTO `tb_token` VALUES (25, 'b905b28d-2826-4b0f-9a5a-077f32a86691', '2018-02-09 02:57:49', '2018-02-08 14:57:49');
INSERT INTO `tb_token` VALUES (26, 'd41f5598-199d-43b5-820e-1be516277cdb', '2018-02-05 02:51:08', '2018-02-04 14:51:08');
INSERT INTO `tb_token` VALUES (27, 'e99b7cf4-04a5-4a80-9bda-a274e8868ed3', '2018-03-24 03:16:22', '2018-03-23 15:16:22');
INSERT INTO `tb_token` VALUES (28, '313e69f4-286c-4d96-91b4-270a2dbd6014', '2018-02-07 00:18:07', '2018-02-06 12:18:07');
INSERT INTO `tb_token` VALUES (29, '6b460c8a-f120-4870-bfed-3db905b5067a', '2018-02-07 08:19:14', '2018-02-06 20:19:14');
INSERT INTO `tb_token` VALUES (30, 'c352b3a4-b96e-4044-93e4-383ff911aa22', '2018-02-06 22:36:04', '2018-02-06 10:36:04');
INSERT INTO `tb_token` VALUES (31, '73a1d674-6e1a-423a-86e2-e44fe49f32e7', '2018-02-11 13:15:25', '2018-02-11 01:15:25');
INSERT INTO `tb_token` VALUES (32, '71f5ff0b-dbac-49dd-be42-0bcf208264b7', '2018-02-12 05:55:30', '2018-02-11 17:55:30');
INSERT INTO `tb_token` VALUES (33, 'c73852e1-02a8-483c-a769-7317cc67d93a', '2018-02-12 18:28:57', '2018-02-12 06:28:57');
INSERT INTO `tb_token` VALUES (34, '5df0927c-badf-4f0d-a5c2-3d2469a3c9d3', '2018-02-22 20:43:18', '2018-02-22 08:43:18');
INSERT INTO `tb_token` VALUES (35, '04d4a5d5-5d10-4999-81af-ca309053860f', '2018-02-25 03:49:58', '2018-02-24 15:49:58');
INSERT INTO `tb_token` VALUES (36, '850d66fd-f21d-4ada-b7d4-487bfaf87dea', '2018-02-25 06:48:05', '2018-02-24 18:48:05');
INSERT INTO `tb_token` VALUES (37, '98a36554-6a5e-4183-bdba-5e6fe47b70eb', '2018-02-26 01:43:17', '2018-02-25 13:43:17');
INSERT INTO `tb_token` VALUES (38, '7cc66ad6-9785-4d47-984c-08d667513603', '2018-02-26 02:39:15', '2018-02-25 14:39:15');
INSERT INTO `tb_token` VALUES (39, 'd30a67bb-9f03-44f2-857f-1c91d7211d68', '2018-02-27 05:46:31', '2018-02-26 17:46:31');
INSERT INTO `tb_token` VALUES (40, '137f2714-9da2-4ed3-90b8-dac2e509290e', '2018-02-27 03:19:13', '2018-02-26 15:19:13');
INSERT INTO `tb_token` VALUES (41, '64ed81f8-55a7-4cc4-a119-7ea567c207f1', '2018-03-07 12:08:54', '2018-03-07 00:08:54');
INSERT INTO `tb_token` VALUES (42, '6ebb0df1-fb63-4bf7-95a4-714fe12c945b', '2018-03-01 01:06:50', '2018-02-28 13:06:50');
INSERT INTO `tb_token` VALUES (43, '3e6dff9b-cbac-486e-9748-5ad8d2826cfb', '2018-02-28 23:52:13', '2018-02-28 11:52:13');
INSERT INTO `tb_token` VALUES (44, 'cebd4f24-505a-4a16-ae89-83f8c6990ea0', '2018-03-13 00:09:46', '2018-03-12 12:09:46');
INSERT INTO `tb_token` VALUES (45, '7935c2a9-1ff6-48a3-a4bf-06a3cca5f5d4', '2018-03-05 06:02:29', '2018-03-04 18:02:29');
INSERT INTO `tb_token` VALUES (46, 'a46cc776-2093-4ec6-b089-37b56b386c65', '2018-03-02 09:49:44', '2018-03-01 21:49:44');
INSERT INTO `tb_token` VALUES (47, 'cdbf76d7-abc7-4401-9db5-dffdf1a6e42b', '2018-03-04 21:40:44', '2018-03-04 09:40:44');
INSERT INTO `tb_token` VALUES (48, 'e61d15fe-1aaf-47a7-832e-509b96d451c8', '2018-03-10 06:07:53', '2018-03-09 18:07:53');
INSERT INTO `tb_token` VALUES (49, 'df7423c0-3775-477a-91b2-79015193f572', '2018-03-05 23:06:36', '2018-03-05 11:06:36');
INSERT INTO `tb_token` VALUES (50, '45f7daf5-518a-4260-9319-efc5c0e872a0', '2018-03-06 01:18:27', '2018-03-05 13:18:27');
INSERT INTO `tb_token` VALUES (51, '8568aa19-e614-4909-a0d7-deea9749da4c', '2018-03-06 04:52:45', '2018-03-05 16:52:45');
INSERT INTO `tb_token` VALUES (52, '99efc5e1-e189-47b1-9872-f969d42ad622', '2018-03-06 11:15:12', '2018-03-05 23:15:12');
INSERT INTO `tb_token` VALUES (53, '4ee6745f-6701-4f6b-b66a-7f856ca6f5a8', '2018-03-09 05:21:55', '2018-03-08 17:21:55');
INSERT INTO `tb_token` VALUES (54, 'b2f4bfaf-e86d-41dc-a11d-adcc422e35e9', '2018-03-06 23:53:56', '2018-03-06 11:53:56');
INSERT INTO `tb_token` VALUES (55, 'c595c49b-7d60-4c64-8198-295356f88795', '2018-03-09 22:27:23', '2018-03-09 10:27:23');
INSERT INTO `tb_token` VALUES (56, '2d9be6e1-48de-49aa-b0ce-37c9b32acd99', '2018-03-13 04:14:53', '2018-03-12 16:14:53');
INSERT INTO `tb_token` VALUES (57, 'e956483a-5a23-489c-982c-18e353f7bae6', '2018-03-09 23:00:02', '2018-03-09 11:00:02');
INSERT INTO `tb_token` VALUES (58, '9bc7cd3a-b73f-47eb-b0b6-69bbee98f419', '2018-03-09 23:07:32', '2018-03-09 11:07:32');
INSERT INTO `tb_token` VALUES (59, '957e58ca-30f8-4c76-9e76-bf79c52e7d92', '2018-03-10 06:08:47', '2018-03-09 18:08:47');
INSERT INTO `tb_token` VALUES (60, '2419cfaf-ff79-4037-b0cd-d70bdbf3532d', '2018-03-12 00:13:23', '2018-03-11 12:13:23');
INSERT INTO `tb_token` VALUES (61, '03d5fbd8-bdeb-4419-a454-3ab7f8804288', '2018-03-12 07:18:14', '2018-03-11 19:18:14');
INSERT INTO `tb_token` VALUES (62, '311c7edb-abfe-4df2-8076-6f0a741bb7e8', '2018-03-23 11:22:28', '2018-03-22 23:22:28');
INSERT INTO `tb_token` VALUES (63, '03bf64cb-2dab-48c7-b296-f2100ed84b2e', '2018-03-13 21:13:13', '2018-03-13 09:13:13');
INSERT INTO `tb_token` VALUES (65, '04292e06-ed90-48e8-9d68-5ba862f018f0', '2018-03-20 07:05:37', '2018-03-19 19:05:37');
INSERT INTO `tb_token` VALUES (66, '01c46a3c-0043-4cfa-96e0-f97c1452b313', '2018-03-24 12:48:17', '2018-03-24 00:48:17');
INSERT INTO `tb_token` VALUES (67, '76acccf7-525c-483a-b96d-0c47e66bd4e3', '2018-03-14 02:28:51', '2018-03-13 14:28:51');
INSERT INTO `tb_token` VALUES (68, '24f1b802-7579-434d-900e-89619a387c37', '2018-03-14 04:08:40', '2018-03-13 16:08:40');
INSERT INTO `tb_token` VALUES (69, 'ca41fadd-1a2e-43d2-b3cb-896ba44580a6', '2018-03-15 11:44:01', '2018-03-14 23:44:01');
INSERT INTO `tb_token` VALUES (70, '0ef8fcf4-8939-4d11-a72c-06b2231c9c1f', '2018-03-15 20:22:08', '2018-03-15 08:22:08');
INSERT INTO `tb_token` VALUES (71, '6c2402d5-69d5-4a7d-b7e8-989c00cc9c25', '2018-03-16 22:54:09', '2018-03-16 10:54:09');
INSERT INTO `tb_token` VALUES (72, 'cce8cafb-3910-40c2-ba1f-89eaefd03389', '2018-03-16 21:11:21', '2018-03-16 09:11:21');
INSERT INTO `tb_token` VALUES (75, 'a43a7da8-e07a-4101-bf51-c72054856fd6', '2018-03-24 12:57:26', '2018-03-24 00:57:26');
INSERT INTO `tb_token` VALUES (76, '3410c295-c46b-41a1-a6c9-bdf564e22cd7', '2018-03-19 04:39:07', '2018-03-18 16:39:07');
INSERT INTO `tb_token` VALUES (77, '02ab2fe9-bacd-4961-8101-f1a94e84700c', '2018-03-22 09:09:33', '2018-03-21 21:09:33');
INSERT INTO `tb_token` VALUES (78, '65e52eae-a56f-4d3e-9f7b-e803b519cc80', '2018-03-22 10:48:40', '2018-03-21 22:48:40');
INSERT INTO `tb_token` VALUES (79, 'bcfc8d2f-55e5-4836-9c38-57622e2c3fd4', '2018-03-23 07:23:16', '2018-03-22 19:23:16');
INSERT INTO `tb_token` VALUES (80, 'f2c0c886-45c6-4670-b025-507194108ac4', '2018-03-23 09:22:43', '2018-03-22 21:22:43');
INSERT INTO `tb_token` VALUES (81, 'f4dca121-4fb5-4726-8e15-d9dbdca1a968', '2018-03-25 23:41:49', '2018-03-25 11:41:49');
INSERT INTO `tb_token` VALUES (82, 'ddac4f78-73c2-4955-9007-6a6e11b747cc', '2018-03-25 08:39:11', '2018-03-24 20:39:11');
INSERT INTO `tb_token` VALUES (83, 'ac9e97a6-cdbc-406d-88e9-16cdf4fb9443', '2018-03-24 03:59:30', '2018-03-23 15:59:30');
INSERT INTO `tb_token` VALUES (84, '086a8c2f-d6a8-435c-ba8f-5a9cd22c132b', '2018-03-24 03:57:30', '2018-03-23 15:57:30');
INSERT INTO `tb_token` VALUES (85, '37e6681d-fba2-44f3-92b0-1cae8eee95b6', '2018-03-24 04:04:01', '2018-03-23 16:04:01');
INSERT INTO `tb_token` VALUES (86, '11c5f5b0-96cb-4df4-ae0a-4cd83d44e7d9', '2018-03-24 05:29:57', '2018-03-23 17:29:57');
INSERT INTO `tb_token` VALUES (87, '8436252c-22f4-4699-87ab-62bdb031fca6', '2018-03-25 05:12:16', '2018-03-24 17:12:16');
INSERT INTO `tb_token` VALUES (88, '012d31e7-40db-4f03-9ed0-9d14658b6680', '2018-03-25 05:20:44', '2018-03-24 17:20:44');
INSERT INTO `tb_token` VALUES (89, '0b61c4db-651a-4362-b8ee-ccb2e6c29647', '2019-03-03 00:48:39', '2019-03-02 12:48:39');
INSERT INTO `tb_token` VALUES (90, '60474122-95cb-42de-a6a2-eb659c07206e', '2019-03-03 02:42:15', '2019-03-02 14:42:15');
INSERT INTO `tb_token` VALUES (91, '73a10061-d435-4c4b-9b16-5123bde3f303', '2019-03-03 02:43:41', '2019-03-02 14:43:41');
INSERT INTO `tb_token` VALUES (92, 'e629334c-9418-4a39-85e5-d2b2eb68963c', '2019-03-03 02:45:20', '2019-03-02 14:45:20');
INSERT INTO `tb_token` VALUES (93, 'ccd39c78-6067-4994-a5e5-55c78a2570ec', '2019-03-03 02:52:52', '2019-03-02 14:52:52');
INSERT INTO `tb_token` VALUES (94, 'fadd87f7-d8cf-4945-b7d1-834660707e13', '2020-01-02 10:31:00', '2020-01-01 22:31:00');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '用户名',
  `mobile` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '手机号',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 95 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, 'mark', '13612345678', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', '2017-03-23 22:37:41');
INSERT INTO `tb_user` VALUES (3, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (4, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (5, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (6, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (7, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (8, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (9, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (10, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (11, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (12, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (13, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (14, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (15, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (16, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (17, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (18, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (19, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (20, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (21, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (22, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (23, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (24, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (25, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (26, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (27, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (28, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (29, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (30, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (31, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (32, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (33, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (34, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (35, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (36, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (37, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (38, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (39, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (40, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (41, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (42, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (43, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (44, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (45, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (46, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (47, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (48, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (49, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (50, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (51, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (52, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (53, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (54, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (55, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (56, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (57, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (58, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (59, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (60, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (61, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (62, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (63, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (65, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (66, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (67, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (68, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (69, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (70, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (71, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (72, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (75, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (76, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (77, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (78, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (79, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (80, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (81, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (82, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (83, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (84, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (85, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (86, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (87, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (88, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (89, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (90, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (91, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (92, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (93, NULL, NULL, NULL, NULL);
INSERT INTO `tb_user` VALUES (94, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
