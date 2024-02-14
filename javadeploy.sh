#!/bin/bash

status=`ps -ef | grep telspiel | grep jar | awk '{print $2}'`

if [ -z "$status" ];
        then
        echo "Application is NOT running & we're starting now...";
        chmod 755 $WORKSPACE/target/telspiel-0.0.1-SNAPSHOT.jar;
        nohup java -jar $WORKSPACE/target/telspiel-0.0.1-SNAPSHOT.jar > output.log 2>&1 &
        echo "Done..";
        if [[ "$?" == 0 ]]; then echo "Application has been started successfully with PID :"; echo `ps -ef | grep telspiel | grep jar | awk '{print $2}'`;
        else echo "Application deployment failed"; exit 1; fi

else
        echo " ;
        kill -9 $status;
        if [[ "$?" == 0 ]]; then echo "Previous instance of the Application has been stopped successfully";
                else echo "Failed to stop previous instance of the Application"; exit 1;
        fi
        chmod 755 $WORKSPACE/telspiel-0.0.1-SNAPSHOT.jar;
        nohup java -jar $WORKSPACE/target/telspiel-0.0.1-SNAPSHOT.jar > output.log 2>&1 &
        echo "Done..";
        if [[ "$?" == 0 ]]; then echo "Application has been deployed successfully with PID :"; echo `ps -ef | grep telspiel | grep jar | awk '{print $2}'`;
        else echo "Application deployment failed"; exit 1; fi
fi

exit 0