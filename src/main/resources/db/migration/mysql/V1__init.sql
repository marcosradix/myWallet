create table user(
  user_id INT(11) NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  password VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL,
  CONSTRAINT user_pk PRIMARY KEY (user_id)
);

create table wallet(
  wallet_id INT(11) NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) ,
  value VARCHAR(10.2),
  CONSTRAINT wallet_pk PRIMARY KEY (wallet_id)
);

create table user_wallet(
  user_wallet_id INT(11),
  wallet_id INT(11) ,
  user_id INT(11) ,
  CONSTRAINT user_wallet_pk PRIMARY KEY (user_wallet_id),
  FOREIGN KEY (user_id) REFERENCES user(user_id),
  FOREIGN KEY (wallet_id) REFERENCES wallet(wallet_id)
);

create table wallet_item(
  wallet_item_id INT(11),
  wallet_id INT(11) ,
  date Date,
  type VARCHAR(2),
  description VARCHAR(500),
  value INT(10.2) ,
  CONSTRAINT wallet_item_pk PRIMARY KEY (wallet_item_id),
  FOREIGN KEY (wallet_id) REFERENCES wallet(wallet_id)
);