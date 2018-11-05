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
* Oktató/Admin - Tud tárgyat hozzáadni
* Hallgató - Tud tárgyat felvenni

### Végpontok:
* felhasználók/
* felhasználók/{ID}/tárgyak
* felhasználók/{ID}/tárgyFelvétel
* felhasználók/{ID}/tárgyLeadás
* tárgyak/
* tárgyak/{ID}/kurzusok
* kurzusok/
* kurzusok/{ID}/tanár
* kurzusok/{ID}/diákSzám
* kurzusok/{ID}/diákLimit
### Adatbázisok:
* Tárgyak
* Felhasználók
* Kurzusok
* Tárgyfelvételek



![Adatbázis táblák](docs/img/Classdiagram1.png)


### Használati esetek:
![Hallgató használati esetei](docs/img/Usecasediagram1.png)
![Oktató használati esetei](docs/img/Usecasediagram2.png)

### Szekvencia diagramok:

* regisztrálás
![regisztrálás szekvenciája](docs/img/register.png)

* belépés
![login szekvenciája](docs/img/login.png)

* felhasználók lekérése
![felhasználók lekérése szekvenciája](docs/img/getAll.png)

* kurzusok lekérése
![kurzusok keresése szekvenciája](docs/img/courses.png)

* kurzus hozzáadása
![kurzus hozzáadása szekvenciája](docs/img/addCourse.png)

* kurzus felvétele
![kurzus felvétele szekvenciája](docs/img/takeCourse.png)

* kurzus leadása
![kurzus hozzáadása szekvenciája](docs/img/leaveCourse.png)

