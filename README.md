Dokumentacja techniczna dla aplikacji TimeTracker


Spis treści

  Wprowadzenie
  Opis funkcjonalności
  Instalacja i konfiguracja
  Użycie aplikacji
   Komenda start
   Komenda stop
   Komenda continue
   Komenda current
   Komenda list
   Komenda last
   Komenda project
   Komenda report
   Komenda h
  Struktura plików danych
  Wymagania systemowe
  Kontakt

1. Wprowadzenie

Firma IT Solution stworzyła aplikację TimeTracker, która umożliwia użytkownikom śledzenie czasu spędzonego nad różnymi projektami. Aplikacja jest przeznaczona do użytku w terminalu i pozwala na łatwe zarządzanie czasem pracy nad zadaniami i projektami.


2. Opis funkcjonalności

Aplikacja TimeTracker posiada następujące funkcjonalności:

   Startowanie zadania: Rozpoczęcie śledzenia czasu dla danego zadania i projektu.
   Zatrzymywanie zadania: Zakończenie śledzenia czasu dla aktualnie aktywnego zadania.
   Wznawianie zadania: Wznowienie śledzenia czasu dla ostatniego zadania.
   Aktualne zadanie: Wyświetlenie informacji o aktualnie zadaniu.
   Lista aktywności: Wyświetlenie wszystkich aktywności.
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
________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________
   
  *Komenda start

   Komenda app start służy do rozpoczęcia śledzenia czasu dla konkretnego zadania i projektu.
   Jeśli inne zadanie jest już uruchomione, zostanie ono automatycznie zatrzymane, a nowe zadanie zostanie dodane do pliku z aktualnym czasem rozpoczęcia.
   
   Składnia komendy:

        start nazwaZadania nazwaProjektu

   nazwaZadania: Nazwa zadania, nad którym zaczynasz pracę.
   nazwaProjektu: Nazwa projektu, do którego należy zadanie.

   *Przykład użycia*

   Jest dzień 01.01.2000, godz. 10:00. Użytkownik wpisuje następującą komendę:
   start Raportowanie ProjektAlpha

W pliku xlsx zostaje utworzony nowy wiersz z nazwą zadania "Raportowanie", nazwą projektu "ProjektAlpa", godziną wykonania komendy start 10:00 i datą 01.01.2000. 

   Jest godz. 10:47. Użytkownik wpisuje kolejną komendę:
   start Korekta ProjektAlpha
   
W pliku xlsx zostaje utworzony nowy wiersz z nazwą zadania "Korekta", nazwą projektu "ProjektAlpa", godziną wykonania komendy start "10:47" i datą "01.01.2000" a do poprzedniego wiersza w pliku xlsx zostaje dopisana godzina zakończenia "10:47". 

________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________

   *Komenda stop
   
   Komenda stop służy do zakończenia śledzenia czasu dla aktualnie aktywnego zadania. 
   
   Składnia komendy:

      stop

   *Przykład użycia*

   Jest godzina 11:15. Użytkownik wpisuje następującą komendę:
   stop

W pliku xlsx zostaje dodana godzina zakończenia śledzenia czasu "11:15" dla wiersza z nazwą zadania "Korekta" i nazwą projektu "ProjektAlpa".
________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________

   *Komenda continue
   
   Komenda continue służy do wznowienia śledzenia czasu dla ostatniego zadania.
   
   Składnia komendy:

     continue 

   *Przykład użycia*

   Jest godzina 12:00. Użytkownik wpisuje komendę:
   continue

W pliku xlsx zostaje skopiowany z wcześniejszego wiersza nazwa zadania "Korekta" i nazwa projektu "ProjektAlpha" i dopisana zostaje godzina rozpoczęcia śledzenia czasu 12:00.
________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________

   *Komenda current

   Komenda current wyświetla nazwę zadania i projektu dla ostatniej aktywności.
    
   Składnia komendy:

    current

   *Przykład użycia*

   Użytkownik wpisuje komendę:
   current

Użytkownikowi wyświetla się w konsoli nazwa zadania "Korekta" i nazwa projektu "ProjektAlpha".
________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________

   *Komenda list 

   Komenda list pokazuje pięć ostatnich aktywności. Wyświetla nazwy zadań, nazwy projektów oraz godziny rozpoczęcia i zakończenia pracy nad zadaniami.

   Składnia komendy:

    list 

   *Przykład użycia*

   Użytkownik wpisuje komendę:
   list 

Użytkownikowi wyświetla się w konsoli lista złożona z jego zadań, składająca się z nazwy zadania, nazwy projektu, godziny rozpoczęcia i ewentualnej godziny zakończenia:

Korekta       ProjektAlpha   12:00  
Korekta       ProjektAlpha   10:47  11:15
Raportowanie  ProjektAlpha   10:00  10:47
________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________
 
   *Komenda last

   Komenda list pokazuje pięć ostatnich aktywności.

   Składnia komendy:

    last

   *Przykład użycia*

   Użytkownik wpisuje komendę:
   last 

Użytkownikowi wyświetla się w konsoli lista złożona z jego ostatnich 5 zadań, składająca się z nazwy zadania i nazwy projektu:
    
Korekta       ProjektAlpha 
Korekta       ProjektAlpha 
Raportowanie  ProjektAlpha 
________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________

   *Komenda project

   Komenda project wyświetla wszystkie projekty, które zostały do tej pory wpisane do systemu.

   Składnia komendy:

    project
   
   *Przykład użycia*

   Użytkownik wpisuje komendę:
   project 

Użytkownikowi wyświetla się w konsoli lista projektów nad którymi pracował, w przypadku naszego przykładu będzie to:

ProjektAlpha
   
________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________

   *Komenda report

   Komenda report wyświetla raport z podziałem na projekty i zadania, pokazując sumaryczny czas poświęcony na każde zadanie i projekt oraz łączny czas poświęcony na wszystkie zadania.

   Składnia komendy:

    report -all /  report -p [nazwaProjektu] 

   Do komendy report jest możliwość nałożenia filtra, by raport wyświetlał wyniki tylko dla danego projektu.
   
   
   *Przykłady użycia*

Na potrzeby przykładu dodajmy, że uzytkownik pracował jeszcze nad następującymi zadaniami:
Wysyłanie       ProjektOmega   13:55  13:59
Raportowanie    ProjektOmega   12:55  13:55

a zadanie "Korekta" projektu "ProjektAlpha" zostało zakończone o 12:54.  

__________________________________________________________________________________________________
   Użytkownik wpisuje komendę:
   report -all

Użytkownikowi wyświetla się w konsoli lista wszystkich zadań i projektów, nad którymi pracował. Listy są posegregowane a czasy zliczone dla poszczególnych zadań, projektów i dla całości.

ProjektAlpha
    Raportowanie    47min
    Korekta         1h 22min
                    Total: 2h 9min

ProjektOmega
    Raportowanie    1h
    Wysyłanie       4min
                    Total: 1h 4min

__________________________________________________________________________________________________
   Użytkownik wpisuje komendę:
   report -p ProjektAlpha

Użytkownikowi wyświetla się w konsoli lista wszystkich zadań projektu ProjektAlpha:

ProjektAlpha
    Raportowanie    47min
    Korekta         1h 22min
                    Total: 2h 9min   
_______________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________

  *Komenda h

   Komenda h wyświetla użytkownikowi w konsoli krótkie podpowiedzi, co robi każda komenda. 
   
   Składnia komendy:
    h  

  *Przykład użycia*
  
   Użytkownik wpisuje komendę:
   h       

Użytkownikowi wyświetla się następująca podpowiedź w konsoli:

    Aplication use:\n" +
                        "    command 'start' - syntax: 'start -t=<task_name> -p=<project_name>' - starting of task reporting \n" +
                        "    command stop - syntax: 'stop' - without arguments, stopping current task \n" +
                        "    command 'continue' - syntax 'continue' - without arguments, continuation of last task\n" +
                        "    command 'current' - syntax 'current' - without arguments, showing of current task\n" +
                        "    command 'list'\n" +
                        "    command 'last' - syntax 'last' - without arguments, showing last 5 tasks\n" +
                        "    command 'project'\n" +
                        "    command 'report' - syntax 'report -all' - report for all projects\n" +
                        "    command 'report' - syntax 'report -all --project=<project_name>' - report for chosen project\n" +
                        "    command 'h' - displaying help");
    

________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________


5. Struktura plików danych

   Dane są przechowywane w pliku xlsx (np. file.xlsx) w następującym formacie:

   index | nazwaProjektu | nazwaZadania | czasRozpoczęcia | czasZakończenia | czasTrwania

  Przykład zawartości pliku:
  patrz file.xlsx w repozytorium.


6. Wymagania systemowe

   System operacyjny: Windows, macOS, Linux
   JAVA w wersji 17 lub nowszej

7. Kontakt

W razie jakichkolwiek pytań lub problemów, prosimy o kontakt z działem wsparcia IT Solution:

   Email: support@itsolution.com
   Telefon: +48 123 456 789
   Pn-Pt w godzinach 8-20

IT Solution dziękuje za korzystanie z aplikacji TimeTracker!
