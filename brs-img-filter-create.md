```
CREATE TABLE `img_download_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` varchar(64) DEFAULT NULL,
  `file_name` varchar(255) DEFAULT NULL COMMENT '图片名称',
  `trend` varchar(255) DEFAULT NULL COMMENT '趋势',
  `location` varchar(255) DEFAULT NULL COMMENT '位置',
  `quantity` varchar(255) DEFAULT NULL COMMENT '定量比',
  `original_id` varchar(64) DEFAULT NULL,
  `param_trend` varchar(45) DEFAULT NULL COMMENT '趋势比',
  `param_error` varchar(45) DEFAULT NULL COMMENT '误差率',
  `show_file_name` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `modify_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='图片下载记录';

CREATE TABLE `img_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(255) DEFAULT NULL,
  `file_path` varchar(255) DEFAULT NULL,
  `download` tinyint(1) DEFAULT NULL COMMENT '是否已经被使用（下载）1代表已经被下载过，0代表未下载',
  `order_id` varchar(64) DEFAULT NULL,
  `param_quantity` varchar(255) DEFAULT NULL COMMENT '定量值',
  `param_center` varchar(255) DEFAULT NULL COMMENT '质心坐标',
  `param_index` varchar(255) DEFAULT NULL COMMENT '索引',
  `param_bbox_all` varchar(255) DEFAULT NULL COMMENT '区域',
  `file_content` longblob COMMENT '图片内容',
  `source_file` varchar(255) DEFAULT NULL,
  `show_file_name` varchar(255) DEFAULT NULL COMMENT '显示的图片名称',
  `create_time` timestamp NULL DEFAULT NULL,
  `modify_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `file_name_UNIQUE` (`file_name`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COMMENT='图片信息表';


CREATE TABLE `img_upload_record` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `server_file_name` varchar(255) DEFAULT NULL COMMENT '上传文件在服务器上的名称。',
  `src_file_name` varchar(255) DEFAULT NULL COMMENT '上传的文件原始名称',
  `file_md5` varchar(400) DEFAULT NULL COMMENT '文件的MD5',
  `byte_size` bigint(20) DEFAULT NULL,
  `upload_status` tinyint(4) DEFAULT NULL COMMENT '上传状态，开始上传0，完成1，处理完成2.',
  `modify_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `upload_time` timestamp NULL DEFAULT NULL COMMENT '上传时间完成时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `server_file_name_UNIQUE` (`server_file_name`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COMMENT='文件上传记录表';

```