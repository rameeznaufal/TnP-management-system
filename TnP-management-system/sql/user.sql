CREATE TABLE IF NOT EXISTS User (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    regNo VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(60) NOT NULL,
    contact VARCHAR(30),
    cgpa FLOAT(4,2),
    plac_stat VARCHAR(50) DEFAULT "NOT PLACED",
    plac_comp VARCHAR(255),
    plac_officer BOOLEAN DEFAULT false
);

INSERT INTO User(name,regNo,email,password,contact,cgpa,plac_officer) VALUES
   ("beny","b190989cs","benny@gmail.com","r4r4r2re","9898998",8.8,true);

INSERT INTO User(name,regNo,email,password,contact,cgpa,plac_officer) VALUES
   ("toby","b190e89cs","benny@gmail.com","r4r4r2re","9898998",8.8,true);


INSERT INTO User(name,regNo,email,password,contact,cgpa,plac_officer) VALUES
   ("doby","b190e29cs","benny@gmail.com","r4r4r2re","9898998",8.8,true);


