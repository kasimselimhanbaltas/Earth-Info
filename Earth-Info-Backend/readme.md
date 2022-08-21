# Earth Info Backend

## Restoring Database

This project uses PostgreSQL. This projcets data comes from 3 tables: country, state and city. You can use the csv files to create your own database or restore the prepared database:

You can do it with query but there is a practical way in pgAdmin 4, you can simply create a database and name it "CountryStateCity" or name anything you like and change the database url in application.properties file, after creating a database, right click at it and select restore, select the restore file and you are ready to go! 

Restore file path: ../Earth-Info-Backend/RestoreDB/Country-State-City-DBbackup

Swagger API documentation(works while running): http://localhost:8085/swagger-ui.html#/application-controller
