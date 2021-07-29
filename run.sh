#! /bin/bash

JAR='jar/Calc.jar'

if [ -f "$JAR" ]; then
	if [ "$#" -gt 0 ]; then
		REDIR="$1"
		echo "[INFO] using file $1 as input"
		echo "*****************************"
		cat $1
		echo "*****************************"
	else
		REDIR='/dev/tty'
		echo "[INFO] waiting for user input"
	fi

	# Trying to detect Cygwin on windows
	if [ -d '/cygdrive' ]; then
		CP_ARG='tools\beaver-rt.jar;jar\Calc.jar'
	else
		CP_ARG='tools/beaver-rt.jar:jar/Calc.jar'
	fi

	java -cp "$CP_ARG" prog.DeskCalc < $REDIR
else
	echo 'Please run ant before'
	exit 1
fi

