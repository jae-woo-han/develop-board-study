CREATE TABLE post_info(
	post_id INT NOT NULL PRIMARY KEY,
	category_id INT NOT NULL,
	title VARCHAR(100) NOT NULL,
	post_content VARCHAR(2000) NOT NULL,
	writer VARCHAR(5) NOT NULL,
	PASSWORD VARCHAR(16) NOT NULL,
	write_dt TIMESTAMP NOT NULL DEFAULT NOW(),
	update_dt TIMESTAMP NOT NULL DEFAULT NOW(),
	view_count INT NOT NULL
);
	
CREATE TABLE category_info(
	category_id INT NOT NULL PRIMARY KEY,
	 category_name VARCHAR(20) NOT NULL,
	 create_dt TIMESTAMP NOT NULL DEFAULT NOW()
);
	 
	 
CREATE TABLE comment_info(
	comment_id INT NOT NULL PRIMARY KEY,
	post_id INT NOT NULL,
	comment_content VARCHAR(1000) NOT NULL,
	wrte_dt TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE TABLE file_info(
	file_seq INT NOT NULL PRIMARY KEY,
	post_id INT NOT NULL,
	file_name VARCHAR(100) NOT NULL,
	file_type VARCHAR(10) NOT NULL,
	encod_file_name VARCHAR(300) NULL,
	directory_path VARCHAR(100) NOT NULL,
	save_dt TIMESTAMP NOT NULL DEFAULT NOW()
);