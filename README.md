# Intrdocution

This is a very very simple mapreduce application. You can run this application in command with following command.

    ./gradlew run    
    
This command will download all the jars to your local machine. No hadoop installation package is required, no setting is required, just issue the command and does work!!

The output would print this information

	The output goes to: out/20140520170354
	
Just use

	cat out/20140520170354/part-r-00000
	
To see the result. 	

# Eclipse Integration

Please follow the steps below

1. Issue this command to create the eclise project files 
	
	./gradlew eclipse
	
2. Open the eclipse. Select the "Import" > "Existing Projects into Workspace".
3. Run as application

# Run in hadoop cluster

I assume that your have knowledge to set up the hadoop standalone server or cluster. Please follow the steps below

1. Issue this command to create the executable jar
	
	./gradlew jar
	
2. Run in hadoop

	hadoop jar build/libs/wordcount.jar [path-to-input] [path-to-output]

Good luck and happy MapReduce!!!
	


