CREATE DATABASE db WITH
    OWNER = "user",
    ENCODING = 'UTF8',
    LC_COLLATE = 'Russian_Russia.1251',
    LC_CTYPE = 'Russian_Russia.1251',
    TABLESPACE = pg_default,
    CONNECTION LIMIT = 2;

GRANT TEMPORARY, CONNECT ON DATABASE db TO PUBLIC;

GRANT ALL ON DATABASE db TO "user";

CREATE TABLE IF NOT EXISTS "dictionaries" (
	"id"	INTEGER UNIQUE,
	"condition"	TEXT NOT NULL DEFAULT '[a-zA-Z]{%d}\\s[а-яА-Я]{%d}',
	"name"	TEXT NOT NULL DEFAULT 'default',
	PRIMARY KEY("id" AUTOINCREMENT)
);

CREATE TABLE IF NOT EXISTS "notes" (
	"id"	INTEGER,
	"text"	TEXT NOT NULL,
	"dictionary_id"	INTEGER NOT NULL,
	PRIMARY KEY("id"),
	FOREIGN KEY("dictionary_id") REFERENCES "dictionaries"("id")
);