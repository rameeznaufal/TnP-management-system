CREATE TABLE IF NOT EXISTS Company (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    role VARCHAR(255) NOT NULL,
    ctc VARCHAR(60),
    locat VARCHAR(255)
);

INSERT INTO Company(name,role,ctc,locat) VALUES
   ("dell","SDE","50LPA","UTAH");
INSERT INTO Company(name,role,ctc,locat) VALUES
   ("hp","SDE","20LPA","NYC");
INSERT INTO Company(name,role,ctc,locat) VALUES
   ("vivo","HDE","50LPA","UTAH");
