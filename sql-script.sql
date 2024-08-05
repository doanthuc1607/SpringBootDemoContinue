-- Create the User table
CREATE TABLE user (
    username VARCHAR(255) PRIMARY KEY,
    password VARCHAR(255) NOT NULL
);

-- Insert data into the User table
INSERT INTO User (username, password) VALUES ('user1', 'password1');
INSERT INTO User (username, password) VALUES ('user2', 'password2');

-- Create the UrlMapping table
CREATE TABLE urlmapping (
    id INT AUTO_INCREMENT PRIMARY KEY,
    original_link VARCHAR(255) NOT NULL,
    short_link VARCHAR(255) NOT NULL
);

-- Insert data into the UrlMapping table
INSERT INTO UrlMapping (original_link, short_link) VALUES ('https://www.example.com', 'https://short.ly/abc123');
INSERT INTO UrlMapping (original_link, short_link) VALUES ('https://www.anotherexample.com', 'https://short.ly/xyz789');