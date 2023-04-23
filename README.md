# java-many-to-many-sample
This app demonstrates creating a many-to-many relationship using Java SpringBoot

This app uses the in-memory h2 database for portability. So that you can run it on any computer.

To access the h2 database and see what is going on:
- Run the app on local
- Visit http://localhost:8080/h2-console
- Look for this line in the run logs of your IDE `H2 console available at '/h2-console'. Database available at 'jdbc:h2:mem:many'`
- Then copy `jdbc:h2:mem:many` or the equivalent in your logs
- Go to the browser and paste it in the "JDBC URL:" input
- Click connect

This should allow you view the database so that you can see the tables that are created as well as the data being recorded

