-- -------------------------------------------------------------------------------- single tables

-- select 'drop table '|| table_name || ' cascade constraints;' from user_tables;
drop table POKEMON cascade constraints;
drop table PERSON cascade constraints;
drop table POKEDEX cascade constraints;
drop table TYPE cascade constraints;
drop table LOCATION cascade constraints;
drop table ITEM cascade constraints;
drop table POKEBALL cascade constraints;
drop table POTION cascade constraints;
drop table PERSON_POKEMON cascade constraints;
drop table POKEMON_POKEDEX cascade constraints;
drop table POKEDEX_TYPE cascade constraints;
drop table LOCATION_POKEDEX cascade constraints;
drop table PERSON_ITEM cascade constraints;

drop sequence person_seq;
drop sequence pokedex_seq;
drop sequence type_seq;
drop sequence item_seq;
drop sequence person_item_seq;
drop sequence location_seq;
drop sequence location_pokedex_seq;
drop sequence pokemon_seq;
/*
    person: represents actual players
    username: the person's unique username with which to log in
    passwd: the person's password with which to log in
    display_name: the optional name that is displayed on the person's profile
    money: how much in-game money the person has
*/
create table person (
    id number(20) primary key,
    username varchar2(40) not null unique,
    passwd varchar2(40) not null,
    display_name varchar2(40),
    money number(20) not null
);

/*
    pokedex: represents each pokemon in a general sense (each species)
    name: the name of the pokemon
    image: the image displayed for the pokemon
    shiny_image: the image displayed if the pokemon is shiny
*/
create table pokedex (
    id number(5) primary key,
    name varchar2(40) not null unique
    -- image
    -- shiny_image
);

/*
    pokemon: represents actual individual pokemon
    nickname: the nickname given by the player, to be displayed with the pokemon
    level: the pokemon's level from 1-100
    hp: the pokemon's current hp
    max_hp: the pokemon's maximum hp stat at its current level
    shiny: randomly generated number determining whether the pokemon is shiny
    exp: the pokemon's current experience points for its current level
*/
create table pokemon (
    id number(20) primary key,
    nickname varchar2(40) not null,
    lvl number(3) not null,
    hp number(3) not null,
    max_hp number(3) not null,
    shiny number(4) not null,
    exp_pts number(10) not null,
    pokedex_id number(20) not null,
    owner_id number(20) not null,
    constraint fk_pokemon_pokedex foreign key (pokedex_id) references pokedex(id),
    constraint fk_pokemon_person foreign key (owner_id) references person(id)
);

/*
    type: represents a pokemon (or move)'s type
    name: the name of the type (i.e. electric)
    color: the color associated with the type
*/
create table type (
    id number(10) primary key,
    name varchar2(30) not null unique,
    color varchar2(30)
);

/*
    location: represents areas in the game that a player can visit to catch pokemon
    name: the name of the location (i.e. viridian forest)
    north_id: represents the location to the north of this one
    east_id, south_id, west_id: see above
*/
create table location (
    id number(20) primary key,
    name varchar2(60) not null unique,
    north_id number(20),
    east_id number(20),
    south_id number(20),
    west_id number(20)
);

/*
    item: a parent table representing all items which a player can own
    name: the name of the item (i.e. great ball)
*/
create table item (
    id number(20) primary key,
    name varchar2(30) not null unique
);

/*
    pokeball: represents items that are used to catch pokemon
    multiplier: represents the chance of catching a pokemon with this ball
*/
create table pokeball (
    multiplier number(3),
    item_id number(20) primary key,
    constraint fk_item_pokeball foreign key (item_id) references item(id)
);

/*
    potion: represents items that are used to heal hp
    hp: the amount of hp restored by this potion
*/
create table potion (
    hp number(3),
    item_id number(20) primary key,
    constraint fk_item_potion foreign key (item_id) references item(id)
);

-- --------------------------------------------------------------------------------- multiplicity tables

/*
    person_pokemon: represents the relationship between a person and their pokemon
*/
create table person_pokemon (
    person_id number(20),
    constraint fk_person_pokemon_person foreign key (person_id) references person(id),
    pokemon_id number(20),
    constraint fk_person_pokemon_pokemon foreign key (pokemon_id) references pokemon(id),
    pokeball_id number(20),
    constraint fk_person_pokemon_pokeball foreign key (pokeball_id) references pokeball(item_id)
);

/*
    pokemon_pokedex: represents the relationship between individual pokemon and their species
*/
create table pokemon_pokedex (
    pokemon_id number(20),
    constraint fk_pokemon_pokedex_pokemon foreign key (pokemon_id) references pokemon(id),
    pokedex_id number(5),
    constraint fk_pokemon_pokedex_pokedex foreign key (pokedex_id) references pokedex(id)
);

/*
    pokedex_type: represents the type(s) of a certain pokemon species
*/
create table pokedex_type (
    pokedex_id number(5),
    constraint fk_pokedex_type_pokedex foreign key (pokedex_id) references pokedex(id),
    type_id number(10),
    constraint fk_pokedex_type_type foreign key (type_id) references type(id)
);

/*
    location_pokedex: represents the pokemon species that can be found in a location and the level range
*/
create table location_pokedex (
    location_id number(20),
    constraint fk_location_pokedex_location foreign key (location_id) references location(id),
    pokedex_id number(5),
    constraint fk_location_pokedex_pokedex foreign key (pokedex_id) references pokedex(id),
    min_level number(3) not null,
    max_level number(3) not null
);

/*
    person_item: represents the item a person has and the quantity
*/
create table person_item (
    id number(20) primary key,
    person_id number(20),
    constraint fk_person_item_person foreign key (person_id) references person(id),
    item_id number(20),
    constraint fk_person_item_item foreign key (item_id) references item(id),
    quantity number(2) not null
);

create sequence person_seq;
create sequence pokedex_seq;
create sequence type_seq;
create sequence item_seq;
create sequence person_item_seq;
create sequence location_seq;
create sequence location_pokedex_seq;
create sequence pokemon_seq;