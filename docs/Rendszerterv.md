# Rendszerterv

## 1. A rendszer célja
---

A rendszer célja, hogy a felhasználó egyszerűen és átláthatóan tudja használni az előtte lévő programot, amihez egy
felhasználóbarát ablakos alkalmazás áll rendelkezésre. Az adatbázis műveletek segítségével a felhasználó könnyedén
lekérdezheti, módosíthatja, törölheti és frissítheti a dolgozók illetve a gyárak adatait. A dolgozókkal kapcsolatos
műveleteknél fontos szempont, hogy adatok módosításakor a program figyelmeztet arról, hogy a főnököt értesítette a
változásokról. 
FOLYT

## 2. Üzleti folyamatok modellje
---
![Image](https://github.com/tcwzgo/ProgTech_Project/blob/main/pictures/uzletifolyamatok.png)

## 3. Követelmények
---
### Funkcionális követelmények:
    - Létező adatbázis
    - Adatbázis műveletek megvalósítása
    - Tervezési minták megvalósítása

### Nem funkcionális követelmény:
    - A programnak átláthatónak kell lennie
    - Pontosnak kell lennie
    - Gyorsnak kell lennie
    - Felhasználóbarátnak kell lennie

## 4. Funkcionális terv
A első kezelőfelületen kiválaszthatjuk, hogy melyik karbantartási modulba szeretnénk belépni (Employees / Factories). Mindkettő felületen lesz egy kattintható táblázat amelyben megjelennek a rekordok, ezeket tudja a felhasználó törölni, frissíteni, újat felvenni illetve listázni. Új adat felvétele esetén a felület bal oldalán található input mezőkbe tudja felvinni az adatokat, majd a lent található gombokkal tudja elvégezni az adott műveletet.
### Rendszerszereplők:
    - Felhasználó
    - Rendszeradmin

### Rendszerhasználati esetek és lefutásaik:

* Felhasználó:
    - Gombok segítségével navigálható a program
    - Szöveges beviteli mezők segítik a munkát
    - Az adatok táblázatban jelennek meg

### Menü-hierarchiák:
* Main menu:
    - Employee Form
    - Factories Form

## 5. Fizikai környezet


### Fejlesztői környezet:
    - Intellij Idea
    - Visual Studio Code
    - Git
    - XAMPP / WAMP
    - phpMyAdmin

### Futtatási környezet:
    A program futtatásához elsősorban egy számítógép szükséges, amire telepítve van a Java. A folyamatot megkönnyíti, ha telepítjük a Intellij Idea-t, mivel azt egyszerű kezelni.

### Specifikáció:
    - Számítógép egy stabil operációs rendszerrel
    - Internetkapcsolat
    - Java
    - Intellij Idea

## 6. Architekturális terv
---
Felhasznált technológiák:
 1. MySQL:
    A MySQL kezeli az adatbázisunkat, itt tároljuk el az adatokat.
    A program "query"-n keresztül kommunikál az adatbázissal, lekérdezéseket, müveleket végez el benne.
    XAMPP-al vezérelt, localhost-on elérhető.
 2. Java:   
    Intellij Idea fejlesztői környezetben folyik a programozás.
    A Java program kezelői felülete Swing használatával hoztuk létre, ennek segítségével rendezzük el a gombokat, képeket, feliratokat, megjelenő ablak méretét.
    Az adatbázisből betölti az adatokat, szükség esetén hozzáad, töröl, módosít.
    Az adatbázishoz a connector package használatával tud kapcsolódni, mysql connect használatával.
    A logolás a Log4j használatával történik, amivel az adatbázis műveleteket logoljuk egy fájlba.

## 7. Telepítési terv
---
A program lokálisan működik.
A futtatáshoz szükség van MySQL elérésre, illetve internetkapcsolatra.
A felhasználónak klónoznia kell a projektet a kódtárból, illetve szüksége van egy futó XAMPP / WAMP szerverre,
amelyen elérhető a phpMyAdmin.

## 8. Karbantartási terv
---
A rendszer karbantartása időszakos lesz. Hibákat a felhasználó emailen keresztül tudja jelezni a fejlesztők felé.
A hibabejelentésnél a felhasználó leírhatja mi a hiba és opcionálisan megadhatja a folyamatot amivel a hiba történt (opcionálisan képernyőkép feltöltése). Az üzenetet csak a fejlesztők látják.

## 9. Adatbázis terv
---

A program kapcsolódik az adatbázishoz, ha nem sikerül, logolásra kerül a probléma.
Csatlakozás után a formok táblázatában megjelennek az adatok, amik a gombok és
szöveges beviteli mezők segítségével módosíthatók.

## 10. Implementációs terv
---
Java: A GUI felület java nyelven fog készülni. Ezeket a technológiákat amennyire csak lehet külön fájlokba írva készítjük, és úgy fogjuk egymáshoz csatolni a jobb átláthatóság, könnyebb változtathatóság, és könnyebb bővítés érdekében. A programban megjelenítjük és alkalmazzuk az adatbázis kezelést emellett alkalmazzuk a swing
grafikus interfészét.

## 11. Tesztterv
JUnit teszt könyvtár lesz használva a tesztek írására és futtatására.
## Tesztelési eljárások

**Alfa teszt:** Az alfa tesztet a fejlesztők végzik. A alfa teszt célja, hogy teszteljük a már meglévő funkciókat, hogy azok az elvártnak megfelelően működnek-e. A teszt akkor tekinthető sikeresnek, ha különböző GUI felületeken minden funkció megfelelően működik.

## Tesztelendő funkciók
**Backend Service:** Képesnek kell lennie több klienst egyidőben kiszolgálni. Képesnek kell lennie, az adatbázisban műveleteket végezni (hozzáadni, törölni, módosítani).

## Architekturális terv
A kommunikáció a Java fordítóprogramján keresztül történik.

### Adatbázis:
A rendszer adatainak tárolásához szükséges egy Adatbázis, a rendszerhez MySql-t alkalmazunk.