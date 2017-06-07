CREATE TABLE users (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  phone VARCHAR(12)
)
  ENGINE = InnoDB;

CREATE TABLE roles (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL
)
  ENGINE = InnoDB;


CREATE TABLE user_roles(
  user_id INT NOT NULL,
  role_id INT NOT NULL,
  
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (role_id) REFERENCES roles(id),
  
  UNIQUE (user_id, role_id)
)
  
ENGINE = InnoDB;

CREATE TABLE memes(
  `id` INT NOT NULL AUTO_INCREMENT,
  `meme_title` VARCHAR(255) NOT NULL,
  `meme_author` VARCHAR(255) NOT NULL,
  `meme_description` TEXT(1000) NOT NULL,
  `meme_price` INT(11) NOT NULL,
  `meme_img_link` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))

ENGINE = InnoDB;

INSERT INTO users VALUES (1, 'testUser', '$2a$11$uSXS6rLJ91WjgOHhEGDx..VGs7MkKZV68Lv5r1uwFu7HgtRn3dcXG', '33333');

INSERT INTO roles VALUES (1, 'ROLE_USER');
INSERT INTO roles VALUES (2, 'ROLE_ADMIN');

INSERT INTO user_roles VALUES (1, 2);