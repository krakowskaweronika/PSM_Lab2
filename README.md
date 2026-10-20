# Konspekt 2
Autor: Weronika Krakowska

# Sprawozdanie

## Zrzuty ekranu gotowej aplikacji
<img width="636" height="753" alt="1" src="https://github.com/user-attachments/assets/0ac80c64-d276-4ef7-b0e4-3b524a5dde5b" />
<img width="615" height="756" alt="2" src="https://github.com/user-attachments/assets/f6d87e11-f974-4acd-a232-b210debed6d2" />
<img width="643" height="748" alt="3" src="https://github.com/user-attachments/assets/a0dab506-ea8c-414e-9c59-b4d2dfe34bee" />

## Zrzuty ekranu szuflady z aplikacją własną
Aplikacja własna znajduję się pod nazwą "Konspekt2".

<img width="630" height="747" alt="szuflada" src="https://github.com/user-attachments/assets/e0dc07a3-9d14-4fad-90f7-a869ceb8a581" />



## Opis zachowania blokady orientacji na telefonie i na tablecie wraz z wyjaśnieniem różnicy

Obserwacje: Na telefonie aplikacja pozostaje zablokowana w trybie portretowym natomiast na tablecie blokada nie działa i aplikacja obraca się wraz z urządzeniem.

Przyczyna: W nowych wersjach systemu atrybut screeenOrientation jest ignorowany na rzuądzeniach, których najmniejszy bok wynosi co najmniej 600dp.

## Jaki był powód tej zmiany po stronie systemu i co powinno zastapić blokowanie orientacji?
Zmiana ta ma na celu zapobieganie sztucznemu blokowaniu aplikacji w wąskim widoku portretowym na dużych ekranach, co wymusza wykorzystanie dostępnej przestrzeni roboczej na tabletach i urządzeniach składanych.
Zamiast blokować orientację na sztywno, nalezy projektować responsywne interfejsy użytkownika, które dynamicznie dostosowują się do dostępnej przestrzeni przy pomocy mechanizmu Window Size Class.

## Uzasadnienie sposobu formatowania wyników
Liczby ułamkowe mniejsze niż 0.001 otrzymują formatowanie wykładnicze, by uniknąć ucinania skrajnie małych wartości do zera (jak przy latach świetlnych), 
a pozostałe liczby korzystają z domyślnego formatowania z separatorami tysięcy, co znacząco ułatwia czytanie bardzo dużych wyników w centymetrach.

## Wynik uruchomienia testów jednostkowych
<img width="1870" height="963" alt="test" src="https://github.com/user-attachments/assets/1e1bf35b-2f4f-4f5b-8635-cf488bd19a5a" />
