# Frequency List
## Uruchomienie programu
Skrypt do uruchomienia aplikacji: _start.bat_
## Przykład wywołania usługi:
_curl -X GET localhost:8080/frequencyList -F file=@testInput.txt_

## Założenia
* Przyjęty i przetestowany maksymalny rozmiar pliku wsadowego to 1000MB. Możliwość rozszerzenia tego limitu za pomocą parametu w _src/main/resources/application.properties_
* Przyjęte kodowanie tekstu w pliku wejściowym: UTF-8
* Wyrażenia z apostrofem w innym miejscu niż na początku lub na końcu (can't, they're etc.) traktowane są jako jedno słowo 