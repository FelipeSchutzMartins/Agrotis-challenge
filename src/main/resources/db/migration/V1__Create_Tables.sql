CREATE TABLE property (
                                  id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                  name varchar(40),
                                  cnpj varchar(14)
);
CREATE TABLE laboratory (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            name varchar(40)
);
CREATE TABLE property_owner (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          name varchar(40),
                          observations varchar(1000),
                          start_date date,
                          end_date date,
                          property_id bigint,
                          laboratory_id bigint,
                          FOREIGN KEY (property_id) REFERENCES property(id),
                          FOREIGN KEY (laboratory_id) REFERENCES laboratory(id)
);
