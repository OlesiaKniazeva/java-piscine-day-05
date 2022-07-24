INSERT INTO users(login, password) VALUES ('Masha', '343454543');
INSERT INTO users(login, password) VALUES ('Katya', 'hjfr893');
INSERT INTO users(login, password) VALUES ('Lele', 'vgh888');
INSERT INTO users(login, password) VALUES ('Bob', 'nnnio8');
INSERT INTO users(login, password) VALUES ('Sanya', '8y7bhj');
INSERT INTO users(login, password) VALUES ('Rob', 'bb78');

INSERT INTO rooms(owner_id, name) VALUES (1, 'room1');
INSERT INTO rooms(owner_id, name) VALUES (2, 'room2');
INSERT INTO rooms(owner_id, name) VALUES (3, 'room3');
INSERT INTO rooms(owner_id, name) VALUES (4, 'room4');
INSERT INTO rooms(owner_id, name) VALUES (1, 'room5');

INSERT INTO messages(author_id, room_id, message) VALUES (1, 1, 'hello');
INSERT INTO messages(author_id, room_id, message) VALUES (2, 1, 'nice to see you');
INSERT INTO messages(author_id, room_id, message) VALUES (3, 2, 'who is here?');
INSERT INTO messages(author_id, room_id, message) VALUES (3, 2, 'can somebody help me?');
INSERT INTO messages(author_id, room_id, message) VALUES (4, 2, 'how?');

-- SELECT * FROM users;
-- SELECT * FROM messages;
-- SELECT * FROM rooms;