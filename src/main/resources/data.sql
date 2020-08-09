/*Admin*/
insert into flowerPotDB.user (first_name, active, password, email, nick) value ('admin', true, '$2a$10$IonuoeuP68nVuYN7ecrkruDMfXztHrqrA/edVWwKHoTopfSrnlP1y', 'admin@gmail.com', 'admin');

/*Role*/
insert into flowerPotDB.roles (id, role) VALUES (NULL, 'ROLE_ADMIN');
insert into flowerPotDB.roles (id, role) VALUES (NULL, 'ROLE_USER');
insert into flowerPotDB.user_role (user_id, role_id) VALUES (1, 1);

/*Fruit*/
insert into flowerPotDB.fruit (description, level, month_to_get_fruit, month_to_start, name, one_year_flower, points, temperature, user_id)
VALUES ('OK', 7, 'Luty', 'Styczen', 'Banan', true , 0, 26, 1);
insert into flowerPotDB.fruit (description, level, month_to_get_fruit, month_to_start, name, one_year_flower, points, temperature, user_id)
VALUES ('OK', 2, 'Marzec', 'Styczen', 'Jablko', true , 0, 21, 1);
insert into flowerPotDB.fruit (description, level, month_to_get_fruit, month_to_start, name, one_year_flower, points, temperature, user_id)
VALUES ('OK', 5, 'Kwiecien', 'Styczen', 'Sliwka', true , 0, 22, 1);

/*Flower*/
insert into flowerPotDB.flower (description, level, month_to_start, name, one_year_flower, temperature, user_id)
VALUES ('trudna do sadzenia', 6, 'Luty', 'Kaktus', false, 26, 1);
insert into flowerPotDB.flower (description, level, month_to_start, name, one_year_flower, temperature, user_id)
VALUES ('trudna do sadzenia', 6, 'Luty', 'Skrzydlokwiat', false, 20, 1);

/*News*/
insert into flowerPotDB.news (news) VALUES ('Najstarszym żyjącym dziś gatunkiem drzewa jest miłorząb. Jest on ogniwem łączącym paprotniki z drzewami nagonasiennymi. Na naszej planecie występował już 1250 milionów lat temu. To prawdziwa żywa skamielina.');
insert into flowerPotDB.news (news) VALUES ('Najdłużej żyjące drzewo na świecie to sosna oścista. Jej wiek naukowcy szacują na 4789 lat.');
insert into flowerPotDB.news (news) VALUES ('Najpotężniejszym drzewem na świecie pod względem wysokości, grubości, objętości a także długowieczności jest mamutowiec olbrzymi. Drzewo to osiąga 93,6 m wysokości, średnicę korony 33 m, pierśnicę 8,25 m. To prawdziwy olbrzym.');
insert into flowerPotDB.news (news) VALUES ('Iglaki to rośliny o korzystnym wpływie na zdrowie. Wiele z nich wydziela do atmosfery fitoncydy. Związki te mają działanie antybakteryjne i łagodzą choroby układu oddechowego.');
insert into flowerPotDB.news (news) VALUES ('Nasiona maku polnego mogą kiełkować nawet po 40 latach przechowywania.');
insert into flowerPotDB.news (news) VALUES ('Lotos stał się dla Egipcjan symbolem zmartwychwstania i życia wiecznego. Uważany był za święty kwiat, który wykorzystywano m. in. przy ceremoniach pogrzebowych. Dlaczego tak uważano?Lotos, jak niewiele innych, jest w stanie przetrwać całe lata suszy, by nagle rozkwitnąć przy pierwszym przypływie wody.');
insert into flowerPotDB.news (news) VALUES ('W obecnych czasach większość kwiatów raczej nie kosztuje dużo. Nie zawsze było tak łatwo zdobyć kwiaty. W XVII-wiecznej Holandii rekordowe ceny osiągały tulipany. Pojedynczy kwiat kosztował wtedy odpowiednik około 2 tys. dzisiejszych dolarów.');
insert into flowerPotDB.news (news) VALUES ('Niedawno na Filipinach odkryto najbardziej mięsożernego kwiata na świecie. Jest on w stanie zjeść nawet szczura.');
insert into flowerPotDB.news (news) VALUES ('Najwyższe drzewo na świecie to eukaliptus królewski. Osiąga 143 m wysokości.');
insert into flowerPotDB.news (news) VALUES ('Naukowcy z Uniwersytetu Technicznego w Wiedniu badają drzewa. Badając ruch drzew specjalnym skanerem zauważyli, że nocą drzewa zmniejszają się. Oznacza to w uproszczeniu, że 5 metrowe drzewo staje się nocą niższe o jakieś 10 cm. Naukowcy zauważają, że najniższe drzewa są przed wschodem słońca.');
insert into flowerPotDB.news (news) VALUES ('Największe trawy to bambusy Dendrocalamus. Występują w południowo-wschodniej Azji i osiągają 40 metrów wysokości przy 30 cm średnicy.');
insert into flowerPotDB.news (news) VALUES ('Pojedynczy osobnik perzu właściwego, pospolitego chwasta, może mieć system kłączy, ciągnący się nawet 100 metrów.');
insert into flowerPotDB.news (news) VALUES ('Choina kanadyjska potrafi rozróżnić kierunki świata. Fenomenem jest fakt, że zawsze swój czubek zwraca w kierunku północno- wschodnim.');
insert into flowerPotDB.news (news) VALUES ('Słonecznik jest wyjątkową rośliną, postawiony w cieniu ma zdolność odwracania głowy w stronę słońca. Słoneczniki to rośliny miododajne. Z jednego hektara można zebrać nawet 50 kilogramów miodu.');
insert into flowerPotDB.news (news) VALUES ('Niektóre rośliny owadożerne mogą wchodzić z owadami w symbiozę. Przykładem jest, żyjąca w lasach Borneo, mrówka z rodzaju Colobopsis. Żyje ona wewnątrz ogonka liściowego dzbanecznika. Roślina zapewnia mrówkom schronienie, a te „udrażniają” układ trawienny gospodarza zjadając większe owady.');
insert into flowerPotDB.news (news) VALUES ('Najszybciej działającą pułapkę w świecie roślin owadożernych i jednocześnie jeden z najszybszych ruchów w całym królestwie roślin posiada pływacz. Klapka w jego pułapce otwiera się z prędkością 1/160 sekundy.');
insert into flowerPotDB.news (news) VALUES ('Najmniejsze nasiona wytwarzają epifityczne storczyki lasów tropikalnych. Nasiona są drobne i lekkie jak pył. 1, 2 miliona nasion tych storczyków waży zaledwie 1 gram. Nasiona niektórych gatunków są tak drobne jak zarodniki grzybów.');

