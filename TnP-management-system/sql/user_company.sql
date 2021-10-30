CREATE TABLE IF NOT EXISTS user_company (
    user_id INT NOT NULL,
    company_id INT NOT NULL,
    FOREIGN KEY (user_id)
            REFERENCES User(id) ON DELETE CASCADE,
    FOREIGN KEY (company_id)
            REFERENCES Company(id) ON DELETE CASCADE,
    PRIMARY KEY(user_id,company_id)               
);

INSERT INTO user_company VALUES
   (1,2);

INSERT INTO user_company VALUES
   (2,1);

INSERT INTO user_company VALUES
   (5,1);
