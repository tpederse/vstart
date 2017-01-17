Dette er en testapp for Trond og bluemix:

Dette er det jeg vet som er hentet fra exempelappen:


## Running with Maven

This project can be build with [Apache Maven](http://maven.apache.org/). The project uses [Liberty Maven Plug-in][] to automatically download and install Liberty profile runtime from the [Liberty repository](https://developer.ibm.com/wasdev/downloads/). Liberty Maven Plug-in is also used to create, configure, and run the application on the Liberty server. 

Use the following steps to run the application with Maven:

1. Execute full Maven build. This will cause Liberty Maven Plug-in to download and install Liberty profile server.
    ```bash
    $ mvn clean install
    ```

2. To run a local Liberty server with the JavaHelloWorldApp sample execute:
    ```bash
    $ mvn liberty:run-server
    ```

    Once the server is running, the application will be available under [http://localhost:9080/JavaHelloWorldApp](http://localhost:9080/JavaHelloWorldApp).


3. To **push the application to Bluemix** using the cf command line tool:
    ```bash
    $ cf push <appname> -p target/JavaHelloWorldApp.war
    ```



Dette sto også der men er mindre relevant:
## Running the Application Locally in Eclipse with Liberty

1. Download and install [IBM Eclipse Tools for Bluemix](https://developer.ibm.com/wasdev/downloads/#asset/tools-IBM_Eclipse_Tools_for_Bluemix).
2. In the Servers view of Eclipse, right-click to create a new WAS Liberty server. Follow the steps in the wizard, which includes the option to download and install the WAS Liberty runtime.
3. Import this sample into Eclipse using *File -> Import -> Maven -> Existing Maven Projects* option.
4. Deploy the sample into Liberty server. Right click on the *JavaHelloWorldApp* sample and select *Run As -> Run on Server* option. Find and select the Liberty profile server and press *Finish*. 
5. Go to: [http://localhost:9080/JavaHelloWorldApp](http://localhost:9080/JavaHelloWorldApp)

## Running the Application in Bluemix using Eclipse

1. Download and install [IBM Eclipse Tools for Bluemix](https://developer.ibm.com/wasdev/downloads/#asset/tools-IBM_Eclipse_Tools_for_Bluemix).
2. In the Servers view of Eclipse, right-click to create a new IBM Bluemix server. Follow the steps in the wizard.
3. Import this sample into Eclipse using *File -> Import -> Maven -> Existing Maven Projects* option.
4. Deploy the sample into Bluemix server. Right click on the *JavaHelloWorldApp* sample and select *Run As -> Run on Server* option. Find and select the Bluemix server and press *Finish*. 