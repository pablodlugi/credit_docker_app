# credit_docker_app
Aplikacja do zarządzania kredytami

## Uruchomienie
W celu uruchomienia aplikacji należy postępować zgodnie z poniższymi punktami:

- wygenerować paczki wszystkich aplikacji (.jar)
- umieścić wygenerowane paczki w odpowiednich folderach   
    (paczkę credit-0.0.1-SNAPSHOT.jar w folderze credit_docker  
     paczkę product-0.0.1-SNAPSHOT.jar w folderze product_docker  
     paczkę customer-0.0.1-SNAPSHOT.jar w folderze customer_docker)  
    jeżeli w wymienionych folderach znajdują się już paczki wtedy należy je nadpisać  
- następnie znajdując sie w głównym folderze aplikacji należy wywołać w termianlu komendy:  
```bash
      $ docker-compose build
      $ docker-compose up
```  
  Za pierwszym i za drugim razem pojawią się błędy spowodowane tym, że poszczególne aplikacje będą chciały połaczyć się z bazą danych, która uruchamia się dłużej.
  Po wpisaniu powyższych komend trzeci raz aplikacja zacznie działać.
- korzystając z Postmana można sprawdzić działanie aplikacji  
```bash
      POST http://localhost:8080/api/credits  
      GET http://localhost:8080/api/credits  
```      
      
  Przykładowy plik Json przekazywany jako @RequestBody przy generowaniu żądania POST:  
```json      
    {
        "customer": {
            "firstName": "testName",
            "surname": "testSurname",
            "pesel": "123456789",
            "creditNumber": null
        },
        "product": {
            "productName": "testProdukt",
            "productValue": 123456789,
            "creditNumber": null
        },
        "credit": {
            "creditName": "testCredit",
            "creditNumber": null
        }
    }
```
