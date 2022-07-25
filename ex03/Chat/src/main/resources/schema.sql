CREATE TABLE IF NOT EXISTS users (
    id             SERIAL PRIMARY KEY,
    login          VARCHAR(100) NOT NULL,
    password       VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS rooms (
    id             SERIAL PRIMARY KEY,
    name           VARCHAR(100),
    owner_id       INT NOT NULL REFERENCES users(id)

);

CREATE TABLE IF NOT EXISTS messages (
    id             SERIAL PRIMARY KEY,
    author_id      INT NOT NULL REFERENCES rooms(id),
    room_id        INT NOT NULL REFERENCES users(id),
    message        TEXT,
    date           TIMESTAMP DEFAULT NOW()
);