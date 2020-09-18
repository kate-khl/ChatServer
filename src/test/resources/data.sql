DELETE from USERS_CHATS;
DELETE from CHAT;
DELETE from USER;

INSERT INTO USER (ID, EMAIL, NAME, PASSWORD, ROLE) VALUES 
	(1000, 'user1@test.com', 'UserName1', '123', 'user'),
	(1001, 'user2@test.com', 'UserName2', '123', 'user'),
	(1002, 'user3@test.com', 'UserName3', '123', 'user'),
	(1003, 'user4@test.com', 'UserName4', '123', 'user');

INSERT INTO CHAT (ID, NAME, AUTHOR_ID) VALUES (1004, 'ChatName', 1000);

INSERT INTO USERS_CHATS (CHAT_ID, USER_ID) VALUES (1004, 1000), (1004, 1001);