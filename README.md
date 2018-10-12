# Neptun++

### Funkcionális követelmények:
* regisztráció
* bejelentkezés
* felvehető tárgyak listázása (minkenki)
* felvett tárgyak listázása (adott személy)
* tárgy(ak) felvétele (adott személy)
* tárgy(ak) leadása (adott személy)
* tárgy(ak) hozzáadása (admin)
* hallgató(k) hozzáadása (admin)

### Nem funkcionális követelmények:
* felhasználóbarát felület
* jelszavak biztonságos tárolása
* listázások gyors megjelenítése


### Szerepkörök:
* Tanár/Admin - Tud tárgyat hozzáadni
* Diák - Tud tárgyat felvenni

### Végpontok:
* felhasználók/
* felhasználók/{ID}/tárgyak
* tárgyak/
* tárgyak/{ID}/kurzusok
* kurzusok/
* kurzusok/{ID}/tanár
* kurzusok/{ID}/diákSzám
* kurzusok/{ID}/diákLimit
### Adatbázisok:
* Tárgyak
* Hallgató
* Oktató
* Kurzusok
* Tárgyfelvételek
![Adatbázis táblák](docs/img/Classdiagram1.png)


### Használati esetek:
![Hallgató használati esetei](docs/img/Usecasediagram1.png)
![Oktató használati esetei](docs/img/Usecasediagram2.png)
###
