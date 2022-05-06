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

## 5. Funkcionális terv
---
### Rendszerszereplők:
    - Felhasználó

### Rendszerhasználati esetek és lefutásaik:

* Felhasználó:
    - Gombok segítségével navigálható a program
    - Szöveges bevitelő mezők segítik a munkát
    - Az adatok táblázatban jelennek meg

### Menü-hierarchiák:
---

* Main menu:
    - Employee Form
    - Factories Form

## 6. Fizikai környezet
---
### Fejlesztői környezet:
    - Visual Studio Code
    - Intellij Idea
    - Git
    - XAMPP

### Futtatási környezet:
    A program futtatásához elsősorban egy számítógép szükséges, amire telepítve van a Java. A folyamatot megkönnyíti, ha telepítjük a Intellij Idea-t, mivel azt egyszerű kezelni.

### Specifikáció:
    - Számítógép egy stabil operációs rendszerrel
    - Internetkapcsolat
    - Java
    - Intellij Idea

## 7. Architekturális terv
--
Felhasznált technológiák:
 1. MySQL:
    A MySQL kezeli az adatbázisunkat, itt tároljuk el az adatokat.
    A program "query"-n keresztül kommunikál az adatbázissal, lekérdezéseket, müveleket végez el benne.
    XAMPP-al vezérelt, localhost-on elérhető.
2.  Java:   
    Intellij Idea fejlesztői környezetben folyik a programozás.
    A Java program kezelői felülete Swing használatával hoztuk létre, ennek segítségével rendezzük el a gombokat, képeket, feliratokat, megjelenő ablak méretét.
    Az adatbázisből betölti az adatokat, szükség esetén hozzáad, töröl, módosít.
    Az adatbázishoz a connector package használatával tud kapcsolódni, mysql connect használatával.
    A logolás a Log4j használatával történik, amivel az adatbázis műveleteket logoljuk egy fájlba.

## 8. Telepítési terv
--
A program lokálisan működik.
A futtatáshoz szükség van MySQL elérésre, illetve internetkapcsolatra.
A felhasználónak le kell töltenie az alkalmazást a saját gépére, biztosítania kell a localhost elérését XAMPP-on keresztül.

## 9. Karbantartási terv
--
A rendszer karbantartása időszakos lesz. Hibákat a felhasználó emailen keresztül tudja jelezni a fejlesztők felé.
A hibabejelentésnél a felhasználó leírhatja mi a hiba és opcionálisan megadhatja a folyamatot amivel a hiba történt (opcionálisan képernyőkép feltöltése). Az üzenetet csak a fejlesztők látják.