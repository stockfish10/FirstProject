INSERT INTO countries (id, name, information,picture) VALUES
(1, 'Bulgaria', 'You can hang out at the beach and in the mountains. Has many monuments. Beautiful nature.', '/images/Bulgaria.jpg'),
(2, 'France', 'You can hang out at the beach and in the mountains. Has many monuments. Beautiful nature.', '/images/France.jpg'),
(3, 'USA', 'You can hang out at the beach and in the mountains. Has many monuments. Beautiful nature.', '/images/USA.jpg');

INSERT INTO towns (id, name, description, country_id) VALUES
(1, 'Sofia', 'Capital of Bulgaria. Located in the West side of the country. Has a great night life and also the biggest city in the country', 1),
(2, 'Varna', 'Second biggest city in the country. Located seaside. During the winter the life is "slow", however during the summer period, living there is great', 1),
(3, 'Veliko Tarnovo', 'Called the "Old Capital" a small city in the center of bulgaria. Has many monuments', 1),
(4, 'Paris', 'One of the best cities to visit in Europe. Great night life, many things to do there.', 2),
(5, 'Nice', 'Located in the French Riviera. Amazing night life, many places for sightseeing', 2),
(6, 'Marseille', 'Located in the French Riviera. Amazing night life, many places for sightseeing', 2),
(7, 'New York', 'Everybodys dream city. Anything we say will not be enough for this city. A must visit.', 3),
(8, 'Los Angeles', 'Located in the western part of the country, thats where all the celebrities live.', 3),
(9, 'Houston', 'If you wanna feel american, must come here', 3);

INSERT INTO events (id, address, date, description, event_place, event_type, country_id, organizer_id, town_id) VALUES
(1, 'Bulgarska st. 11', '2022-08-16', 'Here place some interesting description, about the event. What will be happening there. Famous guests, if any. What will the programme for the day be and so on and so forth.', 'Outdoor', 'Health', 1, 1, 1),
(2, 'Business Park Sofia 12A', '2022-09-16', 'Here place some interesting description, about the event. What will be happening there. Famous guests, if any. What will the programme for the day be and so on and so forth.', 'Indoor', 'Business', 1, 1, 1),
(3, 'Sea Casino', '2022-10-01', 'Here place some interesting description, about the event. What will be happening there. Famous guests, if any. What will the programme for the day be and so on and so forth.', 'Mixed', 'FoodAndDrink', 1, 1, 2),
(4, 'Port Varna', '2022-08-19', 'Here place some interesting description, about the event. What will be happening there. Famous guests, if any. What will the programme for the day be and so on and so forth.', 'Outdoor', 'TravelAndOutdoor', 1, 1, 2),
(5, 'Vasil Levski st.', '2022-08-19', 'Here place some interesting description, about the event. What will be happening there. Famous guests, if any. What will the programme for the day be and so on and so forth.', 'Indoor', 'SportsAndFitness', 1, 1, 3),
(6, 'Gurko st. 12', '2022-08-19', 'Here place some interesting description, about the event. What will be happening there. Famous guests, if any. What will the programme for the day be and so on and so forth.', 'Outdoor', 'FoodAndDrink', 1, 1, 3),
(7, 'Corniche JFK Kennedy -13008', '2022-09-01', 'Here place some interesting description, about the event. What will be happening there. Famous guests, if any. What will the programme for the day be and so on and so forth.', 'Mixed', 'TravelAndOutdoor', 2, 1, 6),
(8, '140 Rue du Vallon des Auffes', '2022-10-23', 'Here place some interesting description, about the event. What will be happening there. Famous guests, if any. What will the programme for the day be and so on and so forth.', 'Indoor',  'FoodAndDrink', 2, 1, 6),
(9, '78160 Marly-le-Roi', '2022-09-10', '2022-10-19', 'Here place some interesting description, about the event. What will be happening there. Famous guests, if any. What will the programme for the day be and so on and so forth.', 'Outdoor', 'Hobbies', 2, 1, 4)
(10, '5 Rue Victor Schoelcher', '2022-09-18', 'Here place some interesting description, about the event. What will be happening there. Famous guests, if any. What will the programme for the day be and so on and so forth.', 'Indoor', 'Music', 2, 1, 4),
(11, '582 Esp. du Levant, Saint-Laurent-du-Var', '2022-09-10', 'Here place some interesting description, about the event. What will be happening there. Famous guests, if any. What will the programme for the day be and so on and so forth.', 'Mixed', 'Music', 2, 1, 5),
(12, '13 Prom. des Anglais', '2022-08-19', 'Here place some interesting description, about the event. What will be happening there. Famous guests, if any. What will the programme for the day be and so on and so forth.', 'Outdoor', 'Hobbies', 2, 1, 5),
(13, '200 Santa Monica Pier, Santa Monica', '2022-08-20', 'Here place some interesting description, about the event. What will be happening there. Famous guests, if any. What will the programme for the day be and so on and so forth.', 'Outdoor', 'SportsAndFitness', 3, 1, 8),
(14, '9341 Venice Blvd., Culver City', '2022-08-25', 'Here place some interesting description, about the event. What will be happening there. Famous guests, if any. What will the programme for the day be and so on and so forth.', 'Outdoor', 'Hobbies', 3, 1, 8),
(15, '501 Crawford St', '2022-10-03', 'Here place some interesting description, about the event. What will be happening there. Famous guests, if any. What will the programme for the day be and so on and so forth.', 'Mixed', 'Health', 3, 1, 9),
(16, '701 Waugh Dr', '2022-08-30', 'Here place some interesting description, about the event. What will be happening there. Famous guests, if any. What will the programme for the day be and so on and so forth.' , 'Mixed', 'FoodAndDrink', 3, 1, 9),
(17, 'Washington Square', '2022-08-30', 'Here place some interesting description, about the event. What will be happening there. Famous guests, if any. What will the programme for the day be and so on and so forth.', 'Outdoor', 'Health', 3, 1, 7),
(18, '1260 6th Ave', '2022-09-04', 'Here place some interesting description, about the event. What will be happening there. Famous guests, if any. What will the programme for the day be and so on and so forth.', 'Mixed', 'FoodAndDrink', 3, 1, 7)
