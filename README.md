# Neptun++

### Funkcionális követelmények:
* regisztráció
* bejelentkezés
* felvehető tárgyak listázása (minkenki)
* felvett tárgyak listázása (adott személy)
* tárgy(ak) felvétele (adott személy)
* tárgy(ak) leadása (adott személy)
* hallgató(k) hozzáadása (admin)

### Nem funkcionális követelmények:
* felhasználóbarát felület
* jelszavak biztonságos tárolása
* listázások gyors megjelenítése


### Szerepkörök az alkalmazásban

Az alkalmazásban 2 különböző felhasználótípust különböztetünk meg. Mindegyik felhasználótípus jogköre hitelesítéshez kötött, vendégként, bejelentkezés nélkül az alkalmazás oldalai nem elérhetőek.

### ADMIN

Ez a jogosultságkör az adminok és az oktatók számára kerül kiosztásra. Az egyszerűség kedvéért csak ADMIN-nak hívjuk. Ez a felhasználótípus vihet fel új felhasználókat.

### USER

A USER jogosultság a hallgatók számára kerül kiosztásra.

## Az alkalmazás logikai felépítése

A Neptun++ alkalmazás felülete elsősorban listás jellegű, ezzel biztosítva a könnyű átláthatóságot és kezelhetőséget.

### Log In - login

A Log in képernyő minden más webes alkalmazáshoz hasonlóan biztosítja a bejelentkezést a hallgatók és az oktatók számára. Az alkalmazás használatához mindenképpen be kell jelentkezni, ha a kérés nincs azonosítva, automatikusan a log in képernyőre navigál a kliens.

### Navigáció – navbar

Az alkalmazásban állandó jelleggel a felső sávban látható egy menüsáv, mely a navigációt biztosítja.  5 menüpont található rajta – tantárgyak, felvett kurzusok, üzenetek,  új felhasználó és egy belépés gomb. Ezek a menüpontok jogosultságtól függően érhetőek el az egyes felhasználók számára. 

### Tantárgyak – subject-list

A tantárgyak megjelenítése tárgyanként kattintásra lenyílik, így jelezve a választható kurzusokat ahhoz a tárgyhoz, amit majd kiválasztva és a tárgy felvétele gombra kattintva felvehetünk, ha arra beférünk.

### Felvett kurzusok – my-course-list

A tantárgyak oldalhoz hasonlóan működik, azzal a különbséggel, hogy itt mégegy lenyíló ablakban láthatjuk a kurzus többi hallgatóját, illetve leadhatjuk az adott kurzust.

### Üzenetek  message-list

Ha van kapott üzenetünk, azt listázva itt láthatjuk, illetve új üzenetet is küldhetünk.

### Új felhasználó  create-user

Ha admin jogaink vannak, felvihetünk új felhasználót. Feltétel, hogy ne legyen a felhasználónév már foglalt.



### Végpontok:

## GET 
* subjects/
* courses/
* courses/{ID}/teacher
* courses/{ID}/students
* courses/{ID}/subject
* courses/{ID}/studentCount
* courses/{ID}/studentLimit
* messages/
* messages/{ID}/sender
* messages/{ID}/addressee
* users/{ID}/courses


## PUT
* users/{userID}/takeCourse/{courseID}


## POST
* messages/sendMessage
* users/register
* users/login


## DELETE
* users/{userID}/{courseID}



### Adatbázisok:
* Tárgyak
* Felhasználók
* Kurzusok
* Üzenetek



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

