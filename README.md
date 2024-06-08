Dokumentacja techniczna dla aplikacji TimeTracker


Spis treści

    Wprowadzenie
    Opis funkcjonalności
    Instalacja i konfiguracja
    Użycie aplikacji
        Komenda app start
        Komenda app stop
        Komenda app continue
        Komenda app current
        Komenda app list
        Komenda app project
        Komenda app report
        Komenda app -h
    Przykłady użycia
    Struktura plików danych
    Wymagania systemowe
    Kontakt

1. Wprowadzenie

Firma IT Solution stworzyła aplikację TimeTracker, która umożliwia użytkownikom śledzenie czasu spędzonego nad różnymi projektami. Aplikacja jest przeznaczona do użytku w terminalu i pozwala na łatwe zarządzanie czasem pracy nad zadaniami.


2. Opis funkcjonalności

Aplikacja TimeTracker posiada następujące funkcjonalności:

    Startowanie zadania: Rozpoczęcie śledzenia czasu dla danego zadania i projektu.
    Zatrzymywanie zadania: Zakończenie śledzenia czasu dla aktualnie aktywnego zadania.
    Wznawianie zadania: Wznowienie śledzenia czasu dla ostatniego zadania lub określonego zadania z historii.
    Aktualne zadanie: Wyświetlenie informacji o aktualnie śledzonym zadaniu.
    Lista ostatnich aktywności: Wyświetlenie pięciu ostatnich aktywności.
    Lista projektów: Wyświetlenie wszystkich projektów wprowadzonych do tej pory.
    Raport z projektów: Wyświetlenie sumarycznego czasu poświęconego na poszczególne projekty i zadania.
    Pomoc: Wyświetlenie krótkiego opisu dostępnych komend.

3. Instalacja i konfiguracja

    Pobierz aplikację TimeTracker z repozytorium Task-Reporter firmy IT Solution.
    Rozpakuj pobrany plik do wybranego katalogu.
    Otwórz terminal i przejdź do katalogu z aplikacją.
    Uruchom aplikację.

4. Użycie aplikacji
   
*Komenda app start
Komenda app start służy do rozpoczęcia śledzenia czasu dla konkretnego zadania i projektu. Składnia komendy:

app start nazwaZadania nazwaProjektu

    nazwaZadania: Nazwa zadania, nad którym zaczynasz pracę.
    nazwaProjektu: Nazwa projektu, do którego należy zadanie.

Przykład: app start Raportowanie ProjektAlpha

Jeśli inne zadanie jest już uruchomione, zostanie ono automatycznie zatrzymane, a nowe zadanie zostanie dodane do pliku z aktualnym czasem rozpoczęcia.
________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________

*Komenda app stop
Komenda app stop służy do zakończenia śledzenia czasu dla aktualnie aktywnego zadania. Składnia komendy:

app stop

Przykład: app stop

Po wpisaniu tej komendy do pliku zostanie dodana godzina zakończenia pracy nad bieżącym zadaniem.
________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________

*Komenda app continue
Komenda app continue służy do wznowienia śledzenia czasu dla ostatniego zadania. Jeśli zostanie podana cyfra (maksymalnie 5), to wznawiane będzie odpowiednie zadanie z historii, w kolejności przeciwnej do chronologicznej. Składnia komendy:

app continue [numer]

    numer (opcjonalnie): Numer zadania do wznowienia, w kolejności przeciwnej do chronologicznej. W innym przypadku uruchomione tracker zostanie uruchomiony dla ostatniego zadania.

Przykład: app continue 1

W powyższym przykładzie, jeśli pracowano nad zadaniami 1, 2, 3, to zostanie wznowione zadanie 2.
________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________

*Komenda app current

Komenda app current wyświetla nazwę zadania i projektu, dla którego jest aktywne śledzenie czasu. Jeśli nie ma żadnego aktywnego śledzenia, pojawia się komunikat:

TimeTracker nie śledzi żadnego zadania.

Przykład: app current

________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________

Komenda app list

Komenda app list pokazuje pięć ostatnich aktywności. Wyświetla nazwy zadań, nazwy projektów oraz godziny rozpoczęcia i zakończenia pracy nad zadaniami.
Przykład:

bash

app list

Komenda app project

Komenda app project wyświetla wszystkie projekty, które zostały do tej pory wpisane do systemu.
Przykład:

bash

app project

Komenda app report

Komenda app report wyświetla raport z podziałem na projekty i zadania, pokazując sumaryczny czas poświęcony na każdy projekt i zadanie oraz łączny czas poświęcony na wszystkie zadania.
Przykład:

bash

app report

Komenda app -h

Komenda app -h wyświetla krótkie wyjaśnienie, co robi każda komenda. Jest to podpowiedź dla użytkownika.
Przykład:

bash

app -h

5. Przykłady użycia

    Rozpoczęcie nowego zadania:

    bash

app start Raportowanie ProjektAlpha

Zakończenie aktualnego zadania:

bash

app stop

Wznowienie ostatniego zadania:

bash

app continue

Wznowienie przedostatniego zadania:

bash

app continue 1

Wyświetlenie aktualnie śledzonego zadania:

bash

app current

Wyświetlenie pięciu ostatnich aktywności:

bash

app list

Wyświetlenie wszystkich projektów:

bash

app project

Wyświetlenie raportu z projektów:

bash

app report

Wyświetlenie pomocy:

bash

    app -h

6. Struktura plików danych

Dane są przechowywane w pliku tekstowym (np. time_log.txt) w następującym formacie:

nazwaZadania | nazwaProjektu | godzinaStartu | godzinaStopu

Przykład zawartości pliku:

yaml

Raportowanie | ProjektAlpha | 2024-06-08 09:00:00 | 2024-06-08 10:30:00
AnalizaDanych | ProjektBeta | 2024-06-08 11:00:00 | 2024-06-08 12:15:00

7. Wymagania systemowe

    System operacyjny: Windows, macOS, Linux
    Python w wersji 3.6 lub nowszej

8. Kontakt

W razie jakichkolwiek pytań lub problemów, prosimy o kontakt z działem wsparcia IT Solution:

    Email: support@itsolution.com
    Telefon: +48 123 456 789

IT Solution dziękuje za korzystanie z aplikacji TimeTracker!
