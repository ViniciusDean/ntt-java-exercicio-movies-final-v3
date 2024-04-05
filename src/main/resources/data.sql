INSERT INTO tb_genre (genre_name) VALUES ('Ação');
INSERT INTO tb_genre (genre_name) VALUES ('Comédia');
INSERT INTO tb_genre (genre_name) VALUES ('Drama');

INSERT INTO tb_studio (name, country) VALUES ('Warner Bros.', 'Estados Unidos');
INSERT INTO tb_studio (name, country) VALUES ('Universal Pictures', 'Estados Unidos');
INSERT INTO tb_studio (name, country) VALUES ('Paramount Pictures', 'Estados Unidos');


INSERT INTO tb_franchise (name, genre_id, studio_id) VALUES ('Marvel Cinematic Universe', 1, 1);
INSERT INTO tb_franchise (name, genre_id, studio_id) VALUES ('Harry Potter', 3, 2);
INSERT INTO tb_franchise (name, genre_id, studio_id) VALUES ('Star Wars', 1, 3);


INSERT INTO tb_streaming (name, url) VALUES ('Netflix', 'https://www.netflix.com');
INSERT INTO tb_streaming (name, url) VALUES ('Amazon Prime Video', 'https://www.primevideo.com');
INSERT INTO tb_streaming (name, url) VALUES ('Disney+', 'https://www.disneyplus.com');


INSERT INTO tb_director (name) VALUES ('Christopher Nolan');
INSERT INTO tb_director (name) VALUES ('Quentin Tarantino');
INSERT INTO tb_director (name) VALUES ('Steven Spielberg');


INSERT INTO tb_movie (title, genre_id, studio_id, franchise_id) VALUES ('Inception', 1, 1, 1);
INSERT INTO tb_movie (title, genre_id, studio_id) VALUES ('Pulp Fiction', 2, 2);
INSERT INTO tb_movie (title, genre_id, studio_id) VALUES ('The Irishman', 3, 3);

INSERT INTO movie_streaming (streaming_id, movie_id) VALUES (1, 1);

INSERT INTO tb_user (name, email, password) VALUES ('João', 'joao@example.com', 'senha123');
INSERT INTO tb_user (name, email, password) VALUES ('Maria', 'maria@example.com', 'senha456');
INSERT INTO tb_user (name, email, password) VALUES ('Pedro', 'pedro@example.com', 'senha789');

INSERT INTO tb_actor (name) VALUES ('Leonardo DiCaprio');
INSERT INTO tb_actor (name) VALUES ('Brad Pitt');
INSERT INTO tb_actor (name) VALUES ('Tom Hanks');