CREATE TABLE `post_info` (
  `post_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `post_content` varchar(2000) NOT NULL,
  `writer` varchar(5) NOT NULL,
  `password` varchar(16) NOT NULL,
  `write_dt` timestamp NOT NULL DEFAULT current_timestamp(),
  `update_dt` timestamp NOT NULL DEFAULT current_timestamp(),
  `view_count` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`post_id`)
);
	
CREATE TABLE `category_info` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(20) NOT NULL,
  `create_dt` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`category_id`)
);
	 
	 
CREATE TABLE `comment_info` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `post_id` int(11) NOT NULL,
  `comment_content` varchar(1000) NOT NULL,
  `write_dt` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`comment_id`)
);

CREATE TABLE `file_info` (
  `file_seq` int(11) NOT NULL AUTO_INCREMENT,
  `post_id` int(11) NOT NULL,
  `file_name` varchar(100) NOT NULL,
  `file_type` varchar(10) NOT NULL,
  `encode_file_name` varchar(300) DEFAULT NULL,
  `directory_path` varchar(100) NOT NULL,
  `save_dt` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`file_seq`)
);