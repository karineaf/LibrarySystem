INSERT INTO author (id, name) VALUES (1, 'Machado de Assis');
INSERT INTO author (id, name) VALUES (2, 'Clarice Lispector');

INSERT INTO book (id, title, description, release_date, pages_number, genre, target_audience)
VALUES (1, 'Dom Casmurro', 'Romance clássico da literatura brasileira', '1899-01-01', 256, 'ROMANCE', 'ADULT');

INSERT INTO book (id, title, description, release_date, pages_number, genre, target_audience)
VALUES(2, 'A Hora da Estrela', 'Romance modernista', '1977-01-01', 96, 'FICTION', 'ADULT');


INSERT INTO author_book (author_id, book_id) VALUES (1, 1);
INSERT INTO author_book (author_id, book_id) VALUES (2, 2);