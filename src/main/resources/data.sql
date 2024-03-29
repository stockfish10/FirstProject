INSERT INTO countries (id, name, information,picture) VALUES
(1, 'Bulgaria', 'You can hang out at the beach and in the mountains. Has many monuments. Beautiful nature.', '/images/Bulgaria.jpg'),
(2, 'France', 'You can hang out at the beach and in the mountains. Has many monuments. Beautiful nature.', '/images/France.jpg'),
(3, 'USA', 'You can hang out at the beach and in the mountains. Has many monuments. Beautiful nature.', '/images/USA.jpg');

INSERT INTO towns (id, name, description, picture, country_id) VALUES
(1, 'Sofia', 'Capital of Bulgaria. Located in the West side of the country. Has a great night life and also the biggest city in the country', '/images/Sofia.jpg', 1),
(2, 'Varna', 'Second biggest city in the country. Located seaside. During the winter the life is "slow", however during the summer period, living there is great', '/images/Varna.jpg', 1),
(3, 'Veliko Tarnovo', 'Called the "Old Capital" a small city in the center of bulgaria. Has many monuments', '/images/VT.jpg', 1),
(4, 'Paris', 'One of the best cities to visit in Europe. Great night life, many things to do there.', '/images/Paris.jpg', 2),
(5, 'Nice', 'Located in the French Riviera. Amazing night life, many places for sightseeing', '/images/Nice.jpg', 2),
(6, 'Marseille', 'Located in the French Riviera. Amazing night life, many places for sightseeing', '/images/Marseille.jpg', 2),
(7, 'New York', 'Everybodys dream city. Anything we say will not be enough for this city. A must visit.', '/images/NY.jpg', 3),
(8, 'Los Angeles', 'Located in the western part of the country, thats where all the celebrities live.', '/images/LA.jpg', 3),
(9, 'Houston', 'If you wanna feel american, must come here', '/images/Houston.jpg', 3);

