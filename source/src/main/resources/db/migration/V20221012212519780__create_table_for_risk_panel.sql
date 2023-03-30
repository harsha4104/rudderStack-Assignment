/* WRITE YOUR SQL */

CREATE TABLE source(
id int AUTO_INCREMENT,
name varchar(50),
PRIMARY KEY (id)
);

CREATE TABLE template(
id int AUTO_INCREMENT,
source_id int NOT NULL,
template_data JSON DEFAULT NULL,
PRIMARY KEY (id),
FOREIGN KEY (source_id) REFERENCES source(id)
);


CREATE TABLE source_config_data(
id int AUTO_INCREMENT,
source_id int NOT NULL,
config_data JSON DEFAULT NULL,
PRIMARY KEY (id),
FOREIGN KEY (source_id) REFERENCES source(id)
);
