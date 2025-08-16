-- ==========================
-- AUTHORS
-- ==========================
INSERT INTO author (id, name) VALUES (1000, 'Machado de Assis');
INSERT INTO author (id, name) VALUES (2000, 'Clarice Lispector');
INSERT INTO author (id, name) VALUES (4000, 'Carlos Drummond de Andrade');

-- ==========================
-- BOOKS
-- ==========================
INSERT INTO book (id, title, description, release_date, pages_number, genre, target_audience)
VALUES (1000, 'Dom Casmurro', 'Romance clássico da literatura brasileira', '1899-01-01', 256, 'ROMANCE', 'ADULT');

INSERT INTO book (id, title, description, release_date, pages_number, genre, target_audience)
VALUES (2000, 'A Hora da Estrela', 'Romance modernista', '1977-01-01', 96, 'FICTION', 'ADULT');

INSERT INTO book (id, title, description, release_date, pages_number, genre, target_audience)
VALUES (3000, 'Memórias Póstumas de Brás Cubas', 'Romance inovador da literatura brasileira', '1881-01-01', 216, 'ROMANCE', 'ADULT');

INSERT INTO book (id, title, description, release_date, pages_number, genre, target_audience)
VALUES (4000, 'A Paixão Segundo G.H. e Outros Contos', 'Coletânea de contos de Clarice e Drummond', '1975-01-01', 220, 'FICTION', 'ADULT');

-- ==========================
-- AUTHOR_BOOK RELATION
-- ==========================
INSERT INTO author_book (author_id, book_id) VALUES (1000, 1000);
INSERT INTO author_book (author_id, book_id) VALUES (1000, 3000);
INSERT INTO author_book (author_id, book_id) VALUES (2000, 2000);
INSERT INTO author_book (author_id, book_id) VALUES (2000, 4000);
INSERT INTO author_book (author_id, book_id) VALUES (4000, 4000);

-- ==========================
-- USERS
-- ==========================
INSERT INTO users (id, name, email, telephone_number, address, birth_date)
VALUES (1234, 'Joseph Will', 'joseph@example.com', '1234567890', 'Avenue A, 123', '1990-01-01');

INSERT INTO users (id, name, email, telephone_number, address, birth_date)
VALUES (5678, 'Alicia Gomez', 'alicia@example.com', '0987654321', 'Avenue B, 456', '1992-02-02');
-- ==========================
-- RESERVATIONS
-- ==========================
