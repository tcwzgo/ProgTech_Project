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