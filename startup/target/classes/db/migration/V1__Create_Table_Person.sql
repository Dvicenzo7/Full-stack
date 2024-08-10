CREATE TABLE IF NOT EXISTS person (
                                      id BIGSERIAL NOT NULL,
                                      first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    address VARCHAR(100) NOT NULL,
    gender VARCHAR(8) NOT NULL,
    PRIMARY KEY (id)
    );

